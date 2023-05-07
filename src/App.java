import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import modelo.Reloj;
import utiles.Metodos;
import utiles.Utiles;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Si un reloj, cada segundo, mueve su aguja aleatoriamente 1 segundo adelante o hacia atras,"+
        "¿qué probabilidad hay de que despues de 2 segundos, esté en su posición inicial?");
        System.out.println("Hay dos maneras de responder a esta pregunta, haciendo todas las posibilidades simulandolas, o utilizando las matemáticas, elige una opción");
        System.out.println("\nEscribe un numero y pulsa ENTER:\n1 Simulacion\n2 Enfoque matemático");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            Metodos.metodoSimulacion();
        }
        else {
            Metodos.metodoMatematico();
        }
    }
}
