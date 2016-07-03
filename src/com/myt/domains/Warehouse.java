/**
 * 
 */
package com.myt.domains;

import java.sql.Timestamp;

/**
 * @author bhanu
 *
 */
public class Warehouse {
	Integer id;
	Integer company_admin_id;
	Integer dealer_id;
	Integer company_id;
	String dealer_name;
	String invoice;
	String collection;
	String cn;
	String dn;
	String payment;
	String account;
	String sale_report;
	Double amount;
	String dirPath;
	Timestamp creationTime;	
	
	
	public Warehouse() {
		super();
	}
	public Warehouse(Integer id, Integer company_admin_id, Integer dealer_id,
			String invoice, String collection, String cn, String dn,
			String payment, String account, String sale_report, Double amount,String dirPath,
			Timestamp creationTime, String dealer_name,Integer company_id) {
		super();
		this.id = id;
		this.company_admin_id = company_admin_id;
		this.dealer_id = dealer_id;
		this.invoice = invoice;
		this.collection = collection;
		this.cn = cn;
		this.dn = dn;
		this.payment = payment;
		this.account = account;
		this.sale_report = sale_report;
		this.amount = amount;
		this.creationTime = creationTime;
		this.dirPath = dirPath;
		this.dealer_name = dealer_name;
		this.company_id = company_id;
	}
	
	
	
	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", company_admin_id=" + company_admin_id
				+ ", dealer_id=" + dealer_id + ", company_id=" + company_id
				+ ", dealer_name=" + dealer_name + ", invoice=" + invoice
				+ ", collection=" + collection + ", cn=" + cn + ", dn=" + dn
				+ ", payment=" + payment + ", account=" + account
				+ ", sale_report=" + sale_report + ", amount=" + amount
				+ ", dirPath=" + dirPath + ", creationTime=" + creationTime
				+ "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getCompany_admin_id() {
		return company_admin_id;
	}
	public void setCompany_admin_id(Integer company_admin_id) {
		this.company_admin_id = company_admin_id;
	}
	public Integer getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(Integer dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getCollection() {
		return collection;
	}
	public void setCollection(String collection) {
		this.collection = collection;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSale_report() {
		return sale_report;
	}
	public void setSale_report(String sale_report) {
		this.sale_report = sale_report;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Timestamp getCreativeTime() {
		return creationTime;
	}
	public void setCreationTime(Timestamp creativeTime) {
		this.creationTime = creativeTime;
	}
	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
	public String getDealer_name() {
		return dealer_name;
	}
	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}
	public Timestamp getCreationTime() {
		return creationTime;
	}
	
}
