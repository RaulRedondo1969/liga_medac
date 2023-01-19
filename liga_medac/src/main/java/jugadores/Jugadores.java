/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugadores;

import java.util.ArrayList;

/**
 * POJOS
 * @author usuario
 */
public class Jugadores {
    
    private String nombre; 
    private double peso; 
    private int edad; 
    private ArrayList<Demarcacion> demarcaciones_jugador; // 1-n

    public Jugadores(String nombre, double peso, int edad, ArrayList<Demarcacion> demarcaciones_jugador) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.demarcaciones_jugador = demarcaciones_jugador;
    }

    
    
    public ArrayList<Demarcacion> getDemarcaciones_jugador() {
        return demarcaciones_jugador;
    }

    public void setDemarcaciones_jugador(ArrayList<Demarcacion> demarcaciones_jugador) {
        this.demarcaciones_jugador = demarcaciones_jugador;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
