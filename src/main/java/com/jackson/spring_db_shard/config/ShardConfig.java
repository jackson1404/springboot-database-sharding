/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * ShardConfig Class.
 * <p>
 * </p>
 *
 * @author
 */
@Configuration
@ConfigurationProperties(prefix = "spring.sharding")
public class ShardConfig {

    private List<ShardProperty> shards;
    private String shardKey;

    @Data
    public static class ShardProperty{

        private String id;
        private String url;
        private String username;
        private String password;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public List<ShardProperty> getShards() {
        return shards;
    }

    public void setShards(List<ShardProperty> shards) {
        this.shards = shards;
    }

    public String getShardKey() {
        return shardKey;
    }

    public void setShardKey(String shardKey) {
        this.shardKey = shardKey;
    }
}
