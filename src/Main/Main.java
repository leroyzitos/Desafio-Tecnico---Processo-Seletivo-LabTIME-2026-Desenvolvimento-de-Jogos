package Main;

import javacode.nave.Nave;
import javacode.ticket2.Tripulante;
//import java.ticket3.*;

public class Main {

    public static void main(String[] args) {
        Nave nave = new Nave("Jackdaw");

        Tripulante t1 = new Tripulante("Andre Alvarez Gomide", 'M', 23, 3);
        Tripulante t2 = new Tripulante("Anna Miyura Rodrigues", 'F', 20, 2);
        Tripulante t3 = new Tripulante("Lucy Zeckowski Andersen", 'F', 40, 1);
        Tripulante t4 = new Tripulante("Marcos Zheng", 'M', 34, 4);
        Tripulante t5 = new Tripulante("Márcia Almeida Rodrigues", 'F', 22, 6);
        Tripulante t6 = new Tripulante("Lorenzo Fleury Da Fiore", 'M', 19, 5);

        nave.registrarTripulante(t1);
        nave.registrarTripulante(t2);
        nave.registrarTripulante(t3);
        nave.registrarTripulante(t4);
        nave.registrarTripulante(t5);
        nave.registrarTripulante(t6);

        System.out.println(nave);
    }
}