package poclocadora.domain._share;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {
	private HttpStatus statusCode;
	private List<String> erros;

	public ApiException(HttpStatus statusCode, List<String> erros) {
		this.statusCode = statusCode;
		this.erros = erros;
	}
	public ApiException(HttpStatus statusCode, String erro) {
		this.statusCode = statusCode;
		this.erros = List.of(erro);
	}
}
