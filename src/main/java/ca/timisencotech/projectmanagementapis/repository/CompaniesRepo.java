package ca.timisencotech.projectmanagementapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ca.timisencotech.projectmanagementapis.dto.CompaniesDetails;

public interface CompaniesRepo extends JpaRepository<CompaniesDetails, Long> {
	
	@Query(value ="select c.usersignupid, c.id,c.companyname,c.companyaddress,c.companycity,c.companystateprovince,c.companycountry,c.postalcode,c.phonenumber from companiestable c inner join usersignuptable u on c.usersignupid =u.id where c.companyname=?1", nativeQuery = true)
	CompaniesDetails findCompaniesDetails(String companyName);
	
}
