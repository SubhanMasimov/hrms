package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegisterDto {

	private String compamyName;
	private String webSite;
	private String email;
	private String phone;
	private String password;
	
}
