package com.myt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myt.domains.DealerOrder;
import com.myt.domains.Message;
import com.myt.services.AdminService;
import com.myt.services.OrderService;


/**
 * 
 * @author bhanu
 *
 */

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	AdminService adminService;
	Logger LOG = Logger.getLogger("OrderController");
	/**
	 * Place Order By Dealer
	 * @param dealerOrder
	 * @return
	 */
	@RequestMapping(value = "/place" , method = RequestMethod.POST)
	@ResponseBody
	public Message placeOrderByDealer(@RequestBody DealerOrder dealerOrder){
		Message result = new Message();
		String message =  new String();
		Integer orderId = 0;
		Integer tsi_id;
		if(dealerOrder != null){
			try{
				tsi_id = adminService.getTSIByDealer(dealerOrder.getCompany_id(),dealerOrder.getDealer_id());
				dealerOrder.setTsi_id(tsi_id);
				orderId = orderService.placeOrderByDealer(dealerOrder);
				if(orderId > 0){
					message = "Order Places Successfully";
				}
				else{
					message = "Order Can't be  Placed";
				}
			}catch(Exception e){
				message = "Error While Placing Order By Dealer " + e;
			}
		}
		else{
			message = "Some Param Missing";
		}
		LOG.info(message);
		result.setId(orderId);
		result.setMessage(message);
		return result;
	}
	
	/**
	 * Get Order List Made By Dealer
	 * @param user_id
	 * @return
	 */
	@RequestMapping(value = "/list/{type}/{user_id}" , method = RequestMethod.GET)
	@ResponseBody
	public List<DealerOrder> getOrderListByType(@PathVariable Integer user_id, @PathVariable String type,
			@RequestParam(required = false, value = "company_id") Integer company_id){
		List<DealerOrder> orderList = new ArrayList<DealerOrder>();
		if(company_id == null)
			company_id = 0;
		if(user_id != null && type != null && company_id != null){
			try{
				orderList = orderService.getOrderListByType(user_id, type, company_id);
				if(orderList != null){
					LOG.info("Listed Retrieved Successfully ");
				}
				else{
					LOG.info("List Not Retrieved");
				}
			}catch(Exception e){
				LOG.info("Error while retrieving order list " + e);
			}
		} 
		else{
			LOG.info("Some Param Missing");
		}
		return orderList;
	}
	
	@RequestMapping(value = "/list/warehouse" , method = RequestMethod.GET)
	@ResponseBody
	public List<DealerOrder> getOrderListByWarehouse(@RequestParam("company_id") Integer company_id){
		List<DealerOrder> orderList = new ArrayList<DealerOrder>();
		if(company_id != null){
			try{
				orderList = orderService.getOrderListByWarehouse(company_id);
				if(orderList != null){
					LOG.info("Order List Fetched Successfully");
				}
				else{
					LOG.info("Order List not fetched");
				}
			}catch(Exception e){
				LOG.info("Exception : " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return orderList;
	}
	/**
	 * Update Order By TSI
	 * @param dealerOrder
	 * @return
	 */
	@RequestMapping(value = "/update" , method = RequestMethod.PUT)
	@ResponseBody
	public DealerOrder updateOrderByTSI(@RequestBody DealerOrder dealerOrder){
		DealerOrder orderResponse = new DealerOrder();
		String message = new String();
		Integer flag = 0;
		if(dealerOrder != null){
			if(dealerOrder.getStatus().equals("ACCEPTED") || dealerOrder.getStatus().equals("REJECTED")){
				try{
					flag = orderService.updateOrderByTSI(dealerOrder);
					if(flag > 0){
						orderResponse = dealerOrder;
						message = "Order Updated Successfully";
					}
					else{
						message = "Order Not Updated";
					}
				}catch(Exception e){
					message = "Error while updating Order " + e;
				}
			}
			else{
				LOG.info("Invalid Status");
			}
		}
		else{
			message = "Some Param Missing";
		}
		LOG.info(message);
		return orderResponse;
	}
}
