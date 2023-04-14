/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coches;

import java.util.Random;

/**
 *
 * @author eli
 */
public class Furgoneta extends Vehiculo{
    //furgoneta su capacidad de carga en kilos y el volumen en metros cúbicos, por ejemplo.
    private int capacidad;
    private double volumen;
    private Random random=new Random();

    public Furgoneta() {
        this.capacidad = random.nextInt(100);
        this.volumen = random.nextDouble(100);
    }

    
    public Furgoneta(int capacidad, double volumen, String bastidor, String matricula) {
        super(bastidor, matricula);
        this.capacidad = capacidad;
        this.volumen = volumen;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getBastidor() {
        return getBastidor();
    }

    public void setBastidor(String bastidor) {
        this.setBastidor(bastidor);
    }

    public String getMatricula() {
        return getMatricula();
    }

    public void setMatricula(String matricula) {
        this.setMatricula(matricula);
    }

    @Override
    public String toString() {
        return """
               Furgoneta
               %s
               capacidad: %s
               volumen:%s""".formatted(super.toString(), capacidad, volumen);
    }

    @Override
    public void encender() {
         System.out.println("La furgoneta hace bruabrabrum bruabrabrum");
        this.setEstaEncendido(true);
    }

    @Override
    public void apagar() {
         System.out.println("La furgoneta se apaga");
        this.setEstaEncendido(false);
    }
    
    
    
}
