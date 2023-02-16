package magicPOO;

public class Manager
{
	private int mana;
	public Mano mano;

	public Manager()
	{
		mana = 5;
		mano = new Mano();
	}

	public void robarCarta()
	{
		if (mano.getMano().size() < 5)
		{
			int mana = (int) (Math.random() * 5 + 1);
			int vida = (int) (Math.random() * 9 + 1);
			int ataque = (int) (Math.random() * 15 + 2);
			mano.agregarCarta(new Carta(mana, vida, ataque));
		}
	}

	public void quemarCarta(Carta carta)
	{
		mano.getMano().remove(carta);
		mana += 3;
	}

	public void jugarCarta(Carta carta, int modo)
	{
		if (mana < carta.getMana())
		{
			System.out.println("No tienes suficiente mana para jugar esta carta");
		} else
		{
			mana -= carta.getMana();
			if (modo == 1)
			{
				carta.jugarNormal(carta.getMana());
			} else if (modo == 2)
			{
				carta.jugarOverkill(carta.getMana());
			} else if (modo == 3)
			{
				carta.jugarTanque(carta.getMana());
			}
		}
	}

	public void mostrarMano()
	{
		System.out.println("Mano actual:");
		for (Carta carta : mano.getMano())
		{
			System.out.println("Carta con mana: " + carta.getMana() + " vida: " + carta.getVida() + " ataque: "
					+ carta.getAtaque());
		}
		System.out.println("Mana disponible: " + mana);
	}
}
