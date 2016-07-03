package com.myt.services;

import java.util.List;

import com.myt.domains.DealerOrder;

public interface OrderService {

	Integer placeOrderByDealer(DealerOrder dealerOrder);

	Integer updateOrderByTSI(DealerOrder dealerOrder);

	List<DealerOrder> getOrderListByType(Integer dealerId, String type,Integer company_id);

	List<DealerOrder> getOrderListByWarehouse(Integer company_id);

}
