package com.zuodexin.po;

import com.zuodexin.po.itf.Refreshable;

// Generated 2016-6-2 9:57:42 by Hibernate Tools 4.0.0

/**
 * Admin generated by hbm2java
 */
public class Admin implements java.io.Serializable, Refreshable {

	private int id;
	private String username;
	private String password;

	public Admin() {
	}

	public Admin(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
