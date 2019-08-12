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
            p.stick(this);
    }

    /**
     * Saves the notes of all the instances of StickyNote in a text file
     * @param file The file to save the notes to
     * @throws IOException
     */
    public void saveNotes(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        String[] notes = readInNotes(file);

        for (StickyNote s : stickyNotes) {
            boolean alreadySaved = false;
            for (int i = 0; i < notes.length; i++) {
                if (s.getNote().equals(notes[i])) {
                    alreadySaved = true;
                    break;
                }
            }
            if (!alreadySaved)
                fileWriter.write(s.getNote() + ";;");
        }
    }

    /**
     * Loads the contents of the savefile and creates instances of StickyNote for every note
     * @param file The savefile
     */
    public void loadNotes(File file) {
        String[] notes = readInNotes(file);
        for (String s : notes)
            stickyNotes.add(new StickyNote(s));
    }

    /**
     * Reads in the savefile and returns the notes in a string array
     * @param file The savefile
     * @return the notes in a string array
     */
    public String[] readInNotes(File file) {
        StringBuilder allNotes = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(";;");

            while (scanner.hasNext())
                allNotes.append(scanner.next());

            return allNotes.toString().split(";;");
        } catch (IOException e) {
            System.err.format("Savefile %s could not be read.", file);
        }

        return null;
    }

    /**
     * Removes the specified instance of StickyNote from the wall
     * @param index The index of the instance of PostIt to remove from the postIt list
     */
    public void removeStickyNote(int index) {
        int realIndex = index - 1;
        if (realIndex < stickyNotes.size()) {
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
