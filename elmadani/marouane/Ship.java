package elmadani.marouane;

import java.util.ArrayList;

public class Ship {
    private String startCoord;
    private String endCoord;
    typeOfShip type = new typeOfShip("",0);
    ArrayList<partsOfShip> coordHit = new ArrayList<>(type.size);
    private int nbTimeHit;

    public boolean isHit(String missileCoord){
        boolean touche = false;
        int x = 0;
        while(x < type.size && !touche){
            if (coordHit.get(x).getCoord().equals(missileCoord)){
                touche = true;
            }
            else {
                x = x + 1;
            }
        }
        return touche;
        }

    public boolean isDestroyed(){
        return nbTimeHit == type.size;
    }

    Ship(String startCoord, String endCoord, typeOfShip type, int nbTimeHit) {
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        this.type = type;
        this.nbTimeHit = nbTimeHit;
    }

    public typeOfShip getType() {
        return type;
    }

    public int getNbTimeHit() {
        return nbTimeHit;
    }

    public void setStartCoord(String startCoord) {
        this.startCoord = startCoord;
    }

    public void setEndCoord(String endCoord) {
        this.endCoord = endCoord;
    }

    public void setNbTimeHit(int nbTimeHit) {
        this.nbTimeHit = nbTimeHit;
    }

    public ArrayList<partsOfShip> getCoordHit() {
        return coordHit;
    }

    public void setCoordHit(ArrayList<partsOfShip> coordHit) {
        this.coordHit = coordHit;
    }
}

