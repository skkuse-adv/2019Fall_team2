package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class CharCategory$Companion$categoryMap$2 extends Lambda implements Function0<Map<Integer, ? extends CharCategory>> {
    public static final CharCategory$Companion$categoryMap$2 INSTANCE = new CharCategory$Companion$categoryMap$2();

    CharCategory$Companion$categoryMap$2() {
        super(0);
    }

    @NotNull
    public final Map<Integer, CharCategory> invoke() {
        CharCategory[] values = CharCategory.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(values.length), 16));
        for (CharCategory charCategory : values) {
            linkedHashMap.put(Integer.valueOf(charCategory.getValue()), charCategory);
        }
        return linkedHashMap;
    }
}
