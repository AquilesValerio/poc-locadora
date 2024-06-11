package poclocadora.infrastructure.http;

import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import poclocadora.domain._share.ApiException;
import poclocadora.domain._share.ExceptionMessage;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ExceptionMessage> apiExceptionMessage(ApiException e) {
		ExceptionMessage err = new ExceptionMessage(e.getErros());
		return ResponseEntity.status(e.getStatusCode()).body(err);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionMessage> DataIntegrityViolationException(ApiException e) {
		ExceptionMessage err = new ExceptionMessage(e.getErros());
		return ResponseEntity.status(e.getStatusCode()).body(err);
	}



	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalException(Exception globalEception) {
		return ResponseEntity.status(500).body(globalEception.getMessage());
	}
}
