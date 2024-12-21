package me.eren.beatblockeditor.notes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

@Getter
@Setter
@Accessors(chain = true)
public class Block extends Note {

    /**
     * Whether the player should tap the note
     */
    protected Boolean tap;

    public Block(double time, double angle) {
        super(NoteType.BLOCK, time, angle);
    }

}
