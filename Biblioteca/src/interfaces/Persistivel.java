package interfaces;

import java.util.List;

public interface Persistivel<T> {
	void salvar(List<T> lista, String caminho);

	List<T> carregar(String caminho);
}
