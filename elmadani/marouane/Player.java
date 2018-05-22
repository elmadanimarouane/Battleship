package elmadani.marouane;

public class Player {
    private String name;
    private Board BoardForPositionning;
    private Board BoardOfShots;
    private int NbShipsRemaining;
    private Ship ListOfShips[] = new Ship[4];

    Player(String name, Board boardForPositionning, Board boardOfShots, int nbShipsRemaining) {
        this.name = name;
        BoardForPositionning = boardForPositionning;
        BoardOfShots = boardOfShots;
        NbShipsRemaining = nbShipsRemaining;
    }

    public String getName() {
        return name;
    }

    public void setBoardOfShots(Board boardOfShots) {
        BoardOfShots = boardOfShots;
    }

    public int getNbShipsRemaining() {
        return NbShipsRemaining;
    }

    public void setNbShipsRemaining(int nbShipsRemaining) {
        NbShipsRemaining = nbShipsRemaining;
    }

    public void setListOfShips(Ship[] listOfShips) {
        ListOfShips = listOfShips;
    }
}
