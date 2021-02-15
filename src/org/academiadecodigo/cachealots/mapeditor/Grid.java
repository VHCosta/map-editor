package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private final int CELL_SIZE = 20;

    private int xSize;
    private int ySize;

    private Rectangle outline;

    public Grid(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void initGrid(){

        outline = new Rectangle(PADDING, PADDING, xSize * CELL_SIZE, ySize * CELL_SIZE);
        outline.draw();

        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {

                Rectangle cell = new Rectangle(PADDING + CELL_SIZE * i, PADDING + CELL_SIZE * j, CELL_SIZE, CELL_SIZE);
                cell.draw();

            }
        }
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getPadding() {
        return PADDING;
    }

    public int getWidth(){
        return outline.getWidth();
    }

    public int getHeight(){
        return outline.getHeight();
    }

}
