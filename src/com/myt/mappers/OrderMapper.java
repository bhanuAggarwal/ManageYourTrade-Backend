package com.myt.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myt.domains.DealerOrder;

public interface OrderMapper {

	@Insert("INSERT INTO dealer_order (order_list, dealer_id, tsi_id, warehouse_id, status, date_of_order) "
			+ "VALUES (#{order_list} , #{dealer_id} , #{tsi_id} , #{warehouse_id} , 'new', now())")
	Integer placeOrderByDealer(DealerOrder dealerOrder);

	@Update("UPDATE dealer_order SET order_list = #{order_list} , status = 'Updated' WHERE id = #{id}")
	Integer updateOrderByTSI(DealerOrder dealerOrder);

	@Select("SELECT * FROM dealer_order WHERE dealer_id = #{user_id}")
	List<DealerOrder> getOrderListByDealer(Integer user_id);

	@Select("SELECT * FROM dealer_order WHERE tsi_id = #{user_id}")
	List<DealerOrder> getOrderListByTSI(Integer user_id);

}
