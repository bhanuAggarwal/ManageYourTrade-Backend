package com.myt.domains;

import java.sql.Timestamp;

/**
 * 
 * @author bhanu
 *
 */
public class DealerOrder {
	Integer id;
	String order_list;
	Integer dealer_id;
	String dealer_name;
	Integer tsi_id;
	Integer company_id;
	String status;
	Timestamp date_of_order;
	
	public DealerOrder() {
		super();
	}

	public DealerOrder(Integer id, String order_list, Integer dealer_id,
			Integer tsi_id, Integer company_id, String status, Timestamp date_of_order,String dealer_name) {
		super();
		this.id = id;
		this.order_list = order_list;
		this.dealer_id = dealer_id;
		this.tsi_id = tsi_id;
		this.company_id = company_id;
		this.status = status;
		this.date_of_order = date_of_order;
		this.dealer_name = dealer_name;
	}


	@Override
	public String toString() {
		return "DealerOrder [id=" + id + ", order_list=" + order_list
				+ ", dealer_id=" + dealer_id + ", tsi_id=" + tsi_id
				+ ", company_id=" + company_id + ", status=" + status
				+ ", date_of_order=" + date_of_order + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrder_list() {
		return order_list;
	}

	public void setOrder_list(String order_list) {
		this.order_list = order_list;
	}

	public Integer getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(Integer dealer_id) {
		this.dealer_id = dealer_id;
	}

	public Integer getTsi_id() {
		return tsi_id;
	}

	public void setTsi_id(Integer tsi_id) {
		this.tsi_id = tsi_id;
	}

	public Integer getCompany_id() {
		return company_id;
	}
	

	public String getDealer_name() {
		return dealer_name;
	}

	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(Timestamp date_of_order) {
		this.date_of_order = date_of_order;
	}
	
}
