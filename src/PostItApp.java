import java.io.IOException;
import java.util.Scanner;

public class PostItApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Wall wall = new Wall();
        PostIt test = new PostIt("Feed the cat!");
        PostIt longer = new PostIt("Feed the cat and don't forget the dog!");
        PostIt evenLonger = new PostIt("Brush my teeth and feed the guinea bugs and give the cat a nice treat...");

        test.post(wall);
        longer.post(wall);
        evenLonger.post(wall);
    }
}
