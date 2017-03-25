//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #1
//February 1, 2017
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        Board game = new Board();

        System.out.println("Hi, let's play Battleship! ");
        //Asks user where they want to place ship, uses verify method in Board to validate coordinates before setting
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the coordinates of your ship #" + (i + 1) + ": ");
            String temp = console.next().toUpperCase();
            while (game.coordInvalid(temp)) {
                System.out.print("Enter the coordinates of your ship #" + (i + 1) + ": ");
                temp = console.next().toUpperCase();
            }
            game.setPlayerShips(temp);
        }
        //Asks user where they want to place grenade, uses verify method in Board to validate coordinates before setting
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter the coordinates of your grenade #" + (i + 1) + ": ");
            String temp = console.next().toUpperCase();
            while (game.coordInvalid(temp)) {
                System.out.print("Enter the coordinates of your grenade #" + (i + 1) + ": ");
                temp = console.next().toUpperCase();
            }
            game.setPlayerGrenades(temp);
        }

        //Sets computer ships and grenades randomly after user is done placing
        game.randomizeComputerCoordinates();
        System.out.println("OK, the computer placed its ships and grenades at random. Let’s play.");

        //Starts game, uses turn() to alternate between player and computer and running() to continue the game until the win condition is met
        //Player turn validates inputted coordinates and passes it into playerMove to update the game
        //Computer turn calls computerMove to random computer target coordinates
        while (game.running()) {
            if (game.turn()) {
                System.out.print("position of your rocket: ");
                String temp = console.next().toUpperCase();
                while (((int) temp.charAt(0)) < 65 || ((int) temp.charAt(0)) > 72 || Character.getNumericValue(temp.charAt(1)) > 8 || Character.getNumericValue(temp.charAt(1)) < 1) {
                    System.out.print("Position out of range, choose another position of your rocket: ");
                    temp = console.next().toUpperCase();
                }
                game.playerMove(temp);
            } else if (!game.turn()) {
                System.out.print("position of my rocket: ");
                game.computerMove();
            }
        }
        //Once win condition is met, prints number of turns lost to grenades after the final board
        System.out.println("\nPlayer lost : " + game.getPlayerLossTurn() + " turn(s) to grenades");
        System.out.println("I lost: " + game.getComputerLossTurn() + " turn(s) to grenades");
    }
}
