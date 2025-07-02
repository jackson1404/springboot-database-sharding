/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ShardDataSourceRouter Class.
 * <p>
 * </p>
 *
 * @author
 */

public class ShardDataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ShardContext.getCurrentShard();
    }
}
