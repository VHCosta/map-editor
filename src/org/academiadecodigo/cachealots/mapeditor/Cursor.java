package org.academiadecodigo.cachealots.mapeditor;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Grid grid;
    private Rectangle cursor;

    public Cursor(Grid grid) {
        this.grid = grid;
    }

    public void drawCursor(){
        cursor = new Rectangle(grid.getCellSize() + grid.getPadding(), grid.getCellSize() + grid.getPadding(), grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.GREEN);
        cursor.fill();
    }

}
