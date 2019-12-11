package com.cartermooring.vesselskirmish;

public class Coordinates {
    private int row;
    private int col;

    //DVC
    public Coordinates(){
        row = 0;
        col = 0;
    }

    //EVC
    public Coordinates(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {

        String coordString = "The coordinate is: (" + row + ", " + col + ")";
        return coordString;
    }
}
