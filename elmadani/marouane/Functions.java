package elmadani.marouane;

import java.util.Scanner;
import static java.lang.Math.abs;

public class Functions {

    public static Position SelectionCase(Board bo) {
        Scanner sc = new Scanner(System.in);
        boolean positionnottaken = false;
        Position p = new Position("",0);
        while(!positionnottaken) {
            boolean errorStr = true;
            boolean errorInt = true;
            while (errorStr) {
                System.out.print("First, choose a column (in upper case)\n");
                String position = sc.next();
                if (position.equals("A") || position.equals("B") || position.equals("C") || position.equals("D") || (position.equals("E")) || (position.equals("F")) || (position.equals("G")) || (position.equals("H")) || (position.equals("I")) || (position.equals("J"))) {
                    errorStr = false;
                    p.setCharacter(position); //Storing the first character
                } else {
                    System.out.print("You've chosen a column out of the battlefield. Please start again\n");
                }
            }
            while (errorInt) {
                System.out.print("Now, a line \n");
                int position = sc.nextInt();
                if (position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6 || position == 7 || position == 8 || position == 9 || position == 10) {
                    errorInt = false;
                    p.setNum(position);

                } else {
                    System.out.print("You've chosen a line out of the battlefield. Please start again\n");
                }
            }
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
            if(bo.BoardOfPlayer[i1][j1].isOccupied()){
                System.out.print("You can't choose this position since it's already taken\n");
            }
            else{
                positionnottaken = true;
            }
        }
        return p;
    }

