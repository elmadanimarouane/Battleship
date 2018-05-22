package elmadani.marouane;

public class AIvsAI {
    public static int battleAi(int a, int b) {
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

        // Creation of ships //
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

        // Creation of players //
        Player AI1 = new Player("Player AI1", B1P1, B2P1, 5);
        Player AI2 = new Player("Player AI2", B1P2, B2P2, 5);

        // Placing the ships for the first AI //
        AI.choicePlaceShip(B1P1, Carrier1);
        AI.choicePlaceShip(B1P1, Battleship1);
        AI.choicePlaceShip(B1P1, Cruiser1);
        AI.choicePlaceShip(B1P1, Submarine1);
        AI.choicePlaceShip(B1P1, Destroyer1);

        // Placing the ships for the second AI //
        AI.choicePlaceShip(B1P2, Carrier2);
        AI.choicePlaceShip(B1P2, Battleship2);
        AI.choicePlaceShip(B1P2, Cruiser2);
        AI.choicePlaceShip(B1P2, Submarine2);
        AI.choicePlaceShip(B1P2, Destroyer2);

        // Affecting the ships to the AIs //
        Ship listOfShip1[] = {Carrier1, Battleship1, Cruiser1, Submarine1, Destroyer1};
        AI1.setListOfShips(listOfShip1);
        Ship listOfShip2[] = {Carrier2, Battleship2, Cruiser2, Submarine2, Destroyer2};
        AI2.setListOfShips(listOfShip2);

        // Beginning of the battle //
        boolean allshipssunk = false;
        Player playerPlaying = AI1;
        boolean AI1won = false;
        while (!allshipssunk) {
            if (playerPlaying.getName().equals(AI1.getName())) {
                if (a == 0) {
                    B2P1 = AI.shootingLvl0(B1P2, listOfShip2, B2P1, AI2,0);
                } else if (a == 1) {
                    B2P1 = AI.shootingLvl1(B1P2, listOfShip2, B2P1, AI2,0);
                } else {
                    B2P1 = AI.shootingLvl2(B1P2, listOfShip2, B2P1, AI2,0);
                }

                if (AI2.getNbShipsRemaining() == 0) {
                    AI1won = true;
                    allshipssunk = true;
                }
            } else {
                if (b == 0) {
                    B2P2 = AI.shootingLvl0(B1P1, listOfShip1, B2P2, AI1,0);
                } else if (b == 1) {
                    B2P2 = AI.shootingLvl1(B1P1, listOfShip1, B2P2, AI1,0);
                } else {
                    B2P2 = AI.shootingLvl2(B1P1, listOfShip1, B2P2, AI1,0);
                }

                if (AI1.getNbShipsRemaining() == 0) {
                    allshipssunk = true;
                }
            }
            if(playerPlaying.getName().equals(AI1.getName())){
                playerPlaying = AI2;
            }
            else{
                playerPlaying = AI1;
            }
        }
        int c;
        if (AI1won)
            c = 1;
        else
            c = 0;
        return c;
    }
}
