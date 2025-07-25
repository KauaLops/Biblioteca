package dao;

import Model.Obra;
import interfaces.Persistivel;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ObraDao implements Persistivel<Obra> {

    private final String caminhoArquivo = "dados/obras.json";
    private final Gson gson;

    public ObraDao() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Obra.class, new ObraAdapter())  // Corrigido aqui
                .setPrettyPrinting()
                .create();
    }

    // Salva a lista no arquivo padrão
    public void salvar(List<Obra> obras) {
        salvar(obras, caminhoArquivo);
    }

    // Carrega a lista do arquivo padrão
    public List<Obra> carregar() {
        return carregar(caminhoArquivo);
    }

    // Salva a lista no arquivo indicado
    @Override
    public void salvar(List<Obra> lista, String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            gson.toJson(lista, writer);
        } catch (IOException e) {
            System.err.println("Erro ao salvar obras: " + e.getMessage());
        }
    }

    // Carrega a lista do arquivo indicado
    @Override
    public List<Obra> carregar(String caminho) {
        try (Reader reader = new FileReader(caminho)) {
            Type tipoLista = new TypeToken<ArrayList<Obra>>() {}.getType();
            List<Obra> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Arquivo não encontrado. Retornando lista vazia.");
            return new ArrayList<>();
        }
    }
}
