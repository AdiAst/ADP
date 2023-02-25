package com.lithan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.entity.Stores;

@Repository
public interface StoresRepository extends JpaRepository<Stores, Integer>{
	@Query(value = "SELECT * FROM store WHERE name LIKE '%' :keyword '%'", nativeQuery = true)
	  public List<Stores> search(@Param("keyword") String keyword);
}
