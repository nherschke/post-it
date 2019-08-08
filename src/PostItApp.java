import java.util.Scanner;

/**
 * @author Nicolas Herschke
 */

public class PostItApp {
    public static void main(String[] args) {
        boolean quit = false;
        Wall wall = new Wall();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");

        System.out.format("Welcome to your post it wall.%n");

        while (!quit) {
            System.out.format("[p]rint | [n]ew | [r]emove | [s]ave | [l]oad | [q]uit%n");
            String choice;

            choice = scanner.next();

            switch (choice) {
                case "p":
                    for (PostIt p : wall.getPostIts())
                        p.post(wall);
                    break;

                case "n":
                    System.out.print("Note: ");
                    String text = scanner.next();
                    wall.add(new PostIt(text));
                    break;

                case "r":

                case "s":

                case "l":

                case "q":
                    quit = true;
                    break;

                default:
                    System.out.format("Option is not recognized.%n");
                    break;
            }
        }

        if (quit) {
            scanner.close();
            System.exit(0);
        }
    }
}
