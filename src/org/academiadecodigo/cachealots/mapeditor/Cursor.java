package org.academiadecodigo.cachealots.mapeditor;


import org.academiadecodigo.simplegraphics.graphics.Color;

public class Cursor {

    private Grid grid;
    //private Rectangle cursor;
    private Cell cursor;

    public Cursor(Grid grid) {
        this.grid = grid;
    }

    public void drawCursor(){
        //cursor = new Rectangle(grid.getCellSize() + grid.getPadding(), grid.getCellSize() + grid.getPadding(), grid.getCellSize(), grid.getCellSize());
        cursor = new Cell(1, 2, grid);
        cursor.setColor(Color.GREEN);
        cursor.fill();
    }

    public Cell getCursor() {
        return cursor;
    }

    public int getX(){
        return cursor.getX();
    }

    public int getY(){
        return cursor.getY();
    }

    public int getWidth(){
        return cursor.getWidth();
    }

    public int getHeight(){
        return cursor.getHeight();
    }



}
