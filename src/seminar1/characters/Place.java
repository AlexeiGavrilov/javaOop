package seminar1.characters;

public class Place {
    protected int x;
    protected int y;
    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double findDistanse (Character target) {
        return Math.sqrt((Math.pow(target.position.getX() - this.getX(), 2)) +
                (Math.pow(target.position.getY() - this.getY(), 2)));
    }
    @Override
    public String toString() {return String.format("Position = (%d,%d)",x,y);}
    public int getX() {return x;}
    public int getY() {
        return y;
    }
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public Place getDiff (Place targetPos) {return new Place(x - targetPos.getX(), y - targetPos.getY());}

    public boolean equals(Place target) {return x == target.getX() && y == target.getY();}
}
