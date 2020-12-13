package com.rs.model.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "LOCATION")
public class StoreEntity {
	@Id
	private BigInteger storeId;
	private String storeName;
	private String licenceCode;
	private String owner;
	private double rating;
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "storeId")
	private List<ItemEntity> items;
}
