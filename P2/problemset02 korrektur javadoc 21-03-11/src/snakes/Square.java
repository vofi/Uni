/*
 * Jonas von Felten: 	10-105-427
 * Lukas Keller:		10-113-736
 */
package snakes;

import java.util.ArrayList;
//FIXED HERE:
import java.util.List;
//DR does not compile! Fix for next week please
public class Square implements ISquare {

	protected int position;
	protected Game game;
	private Player player;

	private boolean invariant() {
		return game != null
			&& game.isValidPosition(position);
	}

	public Square(Game game, int position) {
		this.game = game;
		this.position = position;
		assert invariant();
	}

	public int position() {
		return this.position;
	}

	public ISquare moveAndLand(int moves) {
		//New:
		//assert moves >= 0;
		return game.findSquare(position, moves).landHereOrGoHome();
	}

	protected ISquare nextSquare() {
		return game.getSquare(position+1);
	}

	protected ISquare previousSquare() {
		return game.getSquare(position-1);
	}

	public ISquare landHereOrGoHome() {
		return this.isOccupied() ? game.firstSquare() : this;
	}

	public String toString() {
		return "[" + this.squareLabel() + this.player() + "]";
	}
	
	protected String squareLabel() {
		return Integer.toString(position);
	}
	
	public boolean isOccupied() {
		return player != null;
	}

	public void enter(Player player) {
		assert this.player == null;
		this.player = player;
	}

	public void leave(Player player) {
		assert this.player == player;
		this.player = null;
	}

	public boolean isFirstSquare() {
		return false;
	}

	public boolean isLastSquare() {
		return false;
	}
	
	//New:
	public boolean isLargeSquare()
	{
		return false;
	}
	
	public boolean isTrapDoor()
	{
		return false;
	}
	
	public boolean isTrapTooFull()
	{
		return false;
	}
	
	//FIXED HERER
	public void enterMorePlayers(List<Player> players,int transport)
	{
		//Leer
	}
	
	
	protected String player() {
		return this.isOccupied() ? ("<" + this.player + ">") : "";
	}
	
}
