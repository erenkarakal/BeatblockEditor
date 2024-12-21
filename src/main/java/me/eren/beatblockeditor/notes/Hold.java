package me.eren.beatblockeditor.notes;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.notes.types.HoldNote;
import me.eren.beatblockeditor.notes.types.NoteType;

@Getter
@Setter
@Accessors(chain = true)
public class Hold extends HoldNote {

    /**
     * Whether the player should tap at the start of the hold
     */
    private Boolean startTap;
    /**
     * Whether the player should tap at the end of the hold
     */
    private Boolean endTap;

    public Hold(double time, double angle, double angle2, double duration) {
        super(NoteType.HOLD, time, angle, angle2, duration);
    }

}
