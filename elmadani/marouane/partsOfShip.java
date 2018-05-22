package elmadani.marouane;

public class partsOfShip {
    private String Coord;
    private boolean partHit;

    partsOfShip(String coord, boolean partHit) {
        Coord = coord;
        this.partHit = partHit;
    }

    public String getCoord() {
        return Coord;
    }

    public void setCoord(String coord) {
        Coord = coord;
    }

    public boolean isPartHit() {
        return partHit;
    }

    public void setPartHit(boolean partHit) {
        this.partHit = partHit;
    }
}


