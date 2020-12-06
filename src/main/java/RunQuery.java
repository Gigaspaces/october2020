import com.j_spaces.jdbc.driver.GConnection;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunQuery {
    private final static String REF_TABLE_NAME = "com.gigaspaces.test.database.jdbc.poc_queries.generator.model.barra.BARRA_FX_RATES_WITH_MINOR_CURRENCIES";
    private final static String PARTITIONED_TABLE_NAME = "com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.REAL_TIME_FUTURES";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.j_spaces.jdbc.driver.GDriver");
        GigaSpace gigaSpace = new GigaSpaceConfigurer(new SpaceProxyConfigurer("demo").lookupGroups("xap-15.5.1")).create();

        try (Connection connection = GConnection.getInstance(gigaSpace.getSpace())) {
            try (Statement stmt = connection.createStatement()) {
                String query = Queries.QUERY_3;
                ResultSet rs = stmt.executeQuery(query.toUpperCase().replace("BARRA.", "com.gigaspaces.test.database.jdbc.poc_queries.generator.model.barra.").replace("BPIPE_RT.", "com.gigaspaces.test.database.jdbc.poc_queries.generator.model.bpipe_rt.").replace(" ELEC ", " elec "));
                while (rs.next()){
                    int i = rs.getRow();
                    System.out.println(rs.getRow());
                }
            }
        }
    }
}
