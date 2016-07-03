/**
 * 
 */
package com.myt.domains;


/**
 * @author bhanu
 *
 */
public class Dealer {

	Integer id;
	String name;
	String password;
	String email;
	String phone_no;
	String address;
	String tin;
	String pan;
	Integer boss_id;
	Double latitude;
	Double longitude;
	String bank_name;
	String bank_account;
	String bank_address;
	String bank_ifsc; 
	String reg_no;
	String profile_pic;
	Integer am_id;
	Integer rm_id;
	Integer company_admin_id;
	Company company;
	Double dealerAmount;

	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dealer(Integer id, String name, String password, String email,
			String phone_no, String address, String tin, String pan,
			Integer boss_id, Double latitude, Double longitude,
			String bank_name, String bank_account, String bank_address,
			String bank_ifsc, String reg_no, String profile_pic, Integer am_id,
			Integer rm_id, Integer company_admin_id, Company company,Double dealerAmount) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone_no = phone_no;
		this.address = address;
		this.tin = tin;
		this.pan = pan;
		this.boss_id = boss_id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bank_name = bank_name;
		this.bank_account = bank_account;
		this.bank_address = bank_address;
		this.bank_ifsc = bank_ifsc;
		this.reg_no = reg_no;
		this.profile_pic = profile_pic;
		this.am_id = am_id;
		this.rm_id = rm_id;
		this.company_admin_id = company_admin_id;
		this.company = company;
		this.dealerAmount = dealerAmount;
	}

	

	public Double getDealerAmount() {
		return dealerAmount;
	}

	public void setDealerAmount(Double dealerAmount) {
		this.dealerAmount = dealerAmount;
	}

	@Override
	public String toString() {
		return "Dealer [id=" + id + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", phone_no=" + phone_no + ", address="
				+ address + ", tin=" + tin + ", pan=" + pan + ", boss_id="
				+ boss_id + ", latitude=" + latitude + ", longitude="
				+ longitude + ", bank_name=" + bank_name + ", bank_account="
				+ bank_account + ", bank_address=" + bank_address
				+ ", bank_ifsc=" + bank_ifsc + ", reg_no=" + reg_no
				+ ", profile_pic=" + profile_pic + ", am_id=" + am_id
				+ ", rm_id=" + rm_id + ", company_admin_id=" + company_admin_id
				+ ", company=" + company + ", dealerAmount=" + dealerAmount
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Integer getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(Integer boss_id) {
		this.boss_id = boss_id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public Integer getAm_id() {
		return am_id;
	}

	public void setAm_id(Integer am_id) {
		this.am_id = am_id;
	}

	public Integer getRm_id() {
		return rm_id;
	}

	public void setRm_id(Integer rm_id) {
		this.rm_id = rm_id;
	}

	public Integer getCompany_admin_id() {
		return company_admin_id;
	}

	public void setCompany_admin_id(Integer company_admin_id) {
		this.company_admin_id = company_admin_id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
