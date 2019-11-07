package kr.co.popone.fitts.model.datamodel.service.join;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class RecommenderCheckState {

    public static final class InitState extends RecommenderCheckState {
        public static final InitState INSTANCE = new InitState();

        private InitState() {
            super(null);
        }
    }

    public static final class InvalidState extends RecommenderCheckState {
        public static final InvalidState INSTANCE = new InvalidState();

        private InvalidState() {
            super(null);
        }
    }

    public static final class ValidState extends RecommenderCheckState {
        @NotNull
        private final String code;

        @NotNull
        public static /* synthetic */ ValidState copy$default(ValidState validState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validState.code;
            }
            return validState.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.code;
        }

        @NotNull
        public final ValidState copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "code");
            return new ValidState(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.code, (java.lang.Object) ((kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.ValidState) r2).code) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.ValidState
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState$ValidState r2 = (kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.ValidState) r2
                java.lang.String r0 = r1.code
                java.lang.String r2 = r2.code
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState.ValidState.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.code;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ValidState(code=");
            sb.append(this.code);
            sb.append(")");
            return sb.toString();
        }

        public ValidState(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "code");
            super(null);
            this.code = str;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }
    }

    private RecommenderCheckState() {
    }

    public /* synthetic */ RecommenderCheckState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
