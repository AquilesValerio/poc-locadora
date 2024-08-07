package poclocadora.domain._share;

import java.util.ArrayList;
import java.util.List;

public class NotificationPattern {

	private List<String> listErros;

	private List<String> create() {
		listErros = listErros == null ? new ArrayList<>() : listErros;
		return listErros;
	}

	public void addErros(List<String> erros) {
		create().addAll(erros);
	}

	public void addErro(String erros) {
		create().add(erros);
	}

	public boolean hasErros() {
		return listErros == null ? false : !listErros.isEmpty();
	}
	public List<String> getListErros() {
		return create();
	}
}
