package magicCards;
							//Declaramos el paquete y las librerias a utilizar
import java.util.Scanner;
/*
 * 
 * @author ALEJANDRO HIGUERA MORENO
 * 
 */
public class pruebasMagic1	//Clase MagicCards 
{
	
	static Scanner 		read = new Scanner (System.in);
	
	public static void main(String[] args) 
	  {
		Magic();//Inicio del juego
	  }
	
//-----------------------------------------------------------------------------------------------------------------------------
	//DECLARACION DE VARIABLES GLOBALES PARA LA REALIZACION DEL JUEGO
//-----------------------------------------------------------------------------------------------------------------------------
	//VARIABLES NUMERICAS ENTERAS
	
	static int 			manajugador = 5;							//MANA QUE TIENE EL JUGADOR
	
	static int 			carta;										//VARIABLE UTILIZADA PARA QUE EL USUARIO INTRODUZCA UN NUMERO
	
	static int 			t = 0;										//MARCA EL NUMERO DEL TURNO
	
	static int 			n = 0;										//MARCA POSICIONES (iterador)
	
	static int 			tutorial;
	
	//--------------------------------------------------------------
	//ARRAYS
	
	static String[] 	mano = new String[5];						// AQUI ESTA LAS CARTAS QUE TIENE EL JUGADOR(LA MANO)
	
	static int[]		mana = new int[5];
																	//ESTOS CUATRO VALORES CORRESPONDEN A LOS ATRIBUTOS CON LOS QUE SE FORMAN LAS CARTAS
	static int[] 		vida = new int[5];
	
	static int[] 		ataque = new int[5];
	
	//--------------------------------------------------------------
	//VARIABLES BOOLEANAS
	
	static boolean 		salir = false;								//BUCLE QUE REPITE EL "MENU"
	
	//--------------------------------------------------------------
	//VARIABLES DE TIPO STRING o CHAR
	
	static String 		opcion;										//VARIABLE COMO INPUT DEL USUARIO
		
	//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void PrimerTurno() 
	{																// ESTE METODO SE USA UNA VEZ AL PRINCIPIO SOLO PARA ROBAR 3 CARTAS
		
		System.out.println("TUS PRIMERAS CARTAS SON:");
		System.out.println("");
		
		for ( n = 0; n < 3 ; n++) 									//BUCLE QUE CREA TAN SOLO 3 CARTAS (0, 1, 2)
		{
		
			mana[n] = random(1,6);
			vida[n] = random(1,10);
			ataque[n] = 3;
			mano[n] =" | MANA (" + mana[n] + ") VIDA (" + vida[n] + ") ATAQUE (" + ataque[n] + ")"; //CREACION DE CADA CARTA INDEPENDIENTE
			
		}
		
	}
	
//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void RobarCarta() 
	{																// ESTE METODO SE USARA CADA TURNO PARA ROBAR UNA CARTA SI HAY UN HUECO EN EL ARRAY MANO

		for ( n = 0; n < mano.length  ; n++) 
		{
			
			if(mano[n] == null) 
			{
				System.out.println("");
				System.out.println("Robas carta...");
				mana[n] = random(1,5);
				vida[n] = random(1,9);
				ataque[n] = random(2,16);
				mano[n] =" | MANA (" + mana[n] + ") VIDA (" + vida[n] + ") ATAQUE (" + ataque[n] + ")";
				System.out.println("");
				System.out.println("");
				n = mano.length -1;
				
			}
			
		}
		
	}	
		
//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void ModoQuemar() 
	{
		
		System.out.println("Introduce el NUMERO vinculado a la carta para QUEMARLA");
		carta = 		read.nextInt(); 
    	 	
    	if((carta > 4) || (mano[carta] == null)) 
		{															//SI SE INTRODUCE UN NUMERO FUERA DE RANGO DEL ARRAY O UN HUECO DE LA MANO QUE ESTA VACIO
    																//SE VUELVE AL MENU DE "OPCIONES" JUNTO CON UN MENSAJE DE ERROR
    
    		System.out.println(""); 
    		System.out.println("ESA CARTA NO EXISTE EN TU MANO"); 
    		System.out.println(""); 
    	   	 		 	 		
  		}
		else 
		{
    	 		
    	 	System.out.println(""); 
    	 	System.out.println("Carta numero  (" + carta +  ") quemada! Obtienes 3 de MANA");
    	 															//MOSTRAMOS EL NOMBRE DE LA CRIATURA O CARTA
    	 	mano[carta] = null;										//ELIMINAMOS CARTA
    	 	manajugador += 3; 
    	 	
    	 	t++;													//CONTADOR TURNO, USADO EN CADA METODO DE MODO DE JUEGO PARA IR CONTANDO AL TERMINAR LA JUGADA
   			manajugador += 2;										//CONTADOR MANA JUGADOR, USADO EN CADA METODO DE JUEGO PARA IR CONTANDO AL TERMINAR LA JUGADA
   			
   	    	System.out.println(""); 
   			System.out.println("TURNO " + t); 
   		
   			RobarCarta();											//AL FINAL DE LA JUGADA LLAMAMOS A ROBAR CARTA, 
   						 											//SE USARA EN TODOS LOS MODOS DE JUEGO
		 }
	}
	
//-----------------------------------------------------------------------------------------------------------------------------

