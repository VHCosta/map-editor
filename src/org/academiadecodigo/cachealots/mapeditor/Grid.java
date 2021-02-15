package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private final int CELL_SIZE = 20;

    private Rectangle outline;

    public void createGrid(int x, int y){

        outline = new Rectangle(PADDING, PADDING, x * CELL_SIZE, y * CELL_SIZE);
        outline.draw();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                Rectangle cell = new Rectangle(PADDING + CELL_SIZE * i, PADDING + CELL_SIZE * j, CELL_SIZE, CELL_SIZE);
                cell.draw();

            }
        }
    }

}
