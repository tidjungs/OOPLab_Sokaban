import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        // String gameMap[] = {
        //     " #####",
        //     "#*O.A#",
        //     "#...O#",
        //     "##..*#",
        //     " #####"
        // };
        String gameMap[] = {
            " ##### ",
            "#*A#..#",
            "#.*O..#",
            "#.O...#",
            "####..#",
            "    ## "
        };
 
        GameBoard board = new GameBoard(gameMap);
        Scanner scanner = new Scanner(System.in);
        int round = 0;
 
        while(true) {
            System.out.println("Round: " + round);
            System.out.println(board);
            System.out.println();
 			
 			if(board.isSolved()) {
                System.out.println("You won.");
                break;
            }
            
            System.out.print("Your choice (awsd - movement, q - quit):");
 
            String choiceStr = scanner.nextLine();
 
            if(choiceStr.length() == 0) {
                continue;
            }
 
            char choice = choiceStr.toLowerCase().charAt(0);
 
            if(choice == 'q') {
                System.out.println("Good bye");
                break;
            }
 
            GameBoard.Direction dir = GameBoard.Direction.STILL;
            switch(choice) {
            case 'a':
                dir = GameBoard.Direction.LEFT;
                break;
            case 'w':
                dir = GameBoard.Direction.UP;
                break;
            case 's':
                dir = GameBoard.Direction.DOWN;
                break;
            case 'd':
                dir = GameBoard.Direction.RIGHT;
                break;
            }
            if(board.canBoxMove(dir)) {
            	board.moveBox(dir);
            }
            
            if(board.canPlayerMove(dir)) {
                board.movePlayer(dir);
            }

            round++;
        }
    }
}