package elmadani.marouane;

import java.util.ArrayList;
import static java.lang.Math.abs;
public class Board {
    public Position[][] BoardOfPlayer = new Position[11][11];

    public static void printBoard(Board B)
    {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        for(int i = 0; i < 11; i++)
        {
            for(int j = 0; j < 11; j++)
            {
                if(i == 0 && j == 0){
                    System.out.print("  ");
                }
                else if(j == 0){
                    System.out.print(B.BoardOfPlayer[i][j].getNum());
                    if(i != 10){
                        System.out.print(" ");
                    }
                }
                else if(i == 0){
                    System.out.print(B.BoardOfPlayer[i][j].getCharacter()+" ");
                }

                else if(B.BoardOfPlayer[i][j].isOccupied() && B.BoardOfPlayer[i][j].isMissileshot()){
                    System.out.print(ANSI_GREEN + "X " + ANSI_RESET);
                }

                else if(B.BoardOfPlayer[i][j].isOccupied() && !B.BoardOfPlayer[i][j].isMissileshot()){
                    System.out.print(ANSI_BLACK + "X " + ANSI_RESET);
                }

                else if(!B.BoardOfPlayer[i][j].isOccupied() && B.BoardOfPlayer[i][j].isMissileshot()){
                    System.out.print(ANSI_RED + "X " + ANSI_RESET);
                }

                else  {
                    System.out.print(ANSI_BLUE + "0 " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    void initializeBoard(){

        // initializing the positions //
        for(int i = 0; i<=10;i++){
            for(int j = 0; j<=10; j++) {
                Position p = new Position("",0);
                this.BoardOfPlayer[i][j] = p;
                if(j == 1){
                    this.BoardOfPlayer[i][j].setCharacter("A");
                }
                else if(j == 2){
                    this.BoardOfPlayer[i][j].setCharacter("B");
                }
                else if(j == 3){
                    this.BoardOfPlayer[i][j].setCharacter("C");
                }
                else if(j == 4){
                    this.BoardOfPlayer[i][j].setCharacter("D");
                }
                else if(j == 5){
                    this.BoardOfPlayer[i][j].setCharacter("E");
                }
                else if(j == 6){
                    this.BoardOfPlayer[i][j].setCharacter("F");
                }
                else if(j == 7){
                    this.BoardOfPlayer[i][j].setCharacter("G");
                }
                else if(j == 8){
                    this.BoardOfPlayer[i][j].setCharacter("H");
                }
                else if(j == 9){
                    this.BoardOfPlayer[i][j].setCharacter("I");
                }
                else{
                    this.BoardOfPlayer[i][j].setCharacter("J");
                }
                if(i == 1){
                    this.BoardOfPlayer[i][j].setNum(1);
                }
                else if(i == 2){
                    this.BoardOfPlayer[i][j].setNum(2);
                }
                else if(i == 3){
                    this.BoardOfPlayer[i][j].setNum(3);
                }
                else if(i == 4){
                    this.BoardOfPlayer[i][j].setNum(4);
                }
                else if(i == 5){
                    this.BoardOfPlayer[i][j].setNum(5);
                }
                else if(i == 6){
                    this.BoardOfPlayer[i][j].setNum(6);
                }
                else if(i == 7){
                    this.BoardOfPlayer[i][j].setNum(7);
                }
                else if(i == 8){
                    this.BoardOfPlayer[i][j].setNum(8);
                }
                else if(i == 9){
                    this.BoardOfPlayer[i][j].setNum(9);
                }
                else if(i == 10){
                    this.BoardOfPlayer[i][j].setNum(10);
                }
                if(i != 0 && j != 0) {
                    this.BoardOfPlayer[i][j].setOccupied(false);
                }
            }
        }
    }

    public static Ship putShip(Position p1, Position p2, Ship s, Board b) {
        int i1 = 1;
        int j1 = 1;
        int i2 = 1;
        int j2 = 1;
        boolean positionFound1 = false;
        boolean positionFound2 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (b.BoardOfPlayer[i1][j1].getCharacter().equals(p1.getCharacter()) && b.BoardOfPlayer[i1][j1].getNum() == p1.getNum()) {
                    positionFound1 = true;
                } else {
                    j1 = j1 + 1;
                }
            }
            if (j1 == 11) {
                j1 = 1;
                i1 = i1 + 1;
            }
        }
        while (i2 < 11 && !positionFound2) {
            while (j2 < 11 && !positionFound2) {
                if (b.BoardOfPlayer[i2][j2].getCharacter().equals(p2.getCharacter()) && b.BoardOfPlayer[i2][j2].getNum() == p2.getNum()) {
                    positionFound2 = true;
                } else {
                    j2 = j2 + 1;
                }
            }
            if (j2 == 11) {
                j2 = 1;
                i2 = i2 + 1;
            }
        }
        ArrayList<partsOfShip> arraypa = new ArrayList<>(s.type.getSize());
        s.setStartCoord(b.BoardOfPlayer[i1][j1].getCharacter() + Integer.toString(b.BoardOfPlayer[i1][j1].getNum()));
        s.setEndCoord(b.BoardOfPlayer[i2][j2].getCharacter() + Integer.toString(b.BoardOfPlayer[i2][j2].getNum()));
        if (i1 == i2) {
            //System.out.print("Putting the ship horizontally\n");
            int j3 = j1;
            int j4 = j2;
            while (abs(j3 - j4) != 0) {
                if (j3 > j4) {
                    partsOfShip pa = new partsOfShip("", false);
                    b.BoardOfPlayer[i1][j4].setOccupied(true);
                    pa.setCoord(b.BoardOfPlayer[i1][j4].getCharacter() + Integer.toString(b.BoardOfPlayer[i1][j4].getNum()));
                    j4 = j4 + 1;
                    arraypa.add(pa);
                } else {
                    partsOfShip pa = new partsOfShip("", false);
                    b.BoardOfPlayer[i1][j3].setOccupied(true);
                    pa.setCoord(b.BoardOfPlayer[i1][j3].getCharacter() + Integer.toString(b.BoardOfPlayer[i1][j3].getNum()));
                    j3 = j3 + 1;
                    arraypa.add(pa);
                }
            }
                partsOfShip pa = new partsOfShip("",false);
                b.BoardOfPlayer[i1][j3].setOccupied(true);
                pa.setCoord(b.BoardOfPlayer[i1][j3].getCharacter() + Integer.toString(b.BoardOfPlayer[i1][j3].getNum()));
                arraypa.add(pa);
        } else if (j1 == j2) {
            //System.out.print("Putting the ship vertically\n");
            int i3 = i1;
            int i4 = i2;
            while (abs(i3 - i4) != 0) {
                if (i3 > i4) {
                    partsOfShip pa = new partsOfShip("",false);
                    b.BoardOfPlayer[i4][j1].setOccupied(true);
                    pa.setCoord(b.BoardOfPlayer[i4][j1].getCharacter() + Integer.toString(b.BoardOfPlayer[i4][j1].getNum()));
                    i4 = i4 + 1;
                    arraypa.add(pa);
                } else {
                    partsOfShip pa = new partsOfShip("",false);
                    b.BoardOfPlayer[i3][j1].setOccupied(true);
                    pa.setCoord(b.BoardOfPlayer[i3][j1].getCharacter() + Integer.toString(b.BoardOfPlayer[i3][j1].getNum()));
                    i3 = i3 + 1;
                    arraypa.add(pa);
                }
            }
            b.BoardOfPlayer[i3][j1].setOccupied(true);
            partsOfShip pa = new partsOfShip("",false);
            pa.setCoord(b.BoardOfPlayer[i3][j1].getCharacter() + Integer.toString(b.BoardOfPlayer[i3][j1].getNum()));
            arraypa.add(pa);
        }
        s.setCoordHit(arraypa);
        return s;
    }
}
