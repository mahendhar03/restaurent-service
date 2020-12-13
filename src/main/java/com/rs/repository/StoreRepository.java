package com.rs.repository;

import org.springframework.data.repository.CrudRepository;

import com.rs.model.entity.StoreEntity;

public interface StoreRepository extends CrudRepository<StoreEntity, String> {
	public StoreEntity findByStoreName(String storeName);
}
