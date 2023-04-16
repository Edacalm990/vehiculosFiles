package coches;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author venganzaalchocolate
 */
public class ServicioVehiculos {
    public static String crearStringVehiculos(List<Vehiculo> listaVehiculos) {
        String tmp = "";
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo get = listaVehiculos.get(i);
            tmp += "%s - %s".formatted(String.valueOf(tipoVehiculo(get)), get.toString());
            tmp += "\n";

        }
        return tmp;
    }

    public static int tipoVehiculo(Vehiculo vehiculo) {
        return (vehiculo instanceof Turismo) ? 0
                : (vehiculo instanceof Deportivo) ? 1 : 2;
    }

    public static void crearArchivosConListVehiculos(List<Vehiculo> lista) {
        List<Vehiculo> turismos = new ArrayList<>();
        List<Vehiculo> deportivos = new ArrayList<>();
        List<Vehiculo> furgonetas = new ArrayList<>();
        for (Vehiculo vehiculo : lista) {
            if (vehiculo instanceof Turismo) {
                turismos.add((Turismo) vehiculo);
            } else if (vehiculo instanceof Deportivo) {
                deportivos.add((Deportivo) vehiculo);
            } else if (vehiculo instanceof Furgoneta) {
                furgonetas.add((Furgoneta) vehiculo);
            }
        }
        ServiciosFicheros.crearFichero(crearStringVehiculos(turismos), "turismos.txt");
        ServiciosFicheros.crearFichero(crearStringVehiculos(deportivos), "deportivos.txt");
        ServiciosFicheros.crearFichero(crearStringVehiculos(furgonetas), "furgonetas.txt");

    }

    public static List<Vehiculo> crearListVehiculoConArchivo(String fichero) {
        String[] tokens;
        String linea;
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(fichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                listaVehiculos.add(crearVehiculo(tokens));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaVehiculos;
    }

    public static Vehiculo crearVehiculo(String[] lista) {
        String tipoVehiculo = lista[0].substring(0, 1);
        try {
            switch (tipoVehiculo) {
                case "0" -> {
                    return (new Turismo(lista[0].substring(4), lista[1], lista[2], Integer.parseInt(lista[3]), lista[4]));
                }
                case "1" -> {
                    return (new Deportivo(lista[0].substring(4), lista[1], lista[2], Double.parseDouble(lista[3])));
                }
                case "2" -> {
                    return (new Furgoneta(lista[0].substring(4), lista[1], lista[2], Integer.parseInt(lista[3]), Double.parseDouble(lista[4])));
                }
                default ->
                    throw new AssertionError();
            }
        } catch (Exception e) {
            return null;
        }
    }
}
