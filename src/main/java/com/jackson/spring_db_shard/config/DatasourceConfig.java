/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * DatasourceConfig Class.
 * <p>
 * </p>
 *
 * @author
 */

@Configuration
public class DatasourceConfig {

    @Autowired
    private ShardConfig shardConfig;

    @Bean
    public DataSource dataSource() {
        ShardDataSourceRouter routingDataSource = new ShardDataSourceRouter();

        Map<Object, Object> dataSources = new HashMap<>();
        shardConfig.getShards().forEach(shard -> {
            DataSource ds = createDataSource(
                    shard.getUrl(),
                    shard.getUsername(),
                    shard.getPassword()
            );
            dataSources.put(shard.getId(), ds);
        });

        routingDataSource.setTargetDataSources(dataSources);
        routingDataSource.setDefaultTargetDataSource(dataSources.get(shardConfig.getShards().get(0).getId()));
        return routingDataSource;
    }

    private DataSource createDataSource(String url, String username, String password) {
        // Using HikariCP as the connection pool
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }

}
