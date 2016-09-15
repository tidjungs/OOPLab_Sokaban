import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class GameBoardMovementTest {
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
    public void playerMoveSuccess() {
    	smallBoard.movePlayer(GameBoard.Direction.LEFT);
        assertEquals(1, smallBoard.getPlayerRow());
        assertEquals(3, smallBoard.getPlayerCol());
    	smallBoard.movePlayer(GameBoard.Direction.DOWN);
        assertEquals(2, smallBoard.getPlayerRow());
        assertEquals(3, smallBoard.getPlayerCol());
    }

    @Test 
    public void playerMoveBoxSuccess() {
        smallBoard.movePlayer(GameBoard.Direction.LEFT);
        smallBoard.moveBox(GameBoard.Direction.LEFT);
        smallBoard.movePlayer(GameBoard.Direction.LEFT);
        assertTrue(smallBoard.hasBoxAt(1, 1));
    }
}