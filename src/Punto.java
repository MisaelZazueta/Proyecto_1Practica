import java.util.Scanner;

public class Punto {
    public int abcisa, ordenada;
    private int  puntosTotal, i, maxPuntos, limites;
    private Punto puntos[];

    public Punto(int limites) {
        this.limites = limites;
        maxPuntos = (int) (this.limites * this.limites * 0.3);
    }

    public Punto(int abcisa, int ordenada) {
        this.abcisa = abcisa;
        this.ordenada = ordenada;
    }

    public void pedirPuntos() {
        System.out.println("Puntos maximos a graficar: " + maxPuntos);
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Introduzca la cantidad de puntos a graficar: ");
            String puntosT = in.nextLine();
            try {
                puntosTotal = Integer.parseInt(puntosT);
            } catch (Exception e) {
                i = 0;
                System.out.println();
            }
            if (puntosTotal > maxPuntos) {
                System.out.println("Error. Introduzca un valor no mayor a: " + maxPuntos);
                i = 0;
            } else i = 1;
        } while (i == 0);
        System.out.println("Puntos a graficar: " + puntosTotal);
        puntos = new Punto[puntosTotal];
        for (int j = 0; j < puntosTotal; j++) {
            do {
                System.out.print("Introduzca la abcisa (posicion en x) para el punto numero " + (j + 1) + ": ");
                String abcisaT = in.nextLine();
                try {
                    abcisa = Integer.parseInt(abcisaT);
                } catch (Exception e) {
                    i = 0;
                    System.out.println();
                }
                if (abcisa > limites || abcisa <= 0) {
                    System.out.println("Error. Introduzca un valor no mayor a: " + limites);
                    i = 0;
                } else i = 1;
            } while (i == 0);
            do {
                System.out.print("Introduzca la ordenada (posicion en y) para el punto numero " + (j + 1) + ": ");
                String ordenadaT = in.nextLine();
                try {
                    ordenada = Integer.parseInt(ordenadaT);
                } catch (Exception e) {
                    i = 0;
                    System.out.println();
                }
                if (ordenada > limites || ordenada <= 0) {
                    System.out.println("Error. Introduzca un valor no mayor a: " + limites);
                    i = 0;
                } else i = 1;
            } while (i == 0);
            Punto punto = new Punto(abcisa, ordenada);
            puntos[j] = punto;
        }
        Plano x = new Plano(puntos, puntosTotal, limites);
        x.mostrarPuntos();
    }
}