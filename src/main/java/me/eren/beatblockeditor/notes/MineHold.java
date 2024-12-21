package me.eren.beatblockeditor.notes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.HoldNote;
import me.eren.beatblockeditor.notes.types.NoteType;

@Getter
@Setter
@Accessors(chain = true)
public class MineHold extends HoldNote {

    /**
     * If this mine hold has been hit, how frequently it should check for hits again
     * Default to 0.5
     */
    private Double tickRate;

    public MineHold(double time, double angle, double angle2, double duration) {
        super(NoteType.MINE_HOLD, time, angle, angle2, duration);
    }

}
