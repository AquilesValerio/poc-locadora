package poclocadora.application.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import poclocadora.domain._share.ApiException;
import poclocadora.domain._share.NotificationPattern;
import poclocadora.domain.entities.User;
import poclocadora.domain.interfaces.gateway.IUserGateway;
import poclocadora.domain.interfaces.services.IUserService;

@Service
public class UserService implements IUserService {
	private final IUserGateway iUserGateway;

	public UserService(IUserGateway iUserGateway) {this.iUserGateway = iUserGateway;}

	@Override
	public User insert(User request) {
		validateUser(request);
		checkAndSave(request);
		return setUpStatus(request);
	}

	private User setUpStatus(User request) {
		if (request.getId() != null) {
			request.setStatus("Active");
		}
		return request;
	}

	private void validateUser(User request) {
		var erros = new NotificationPattern();
		request.validate(erros);
		if (erros.hasErros()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, erros.getListErros());
		}
	}
	private void checkAndSave(User request) {
		var entity =  iUserGateway.findByCpf(request.getCpf());
		if(entity == null){
			iUserGateway.insert(request);
		}else {
			throw new ApiException(HttpStatus.CONFLICT, "This cpf is already in the system");
		}
	}
}
