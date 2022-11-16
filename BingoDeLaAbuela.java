package ejercicios;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//Realizado por Alejandro Higuera 

public class Bingo 
{
 
    public static void main(String[] args) 
    {
        int bombo = 0, aux, acertar;
        boolean ordenar = true;
        int[][] carton = new int[3][9];
        int[] sorteo = new int[90];
        //Llamadas
        ordenar(carton);
        bombo = bombos(carton);
        imprimirCuadro(carton);
        int numSorteo = sorteig_Bingo(carton, sorteo);
        mostrarUsados(sorteo, numSorteo);
        imprimirCuadro(carton);
        System.out.println("");
    }
 
    public static void ordenar(int[][] carton) 
    {
        Random ran = new Random();
        int k = 0;
        for (int i = 0; i < carton.length; i++) 
        {
            for (int j = 0; j < carton[i].length; j++) 
            {
                if (i == 0) 
                {
                    if (j == 0) 
                    {
                    	carton[i][j] = ran.nextInt(7) + (10 * j) + 1;
                    } else 
                    {
                    	carton[i][j] = ran.nextInt(8) + (10 * j);
                    }
                } else 
                {
                    if (i == 1) 
                    {
                        k = 0;
                    } else if (i == 2) 
                    {
                        k = 1;
                    }
                    carton[i][j] = ran.nextInt(9 + k) + (10 * j);
                    do {
                    	carton[i][j] = ran.nextInt(9 + k) + (10 * j);
                    } while (carton[i][j] <= carton[i - 1][j]);
                }
            }
        }
        carton[2][8]++;
    }
 
    public static int bombos(int[][] carton) 
    {
    	Random ran = new Random();
    	int support = ran.nextInt(90);
        int bombo = support;
        for (int i = 0; i < carton.length; i++) 
        {
            for (int j = 0; j < carton[i].length; j++) 
            {
            	carton[0 + 1][0] = bombo + ran.nextInt(6);
            	carton[1][0] = bombo + ran.nextInt(6);
            	carton[2][1] = bombo + ran.nextInt(6);
            	carton[0][2] = bombo + ran.nextInt(6);
            	carton[1][3] = bombo + ran.nextInt(6);
            	carton[2][3] = bombo + ran.nextInt(6);
            	carton[2][4] = bombo + ran.nextInt(6);
            	carton[0 + 2][5] = bombo + ran.nextInt(6);
            	carton[1][6] = bombo + ran.nextInt(6);
            	carton[2][6] = bombo + ran.nextInt(6);
            	carton[0 + 1][7] = bombo + ran.nextInt(6);
            	carton[1][8] = bombo + ran.nextInt(6);
            }
        }
        return bombo;
    }
 
    public static void imprimirCuadro(int[][] carton) 
    {
        //Imprimir la interfaz del bingo
        System.out.println("Cartón del BINGO de las abuelas");
        System.out.println("------------------------------------");
        System.out.println("Bingo realizado por Alex HM");
        System.out.println("------------------------------------");
 
        for (int i = 0; i < carton.length; i++) 
        {
            System.out.println(""); 
            for (int j = 0; j < carton[i].length; j++) 
            {
                System.out.printf("%3d ", carton[i][j]);
            }
        }
    }
 
    public static int sorteig_Bingo(int[][] carton, int[] sorteo) 
    {
        Scanner ranlat = new Scanner(System.in);
        Random ran = new Random();
        char opcio = ' ';
        for (int i = 0; i < sorteo.length; i++) 
        {
        	sorteo[i] = numsRepetits(sorteo);
        }
        //Imprimimos los numeros del bingo
        for (int i = 0; i < sorteo.length; i++) 
        {
            System.out.println("");
            System.out.println("");
            System.out.println("------------------------------------");
            System.out.println("Numero nuevo: " + sorteo[i]);
            System.out.println("Continuar? (s/n)");
 
            do {
                opcio = ranlat.next().charAt(0);
                if (opcio != 's' && opcio != 'n') 
                {
                	
                    System.out.println("Introduce 's' o 'n'!");
                }
            } while (opcio != 's' && opcio != 'n');
            numAcierto(sorteo[i], carton); 
            if (opcio == 's') {
                System.out.println("");
 
                if (comproBingo(carton) == true) 
                {
                    System.out.println("BINGOOO!!!");
                    System.out.print("Numeros que han salido: ");
                    return i;
                }
                imprimirCuadro(carton);
            } else if (opcio == 'n')
            {
                System.out.println("Hasta la proxima!!!!!!!");
                System.out.print("Numeros que han salido: ");
                return i;
            }
            System.out.println("");
        }
 
        return sorteo.length;
    }
 
    public static void mostrarUsados(int[] sorteo, int numSorteo) 
    {
        for (int i = 0; i <= numSorteo; i++) 
        {
            System.out.print(sorteo[i] + ",");
        }
        System.out.println();
    }
 
    public static int numsRepetits(int[] sorteo) 
    {
 
        Random ran = new Random();
        int num;
        boolean repetir = true;
 
        do {
        	repetir = false;
            num = ran.nextInt(90) + 1;
            for (int i = 0; i < 90; i++) 
            {
                if (num == sorteo[i]) 
                {
                	repetir = true;
                    break;
                }
            }
        } while (repetir == true);
        return num;
    }
 
    public static void numAcierto(int num, int[][] carton) 
    {
 
        for (int i = 0; i < carton.length; i++) 
        {
            for (int j = 0; j < carton[i].length; j++) 
            {
                if (carton[i][j] == num) {
                	carton[i][j] = -1;
                }
            }
        }
    }
 
    private static boolean comproBingo(int[][] carton) 
    {
        for (int i = 0; i < carton.length; i++) 
        {
            for (int j = 0; j < carton[i].length; j++) 
            {
                if (carton[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
