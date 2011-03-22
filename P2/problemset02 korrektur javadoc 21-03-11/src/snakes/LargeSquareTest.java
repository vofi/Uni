/*
 * Jonas von Felten: 	10-105-427
 * Lukas Keller:		10-113-736
 */
package snakes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ch.unibe.jexample.JExample;
import ch.unibe.jexample.Given;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JExample.class)
public class LargeSquareTest {
	
	private Player jonas;
	private Player lukas;

	@Test
	public Game newGame() 
	{
		jonas = new Player("Jonas");
		lukas = new Player("Lukas");
		Player[] args = { jonas, lukas };
		Game game = new Game(12, args);
		game.setSquareToLadder(2, 4);
		game.setSquareToLadder(7, 2);
		game.setSquareToLargeSquare(6, game);
		game.setSquareToLargeSquare(10,game);
		game.setSquareToSnake(11, -6);
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jonas.position());
		assertEquals(1, lukas.position());
		assertEquals(jonas, game.currentPlayer());
		return game;
	}

	
	@Given("newGame")
	public Game LargeSquares(Game game)
	{
		assertEquals("[L 6 L]",game.getSquare(6).toString());
		assertEquals("[L 10 L]", game.getSquare(10).toString());
		
		assertEquals("[1<Jonas><Lukas>][2->6][3][4][5][L 6 L][7->9][8][9][L 10 L][5<-11][12]", game.toString());
		
		return game;
	}
	
	@Given("newGame")
	public Game JonasGoToLargeSquare(Game game)
	{
		game.movePlayer(5);
		assertTrue(game.notOver());
		assertEquals(6,jonas.position());
		assertEquals(1,lukas.position());
		assertEquals(lukas,game.currentPlayer());
		assertTrue(!game.getSquare(6).isOccupied());
		return game;
		
	}
	@Given("JonasGoToLargeSquare")
	public Game LukasGoToLargeSquareToo(Game game)
	{
		assertEquals(lukas, game.currentPlayer());
		assertEquals(1, lukas.position());
		
		game.movePlayer(5);
		assertTrue(game.notOver());
	
		assertEquals(6,jonas.position());
		
		assertEquals(6,lukas.position());
		
		assertTrue(!game.getSquare(6).isOccupied());
		
		return game;
		
	}
	
	@Given("newGame")
	public Game isLargeSquareOne(Game game)
	{
		assertTrue(game.getSquare(6).isLargeSquare());
		assertEquals( 6, game.getSquare(6).position());
		return game;
	}
	
	@Given("newGame")
	public Game isLargeSquareTwo(Game game)
	{
		assertTrue(game.getSquare(10).isLargeSquare());
		assertEquals( 10, game.getSquare(10).position());
		return game;
	}
	
	@Given("LukasGoToLargeSquareToo")
	public Game goToNextLargeSquare(Game game)
	{
		game.movePlayer(2);
		assertEquals(8,jonas.position());
		assertEquals(lukas, game.currentPlayer());
		game.movePlayer(4);
		assertTrue(game.getSquare(lukas.position()).isLargeSquare());
		assertEquals(jonas, game.currentPlayer());
		game.movePlayer(2);
		assertTrue(game.getSquare(jonas.position()).isLargeSquare());
		return game;
	}
	
	
	
	
	

}
