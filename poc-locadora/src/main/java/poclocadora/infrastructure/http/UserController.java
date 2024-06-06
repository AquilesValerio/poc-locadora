package poclocadora.infrastructure.http;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import poclocadora.domain.entities.User;
import poclocadora.domain.interfaces.services.IUserService;
import poclocadora.infrastructure.DTO.IN.UserIn;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final IUserService service;

	public UserController(IUserService service) {this.service = service;}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody @Valid UserIn requestBody){

		var response = service.insert(requestBody.toDomain(requestBody));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
