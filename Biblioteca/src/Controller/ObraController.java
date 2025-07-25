package Controller;

import dao.ObraDao;
import Model.Obra;
import Model.Livro;
import Model.Revista;
import Model.Artigo;

import java.util.List;

public class ObraController {
    private final ObraDao obraDao;

    public ObraController() {
        this.obraDao = new ObraDao();
    }

    // ---------- MÉTODOS DE CADASTRO ----------

    public void cadastrarLivro(String codigo, String titulo, String autor, int ano) {
        Livro livro = new Livro(codigo, titulo, autor, ano);
        adicionarObra(livro);
    }

    public void cadastrarRevista(String codigo, String titulo, String autor, int ano) {
        Revista revista = new Revista(codigo, titulo, autor, ano);
        adicionarObra(revista);
    }

    public void cadastrarArtigo(String codigo, String titulo, String autor, int ano) {
        Artigo artigo = new Artigo(codigo, titulo, autor, ano);
        adicionarObra(artigo);
    }

    // ---------- MÉTODOS DE LISTAGEM E BUSCA ----------

    public List<Obra> listarObras() {
        return obraDao.carregar();
    }

    public Obra buscarPorCodigo(String codigo) {
        for (Obra obra : obraDao.carregar()) {
            if (obra.getCodigo().equals(codigo)) {
                return obra;
            }
        }
        return null;
    }

    // ---------- MÉTODO DE REMOÇÃO ----------

    public boolean removerObra(String codigo) {
        List<Obra> obras = obraDao.carregar();
        boolean removido = obras.removeIf(o -> o.getCodigo().equals(codigo));
        if (removido) {
            obraDao.salvar(obras);
        }
        return removido;
    }

    // ---------- MÉTODO DE EDIÇÃO ----------

    public boolean editarObra(String codigo, String novoTitulo, String novoAutor, int novoAno) {
        List<Obra> obras = obraDao.carregar();
        for (Obra obra : obras) {
            if (obra.getCodigo().equals(codigo)) {
                obra.setTitulo(novoTitulo);
                obra.setAutor(novoAutor);
                obra.setAnoPublicacao(novoAno);
                obraDao.salvar(obras);
                return true;
            }
        }
        return false;
    }

    // ---------- MÉTODO AUXILIAR PRIVADO ----------

    private void adicionarObra(Obra obra) {
        List<Obra> obras = obraDao.carregar();
        obras.add(obra);
        obraDao.salvar(obras);
    }
}
