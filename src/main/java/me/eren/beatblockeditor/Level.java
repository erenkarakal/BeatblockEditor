package me.eren.beatblockeditor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
@ToString
public class Level {

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(NoteType.class, new NoteType.Adapter())
            .registerTypeAdapter(Ease.class, new Ease.Adapter())
            .registerTypeAdapter(Note.class, new Note.Deserializer())
            .create();

    @Setter
    private File source = new File(".");
    private final List<Note> chart = new ArrayList<>();

    /**
     * Creates a new level from scratch
     * @see Level#fromFolder(File) 
     */
    public Level() {
    }

    protected Level(File source) {
        this.source = source;
    }

    /**
     * Loads a level from a map folder
     * @param source The level's folder
     * @return The loaded level.
     */
    public static Level fromFolder(File source) {
        Condition.check(source != null, "Source is null");
        Condition.check(source.exists(), "Source does not exist");
        Condition.check(source.isDirectory(), "Level must be a directory");
        Condition.check(new File(source, "chart.json").exists(), "Level is missing chart.json");
        Condition.check(new File(source, "level.json").exists(), "Level is missing level.json");

        Level level = new Level(source);

        try (FileReader reader = new FileReader(new File(source, "/chart.json"))) {
            level.chart.addAll(List.of(GSON.fromJson(reader, Note[].class)));
            return level;
        } catch (IOException e) {
            throw new RuntimeException("Error while loading level.", e);
        }
    }

    /**
     * Saves this level to where it was loaded from. If the source wasn't specified the current directory will be used
     * @return Whether it was successful
     * @see Level#setSource(File) 
     */
    public boolean save() {
        return save(source);
    }

    /**
     * Saves this level to the target folder. Will create directories if they don't exist
     * @param targetFolder Where to save it to
     * @return Whether it was successful
     */
    public boolean save(File targetFolder) {
        Path chartPath = Paths.get(targetFolder.toString(), "/chart.json");
        try {
            Files.writeString(chartPath, getChartAsString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Returns the note list in the same format as chart.json
     * If you need to call this multiple times in a row you should cache it
     */
    public String getChartAsString() {
        return GSON.toJson(chart);
    }

    /**
     * Sorts the level's notes by their time
     */
    public void sortNotes() {
        chart.sort(Comparator.comparingDouble(Note::getTime).reversed());
    }

}
