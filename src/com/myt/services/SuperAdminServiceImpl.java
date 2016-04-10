package com.myt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myt.domains.Company;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.User;
import com.myt.mappers.SuperAdminMapper;
/**
 * 
 * @author bhanu
 *
 */
@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	
	@Autowired
	SuperAdminMapper superAdminMapper;
	
	Logger LOG = Logger.getLogger("SuperAdminService");

	@Override
	public Integer createCompany(Company company) {
		int i=0,id = 0;
		if(company != null){
			try{
				i = superAdminMapper.createCompany(company);
				if(i > 0){
					LOG.info("Company Created");
					id = superAdminMapper.getLastAddedCompanyId();
					if(id > 0){
						LOG.info("Company Id Retrived Successfully");
					}
					else{
						LOG.info("Company Id Not Found");
					}
				}
				else{
					LOG.info("Company Not Created");
					id = 0;
				}
			} catch(Exception e){
			    LOG.info("Fault in superAdminMapper" + e);
			}
	    } else {
			LOG.info("company data is null");
		}
		return id;
	}

	@Override
	public Integer createCompanyAdmin(CompanyAdmin companyAdmin) {
		int i=0, id = 0;
		User user = null;
		if(companyAdmin != null){
			try{
				i = superAdminMapper.createCompanyAdmin(companyAdmin);
				if(i > 0){
					LOG.info("Company-Admin Created");
					id = superAdminMapper.getLastAddedCompanyAdminId(companyAdmin.getCompany().getId());
					user = new User();
					user.setEmail(companyAdmin.getEmail());
					user.setPhone_no(companyAdmin.getPhone_no());
					user.setType("CA");
					user.setPassword(companyAdmin.getPassword());
					user.setName(companyAdmin.getUsername());
					user.setReference_id(id);
					addCommonUser(user);
				}
				else{
					LOG.info("Company-Admin Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in superAdminMapper" + e);
			}
	    } else {
			LOG.info("company-admin data is null");
		}
		return id;
	}

	@Override
	public Integer addCommonUser(User user) {
		int i=0;
		if(user != null){
			try{
				i = superAdminMapper.createUser(user);
				if(i > 0){
					LOG.info("User Created");
				}
				else{
					LOG.info("User Not Created");
				}
			} catch(Exception e){
			    LOG.info("Fault in superAdminMapper" + e);
			}
	    } else {
			LOG.info("company data is null");
		}
		return i;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		if(email != null){
			try{
				user = superAdminMapper.getUserByEmail(email);
				if(user != null){
					LOG.info("User Retrived Successfully");
				}
				else{
					LOG.info("Error while retriving user");
				}
			} catch(Exception e){
			    LOG.info("Fault in superAdminMapper" + e);
			}
	    } else {
			LOG.info("user email is null");
		}
		return user;
	}

	@Override
	public List<CompanyAdmin> getCompanyAdminList() {
		List<CompanyAdmin> listCompanyAdmin = new ArrayList<CompanyAdmin>();
		try{
			listCompanyAdmin = superAdminMapper.getCompanyAdminList();
			if(listCompanyAdmin != null){
				LOG.info("List Fetched Successfully");
			}
			else{
				LOG.info("List Not Fetched");
			}
		}catch(Exception e){
			LOG.info("Error in Super Admin Service " + e);
		}
		return listCompanyAdmin;
	}
	
	
}
