package sokoban;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class GameBoardTest {
	static String smallBoardMap[] = {
			" #####",
		    "#*O.A#",
		    "#...O#",
		    "##..*#",
		    " #####"
	};
	private GameBoard smallBoard;
	 
	@Before
	public void setUp() {
		smallBoard = new GameBoard(smallBoardMap);
	}
	 
	@Test
    public void testLoadBoardProperties() {
        assertEquals(5, smallBoard.getHeight());
        assertEquals(6, smallBoard.getWidth());
    }

    @Test
    public void testLoadBoardPlayerPosition() {
        assertEquals(1, smallBoard.getPlayerRow());
        assertEquals(4, smallBoard.getPlayerCol());
    }

    @Test
    public void testLoadBoardNumBoxes() {
        assertEquals(2, smallBoard.getNumBoxes());
    }
 
	 
}
