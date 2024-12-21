package me.eren.beatblockeditor;

import com.google.gson.*;

import java.lang.reflect.Type;

public enum Ease {

    LINEAR("linear"),
    IN_SINE("inSine"), OUT_SINE("outSine"), IN_OUT_SINE("inOutSine"),
    IN_QUAD("inQuad"), OUT_QUAD("outQuad"), IN_OUT_QUAD("inOutQuad"),
    IN_CUBIC("inCubic"), OUT_CUBIC("outCubic"), IN_OUT_CUBIC("inOutCubic"),
    IN_QUART("inQuart"), OUT_QUART("outQuart"), IN_OUT_QUART("inOutQuart"),
    IN_QUINT("inQuint"), OUT_QUINT("outQuint"), IN_OUT_QUINT("inOutQuint"),
    IN_EXPO("inExpo"), OUT_EXPO("outExpo"), IN_OUT_EXPO("inOutExpo"),
    IN_CIRC("inCirc"), OUT_CIRC("outCirc"), IN_OUT_CIRC("inOutCirc"),
    IN_ELASTIC("inElastic"), OUT_ELASTIC("outElastic"), IN_OUT_ELASTIC("inOutElastic"),
    IN_BACK("inBack"), OUT_BACK("outBack"), IN_OUT_BACK("inOutBack");

    final String name;

    Ease(String name) {
        this.name = name;
    }

    public static Ease fromString(String name) {
        for (Ease e : Ease.values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Adapter implements JsonSerializer<Ease>, JsonDeserializer<Ease> {

        @Override
        public JsonElement serialize(Ease src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        @Override
        public Ease deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Ease.fromString(json.getAsString());
        }

    }

}
