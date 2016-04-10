/**
 * 
 */
package com.myt.domains;

/**
 * @author bhanu
 *
 */
public class RegionalManager {
		
	int id;
	String name;
	String designation;
	String area;
	Integer boss_id;
	String phone_no;
	String email;
	String password;
	String profile_pic;
	Company company;
	

	public RegionalManager(int id, String name, String designation,
			String area, Integer boss_id, String phone_no, String email,
			String password, String profile_pic, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.area = area;
		this.boss_id = boss_id;
		this.phone_no = phone_no;
		this.email = email;
		this.password = password;
		this.profile_pic = profile_pic;
		this.company = company;
	}
	
	
	@Override
	public String toString() {
		return "RegionalManager [id=" + id + ", name=" + name
				+ ", designation=" + designation + ", area=" + area
				+ ", boss_id=" + boss_id + ", phone_no=" + phone_no
				+ ", email=" + email + ", password=" + password
				+ ", profile_pic=" + profile_pic + ", company=" + company + "]";
	}


	public RegionalManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(Integer boss_id) {
		this.boss_id = boss_id;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
}
