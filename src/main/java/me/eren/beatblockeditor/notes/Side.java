package me.eren.beatblockeditor.notes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

@Setter
@Getter
@Accessors(chain = true)
public class Side extends Note {

    /**
     * Whether the player should tap the note.
     */
    protected Boolean tap;

    public Side(double time, double angle) {
        super(NoteType.SIDE, time, angle);
    }

}
