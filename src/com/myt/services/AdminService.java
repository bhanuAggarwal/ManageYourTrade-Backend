/**
 * 
 */
package com.myt.services;

import java.util.List;

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
}
