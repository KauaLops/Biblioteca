package Model;

import java.time.LocalDate;

public class PagamentoMulta {
	private String id;
	private double valor;
	private LocalDate data;
	private String metodo; // dinheiro, pix, cartão
	private Usuario usuario;

	public PagamentoMulta(String id, double valor, LocalDate data, String metodo, Usuario usuario) {
		setId(id);
		setValor(valor);
		setData(data);
		setMetodo(metodo);
		setUsuario(usuario);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id == null || id.isEmpty()) {
			throw new IllegalArgumentException("ID inválido");
		}
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("O valor da multa tem que ser maior que zero.");
		}
		this.valor = valor;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		if(data == null) {
			throw new IllegalArgumentException("Data inválida");
		}
		this.data = data;
	}
	
	public String getMetodo() {
		return metodo;
	}
	
	public void setMetodo(String metodo) {
		if(metodo == null ||
			(!metodo.equalsIgnoreCase("dinheiro") &&
			 !metodo.equalsIgnoreCase("pix") &&
			 !metodo.equalsIgnoreCase("cartao"))) {
				throw new IllegalArgumentException("Método inválido");
			}
			this.metodo = metodo;
	}
	
	public Usuario getUsuario(Usuario usuario) {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuário inválido.");
		}
		this.usuario = usuario;
	}

	@Override
	public String toString() {
	    return "== Pagamento da Multa ==\n" +
	           "ID: " + id + "\n" +
	           "Valor: R$ " + valor + "\n" +
	           "Data: " + data + "\n" +
	           "Método: " + metodo + "\n" +
	           "Usuário: " + usuario.getNome();
	}

	
	
	
	
	
	
}
