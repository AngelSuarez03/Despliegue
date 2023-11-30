package mx.uv;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.UUID;

import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App {
    static Gson gson = new Gson();
    static HashMap<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        port(90);

        get("/usuarios", (request, response)->{
            response.type("application/json");
            return gson.toJson(usuarios.values());
            //return gson.toJson(DAO.dameUsuarios());
        });

        post("/usuarios", (request, response)->{
            String payload = request.body();
            Usuario usuario = gson.fromJson(payload, Usuario.class);
            System.out.println("payload "+payload);
            String id = UUID.randomUUID().toString();
            usuario.setId(id);
            usuarios.put(id, usuario);
            //DAO.crearUsuario(usuario);
            System.out.println("n "+usuario.getNombre());
            System.out.println("p "+usuario.getPassword());
            System.out.println("i "+usuario.getId());
            return usuario;
        });

        // get("/usuarios",
        //         (rq, rs) -> {
        //             rs.type("aplicattion/json");
        //             return gson.toJson(DAO.dameUsuarios());
        //         });
        // post("/usuarios",
        //         (rq, rs) -> {
        //             String payload = rq.body();
        //             Usuario u = gson.fromJson(payload, Usuario.class);
        //             String id = UUID.randomUUID().toString();
        //             u.setId(id);
        //             // usuarios.put(id, u); //Almacena en un diccionario
        //             DAO.crearUsuario(u);
        //             System.out.println(
        //                     "Payload;" + payload + "\nNombre: " + u.getNombre() + "\nPassword: " + u.getPassword());

        //             JsonObject respuesta = new JsonObject();
        //             respuesta.addProperty("msj", "Creado");
        //             respuesta.addProperty("id", "id");

        //             return respuesta;
        //         });
    }
}
