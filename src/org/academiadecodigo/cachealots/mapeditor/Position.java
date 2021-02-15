package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int row;
    private int col;
    private Grid grid;
    private Rectangle rect;

    public Position(int row, int col, Grid grid) {
        this.row = row;
        this.col = col;
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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setColor(Color color){
        rect.setColor(color);
    }

    public void move(int xDist, int yDist){
        rect.translate(grid.getCellSize() * xDist, grid.getCellSize() * yDist);
        col += xDist;
        row += yDist;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isFilled(){
        return rect.isFilled();
    }
}
