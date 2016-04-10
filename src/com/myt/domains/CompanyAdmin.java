/**
 * 
 */
package com.myt.domains;

/**
 * @author bhanu
 *
 */
public class CompanyAdmin {
	
	int id;
	String username;
	String email;
    String phone_no;
    String password;
    Company company;
    int rm_no;
	int am_no;
	int tsi_no;
	int dealer_no;
	String profile_pic;
	
	public CompanyAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyAdmin(int id, String username, String email, String phone_no,
			String password, Company company, int rm_no, int am_no, int tsi_no,
			int dealer_no, String profile_pic) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone_no = phone_no;
		this.password = password;
		this.company = company;
		this.rm_no = rm_no;
		this.am_no = am_no;
		this.tsi_no = tsi_no;
		this.dealer_no = dealer_no;
		this.profile_pic = profile_pic;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRm_no() {
		return rm_no;
	}
	public void setRm_no(int rm_no) {
		this.rm_no = rm_no;
	}
	public int getAm_no() {
		return am_no;
	}
	public void setAm_no(int am_no) {
		this.am_no = am_no;
	}
	public int getTsi_no() {
		return tsi_no;
	}
	public void setTsi_no(int tsi_no) {
		this.tsi_no = tsi_no;
	}
	
	public int getDealer_no() {
		return dealer_no;
	}
	
	public void setDealer_no(int dealer_no) {
		this.dealer_no = dealer_no;
	}


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	
}	
