package com.lithan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
	@Autowired
	private StoreDAO dao;
	
//	this method will send the data from controller to dao by using dao method
	public Store addStore(Store store) {
		return dao.addStore(store);
	}
	
//	this method will return the data to the controller
	public List<Store> getAllStore(){
		return dao.getAllStore();
	}
}
