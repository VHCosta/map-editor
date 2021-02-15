package org.academiadecodigo.cachealots.mapeditor;

public class Editor {

    //Class that inits all other objects: Grid, Cursor

    private Grid grid;
    private Cursor cursor;
    private EditorKeyboardHandler keyboardHandler;
    private EditorMouseHandler mouseHandler;
    private FileManager manager;

    public Editor(int x, int y) {

        grid = new Grid(x, y);
        cursor = new Cursor(grid);
        manager = new FileManager(grid);

        keyboardHandler = new EditorKeyboardHandler(grid, cursor, manager);
        keyboardHandler.keyboardHandlerInit();
        mouseHandler = new EditorMouseHandler(grid);
        mouseHandler.mouseHandlerInit();




    }

    public void start() {

        grid.initGrid();
        cursor.drawCursor();

    }

}
