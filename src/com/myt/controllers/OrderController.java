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
import org.springframework.web.bind.annotation.ResponseBody;

import com.myt.domains.DealerOrder;
import com.myt.domains.Message;
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
	
	Logger LOG = Logger.getLogger("OrderController");
	/**
	 * Place Order By Dealer
	 * @param dealerOrder
	 * @return
	 */
	@RequestMapping(value = "/place/dealer" , method = RequestMethod.POST)
	@ResponseBody
	public Message placeOrderByDealer(@RequestBody DealerOrder dealerOrder){
		Message result = new Message();
		String message =  new String();
		Integer flag = 0;
		if(dealerOrder != null){
			try{
				flag = orderService.placeOrderByDealer(dealerOrder);
				if(flag > 0){
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
		result.setId(flag);
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
	public List<DealerOrder> getOrderListByType(@PathVariable Integer user_id, @PathVariable String type){
		List<DealerOrder> orderList = new ArrayList<DealerOrder>();
		if(user_id != null && type != null){
			try{
				orderList = orderService.getOrderListByType(user_id, type);
				if(orderList != null){
					LOG.info("Listed Retrieved Successfully " + orderList);
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
	
	/**
	 * Update Order By TSI
	 * @param dealerOrder
	 * @return
	 */
	@RequestMapping(value = "/update/tsi" , method = RequestMethod.PUT)
	@ResponseBody
	public Message updateOrderByTSI(@RequestBody DealerOrder dealerOrder){
		Message result = new Message();
		String message = new String();
		Integer flag = 0;
		if(dealerOrder != null){
			try{
				flag = orderService.updateOrderByTSI(dealerOrder);
				if(flag > 0){
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
			message = "Some Param Missing";
		}
		LOG.info(message);
		result.setId(flag); 
		result.setMessage(message);
		return result;
	}
}
