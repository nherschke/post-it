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

    public ArrayList<PostIt> getPostIts() {
        return postIts;
    }
}
