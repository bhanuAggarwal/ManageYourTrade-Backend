/**
 * 
 */
package com.myt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myt.domains.AreaManager;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.Dealer;
import com.myt.domains.RegionalManager;
import com.myt.domains.TSI;
import com.myt.domains.User;
import com.myt.domains.Warehouse;
import com.myt.mappers.AdminMapper;

/**
 * @author bhanu
 *
 */
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	SuperAdminService superAdminService;
	
	Logger LOG = Logger.getLogger("AdminMapper");


	@Override
	public Integer createRM(RegionalManager regionalManager) {
		int i=0,id = 0;
		User user = null;
		if(regionalManager != null){
			try{
				i = adminMapper.createRM(regionalManager);
				if(i > 0){
					LOG.info("RM Created");
					id = adminMapper.getLastAddedRMId();
					if(id > 0){
						user = new User();
						user.setEmail(regionalManager.getEmail());
						user.setName(regionalManager.getName());
						user.setPhone_no(regionalManager.getPhone_no());
						user.setType("RM");
						user.setPassword(regionalManager.getPassword());
						user.setReference_id(id);
						user.setName(regionalManager.getName());
						superAdminService.addCommonUser(user);
					}
					else{
						LOG.info("Can't Fetch RM id");
					}
				}
				else{
					LOG.info("RM Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in adminMapper" + e);
			}
	    } else {
			LOG.info("RM data is null");
		}
		return id;
	}

	@Override
	public Integer createAM(AreaManager areaManager) {
		int i=0,id=0;
		User user = null;
		if(areaManager != null){
			try{
				i = adminMapper.createAM(areaManager);
				if(i > 0){
					LOG.info("AM Created");
					id = adminMapper.getLastAddedAMId();
					if(id > 0){
						user = new User();
						user.setEmail(areaManager.getEmail());
						user.setName(areaManager.getName());
						user.setPhone_no(areaManager.getPhone_no());
						user.setType("AM");
						user.setPassword(areaManager.getPassword());
						user.setReference_id(id);
						user.setName(areaManager.getName());
						superAdminService.addCommonUser(user);
					}
					else{
						LOG.info("Can't Fetch AM id");
					}
				}
				else{
					LOG.info("AM Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in adminMapper" + e);
			}
	    } else {
			LOG.info("AM data is null");
		}
		return id;
	}

	@Override
	public Integer createTSI(TSI tsi) {
		int i=0,id = 0;
		User user = null;
		if(tsi != null){
			try{
				i = adminMapper.createTSI(tsi);
				if(i > 0){
					LOG.info("TSI Created");
					id = adminMapper.getLastAddedTSIId();
					if(id > 0){
						user = new User();
						user.setEmail(tsi.getEmail());
						user.setName(tsi.getName());
						user.setPhone_no(tsi.getPhone_no());
						user.setType("TSI");
						user.setPassword(tsi.getPassword());
						user.setReference_id(id);
						user.setName(tsi.getName());
						superAdminService.addCommonUser(user);
					}
					else{
						LOG.info("Can't Fetch TSI id");
					}
				}
				else{
					LOG.info("TSI Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in adminMapper" + e);
			}
	    } else {
			LOG.info("TSI data is null");
		}
		return id;
	}

	@Override
	public Integer createDealer(Dealer dealer) {
		int i=0,id = 0;
		User user = null;
		if(dealer != null){
			try{
				i = adminMapper.createDealer(dealer);
				if(i > 0){
					LOG.info("Dealer Created");
					id = adminMapper.getLastAddedDealerId();
					if(id > 0){
						user = new User();
						user.setEmail(dealer.getEmail());
						user.setName(dealer.getName());
						user.setPhone_no(dealer.getPhone_no());
						user.setType("DEALER");
						user.setPassword(dealer.getPassword());
						user.setReference_id(id);
						user.setName(dealer.getName());
						superAdminService.addCommonUser(user);
					}
					else{
						LOG.info("Can't Fetch Dealer id");
					}
				}
				else{
					LOG.info("dealer Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in adminMapper" + e);
			}
	    } else {
			LOG.info("Dealer data is null");
		}
		return id;
	}

	@Override
	public List<AreaManager> getAreaManagerByRegionalManager(Integer rm_id) {
		List<AreaManager> listAreaManager = new ArrayList<AreaManager>();
		if(rm_id != null){
			try{
				listAreaManager = adminMapper.getAreaManagerByRegionalManager(rm_id);
			}catch(Exception e){
				LOG.info("Error in Admin Services " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return listAreaManager;
	}

	@Override
	public List<AreaManager> getRegionalManagerByCompanyAdmin(Integer company_admin_id){
			List<AreaManager> listAreaManager = new ArrayList<AreaManager>();
			if(company_admin_id != null){
				try{
					listAreaManager = adminMapper.getRegionalManagerByCompanyAdmin(company_admin_id);
				}catch(Exception e){
					LOG.info("Error in Admin Services " + e);
				}
			}
			else{
				LOG.info("Some Param Missing");
			}
			return listAreaManager;
	}

	@Override
	public List<TSI> getTSIByAM(Integer am_id) {
		List<TSI> listTSI = new ArrayList<TSI>();
		if(am_id != null){
			try{
				listTSI = adminMapper.getTSIByAM(am_id);
			}catch(Exception e){
				LOG.info("Error in Admin Services " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return listTSI;
	}
	
	@Override
	public List<Dealer> getDealersByTSI(Integer tsi_id) {
		List<Dealer> listDealer = new ArrayList<Dealer>();
		if(tsi_id != null){
			try{
				listDealer = adminMapper.getDealersByTSI(tsi_id);
			}catch(Exception e){
				LOG.info("Error in Admin Services " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return listDealer;
	}

	@Override
	public Dealer getDealerById(Integer dealer_id) {
		Dealer dealer =  new Dealer();
		if(dealer_id != null){
			try{
				dealer = adminMapper.getDealerById(dealer_id);
			}catch(Exception e){
				LOG.info("Error in Admin Service " + e);
			}
		}
		else{
			LOG.info("Dealer Id is NUll");
		}
		return dealer;
	}

	@Override
	public Integer getCompanyIdByAdmin(Integer company_admin_id) {
		Integer company_id = 0;
		if(company_admin_id != null){
			try{
				company_id = adminMapper.getCompanyIdByAdmin(company_admin_id);
				if(company_id != null){
					LOG.info("Company Id fetched Successfully");
				}
				else{
					LOG.info("Company Id Can't be Fetched");
				}
			}catch(Exception e){
				LOG.info("Error in while retriving company id " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return company_id;
	}

	@Override
	public String getCompanyNameById(Integer company_id) {
		String company_name = null;
		if(company_id != null){
			try{
				company_name = adminMapper.getCompanyNameById(company_id);
				if(company_name != null){
					LOG.info("Company Name Fetched Successfully");
				}
				else{
					LOG.info("Company Name Not Fetched");
				}
			}catch(Exception e){
				LOG.info("Error while fetching company name " + e);
			}
		}
		else{
			LOG.info("Company Id is Null");
		}
		return company_name;
	}

	@Override
	public User getUserById(Integer user_id) {
		User user = new User();
		if(user_id != null){
			try{
				user = adminMapper.getUserById(user_id);
			}catch(Exception e){
				LOG.info("Error with fetching User Info " + e);
			}
		}
		else{
			LOG.info("User Id is NUll");
		}
		return user;
	}

	@Override
	public Integer changePasswordByType(User user, String type) {
		Integer flag = 0;
		if(user != null && type != null){
			switch(type){
				case "CA":
					flag = adminMapper.changeCAPassword(user);
				break;
				case "RM":
					flag = adminMapper.changeRMPassword(user);
					break;
				case "AM":
					flag = adminMapper.changeAMPassword(user);
					break;
				case "TSI":
					flag = adminMapper.changeTSIPassword(user);
					break;
				case "DEALER":
					flag = adminMapper.changeDealerPassword(user);
					break;
			}
		} else{
			LOG.info("Some Param Missing");
		}
		return flag;
	}

	@Override
	public CompanyAdmin getCompanyAdminById(Integer companyAdminId) {
		CompanyAdmin companyAdmin = new CompanyAdmin();
		if(companyAdminId != null){
			try{
				companyAdmin = adminMapper.getCompanyAdminById(companyAdminId);
				if(companyAdmin != null){
					LOG.info("Company Admin Fetched Succesfully");
				}
				else{
					LOG.info("Company Admin can't be fetched");
				}
			}catch(Exception e){
				LOG.info("Error while fetching company Admin " + e);
			}
		}else{
			LOG.info("Param Missing ");
		}
		return companyAdmin;
	}

	@Override
	public Integer updateUserProfilePic(String type, Integer type_id,
			String file_url) {
		Integer flag = 0;
		if(type != null && type_id != null && file_url != null){
			switch(type){
				case "CA":
					flag = adminMapper.updateCAProfilePic(type_id, file_url);
					break;
				case "RM":
					flag = adminMapper.updateRMProfilePic(type_id, file_url);
					break;
				case "AM":
					flag = adminMapper.updateAMProfilePic(type_id, file_url);
					break;
				case "TSI":
					flag = adminMapper.updateTSIProfilePic(type_id, file_url);
					break;
				case "DEALER":
					flag = adminMapper.updateDEALERProfilePic(type_id, file_url);
					break;
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return flag;
	}

	@Override
	public RegionalManager getRMById(Integer rm_id) {
		RegionalManager regionalManager = new  RegionalManager();
		if(rm_id  != null){
			regionalManager = adminMapper.getRMById(rm_id);
		}
		else{
			LOG.info("Param Missing");
		}
		return regionalManager;
	}

	@Override
	public AreaManager getAMById(Integer am_id) {
		AreaManager areaManager = new AreaManager();
		if(am_id != null){
			try{
				areaManager = adminMapper.getAMById(am_id);
			}catch(Exception e){
				LOG.info("Error While Fetching AM Info " + e);
			}
		}
		else{
			LOG.info("AM Id is Missing");
		}
		return areaManager;
	}

	@Override
	public TSI getTSIById(Integer tsi_id) {
		TSI tsi = new TSI();
		if(tsi_id != null){
			try{
				tsi = adminMapper.getTSIById(tsi_id);
			}catch(Exception e){
				LOG.info("Error while fetching TSI Details " + e);
			}
		}
		else{
			LOG.info("TSI id id null");
		}
		return tsi;
	}

	@Override
	public Integer addWarehouseBill(Warehouse warehouseBills) {
		Integer flag = 0,id= 0;
		if(warehouseBills != null){
			try{
				flag = adminMapper.addWarehouseBills(warehouseBills);
				if(flag > 0){
					id = adminMapper.getLastAddedBillId(warehouseBills.getCompany_admin_id());
				}
				else{
					LOG.info("Bill Not Updated");
				}
			}catch(Exception e){
				LOG.info("Error While Adding Warehouse Bills " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return id;
	}

	@Override
	public List<Dealer> getDealerListByCA(Integer company_admin_id) {
		List<Dealer> dealerList = new ArrayList<Dealer>();
		if(company_admin_id != null){
			try{
				dealerList = adminMapper.getDealerListByCA(company_admin_id);
			}catch(Exception e){
				LOG.info("Error While Fetching Dealer List " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return dealerList;
	}
	
}