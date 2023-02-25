package com.lithan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "web_user")
public class WebUser {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "user_id")
	  private int idUser;
	  @Column(name = "u_name")
	  private String username;
	  @Column(name = "u_password")
	  private String password;

	  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private List<WebRoles> roles = new ArrayList<>();

	  public WebUser() {
	  }

	  public WebUser(String username, String password) {
	    this.username = username;
	    this.password = password;
	  }

	  public int getIdUser() {
	    return idUser;
	  }

	  public void setIdUser(int idUser) {
	    this.idUser = idUser;
	  }

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

	public List<WebRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<WebRoles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "WebUser [idUser=" + idUser + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ "]";
	}

}
