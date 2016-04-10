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
import com.myt.domains.CompanyAdmin;
import com.myt.domains.Dealer;
import com.myt.domains.RegionalManager;
import com.myt.domains.TSI;
import com.myt.domains.User;

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
	
	@Select("SELECT * FROM area_manager WHERE boss_id =  #{rm_id}")
	public List<AreaManager> getAreaManagerByRegionalManager(Integer rm_id);

	@Select("SELECT * FROM regional_manager WHERE boss_id = #{company_admin_id}")
	public List<AreaManager> getRegionalManagerByCompanyAdmin(
			Integer company_admin_id);

	@Select("SELECT * FROM tsi WHERE boss_id = #{am_id}")
	public List<TSI> getTSIByAM(Integer am_id);
	

	@Select("SELECT * FROM dealer WHERE boss_id = #{tsi_id}")
	public List<Dealer> getDealersByTSI(Integer tsi_id);

	@Select("SELECT id FROM regional_manager ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedRMId();
	
	@Select("SELECT id FROM area_manager ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedAMId();
	
	@Select("SELECT id FROM tsi ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedTSIId();
	
	@Select("SELECT id FROM dealer ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedDealerId();

	@Select("SELECT * FROM dealer WHERE id = #{dealer_id}")
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

	@Select("SELECT ca.*, c.name AS \"company.name\" FROM company_admin AS ca JOIN company c ON ca.company_id = c.id WHERE ca.id = #{companyAdminId}")
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

	@Select("SELECT rm.* , c.name AS \" company.name \" FROM regional_manager rm JOIN company_admin ca ON "
			+ " rm.company_admin_id = ca.id JOIN company c ON ca.company_id = c.id WHERE rm.id = #{rm_id}")
	public RegionalManager getRMById(Integer rm_id);
	
	@Select("SELECT am.*, c.name AS \"company.name\" FROM area_manager am JOIN company_admin ca ON am.company_admin_id = ca.id "
			+ " JOIN company c ON ca.company_id = c.id WHERE am.id = #{am_id}")
	public AreaManager getAMById(Integer am_id);

}