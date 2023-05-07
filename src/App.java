import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Reloj;
import utiles.Utiles;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Si un reloj, cada segundo, mueve su aguja aleatoriamente 1 segundo adelante o hacia atras,"+
             "¿qué probabilidad hay de que despues de 2 segundos, esté en su posición inicial?");

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
