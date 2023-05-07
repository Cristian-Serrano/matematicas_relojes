package utiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Reloj;

/**
 * Este metodo lo ha creado bing chat
 */
public class Metodos {
    public static void metodoMatematico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero de segundos que quieres calcular");
        int n = sc.nextInt();// número de pasos
        sc.close();

        double p = Utiles.binomialCoefficient(n, n/2) * Math.pow(0.5, n);
        System.out.println("Probabilidad de estar en la posición inicial después de " + n + " pasos: " +(p*100)+"%");
    }

    public static void metodoSimulacion() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el numero de segundos que quieres simular (si introduces más de 15 podría tardar un tiempo)");
        int segundos = sc.nextInt();
        sc.close();

        int total = (int)Math.pow(2, segundos);
        ArrayList<Reloj> relojes = new ArrayList<>(Utiles.factoriaRelojes(total));

        //bing chat hizo este bucle
        int grupo = 1;
        for (int s = 0; s < segundos; s++) {
            for (int i = 0; i < relojes.size(); i += grupo*2) {
                for (int j = 0; j < grupo && i+j < relojes.size(); j++) {
                    relojes.get(i+j).avanzarSentidoHorario();
                }
                for (int j = grupo; j < grupo*2 && i+j < relojes.size(); j++) {
                    relojes.get(i+j).avanzarSentidoAntihorario();
                }
            }
            grupo *= 2;
        }

        HashMap<Integer,Integer> cantidades = Utiles.cantidades(relojes);
        HashMap<Integer,Double> probabilidades = Utiles.probabilidades(cantidades, total);

        System.out.println(relojes);
        System.out.println("\nTotal de posibilidades: "+total);
        System.out.println("\n"+cantidades.toString()+" Las cantidades de cada posicion de aguja");
        System.out.println("\n"+probabilidades.toString()+" Las probabilidades de cada posicion de aguja");
    }
}
