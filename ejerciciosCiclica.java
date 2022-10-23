package ciclicas;
import java.util.Scanner;
public class ejerciciosCiclica
{
	Scanner read = new Scanner(System.in);
	public static void main(String[] args) 
	{
		ejerciciosCiclica test = new ejerciciosCiclica();
		test.Ans();
	}
	public void Ans() 
	{
		//Declaracion de variables utilizadas proximamente en el codigo
		int num1;
		int num2;
		int res;
		int ans = 0;
		int contador = 0;
		int operacion;
		int seguir;
		int resAnt;
		int cond1;
		
		while (contador < 1)
		{
			System.out.println("Elige una operacion a realizar mediante numeros del 1 al 4:\n 1) Sumar\n 2) Restar\n 3) Multiplicar\n 4) Dividir");
			operacion = read.nextInt();
			if ((operacion < 1)||(operacion > 4)){
				System.out.println("Numero de opcion incorrecto");
				contador++;
				
			}else {
				
				switch (operacion) {
				case 1://Sumar
					System.out.println("¿Tienes algun resultado anterior almacenado? 1(SI) 2(NO) " );
					resAnt = read.nextInt();
					if (resAnt == 1) {
						System.out.println("Elige un numero que sumar al resultado anterior: ");
						num1 = read.nextInt();
						res = ans + num1;
						System.out.println("El resultado de la operacion es: " + ans + " + " + num1 + " = " + res + "\n");
						ans += res;
						res = 0;
						System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
						seguir = read.nextInt();
						if (seguir == 1) {
							
						}else if (seguir == 2){
							System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
							contador++;
						}else {
							System.out.println("Accion no identificada...");
							contador++;
							}	
					}else {
					System.out.println("Elige el primer numero");
					num1 = read.nextInt();
					System.out.println("Elige el segundo numero");
					num2 = read.nextInt();
					res = num1 + num2;
					System.out.println("El resultado de la operacion es: " + num1 + " + " + num2 + " = " + res + "\n");
					ans += res;
					res = 0;
					System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
					seguir = read.nextInt();
					if (seguir == 1) {
						
					}else if (seguir == 2){
						System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
						contador++;
					}else {
						System.out.println("Accion no identificada...");
						contador++;
						}
					}
					break;
//-------------------------------------------------------------------------------------------------------------------------------					
												//FINALIZACION CASO --SUMAR--
//-------------------------------------------------------------------------------------------------------------------------------					
				case 2://Restar
					System.out.println("¿Tienes algun resultado anterior almacenado? 1(SI) 2(NO) " );
					resAnt = read.nextInt();
					//CONTINUAR -SI- HAY UN RESULTADO ANTERIOR
					if (resAnt == 1) {
						System.out.println("Quieres que el resultado anterior reste(1) o sea restado(2)");
						cond1 = read.nextInt();
						if (cond1 == 1) {
							System.out.println("Elige el nuevo numero: ");
							num1 = read.nextInt();
							res = num1 - ans;
							System.out.println("El resultado de la operacion es: " + num1 + " - " + ans + " = " + res + "\n");
							ans += res;
							res = 0;
							System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
							seguir = read.nextInt();
							if (seguir == 1) {
								
							}else if (seguir == 2){
								System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
								contador++;
							}else {
								System.out.println("Accion no identificada...");
								contador++;
								}	
						}else if (cond1 == 2) {//
							System.out.println("Elige el nuevo numero: ");
							num1 = read.nextInt();
							res = ans - num1;
							System.out.println("El resultado de la operacion es: " + ans + " - " + num1 + " = " + res + "\n");
							ans += res;
							res = 0;
							System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
							seguir = read.nextInt();
							if (seguir == 1) {
								
							}else if (seguir == 2){
								System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
								contador++;
							}else {
								System.out.println("Accion no identificada...");
								contador++;
								}	
						}else {
							contador++;
							}
					//CONTINUAR SI -NO- HAY UN RESULTADO ANTERIOR
					}else if (resAnt == 2){
					System.out.println("Elige el primer numero");
					num1 = read.nextInt();
					System.out.println("Elige el segundo numero");
					num2 = read.nextInt();
					res = num1 - num2;
					System.out.println("El resultado de la operacion es: " + num1 + " - " + num2 + " = " + res + "\n");
					ans += res;
					res = 0;
					System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
					seguir = read.nextInt();
						if (seguir == 1) {
							
						}else if (seguir == 2){
							System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
							contador++;
						}else {
							System.out.println("Accion no identificada...");
							contador++;
							}
					}else {
						System.out.println("Accion no identificada...");
						contador++;
					}
					break;
//-------------------------------------------------------------------------------------------------------------------------------					
												//FINALIZACION CASO --RESTAR--
//-------------------------------------------------------------------------------------------------------------------------------
				case 3://Multiplicar
					System.out.println("¿Tienes algun resultado anterior almacenado? 1(SI) 2(NO) " );
					resAnt = read.nextInt();
					if (resAnt == 1) {
						System.out.println("Elige un numero para multiplicarle al resultado anterior: ");
						num1 = read.nextInt();
						res = ans * num1;
						System.out.println("El resultado de la operacion es: " + ans + " x " + num1 + " = " + res + "\n");
						ans += res;
						res = 0;
						System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
						seguir = read.nextInt();
						if (seguir == 1) {
							
						}else if (seguir == 2){
							System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
							contador++;
						}else {
							System.out.println("Accion no identificada...");
							contador++;
							}	
					}else {
					System.out.println("Elige el primer numero");
					num1 = read.nextInt();
					System.out.println("Elige el segundo numero");
					num2 = read.nextInt();
					res = num1 * num2;
					System.out.println("El resultado de la operacion es: " + num1 + " x " + num2 + " = " + res + "\n");
					ans += res;
					res = 0;
					System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
					seguir = read.nextInt();
					if (seguir == 1) {
						
					}else if (seguir == 2){
						System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
						contador++;
					}else {
						System.out.println("Accion no identificada...");
						contador++;
						}
					}
					break;
//-------------------------------------------------------------------------------------------------------------------------------					
												//FINALIZACION CASO --MULTIPLICAR--
//-------------------------------------------------------------------------------------------------------------------------------
				case 4://Restar
					System.out.println("¿Tienes algun resultado anterior almacenado? 1(SI) 2(NO) " );
					resAnt = read.nextInt();
					//CONTINUAR -SI- HAY UN RESULTADO ANTERIOR
					if (resAnt == 1) {
						System.out.println("Quieres que el resultado anterior reste(1) o sea restado(2)");
						cond1 = read.nextInt();
						if (cond1 == 1) {
							System.out.println("Elige el nuevo numero: ");
							num1 = read.nextInt();
							res = num1 - ans;
							System.out.println("El resultado de la operacion es: " + num1 + " - " + ans + " = " + res + "\n");
							ans += res;
							res = 0;
							System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
							seguir = read.nextInt();
							if (seguir == 1) {
								
							}else if (seguir == 2){
								System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
								contador++;
							}else {
								System.out.println("Accion no identificada...");
								contador++;
								}	
						}else if (cond1 == 2) {//
							System.out.println("Elige el nuevo numero: ");
							num1 = read.nextInt();
							res = ans - num1;
							System.out.println("El resultado de la operacion es: " + ans + " - " + num1 + " = " + res + "\n");
							ans += res;
							res = 0;
							System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
							seguir = read.nextInt();
							if (seguir == 1) {
								
							}else if (seguir == 2){
								System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
								contador++;
							}else {
								System.out.println("Accion no identificada...");
								contador++;
								}	
						}else {
							contador++;
							}
					//CONTINUAR SI -NO- HAY UN RESULTADO ANTERIOR
					}else if (resAnt == 2){
					System.out.println("Elige el primer numero");
					num1 = read.nextInt();
					System.out.println("Elige el segundo numero");
					num2 = read.nextInt();
					res = num1 - num2;
					System.out.println("El resultado de la operacion es: " + num1 + " - " + num2 + " = " + res + "\n");
					ans += res;
					res = 0;
					System.out.println("Quieres seguir realizando operaciones: 1(SI) 2(NO)");
					seguir = read.nextInt();
						if (seguir == 1) {
							
						}else if (seguir == 2){
							System.out.println("Perfecto! Hasta luego pase buen día, vuelva pronto!");
							contador++;
						}else {
							System.out.println("Accion no identificada...");
							contador++;
							}
					}else {
						System.out.println("Accion no identificada...");
						contador++;
					}
					break;
//-------------------------------------------------------------------------------------------------------------------------------					
												//FINALIZACION CASO --DIVIDIR--
//-------------------------------------------------------------------------------------------------------------------------------
				
				}//End mainSwitch
			}//End mainElse
		}//End mainWhile
	}//End ans
}//Enc class
