//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #1
//February 1, 2017

/**
 * The class Board creates a board for the game Battleship containing all the
 * attributes necessary for the game, this includes the positions of all the
 * ships and grenades for each player, and several methods to allow the game to
 * continue as expected depending on inputs from the user
 *
 * @author Kevin Tan, Sagar Patel
 */
public class Board {

    private char[][] board = new char[8][8];

    private int playerShips, computerShips;
    private int playerLossTurn, computerLossTurn;
    private int turnCounter;
    private boolean grenadeHit;

    /**
     * Creates a Board instance that initializes instance variables(char[][]
     * board is filled with '_' to start with an empty board)
     */
    public Board() {
        grenadeHit = false;
        turnCounter = 0;
        playerShips = 0;
        computerShips = 0;
        playerLossTurn = 0;
        computerLossTurn = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
    }

    /**
     * Checks if win condition has been met, i.e. if all ships have been sunk by
     * either player (when playerShips or computerShips is 0)
     *
     * @return false, if all ships for either side have been sunk(game over);
     * true, if game is still ongoing
     */
    public boolean running() {
        if (playerShips == 0) {
            System.out.print("\nGood game, I win let's play again!\n");
            return false;
        } else if (computerShips == 0) {
            System.out.print("Good game, I lost let's play again!\n");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sets random coordinates for computer ships and grenades(while checking if
     * coordinates are not already taken) this is done by replacing the current
     * character in board array with an 'S' or 'G' respectively. Every added
     * ship increments computerShips
     */
    public void randomizeComputerCoordinates() {
        int temp1 = (int) (Math.random() * 8);
        int temp2 = (int) (Math.random() * 8);
        for (int i = 0; i < 6; i++) {
            while (board[temp2][temp1] != '_') {
                temp1 = (int) (Math.random() * 8);
                temp2 = (int) (Math.random() * 8);
            }
            board[temp2][temp1] = 'S';
            computerShips++;
        }
        for (int i = 0; i < 4; i++) {
            while (board[temp2][temp1] != '_') {
                temp1 = (int) (Math.random() * 8);
                temp2 = (int) (Math.random() * 8);
            }
            board[temp2][temp1] = 'G';
        }
    }

    /**
     * Sets a player ship on the board by replacing an 's' into board array at
     * user-defined coordinates, increments playerShips for each ship added
     *
     * @param playerShip coordinates of player ship entered by user
     */
    public void setPlayerShips(String playerShip) {
        board[((int) playerShip.charAt(1)) - 49][((int) playerShip.charAt(0)) - 65] = 's';
        playerShips++;
    }

    /**
     * Sets a player grenade on the board by replacing a 'g' into board array at
     * user-defined coordinates
     *
     * @param playerGrenade coordinates of player grenade entered by user
     */
    public void setPlayerGrenades(String playerGrenade) {
        board[((int) playerGrenade.charAt(1)) - 49][((int) playerGrenade.charAt(0)) - 65] = 'g';
    }

    /**
     * Validates coordinates given by user
     *
     * @param coordinate coordinates entered by user
     * @return true, if coordinates entered are not within the range of 'A' -
     * 'G' AND/OR 1-8 (coordinates out of bounds), else if coordinates at board
     * array are already used; false, if coordinates are valid
     */
    public boolean coordInvalid(String coordinate) {
        if (((int) coordinate.charAt(0)) < 65 || ((int) coordinate.charAt(0)) > 72 || Character.getNumericValue(coordinate.charAt(1)) > 8 || Character.getNumericValue(coordinate.charAt(1)) < 1) {
            System.out.println("Sorry, coordinates are outside the grid. Try again.");
            return true;
        } else if (board[(int) coordinate.charAt(1) - 49][(int) coordinate.charAt(0) - 65] != '_') {
            System.out.println("Sorry, coordinates are already used. Try again.");
            return true;
        }
        return false;
    }

    /**
     * Passes user target coordinates into updateBoard since it is a private
     * method
     *
     * @param coordinate coordinates entered by user
     *
     */
    public void playerMove(String coordinate) {
        updateBoard(coordinate);
    }

    /**
     * Randomizes computer target coordinates and prints it with correct
     * notation
     *
     * Passes coordinates into updateBoard
     */
    public void computerMove() {
        int x = (int) (Math.random() * 7) + 65;
        int y = (int) (Math.random() * 7) + 49;
        String coordinate = Character.toString((char) x) + Character.toString((char) y);
        System.out.print(coordinate + "\n");
        updateBoard(coordinate);
    }

    /**
     * Method used to print 8x8 board in its current state
     *
     * Using letter codes from updateBoard, prints corresponding character to
     * show when element is hit by user/computer.
     *
     * In order to print final board, method also checks for any remaining
     * ships/grenades when the game is over to print location of all elements,
     * and replaces any '*' with an '_'
     *
     */
    public void printUpdatedBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'h' || (board[i][j] == 's' && (playerShips == 0 || computerShips == 0))) {
                    System.out.print("s" + " ");
                } else if (board[i][j] == 'H' || (board[i][j] == 'S' && (playerShips == 0 || computerShips == 0))) {
                    System.out.print("S" + " ");
                } else if (board[i][j] == 'b' || (board[i][j] == 'g' && (playerShips == 0 || computerShips == 0))) {
                    System.out.print("g" + " ");
                } else if (board[i][j] == 'B' || (board[i][j] == 'G' && (playerShips == 0 || computerShips == 0))) {
                    System.out.print("G" + " ");
                } else if (board[i][j] == '*') {
                    if (computerShips == 0 || playerShips == 0) {
                        System.out.print("_ ");
                    } else {
                        System.out.print(board[i][j] + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    /**
     * This method uses turnCounter and a modulus to alternate between user and
     * computer as the game progresses
     *
     * @return true, when it's player's turn; false, when it's computer's turn
     */
    public boolean turn() {
        if (turnCounter % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is used to both increment the turnCounter, and check whether
     * a grenade has been hit.
     *
     * If a grenade is not hit turnCounter is incremented and the game
     * progresses as usual
     *
     * If a grenade is hit it will set grenadeHit back to false and cause a
     * player to go twice since turnCounter is not incremented
     *
     */
    private void checkingTurn() {
        if (!grenadeHit) {
            turnCounter++;
        } else {
            grenadeHit = false;
        }
    }

    /**
     * Returns playerLossTurn
     *
     * @return number of player turns lost to grenades
     */
    public int getPlayerLossTurn() {
        return playerLossTurn;
    }

    /**
     * Returns computerLossTurn
     *
     * @return number of computer turns lost to grenades
     */
    public int getComputerLossTurn() {
        return computerLossTurn;
    }

    /**
     * This method is called when a grenade is hit in order to increment the
     * respective player's turns lost counter
     *
     */
    private void turnsLost() {
        if (turn()) {
            playerLossTurn++;
        } else {
            computerLossTurn++;
        }
    }

    /**
     *
     *
     * Method checks board at target coordinates and updates the board depending
     * on what is at this location, this includes: empty coordinates, a
     * user/computer ship, a user/computer grenade, or a coordinate that's
     * already been called. If ones of these locations are hit, board array will
     * be updated with a '*', 'h/H', or 'b/B' respectively.
     *
     * When a ship is hit, the respective ship counter is decremented
     *
     * When a grenade is hit, turnsLost is called to keep count of turns lost by
     * grenades for each player, turnCounter is incremented and grenadeHit is
     * set to true in order to give the next player two turns in a row
     *
     * When anything other than a grenade is hit, checkingTurn is called to
     * alternate turns between each player(unless a grenade is hit)
     *
     * @param coordinate target coordinates for where to update board array
     */
    private void updateBoard(String coordinate) {
        int x = (int) coordinate.charAt(1) - 49;
        int y = (int) coordinate.charAt(0) - 65;
        if (board[x][y] == '_') {
            System.out.print("nothing.");
            board[x][y] = '*';
            checkingTurn();
        } else if (board[x][y] == 's' || board[x][y] == 'S') {
            System.out.print("ship hit.");
            board[x][y] = ((board[x][y] == 's') ? 'h' : 'H');
            if (board[x][y] == 'h') {
                playerShips--;
            } else {
                computerShips--;
            }
            checkingTurn();
        } else if (board[x][y] == 'g' || board[x][y] == 'G') {
            System.out.print("boom! grenade.");
            board[x][y] = ((board[x][y] == 'g') ? 'b' : 'B');
            turnsLost();
            turnCounter++;
            grenadeHit = true;
        } else {
            System.out.print("position already called.");
            checkingTurn();
        }
        printUpdatedBoard();
    }
}
