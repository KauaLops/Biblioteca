package dao;

import com.google.gson.*;
import Model.*;

import java.lang.reflect.Type;

// Adapter para serializar e desserializar polimorficamente a classe abstrata Obra e seus subtipos
public class ObraAdapter implements JsonSerializer<Obra>, JsonDeserializer<Obra> {

    private static final String TIPO = "tipo";

    @Override
    public JsonElement serialize(Obra obra, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObj = context.serialize(obra, obra.getClass()).getAsJsonObject();
        // Adiciona o campo "tipo" para indicar o subtipo de Obra
        if (obra instanceof Livro) {
            jsonObj.addProperty(TIPO, "Livro");
        } else if (obra instanceof Revista) {
            jsonObj.addProperty(TIPO, "Revista");
        } else if (obra instanceof Artigo) {
            jsonObj.addProperty(TIPO, "Artigo");
        } else {
            throw new JsonParseException("Tipo de obra desconhecido: " + obra.getClass().getName());
        }
        return jsonObj;
    }

    @Override
    public Obra deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObj = json.getAsJsonObject();
        JsonElement tipoElement = jsonObj.get(TIPO);

        if (tipoElement == null) {
            throw new JsonParseException("Campo 'tipo' não encontrado no JSON.");
        }

        String tipo = tipoElement.getAsString();

        switch (tipo) {
            case "Livro":
                return context.deserialize(jsonObj, Livro.class);
            case "Revista":
                return context.deserialize(jsonObj, Revista.class);
            case "Artigo":
                return context.deserialize(jsonObj, Artigo.class);
            default:
                throw new JsonParseException("Tipo de obra desconhecido no JSON: " + tipo);
        }
    }
}
