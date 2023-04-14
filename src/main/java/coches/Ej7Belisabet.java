/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package coches;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eli
 */
/*
A.- Generación del fichero vehiculos.txt
Usando la jerarquía de la clase Vehículo, implementa un programa que realice lo siguiente:

    Crea 30 vehículos (10 Turismos, 10 Deportivos y 10 Furgonetas) con valores de tu elección y guárdalos en una lista de objetos tipo Vehiculo.
    Guarda los vehículos en un fichero de texto llamado “vehículos.txt”, haciendo uso del método polimórfico toString(), teniendo en cuenta que el string devuelto lleve separados los campos del objeto por el carácter dos puntos (:).
    Cada línea del fichero estará compuesta por un número, un espacio, un guión, un espacio y los datos del vehículo en cuestión. El número de cada línea será 0, 1 o 2 si el objeto es un Turismo, un Deportivo o una Furgoneta, respectivamente. 
    Cada vehículo irá en una línea distinta del fichero.
    Ejemplos de líneas, los campos no tienen porqué coincidir con los de tus clases:

0 – 4534JTK:Seat:Ibiza:Blanco:… (Este vehículo sería un Turismo)
1 – 3322FFF:Ford:Kuga:Rojo:… (Este vehículo sería un Deportivo)


B.- Lectura del fichero vehiculos.txt
Realiza un programa que lea los datos fichero vehiculos.txt. Para ello creará una lista de objetos de tipo Vehículo. El programa irá almacenando en la lista los objetos leídos desde el archivo de texto “vehículos.txt”. Una vez cargados todos los datos en la lista, ordena los vehículos por Marca y muestra el resultado por consola.


C.- Generación de turismos.txt, deportivos.txt, furgonetas.txt.
A partir de los datos almacenados en vehiculos.txt, crea tres archivos de texto para almacenar los vehículos del mismo tipo.
*/
public class Ej7Belisabet {

    public static void main(String[] args) {
        // Crea 30 vehículos (10 Turismos, 10 Deportivos y 10 Furgonetas) con valores de tu elección y guárdalos en una lista de objetos tipo Vehiculo.
        List<Vehiculo> listaVehiculos= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Turismo());
            listaVehiculos.add(new Deportivo());
            listaVehiculos.add(new Furgoneta());
        }
        
        ServiciosFicheros.crearFichero(crearStringVehiculos(listaVehiculos), "vehiculos.txt");
        ServiciosFicheros.leerArchivo("vehiculos.txt");
        
    }
    
    public static String crearStringVehiculos(List<Vehiculo> listaVehiculos){
    int contador=0;
    String tmp="";
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo get = listaVehiculos.get(i);
            tmp+="%s - %s".formatted(String.valueOf(tipoVehiculo(get)), get.toString());
            tmp+="\n";
                     
        }
    return tmp;
    }
    
    public static int tipoVehiculo(Vehiculo vehiculo){
        return (vehiculo instanceof Turismo) ? 0 
                : (vehiculo instanceof Deportivo) ? 1 : 2;
    }
}
