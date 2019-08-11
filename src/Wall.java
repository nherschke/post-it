import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

        for (PostIt p : postIts) {
            if (!p.isSaved()) {
                fileWriter.write(p.getNote() + ";;");
                p.setSaved(true);
            }
        }

        if (fileWriter != null)
            fileWriter.close();
    }

    /**
     * Loads the contents of the savefile and creates instances of PostIt for every note
     * @param file The savefile
     */
    public void loadPosts(File file) {
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(";;");

            while (scanner.hasNext())
                postIts.add(new PostIt(scanner.next()));
        } catch (IOException e) {
            System.err.format("Savefile %s could not be read.", file);
        }
    }

    /**
     * Removes the specified instance of PostIt from the wall
     * @param index The index of the instance of PostIt to remove from the postIt list
     */
    public void removePostIt(int index) {
        int realIndex = index - 1;
        if (realIndex < postIts.size()) {
            PostIt toRemove = postIts.get(realIndex);
            postIts.remove(toRemove);
        } else {
            System.err.format("No post it at this index.%n");
        }
    }

    public ArrayList<PostIt> getPostIts() {
        return postIts;
    }
}
