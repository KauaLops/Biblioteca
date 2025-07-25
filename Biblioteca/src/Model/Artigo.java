package Model;

public class Artigo extends Obra {

	public Artigo(String codigo, String titulo, String autor, int anoPublicacao) {
		super(codigo, titulo, autor, anoPublicacao, false);
		
	}

	@Override
	public int getTempoEmprestimo() {
		return 2;
	}
	
	@Override
    public String toString() {
         return "== Artigo ==\n" +
 	           "Código: " + codigo + "\n" +
 	           "titulo: " + titulo + "\n" +
 	           "autor: " + autor + "\n" +
 	           "anoPublicacao: " + anoPublicacao + "\n" +
 	           "disponivel: " + disponivel;
    }
}
