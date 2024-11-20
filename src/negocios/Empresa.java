package negocios;

import exepciones.YaExiste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

public class Empresa implements java.io.Serializable {
    private ArrayList<Cliente> clientes;
    private ArrayList<Envio> envios;

    public Empresa(){
        this.clientes = new ArrayList<Cliente>();
        this.envios = new ArrayList<Envio>();
    }
    public void agregarCliente(Cliente c){
        for(Cliente cliente: clientes){
            if(cliente.getDni()==c.getDni()){
                throw new YaExiste();
            }
        }
        clientes.add(c);
    }
    public Cliente obtenerCliente(int dni){
        for(Cliente cliente: clientes){
            if(cliente.getDni()==dni){
                return cliente;
            }
        }
        return null;
    }
    public void agregarEnvio(Envio e){
        for (Envio envio: envios){
            if(envio.getId()==e.getId()){
                throw new YaExiste();
            }
        }
        envios.add(e);
    }
    public double costoTotal(){
        double suma = 0;
        for (Envio envio: envios){
            suma+=envio.getCosto();
        }
        return suma;
    }
    public void cargarEmpresa(String nombreArchivo){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            Empresa empresa = (Empresa) in.readObject();
            this.clientes = empresa.clientes;
            this.envios = empresa.envios;
        } catch (Exception e){
            System.out.println("Error al cargar la empresa");

        }
    }
    public void guardarEmpresa(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this);
            System.out.println("Empresa guardada exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
