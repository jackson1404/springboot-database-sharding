/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.service;

import com.jackson.spring_db_shard.config.ShardContext;
import com.jackson.spring_db_shard.config.ShardResolver;
import com.jackson.spring_db_shard.entity.CustomerEntity;
import com.jackson.spring_db_shard.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerService Class.
 * <p>
 * </p>
 *
 * @author
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShardResolver shardResolver;

    @Transactional
    public CustomerEntity createCustomer(CustomerEntity customer){

         String shardKey = shardResolver.resolveShard(customer.getCustomerId());

         try {
             ShardContext.setCurrentShard(shardKey);
             return customerRepository.save(customer);
         } finally {
             ShardContext.clear();
         }

    }

}
