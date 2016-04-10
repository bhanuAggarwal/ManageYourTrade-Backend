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
	Integer tsi_id;
	Integer warehouse_id;
	String status;
	Timestamp date_of_order;
	
	public DealerOrder() {
		super();
	}

	public DealerOrder(Integer id, String order_list, Integer dealer_id,
			Integer tsi_id, Integer warehouse_id, String status, Timestamp date_of_order) {
		super();
		this.id = id;
		this.order_list = order_list;
		this.dealer_id = dealer_id;
		this.tsi_id = tsi_id;
		this.warehouse_id = warehouse_id;
		this.status = status;
		this.date_of_order = date_of_order;
	}


	@Override
	public String toString() {
		return "DealerOrder [id=" + id + ", order_list=" + order_list
				+ ", dealer_id=" + dealer_id + ", tsi_id=" + tsi_id
				+ ", warehouse_id=" + warehouse_id + ", status=" + status
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

	public Integer getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(Integer warehouse_id) {
		this.warehouse_id = warehouse_id;
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
