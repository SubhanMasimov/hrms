package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "status")
	private boolean status;

//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Candidate candidate;

}
