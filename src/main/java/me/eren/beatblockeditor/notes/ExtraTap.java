package me.eren.beatblockeditor.notes;

import lombok.ToString;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.Ease;
import me.eren.beatblockeditor.notes.types.Note;
import me.eren.beatblockeditor.notes.types.NoteType;

@ToString(exclude = { "endAngle", "spinEase" })
@Accessors(chain = true)
public class ExtraTap extends Note {

    public ExtraTap(double time, double angle) {
        super(NoteType.EXTRA_TAP, time, angle);
    }

    /**
     * Not supported for extra tap notes
     */
    @Override
    public Double getEndAngle() {
        throw new UnsupportedOperationException("Extra tap notes don't have an end angle.");
    }

    /**
     * Not supported for extra tap notes
     */
    @Override
    public ExtraTap setEndAngle(double angle2) {
        throw new UnsupportedOperationException("You can't set the end angle of an extra tap note.");
    }

    /**
     * Not supported for extra tap notes
     */
    @Override
    public Ease getSpinEase() {
        throw new UnsupportedOperationException("Extra tap notes don't have a spin ease.");
    }

    /**
     * Not supported for extra tap notes
     */
    @Override
    public ExtraTap setSpinEase(Ease spinEase) {
        throw new UnsupportedOperationException("You can't set the spin ease of an extra tap note.");
    }

}
