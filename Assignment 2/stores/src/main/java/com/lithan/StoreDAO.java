package com.lithan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StoreDAO {
	List<Store> storeList = new ArrayList<Store>();
	
//	this method will add the data to storeList
	public Store addStore (Store store) {
		storeList.add(store);
		return store;
	}
	
//	this method will return the data back to the service
	public List<Store> getAllStore(){
		return storeList;
	}
}
