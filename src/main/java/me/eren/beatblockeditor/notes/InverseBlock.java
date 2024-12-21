package me.eren.beatblockeditor.notes;

import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

@Accessors(chain = true)
public class InverseBlock extends Note {

    public InverseBlock(double time, double angle) {
        super(NoteType.INVERSE_BLOCK, time, angle);
    }

}
