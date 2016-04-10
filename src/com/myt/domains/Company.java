package com.myt.domains;
/**
 * 
 * @author bhanu
 *
 */
public class Company {
	
	int id;
	String name;
	String address;
	String description;
	String tin;
	String pan;
	String bank_name;
	String bank_account;
	String bank_address;
	String bank_ifsc; 
	String reg_no;
	String logo_location;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Company(int id, String name, String address, String description,
			String tin, String pan, String bank_name, String bank_account,
			String bank_address, String bank_ifsc, String reg_no,
			String logo_location) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.tin = tin;
		this.pan = pan;
		this.bank_name = bank_name;
		this.bank_account = bank_account;
		this.bank_address = bank_address;
		this.bank_ifsc = bank_ifsc;
		this.reg_no = reg_no;
		this.logo_location = logo_location;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTin() {
		return tin;
	}
	public void setTin(String tin) {
		this.tin = tin;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getBank_ifsc() {
		return bank_ifsc;
	}
	public void setBank_ifsc(String bank_ifsc) {
		this.bank_ifsc = bank_ifsc;
	}
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getLogo_location() {
		return logo_location;
	}

	public void setLogo_location(String logo_location) {
		this.logo_location = logo_location;
	}

}
