/**
 * 
 */
package com.myt.services;

import java.util.List;

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
public interface AdminService {
	
	public Integer createRM(RegionalManager regionalManager);
	
	public Integer createAM(AreaManager areaManager);
	
	public Integer createTSI(TSI tsi);
	
	public Integer createDealer(Dealer dealer);

	public List<AreaManager> getAreaManagerByRegionalManager(Integer rm_id);

	public List<AreaManager> getRegionalManagerByCompanyAdmin(
			Integer company_admin_id);

	public List<TSI> getTSIByAM(Integer am_id);
	
	public List<Dealer> getDealersByTSI(Integer tsi_id);

	public Dealer getDealerById(Integer dealer_id);

	public Integer getCompanyIdByAdmin(Integer company_admin_id);

	public String getCompanyNameById(Integer company_id);

	public User getUserById(Integer user_id);

	public Integer changePasswordByType(User user, String type);

	public CompanyAdmin getCompanyAdminById(Integer companyAdminId);

	public Integer updateUserProfilePic(String type, Integer type_id,
			String file_url);

	public RegionalManager getRMById(Integer rm_id);

	public AreaManager getAMById(Integer am_id);

	public TSI getTSIById(Integer tsi_id);

	public Integer addWarehouseBill(Warehouse warehouseBills);

	public List<Dealer> getDealerListByCA(Integer company_admin_id);

	public List<Company> getCompanyListByDealer(Integer dealerId);

	public Integer getTSIByDealer(Integer company_id, Integer dealer_id);

	public String getCompanyNameByCompanyAdmin(Integer company_admin_id);

	public String getRMArea(Integer company_admin_id, Integer dealer_id);

	public String getAMArea(Integer company_admin_id, Integer dealer_id);

	public String getTSIArea(Integer company_admin_id, Integer dealer_id);

	public String getDealerName(Integer dealer_id);

	public Warehouse getWarehouseBillsById(Integer bill_id);

	public Integer updateWarehouseBills(String type, Integer bill_id,
			String file_url);

	public List<String> getWarehouseBills(String type, Integer companyId,
			Integer dealerId);
}
