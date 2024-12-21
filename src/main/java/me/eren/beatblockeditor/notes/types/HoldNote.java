package me.eren.beatblockeditor.notes.types;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.Condition;
import me.eren.beatblockeditor.Ease;

@Getter
@Accessors(chain = true)
public abstract class HoldNote extends Note {

    /**
     * Angle for the end of the hold
     */
    protected Double angle2;
    /**
     * How many beats the hold lasts
     */
    @Setter
    protected Double duration;
    /**
     * Force a certain number of line segments
     * Defaults to 1
     */
    protected Integer segments;
    /**
     * Change ease from angle1 to angle2
     * Defaults to LINEAR
     */
    @Setter
    protected Ease holdEase;

    public HoldNote(NoteType type, double time, double angle, double angle2, double duration) {
        super(type, time, angle);
        this.angle2 = angle2;
        this.duration = duration;
    }

    public void setAngle2(double angle2) {
        this.angle2 = angle2 % 360;
    }

    /**
     * How many segments the hold note should have. Must be above zero.
     */
    public void setSegments(int segments) {
        Condition.check(segments > 0, "Segment must be greater than zero.");
        this.segments = segments;
    }

    /**
     * A method that allows you to set negative segments.
     */
    public void setSegmentsUnsafe(int segments) {
        this.segments = segments;
    }

}
