package com.myt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myt.domains.Company;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.Message;
import com.myt.services.SuperAdminService;


/**
 * @author bhanu
 *
 */

@Controller
@RequestMapping("/super-admin")
@SessionAttributes("company_id")
public class SuperAdminController {
	
	@Autowired
	SuperAdminService superAdminService;
	
	Logger LOG = Logger.getLogger("SuperAdminController");
	
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/company",method = RequestMethod.POST)
	@ResponseBody
	public Message createCompany(@RequestBody Company company) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (company != null) {
			try {
				id = superAdminService.createCompany(company);
				if (id > 0) {
					result = "Company has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "Company was not added";
			} catch (Exception e) {
				LOG.info("Fault in companyService" + e);
			}
		} else {
			result = "Company value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/company-admin/company/{company_id}",method = RequestMethod.POST)
	@ResponseBody
	public Message createCompanyAdmin(@RequestBody CompanyAdmin companyAdmin, @PathVariable Integer company_id) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (companyAdmin != null) {
			try {
				Company company = new Company();
				company.setId(company_id);
				companyAdmin.setCompany(company);
				id = superAdminService.createCompanyAdmin(companyAdmin);
				if (id > 0) {
					result = "Company has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "Company was not added";
			} catch (Exception e) {
				LOG.info("Fault in companyService" + e);
			}
		} else {
			result = "Company value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	@RequestMapping(value = "/company-admin", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyAdmin> getCompanyAdminList(){
		List<CompanyAdmin> listCompanyAdmin = new ArrayList<CompanyAdmin>();
		try{
			listCompanyAdmin = superAdminService.getCompanyAdminList();
		}catch(Exception e){
			LOG.info("Error in Super Admin Controller " + e);
		}
		return listCompanyAdmin;
	}

}
