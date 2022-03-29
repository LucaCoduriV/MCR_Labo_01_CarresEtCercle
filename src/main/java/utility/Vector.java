package utility;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Add two vectors
     * @param other The other vector
     * @return The first vector added to the second vector
     */
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y);
    }

    /**
     * @return The y coordinate of the vector   
     */
    public int getY() {
        return y;
    }

    /**
     * @return The x coordinate of the vector
     */
    public int getX() {
        return x;
    }
}
