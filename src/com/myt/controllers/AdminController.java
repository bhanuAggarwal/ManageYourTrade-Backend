/**
 * 
 */
package com.myt.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myt.domains.AreaManager;
import com.myt.domains.Bills;
import com.myt.domains.Company;
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
	public Message createRM(@RequestBody RegionalManager regionalManager) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (regionalManager != null) {
			try {
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
	public List<AreaManager> getRegionalManagerByCompanyAdmin(@RequestParam Integer companyAdminId) {
		List<AreaManager> listRegionalManager = new ArrayList<AreaManager>();
		if(companyAdminId != null){
			try{
				listRegionalManager = adminService.getRegionalManagerByCompanyAdmin(companyAdminId);
			}catch(Exception e){
				LOG.info("Error in Admin Controller " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return listRegionalManager;
	}

	@RequestMapping(value = "/rm/{rm_id}" , method = RequestMethod.GET)
	@ResponseBody
	public RegionalManager getCurrentRM(@PathVariable Integer rm_id){
		RegionalManager regionalManager = new RegionalManager();
		if(rm_id != null){
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

	/**
	 * This will create the vendor object in database
	 * 
	 * @param vendor
	 * @return message
	 */
	@RequestMapping(value="/am",method = RequestMethod.POST)
	@ResponseBody
	public Message createAM(@RequestBody AreaManager areaManager) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (areaManager != null) {
			try {
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
	public List<AreaManager> getAreaManagerByRegionalManager(@RequestParam Integer rm_id) {
		List<AreaManager> listAreaManager = new ArrayList<AreaManager>();
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
	
	@RequestMapping(value = "/am/{am_id}" , method = RequestMethod.GET)
	@ResponseBody
	public AreaManager getCurrentAM(@PathVariable Integer am_id){
		AreaManager areaManager = new AreaManager();
		if(am_id != null){
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
	public Message createTSI(@RequestBody TSI tsi) {
		Message message = new Message();
		String result = null;
		int id = 0;
		if (tsi != null) {
			try {
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
	public List<TSI> getTSIByAM(@RequestParam Integer am_id) {
		List<TSI> listTSI = new ArrayList<TSI>();
		if(am_id != null){
			try{
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
	
	@RequestMapping(value = "/tsi/{tsi_id}" , method = RequestMethod.GET)
	@ResponseBody
	public TSI getCurrentTSI(@PathVariable Integer tsi_id){
		TSI tsi = new TSI();
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
	public Message createDealer(@RequestBody Dealer dealer) {
		Message message = new Message();
		String result = null;
		Integer id = 0;
		if (dealer != null) {
			try {
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
	public List<Dealer> getDealersByTSI(@RequestParam Integer tsi_id) {
		List<Dealer> listDealers = new ArrayList<Dealer>();
		if(tsi_id != null){
			try{
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
	public Dealer getDealerById(@PathVariable Integer dealer_id){
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

	@RequestMapping(value = "/{type}/{type_id}/picture/company/{company_id}", method = RequestMethod.POST)
	@ResponseBody
	public Message upload(@PathVariable String type, @PathVariable Integer company_id,
			@PathVariable Integer type_id,MultipartHttpServletRequest request) {
		Message result = new Message();
		String message = new String();
		Integer i = 0;
		byte[] bytes;
		String file_url = null;
		String SAVE_DIR = null;
		String savePath = null;
		BufferedImage image = null;
		if(type != null && type_id != null && request != null && company_id != null){
			try {
				Iterator<String> itr =  request.getFileNames();
				String appPath = "/usr/share/tomcat7/webapps";
				MultipartFile mpf = request.getFile(itr.next());
				SAVE_DIR = adminService.getCompanyNameById(company_id);
				SAVE_DIR = SAVE_DIR.replace(" ", "_");
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
					file_url = "http://52.26.80.158:2110/" + SAVE_DIR + File.separator + type + "_" + type_id + ".jpg";
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
	public Message addWarehouseBill(@RequestBody Warehouse warehouseBills){
		Message result = new Message();
		Integer id = 0;
		String message = new String();
		if(warehouseBills != null){
			try{
				id = adminService.addWarehouseBill(warehouseBills);
				if(id > 0){
					message = "Bill Updated Successfully";
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
	
	@RequestMapping(value="/warehouse/bill/{bill_id}/{type}" , method=RequestMethod.POST)
	@ResponseBody
    public Message addWarehouseBillsImages(@PathVariable Integer bill_id , @PathVariable String type 
    		,MultipartHttpServletRequest request) {
    	String file_url = new String();
    	Message result = new Message();
    	String message = new String();
    	Integer flag = 0;
		byte[] bytes;
    	String SAVE_DIR = null;
    	String savePath = null;
		BufferedImage image = null;
		String dirPath = new String();
		DateFormat dateFormator = new SimpleDateFormat("dd-MM-yyyy");
		if(type != null && bill_id != null && request != null){
			try {
				Warehouse warehouseBills = new Warehouse();
				warehouseBills = adminService.getWarehouseBillsById(bill_id);
				dirPath = adminService.getCompanyNameByCompanyAdmin(warehouseBills.getCompany_admin_id()).replace(" ", "_") + "/"; 
				dirPath += adminService.getRMArea(warehouseBills.getCompany_admin_id(),warehouseBills.getDealer_id()).replace(" ", "_") + "/";
				dirPath += adminService.getAMArea(warehouseBills.getCompany_admin_id(),warehouseBills.getDealer_id()).replace(" ", "_") + "/";
				dirPath += adminService.getTSIArea(warehouseBills.getCompany_admin_id(),warehouseBills.getDealer_id()).replace(" ", "_") + "/";
				dirPath += adminService.getDealerName(warehouseBills.getDealer_id()).replace(" ", "_") + "/";
				Date orderDate = new Date(warehouseBills.getCreativeTime().getTime());
				dirPath += dateFormator.format(orderDate);
				LOG.info(dirPath);
				Iterator<String> itr =  request.getFileNames();
				String appPath = "/usr/share/tomcat7/webapps";
				MultipartFile mpf = request.getFile(itr.next());
				SAVE_DIR = dirPath;
				bytes= mpf.getBytes();
				savePath = appPath + File.separator + SAVE_DIR;
				File fileSaveDir = new File(savePath);
				InputStream inputStream = new ByteArrayInputStream(bytes);
				image = ImageIO.read(inputStream);
				if (!fileSaveDir.exists()) {
					if(fileSaveDir.mkdirs()){
						LOG.info("Directory Created");
					}else{
						LOG.info("Directory not created");
					}
				}
				ImageIO.write(image, "jpg", new File(fileSaveDir + File.separator + type + "_" + bill_id + ".jpg"));
				file_url = "http://52.26.80.158:2110/" + SAVE_DIR + File.separator + type + "_" + bill_id + ".jpg";
				if(image != null){
					flag = adminService.updateWarehouseBills(type,bill_id, file_url);
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
	
	@RequestMapping(value= "/warehouse/bill/{type}", method = RequestMethod.GET)
	@ResponseBody
	public Bills getWarehouseBills(@PathVariable String type , @RequestParam Integer companyId , 
			@RequestParam Integer dealerId){
		Bills warehouseBills = new Bills();
		List<String> billsArray = new ArrayList<String>();
		if(type != null && companyId != null && dealerId != null){
			try{
				billsArray = adminService.getWarehouseBills(type,companyId,dealerId);
				if(billsArray != null){
					warehouseBills.setBills(billsArray);
					LOG.info("Bills fetched Successfully");
				}
				else{
					LOG.info("Bills not fetched");
				}
			}catch(Exception e){
				LOG.info("Exception : " + e);
			}
		}
		else{
			LOG.info("Param Missing");
		}
		return warehouseBills;
	}
	@RequestMapping(value = "/companyAdmin/{company_admin_id}/dealer" , method = RequestMethod.GET)
	@ResponseBody
	public List<Dealer> getDealerListByCA(@PathVariable Integer company_admin_id){
		List<Dealer> dealerList = new ArrayList<Dealer>();
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
					file_url = "http://52.26.80.158:2110/" + SAVE_DIR + File.separator
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
	public User checkLogin(@RequestBody User user){
		User user1 = null;
		if (user != null) {
			try {
				user1 = new User();
				user1 = superAdminService.getUserByEmail(user.getEmail());
				if(user1 != null && user1.getPassword() != null){
					if(user1.getPassword().equals(user.getPassword())){
						LOG.info("Password matched");
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
	
	@RequestMapping(value = "/companyAdmin/{companyAdminId}" , method = RequestMethod.GET)
	@ResponseBody
	public CompanyAdmin getCompanyAdmin(@PathVariable Integer companyAdminId){
		CompanyAdmin companyAdmin = new CompanyAdmin();
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
	
	@RequestMapping(value = "/company/dealer/{dealerId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> getCompanyListByDealer(@PathVariable Integer dealerId){
		List<Company> companyList = new ArrayList<Company>();
		if(dealerId != null){
			try{
				companyList = adminService.getCompanyListByDealer(dealerId);
			}catch(Exception e){
				LOG.info("Error while fetching company list " + e);
			}
		}
		else{
			LOG.info("Dealer id is NULL");
		}
		return companyList;
	}
}