package com.rs.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Quantity {
	private BigDecimal availableQuantity;
	private QuantityType quantityType;
	public enum QuantityType{
		GRAMS,LITERS,PIECES
	}
}
