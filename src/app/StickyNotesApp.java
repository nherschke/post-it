package app;

import java.io.Console;
import java.io.File;
import java.io.IOException;

/**
 * @author Nicolas Herschke
 */

public class StickyNotesApp {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        boolean quit = false;
        Wall wall = new Wall();

        File storedNotes = new File("notes.txt");
        if (!storedNotes.exists()) try { storedNotes.createNewFile(); } catch (IOException e) {}

        c.printf("Welcome to your sticky notes wall.%n");
        c.printf("______________________________________________________________%n");
        c.printf("[p]rint | [n]ew | [r]emove | [s]ave | [l]oad | [q]uit | [h]elp%n");
        c.printf("--------------------------------------------------------------%n");

        while (!quit) {
            String choice;

            c.printf("[command]> ");
            choice = c.readLine();

            switch (choice) {
                case "p":
                    wall.display();
                    break;

                case "n":
                    c.printf("Note> ");
                    String text = c.readLine();
                    wall.add(new StickyNote(text));
                    break;

                case "r":
                    c.printf("Index> ");
                    int index = Integer.parseInt(c.readLine());
                    wall.removeStickyNote(index);
                    break;

                case "s":
                    wall.saveNotes(storedNotes);
                    break;

                case "l":
                    wall.loadNotes(storedNotes);
                    break;

                case "q":
                    c.printf("Save before exit? [y/n]> ");
                    String answer = c.readLine();
                    switch (answer) {
                        case "y":
                        case "Y":
                        case "yes":
                        case "Yes":
                            wall.saveNotes(storedNotes);
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                    }
                    quit = true;
                    break;

                default:
                    System.out.format("Option does not exist.%n");
                    break;
            }
        }

        System.exit(0);
    }
}
