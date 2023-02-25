package com.lithan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.lithan.entity.Stores;
import com.lithan.exception.StoreNotFoundException;
import com.lithan.repository.StoresRepository;

@Service
public class StoreService{
	@Autowired
	private StoresRepository repo;
	
//	add or update existing data
	public void save(Stores store) {
		repo.save(store);
	}
//	return all data on database
	public List<Stores> getAllStore(){
		return repo.findAll();
	}
//	delete single data based on id
	public void delete(int id) {
		repo.deleteById(id);
	}
//	get single data based on id
	public Optional<Stores> getStore(int id){
		Optional<Stores> store = repo.findById(id);
		return store;
	}
	public List<Stores> search(String keyword) throws StoreNotFoundException {
		List<Stores> listStore = repo.search(keyword);

		return listStore;
	}

}
