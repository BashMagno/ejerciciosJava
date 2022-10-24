package arrays;
import java.util.Scanner;
public class EjercicioArray {
	Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		EjercicioArray test = new EjercicioArray();
		//test.ejercicioArray1();
		test.ejercicioForArray4();
	}//END main

	public void ejercicioArray1() {
		System.out.println("Diga el numero 1");
		int num1 = read.nextInt();
		System.out.println("Diga el numero 2");
		int num2 = read.nextInt();
		System.out.println("Diga el numero 3");
		int num3 = read.nextInt();
		int media;
		
		
		int [] array = {
				num1,
				num2,
				num3
		};
		media = ( num1 + num2 + num3 ) / 3;
		System.out.println("La media de los tres numeros es: " + media + " y los numeros que tecleaste fueron: " + num1 +" " + num2 + " " + num3);
	}//END ejArr1
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//	EJERCICIO ARRAY 1
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void ejercicioForArray1() {
		
		
	}//END ejArrFor1
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//	EJERCICIO ARRAY  FOR1
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void ejercicioForArray2() {
		
		
	}//END ejArrFor2
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//	EJERCICIO ARRAY FOR 2
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void ejercicioForArray3() {
		
		
	}//END ejArrFor3
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//	EJERCICIO ARRAY FOR 3
//----------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void ejercicioForArray4() {
	

		System.out.println("Eliga el numero 1");
		short n1 = read.nextShort();
		System.out.println("Eliga el numero 2");
		short n2 = read.nextShort();
		System.out.println("Eliga el numero 3");
		short n3 = read.nextShort();
		System.out.println("Eliga el numero 4");
		short n4 = read.nextShort();
		System.out.println("Eliga el numero 5");
		short n5 = read.nextShort();
		System.out.println("Eliga el numero 6");
		short n6 = read.nextShort();
		
		short[] matriz = {n1, n2, n3, n4, n5, n6};
		
		for(Short i = 5; i >= 0; i--) {
			System.out.println("Los numeros almacenados, de forma regresiva son " + matriz[i]);
		}
	}//END ejArrFor4
	
//----------------------------------------------------------------------------------------------------------------------------------------------------
//	EJERCICIO ARRAY FOR  4
//-----------------------------------------------------------------------------------------------------------------------------------------------------

}//END CLASS
