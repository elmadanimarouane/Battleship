package elmadani.marouane;

public class Position {
    private String character;
    private int num;
    private boolean missileshot = false;
    private boolean occupied = true;

    Position(String character, int num) {
        this.character = character;
        this.num = num;
    }

    public boolean isMissileshot() {
        return missileshot;
    }

    public void setMissileshot(boolean missileshot) {
        this.missileshot = missileshot;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
