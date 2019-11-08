package kotlin.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public enum CharCategory {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Lazy categoryMap$delegate = null;
    @NotNull
    private final String code;
    private final int value;

    public static final class Companion {
        static final /* synthetic */ KProperty[] $$delegatedProperties = null;

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Companion.class), "categoryMap", "getCategoryMap()Ljava/util/Map;"))};
        }

        private final Map<Integer, CharCategory> getCategoryMap() {
            Lazy access$getCategoryMap$cp = CharCategory.categoryMap$delegate;
            Companion companion = CharCategory.Companion;
            KProperty kProperty = $$delegatedProperties[0];
            return (Map) access$getCategoryMap$cp.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CharCategory valueOf(int i) {
            CharCategory charCategory = (CharCategory) getCategoryMap().get(Integer.valueOf(i));
            if (charCategory != null) {
                return charCategory;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Category #");
            sb.append(i);
            sb.append(" is not defined.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private CharCategory(int i, String str) {
        this.value = i;
        this.code = str;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion(null);
        categoryMap$delegate = LazyKt__LazyJVMKt.lazy(CharCategory$Companion$categoryMap$2.INSTANCE);
    }

    public final boolean contains(char c) {
        return Character.getType(c) == this.value;
    }
}
