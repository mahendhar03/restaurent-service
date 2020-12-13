package com.rs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.model.Catageroy;
import com.rs.model.Item;
import com.rs.model.Store;
import com.rs.model.Quantity;
import com.rs.model.Quantity.QuantityType;
import com.rs.model.entity.ItemEntity;
import com.rs.model.entity.StoreEntity;
import com.rs.repository.StoreRepository;

@Service
public class StoreInfoService {
	@Autowired
	private StoreRepository storeRepository;

	public String saveStore(Store store) {
		StoreEntity storeEntity = new StoreEntity();
		storeEntity.setStoreName(store.getStoreName());
		storeEntity.setStoreId(store.getStoreId());
		storeEntity.setRating(store.getRating());
		storeEntity.setOwner(store.getOwner());
		storeEntity.setLicenceCode(store.getLicenceCode());

		List<ItemEntity> itemEntityList = new ArrayList<>();
		store.getItems().forEach(item -> {
			ItemEntity itemEntity = new ItemEntity();
			itemEntity.setCatagory(item.getCatagory().name());
			itemEntity.setDecription(item.getDecription());
			itemEntity.setItemCode(item.getItemCode());
			itemEntity.setItemName(item.getItemName());
			itemEntity.setQuantity(item.getQuantity().getAvailableQuantity());
			itemEntity.setQuantityType(item.getQuantity().getQuantityType().name());
			itemEntity.setTags(item.getTags());
			itemEntity.setUnitPrice(item.getUnitPrice());
			itemEntityList.add(itemEntity);
		});
		storeEntity.setItems(itemEntityList);
		return storeRepository.save(storeEntity).getStoreName();
	}

	public Store getStore(String storeName) {
		StoreEntity storeEntity = storeRepository.findByStoreName(storeName);

		Store store = new Store();
		store.setStoreName(storeEntity.getStoreName());
		store.setStoreId(storeEntity.getStoreId());
		store.setRating(storeEntity.getRating());
		store.setOwner(storeEntity.getOwner());
		store.setLicenceCode(storeEntity.getLicenceCode());

		List<Item> itemList = new ArrayList<>();
		storeEntity.getItems().forEach(itemEntity -> {
			Item item = new Item();
			item.setCatagory(Catageroy.valueOf(itemEntity.getCatagory()));
			item.setDecription(itemEntity.getDecription());
			item.setItemCode(itemEntity.getItemCode());
			item.setItemName(itemEntity.getItemName());
			Quantity quantity = new Quantity();
			quantity.setAvailableQuantity(itemEntity.getQuantity());
			quantity.setQuantityType(QuantityType.valueOf(itemEntity.getQuantityType()));
			item.setQuantity(quantity);
			item.setTags(itemEntity.getTags());
			item.setUnitPrice(itemEntity.getUnitPrice());
			itemList.add(item);
		});
		store.setItems(itemList);
		return store;
	}
}
