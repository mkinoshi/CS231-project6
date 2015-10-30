/*Landscape.java
 *Makoto kinoshtia
 *10/05/2015
 */

 //importing all of the java.util packages
import java.util.*;

/*
 *This class creates LinkedList which keeps the info of all cells.
 */
public class Landscape {
    //width  fields which keeps the information of the width this grid.
    private double width;
    //width  fields which keeps the information of the height this grid.
    private double height;
    //list fields whose nodes contain cells for each.
    private LinkedList<Cell> list.

    /*
     *Landcape object constructor
     */
    public Landscape(double rows, double cols) {
        width = rows;
        height =cols;
        list = new LinkedList<Cell>();
    }

    /*
     *this method resets landscape object
     */
    public void reset(int num) {
        width =0;
        height =0;
        if (num == 0) {
            squirrel.clear();
        } else if (num == 1) {
            oak.clear();
        } else if (num == 2) {
            fence.clear();
        }
    }

    /*
     *returning the value of the height of this grid
     */
    public int getRows() {
        return (int)height;
    }

    /*
     *returning the width value of the width
     */
    public int getCols() {
        return (int)width;
    }

    /*
     *This method returns height field of this class
     */
    public double getHeight() {
            return height;
    }

    /*
     *This method returns width field of this class
     */
    public double getWidth() {
            return width;
    }

    /*
     *adding a cell to one element of this grid
     */
    public void addAgent(Cell a) {
        list.add(a);
    }

    /*
     *This function removes cell object specified.
     */
    public void removeAgent(Cell a) {
        list.remove(a);
    }

    /*
     *returning cells on this grid
     */
    public ArrayList<Cell> getAgents() {
        ArrayList<Cell> cellarray = new ArrayList<Cell> ();
        cellarray = list.toArrayList();      
        return cellarray;
    }

    /*
     *Changing the way to represent the grid from linkedlist to Array and from Array to Arraylist
     * to print this grid
     */
     public String toString(int num) {
         String[][] strgrid = new String[(int)height][(int)width];
         ArrayList<Cell> cells = this.getAgents(num);
         String str = "";
         for (int rownum = 0; rownum < strgrid.length; rownum++) {
             for (int colnum = 0; colnum < strgrid[0].length; colnum++) {
                 strgrid[rownum][colnum] = " ";
             }
         }
         for (int i = 0; i < cells.size(); i++) {
             int colval = cells.get(i).getCol();
             int rowval = cells.get(i).getRow();
             if (((0 <= colval) && (colval < width)) && ((0 <= rowval) && (rowval < height))) {
                 strgrid[rowval][colval] = cells.get(i).toString();
             }
         }
         for (int i = 0; i < strgrid.length; i++) {
             for (int j = 0; j < strgrid[0].length; j++) {
                 str = str + strgrid[i][j];
             }
             str = str + "\n";
         }
         return str;
     }

    /*
     *get all of cells which are within certain length which is determined by radius variable
     */
    public ArrayList<Cell> getNeighbors(int num,  Cell qcell) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        ArrayList<Cell> allcells = this.getAgents(num);
        for (int i=0; i < allcells.size(); i++) {
            if (allcells.get(i).isNeighbor(num, qcell, 10)) {
                neighbors.add(allcells.get(i));
            }
        }
        return neighbors;
    }

    /*
     *this method update each cell according to the updateState method of each cell object
     */
    public void advance() {
        ArrayList<Cell> sarray = squirrel.toShuffledList();
        ArrayList<Cell> soak = oak.toShuffledList();
        ArrayList<Cell> sfence = fence.toShuffledList();
        Random r = new Random();
        for (int i = 0; i < sarray.size(); i++) {
            sarray.get(i).updateState(this);
        }
        for (int i = 0; i < soak.size(); i++) {
            soak.get(i).updateState( this);
        }
        for (int i = 0; i < sfence.size(); i++) {
            sfence.get(i).updateState(this);
        }
        //     /*
        //      *The code below here is to change some features of landscape by using the results of update of LifeCells
        //      */
        //     int neighborcells = this.getNeighbors(cellarray.get(i).getX(), cellarray.get(i).getY(), 10).size();
        //     if (cellarray.get(i) instanceof LifeCell) {
        //         if (((LifeCell) cellarray.get(i)).createNew() > 0) {
        //             int newval = ((LifeCell) cellarray.get(i)).createNew();
        //             while (newval > 0) {
        //                 double movex = r.nextDouble()*3 - 1.5;
        //                 double movey = r.nextDouble()*3 - 1.5;
        //                 double x = movex + cellarray.get(i).getX();
        //                 double y = movey + cellarray.get(i).getY();
        //                 if ((x > 0 && x < this.getWidth()) && (y > 0 && y < this.getHeight())) {
        //                     this.addAgent(new LifeCell(x, y));
        //                     newval = newval - 1;
        //                 }
        //             }
        //         }
        //         if (((LifeCell) cellarray.get(i)).getLives() == 0) {
        //             cellarray.remove((LifeCell) cellarray.get(i));
        //         } else if (((LifeCell) cellarray.get(i)).getX() < 0 || ((LifeCell) cellarray.get(i)).getY() < 0 || ((LifeCell) cellarray.get(i)).getX() > this.getWidth() || ((LifeCell) cellarray.get(i)). getY() > this.getHeight()) {
        //             System.out.println(((LifeCell) cellarray.get(i)).getX());
        //             System.out.println(((LifeCell) cellarray.get(i)).getY());
        //             cellarray.remove((LifeCell)cellarray.get(i));
        //         } else if (((LifeCell) cellarray.get(i)).getLives() > 0 && (neighborcells == 5 || neighborcells == 4 || neighborcells == 3) && Math.random() < 0.01) {
        //             double movex = r.nextDouble()*(this.getWidth()*0.1) - (this.getWidth()*0.05);
        //             double movey = r.nextDouble()*(this.getWidth()*0.1) - (this.getWidth()*0.05) ;
        //             double x = ((LifeCell) cellarray.get(i)).getX() + movex;
        //             double y = ((LifeCell) cellarray.get(i)).getY() + movey;
        //             ((LifeCell) cellarray.get(i)).setX(x);
        //             ((LifeCell) cellarray.get(i)).setY(y);
        //         } else if (((LifeCell) cellarray.get(i)).getLives() > 0 && (neighborcells < 3 || neighborcells > 5)) {
        //             double movex = r.nextDouble()*(this.getWidth()*0.1) - (this.getWidth()*0.05);
        //             double movey = r.nextDouble()*(this.getWidth()*0.1) - (this.getWidth()*0.05);
        //             double x = ((LifeCell) cellarray.get(i)).getX() + movex;
        //             double y = ((LifeCell) cellarray.get(i)).getY() + movey;
        //             ((LifeCell) cellarray.get(i)).setX(x);
        //             ((LifeCell) cellarray.get(i)).setY(y);
        //         }
        //     }
        // }
    }

    /*
     *this main method creates a grid and conducts simulation for 10 times
     */
    public static void main(String[] args) {

    }
}

