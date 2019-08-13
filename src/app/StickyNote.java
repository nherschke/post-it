package app;

public class StickyNote {
    private String note;

    public StickyNote(String note) {
        this.note = note;
    }

    /**
     * Prints an ASCII sticky note
     */
    public void stick() {
        int rowsNeeded = (int) Math.ceil(note.length() / 13.0);
        if (rowsNeeded > 1)
            printMultiLiner(rowsNeeded);
        else
            printOneLiner();
    }

    /**
     * Formats the text so that the sticky notes always have the same width
     * @param note The text to put on the sticky note
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
     * Prints a sticky note if the note only contains one line
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
     * Prints a sticky note if the text contains multiple lines
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
     * Prints the top part of a sticky note
     */
    public void printTop() {
        System.out.format(" _______________%n");
    }

    /**
     * Prints the middle part of a sticky note
     */
    public void printMiddle() {
        System.out.format("|               |%n");
    }

    /**
     * Prints the bottom part of a sticky note
     */
    public void printBottom() {
        System.out.format("|_______________|%n");
    }

    public String getNote() {
        return note;
    }
}
