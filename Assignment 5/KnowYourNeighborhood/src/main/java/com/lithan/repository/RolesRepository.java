package com.lithan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.entity.WebRoles;



@Repository
public interface RolesRepository extends JpaRepository<WebRoles, Integer> {
  public WebRoles findByRole(String role);
}