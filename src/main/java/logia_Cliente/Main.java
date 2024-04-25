/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logia_Cliente;

import java.util.ArrayList;
import java.util.Scanner;
import logica_Negocio.Contacto;

/**
 *
 * @author 1002963131
 */
public class Main {

    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("****** Zona Virtual S.A. ********");
            System.out.println("******* Aplicación de Lista de Contactos ********");
            System.out.println("1. Agregar un Nuevo Contacto");
            System.out.println("2. Mostrar Lista de Contactos");
            System.out.println("3. Buscar contacto por nombre");
            System.out.println("4. Ordenar por Burbuja a partir de los nombres");
            System.out.println("5. Ordenar por Inserción a partir de los números Telefónicos");
            System.out.println("6. Salir");
            System.out.print("Digite una opción: ");

            opcion = scan.nextInt();
            scan.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    mostrarContactos();
                    break;
                case 3:
                    buscarContacto();
                    break;
                case 4:
                    ordenarPorBurbuja();
                    break;
                case 5:
                    ordenarPorInserción();
                    break;
                case 6:
                    System.out.println("******salir******");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");

            }

        } while (opcion != 6);
    }

    private static void agregarContacto() {
        System.out.print("Ingrese el nombre del contacto que va a registrar"+":");
        String Nombre = scan.nextLine();
        System.out.print("Ingrese el número de teléfono del contacto que desea registrar: ");
        int Num_Cel = scan.nextInt();
        scan.nextLine();
        Contacto contacto = new Contacto(Nombre, Num_Cel);
        listaContactos.add(contacto);
        System.out.println("El contacto ah sido agregado exitosamente");

    }

    private static void mostrarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("En la lista no se han registrado contactos");
        } else {
            System.out.println("Lista de Contactos:");
            for (int i = 0; i < listaContactos.size(); i++) {
                Contacto contacto = listaContactos.get(i);
                System.out.println((i + 1) + ". Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNum_Cel());
            }
        }
    }

    private static void buscarContacto() {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombreBuscado = scan.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < listaContactos.size(); i++) {
            Contacto contacto = listaContactos.get(i);
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("El contacto se encuentra en la posicion " + (i + 1) + ":");
                System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getNum_Cel());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El contacto no se encuentra en la lista.");
        }
    }

    private static void ordenarPorBurbuja() {
        int n = listaContactos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String nombre1 = listaContactos.get(j).getNombre();
                String nombre2 = listaContactos.get(j + 1).getNombre();
                if (nombre1.compareToIgnoreCase(nombre2) > 0) {
                    Contacto temp = listaContactos.get(j);
                    listaContactos.set(j, listaContactos.get(j + 1));
                    listaContactos.set(j + 1, temp);
                }
            }
        }
        System.out.println("Lista de contactos ordenada por nombre:");
        mostrarContactos();
    }

    private static void ordenarPorInserción() {
        int n = listaContactos.size();
        for (int i = 1; i < n; ++i) {
            Contacto cel= listaContactos.get(i);
            int j = i - 1;
            while (j >= 0 && listaContactos.get(j).getNum_Cel() > cel.getNum_Cel()) {
                listaContactos.set(j + 1, listaContactos.get(j));
                j = j - 1;
            }
            listaContactos.set(j + 1, cel);
        }
        System.out.println("Lista de contactos ordenada por número de teléfono:");
        mostrarContactos();
    }
}
