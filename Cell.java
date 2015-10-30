

/*Cell.java
 *Makoto Kinoshita
 *10/05/2015
 */

 /*
  *This is Cell class. Cell class is the most besic class to simulte game of life
  */


import java.util.*;
import java.awt.Graphics;
public abstract class Cell {
    //x and y fields which keep the info of the location of this cell
    public double x;
    public double y;

    /*
     *Cell constructor. Cell data contains data of x value and y value
     */
    public Cell(double x0, double y0) {
        x = x0;
        y = y0;
    }

    /*
     *returning the x value of this cell object
     */
    public double getX() {
        return x;
    }

    /*
     *returning an integer number which is closest to the x value of this cell
     */
    public int getCol() {
        return (int) x;
    }

    /*
     *returning the y value of this cell object
     */
    public double getY() {
        return y;
    }

    /*
     *returning an integer number which is closest to the y value of this cell
     */
    public int getRow() {
        return (int) y;
    }

    /*
     *representing cells by dots
     */
    public String toString() {
        String str = ".";
        return str;
    }

    /*
     *update its status by the number of neighbor cells
    *public void updateState(ArrayList<Cell> neighbors) {
     *   int neighborcells = neighbors.size();
    *    Random r = new Random();
    *    if (neighborcells > 3 && Math.random() < 0.01) {
    *        double movex = r.nextDouble()*10 - 5;
    *        double movey = r.nextDouble()*10 - 5;
    *        x = x + movex;
    *        y = y + movey;
    *    } else if (neighborcells <= 3) {
    *        double movex = r.nextDouble()*10 - 5;
    *        double movey = r.nextDouble()*10 - 5;
    *        x = x + movex;
    *        y = y + movey;
    *    }
    *}
    */

    /*
     *These are abstract methods
     */
    public abstract boolean isNeighbor(int num, Cell cell, int radius);
    public abstract void updateState(Landscape land);
    public abstract void draw(Graphics g, int x, int y, int scale);

    /*
     *this main method is for testing this class
     */
    //public static void main(String[] args) {
    //    Cell cell1 = new Cell(4.4, 3.6);
    //    Cell cell2 = new Cell(2.1, 4.5);
    //    System.out.printf( "cell1: %.2f %.2f %d %d\n", cell1.getX(), cell1.getY(), cell1.getCol(), cell1.getRow() );
    //    System.out.printf( "cell2: %.2f %.2f %d %d\n", cell2.getX(), cell2.getY(), cell2.getCol(), cell2.getRow() );
    //}
}



