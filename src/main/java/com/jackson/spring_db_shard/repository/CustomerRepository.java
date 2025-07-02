/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.repository;

import com.jackson.spring_db_shard.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository Class.
 * <p>
 * </p>
 *
 * @author
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
