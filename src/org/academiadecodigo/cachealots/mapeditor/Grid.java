package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.NoSuchElementException;

public class Grid {

    private final int PADDING = 10;
    private final int CELL_SIZE = 15;

    private int cols;
    private int rows;

    private Rectangle outline;
    private Cell[][] cells;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    public void initGrid(){

        outline = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        outline.draw();
        cells = new Cell[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                cells[i][j] = new Cell(i, j, this);

            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCellByPosition(int col, int row) {
       return cells[col][row];
    }

    public Cell getCellsByPixels(int x, int y){
        for (Cell[] subArray : cells){
            for (Cell cell : subArray) {

                int minY = cell.getY()+getCellSize()/2;
                int maxY = minY + cell.getHeight();
                int minX = cell.getX();
                int maxX = minX + cell.getWidth();

                if(Math.max(minY, y) == Math.min(y, maxY) &&
                        Math.max(minX, x) == Math.min(x, maxX))
                        return cell;
            }
        }

        throw new NoSuchElementException();

    }

    public void clearCells() {
        for (Cell[] subArray : cells) {
            for (Cell cell : subArray) {
                cell.unFill();
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

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

}

