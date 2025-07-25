package Model;

import java.time.LocalDate;

public class Emprestimo {
	private Usuario usuario;
	private Obra obra;
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaDevolucao;
	private boolean devolvido;

	public Emprestimo(Usuario usuario, Obra obra) {
		if (usuario == null || obra == null) {
			throw new IllegalArgumentException("Usuário e obra não podem ser nulos.");
		}
		if (!obra.isDisponivel()) {
			throw new IllegalStateException("Obra não está disponível para empréstimo.");
		}

		this.usuario = usuario;
		this.obra = obra;
		this.dataEmprestimo = LocalDate.now();
		this.dataPrevistaDevolucao = dataEmprestimo.plusDays(obra.getTempoEmprestimo());
		this.devolvido = false;

		obra.emprestar(); // marca a obra como emprestada
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Obra getObra() {
		return obra;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public boolean isAtrasado() {
		return !devolvido && LocalDate.now().isAfter(dataPrevistaDevolucao);
	}

	public void devolver() {
		if (devolvido) {
			throw new IllegalArgumentException("Obra já foi devolvida.");
		}
		this.devolvido = true;
		obra.devolver();
	}
}
