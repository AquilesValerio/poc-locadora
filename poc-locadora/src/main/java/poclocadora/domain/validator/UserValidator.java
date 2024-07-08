package poclocadora.domain.validator;

import poclocadora.domain._share.NotificationPattern;
import poclocadora.domain.entities.User;
import poclocadora.domain.util.CpfValidator;
import poclocadora.domain.util.EmailValidator;

public class UserValidator {

	public static void validate(User user, NotificationPattern notificationPattern) {
		if (user.getName() == null || user.getName().trim().isEmpty() || user.getName().length() > 50) {
			notificationPattern.addErro("This field is mandatory and must be 50 characters long.");
		}
		if (!EmailValidator.isValid(user.getEmail())) {
			notificationPattern.addErro("Must to be a valid email");
		}
		if (!CpfValidator.isValidCPF(user.getCpf())) {
			notificationPattern.addErro("Must to be a valid cpf");
		}
	}
}
