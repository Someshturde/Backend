package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDeatils")
public class User 
{
	@Id
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String address;
	@Column(nullable=false)
	private int contact;
	@Column(nullable=false)
	private String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", contact=" + contact + ", role=" + role + "]";
	}
	
	
	
	
	
}
