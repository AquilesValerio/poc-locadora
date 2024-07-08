package poclocadora.domain.interfaces.gateway;

import poclocadora.domain.entities.User;

public interface IUserGateway {
	User insert(User request);
	User findByCpf(String cpf);
}
