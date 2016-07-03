package com.myt.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myt.domains.DealerOrder;

public interface OrderMapper {

	@Insert("INSERT INTO dealer_order (order_list, dealer_id, tsi_id, company_id, status, date_of_order) "
			+ "VALUES (#{order_list} , #{dealer_id} ,#{tsi_id}, #{company_id} , 'new', now())")
	Integer placeOrderByDealer(DealerOrder dealerOrder);

	@Update("UPDATE dealer_order SET order_list = #{order_list} , status = #{status} WHERE id = #{id}")
	Integer updateOrderByTSI(DealerOrder dealerOrder);

	@Select("SELECT * FROM dealer_order WHERE dealer_id = #{user_id} AND company_id = #{company_id} ORDER BY id DESC")
	List<DealerOrder> getOrderListByDealer(@Param("user_id") Integer user_id, @Param("company_id") Integer company_id);

	@Select("SELECT * FROM dealer_order WHERE tsi_id = #{user_id} ORDER BY id DESC")
	List<DealerOrder> getOrderListByTSI(Integer user_id);

	@Select("SELECT id FROM dealer_order WHERE dealer_id = #{dealer_id} ORDER BY id DESC LIMIT 1")
	Integer getLastPlacedOrder(Integer dealer_id);

	@Select("SELECT do.*, d.name AS \"dealer_name\" FROM dealer_order do JOIN dealer d ON  d.id = do.dealer_id "
			+ "WHERE do.company_id = #{company_id} AND do.status = 'ACCEPTED'")
	List<DealerOrder> getOrderListByWarehouse(Integer company_id);

}
