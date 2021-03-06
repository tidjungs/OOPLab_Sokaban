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

    @Test
    public void testLoadBoardBoxPositions() {
        assertArrayEquals(new int[] {1, 2}, smallBoard.getBoxPosition(0));
        assertArrayEquals(new int[] {2, 4}, smallBoard.getBoxPosition(1));
    }

    @Test
    public void testPlayerPositionCheck() {
        assertFalse(smallBoard.hasPlayerAt(0,0));
        assertTrue(smallBoard.hasPlayerAt(1,4));
    }

    @Test
    public void testPlayerPositionCheckAfterChange() {
        smallBoard.setPlayerPosition(2, 3);
        assertFalse(smallBoard.hasPlayerAt(1,4));
        assertTrue(smallBoard.hasPlayerAt(2, 3));
    }

    @Test
    public void testPlayerPositionCheckOutside() {
        assertFalse(smallBoard.hasPlayerAt(-10, 1));
        assertFalse(smallBoard.hasPlayerAt(1, -10));
        assertFalse(smallBoard.hasPlayerAt(1, 100));
        assertFalse(smallBoard.hasPlayerAt(100, 1));
    }

    @Test
    public void testExitPositionCheck() {
        assertFalse(smallBoard.hasExitAt(0, 0));
    }

    @Test
    public void testExitPositionCheckOutsideBoard() {
        assertFalse(smallBoard.hasExitAt(-10, -1));
        assertFalse(smallBoard.hasExitAt(100, 1));
        assertFalse(smallBoard.hasExitAt(1, 500));
    }

    @Test
    public void testBoxesPositionCheckOutsideBoard() {
        assertFalse(smallBoard.hasBoxAt(-10, -1));
        assertFalse(smallBoard.hasBoxAt(100, 1));
        assertFalse(smallBoard.hasBoxAt(1, 500));
    }

    @Test
    public void testToStringWithInitialPositions() {
        assertEquals(		
                " #####\n"+
                "#*O.A#\n"+
                "#...O#\n"+
                "##..*#\n"+
                " #####\n",
                smallBoard.toString());
    }
    
    @Test
    public void testToStringWithNewPlayerAndBoxesPositions() {
    	smallBoard.setPlayerPosition(2, 2);
    	smallBoard.setBoxPosition(0, 2, 1);
        assertEquals(		
                " #####\n"+
                "#*...#\n"+
                "#OA.O#\n"+
                "##..*#\n"+
                " #####\n",
                smallBoard.toString());
    }

    @Test
    public void testGetBoardNextItem() {
        assertEquals('O', smallBoard.getBoardNextItem(1, 1, GameBoard.Direction.RIGHT));
        assertEquals('#', smallBoard.getBoardNextItem(1, 1, GameBoard.Direction.LEFT));
        assertEquals('.', smallBoard.getBoardNextItem(1, 1, GameBoard.Direction.DOWN));
        assertEquals('A', smallBoard.getBoardNextItem(1, 3, GameBoard.Direction.RIGHT));
    }
	 
}
