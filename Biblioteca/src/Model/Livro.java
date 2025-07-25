package Model;

public class Livro extends Obra {

    public Livro(String codigo, String titulo, String autor, int anoPublicacao) {
        super(codigo, titulo, autor, anoPublicacao, false);
    }

    @Override
    public String toString() {
         return "== Livro ==\n" +
 	           "Código: " + codigo + "\n" +
 	           "titulo: " + titulo + "\n" +
 	           "autor: " + autor + "\n" +
 	           "anoPublicacao: " + anoPublicacao + "\n" +
 	           "disponivel: " + disponivel;
    }

	@Override
	public int getTempoEmprestimo() {
		// TODO Auto-generated method stub
		return 7;
	}


}
