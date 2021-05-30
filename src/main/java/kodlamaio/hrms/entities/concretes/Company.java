package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company{

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
	
	public Company(String companyName, String website, String phoneNumber) {
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
}
