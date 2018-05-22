package elmadani.marouane;

import java.util.Scanner;

public class Main2Players {
    public static void main(String[] args) {
        boolean replay = true;
        int i = 1;
        while (replay) {
            // Creation of the boards//
            Board B1P1 = new Board();
            Board B2P1 = new Board();
            Board B1P2 = new Board();
            Board B2P2 = new Board();
            Board B1OfCurrPlayer = new Board();
            Board B2OfCurrPlayer = new Board();
            Board B1OfEnemy = new Board();
            Board B2OfEnemy = new Board();
            B1P1.initializeBoard();
            B2P1.initializeBoard();
            B1P2.initializeBoard();
            B2P2.initializeBoard();
            B1OfCurrPlayer.initializeBoard();
            B2OfCurrPlayer.initializeBoard();
            B1OfEnemy.initializeBoard();
            B2OfEnemy.initializeBoard();

            // Creation of ships types //
            typeOfShip Carrier = new typeOfShip("Carrier", 5);
            typeOfShip Battleship = new typeOfShip("elmadani", 4);
            typeOfShip Cruiser = new typeOfShip("Cruiser", 3);
            typeOfShip Submarine = new typeOfShip("Submarine", 3);
            typeOfShip Destroyer = new typeOfShip("Destroyer", 2);

            //Creation of ships //
            Ship Carrier1 = new Ship("", "", Carrier, 0);
            Ship Carrier2 = new Ship("", "", Carrier, 0);
            Ship Battleship1 = new Ship("", "", Battleship, 0);
            Ship Battleship2 = new Ship("", "", Battleship, 0);
            Ship Cruiser1 = new Ship("", "", Cruiser, 0);
            Ship Cruiser2 = new Ship("", "", Cruiser, 0);
            Ship Submarine1 = new Ship("", "", Submarine, 0);
            Ship Submarine2 = new Ship("", "", Submarine, 0);
            Ship Destroyer1 = new Ship("", "", Destroyer, 0);
            Ship Destroyer2 = new Ship("", "", Destroyer, 0);

            //Creation of players //
            Player player1 = new Player("Player 1", B1P1, B2P1, 5);
            Player player2 = new Player("Player 2", B1P2, B2P2, 5);


            //Beginning of the game //
            System.out.print("Welcome to the Battlefield ! \n");
            System.out.print("Here is where you can place your battleships\n");
            Board.printBoard(B1P1);
            System.out.print("Player 1 : Where do you want to put the front of your Carrier ?\n");
            System.out.print("Remember : The size of a Carrier is " + Integer.toString(Carrier.getSize()) + "\n");
            Position p1 = Functions.SelectionCase(B1P1);
            System.out.print("Now, where do you want to put the rear of your Carrier ?\n");
            Position p2 = Functions.selectRear(p1, Carrier1, B1P1);
            Carrier1 = Board.putShip(p1, p2, Carrier1, B1P1);
            Board.printBoard(B1P1);
            System.out.print("Where do you want to put the front of your Battleship ?\n");
            System.out.print("Remember : The size of a Battleship is " + Integer.toString(Battleship.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P1);
            System.out.print("Now, where do you want to put the rear of your Battleship ?\n");
            p2 = Functions.selectRear(p1, Battleship1, B1P1);
            Battleship1 = Board.putShip(p1, p2, Battleship1, B1P1);
            Board.printBoard(B1P1);
            System.out.print("Remember : The size of a Cruiser is " + Integer.toString(Cruiser.getSize()) + "\n");
            System.out.print("Where do you want to put the front of your Cruiser ?\n");
            p1 = Functions.SelectionCase(B1P1);
            System.out.print("Now, where do you want to put the rear of your Cruiser ?\n");
            p2 = Functions.selectRear(p1, Cruiser1, B1P1);
            Cruiser1 = Board.putShip(p1, p2, Cruiser1, B1P1);
            Board.printBoard(B1P1);
            System.out.print("Where do you want to put the front of your Submarine ?\n");
            System.out.print("Remember : The size of a Submarine is " + Integer.toString(Submarine.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P1);
            System.out.print("Now, where do you want to put the rear of your Submarine ?\n");
            p2 = Functions.selectRear(p1, Submarine1, B1P1);
            Submarine1 = Board.putShip(p1, p2, Submarine1, B1P1);
            Board.printBoard(B1P1);
            System.out.print("Finally, where do you want to put the front of your Destroyer ?\n");
            System.out.print("Remember : The size of a Destroyer is " + Integer.toString(Destroyer.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P1);
            System.out.print("Now, where do you want to put the rear of your Destroyer ?\n");
            p2 = Functions.selectRear(p1, Destroyer1, B1P1);
            Destroyer1 = Board.putShip(p1, p2, Destroyer1, B1P1);
            System.out.print("Player 1 placed his ships successfully\n");
            System.out.print("Now it's time for Player 2 to place his ships\n");
            System.out.print("Here is where you can place your battleships\n");
            Board.printBoard(B1P2);
            System.out.print("Player 2 : Where do you want to put the front of your Carrier ?\n");
            System.out.print("Remember : The size of a Carrier is " + Integer.toString(Carrier.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P2);
            System.out.print("Now, where do you want to put the rear of your Carrier ?\n");
            p2 = Functions.selectRear(p1, Carrier2, B1P2);
            Carrier2 = Board.putShip(p1, p2, Carrier2, B1P2);
            Board.printBoard(B1P2);
            System.out.print("Where do you want to put the front of your Battleship ?\n");
            System.out.print("Remember : The size of a Battleship is " + Integer.toString(Battleship.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P2);
            System.out.print("Now, where do you want to put the rear of your Battleship ?\n");
            p2 = Functions.selectRear(p1, Battleship2, B1P2);
            Battleship2 = Board.putShip(p1, p2, Battleship2, B1P2);
            Board.printBoard(B1P2);
            System.out.print("Where do you want to put the front of your Cruiser ?\n");
            System.out.print("Remember : The size of a Cruiser is " + Integer.toString(Cruiser.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P2);
            System.out.print("Now, where do you want to put the rear of your Cruiser ?\n");
            p2 = Functions.selectRear(p1, Cruiser2, B1P2);
            Cruiser2 = Board.putShip(p1, p2, Cruiser2, B1P2);
            Board.printBoard(B1P2);
            System.out.print("Where do you want to put the front of your Submarine ?\n");
            System.out.print("Remember : The size of a Submarine is " + Integer.toString(Submarine.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P2);
            System.out.print("Now, where do you want to put the rear of your Submarine ?\n");
            p2 = Functions.selectRear(p1, Submarine2, B1P2);
            Submarine2 = Board.putShip(p1, p2, Submarine2, B1P2);
            Board.printBoard(B1P2);
            System.out.print("Finally, where do you want to put the front of your Destroyer ?\n");
            System.out.print("Remember : The size of a Destroyer is " + Integer.toString(Destroyer.getSize()) + "\n");
            p1 = Functions.SelectionCase(B1P2);
            System.out.print("Now, where do you want to put the rear of your Destroyer ?\n");
            p2 = Functions.selectRear(p1, Destroyer2, B1P2);
            Destroyer2 = Board.putShip(p1, p2, Destroyer2, B1P2);
            System.out.print("Player 2 placed his ships successfully\n");
            Ship listOfShip1[] = {Carrier1, Battleship1, Cruiser1, Submarine1, Destroyer1};
            player1.setListOfShips(listOfShip1);
            Ship listOfShip2[] = {Carrier2, Battleship2, Cruiser2, Submarine2, Destroyer2};
            player2.setListOfShips(listOfShip2);
            System.out.print("Now, it's time to battle ! May the best win !\n");

            // Beginning of the battle //
            boolean allshipssunk = false;
            Player playerPlaying;
            if(i%2 == 0){
                playerPlaying = player2;
                B1OfCurrPlayer = B1P2;
                B2OfCurrPlayer = B2P2;
            }
            else{
                playerPlaying = player1;
                B1OfCurrPlayer = B1P1;
                B2OfCurrPlayer = B2P1;
            }
            while (!allshipssunk) {
                System.out.print("Current player playing : " + playerPlaying.getName() + "\n");
                System.out.print("Here is your current board : \n");
                Board.printBoard(B1OfCurrPlayer);
                System.out.print("Here is your shooting board : \n");
                Board.printBoard(B2OfCurrPlayer);
                System.out.print("Where do you want to shoot ?\n");
                if (playerPlaying.getName().equals(player1.getName())) {
                    Position positionOfShot = Functions.SelectionCaseToShoot();
                    B2P1 = Functions.shoot(positionOfShot, B1P2, listOfShip2, B2P1, player2, 1);
                    player1.setBoardOfShots(B2P1);
                    if (player2.getNbShipsRemaining() == 0) {
                        System.out.print("End of the Game !\n");
                        System.out.print(player1.getName() + " won ! Congratulation !\n");
                        allshipssunk = true;
                        boolean choicemade = false;
                        Scanner sc = new Scanner(System.in);
                        while(!choicemade){
                            System.out.print("Would you like to replay ? Type yes to replay or no to stop the game\n");
                            String choice = sc.next();
                            switch (choice) {
                                case "yes":
                                    i = i + 1;
                                    choicemade = true;
                                    break;
                                case "no":
                                    replay = false;
                                    choicemade = true;
                                    break;
                                default:
                                    System.out.print("Unknown word\n");
                                    break;
                            }
                        }

                    }
                } else {
                    Position positionOfShot = Functions.SelectionCaseToShoot();
                    B2P2 = Functions.shoot(positionOfShot, B1P1, listOfShip1, B2P2, player1, 1);
                    player2.setBoardOfShots(B2P2);
                    if (player1.getNbShipsRemaining() == 0) {
                        System.out.print("End of the Game !\n");
                        System.out.print(player2.getName() + " won ! Congratulation !\n");
                        allshipssunk = true;
                        boolean choicemade = false;
                        Scanner sc = new Scanner(System.in);
                        while(!choicemade){
                            System.out.print("Would you like to replay ? Type yes to replay or no to stop the game\n");
                            String choice = sc.next();
                            switch (choice) {
                                case "yes":
                                    i = i + 1;
                                    choicemade = true;
                                    break;
                                case "no":
                                    replay = false;
                                    choicemade = true;
                                    break;
                                default:
                                    System.out.print("Unknown word\n");
                                    break;
                            }
                        }
                    }
                }
                if (playerPlaying.getName().equals(player1.getName())) {
                    playerPlaying = player2;
                    B1OfCurrPlayer = B1P2;
                    B2OfCurrPlayer = B2P2;
                } else {
                    playerPlaying = player1;
                    B1OfCurrPlayer = B1P1;
                    B2OfCurrPlayer = B2P1;
                }
            }
        }
    }
    }
