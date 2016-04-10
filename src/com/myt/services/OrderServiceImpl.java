/**
 * 
 */
package com.myt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myt.domains.DealerOrder;
import com.myt.mappers.OrderMapper;

/**
 * @author bhanu
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;
	
	Logger LOG = Logger.getLogger("OrderServices");
	
	@Override
	public Integer placeOrderByDealer(DealerOrder dealerOrder) {
		Integer flag = 0;
		if(dealerOrder != null){
			try{
				flag = orderMapper.placeOrderByDealer(dealerOrder);
			}catch(Exception e){
				LOG.info("Error while Placing order in Services " + e);
			}
		} 
		else{
			LOG.info("Some Param Missing");
		}
		return flag;
	}

	
	@Override
	public List<DealerOrder> getOrderListByType(Integer user_id, String type) {
		List<DealerOrder> orderList = new ArrayList<DealerOrder>();
		if(user_id != null && type != null){
			try{
				if(type.equals("dealer")){
					orderList = orderMapper.getOrderListByDealer(user_id);
				}
				else{
					orderList = orderMapper.getOrderListByTSI(user_id);
				}
				if(orderList != null){
					LOG.info("List Retrieved");
				}
				else{
					LOG.info("List can't be Retrieved");
				}
			}catch(Exception e){
				LOG.info("Error while Retrieving Order List " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return orderList;
	}


	@Override
	public Integer updateOrderByTSI(DealerOrder dealerOrder) {
		Integer flag = 0;
		if(dealerOrder != null){
			try{
				flag = orderMapper.updateOrderByTSI(dealerOrder);
			}catch(Exception e){
				LOG.info("Error while updating Order in Services " + e);
			}
		} else{
			LOG.info("Some Param Missing");
		}
		return flag;
	}
	
	
}
