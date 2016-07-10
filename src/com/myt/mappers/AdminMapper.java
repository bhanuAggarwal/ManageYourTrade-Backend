/**
 * 
 */
package com.myt.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myt.domains.AreaManager;
import com.myt.domains.Company;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.Dealer;
import com.myt.domains.RegionalManager;
import com.myt.domains.TSI;
import com.myt.domains.User;
import com.myt.domains.Warehouse;

/**
 * @author bhanu
 *
 */
public interface AdminMapper {
	
    @Insert("INSERT INTO regional_manager("
            + "  name, designation , area, boss_id, phone_no, email, password)"
            + " VALUES (#{name}, #{designation}, #{area}, #{boss_id}, #{phone_no}, #{email}, #{password})")
	public Integer createRM(RegionalManager regionalManager);
	
	@Insert("INSERT INTO area_manager("
            + "  name, designation , area, boss_id, phone_no, email, password, company_admin_id)"
            + " VALUES (#{name}, #{designation}, #{area}, #{boss_id}, #{phone_no}, #{email}, #{password}"
            + " , #{company_admin_id})")
	public Integer createAM(AreaManager areaManager);
	
	
	@Insert("INSERT INTO tsi("
            + "  name, designation , area, boss_id, phone_no, email, password, rm_id, company_admin_id)"
            + " VALUES (#{name}, #{designation}, #{area}, #{boss_id}, #{phone_no}, #{email}, #{password}"
            + ", #{rm_id}, #{company_admin_id})")
	public Integer createTSI(TSI tsi);
	
	@Insert("INSERT INTO dealer("
            + "  name, password , email, phone_no, address, tin, pan, bank_name, bank_account,"
			+ " bank_address, bank_ifsc, reg_no, boss_id, latitude, longitude, profile_pic , am_id,"
			+ " rm_id, company_admin_id)"
            + " VALUES (#{name}, #{password} , #{email} ,#{phone_no}, #{address}, #{tin}, #{pan},"
            + " #{bank_name}, #{bank_account}, #{bank_address} , #{bank_ifsc} , #{reg_no} , #{boss_id} , #{latitude} , "
            + " #{longitude} , #{profile_pic}, #{am_id} , #{rm_id} , #{company_admin_id})")
    public Integer createDealer(Dealer dealer);
	
	@Select("SELECT am.* FROM area_manager am "
			+ "WHERE am.boss_id =  #{rm_id} ORDER BY am.id DESC")
	public List<AreaManager> getAreaManagerByRegionalManager(Integer rm_id);

	@Select("SELECT rm.* FROM regional_manager rm "
			+ "WHERE rm.boss_id = #{company_admin_id} ORDER BY rm.id DESC")
	public List<AreaManager> getRegionalManagerByCompanyAdmin(
			Integer company_admin_id);

	@Select("SELECT tsi.* FROM tsi "
			+ " WHERE tsi.boss_id = #{am_id} ORDER BY tsi.id DESC")
	public List<TSI> getTSIByAM(Integer am_id);
	

	@Select("SELECT d.* FROM dealer d "
			+ "WHERE d.boss_id = #{tsi_id} ORDER BY d.id DESC")
	public List<Dealer> getDealersByTSI(Integer tsi_id);

