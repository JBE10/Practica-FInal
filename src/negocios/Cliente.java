package negocios;

import exepciones.YaExiste;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private int dni;

    private String nombre;
    private int telefono;
    private ArrayList<Envio> envios;
    public Cliente(){
        this.envios = new ArrayList<Envio>();
        this.nombre="";
        this.telefono=0;
        this.dni=0;
    }
    public Cliente (int dni, String nombre, int telefono){
        this.envios = new ArrayList<Envio>();
        this.nombre=nombre;
        this.telefono=telefono;
        this.dni=dni;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }

    public void agregarEnvio(Envio e){
        for (Envio envio: envios){
            if (envio.getId()==e.getId()){
                throw new YaExiste();
            }
        }
        envios.add(e);
    }
    public Envio obtenerEnvio(int id){
        for(Envio envio: envios){
            if(envio.getId()==id){
                return envio;
            }
        }
        return null;
    }



}
