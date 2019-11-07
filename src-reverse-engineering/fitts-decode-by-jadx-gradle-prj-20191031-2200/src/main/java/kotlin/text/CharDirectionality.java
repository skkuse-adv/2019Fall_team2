package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Lazy directionalityMap$delegate = null;
    private final int value;

    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = null;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "directionalityMap", "getDirectionalityMap()Ljava/util/Map;"))};
        }

        private final Map<Integer, CharDirectionality> getDirectionalityMap() {
            Lazy access$getDirectionalityMap$cp = CharDirectionality.directionalityMap$delegate;
            Companion companion = CharDirectionality.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (Map) access$getDirectionalityMap$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CharDirectionality valueOf(int i) {
            CharDirectionality charDirectionality = (CharDirectionality) getDirectionalityMap().get(Integer.valueOf(i));
            if (charDirectionality != null) {
                return charDirectionality;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Directionality #");
            sb.append(i);
            sb.append(" is not defined.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private CharDirectionality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        directionalityMap$delegate = LazyKt__LazyJVMKt.lazy(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
    }
}
