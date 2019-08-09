import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Wall {
    private ArrayList<PostIt> postIts;

    public Wall() {
        postIts = new ArrayList<>();
    }

    /**
     * Adds a new post it to the wall for displaying
     * @param postIt The instance of PostIt to add to the wall
     */
    public void add(PostIt postIt) {
        postIts.add(postIt);
    }

    /**
     * Renders all the post it's on this wall
     */
    public void display() {
        for (PostIt p : postIts)
            p.post(this);
    }

    /**
     * Saves the notes of all the post its in a text file
     * @param file The file to save the notes to
     * @throws IOException
     */
    public void savePosts(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);

        for (PostIt p : postIts)
            fileWriter.write(p.getNote());

        if (fileWriter != null)
            fileWriter.close();
    }

    public ArrayList<PostIt> getPostIts() {
        return postIts;
    }
}
