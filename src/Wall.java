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

    public ArrayList<PostIt> getPostIts() {
        return postIts;
    }
}
