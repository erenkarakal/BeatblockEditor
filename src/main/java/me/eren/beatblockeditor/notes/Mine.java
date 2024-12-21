package me.eren.beatblockeditor.notes;

import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

@Accessors(chain = true)
public class Mine extends Note {

    public Mine(double time, double angle) {
        super(NoteType.MINE, time, angle);
    }

}
