import com.sun.security.jgss.GSSUtil;
import exepciones.*;
import negocios.*;

import java.util.Scanner;

public class Main {
    static Empresa empresa = new Empresa();
    public static void main(String[] args) {
        try{

            empresa.cargarEmpresa("empresa.dat");

                if (empresa == null) {
                    empresa = new Empresa(); // Si no existe, crea una nueva instancia
                }

            Scanner scanner = new Scanner(System.in);

            int opcion;



            do {
                System.out.println("1. Agregar cliente, 2. Agregar envio, 3. mostrar envios, 4. mostrar costo total, 5. Salir");
                switch (opcion=scanner.nextInt()) {
                    case 1:
                       agregarCliente(scanner);
                        break;
                    case 2:

                       agregarEnvio(scanner);
                        break;
                    case 3:
                        mostrarEnvios(scanner);
                        break;
                    case 4:
                        mostrarCostoTotal();
                        break;
                    case 5:
                        empresa.guardarEmpresa("empresa.dat");
                        break;
                    default:
                        System.out.println("Opcion invalida");

                        break;

                       }
            }while (opcion!=5);
        } catch (YaExiste e){
            System.out.println("Ya existe el envio");
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    public static void agregarCliente(Scanner scanner){
        System.out.println("Ingrese dni, nombre y telefono del cliente");
        Cliente cliente = new Cliente(scanner.nextInt(), scanner.next(), scanner.nextInt());
        empresa.agregarCliente(cliente);

    }
    public static void agregarEnvio(Scanner scanner){
         System.out.println("Ingrese dni del cliente");
        Cliente cliente=empresa.obtenerCliente(scanner.nextInt());
        if (cliente==null){
            System.out.println("No existe el cliente");
            return;
        }

        System.out.println("Ingrese id, direccion, peso, costo, altura, ancho y estado del envio");
        Envio envio = new Envio(scanner.nextInt(), scanner.next(), scanner.nextDouble(), 0, scanner.nextDouble(), cliente, scanner.nextDouble(), scanner.nextDouble(),0);
        envio.calcularCosto();
        empresa.agregarEnvio(envio);

        cliente.agregarEnvio(envio);
    }
    public static void mostrarEnvios(Scanner scanner){
        System.out.println("Ingrese dni del cliente");
        Cliente cliente=empresa.obtenerCliente(scanner.nextInt());
        if (cliente==null){
            System.out.println("No existe el cliente");
            return;
        }
        for (Envio envio: cliente.getEnvios()){
            System.out.println(envio.getId());
        }
    }
    public static void mostrarCostoTotal(){
        System.out.println(empresa.costoTotal());
    }

}