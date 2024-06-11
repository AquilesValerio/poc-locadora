package poclocadora.infrastructure.gateway;

import org.springframework.stereotype.Repository;
import poclocadora.domain.entities.User;
import poclocadora.domain.interfaces.gateway.IUserGateway;
import poclocadora.infrastructure.persistence.UserRepository;

@Repository
public class UserGateway implements IUserGateway {

	private final UserRepository repository;

	public UserGateway(UserRepository repository) {this.repository = repository;}

	@Override
	public User insert(User request) {
		var result = repository.save(request);
		return result;
	}

	@Override
	public User findByCpf(String cpf) {
		var result = repository.findByCpf(cpf);
		return result;
	}

}
