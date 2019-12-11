package com.cartermooring.vesselskirmish;

public class Cell {
    private Coordinates coordinates;
    private int player;

    //DVC
    public Cell(){
        coordinates = new Coordinates();
        player = -1;
    }

    //EVC
    public Cell(int row, int col, int player){
        this.coordinates = new Coordinates(row, col);
        this.player = player;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    @Override
    public String toString() {
        String cellStr = "";
        cellStr += player;
        return cellStr;
    }
}
