package com.myt.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myt.domains.Company;
import com.myt.domains.CompanyAdmin;
import com.myt.domains.User;
/**
 * 
 * @author bhanu
 *
 */
public interface SuperAdminMapper {

	@Insert("INSERT INTO company("
	            + "  name, address , description, tin, pan, bank_name, bank_account, bank_address"
	            + " ,bank_ifsc, reg_no)"
	            + " VALUES (#{name}, #{address} , #{description} ,#{tin}, #{pan},"
	            + " #{bank_name}, #{bank_account}, #{bank_address} , #{bank_ifsc} "
	            + " , #{reg_no})")
    public Integer createCompany(Company company);
	
	
	@Insert("INSERT INTO company_admin("
            + "  username, email , phone_no, password, RM_no, AM_no, TSI_no, Dealer_no, company_id , profile_pic)"
            + " VALUES (#{username}, #{email} , #{phone_no} ,#{password}, #{rm_no},"
            + " #{am_no}, #{tsi_no}, #{dealer_no} , #{company.id} , '')")
	public Integer createCompanyAdmin(CompanyAdmin companyAdmin);
	
	@Insert("INSERT INTO users("
            + "name,  email , phone_no, type, password, reference_id)"
            + " VALUES(#{name} , #{email} , #{phone_no} ,#{type}, #{password} , #{reference_id})")
	public Integer createUser(User user);
	
	@Select("SELECT * from users where email = #{email} ORDER BY id DESC LIMIT 1")
	public User getUserByEmail(String email);

	
	@Select("SELECT ca.*, c.name AS \"company.name\" FROM company_admin ca JOIN company c ON ca.company_id = c.id ORDER BY id DESC")
	public List<CompanyAdmin> getCompanyAdminList();

	@Select("SELECT id FROM company ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedCompanyId();

	@Select("SELECT id FROM company_admin WHERE company_id = #{company_id} ORDER BY id DESC LIMIT 1")
	public Integer getLastAddedCompanyAdminId(Integer company_id);

	

}
