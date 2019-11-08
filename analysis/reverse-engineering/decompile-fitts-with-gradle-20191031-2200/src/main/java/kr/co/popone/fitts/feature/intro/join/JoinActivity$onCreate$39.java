package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.Observable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.service.join.RecommenderCheckState;
import org.jetbrains.annotations.NotNull;

final class JoinActivity$onCreate$39 extends FunctionReference implements Function1<String, Observable<RecommenderCheckState>> {
    JoinActivity$onCreate$39(JoinActivity joinActivity) {
        super(1, joinActivity);
    }

    public final String getName() {
        return "checkValidInvitationCode";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(JoinActivity.class);
    }

    public final String getSignature() {
        return "checkValidInvitationCode(Ljava/lang/String;)Lio/reactivex/Observable;";
    }

    @NotNull
    public final Observable<RecommenderCheckState> invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "p1");
        return ((JoinActivity) this.receiver).checkValidInvitationCode(str);
    }
}
