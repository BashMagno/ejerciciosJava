package magicPOO;

import java.util.ArrayList;
import java.util.List;

public class Mano
{
	private List<Carta> mano;

	public Mano()
	{
		mano = new ArrayList<>();
	}

	public void agregarCarta(Carta carta)
	{
		mano.add(carta);
	}

	public List<Carta> getMano()
	{
		return mano;
	}
}