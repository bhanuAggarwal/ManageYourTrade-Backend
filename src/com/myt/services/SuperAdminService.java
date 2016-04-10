package com.myt.services;

import java.util.List;

import com.myt.domains.Company;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.User;
/**
 * 
 * @author bhanu
 *
 */
public interface SuperAdminService {
	
	public Integer createCompany(Company company);
	
	public Integer createCompanyAdmin(CompanyAdmin companyAdmin);
	
	public Integer addCommonUser(User user);
	
	public User getUserByEmail(String email);

	public List<CompanyAdmin> getCompanyAdminList();

}
