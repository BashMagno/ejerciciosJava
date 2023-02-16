package magicPOO;

import java.util.Scanner;

public class Juego
{
	public static void main(String[] args)
	{
		Manager manager = new Manager();
		Scanner scan = new Scanner(System.in);

		manager.robarCarta();
		manager.robarCarta();
		manager.robarCarta();

		int opcion;
		do
		{
			manager.mostrarMano();
			System.out.println("\n==========================");

			System.out.println("\nBienvenido al juego de cartas");
			System.out.println("1. Robar carta");
			System.out.println("2. Quemar carta");
			System.out.println("3. Jugar carta");
			System.out.println("4. Mostrar mano");
			System.out.println("5. Salir");
			System.out.print("Selecciona una opcion: ");

			opcion = scan.nextInt();
			switch (opcion)
			{
			case 1:
				manager.robarCarta();
				break;
			case 2:
				manager.mostrarMano();
				System.out.print("Selecciona el numero de la carta que quieres quemar: ");
				int quemar = scan.nextInt();
				try
				{
					manager.quemarCarta(manager.mano.getMano().get(quemar - 1));
				} catch (IndexOutOfBoundsException e)
				{
					System.out.println("=================");
					System.out.println("Tu mano está vacía");
					System.out.println("=================");
				}
				break;
			case 3:
				manager.mostrarMano();
				System.out.print("Selecciona el numero de la carta que quieres jugar: ");
				int jugar = scan.nextInt();
				System.out.println("Selecciona el modo de juego:");
				System.out.println("1. Modo normal");
				System.out.println("2. Modo Overkill");
				System.out.println("3. Modo Tanque");
				int modo = scan.nextInt();
				manager.jugarCarta(manager.mano.getMano().get(jugar - 1), modo);
				break;
			case 4:
				manager.mostrarMano();
				break;
			}
		} while (opcion != 5);
		System.out.println("¡Hasta la proxima!");
	}
}