    public static Position selectRear(Position p, Ship s, Board bo) {
        Position p2 = new Position("", 0);
        boolean b = true;
        while (b) {
            p2 = SelectionCase(bo);
            int i1 = 1;
            int j1 = 1;
            int i2 = 1;
            int j2 = 1;
            boolean positionFound1 = false;
            boolean positionFound2 = false;
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
            while (i2 < 11 && !positionFound2) {
                while (j2 < 11 && !positionFound2) {
                    if (bo.BoardOfPlayer[i2][j2].getCharacter().equals(p2.getCharacter()) && bo.BoardOfPlayer[i2][j2].getNum() == p2.getNum()) {
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
            boolean notoccupied = true;
            if (p.getCharacter().equals(p2.getCharacter())) {
                if (abs(p.getNum() - p2.getNum()) > s.type.size - 1) {
                    System.out.print("Your ship is not that long. Please select another position\n");
                } else if (abs(p.getNum() - p2.getNum()) < s.type.size - 1) {
                    System.out.print("Your ship is not that small. Please select another position\n");
                } else {
                    int i3 = i1;
                    int i4 = i2;
                    while (abs(i3 - i4) != 0 && notoccupied) {
                        if (i3 > i4) {
                            if (bo.BoardOfPlayer[i4][j1].isOccupied()) {
                                System.out.print("You can't place a ship here because there is another ship on the way. Please try again\n");
                                notoccupied = false;
                            } else {
                                i4 = i4 + 1;
                            }
                        } else if (i4 > i3) {
                            if (bo.BoardOfPlayer[i3][j1].isOccupied()) {
                                System.out.print("You can't place a ship here because there is another ship on the way. Please try again\n");
                                notoccupied = false;
                            } else {
                                i3 = i3 + 1;
                            }
                        }
                    }
                    if (i3 - i4 == 0 && notoccupied) {
                        b = false;
                        System.out.print("You're putting your ship vertically\n");
                    }
                }
            } else if (p.getNum() == p2.getNum()) {
                String a = p.getCharacter().toLowerCase();
                String d = p2.getCharacter().toLowerCase();
                if (abs(a.charAt(0) - d.charAt(0)) > s.type.size) {
                    System.out.print("Your ship is not that long. Please select another position\n");
                } else if (abs(a.charAt(0) - d.charAt(0)) > s.type.size) {
                    System.out.print("Your ship is not that short. Please select another position\n");
                } else {
                    int j3 = j1;
                    int j4 = j2;
                    while (abs(j3 - j4) != 0 && notoccupied) {
                        if (j3 > j4) {
                            if (bo.BoardOfPlayer[i1][j4].isOccupied()) {
                                System.out.print("You can't place a ship here because there is another ship on the way. Please try again\n");
                                notoccupied = false;
                            } else {
                                j4 = j4 + 1;
                            }
                        } else if (j4 > j3) {
                            if (bo.BoardOfPlayer[i1][j3].isOccupied()) {
                                System.out.print("You can't place a ship here because there is another ship on the way. Please try again\n");
                                notoccupied = false;
                            } else {
                                j3 = j3 + 1;
                            }
                        }
                    }
                    if (j4 - j3 == 0 && notoccupied) {
                        b = false;
                        System.out.print("You're putting your ship horizontally\n");
                    }
                }
            } else {
                System.out.print("You must put your ship vertically or horizontally. Please select another position\n");
            }
        }
        return p2;

    }

    public static Board shoot (Position p, Board b, Ship listofShips[], Board b2, Player pl, int a) {
        int i1 = 1;
        int j1 = 1;
        boolean positionFound1 = false;
        while (i1 < 11 && !positionFound1) {
            while (j1 < 11 && !positionFound1) {
                if (b.BoardOfPlayer[i1][j1].getCharacter().equals(p.getCharacter()) && b.BoardOfPlayer[i1][j1].getNum() == p.getNum()) {
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
        boolean shotconfirmed = false;
        String PosString = b.BoardOfPlayer[i1][j1].getCharacter() + Integer.toString(b.BoardOfPlayer[i1][j1].getNum());
        int i = 0;
        int j = 0;
        while (i < listofShips.length && !shotconfirmed) {
            if (listofShips[i].isHit(PosString)) {
            while (j < listofShips[i].coordHit.size() && !shotconfirmed) {
                    if (listofShips[i].getCoordHit().get(j).getCoord().equals(PosString)) {
                        if (listofShips[i].getCoordHit().get(j).isPartHit()) {
                            if(a == 1){
                                System.out.print("You just shot a part of a ship that was already destroyed\n");
                            }
                            shotconfirmed = true;
                        } else {
                            if(a == 1){
                                System.out.print("Boom ! Target hit ! \n");
                            }
                            b2.BoardOfPlayer[i1][j1].setMissileshot(true);
                            b2.BoardOfPlayer[i1][j1].setOccupied(true);
                            b.BoardOfPlayer[i1][j1].setMissileshot(true);
                            listofShips[i].setNbTimeHit(listofShips[i].getNbTimeHit() + 1);
                            listofShips[i].getCoordHit().get(j).setPartHit(true);
                            shotconfirmed = true;
                            if (listofShips[i].isDestroyed()) {
                                if(a == 1){
                                    System.out.print("You successfully sank an enemy ship. Good job !\n");
                                }
                                pl.setNbShipsRemaining(pl.getNbShipsRemaining() - 1);
                            }
                        }

                    } else {
                        j = j + 1;
                    }
                }} else {
                    i = i + 1;
                }
            }
            if (!shotconfirmed) {
            if(a == 1){
                System.out.print("You missed\n");
            }
                b2.BoardOfPlayer[i1][j1].setMissileshot(true);
            }
            return b2;
    }

    public static Position SelectionCaseToShoot() {
        Scanner sc = new Scanner(System.in);
        Position p = new Position("", 0);
        boolean errorStr = true;
        boolean errorInt = true;
        while (errorStr) {
            System.out.print("First, choose a column (in upper case)\n");
            String position = sc.next();
            if (position.equals("A") || position.equals("B") || position.equals("C") || position.equals("D") || (position.equals("E")) || (position.equals("F")) || (position.equals("G")) || (position.equals("H")) || (position.equals("I")) || (position.equals("J"))) {
                errorStr = false;
                p.setCharacter(position); //Storing the first character
            } else {
                System.out.print("You've chosen a column out of the battlefield. Please start again\n");
            }
        }
        while (errorInt) {
            System.out.print("Now, a line \n");
            int position = sc.nextInt();
            if (position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6 || position == 7 || position == 8 || position == 9 || position == 10) {
                errorInt = false;
                p.setNum(position);

            } else {
                System.out.print("You've chosen a line out of the battlefield. Please start again\n");
            }
        }
        return p;
    }
}

