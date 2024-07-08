package poclocadora.infrastructure.DTO.IN;

import poclocadora.domain.entities.User;

public record UserIn(String name, String cpf, String email, String password) {

	public User toDomain(UserIn request){
		return new User(null, request.name, request.cpf, request.email, null);
	}
}
