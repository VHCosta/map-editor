package org.academiadecodigo.cachealots.mapeditor;

public class Editor {

    //Class that inits all other objects: Grid, Cursor

    private Grid grid;
    private Cursor cursor;

    public Editor(int x, int y) {

        this.grid = new Grid(x, y);
        this.cursor = new Cursor(grid);
    }

    public void start() {

        grid.initGrid();
        cursor.drawCursor();
    }

}
