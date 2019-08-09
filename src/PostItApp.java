import java.io.Console;
import java.io.File;
import java.io.IOException;

/**
 * @author Nicolas Herschke
 */

public class PostItApp {
    public static void main(String[] args) {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        boolean quit = false;
        Wall wall = new Wall();

        File storedNotes = new File("notes.txt");
        if (!storedNotes.exists()) {
            try {
                storedNotes.createNewFile();
            } catch (IOException e) {
                System.err.format("File %s could not be created.", storedNotes);
            }
        }

        c.printf("Welcome to your post it wall.%n");

        while (!quit) {
            c.printf("[p]rint | [n]ew | [r]emove | [s]ave | [l]oad | [q]uit%n> ");
            String choice;

            choice = c.readLine();

            switch (choice) {
                case "p":
                    wall.display();
                    break;

                case "n":
                    c.printf("Note: ");
                    String text = c.readLine();
                    wall.add(new PostIt(text));
                    break;

                case "r":
                    break;

                case "s":
                    try {
                        wall.savePosts(storedNotes);
                    } catch (IOException e) {
                        System.err.format("Notes could not be saved.");
                    }
                    break;

                case "l":
                    break;

                case "q":
                    quit = true;
                    break;

                default:
                    System.out.format("Option does not exist.%n");
                    break;
            }
        }

        if (quit)
            System.exit(0);
    }
}
