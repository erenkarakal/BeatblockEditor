package me.eren.beatblockeditor.notes.types;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import me.eren.beatblockeditor.Ease;
import me.eren.beatblockeditor.notes.*;

import java.lang.reflect.Type;

@Getter
@Accessors(chain = true)
@ToString
public abstract class Note {

    /**
     * The type of the note
     */
    @SerializedName("type")
    private final NoteType TYPE;
    /**
     * Beat to activate on
     */
    @Setter
    private Double time;
    /**
     * Angle to activate at
     */
    private Double angle;
    /**
     * Angle to end up at
     */
    private Double endAngle;
    /**
     * Order to run on, lower = first
     * Defaults to 0
     */
    @Setter
    private Integer order;
    /**
     * Speed multiplier for approach
     */
    @Setter
    private Double speedMult;
    /**
     * Ease to use while rotating
     * Defaults to LINEAR
     */
    @Setter
    private Ease spinEase;

    protected Note(NoteType type, double time, double angle) {
        this.TYPE = type;
        this.time = time;
        this.angle = Math.abs(angle) % 360;
    }

    public Note setAngle(double angle) {
        this.angle = Math.abs(angle) % 360;
        return this;
    }

    public Note setEndAngle(double endAngle) {
        this.endAngle = Math.abs(endAngle) % 360;
        return this;
    }

    public static class Deserializer implements JsonDeserializer<Note> {
        @Override
        public Note deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            NoteType type = NoteType.fromString(jsonObject.get("type").getAsString());

            return switch (type) {
                case BLOCK -> context.deserialize(json, Block.class);
                case HOLD -> context.deserialize(json, Hold.class);
                case MINE -> context.deserialize(json, Mine.class);
                case SIDE -> context.deserialize(json, Side.class);
                case EXTRA_TAP -> context.deserialize(json, ExtraTap.class);
                case MINE_HOLD -> context.deserialize(json, MineHold.class);
                case INVERSE_BLOCK -> context.deserialize(json, InverseBlock.class);
                case null -> null;
            };
        }
    }
}
