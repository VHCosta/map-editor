package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private int col;
    private int row;
    private Grid grid;
    private Rectangle rect;

    public Cell(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
        rect = new Rectangle(grid.getPadding() + grid.getCellSize() * col, grid.getPadding() + grid.getCellSize() * row, grid.getCellSize(), grid.getCellSize());
        rect.draw();
    }

    public void unFill(){
        rect.draw();
    }

    public void fill(){
        rect.fill();
    }

    public int getX(){
        return rect.getX();
    }

    public int getY(){
        return rect.getY();
    }

    public int getWidth(){
        return rect.getWidth();
    }

    public int getHeight(){
        return rect.getHeight();
    }

    public void setColor(Color color){
        rect.setColor(color);
    }

    public void move(int xDist, int yDist){
        rect.translate(grid.getCellSize() * xDist, grid.getCellSize() * yDist);
        col += xDist;
        row += yDist;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isFilled(){
        return rect.isFilled();
    }

    public String toString(){
        return isFilled() ? "1" : "0";
    }

}
