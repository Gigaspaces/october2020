import com.j_spaces.jdbc.driver.GConnection;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunQuery {
    private final static String REF_TABLE_NAME = "barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES";
    private final static String PARTITIONED_TABLE_NAME = "bpipe_rt.REAL_TIME_FUTURES";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.j_spaces.jdbc.driver.GDriver");
        GigaSpace gigaSpace = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo").lookupGroups("xap-15.5.1")).create();

        try (Connection connection = GConnection.getInstance(gigaSpace.getSpace())) {
            try (Statement stmt = connection.createStatement()) {
                String query ="SELECT Replace(ticker, ' ELEC ', ' ') AS TICKER, \n" +
                        "               crncy                       AS CRNCY, \n" +
                        "               data_received_timestamp     AS DATA_RECEIVED_TIMESTAMP \n" +
                        "        FROM   bpipe_rt.real_time_futures";
                ResultSet rs = stmt.executeQuery(query.toUpperCase().replace("BARRA.", "barra.").replace("BPIPE_RT.", "bpipe_rt.").replace(" ELEC ", " elec "));
                while (rs.next()){
                    int i = rs.getRow();
                    System.out.println(rs.getRow());
                }
            }
        }
    }
    /*
    SELECT *
FROM   (SELECT Replace(x.ticker, ' ELEC ', ' ') AS TICKER,
               Max(crncy)                       AS CRNCY,
               Max(data_received_timestamp)     AS DATA_RECEIVED_TIMESTAMP
        FROM   bpipe_rt.real_time_futures AS x
               INNER JOIN (SELECT ticker,
                                  Max(data_received_timestamp) AS MAX_TIMESTAMP
                           FROM   bpipe_rt.real_time_futures
                           WHERE  crncy IS NOT NULL
                           GROUP  BY ticker) AS y
                       ON x.data_received_timestamp = max_timestamp
                          AND x.ticker = y.ticker
        GROUP  BY x.ticker) RT
       LEFT JOIN (SELECT x.fx_rate,
                         x.currency_code,
                         x.ddate AS FX_DATE
                  FROM   barra.barra_fx_rates_with_minor_currencies AS x
                         INNER JOIN
                         (SELECT currency_code,
                                 Max(ddate) AS DDATE
                          FROM   barra.barra_fx_rates_with_minor_currencies
                          GROUP  BY currency_code) y
                                 ON x.currency_code = y.currency_code
                                    AND x.ddate = y.ddate) FX
              ON RT.crncy = FX.currency_code
                 AND crncy IS NOT NULL
ORDER  BY data_received_timestamp;
     */
}
