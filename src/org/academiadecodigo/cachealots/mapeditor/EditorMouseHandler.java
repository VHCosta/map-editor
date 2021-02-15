package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class EditorMouseHandler implements MouseHandler {

    private Mouse mouse;
    private Grid grid;

    public EditorMouseHandler(Grid grid) {
        this.grid = grid;
    }

    public void mouseHandlerInit() {
        this.mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        int mouseCol = (int) ((mouseEvent.getX() - grid.getPadding()) / grid.getCellSize());
        int mouseRow = (int) ((mouseEvent.getY() + grid.getPadding()) / grid.getCellSize());

        for (Position pos : grid.getCells()) {
            if(
                    mouseEvent.getY() >= pos.getY() &&
                    mouseEvent.getY() < pos.getY() + pos.getHeight() &&
                    mouseEvent.getX() >= pos.getX() &&
                    mouseEvent.getX() < pos.getX() + pos.getWidth()
            ){
                if(!pos.isFilled()) pos.fill();
                else pos.unFill();
            }
        }
        /*Position cell = grid.getCellsByPixels((int) mouseEvent.getX(), (int) mouseEvent.getY());
        if(!cell.isFilled()) cell.fill();
        else cell.unFill();*/

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
