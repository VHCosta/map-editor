package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class EditorMouseHandler implements MouseHandler {

    private Mouse mouse;
    private final Grid grid;

    public EditorMouseHandler(Grid grid) {
        this.grid = grid;
    }

    public void mouseHandlerInit() {
        this.mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int padding = grid.getPadding();
        int cellSize = grid.getCellSize();
        int x = (int) mouseEvent.getX();
        int y = (int) mouseEvent.getY();

        int mouseCol = (x - padding) / cellSize;
        int mouseRow = (y - padding - cellSize) / cellSize;

        //Cell cell = grid.getCellsByPixels(x, y);
        Cell cell = grid.getCellByPosition(mouseCol, mouseRow);

        if(!cell.isFilled()) cell.fill();
        else cell.unFill();



    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