	public static void ModoNormal() 
	{
		
		System.out.println("Introduce el NUMERO vinculado a la carta para JUGARLA");
   	 	carta = 		read.nextInt();
   	 		
	   	if((carta > 4) || (mano[carta] == null)){					//SI SE INTRODUCE UN NUMERO FUERA DE RANGO DEL ARRAY O UN HUECO DE LA MANO QUE ESTA VACIO
	   											 					//SE VUELVE AL MENU DE "OPCIONES"
   		
   		System.out.println("");
   	 	System.out.println("ESA CARTA NO EXISTE EN TU MANO");
   	 	System.out.println("");
   	 		
                                         	}
   	
   	 	else if ((mano[carta] != null) && (manajugador >= mana[carta])) 
   	 	{
   		
   	 		System.out.println("");
   	 		System.out.println("--> " + mano[carta] + " <--");
   		
   		 	manajugador -= mana[carta];
   		 	mano[carta] = null;										//ELIMINAMOS CARTA
   		 	
   			t++;
   			manajugador += 2;
   			
   			System.out.println("");
   			System.out.println("TURNO " + t);
   		
   			RobarCarta();
   															   
   	 	} 
   	 	else 
   	 	{
   		
		System.out.println("");
		System.out.println("NO tienes suficiente MANA, para jugar:");
		System.out.println("--> " + mano[carta] + " <--");
		System.out.println("");
   		}
   	 	
	}
	
//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void ModoOverKill() 
	{
		
		System.out.println("Introduce el NUMERO vinculado a la carta para JUGARLA OVERKILL");
   	  	carta = 		read.nextInt();
   	  			
   	  	if((carta > 4) || (mano[carta] == null))
   	  	{
   	  																//SI SE INTRODUCE UN NUMERO FUERA DE RANGO DEL ARRAY O UN HUECO DE LA MANO QUE ESTA VACIO
   	  																//SE VUELVE AL MENU DE "OPCIONES"
   	  		System.out.println("");
   	    	System.out.println("ESA CARTA NO EXISTE EN TU MANO");
   	    	System.out.println("");
   	    	 	
   	  	}
   	  	else if ((manajugador >= mana[carta]) && vida[carta] > 1 ) 
   	  	{
   		  
   	  		System.out.println(mano[carta]);
		
   	  		mano[carta] =" | MANA (" + mana[carta] + ") VIDA (" + (vida[carta] = 1) + ") ATAQUE (" + (ataque[carta] *= 2) + ")";
				
   	  		System.out.println("");
   	  		System.out.println("         |   ");
   	  		System.out.println("         |   ");					//DECORACION, NUNCA VIENE DE MAS
   	  		System.out.println("         V   ");		
   	  		System.out.println("");
   		
   	  		System.out.println("--> " + mano[carta] + " <--");
   		
   	    	manajugador -= mana[carta];
   	    	mano[carta] = null;										//ELIMINAMOS CARTA
   	    		
   	    	t++;
   	 		manajugador += 2;
   	 		
   	 		System.out.println("");
   	 		System.out.println("TURNO " + t);
   	 	
   	 		RobarCarta();
   	  	}
   	  
   	  	else if ((manajugador >= mana[carta]) && vida[carta] == 1 ) 
   	  	{
    	 
   	  		System.out.println("");
   	  		System.out.println("Su VIDA es 1, se juega NORMAL");
   	  		System.out.println("--> "+ mano[carta] + " <--");
   	  		manajugador -= mana[carta];
    		mano[carta] = null;										//ELIMINAMOS LA CARTA		
    		t++;
    		manajugador += 2;
    		System.out.println("");
    		System.out.println("TURNO " + t);
    		RobarCarta();
    			
   	  	} 
   	  	else 
   	  	{
	   
   	  		System.out.println("");
   	  		System.out.println("NO tienes suficiente MANA, para jugar:");
   	  		System.out.println("--> " + mano[carta] + " <--");
   	  		System.out.println("");
   	  	 		
   	  	}
   	  	
	}	
   	  					
	
//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void ModoTanque() 
	{
		
		System.out.println("Introduce el NUMERO vinculado a la carta para JUGARLA TANQUE");
	   	carta = 		read.nextInt();
	   	  		
	   	if((carta > 4) || (mano[carta] == null))
	   	{															//SI SE INTRODUCE UN NUMERO FUERA DE RANGO DEL ARRAY O UN HUECO DE LA MANO QUE ESTA VACIO
		 															//SE VUELVE AL MENU DE "OPCIONES"
	   		System.out.println("");
	   		System.out.println("ESA CARTA NO EXISTE EN TU MANO");
	   		System.out.println("");
	   	   	    	
	   	}	
	 
	   	else if ((manajugador >= (mana[carta] + 2)) && ataque[carta] >= 4 ) 
	   	{
		 
	   		System.out.println(mano[carta]);
	   		mano[carta] ="| MANA (" + (mana[carta] + 2) + ") VIDA (" + (vida[carta] + 5) + ") ATAQUE (" + (ataque[carta] - 4) + ")";	
	   		System.out.println("");
	   		System.out.println("         |   ");
	   		System.out.println("         |   ");					//DECORACION, NUNCA VIENE DE MAS
	   		System.out.println("         V   ");
	   		System.out.println("");
	   		System.out.println("--> " + mano[carta] + " <--");
	   		manajugador -= (mana[carta] + 2);
	   		mano[carta] = null;										//SE ELIMINA LA CARTA	
	   		t++;
	   		manajugador += 2;	
	   		System.out.println("");
	   		System.out.println("TURNO " + t);
	   		RobarCarta();
	   		
	 	}
	 	else if ((manajugador >= mana[carta]) && ataque[carta] < 4 ) 
	 	{
		 
	 		System.out.println("");
			System.out.println("Su ATAQUE queda NEGATIVO, no se puede JUGAR");
			System.out.println("--> " + mano[carta] + " <--");	//MOSTRAMOS CARTA Y SUS VALORES
	    	System.out.println("");
	
	 	} 
	 	else 
	 	{
		 
	 		System.out.println("");
			System.out.println("NO tienes suficiente MANA, para jugar:");
			System.out.println("--> " + mano[carta] + " <--");
			System.out.println("");
	
	 	}
	   	
	 }
					   
					  
//-----------------------------------------------------------------------------------------------------------------------------
	public static void Tutorial() 								//Metodo para mostrar las reglas o ir directamente al juego
	{
		System.out.println("------ BIENVENIDO A MAGIC ------");		//INTRODUCCION AL JUEGO
		System.out.println("REALIZADO POR ALEJANDRO HIGUERA MORENO");
		System.out.println("======================================");
		
		
		System.out.println("---> ¿QUIERES LEER LAS REGLAS U OMITIR EL TUTORIAL E IR DIRECTAMENTE AL JUEGO? <---\n"
				+ "1 --> LEER REGLAS\n"
				+ "2 --> OMITIR EL TUTORIAL (Pasar a jugar directamente)");
		tutorial = read.nextInt();
			
		if (tutorial == 1)
		{
		
			System.out.println("REGLAS BASICAS DEL JUEGO:\n"
					+ "0.-Comenzaras con 5 de mana, 3 cartas y tendras la opcion en todo momento de pasar turno hasta que llenes la mano.\n"
					+ "1.-Recibiras 2 de mana por cada turno que pase.\n"
					+ "2.-Recibiras 3 de mana por cada carta que quemes.\n"
					+ "3.-No podras jugar en ciertos modos si no tienes los atributos suficientes para ello.\n"
					+ "4.-El juego finaliza cuando tu quieras, tan solo presiona <ABANDONAR>.\n"
					+ "5.-Cuando quemes una carta, esta se reemplazara con otra que robes.\n"
					+ "6.-Tus cartas estan numeradas de 0, a 4 como maximo\n"
					+ "7.-EXPLICACION DE LOS MODOS DE JUEGO:\n"
					+ "\n"
					+ "		7.1-Modo Normal: debes tener mayor o igual numero que exige la carta para jugarla, se descuenta la cantidad de mana de la carta.\n"
					+ "		7.2-Modo OverKill: si tienes mana igual o superior al coste de la carta, podras jugar en este modo. Duplica tu ataque, pero tu vida se reduce a 1.\n"
					+ "					En el caso de que tengas 1 de vida, la carta se jugara en modo normal sin duplicar su ataque.\n"
					+ "		7.3-Modo Tanque: si tienes mana acumulado igual o superior al coste de la carta +2, podras jugar en este modo.\n"
					+ "					La vida de tu carta aumenta 5 puntos, pero el ataque a 4, siempre y cuando este no quede negativo.\n"
					+ "\n"
					+ "8.-Pasarlo bien :)\n");
				
		}
		else if(tutorial == 2)
		{
								
		}
		else 
		{
			System.out.println("NUMERO DE OPCION INCORRECTO, PUES ALA, TE QUEDAS SIN REGLAS, PERO VAS A JUGAR!...");
				
		}

	}
//-----------------------------------------------------------------------------------------------------------------------------
	
