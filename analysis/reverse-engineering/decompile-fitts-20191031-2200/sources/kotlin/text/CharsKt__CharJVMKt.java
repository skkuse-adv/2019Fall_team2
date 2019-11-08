package kotlin.text;

import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

class CharsKt__CharJVMKt {
    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    @NotNull
    public static final CharCategory getCategory(char c) {
        return CharCategory.Companion.valueOf(Character.getType(c));
    }

    @NotNull
    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(c));
    }

    public static final int digitOf(char c, int i) {
        return Character.digit(c, i);
    }

    public static int checkRadix(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("radix ");
        sb.append(i);
        sb.append(" was not in valid range ");
        sb.append(new IntRange(2, 36));
        throw new IllegalArgumentException(sb.toString());
    }
}
