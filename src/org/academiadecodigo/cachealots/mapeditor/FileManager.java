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

            reader = new BufferedReader(new FileReader("savedContent"));

            for (Position pos : grid.getCells()) {

                String c = reader.readLine();

                if(c.equals("1")) {
                    System.out.println("reading 1");
                    pos.fill();

                } else {
                    System.out.println("reading 0");
                    pos.unFill();
                }

            }

            reader.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

    public void saveContent() {
        try {

            writer = new BufferedWriter(new FileWriter("savedContent"));
            for (Position pos : grid.getCells()) {

                if (pos.isFilled()) {
                    writer.write("1\n");
                    System.out.println("writing 1");
                }
                else {
                    writer.write("0\n");
                    System.out.println("writing 0");
                }
            }
            writer.flush();
            writer.close();

        } catch (IOException e) { e.printStackTrace(); }
    }

}
