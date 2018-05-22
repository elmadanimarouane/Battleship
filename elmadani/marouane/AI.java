package elmadani.marouane;

import java.util.ArrayList;
import java.util.Random;

public class AI {

    public static Board shootingLvl0(Board B1, Ship listofShips[], Board B2, Player pl, int n) {
        Random rand = new Random();
        int i1 = rand.nextInt(10) + 1;
        int j1 = rand.nextInt(10) + 1;
        B2 = Functions.shoot(B1.BoardOfPlayer[i1][j1],B1,listofShips,B2,pl,n);
        return B2;
    }

    public static Board shootingLvl1(Board B1, Ship listofShips[], Board B2, Player pl, int n){
        Random rand = new Random();
        int i = 1;
        int j = 1;
        while(B2.BoardOfPlayer[i][j].isMissileshot()){
            i = rand.nextInt(10) + 1;
            j = rand.nextInt(10) + 1;
        }
        B2 = Functions.shoot(B1.BoardOfPlayer[i][j],B1,listofShips,B2,pl,n);
        return B2;
    }

    public static Board shootingLvl2(Board B1, Ship listofShips[], Board B2, Player pl, int n) {
        int i = 1;
        int j = 1;
        int l = 0;
        boolean OneShotFound = false;
        boolean ShotConfirmed = false;
        //boolean AllPossibilitiesTried = false;
        ArrayList<Position> PotentialTargets = new ArrayList<>();
        ArrayList<Position> PreviousShot = new ArrayList<>();
        while (i < 11) {
            while (j < 11) {
                if (B2.BoardOfPlayer[i][j].isOccupied()) {
                    OneShotFound = true;
                    PreviousShot.add(B2.BoardOfPlayer[i][j]);
                    j = j + 1;
                }
                else{
                    j = j + 1;
                }
            }
            if (j == 11) {
                j = 1;
                i = i + 1;
            }
        }

        if(!OneShotFound){
            B2 = shootingLvl1(B1, listofShips, B2, pl,n);
            ShotConfirmed = true;
        }
        else{
            while(!ShotConfirmed && l < PreviousShot.size()){
                if(PreviousShot.get(l).getNum() == 1 && PreviousShot.get(l).getCharacter().equals("A")){
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }
                else if(PreviousShot.get(l).getNum() == 1 && PreviousShot.get(l).getCharacter().equals("J")){
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                }
                else if(PreviousShot.get(l).getNum() == 10 && PreviousShot.get(l).getCharacter().equals("J")){
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                }
                else if(PreviousShot.get(l).getNum() == 10 && PreviousShot.get(l).getCharacter().equals("A")){
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }
                else if(PreviousShot.get(l).getNum() == 1){
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }
                else if(PreviousShot.get(l).getCharacter().equals("A")){
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }

                else if(PreviousShot.get(l).getCharacter().equals("J")){
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                }

                else if(PreviousShot.get(l).getNum() == 10){
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }

                else{
                    PotentialTargets.add(GetTopPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetBottomPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetLeftPosition(PreviousShot.get(l),B2));
                    PotentialTargets.add(GetRightPosition(PreviousShot.get(l),B2));
                }
                l = l + 1;

            int k = 0;
            while(PotentialTargets.size() !=0 && !ShotConfirmed){
                if(!PotentialTargets.get(k).isMissileshot()){
                    B2 = Functions.shoot(PotentialTargets.get(k),B1,listofShips,B2,pl,n);
                    ShotConfirmed = true;
                }
                else{
                    PotentialTargets.remove(k);
                }
            }
            }

        }
        if(!ShotConfirmed){
            B2 = shootingLvl1(B1,listofShips,B2,pl,n);
            }

return B2;
    }

