public class PostIt {
    private String note;

    public PostIt(String note) {
        this.note = note;
    }

    public void post(Wall wall) {
        int rowsNeeded = (int) Math.ceil(note.length() / 13.0);
        if (rowsNeeded > 1)
            printMultiLiner(rowsNeeded);
        else
            printOneLiner();
    }

    public String[] formatNote(String note, int rowsNeeded) {
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

    public void printOneLiner() {
        int spacesToFill = note.length() - 13;

        if (spacesToFill > 0) {
            String padding = "";
            for (int i = 0; i < spacesToFill; i++)
                padding += " ";
            note += padding;
        }

        printTop();
        printMiddle();
        System.out.format("| %s |%n", note);
        printMiddle();
        printBottom();
    }

    public void printMultiLiner(int amountOfRows) {
        String[] rowsInNote = formatNote(note, amountOfRows);

        printTop();
        printMiddle();
        for (int i = 0; i < rowsInNote.length; i++)
            System.out.format("| %s |%n", rowsInNote[i]);
        printMiddle();
        printBottom();
    }

    public void printTop() {
        System.out.format(" _______________%n");
    }

    public void printMiddle() {
        System.out.format("|               |%n");
    }

    public void printBottom() {
        System.out.format("|_______________|%n");
    }
}
