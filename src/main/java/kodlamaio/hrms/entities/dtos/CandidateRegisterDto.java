package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRegisterDto {
	
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate birthDate;
	private String email;
	private String password;
}
