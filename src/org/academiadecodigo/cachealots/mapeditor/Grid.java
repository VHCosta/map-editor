package org.academiadecodigo.cachealots.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.NoSuchElementException;

public class Grid {

    private final int PADDING = 10;
    private final int CELL_SIZE = 40;

    private int xSize;
    private int ySize;
    private int positionIndex;

    private Rectangle outline;
    private Position[] cells;



    private BufferedReader reader;
    private BufferedWriter writer;

    public Grid(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;

    }

    public void initGrid(){

        outline = new Rectangle(PADDING, PADDING, xSize * CELL_SIZE, ySize * CELL_SIZE);
        outline.draw();
        cells = new Position[xSize * ySize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {

                cells[positionIndex] = new Position(i, j, this);
                ++positionIndex;

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

    public Position[] getCells() {
        return cells;
    }

    public Position getCellByPosition(int col, int row) {
        for (Position pos : cells) {
            if (pos.getCol() == col && pos.getRow() == row) return pos;
        }
        throw new NoSuchElementException();
    }

    public Position getCellsByPixels(int x, int y){
        for (Position pos : cells){
            if (
                    pos.getX() >= x && pos.getX() + pos.getWidth() < x &&
                    pos.getY() >= y && pos.getY() + pos.getHeight() < y
            ){
               return pos;
            }
        }
        throw new NoSuchElementException();
    }

    public void clearCells() {
        for (Position pos : cells) {
            pos.unFill();
        }
    }




}

