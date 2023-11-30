package mx.uv;

public class Usuario {
    String id;
    String nombre;
    String password;

    Usuario(){

    }

    Usuario(String id, String nombre, String password){
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setPasswd(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setId(String Id){
        this.id = Id;
    }

    public String getId(){
        return id;
    }

}
