package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Regex implements Serializable {
    public static final Companion Companion = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public static final class Companion {
        /* access modifiers changed from: private */
        public final int ensureUnicodeCase(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Regex fromLiteral(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "literal");
            return new Regex(str, RegexOption.LITERAL);
        }

        @NotNull
        public final String escape(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "literal");
            String quote = Pattern.quote(str);
            Intrinsics.checkExpressionValueIsNotNull(quote, "Pattern.quote(literal)");
            return quote;
        }

        @NotNull
        public final String escapeReplacement(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "literal");
            String quoteReplacement = Matcher.quoteReplacement(str);
            Intrinsics.checkExpressionValueIsNotNull(quoteReplacement, "Matcher.quoteReplacement(literal)");
            return quoteReplacement;
        }
    }

    private static final class Serialized implements Serializable {
        public static final Companion Companion = new Companion(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        @NotNull
        private final String pattern;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(@NotNull String str, int i) {
            Intrinsics.checkParameterIsNotNull(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        public final int getFlags() {
            return this.flags;
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    public Regex(@NotNull Pattern pattern) {
        Intrinsics.checkParameterIsNotNull(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public Regex(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        Pattern compile = Pattern.compile(str);
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern)");
        this(compile);
    }

    public Regex(@NotNull String str, @NotNull RegexOption regexOption) {
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        Intrinsics.checkParameterIsNotNull(regexOption, "option");
        Pattern compile = Pattern.compile(str, Companion.ensureUnicodeCase(regexOption.getValue()));
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(compile);
    }

    public Regex(@NotNull String str, @NotNull Set<? extends RegexOption> set) {
        Intrinsics.checkParameterIsNotNull(str, "pattern");
        Intrinsics.checkParameterIsNotNull(set, "options");
        Pattern compile = Pattern.compile(str, Companion.ensureUnicodeCase(RegexKt.toInt(set)));
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
        this(compile);
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set<? extends RegexOption> set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        CollectionsKt__MutableCollectionsKt.retainAll((Iterable<? extends T>) allOf, (Function1<? super T, Boolean>) new Regex$fromInt$$inlined$apply$lambda$1<Object,Boolean>(flags));
        Set<? extends RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.checkExpressionValueIsNotNull(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @Nullable
    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    @Nullable
    public final MatchResult find(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "nativePattern.matcher(input)");
        return RegexKt.findNext(matcher, i, charSequence);
    }

    @NotNull
    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    @NotNull
    public final Sequence<MatchResult> findAll(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        return SequencesKt__SequencesKt.generateSequence((Function0<? extends T>) new Regex$findAll$1<Object>(this, charSequence, i), (Function1<? super T, ? extends T>) Regex$findAll$2.INSTANCE);
    }

    @Nullable
    public final MatchResult matchEntire(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkExpressionValueIsNotNull(matcher, "nativePattern.matcher(input)");
        return RegexKt.matchEntire(matcher, charSequence);
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Intrinsics.checkParameterIsNotNull(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        Intrinsics.checkExpressionValueIsNotNull(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        int i = 0;
        MatchResult find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            if (find$default == null) {
                Intrinsics.throwNpe();
            }
            sb.append(charSequence, i, find$default.getRange().getStart().intValue());
            sb.append((CharSequence) function1.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        Intrinsics.checkParameterIsNotNull(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        Intrinsics.checkExpressionValueIsNotNull(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i) {
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (!matcher.find() || i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(charSequence.toString());
            }
            int i3 = 10;
            if (i > 0) {
                i3 = RangesKt___RangesKt.coerceAtMost(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i4 >= 0 && arrayList.size() == i4) {
                    break;
                }
            } while (matcher.find());
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
    public String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.toString()");
        return pattern;
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkExpressionValueIsNotNull(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }
}
