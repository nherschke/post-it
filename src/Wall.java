public class Wall {
    /**
     * Adds a new post it to the wall for displaying
     * @param postIt The instance of PostIt to add to the wall
     */
    public void add(PostIt postIt) {
        postIt.post(this);
    }
}
