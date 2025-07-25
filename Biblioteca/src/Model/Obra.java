package Model;

public abstract class Obra {
	protected String codigo;
	protected String titulo;
	protected String autor;
	protected int anoPublicacao;
	protected boolean disponivel;
	
	public Obra(String codigo, String titulo, String autor, int anoPublicacao, boolean disponivel) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.setAnoPublicacao(anoPublicacao);
		this.disponivel = true;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		if(anoPublicacao > 0) {
			this.anoPublicacao = anoPublicacao;
		} else {
			throw new IllegalArgumentException("Ano de publicação inválido");
		}
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setStatus(boolean status) {
		this.disponivel = status;
	}
	public void emprestar() {
		if(!disponivel) {
			throw new IllegalStateException("Obra já está emprestada.");
		}
		disponivel = false;
	}
	public void devolver() {
		disponivel = true;
	}
	// Método abstrato: cada tipo define seu próprio tempo de empréstimo
    public abstract int getTempoEmprestimo();
}
