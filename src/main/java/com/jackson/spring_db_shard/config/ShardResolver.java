/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ShardResolver Class.
 * <p>
 * </p>
 *
 * @author
 */
@Component
public class ShardResolver {

    @Autowired
    private ShardConfig shardConfig;

    public String resolveShard(Object shardKeyValue){
        if (shardKeyValue == null ) {
            return shardConfig.getShards().get(0).getId();
        }

        int hash = Math.abs(shardKeyValue.hashCode());
        int shardIndex = hash % shardConfig.getShards().size();
        return shardConfig.getShards().get(shardIndex).getId();

    }


}
