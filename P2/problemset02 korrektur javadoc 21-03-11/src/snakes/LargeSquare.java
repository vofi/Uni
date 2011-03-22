/*
 * Jonas von Felten: 	10-105-427
 * Lukas Keller:		10-113-736
 */
package snakes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LargeSquare extends Square implements ISquare 
{
	private List<Player> players;
	
	public LargeSquare(Game game, int position) 
	{
		super(game, position);
		players = new ArrayList<Player>();
		
	}

//<<<<<<< HEAD
	public boolean isLargeSquare()
	{
		return true;
	}
	
	public void enter(Player player)
	{
		assert !players.contains(player);
		players.add(player);
	}
	
	public void enterMorePlayers(List<Player> playersFromTrapDoor,int transport)
	{
		for(int i=0; i<playersFromTrapDoor.size();i++)
		{
			playersFromTrapDoor.get(i).moveForward(transport);
		}
	}
	public void leave(Player player)
	{
		assert players.contains(player);
		players.remove(player);
	}
	
	public boolean isOccupied()
	{
		return false;
	}
	
	public ISquare landHereOrGoHome()
	{
		return this;
	}
	protected String squareLabel() 
	{
		return "L " +Integer.toString(position) +" L";
	}
	
	@Override
	protected String player() {
		StringBuffer buffer = new StringBuffer();
		for (Player player : players) {
			buffer.append("<" + player + ">");
		}
		return buffer.toString();
	}

//=======
}
//>>>>>>> 2d9a0cf9d5f4bf0df74411fb38790f63896e4cfc
