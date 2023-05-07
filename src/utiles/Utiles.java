package utiles;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Reloj;

public class Utiles {
    /**
     * Devuelve un arraylist de tantos relojes como especifiques
     * @param cantidad
     * @return
     */
    public static ArrayList<Reloj> factoriaRelojes(int cantidad) {
        ArrayList<Reloj> relojes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            relojes.add(new Reloj());
        }
        return relojes;
    }

    public static int aleatorio(int min,int max) {
        return (int)(Math.random()*(max+1-min)+min);
    }

    /**Devuelve un mapa de las cantidades
     * Key: posicionAguja Value: cantidad
     * @param relojes
     * @return
     */
    public static HashMap<Integer,Integer> cantidades(ArrayList<Reloj> relojes) {
        HashMap<Integer,Integer> cantidades = new HashMap<>();

        for (int i = 0; i < relojes.size(); i++) {
            int posicionAguja = relojes.get(i).getPosicionAguja();
            //se suma 1 a la cantidad de la posicion aguja, si es 0 se pone 1
            if (cantidades.containsKey(posicionAguja)) {
                cantidades.put(posicionAguja, cantidades.get(posicionAguja)+1);
            } else{
                cantidades.put(posicionAguja, 1);
            }
        }
        return cantidades;
    }

    public static HashMap<Integer,Double> probabilidades(HashMap<Integer,Integer> cantidades, int total) {
        HashMap<Integer,Double> probabilidades = new HashMap<>();

        for (Integer posicionAguja : cantidades.keySet()) {
            probabilidades.put(posicionAguja, cantidades.get(posicionAguja)*100/(double)total);
        }
        return probabilidades;
    }
}
