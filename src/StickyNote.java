public class StickyNote {
    private String note;

    public StickyNote(String note) {
        this.note = note;
    }

    /**
     * Prints an ascii-art post it
     * @param wall The instance of Wall to post this on
     */
    public void stick(Wall wall) {
        int rowsNeeded = (int) Math.ceil(note.length() / 13.0);
        if (rowsNeeded > 1)
            printMultiLiner(rowsNeeded);
        else
            printOneLiner();
    }

    /**
     * Formats the text so that the post its always have the same width
     * @param note The text to put on the post it
     * @param rowsNeeded The amount of rows needed to display the text
     * @return A string array containing the note broken up into lines
     */
    public String[] splitUpNote(String note, int rowsNeeded) {
        String[] rows = new String[rowsNeeded];
        for (int i = 0; i < rows.length; i++) {
            if ((i+1)*13 < note.length())
                rows[i] = note.substring(i*13, (i+1)*13);
            else
                rows[i] = note.substring(i*13);
        }

        if (rows[rows.length - 1].length() < 13) {
            while (rows[rows.length - 1].length() < 13)
                rows[rows.length - 1] += " ";
        }

        return rows;
    }

    /**
     * Prints a post it if the note only contains one line
     */
    public void printOneLiner() {
        if (note.length() < 13) {
            while (note.length() < 13)
                note += " ";
        }

        printTop();
        printMiddle();
        System.out.format("| %s |%n", note);
        printMiddle();
        printBottom();
    }

    /**
     * Prints a post it if the text contains multiple lines
     * @param amountOfRows The amount of rows needed to print the text
     */
    public void printMultiLiner(int amountOfRows) {
        String[] rowsInNote = splitUpNote(note, amountOfRows);

        printTop();
        printMiddle();
        for (int i = 0; i < rowsInNote.length; i++)
            System.out.format("| %s |%n", rowsInNote[i]);
        printMiddle();
        printBottom();
    }

    /**
     * Prints the top part of a post it
     */
    public void printTop() {
        System.out.format(" _______________%n");
    }

    /**
     * Prints the middle part of a post it
     */
    public void printMiddle() {
        System.out.format("|               |%n");
    }

    /**
     * Prints the bottom part of a post it
     */
    public void printBottom() {
        System.out.format("|_______________|%n");
    }

    public String getNote() {
        return note;
    }
}
