public class GameBoard {
	private int height;
	private int width;
    private String[] baseBoard;
	
    private int playerRow;
    private int playerCol;
    
    private int numBoxes;
    private int[] boxRows;
    private int[] boxCols;

    private int numExit;
    private int[] exitRows;
    private int[] exitCols;

    public enum Direction {
        UP, RIGHT, DOWN, LEFT, STILL
    }
    
	public GameBoard(String[] map) {
        loadBoard(map);
	}
	
	public void loadBoard(String[] map) {
		height = map.length;
        width = map[0].length();
        numBoxes = 0;
        numExit = 0;
        boxRows = new int[height*width];
        boxCols = new int[height*width];

        exitRows = new int[height*width];
        exitCols = new int[height*width];
		
        baseBoard = new String[height];
        for(int r=0; r<height; r++) {
        	baseBoard[r] = "";
        	for(int c=0; c<width; c++) {
        		char mch = map[r].charAt(c);
        		char sch = '.';
        		switch(mch) {
        			case 'A':
        				playerRow = r;
        				playerCol = c;
        				break;
        			case 'O':
        				 boxRows[numBoxes] = r;
                         boxCols[numBoxes] = c;
                         numBoxes++;
                         break;
                    case '*':
                        exitRows[numExit] = r;
                        exitCols[numExit] = c;
                        numExit++;
                        break;
                    default:
                    	sch = mch;
        		}
                baseBoard[r] += sch;
        	}
        }
	}
	
	public int getHeight() {
		return height;
	}
	 
	public int getWidth() {
	    return width;
	}

    public int getPlayerRow() {
        return playerRow;
    }
 
    public int getPlayerCol() {
        return playerCol;
    }

    public void setPlayerPosition(int r, int c) {
        playerRow = r;
        playerCol = c;
    }

    public int getNumBoxes() {
        return numBoxes;
    }

    public int[] getBoxPosition(int i) {
        return new int[] { 
            boxRows[i],
            boxCols[i]
        };
    }

    public void setBoxPosition(int i, int r, int c) {
        boxRows[i] = r;
        boxCols[i] = c;
    }

    public boolean hasPlayerAt(int r, int c) {
        return (playerRow == r) && (playerCol == c);
    }

    public boolean hasBoxAt(int r, int c) {
        for(int i=0; i<numBoxes; i++) {
            if(boxRows[i] == r && boxCols[i] == c) {
                return true;
            }
        }
        return false;    
    }
 
    public boolean hasExitAt(int r, int c) {
        for(int i=0; i<numExit; i++) {
            if(exitRows[i] == r && exitCols[i] == c) {
                return true;
            }
        }
        return false;
    }
 
    public String toString() {
        String stringBoard = "";
        for(int r=0; r<height; r++) {
            for(int c=0; c<width; c++) {
                 if(hasPlayerAt(r, c)) {
                     stringBoard += "A";
                 } else if (hasBoxAt(r, c)) {
                     stringBoard += "O";
                 } else if (hasExitAt(r, c)) {
                     stringBoard += "*";
                 } else {
                     stringBoard += baseBoard[r].charAt(c);
                 }
            }
            stringBoard += "\n";
        }
        return stringBoard;
    }

    public char getBoardNextItem(int r, int c, Direction dir) {

        r += getRowDiff(dir);
        c += getColDiff(dir);

        if (hasBoxAt(r, c)) {
            return 'O';
        } else if (hasExitAt(r, c)) {
            return '*';
        } else if (hasPlayerAt(r ,c)) {
            return 'A';
        } else {
            return baseBoard[r].charAt(c);
        }
    }

  
    
    public void moveBox(Direction dir) {
        int r = playerRow + getRowDiff(dir);
        int c = playerCol + getColDiff(dir);
        for (int i=0; i<numBoxes; i++) {
            int[] box = getBoxPosition(i);
            if (box[0] == r && box[1] == c) {
                setBoxPosition(i, box[0] + getRowDiff(dir), box[1] + getColDiff(dir));
            } 
        }        
    }

    public void movePlayer(Direction dir) {
    	playerRow += getRowDiff(dir);
    	playerCol += getColDiff(dir);
    }

    public boolean canBoxMove(Direction dir) {
        int r = playerRow + getRowDiff(dir);
        int c = playerCol + getColDiff(dir);
        return hasBoxAt(r, c) && getBoardNextItem(r, c, dir) != '#';
    }

    public boolean canPlayerMove(Direction dir) {
        return canPlayerStepOn(getBoardNextItem(playerRow, playerCol, dir));
    }

    public boolean canPlayerStepOn(char item) {
        return (item == '.') || (item == '*') || (item == ' ');
    }
    
    public int getColDiff(Direction dir) {
        switch(dir) {
        case LEFT:
            return -1;
        case RIGHT:
            return 1;
        default:
            return 0;
        }
    }
 
    public int getRowDiff(Direction dir) {
        switch(dir) {
        case UP:
            return -1;
        case DOWN:
            return 1;
        default:
            return 0;
        }
    }
}
