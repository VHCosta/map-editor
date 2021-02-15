package org.academiadecodigo.cachealots.mapeditor;

public class Editor {

    //Class that inits all other objects: Grid, Cursor

    private Grid grid;
    private Cursor cursor;
    private EditorKeyboardHandler handler;

    public Editor(int x, int y) {

        grid = new Grid(x, y);
        cursor = new Cursor(grid);
        handler = new EditorKeyboardHandler(grid, cursor);
        handler.keyboardHandlerInit();

    }

    public void start() {

        grid.initGrid();
        cursor.drawCursor();

    }

}
