//package com.mycompany.app;
//
//import com.gigaspaces.datasource.DataIterator;
//import org.hibernate.SessionFactory;
//import org.openspaces.core.cluster.ClusterInfo;
//import org.openspaces.persistency.hibernate.DefaultHibernateSpaceDataSource;
//
//import java.util.Set;
//
//public class CustomSpaceDataSource extends DefaultHibernateSpaceDataSource {
//
//    public CustomSpaceDataSource(SessionFactory sessionFactory, Set<String> managedEntries, int fetchSize, boolean performOrderById, String[] initialLoadEntries, int initialLoadThreadPoolSize, int initialLoadChunkSize, boolean useScrollableResultSet, String[] initialLoadQueryScanningBasePackages, boolean augmentInitialLoadEntries, ClusterInfo clusterInfo, int limitResults) {
//        super(sessionFactory, managedEntries, fetchSize, performOrderById, initialLoadEntries, initialLoadThreadPoolSize, initialLoadChunkSize, useScrollableResultSet, initialLoadQueryScanningBasePackages, augmentInitialLoadEntries, clusterInfo, limitResults);
//    }
//
//    @Override
//    public DataIterator<Object> initialDataLoad() {
//        return new CustomDataIterator<>(super.initialDataLoad());
//    }
//
//    class CustomDataIterator<T> implements DataIterator<T> {
//        private final DataIterator<T> dataIterator;
//
//        public CustomDataIterator(DataIterator<T> dataIterator) {
//            this.dataIterator = dataIterator;
//        }
//
//        @Override
//        public void close() {
//
//        }
//
//        @Override
//        public boolean hasNext() {
//            return dataIterator.hasNext();
//        }
//
//        @Override
//        public T next() {
//            T t = dataIterator.next();
//            if(t instanceof RefTable) {
//                ((RefTable) t).setRouting(clusterInfo.getInstanceId() - 1);
//            }
//            return t;
//        }
//    }
//}
