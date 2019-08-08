import java.util.Scanner;

/**
 * @author Nicolas Herschke
 */

public class PostItApp {
    public static void main(String[] args) {
        Wall wall = new Wall();
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            String postNote = scanner.nextLine();
            wall.add(new PostIt(postNote));
        }
    }
}
