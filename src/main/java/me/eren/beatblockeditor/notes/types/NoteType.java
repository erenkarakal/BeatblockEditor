package me.eren.beatblockeditor.notes.types;

import com.google.gson.*;

import java.lang.reflect.Type;

public enum NoteType {
    BLOCK("block"),
    EXTRA_TAP("extraTap"),
    INVERSE_BLOCK("inverse"),
    MINE("mine"),
    SIDE("side"),
    MINE_HOLD("mineHold"),
    HOLD("hold");

    private final String type;

    NoteType(String type) {
        this.type = type;
    }

    public static NoteType fromString(String type) {
        return switch(type) {
            case "block" -> NoteType.BLOCK;
            case "extraTap" -> NoteType.EXTRA_TAP;
            case "inverse" -> NoteType.INVERSE_BLOCK;
            case "mine" -> NoteType.MINE;
            case "side" -> NoteType.SIDE;
            case "mineHold" -> NoteType.MINE_HOLD;
            case "hold" -> NoteType.HOLD;
            default -> null;
        };
    }

    @Override
    public String toString() {
        return type;
    }

    public static class Adapter implements JsonSerializer<NoteType>, JsonDeserializer<NoteType> {

        @Override
        public JsonElement serialize(NoteType noteType, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(noteType.toString());
        }

        @Override
        public NoteType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return NoteType.fromString(json.getAsString());
        }

    }

}
