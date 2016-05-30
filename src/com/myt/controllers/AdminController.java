/**
 * 
 */
package com.myt.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myt.domains.AreaManager;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.Dealer;
import com.myt.domains.Message;
import com.myt.domains.RegionalManager;
import com.myt.domains.TSI;
import com.myt.domains.User;
import com.myt.domains.Warehouse;
import com.myt.services.AdminService;
import com.myt.services.SuperAdminService;

/**
 * @author bhanu
 *
 */
@Controller
@SessionAttributes(value = {"company_id","company_admin_id","rm_id","am_id","tsi_id","dealer_id"})
@Scope("session")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	SuperAdminService superAdminService;
	
	Logger LOG = Logger.getLogger("AdminController");
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/rm",method = RequestMethod.POST)
	@ResponseBody
	public Message createRM(@RequestBody RegionalManager regionalManager, HttpServletRequest request) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (regionalManager != null && request.getSession().getAttribute("company_admin_id") != null) {
			try {
				regionalManager.setBoss_id((Integer)request.getSession().getAttribute("company_admin_id"));
				id = adminService.createRM(regionalManager);
				
				if (id > 0) {
					result = "RM has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "RM was not added";
			} catch (Exception e) {
				LOG.info("Fault in adminService" + e);
			}
		} else {
			result = "RM value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	@RequestMapping(value="/rm" , method = RequestMethod.GET)
	@ResponseBody
	public List<AreaManager> getRegionalManagerByCompanyAdmin(HttpServletRequest request) {
		List<AreaManager> listRegionalManager = new ArrayList<AreaManager>();
		Integer company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		if(company_admin_id != null){
			try{
				listRegionalManager = adminService.getRegionalManagerByCompanyAdmin(company_admin_id);
			}catch(Exception e){
				LOG.info("Error in Admin Controller " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return listRegionalManager;
	}

	@RequestMapping(value = "/rm/details" , method = RequestMethod.GET)
	@ResponseBody
	public RegionalManager getCurrentRM(HttpServletRequest request){
		RegionalManager regionalManager = new RegionalManager();
		Integer rm_id = 0;
		rm_id = (Integer)request.getSession().getAttribute("rm_id");
		if(rm_id > 0){
			try{
				regionalManager = adminService.getRMById(rm_id);
				if(regionalManager != null){
					LOG.info("Regional Manager Fetched Successfully ");
				}
				else{
					LOG.info("Regional Manager Can't Be Feteched");
				}
			}catch(Exception e){
				LOG.info("Error While Fetching RM Details " + e);
			}
		}
		return regionalManager;
	}
	@RequestMapping(value = "/session/{type}/{type_id}" , method = RequestMethod.GET)
	@ResponseBody
	public Message startRMSession(@PathVariable String type, @PathVariable Integer type_id,  HttpServletRequest request){
		Message result = new Message();
		Boolean flag = false;
		if(type_id != null && type != null){
			switch(type){
				case "RM":
					request.getSession().setAttribute("rm_id", type_id);
					flag = request.getSession().getAttribute("rm_id").equals(type_id);
					break;
				case "AM":
					request.getSession().setAttribute("am_id", type_id);
					flag = request.getSession().getAttribute("am_id").equals(type_id);
					break;
				case "TSI":
					request.getSession().setAttribute("tsi_id", type_id);
					flag = request.getSession().getAttribute("tsi_id").equals(type_id);
					break;
				case "DEALER":
					request.getSession().setAttribute("dealer_id", type_id);
					flag = request.getSession().getAttribute("dealer_id").equals(type_id);
					break;
				
			}
			
			if(flag){
				result.setId(1);
				LOG.info("Session is now Active");
			}
			else{
				result.setId(0);
				LOG.info("Session Can't Start");
			}
		}
		else{
			LOG.info("Id Is Missing");
		}
		return result;
	}
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/am",method = RequestMethod.POST)
	@ResponseBody
	public Message createAM(@RequestBody AreaManager areaManager, HttpServletRequest request) {
		Message message = new Message();
		String result = null;
		Integer rm_id = 0, company_admin_id = 0;
		rm_id = (Integer)request.getSession().getAttribute("rm_id");
		company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		int id = 0;
		if (areaManager != null && rm_id > 0 && company_admin_id > 0) {
			try {
				areaManager.setBoss_id((Integer)request.getSession().getAttribute("rm_id"));
				areaManager.setCompany_admin_id(company_admin_id);
				id = adminService.createAM(areaManager);
				if (id > 0) {
					result = "AM has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "AM was not added";
			} catch (Exception e) {
				LOG.info("Fault in adminService" + e);
			}
		} else {
			result = "AM value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	@RequestMapping(value="/am" , method = RequestMethod.GET)
	@ResponseBody
	public List<AreaManager> getAreaManagerByRegionalManager(HttpServletRequest request) {
		List<AreaManager> listAreaManager = new ArrayList<AreaManager>();
		Integer rm_id = (Integer)request.getSession().getAttribute("rm_id"); 
		if(rm_id != null){
			try{
				listAreaManager = adminService.getAreaManagerByRegionalManager(rm_id);
				if(listAreaManager != null){
					LOG.info("AM List Fetched Successfully");
				}
				else{
					LOG.info("AM List Not Fetched");
				}
			}catch(Exception e){
				LOG.info("Error in Admin Controller " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return listAreaManager;
	}
	
	@RequestMapping(value = "/am/details" , method = RequestMethod.GET)
	@ResponseBody
	public AreaManager getCurrentAM(HttpServletRequest request){
		AreaManager areaManager = new AreaManager();
		Integer am_id = 0;
		am_id = (Integer)request.getSession().getAttribute("am_id");
		if(am_id > 0){
			try{
				areaManager = adminService.getAMById(am_id);
				if(areaManager != null){
					LOG.info("Area Manager Fetched Successfully ");
				}
				else{
					LOG.info("Area Manager Can't Be Feteched");
				}
			}catch(Exception e){
				LOG.info("Error While Fetching AM Details " + e);
			}
		}
		return areaManager;
	}
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/tsi/add",method = RequestMethod.POST)
	@ResponseBody
	public Message createTSI(@RequestBody TSI tsi, HttpServletRequest request) {
		Message message = new Message();
		String result = null;
		Integer am_id = (Integer)request.getSession().getAttribute("am_id");
		Integer rm_id = (Integer)request.getSession().getAttribute("rm_id");
		Integer company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		int id = 0;
		if (tsi != null && am_id != null && rm_id != null && company_admin_id != null) {
			try {
				tsi.setBoss_id(am_id);
				tsi.setRm_id(rm_id);
				tsi.setCompany_admin_id(company_admin_id);
				id = adminService.createTSI(tsi);
				if (id > 0) {
					result = "TSI has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "TSI was not added";
			} catch (Exception e) {
				LOG.info("Fault in adminService" + e);
			}
		} else {
			result = "Company value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	@RequestMapping(value="/tsi" , method = RequestMethod.GET)
	@ResponseBody
	public List<TSI> getTSIByAM(HttpServletRequest request) {
		List<TSI> listTSI = new ArrayList<TSI>();
		Integer am_id = (Integer)request.getSession().getAttribute("am_id");
		if(am_id != null){
			try{
				request.getSession().setAttribute("am_id", am_id);
				listTSI = adminService.getTSIByAM(am_id);
			}catch(Exception e){
				LOG.info("Error in Admin Controller " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return listTSI;
	}
	
	@RequestMapping(value = "/tsi/details" , method = RequestMethod.GET)
	@ResponseBody
	public TSI getCurrentTSI(HttpServletRequest request){
		TSI tsi = new TSI();
		Integer tsi_id = (Integer)request.getSession().getAttribute("tsi_id");
		if(tsi_id != null){
			try{
				tsi = adminService.getTSIById(tsi_id);
				if(tsi != null){
					LOG.info("TSI Fetched Succesfully");
				}
				else{
					LOG.info("TSI Not Fetched");
				}
			}catch(Exception e){
				LOG.info("Error While fetching TSI Info " + e);
			}
		}
		else{
			LOG.info("TSI Id is not set");
		}
		return tsi;
	}
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/dealer/add",method = RequestMethod.POST)
	@ResponseBody
	public Message createDealer(@RequestBody Dealer dealer, HttpServletRequest request) {
		Message message = new Message();
		String result = null;
		Integer id = 0, tsi_id = 0, am_id = 0, rm_id = 0, company_admin_id = 0;
		tsi_id = (Integer)request.getSession().getAttribute("tsi_id");
		am_id = (Integer)request.getSession().getAttribute("am_id");
		rm_id = (Integer)request.getSession().getAttribute("rm_id");
		company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		if (dealer != null && tsi_id > 0 && am_id > 0 && rm_id > 0 && company_admin_id > 0) {
			try {
				dealer.setBoss_id((Integer)request.getSession().getAttribute("tsi_id"));
				dealer.setAm_id(am_id);
				dealer.setRm_id(rm_id);
				dealer.setCompany_admin_id(company_admin_id);
				id = adminService.createDealer(dealer);
				if (id > 0) {
					result = "Dealer has been added successfuly";
					LOG.info("The id created is" + id);
				} else
					result = "Dealer was not added";
			} catch (Exception e) {
				LOG.info("Fault in adminService" + e);
			}
		} else {
			result = "Dealer value is null";
			LOG.info(result);
		}
		message.setMessage(result);
		message.setId(id);
		return message;
	}
	
	@RequestMapping(value="/dealers" , method = RequestMethod.GET)
	@ResponseBody
	public List<Dealer> getDealersByTSI(HttpServletRequest request) {
		List<Dealer> listDealers = new ArrayList<Dealer>();
		Integer tsi_id = (Integer)request.getSession().getAttribute("tsi_id");
		if(tsi_id != null){
			try{
				request.getSession().setAttribute("tsi_id", tsi_id);
				listDealers = adminService.getDealersByTSI(tsi_id);
				if(listDealers != null){
					LOG.info("List Fetched Successfully");
				}
				else{
					LOG.info("List Not Fetched");
				}
			}catch(Exception e){
				LOG.info("Error in Admin Controller " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return listDealers;
	}
	
	@RequestMapping(value = "/dealer/{dealer_id}" , method = RequestMethod.GET)
	@ResponseBody
	public Dealer getDealerById(@PathVariable Integer dealer_id, HttpServletRequest request){
		Dealer dealer = new Dealer();
		if(dealer_id != null){
			try{
				dealer = adminService.getDealerById(dealer_id);
				if(dealer != null){
					LOG.info("Dealer Fetched Successfully");
				}
				else{
					LOG.info("Dealer Can't be fetched");
				}
			}catch(Exception e){
				LOG.info("Error With Admin Controller " + e);
			}
		}
		else{
			LOG.info("Dealer Id is NUll");
		}
		return dealer;
	}
	
	@RequestMapping(value = "/{type}/{type_id}/picture", method = RequestMethod.POST)
	@ResponseBody
	public Message upload(@PathVariable String type, 
			@PathVariable Integer type_id,MultipartHttpServletRequest request, HttpServletRequest sessionRequest) {
		Message result = new Message();
		String message = new String();
		Integer i = 0;
		byte[] bytes;
		String file_url = null;
    	String SAVE_DIR = null;
    	String savePath = null;
		BufferedImage image = null;
		if(type != null && type_id != null && request != null){
			try {
				Iterator<String> itr =  request.getFileNames();
				String appPath = "/usr/share/tomcat7/webapps";
				MultipartFile mpf = request.getFile(itr.next());
				SAVE_DIR = adminService.getCompanyNameById((Integer)sessionRequest.getSession().getAttribute("company_id"));
				bytes= mpf.getBytes();
				if(SAVE_DIR != null){
					savePath = appPath + File.separator + SAVE_DIR;
					File fileSaveDir = new File(savePath);
					InputStream inputStream = new ByteArrayInputStream(bytes);
					image = ImageIO.read(inputStream);
					if (!fileSaveDir.exists()) {
						fileSaveDir.mkdir();
					}
					ImageIO.write(image, "jpg", new File(fileSaveDir + File.separator + type + "_" + type_id + ".jpg"));
					file_url = "http://172.16.173.111:8080/" + SAVE_DIR + File.separator + type + "_" + type_id + ".jpg";
					if(image != null){
						i = adminService.updateUserProfilePic(type,type_id, file_url);
						if(i > 0){
							message = "Image Uploaded And Updated Successfully";
						}
						else{
							message = "Image not Updated";
						}
					}
					else{
						message = "Image Not Uploaded";
					}
				}
				else{
					message = "Company Name Not found";
				}
			} catch (Exception e) {
				message = "Error While Uploading Picture " + e;
			}
		}
		else{
			message = "Some Param Missing";
		}
		result.setId(i);
		result.setMessage(message);
		return result;
	}

	@RequestMapping(value = "/warehouse/bill" , method = RequestMethod.POST)
	@ResponseBody
	public Message addWarehouseBill(@RequestBody Warehouse warehouseBills , HttpServletRequest request){
		Message result = new Message();
		Integer company_admin_id = 0, id = 0;
		String message = new String();
		company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		if(warehouseBills != null && company_admin_id != null){
			try{
				warehouseBills.setCompany_admin_id(company_admin_id);
				id = adminService.addWarehouseBill(warehouseBills);
				if(id > 0){
					message = "Bills Added Successfully";
				}
				else{
					message = "Bill Not Added";
				}
			}catch(Exception e){
				LOG.info("Error While Adding Warehouse Bills " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		result.setId(id);
		result.setMessage(message);
		return result;
	}
	
	@RequestMapping(value="/warehouse/bill/{bill_id}/{type}" , method=RequestMethod.PUT)
	@ResponseBody
    public Message addWarehouseBillsImages(@PathVariable Integer bill_id , @PathVariable String type , 
    		MultipartHttpServletRequest request, HttpServletRequest sessionRequest) {
    	String file_url = new String();
    	Message result = new Message();
    	String message = new String();
    	Integer flag = 0;
		byte[] bytes;
    	String SAVE_DIR = null;
    	String savePath = null;
		BufferedImage image = null;
		if(type != null && bill_id != null && request != null){
			try {
				Iterator<String> itr =  request.getFileNames();
				String appPath = "/usr/share/tomcat7/webapps";
				MultipartFile mpf = request.getFile(itr.next());
				SAVE_DIR = adminService.getCompanyNameById((Integer)sessionRequest.getSession().getAttribute("company_id"));
				bytes= mpf.getBytes();
				if(SAVE_DIR != null){
					savePath = appPath + File.separator + SAVE_DIR;
					File fileSaveDir = new File(savePath);
					InputStream inputStream = new ByteArrayInputStream(bytes);
					image = ImageIO.read(inputStream);
					if (!fileSaveDir.exists()) {
						fileSaveDir.mkdir();
					}
					ImageIO.write(image, "jpg", new File(fileSaveDir + File.separator + type + "_" + bill_id + ".jpg"));
					file_url = "http://172.16.173.111:8080/" + SAVE_DIR + File.separator + type + "_" + bill_id + ".jpg";
					if(image != null){
						flag = adminService.updateUserProfilePic(type,bill_id, file_url);
						if(flag > 0){
							message = "Image Uploaded And Updated Successfully";
						}
						else{
							message = "Image not Updated";
						}
					}
					else{
						message = "Image Not Uploaded";
					}
				}
				else{
					message = "Company Name Not found";
				}
			} catch (Exception e) {
				message = "Error While Uploading Picture " + e;
			}
		}
		else{
			message = "Some Param Missing";
		}
		result.setId(flag);
		result.setMessage(message);
    	return result;
    }
	
	@RequestMapping(value = "/companyAdmin/dealer" , method = RequestMethod.GET)
	@ResponseBody
	public List<Dealer> getDealerListByCA(HttpServletRequest request){
		List<Dealer> dealerList = new ArrayList<Dealer>();
		Integer company_admin_id = (Integer)request.getSession().getAttribute("company_admin_id");
		if(company_admin_id != null){
			try{
				dealerList = adminService.getDealerListByCA(company_admin_id);
				if(dealerList != null){
					LOG.info("Dealer List Fetched Successfully");
				}
				else{
					LOG.info("Dealer List Can't be Fetched");
				}
			}catch(Exception e){
				LOG.info("Error while fetching dealer List " + e);
			}
		}
		else{
			LOG.info("Some Param Missing");
		}
		return dealerList;
	}
	/**
	 * This will create the user 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/image/notification",method = RequestMethod.POST)
	@ResponseBody
	public Message uploadFile(@RequestBody byte[] bytes) {
		BufferedImage image = null;
		String file_url = null;
		String SAVE_DIR = "notification";
		String message = null;
		Integer id= 0;
		java.util.Date date= new java.util.Date();
		Long currentTimestamp = date.getTime();
		Message result = new Message();
		String appPath = "/usr/share/tomcat7/webapps";
		String savePath = appPath + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if(bytes != null){
			try {	
				InputStream inputStream = new ByteArrayInputStream(bytes);
				image = ImageIO.read(inputStream);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}
				if(ImageIO.write(image, "jpg", new File(fileSaveDir + File.separator + "noti_" + currentTimestamp + ".jpg"))){
					file_url = "http://192.168.43.181:8080/" + SAVE_DIR + File.separator
							+ "noti_" + currentTimestamp + ".jpg";
					id = 1;
					message = file_url;
					LOG.info(file_url);
				}
				else{
					id =0;
					message ="Image Not Uploaded";
					LOG.info(message);
					
				}
				
			} catch (Exception e) {
				LOG.info("File uploading error" + e);
			}
			
		} else {
			id = 9;
			message = "Some Param are null";
			LOG.info(message);
			
		}
		result.setMessage(message);
		result.setId(id);
		return result;
	}
	
	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	@ResponseBody
	public User checkLogin(@RequestBody User user, HttpServletRequest request){
		User user1 = null;
		Integer company_id = 0;
		if (user != null) {
			try {
				user1 = new User();
				user1 = superAdminService.getUserByEmail(user.getEmail());
				if(user1 != null && user1.getPassword() != null){
					if(user1.getPassword().equals(user.getPassword())){
						LOG.info("Password matched");
						// Only For Web
						if(user1.getType().equals("CA")){
							company_id = adminService.getCompanyIdByAdmin(user1.getReference_id());
							if(company_id != null){
								request.getSession().setAttribute("company_id", company_id);
								LOG.info("Company Id : " + (Integer)request.getSession().getAttribute("company_id"));
							}
							request.getSession().setAttribute("company_admin_id", user1.getReference_id());
							if(request.getSession().getAttribute("company_admin_id").equals(user1.getReference_id())){
								LOG.info("Session Started " + request.getSession().getAttribute("company_admin_id"));
							}
							else{
								LOG.info("Error While Adding Session");
							}
						}
						return user1;
					}
					else
						return null;
				}
			} catch (Exception e) {
				LOG.info("Fault in companyService" + e);
			}
		} else {
			LOG.info("User value is null");
		}
		return user1;
	}
	
	@RequestMapping(value = "/companyAdmin" , method = RequestMethod.GET)
	@ResponseBody
	public CompanyAdmin getCompanyAdmin(HttpServletRequest request){
		CompanyAdmin companyAdmin = new CompanyAdmin();
		Integer companyAdminId = (Integer)request.getSession().getAttribute("company_admin_id");
		LOG.info("Company Admin id " + companyAdminId);
		if(companyAdminId != null){
			try{
				companyAdmin = adminService.getCompanyAdminById(companyAdminId);
				if(companyAdmin != null){
					LOG.info("Company Admin Fetched Succesfully");
				}
				else{
					LOG.info("Company Admin can't be fetched");
				}
			}catch(Exception e){
				LOG.info("Error while retriving Company Admin " + e);
			}
		}
		else{
			LOG.info("Company Admin Id is null");
		}
		return companyAdmin;
	}
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	@ResponseBody
	public Message IsSessionSet(HttpServletRequest request){
		Message result = new Message();
		String message = new String();
		Integer id = 0;
		try{
			LOG.info("Company Admin Id : " + (Integer)request.getSession().getAttribute("company_admin_id"));
			if(request.getSession().getAttribute("company_admin_id").equals(0)){
				message = "Session is Not Active";
				id = 0;
			}
			else{
				message = "Session is Active";
				id = 1;
			}
		}catch(Exception e){
			LOG.info("Error in Sessions " + e);
		}
		LOG.info(message);
		result.setId(id);
		result.setMessage(message);
		return result;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Message logout(HttpServletRequest request){
		Message result = new Message();
		String message = new String();
		Integer id = 0;
		try{
			request.getSession().setAttribute("company_admin_id", 0);
//			request.getSession().removeAttribute("rm_id");
//			request.getSession().removeAttribute("am_id");
//			request.getSession().removeAttribute("tsi_id");
//			request.getSession().removeAttribute("dealer_id");
			if(request.getSession().getAttribute("company_admin_id").equals(0)){
				id = 1;
				message = "Logout Successfully";
			}
			else{
				id = 0;
				message = "Logout Failed";	
			}
		}catch(Exception e){
			LOG.info("Error While Removing Sessions " + e);
		}
		LOG.info(message);
		result.setId(id);
		result.setMessage(message);
		return result;
	}
	
	@RequestMapping(value= "/type/{type}/password", method = RequestMethod.PUT)
	@ResponseBody
	public Message changePasswordByType(@PathVariable String type, @RequestBody User user){
		Message result  = new Message();
		String message = new String();
		Integer flag = 0;
		if(type != null && user != null){
			try{
				flag = adminService.changePasswordByType(user,type);
				if(flag > 0){
					message = "Password Updated Successfully";
				}
				else{
					message = "Password Not Updated";
				}
			}catch(Exception e){
				message = "Error While Changing Password " + e;
			}
		} else{
			message = "Param Missing";
		}
		LOG.info(message);
		result.setId(flag);
		result.setMessage(message);
		return result;
	}
	
}