//package com.mycompany.app;
//
//import org.openspaces.persistency.hibernate.DefaultHibernateSpaceDataSource;
//import org.openspaces.persistency.hibernate.DefaultHibernateSpaceDataSourceConfigurer;
//
//public class CustomSpaceDataSourceConfigurer extends DefaultHibernateSpaceDataSourceConfigurer{
//    @Override
//    public DefaultHibernateSpaceDataSource create() {
//        return new CustomSpaceDataSource(sessionFactory, managedEntries, fetchSize, performOrderById, initialLoadEntries, initialLoadThreadPoolSize, initialLoadChunkSize,
//                useScrollableResultSet, initialLoadQueryScanningBasePackages, augmentInitialLoadEntries, clusterInfo, limitResults);
//    }
//}
