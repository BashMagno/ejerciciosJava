package magicPOO;

public class Carta
{
	private int mana;
	private int vida;
	private int ataque;

	public Carta(int mana, int vida, int ataque)
	{
		this.mana = mana;
		this.vida = vida;
		this.ataque = ataque;
	}

	public int getMana()
	{
		return mana;
	}

	public int getVida()
	{
		return vida;
	}

	public int getAtaque()
	{
		return ataque;
	}

	public void jugarNormal(int mana)
	{
		System.out.println("Jugando carta normal");
		System.out.println("Coste de mana: " + mana);
		System.out.println("Vida: " + vida);
		System.out.println("Ataque: " + ataque);
	}

	public void jugarOverkill(int mana)
	{
		System.out.println("Jugando carta en modo Overkill");
		System.out.println("Coste de mana: " + mana);
		System.out.println("Vida: 1");
		System.out.println("Ataque: " + 2 * ataque);
	}

	public void jugarTanque(int mana)
	{
		System.out.println("Jugando carta en modo Tanque");
		System.out.println("Coste de mana: " + mana);
		System.out.println("Vida: " + (vida + 5));
		System.out.println("Ataque: " + Math.max(0, ataque - 4));
	}
}