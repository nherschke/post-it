package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void add(StickyNote stickyNote) {
        stickyNotes.add(stickyNote);
    }

    /**
     * Renders all the sticky notes on this wall
     */
    public void display() {
        for (StickyNote p : stickyNotes)
            p.stick();
    }

    public void saveNotes(File file) {
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
            if (fileWriter != null) try { fileWriter.close(); } catch (IOException e) {}
        }
    }

    public void loadNotes(File file) {
        ArrayList<String> notes = readInNotes(file);
        for (String s : notes)
            stickyNotes.add(new StickyNote(s));
    }

    public ArrayList<String> readInNotes(File file) {
        ArrayList<String> notes = new ArrayList<>();
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            scanner.useDelimiter("\n");

            while (scanner.hasNext())
                notes.add(scanner.next());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
        }

        return notes;
    }

    /**
     * Removes the specified instance of StickyNote from the wall
     * @param index The index of the instance of StickyNote to remove from the postIt list
     */
    public void removeStickyNote(int index) {
        int realIndex = index - 1;
        if (realIndex < stickyNotes.size() && realIndex > 0) {
            StickyNote toRemove = stickyNotes.get(realIndex);
            stickyNotes.remove(toRemove);
        } else {
            System.err.format("No post it at this index.%n");
        }
    }

    public ArrayList<StickyNote> getStickyNotes() {
        return stickyNotes;
    }
}
