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
public class TrapDoorTest {
	
	private Player jonas;
	private Player lukas;
	private Player humanPlayer;

	@Test
	public Game newGame() 
	{
		jonas = new Player("Jonas");
		lukas = new Player("Lukas");
		Player[] args = { jonas, lukas };
		Game game = new Game(12, args);
		game.setSquareToLargeSquare(2, game);
		game.setSquareToTrapDoor(-2, game, 4,1);
		assertTrue(game.notOver());
		assertTrue(game.firstSquare().isOccupied());
		assertEquals(1, jonas.position());
		assertEquals(1, lukas.position());
		assertEquals(jonas, game.currentPlayer());
		return game;
	}
	


	
	@Given("newGame")
	public Game TrapDoor(Game game)
	{
		assertEquals("[TD 2 <- 4 MaxPlayers: 1 TD]",game.getSquare(4).toString());
		assertEquals("[1<Jonas><Lukas>][L 2 L][3][TD 2 <- 4 MaxPlayers: 1 TD][5][6][7][8][9][10][11][12]", game.toString());
		
		return game;
	}
	
	@Given("newGame")
	public Game JonasGoToTrapDoor(Game game)
	{
		game.movePlayer(3);
		
		assertTrue(game.notOver());
		assertEquals(4,jonas.position());
		assertEquals(1,lukas.position());
		assertEquals(lukas,game.currentPlayer());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		assertTrue(!game.getSquare(2).isOccupied());
		return game;
		
	}
	@Given("JonasGoToTrapDoor")
	public Game LukasGoToTrapDoor(Game game)
	{
		assertEquals(lukas, game.currentPlayer());
		assertEquals(1, lukas.position());
		
		game.movePlayer(3);
		assertTrue(game.notOver());
		
		assertEquals(2,jonas.position());
		assertEquals(2,lukas.position());
		
	
		assertTrue(!game.getSquare(2).isOccupied());
		
		
		return game;
		
	}
	
	@Given("JonasGoToTrapDoor")
	public Game LukasGoOverToTrapDoor(Game game)
	{
		assertEquals(lukas, game.currentPlayer());
		assertEquals(1, lukas.position());
		assertEquals(4, jonas.position());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		
		game.movePlayer(6);
		
		assertEquals(4, jonas.position());
		assertEquals(7, lukas.position());
		
		return game;
		
		
	}
	
	@Given("JonasGoToTrapDoor")
	public  Game JonasLeaveTrapDoor(Game game) 
	{
		
		assertEquals(lukas, game.currentPlayer());
		assertEquals(1, lukas.position());
		assertEquals(4, jonas.position());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		
		game.movePlayer(1);
		
		assertEquals(4, jonas.position());
		assertEquals(2, lukas.position());
		
		assertEquals(jonas, game.currentPlayer());
		game.movePlayer(2);
		
		assertEquals(6, jonas.position());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		
		
		return game;
	}
	
	@Given("JonasLeaveTrapDoor")
	public Game LukasGoToTrapDoorAfterJonasLeftIt(Game game)
	{
		assertEquals(lukas, game.currentPlayer());
		assertEquals(2, lukas.position());
		assertEquals(6, jonas.position());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		
		game.movePlayer(2);
		
		assertEquals(4, lukas.position());
		assertTrue(!game.getSquare(4).isTrapTooFull());
		
		return game;
	}
	
	@Given("newGame")
	public Game isTrapDoor(Game game)
	{
		assertTrue(game.getSquare(4).isTrapDoor());
		assertEquals( 4, game.getSquare(4).position());
		return game;
	}
	
	@Given("newGame")
	public Game isLargeSquare(Game game)
	{
		assertTrue(game.getSquare(2).isLargeSquare());
		assertEquals( 2, game.getSquare(2).position());
		return game;
	}
	
	@Given("newGame")
	public Game square7(Game game)
	{
		return game;
	}
	
	
	@Test
	public Game newGame2()
	{
		jonas = new Player("Jonas");
		lukas = new Player("Lukas");
		humanPlayer=new Player("humanPlayer");
		Player[] args = { jonas, lukas, humanPlayer };
		Game game2 = new Game(20, args);
		game2.setSquareToLargeSquare(15, game2);
		game2.setSquareToLargeSquare(2, game2);
		game2.setSquareToTrapDoor(-2, game2, 4,1);
		game2.setSquareToTrapDoor(-6, game2, 8,2);
		game2.setSquareToTrapDoor(5, game2, 10,1);
		
		assertTrue(game2.notOver());
		assertTrue(game2.firstSquare().isOccupied());
		assertEquals(1, jonas.position());
		assertEquals(1, lukas.position());
		assertEquals(1, humanPlayer.position());
		assertEquals(jonas, game2.currentPlayer());
		return game2;
	}
	
	@Given("newGame2")
	public Game squaresTest(Game game2)
	{
		assertTrue(game2.getSquare(15).isLargeSquare());
		assertTrue(game2.getSquare(2).isLargeSquare());
		assertTrue(game2.getSquare(4).isTrapDoor());
		assertTrue(game2.getSquare(8).isTrapDoor());
		assertTrue(game2.getSquare(10).isTrapDoor());
		
		assertTrue(!game2.getSquare(4).isTrapTooFull());
		assertTrue(!game2.getSquare(8).isTrapTooFull());
		assertTrue(!game2.getSquare(10).isTrapTooFull());
		
		return game2;
	}
	
	@Given("newGame2")
	public Game TwoPlayersGoToTrapDoorOnPosition8(Game game2)
	{
		assertEquals(jonas, game2.currentPlayer());
		game2.movePlayer(7);
		assertTrue(!game2.getSquare(8).isTrapTooFull());
		

		assertEquals(1, lukas.position());
		assertEquals(lukas, game2.currentPlayer());
		game2.movePlayer(7);
		
		assertEquals(humanPlayer, game2.currentPlayer());
		game2.movePlayer(1);
		
	
		assertEquals(8, jonas.position());
		assertEquals(8, lukas.position());			//expecte 8 but was 2 why?!
		assertEquals(2, humanPlayer.position());
		
		return game2;
	}
	
	@Given("newGame2")
	public Game OpenTrapDoorOnPosition8(Game game2)
	{
		assertEquals(jonas, game2.currentPlayer());
		game2.movePlayer(7);
		assertTrue(!game2.getSquare(8).isTrapTooFull());
		

		assertEquals(1, lukas.position());
		assertEquals(lukas, game2.currentPlayer());
		game2.movePlayer(7);
		
		assertEquals(1, humanPlayer.position());
		assertEquals(humanPlayer, game2.currentPlayer());
		game2.movePlayer(7);
		
		assertEquals(2, jonas.position());
		assertEquals(2, lukas.position());
		assertEquals(2, humanPlayer.position());
		
		return game2;
	}
	
	@Given("newGame2")
	public Game TwoPlayersGoToTrapDoorOnPosition10(Game game2)
	{
		assertEquals(jonas, game2.currentPlayer());
		game2.movePlayer(9);
		assertTrue(!game2.getSquare(8).isTrapTooFull());
		
		assertEquals(lukas, game2.currentPlayer());
		game2.movePlayer(9);
		assertEquals(15, jonas.position());
		assertEquals(15, lukas.position());
		assertEquals(1, humanPlayer.position());
		assertEquals(humanPlayer, game2.currentPlayer());
		
		return game2;
	}
	

	
	
	
	
	

}
