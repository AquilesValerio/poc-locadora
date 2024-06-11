package poclocadora.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import poclocadora.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByCpf(String cpf);
}
