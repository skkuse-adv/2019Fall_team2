package kotlin.text;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CharIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = ((Boolean) function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length)))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!((Boolean) function1.invoke(Character.valueOf(charSequence.charAt(i)))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (((Boolean) function1.invoke(Character.valueOf(charSequence.charAt(length)))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    @NotNull
    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(charSequence, i, c);
    }

    @NotNull
    public static final CharSequence padStart(@NotNull CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Desired length ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb2.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    @NotNull
    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padStart(str, i, c);
    }

    @NotNull
    public static final String padStart(@NotNull String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return padStart((CharSequence) str, i, c).toString();
    }

    @NotNull
    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(charSequence, i, c);
    }

    @NotNull
    public static final CharSequence padEnd(@NotNull CharSequence charSequence, int i, char c) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Desired length ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i);
            sb2.append(charSequence);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb2.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb2;
        }
    }

    @NotNull
    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = ' ';
        }
        return padEnd(str, i, c);
    }

    @NotNull
    public static final String padEnd(@NotNull String str, int i, char c) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        return padEnd((CharSequence) str, i, c).toString();
    }

    @NotNull
    public static final CharIterator iterator(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return new StringsKt__StringsKt$iterator$1(charSequence);
    }

    @NotNull
    public static final IntRange getIndices(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int getLastIndex(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        int length = charSequence.length() - 2;
        if (i >= 0 && length >= i && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1))) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String substring(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence subSequence(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final String substring(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    @NotNull
    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBefore(str, c, str2);
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBefore(str, str2, str3);
    }

    @NotNull
    public static final String substringBefore(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfter(str, c, str2);
    }

    @NotNull
    public static final String substringAfter(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(indexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfter(str, str2, str3);
    }

    @NotNull
    public static final String substringAfter(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(indexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringBeforeLast(str, c, str2);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringBeforeLast(str, str2, str3);
    }

    @NotNull
    public static final String substringBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(0, lastIndexOf$default);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return substringAfterLast(str, c, str2);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String str, char c, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str2;
        }
        String substring = str.substring(lastIndexOf$default + 1, str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return substringAfterLast(str, str2, str3);
    }

    @NotNull
    public static final String substringAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return str3;
        }
        String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence charSequence, int i, int i2, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            return sb;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("End index (");
        sb2.append(i2);
        sb2.append(") is less than start index (");
        sb2.append(i);
        sb2.append(").");
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    @NotNull
    public static final CharSequence replaceRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        Intrinsics.checkParameterIsNotNull(charSequence2, "replacement");
        return replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("End index (");
            sb.append(i2);
            sb.append(") is less than start index (");
            sb.append(i);
            sb.append(").");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence.length() - (i2 - i));
            sb2.append(charSequence, 0, i);
            sb2.append(charSequence, i2, charSequence.length());
            return sb2;
        }
    }

    @NotNull
    public static final CharSequence removeRange(@NotNull CharSequence charSequence, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        return removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final CharSequence removePrefix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final String removePrefix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        if (!startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence removeSuffix(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @NotNull
    public static final String removeSuffix(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "suffix");
        if (!endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "suffix");
        if (charSequence.length() < charSequence2.length() + charSequence3.length() || !startsWith$default(charSequence, charSequence2, false, 2, (Object) null) || !endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length());
        }
        return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null) || !endsWith$default((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @NotNull
    public static final CharSequence removeSurrounding(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "delimiter");
        return removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    @NotNull
    public static final String removeSurrounding(@NotNull String str, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "delimiter");
        return removeSurrounding(str, charSequence, charSequence);
    }

    @NotNull
    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBefore(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange(str, 0, indexOf$default, str2).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBefore(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBefore(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange(str, 0, indexOf$default, str3).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfter(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str3 : replaceRange(str, indexOf$default + 1, str.length(), str2).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfter(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceAfter(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        int indexOf$default = indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return indexOf$default == -1 ? str4 : replaceRange(str, indexOf$default + str2.length(), str.length(), str3).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceAfterLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange(str, lastIndexOf$default + str2.length(), str.length(), str3).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceAfterLast(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceAfterLast(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange(str, lastIndexOf$default + 1, str.length(), str2).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return replaceBeforeLast(str, c, str2, str3);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, char c, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "replacement");
        Intrinsics.checkParameterIsNotNull(str3, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str3 : replaceRange(str, 0, lastIndexOf$default, str2).toString();
    }

    @NotNull
    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return replaceBeforeLast(str, str2, str3, str4);
    }

    @NotNull
    public static final String replaceBeforeLast(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str2, "delimiter");
        Intrinsics.checkParameterIsNotNull(str3, "replacement");
        Intrinsics.checkParameterIsNotNull(str4, "missingDelimiterValue");
        int lastIndexOf$default = lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default == -1 ? str4 : replaceRange(str, 0, lastIndexOf$default, str3).toString();
    }

    public static final boolean regionMatchesImpl(@NotNull CharSequence charSequence, int i, @NotNull CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, c, z);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(0), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, c, z);
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return charSequence.length() > 0 && CharsKt__CharKt.equals(charSequence.charAt(getLastIndex(charSequence)), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, z);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(charSequence, charSequence2, i, z);
    }

    public static final boolean startsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, null);
        }
        return regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    @NotNull
    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonPrefixWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final String commonPrefixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (hasSurrogatePairAt(charSequence, i2) || hasSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    @NotNull
    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return commonSuffixWith(charSequence, charSequence2, z);
    }

    @NotNull
    public static final String commonSuffixWith(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int min = Math.min(length, length2);
        int i = 0;
        while (i < min && CharsKt__CharKt.equals(charSequence.charAt((length - i) - 1), charSequence2.charAt((length2 - i) - 1), z)) {
            i++;
        }
        if (hasSurrogatePairAt(charSequence, (length - i) - 1) || hasSurrogatePairAt(charSequence2, (length2 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, cArr, i, z);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
            int lastIndex = getLastIndex(charSequence);
            if (coerceAtLeast <= lastIndex) {
                while (true) {
                    char charAt = charSequence.charAt(coerceAtLeast);
                    int length = cArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z2 = false;
                            break;
                        } else if (CharsKt__CharKt.equals(cArr[i2], charAt, z)) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        if (coerceAtLeast == lastIndex) {
                            break;
                        }
                        coerceAtLeast++;
                    } else {
                        return coerceAtLeast;
                    }
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt___ArraysKt.single(cArr), i);
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int coerceAtMost = RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
                char charAt = charSequence.charAt(coerceAtMost);
                int length = cArr.length;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (CharsKt__CharKt.equals(cArr[i2], charAt, z)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return coerceAtMost;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.single(cArr), i);
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int indexOf$StringsKt__StringsKt(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            intProgression = new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), RangesKt___RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            intProgression = RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), RangesKt___RangesKt.coerceAtLeast(i2, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int first = intProgression.getFirst();
            int last = intProgression.getLast();
            int step = intProgression.getStep();
            if (step <= 0 ? first >= last : first <= last) {
                while (true) {
                    if (!regionMatchesImpl(charSequence2, 0, charSequence, first, charSequence2.length(), z)) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return first;
                    }
                }
            }
        } else {
            int first2 = intProgression.getFirst();
            int last2 = intProgression.getLast();
            int step2 = intProgression.getStep();
            if (step2 <= 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    if (!StringsKt__StringsJVMKt.regionMatches((String) charSequence2, 0, (String) charSequence, first2, charSequence2.length(), z)) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return first2;
                    }
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(@NotNull CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        Pair<Integer, String> pair = null;
        if (z || collection.size() != 1) {
            IntProgression intRange = !z2 ? new IntRange(RangesKt___RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt___RangesKt.downTo(RangesKt___RangesKt.coerceAtMost(i, getLastIndex(charSequence)), 0);
            if (charSequence instanceof String) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                int step = intRange.getStep();
                if (step <= 0 ? first >= last : first <= last) {
                    while (true) {
                        Iterator it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            String str = (String) obj2;
                            if (StringsKt__StringsJVMKt.regionMatches(str, 0, (String) charSequence, first, str.length(), z)) {
                                break;
                            }
                        }
                        String str2 = (String) obj2;
                        if (str2 == null) {
                            if (first == last) {
                                break;
                            }
                            first += step;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first), str2);
                        }
                    }
                }
            } else {
                int first2 = intRange.getFirst();
                int last2 = intRange.getLast();
                int step2 = intRange.getStep();
                if (step2 <= 0 ? first2 >= last2 : first2 <= last2) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it2.next();
                            String str3 = (String) obj;
                            if (regionMatchesImpl(str3, 0, charSequence, first2, str3.length(), z)) {
                                break;
                            }
                        }
                        String str4 = (String) obj;
                        if (str4 == null) {
                            if (first2 == last2) {
                                break;
                            }
                            first2 += step2;
                        } else {
                            return TuplesKt.to(Integer.valueOf(first2), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.single((Iterable<? extends T>) collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i2 = i;
        int indexOf$default = !z2 ? indexOf$default(charSequence2, str6, i2, false, 4, (Object) null) : lastIndexOf$default(charSequence2, str6, i2, false, 4, (Object) null);
        if (indexOf$default >= 0) {
            pair = TuplesKt.to(Integer.valueOf(indexOf$default), str5);
        }
        return pair;
    }

    @Nullable
    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findAnyOf(charSequence, collection, i, z);
    }

    @Nullable
    public static final Pair<Integer, String> findAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    @Nullable
    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return findLastAnyOf(charSequence, collection, i, z);
    }

    @Nullable
    public static final Pair<Integer, String> findLastAnyOf(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOfAny(charSequence, collection, i, z);
    }

    public static final int indexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (findAnyOf$StringsKt__StringsKt != null) {
            Integer num = (Integer) findAnyOf$StringsKt__StringsKt.getFirst();
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOfAny(charSequence, collection, i, z);
    }

    public static final int lastIndexOfAny(@NotNull CharSequence charSequence, @NotNull Collection<String> collection, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "strings");
        Pair findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (findAnyOf$StringsKt__StringsKt != null) {
            Integer num = (Integer) findAnyOf$StringsKt__StringsKt.getFirst();
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, c, i, z);
    }

    public static final int indexOf(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return indexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i);
        }
        return lastIndexOfAny(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, charSequence2, z);
    }

    public static final boolean contains(@NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return contains(charSequence, c, z);
    }

    public static final boolean contains(@NotNull CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$2(cArr, z));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(@NotNull CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new DelimitedRangesSequence(charSequence, i, i2, new StringsKt__StringsKt$rangesDelimitedBy$4(ArraysKt___ArraysJvmKt.asList((T[]) strArr), z));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, strArr, z, i);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    @NotNull
    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, strArr, z, i);
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(strArr, "delimiters");
        if (strArr.length == 1) {
            boolean z2 = false;
            String str = strArr[0];
            if (str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(substring(charSequence, substring));
        }
        return arrayList;
    }

    @NotNull
    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return splitToSequence(charSequence, cArr, z, i);
    }

    @NotNull
    public static final Sequence<String> splitToSequence(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        return SequencesKt___SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$2(charSequence));
    }

    @NotNull
    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return split(charSequence, cArr, z, i);
    }

    @NotNull
    public static final List<String> split(@NotNull CharSequence charSequence, @NotNull char[] cArr, boolean z, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "delimiters");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable<IntRange> asIterable = SequencesKt___SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(asIterable, 10));
        for (IntRange substring : asIterable) {
            arrayList.add(substring(charSequence, substring));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(@NotNull CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int indexOf = indexOf(charSequence, str, 0, z);
            if (indexOf == -1 || i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
            }
            boolean z2 = i > 0;
            int i3 = 10;
            if (z2) {
                i3 = RangesKt___RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            do {
                arrayList.add(charSequence.subSequence(i2, indexOf).toString());
                i2 = str.length() + indexOf;
                if (z2 && arrayList.size() == i - 1) {
                    break;
                }
                indexOf = indexOf(charSequence, str, i2, z);
            } while (indexOf != -1);
            arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @NotNull
    public static final List<String> lines(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        return SequencesKt___SequencesKt.toList(lineSequence(charSequence));
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = ((Boolean) function1.invoke(Character.valueOf(str.charAt(!z ? i : length)))).booleanValue();
            if (!z) {
                if (!booleanValue) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!booleanValue) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                obj = "";
                break;
            } else if (!((Boolean) function1.invoke(Character.valueOf(str.charAt(i)))).booleanValue()) {
                obj = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return obj.toString();
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull Function1<? super Character, Boolean> function1) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!((Boolean) function1.invoke(Character.valueOf(str.charAt(length)))).booleanValue()) {
                    obj = str.subSequence(0, length + 1);
                    break;
                }
            } else {
                obj = "";
                break;
            }
        }
        return obj.toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final String trim(@NotNull String str, @NotNull char... cArr) {
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt___ArraysKt.contains(cArr, str.charAt(!z ? i : length));
            if (!z) {
                if (!contains) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!contains) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final String trimStart(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                obj = "";
                break;
            } else if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(i))) {
                obj = str.subSequence(i, str.length());
                break;
            } else {
                i++;
            }
        }
        return obj.toString();
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence, @NotNull char... cArr) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (ArraysKt___ArraysKt.contains(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @NotNull
    public static final String trimEnd(@NotNull String str, @NotNull char... cArr) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(str, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr, "chars");
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                if (!ArraysKt___ArraysKt.contains(cArr, str.charAt(length))) {
                    obj = str.subSequence(0, length + 1);
                    break;
                }
            } else {
                obj = "";
                break;
            }
        }
        return obj.toString();
    }

    @NotNull
    public static final CharSequence trim(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (!z) {
                if (!isWhitespace) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!isWhitespace) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    @NotNull
    public static final CharSequence trimStart(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    @NotNull
    public static final CharSequence trimEnd(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "receiver$0");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }
}
