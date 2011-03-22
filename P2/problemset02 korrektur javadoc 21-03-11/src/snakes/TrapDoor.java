/*
 * Jonas von Felten: 	10-105-427
 * Lukas Keller:		10-113-736
 */
package snakes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class TrapDoor extends LargeSquare implements ISquare 
{
	private int transport;
	private int maxPlayerOnTrapDoor;
	private List<Player> playersOnTrapDoor;
	
	private boolean invariant() 
	{
		return isValidTransport(transport);
	}

	private boolean isValidTransport(int transport) 
	{
		return transport != 0 && game.isValidPosition(position + transport);
	}
	
	public TrapDoor(int transport, Game game, int position, int maxPlayerOnTrapDoor)
	{
		super(game, position);
		
		playersOnTrapDoor = new ArrayList<Player>();
		
		assert isValidTransport(transport);
		this.transport = transport;
		this.maxPlayerOnTrapDoor=maxPlayerOnTrapDoor;
		assert invariant();
	}
	
	public boolean isLargeSquare()
	{
		return false;
	}
	
	public boolean isTrapDoor()
	{
		return true;
	}
	
	public void leave(Player player)
	{
		assert playersOnTrapDoor.contains(player);
		if (!this.isTrapTooFull())
		{
			playersOnTrapDoor.remove(player);
		}
	}
	
	public void enter(Player player)
	{
		playersOnTrapDoor.add(player);
		if (!playersOnTrapDoor.contains(player))
		{
			playersOnTrapDoor.add(player);
		}
		if(this.isTrapTooFull()==true)
		{
			this.destination().enterMorePlayers(playersOnTrapDoor,transport);
			
			for(Player playerRemove:playersOnTrapDoor)
			{
				this.leave(playerRemove);

			}
		}
		
	}
	
	protected String squareLabel()
	{
		return "TD " +(position+transport) +" <- "+Integer.toString(position) + " MaxPlayers: " +this.maxPlayerOnTrapDoor +" TD";
	}
	
	protected ISquare destination() {
		return game.getSquare(position+transport);
	}

	public boolean isOccupied()
	{
		if (playersOnTrapDoor.size()>1)
			return true;
		else
			return false;
	}
	
	public boolean isTrapTooFull()
	{
		if(playersOnTrapDoor.size()>maxPlayerOnTrapDoor)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	protected String player() {
		StringBuffer buffer = new StringBuffer();
		for (Player player : playersOnTrapDoor) {
			buffer.append("<" + player + ">");
		}
		return buffer.toString();
	}
	
}