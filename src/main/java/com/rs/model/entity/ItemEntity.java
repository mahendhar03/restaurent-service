package com.rs.model.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITEM")
public class ItemEntity {
	@Id
	private String itemCode;
	private String itemName;
	private String catagory;
	private String decription;
	private BigDecimal quantity;
	private String quantityType;
	private BigDecimal unitPrice;
	private String tags;
}
