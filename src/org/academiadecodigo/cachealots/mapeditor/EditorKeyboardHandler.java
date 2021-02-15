package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class EditorKeyboardHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Grid grid;
    private Cursor cursor;

    public EditorKeyboardHandler(Grid grid, Cursor cursor) {
        this.grid = grid;
        this.cursor = cursor;
    }

    public void keyboardHandlerInit() {
        this.keyboard = new Keyboard(this);

        keyboard.addEventListener(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_L, KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if(cursor.getCursor().getY() > grid.getPadding())
                    cursor.getCursor().translate(0, -grid.getCellSize());

                break;

            case KeyboardEvent.KEY_DOWN:
                if(cursor.getCursor().getY() < grid.getHeight() - grid.getCellSize())
                    cursor.getCursor().translate(0, grid.getCellSize());

                break;

            case KeyboardEvent.KEY_LEFT:
                if(cursor.getCursor().getX() > grid.getPadding())
                    cursor.getCursor().translate(-grid.getCellSize(), 0);

                break;

            case KeyboardEvent.KEY_RIGHT:
                if(cursor.getCursor().getX() < grid.getWidth() - grid.getCellSize())
                    cursor.getCursor().translate(grid.getCellSize(), 0);

                break;

            case KeyboardEvent.KEY_SPACE:
                break;
            case KeyboardEvent.KEY_S:
                break;
            case KeyboardEvent.KEY_L:
                break;
            case KeyboardEvent.KEY_C:
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
