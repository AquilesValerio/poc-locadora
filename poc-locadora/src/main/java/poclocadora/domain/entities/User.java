package poclocadora.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import poclocadora.domain._share.NotificationPattern;
import poclocadora.domain.validator.UserValidator;

@Data
@Entity(name = "users")
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "cpf", nullable = false, length = 14, unique = true)
	private String cpf;
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	private String status;

	public User() {}

	public User(Long id, String name, String cpf, String email, String status) {
		this.Id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.status = status;
	}
	public void validate(NotificationPattern notificationPattern){
		new UserValidator().validate(this, notificationPattern);
	}
}
