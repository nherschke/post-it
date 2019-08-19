package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Wall {
    private ArrayList<StickyNote> stickyNotes;

    public Wall() {
        stickyNotes = new ArrayList<>();
    }

    /**
     * Adds a new sticky note to the wall for displaying
     * @param stickyNote The instance of StickyNote to add to the wall
     */
    void add(StickyNote stickyNote) {
        stickyNotes.add(stickyNote);
    }

    /**
     * Renders all the sticky notes on this wall
     */
    void display() {
        for (StickyNote p : stickyNotes)
            p.stick();
    }

    /**
     * Saves all the notes currently on the wall into a text file
     * @param file The text file
     */
    void saveNotes(File file) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file, true);
            ArrayList<String> notes = readInNotes(file);

            if (notes.size() == 0) {
                for (StickyNote s : stickyNotes)
                    fileWriter.write(s.getNote() + "\n");
            } else {
                for (StickyNote s : stickyNotes) {
                    boolean alreadySaved = false;
                    for (String note : notes) {
                        if (s.getNote().equals(note)) {
                            alreadySaved = true;
                            break;
                        }
                    }

                    if (!alreadySaved)
                        fileWriter.write(s.getNote() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) try { fileWriter.close(); } catch (IOException ignored) {}
        }
    }

    /**
     * Loads the notes from the savefile and creates sticky notes from them
     * @param file The savefile
     */
    void loadNotes(File file) {
        ArrayList<String> savedNotes = readInNotes(file);
        var displayedNotes = new ArrayList<String>();

        for (StickyNote sn : stickyNotes)
            displayedNotes.add(sn.getNote());

        savedNotes.removeAll(displayedNotes);

        for (String s : savedNotes)
            stickyNotes.add(new StickyNote(s));

        try { new PrintWriter(file).close(); } catch (IOException ignored) {}
    }

    /**
     * Reads the content of the savefile into an ArrayList
     * @param file The savefile
     * @return An ArrayList containing the saved notes
     */
    public ArrayList<String> readInNotes(File file) {
        ArrayList<String> notes = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\n");

            while (scanner.hasNext())
                notes.add(scanner.next());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return notes;
    }

    /**
     * Removes the specified instance of StickyNote from the wall
     * @param index The index of the sticky note to remove
     */
    void removeStickyNote(int index) {
        int realIndex = index - 1;
        if (realIndex < stickyNotes.size() && realIndex > 0) {
            StickyNote toRemove = stickyNotes.get(realIndex);
            stickyNotes.remove(toRemove);
        } else {
            System.err.format("No sticky note at this index.%n");
        }
    }

    public ArrayList<StickyNote> getStickyNotes() {
        return stickyNotes;
    }
}
