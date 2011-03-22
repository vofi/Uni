/*
 * Jonas von Felten: 	10-105-427
 * Lukas Keller:		10-113-736
 */
package snakes;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Lukas Keller
 * @author Jonas von Felten
 *
 * Any square of the snakes-and-ladders-game. Responsible for any type of square {@link Square}, {@link FirstSquare}, {@link LastSquare},  {@link Ladder}, {@link Snake}, {@link LargeSquare} and {@link TrapDoor}
 * Responsible for finding the <code>ISquare</code> that a {@link Player} will ultimately be placed on if he steps on this square.
 * <br />- For {@link Square}: It makes sure that only one player at a time can occupy this field and knows the {@link Player} that currently occupies it.
 * <br />- For {@link FirstSquare}: It is the first Square of the {@link Game} board. It is able to contain multiple players at once.
 * <br />- For {@link LastSquare}: It is the last Square of the {@link Game} board. If a {@link Player} reaches this square. That player wins the {@link Game}.
 * <br />- For {@link Ladder}: If a {@link Player} reaches this special square he will go to its destination. 
 * <br />- For {@link Snake}: If a {@link Player} reaches this special square he will go to its destination.
 * <br />- For {@link LargeSquare}: It is able to contain multiple players at once.
 * <br />- For {@link TrapDoor}: It can hold a given number of {@link Player}s at once. If more than this given number of {@link Player}s are on it, it sends all {@link Player}s to the given {@link LargeSquare}.
 * 

 *  
 */
public interface ISquare {
	/**
	 * Returns the position of this square on the {@link Game} board.
	 * @return the position of this square on the game board, initial position is 1.
	 */
	public int position();
	
	/**
	 * Returns the i<sup>th</sup> square ahead of this one on the {@link Game} board, according to the regular game flow.
	 * Does not take into account special square such as snakes, ladders.
	 * @param Moves to go
	 * @return the square on the i<sup>th</sup> square ahead of this one. Not null.
	 */
	public ISquare moveAndLand(int moves);
	/**
	 * Returns if this square is the {@link FirstSquare} on the {@Game} board.
	 * All {@link Player}s start the game on this first square.
	 * @see ISquare#isLastSquare()
	 * @return true if this is the first square on the board; false otherwise.
	 */
	public boolean isFirstSquare();
	/**
	 * Returns if this square is the {@link LastSquare} on the {@link Game} board.
	 * The {@link Player} that first reaches the last square on the board wins the game (winning condition).
	 * @see ISquare#isFirstSquare()
	 * @see ISquare#isTrapDoor()
	 * @see ISquare#isLargeSquare()
	 * @return true if this is the last square on the board; false otherwise.
	 */
	public boolean isLastSquare();
	/**
	 * Returns if this square is the {@link LargeSquare} on the {@link Game} board.
	 * The large Square is able to contain multiple players at once.
	 * @see ISquare#isFirstSquare()
	 * @see ISquare#isTrapDoor()
	 * @return true if this is a large square on the board; false otherwise.
	 */
	public boolean isLargeSquare();
	/**
	 * Returns if this square is the {@link TrapDoor} on the {@link Game} board.
	 * The TrapDoor can hold a given number of {@link Player}s at once. If more than this given number of {@link Player}s are on it, it sends all {@link Player}s to the given {@link LargeSquare}.
	 * @see ISquare#isFirstSquare()
	 * @see ISquare#isLargeSquare()
	 * @return true if this is a trapDoor on the board; false otherwise.
	 */
	public boolean isTrapDoor();
	/**
	 * Checks if this trapDoorSquare has more than its maxPlayerOnTrapDoor players on it
	 * @see ISquare#isOccupied()
	 * @return return true if more than <code>maxPlayerOnTrapDoor</code>  Players are on this TrapDoor; false otherwise.
	 */
	public boolean isTrapTooFull();
	/**
	 * calls enter(player) for every player on this {@link TrapDoor}. 
	 * @param players List of Player Objects
	 * @param transport Integer, Distance to go
	 */
	public void enterMorePlayers(List<Player> players,int transport);
	/**
	 * Informs this square that {@link Player} has entered this square.
	 * If this square is already occupied, this may fail. If <code>player</code> is null, the square is informed it's empty.
	 * @see ISquare#leave
	 * @see ISquare#enter(Player)
	 * @see ISquare#enterMorePlayers(List, int)
	 * @param player, the player entering the square. May be null.
	 */
	public void enter(Player player);
	/**
	 * Informs this square that {@link Player} is leaving this square.
	 * Here, <code>player</code> may be null, thus making sure that the square is informed that it is empty. This method may fail, but doesn't need to, if <code>player</code> is not currently on this square.
	 * @see ISquare#enter
	 * @see ISquare#enterMorePlayers(List, int)
	 * @param player, the player leaving the square. May be null. 
	 */
	public void leave(Player player);
	/**
	 * Returns if it is any {@link Player} on this at the moment.
	 * It will always return false for {@link LargeSquare}.
	 * It will return true if the max. numbers of {@link Player}s are on this {@link TrapDoor}.
	 * @return true if a {@link Player} is on this square; false otherwise.
	 */
	public boolean isOccupied();
	/**
	 * Gets the permission to land on this square
	 * 
	 * if it is a normal square if this.isOccupied() false then return this, else return firstSquare
	 * if it is a LargeSquare  or TrapDoor it returns itself
	 * @return ISquare
	 */
	public ISquare landHereOrGoHome();
	
}
