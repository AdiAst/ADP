package com.lithan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.lithan.entity.WebUser;

@Entity
@Table(name = "web_role")
public class WebRoles {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "role_id")
	  private int id;

	  @Column(name = "role_name")
	  private String role;

	  @ManyToMany(mappedBy = "roles")
	  private List<WebUser> users = new ArrayList<>();

	  public WebRoles() {
	  }

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getRole() {
	    return role;
	  }

	  public void setRole(String role) {
	    this.role = role;
	  }

	  public List<WebUser> getUsers() {
	    return users;
	  }

	  public void setUsers(List<WebUser> users) {
	    this.users = users;
	  }

}