    public static void choicePlaceShip(Board b, Ship s) {
        Random rand = new Random();
        boolean placementConfirmed = false;
        int l;
        while(!placementConfirmed) {
            int i1 = 0;
            int j1 = 0;
            int i2;
            int j2;
            boolean placeEmptya = true;
            boolean placeEmptyb = true;
            while(b.BoardOfPlayer[i1][j1].isOccupied()) {
                i1 = rand.nextInt(10) + 1;
                j1 = rand.nextInt(10) + 1;
            }
            int k = rand.nextInt(2) + 1;
            if (k == 1) {
                i2 = i1;
                if (j1 + s.getType().getSize() - 1 < 11) {
                    l = j1;
                    j2 = j1 + s.getType().getSize() - 1;
                    while (placeEmptya && l <= j2) {
                        if (b.BoardOfPlayer[i2][l].isOccupied()) {
                            placeEmptya = false;
                        } else {
                            l = l + 1;
                        }
                    }

                    if (placeEmptya) {
                        Board.putShip(b.BoardOfPlayer[i2][j1],b.BoardOfPlayer[i2][j2],s,b);
                    }

                } else if (j1 - s.getType().getSize() + 1 > 0) {
                    j2 = j1 - s.getType().getSize() + 1;
                    l = j2;
                    while (placeEmptyb && l <= j1) {
                        if (b.BoardOfPlayer[i2][l].isOccupied()) {
                            placeEmptyb = false;
                        } else {
                            l = l + 1;
                        }
                    }
                    if (placeEmptyb) {
                        Board.putShip(b.BoardOfPlayer[i2][j2],b.BoardOfPlayer[i2][j1],s,b);
                    }
                }
            } else {
                j2 = j1;
                placeEmptya = true;
                placeEmptyb = true;
                if (i1 + s.getType().getSize() - 1 < 11) {
                    l = i1;
                    i2 = i1 + s.getType().getSize() - 1;
                    while (placeEmptya && l <= i2) {
                        if (b.BoardOfPlayer[l][j2].isOccupied()) {
                            placeEmptya = false;
                        } else {
                            l = l + 1;
                        }
                    }

                    if (placeEmptya) {
                        Board.putShip(b.BoardOfPlayer[i1][j2],b.BoardOfPlayer[i2][j2],s,b);
                    }
                } else if (i1 - s.getType().getSize() + 1 > 0) {
                    i2 = i1 - s.getType().getSize() + 1;
                    l = i2;
                    while (placeEmptyb && l <= i1) {
                        if (b.BoardOfPlayer[l][j2].isOccupied()) {
                            placeEmptyb = false;
                        } else {
                            l = l + 1;
                        }
                    }
                    if (placeEmptyb) {
                        Board.putShip(b.BoardOfPlayer[i2][j2],b.BoardOfPlayer[i1][j2],s,b);
                    }
                }
            }
            if (placeEmptya && placeEmptyb) {
                placementConfirmed = true;
            }
        }
    }

    private static Position GetTopPosition(Position p, Board bo){
        int i1 = 1;
        int j1 = 1;
        boolean positionFound1 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (bo.BoardOfPlayer[i1][j1].getCharacter().equals(p.getCharacter()) && bo.BoardOfPlayer[i1][j1].getNum() == p.getNum()) {
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
        return bo.BoardOfPlayer[i1-1][j1];
    }

    private static Position GetBottomPosition(Position p, Board bo){
        int i1 = 1;
        int j1 = 1;
        boolean positionFound1 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (bo.BoardOfPlayer[i1][j1].getCharacter().equals(p.getCharacter()) && bo.BoardOfPlayer[i1][j1].getNum() == p.getNum()) {
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
        return bo.BoardOfPlayer[i1+1][j1];
    }

    private static Position GetLeftPosition(Position p, Board bo){
        int i1 = 1;
        int j1 = 1;
        boolean positionFound1 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (bo.BoardOfPlayer[i1][j1].getCharacter().equals(p.getCharacter()) && bo.BoardOfPlayer[i1][j1].getNum() == p.getNum()) {
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
        return bo.BoardOfPlayer[i1][j1-1];
    }

    private static Position GetRightPosition(Position p, Board bo){
        int i1 = 1;
        int j1 = 1;
        boolean positionFound1 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (bo.BoardOfPlayer[i1][j1].getCharacter().equals(p.getCharacter()) && bo.BoardOfPlayer[i1][j1].getNum() == p.getNum()) {
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
        return bo.BoardOfPlayer[i1][j1+1];
    }


}
