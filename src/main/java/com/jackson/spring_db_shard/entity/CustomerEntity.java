/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.spring_db_shard.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

/**
 * CustomerEntity Class.
 * <p>
 * </p>
 *
 * @author
 */

@Entity
@Table(name = "tbl_customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

}
