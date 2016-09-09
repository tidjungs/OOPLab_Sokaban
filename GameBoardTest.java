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
}