	@Select("SELECT id FROM regional_manager ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedRMId();
	
	@Select("SELECT id FROM area_manager ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedAMId();
	
	@Select("SELECT id FROM tsi ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedTSIId();
	
	@Select("SELECT id FROM dealer ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedDealerId();

	@Select("SELECT d.*, c.name AS \"company.name\" FROM dealer d JOIN company_admin ca ON d.company_admin_id = ca.id "
			+ " JOIN company c ON c.id = ca.company_id WHERE d.id = #{dealer_id}")
	public Dealer getDealerById(Integer dealer_id);

	@Select("SELECT company_id FROM company_admin WHERE id = #{company_admin_id}")
	public Integer getCompanyIdByAdmin(Integer company_admin_id);

	@Select("SELECT name FROM company WHERE id = #{company_id}")
	public String getCompanyNameById(Integer company_id);

	@Select("SELECT * FROM users WHERE id = #{user_id} ")
	public User getUserById(Integer user_id);
	
	@Update("UPDATE company_admin ca JOIN users u ON ca.id = u.reference_id "
			+ " SET ca.password = #{password}, u.password = #{password}  WHERE u.id = #{id} ")
	public Integer changeCAPassword(User user);

	@Update("UPDATE regional_manager rm JOIN users u ON rm.id = u.reference_id "
			+ " SET rm.password = #{password}, u.password = #{password}  WHERE u.id = #{id} ")
	public Integer changeRMPassword(User user);

	@Update("UPDATE area_manager am JOIN users u ON am.id = u.reference_id "
			+ " SET am.password = #{password}, u.password = #{password}  WHERE u.id = #{id} ")
	public Integer changeAMPassword(User user);

	@Update("UPDATE tsi JOIN users u ON tsi.id = u.reference_id "
			+ " SET tsi.password = #{password}, u.password = #{password}  WHERE u.id = #{id} ")
	public Integer changeTSIPassword(User user);

	@Update("UPDATE dealer d JOIN users u ON d.id = u.reference_id "
			+ " SET d.password = #{password}, u.password = #{password}  WHERE u.id = #{id} ")
	public Integer changeDealerPassword(User user);

	@Select("SELECT ca.*, c.name AS \"company.name\", c.id AS \"company.id\""
			+ " FROM company_admin AS ca JOIN company c ON ca.company_id = c.id WHERE ca.id = #{companyAdminId}")
	public CompanyAdmin getCompanyAdminById(Integer companyAdminId);

	@Update("UPDATE company_admin SET profile_pic = #{file_url} WHERE id = #{type_id}")
	public Integer updateCAProfilePic(@Param("type_id") Integer type_id,@Param("file_url") String file_url);
	
	@Update("UPDATE regional_manager SET profile_pic = #{file_url} WHERE id = #{type_id}")
	public Integer updateRMProfilePic(@Param("type_id") Integer type_id,@Param("file_url") String file_url);

	@Update("UPDATE area_manager SET profile_pic = #{file_url} WHERE id = #{type_id}")
	public Integer updateAMProfilePic(@Param("type_id") Integer type_id,@Param("file_url") String file_url);

	@Update("UPDATE tsi SET profile_pic = #{file_url} WHERE id = #{type_id}")
	public Integer updateTSIProfilePic(@Param("type_id") Integer type_id,@Param("file_url") String file_url);

	@Update("UPDATE dealer SET profile_pic = #{file_url} WHERE id = #{type_id}")
	public Integer updateDEALERProfilePic(@Param("type_id") Integer type_id,@Param("file_url") String file_url);

	@Select("SELECT rm.* , c.name AS \"company.name\" FROM regional_manager rm JOIN company_admin ca ON "
			+ " rm.boss_id = ca.id JOIN company c ON ca.company_id = c.id WHERE rm.id = #{rm_id}")
	public RegionalManager getRMById(Integer rm_id);
	
	@Select("SELECT am.*, c.name AS \"company.name\" FROM area_manager am JOIN company_admin ca ON am.company_admin_id = ca.id "
			+ " JOIN company c ON ca.company_id = c.id WHERE am.id = #{am_id}")
	public AreaManager getAMById(Integer am_id);

	@Select("SELECT tsi.* , c.name AS \"company.name\" FROM tsi JOIN company_admin ca ON tsi.company_admin_id = ca.id "
			+ " JOIN company c ON c.id = ca.company_id WHERE tsi.id = #{tsi_id}") 
	public TSI getTSIById(Integer tsi_id);

	@Insert("INSERT INTO warehouse_bill(company_admin_id, dealer_id, amount,company_id,creationTime) "
			+ "VALUES(#{company_admin_id} , #{dealer_id} , #{amount},#{company_id}, now()) ")
	public Integer addWarehouseBills(Warehouse warehouseBills);

	@Select("SELECT id FROM warehouse_bill WHERE company_admin_id = #{company_admin_id} ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedBillId(Integer company_admin_id);

	@Select("SELECT id, name FROM dealer WHERE company_admin_id = #{company_admin_id}")
	public List<Dealer> getDealerListByCA(Integer company_admin_id);

	@Update("Update company SET logo = #{file_url} WHERE id = #{type_id}")
	public Integer updateCompanyLogo(@Param("type_id") Integer type_id,@Param("file_url") String file_url);

	@Select("SELECT *, logo AS \"logo_location\" FROM company WHERE id IN (SELECT company_id FROM company_admin WHERE id IN "
			+ "(SELECT company_admin_id FROM dealer WHERE email IN (SELECT email FROM dealer WHERE id = #{dealerId})))")
	public List<Company> getCompanyListByDealer(Integer dealerId);

	@Select("SELECT id FROM tsi WHERE company_admin_id IN "
			+ "(SELECT id FROM company_admin WHERE company_id = #{company_id} AND id IN "
			+ "(SELECT company_admin_id FROM dealer WHERE id = #{dealer_id}))")
	public Integer getTSIByDealer(@Param("company_id") Integer company_id,@Param("dealer_id") Integer dealer_id);

	@Select("SELECT c.name FROM company c WHERE id IN "
			+ "(SELECT company_id FROM company_admin WHERE id = #{company_admin_id})")
	public String getCompanyNameByCompanyAdmin(Integer company_admin_id);

	@Select("SELECT area FROM regional_manager WHERE id IN "
			+ "(SELECT rm_id FROM dealer WHERE id = #{dealer_id} AND company_admin_id = #{company_admin_id})")
	public String getRMArea(@Param("company_admin_id") Integer company_admin_id,@Param("dealer_id") Integer dealer_id);
	

	@Select("SELECT area FROM area_manager WHERE id IN "
			+ "(SELECT am_id FROM dealer WHERE id = #{dealer_id} AND company_admin_id = #{company_admin_id})")
	public String getAMArea(@Param("company_admin_id") Integer company_admin_id,@Param("dealer_id") Integer dealer_id);
	

	@Select("SELECT area FROM tsi WHERE id IN "
			+ "(SELECT boss_id FROM dealer WHERE id = #{dealer_id} AND company_admin_id = #{company_admin_id})")
	public String getTSIArea(@Param("company_admin_id") Integer company_admin_id,@Param("dealer_id") Integer dealer_id);

	@Select("SELECT * FROM warehouse_bill WHERE company_admin_id = #{company_admin_id} ORDER BY id DESC LIMIT 1")
	public Warehouse getLastAddedBill(Integer company_admin_id);

	@Select("SELECT * FROM warehouse_bill WHERE id = #{bill_id}")
	public Warehouse getWarehouseBillById(Integer bill_id);

	@Update("UPDATE warehouse_bill SET ${type} = #{file_url} WHERE id = #{bill_id}")
	public Integer updateWarehouseBills(@Param("type") String type,@Param("bill_id") Integer bill_id,@Param("file_url")String file_url);

	@Select("SELECT ${type} FROM warehouse_bill WHERE company_id = #{companyId} AND dealer_id = #{dealerId} ORDER BY id DESC")
	public List<String> getWarehouseBill(@Param("type")String type,@Param("companyId") Integer companyId,
			@Param("dealerId")Integer dealerId);
}