	public static void ImprimirCartas() 
	{															//MUESTRA LAS CARTAS EN MANO
		for ( n = 0; n < mano.length ; n++) 
		{
			if(mano[n] == null) 
			{
				break;
			}
		System.out.print(n +"--> " + mano[n] + "\n");
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------

	public static void Magic() 
	{

		Tutorial();
		
		System.out.println("======================================");
		System.out.println("------ COMIENZA EL JUEGO  ------");
																	//FIN INTRODUCCION
		System.out.println("");
		System.out.println("");
		System.out.println("");
		PrimerTurno();												//Comienza el primer turno

		while(!salir) 												//Bucle principal, el cual da vida a la infinidad de este juego
		{
			System.out.println("Tu mano es:");
			System.out.println("");
			ImprimirCartas();										//LLAMAMOS AL METODO PARA MOSTRAR LA MANO ANTES DE ELEGIR OPCIONES	
			System.out.println("");
			System.out.println("===========================");
			System.out.println("Tienes "+ manajugador + " de MANA");//SE MUESTRA EL MANA DEL JUGADOR
			System.out.println("===========================");
			System.out.println("");
			System.out.println("Elige una accion:");
			System.out.println("");
			System.out.print("1 --> Pasar turno\n");				//PASAR TURNO 									1
			System.out.print("2 --> QUEMAR carta\n");				//QUEMAR CARTA 									2
			System.out.print("3 --> Jugar carta en modo NORMAL\n");	//JUGAR MODO_NORMAL								3
			System.out.println("4 --> Jugar carta en modo OVERKILL");//JUGAR MODO_OVERKILL							4
			System.out.print("5 --> Jugar carta en modo TANQUE\n");	//JUGAR MODO_TANQUE								5
			System.out.print("6 --> ABANDONAR");					//ABANDONAR JUEGO, SE ROMPE BUCLE PRINCIPAL		6
			System.out.println("");
			opcion = 	read.next();								//SE RECOGE EL INPUT DEL USUARIO
		
		
			System.out.println("");
			System.out.println("TURNO " + t);						//MUESTRA TURNO EN EL QUE NOS ENCONTRAMOS
	
			switch(opcion) 											//Switch que nos permite la variacion entre las distintas opciones o modos de juego
			{
			     case "1":
			    	boolean pasarTurno = true;
			    	while (pasarTurno) 								//WHILE QUE DECIDE SI PASAR DE TURNO O NO
			    	{
			    		for ( n = 0; n < mano.length  ; n++) 
			    		{ 											//FOR QUE RECORRE EL ARRAY DE TU PRECIOSA MANO PARA VER SI TE QUEDAN ESPACIOS LIBRES 
			    			
			    			if(mano[n] == null) 					//SI HAY ESPACIO LIBRES EN TU DIVINA MANO, TE COLOCA UNA CARTA POR !FUERZA BRUTA !
			    			{
			    				System.out.println("");
								System.out.println("Pasas turno...");
								System.out.println("");
								t++;								//AUMENTAMOS EN 1 LOS TURNOS QUE LLEVAMOS
								
								RobarCarta();
								manajugador += 2;					//AUMENTAMOS EL MANA +2 POR RONDA
							    System.out.println("");
							    System.out.println("TURNO " + t);	//MUESTRA TURNO EN EL QUE NOS ENCONTRAMOS
							    n = mano.length - 1;
							    pasarTurno = false;
			    				
			    			}
			    			else if(mano[mano.length -1] != null) 	//SI LA MANO ESTA LLENA, LA TIENES LLENA, NO HAY MAS
			    			{
			    				System.out.println("=====================");
			    				System.out.println("TIENES LA MANO LLENA! RECUERDA, SOLO PUEDES TENER 5 CARTAS EN LA MANO, QUIEN TE CREES, HULK?");
			    				System.out.println("=====================");
			    				pasarTurno = false;
			    				break;
			    			}
			    			
			    		}
			    		
			    	}
		 	
					break; //END CASE 1
			     case "2": 
			    	 
			    	ModoQuemar();									//Modo quemar la carta, +3 mana, +1 carta nueva sustituida por la recien quemada
			    	
			    	break; //END CASE 2
			     case "3": 
			    	 
			    	 ModoNormal(); 									//Modo NORMAL, gastas tu mana por la carta y esta se destruye, posteriormente vuelves a robar una carta
			    	 
			    	 break; //END CASE 3
			     case "4": 
			    	 
			    	 ModoOverKill(); 								//Modo OVERKILL, +3 mana, +1 carta nueva sustituida por la recien quemada 
			    	 
			    	 break; //END CASE 4
			     case "5": 
			    	 
			    	 ModoTanque(); 									//Modo TANQUE, +3 mana, +1 carta nueva sustituida por la recien quemada 
			    	 
			    	 break; //END CASE 5
			     case "6": 
			    	 
			    	 System.out.println("---- FIN DEL JUEGO ----"); 
			    	 salir = true;//SALIMOS DEL WHILE
			    	 
			    	 break; //END CASE 6
			    	 			
			     default:											//SI EL USUARIO ESCOGE UN VALOR FUERA DEL RANGO (mensaje de error)
			    	 
			    	System.out.println("NUMEROS que incluyan opciones"); 
			    	System.out.println(""); 
			    	break; 
			} 
			
		}	 
 	
	} 
	
	
//-----------------------------------------------------------------------------------------------------------------------------
	public static int random(int min, int max)						//FUNCION PARA SACAR LOS VALORES ALEATORIOS DE LAS CARTAS (MANA, VIDA Y ATAQUE)
	{
		int aux = 		(int) Math.floor(Math.random() * (max - min) ) + min; 
		return aux; 
	}
	
}

