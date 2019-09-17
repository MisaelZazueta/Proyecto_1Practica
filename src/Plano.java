import java.util.Scanner;

public class Plano {
    public int limites;
    private int i, puntosTotal;
    public Punto puntos[];

    public Plano(Punto[] puntos, int puntosTotal, int limites) {
        this.puntos = puntos;
        this.puntosTotal = puntosTotal;
        this.limites = limites;
    }

    public Plano() {

    }

    public void pedirLimites() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Introduzca el valor de los limites de los ejes: ");
            String limitesEntero = in.nextLine();
            try{
                limites= Integer.parseInt(limitesEntero);
            }catch (Exception e){
                i = 0;
                System.out.println();
            }
            if(limites < 10 || limites > 15){
                System.out.println("Error. Introduzca un valor de 10 a 15.");
                i = 0;
            }
            else
                i = 1;
        }while (i == 0);
    }
    public void mostrar() {
        System.out.println();
        System.out.println("y");
        for (int j = limites; j >= 0; j--) {
            System.out.println();
            if(j <= limites && j != 0) {
                for (int i = 0; i < limites; i++) {
                    if (i == 0) {
                        if (j > 9)
                            System.out.print(j  + "|");
                        else
                            System.out.print(j + " |");
                    }
                    System.out.print("__");
                    System.out.print("|");
                }
            }
            else if (j == 0) {
                for (int k = 1; k <= limites; k++) {
                    if(k == 1)
                        System.out.print("    "+ k);
                    else {
                        if(k > 9)
                            System.out.print(" " + k);
                        else
                            System.out.print("  " + k);
                    }
                }
                System.out.print("   x");
                System.out.println();
            }
        }
        Punto lim = new Punto(limites);
        lim.pedirPuntos();
    }
    public void mostrarPuntos(){
        System.out.println();
        System.out.println("y");
        for (int j = limites; j >= 0; j--) {
            System.out.println();
            if (j <= limites && j != 0) {
                for (int i = 1; i <= limites; i++) {
                    int x = 0;
                    if (i == 1) {
                        if (j > 9)
                            System.out.print(j + "|");
                        else
                            System.out.print(j + " |");
                    }
                    for (int k = 0; k < puntosTotal; k++)
                        if (puntos[k].ordenada == j && puntos[k].abcisa == i) {
                            System.out.print(" O ");
                            System.out.print("|");
                            x = 1;
                        }
                    if (x == 0) {
                        System.out.print("___");
                        System.out.print("|");
                    }
                }
            }
            if (j == 0) {
                for (int k = 1; k <= limites; k++) {
                    if (k == 1)
                        System.out.print("    " + k);
                    else {
                        if (k > 9)
                            System.out.print("  " + k);
                        else
                            System.out.print("   " + k);
                    }
                }
                System.out.print("    x");
                System.out.println();
            }
        }
    }
}