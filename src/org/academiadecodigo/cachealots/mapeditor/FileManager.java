package org.academiadecodigo.cachealots.mapeditor;

import java.io.*;

public class FileManager {

    private Grid grid;
    private BufferedReader reader;
    private BufferedWriter writer;

    public FileManager(Grid grid) {
        this.grid = grid;
    }

    public void loadContent() {

        try {

            reader = new BufferedReader(new FileReader("map.txt"));


            for (int i = 0; i < grid.getRows(); i++) {
                for (int j = 0; j < grid.getCols(); j++) {

                    String line = reader.readLine();

                    if (line.charAt(j) == 1){
                        grid.getCells()[i][j].fill();
                    } else {
                        grid.getCells()[i][j].unFill();
                    }
                }
            }

            reader.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

    public void saveContent() {
        try {

            writer = new BufferedWriter(new FileWriter("map.txt"));

            for (int i = 0; i < grid.getRows(); i++) {
                for (int j = 0; j < grid.getCols(); j++) {

                    if (grid.getCells()[i][j].isFilled()) {
                        writer.write("1");
                        System.out.println("writing 1");
                    } else {
                        writer.write("0");
                        System.out.println("writing 0");
                    }
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException e) { e.printStackTrace(); }
    }

}
