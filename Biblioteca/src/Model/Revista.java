package Model;

public class Revista extends Obra {

	public Revista(String codigo, String titulo, String autor, int anoPublicacao) {
		super(codigo, titulo, autor, anoPublicacao, false);
		
	}

	@Override
	public int getTempoEmprestimo() {
		return 3;
	}
	
	@Override
    public String toString() {
         return "== Revista ==\n" +
 	           "Código: " + codigo + "\n" +
 	           "titulo: " + titulo + "\n" +
 	           "autor: " + autor + "\n" +
 	           "anoPublicacao: " + anoPublicacao + "\n" +
 	           "disponivel: " + disponivel;
    }
}
