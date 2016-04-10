package com.myt.domains;
/**
 * 
 * @author bhanu
 *
 */
public class User {
	
	int id;
	String email;
	String phone_no;
	String type;
	Integer reference_id;
	String password;
	String name;
	
	public User() {
		super();
	}
	


	public User(int id, String email, String phone_no, String type,
			Integer reference_id, String password, String name) {
		super();
		this.id = id;
		this.email = email;
		this.phone_no = phone_no;
		this.type = type;
		this.reference_id = reference_id;
		this.password = password;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getReference_id() {
		return reference_id;
	}

	public void setReference_id(Integer reference_id) {
		this.reference_id = reference_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
