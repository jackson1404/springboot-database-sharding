/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.config;

/**
 * ShardContext Class.
 * <p>
 * </p>
 *
 * @author
 */

public class ShardContext {

    private static final ThreadLocal<String> currentShard = new ThreadLocal<>();

    public static String getCurrentShard(){
        return currentShard.get();
    }

    public static void setCurrentShard(String shardId){
        currentShard.set(shardId);
    }

    public static void clear(){
         currentShard.remove();
    }

}
