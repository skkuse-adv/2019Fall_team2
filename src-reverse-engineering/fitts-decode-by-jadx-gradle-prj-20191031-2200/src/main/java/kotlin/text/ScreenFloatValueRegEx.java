package kotlin.text;

import org.jetbrains.annotations.NotNull;

final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    @NotNull
    public static final Regex value;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("[eE][+-]?");
        String str = "(\\p{Digit}+)";
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        String str2 = "(0[xX]";
        sb3.append(str2);
        String str3 = "(\\p{XDigit}+)";
        sb3.append(str3);
        sb3.append("(\\.)?)|");
        sb3.append(str2);
        sb3.append(str3);
        sb3.append("?(\\.)");
        sb3.append(str3);
        sb3.append(')');
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append('(');
        sb5.append(str);
        sb5.append("(\\.)?(");
        sb5.append(str);
        sb5.append("?)(");
        sb5.append(sb2);
        String str4 = ")?)|";
        sb5.append(str4);
        sb5.append("(\\.(");
        sb5.append(str);
        sb5.append(")(");
        sb5.append(sb2);
        sb5.append(str4);
        sb5.append("((");
        sb5.append(sb4);
        sb5.append(")[pP][+-]?");
        sb5.append(str);
        sb5.append(')');
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        sb7.append(sb6);
        sb7.append(")[fFdD]?))[\\x00-\\x20]*");
        value = new Regex(sb7.toString());
    }

    private ScreenFloatValueRegEx() {
    }
}
