package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SalvarJSON {
	private static final Gson gson = new Gson();
	
	public static <T> void salvarLista(List<T> lista, String caminho) {
		try(FileWriter writer = new FileWriter(caminho)){
			gson.toJson(lista, writer);
		} catch (Exception e) {
			System.out.println("Erro ao salvar JSON: "+ e.getMessage());
		}
	}
	
	public static <T> List<T> carregarLista(String caminho, Type tipoLista){
		try(FileReader reader = new FileReader(caminho)){
			return gson.fromJson(reader, tipoLista);
		} catch (Exception e) {
			System.out.println("Erro ao arregar JSON: "+ e.getMessage());
			return new ArrayList<>();
		}
		
	}
}
