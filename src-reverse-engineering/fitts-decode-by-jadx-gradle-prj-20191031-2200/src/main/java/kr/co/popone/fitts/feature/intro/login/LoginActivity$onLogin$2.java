package kr.co.popone.fitts.feature.intro.login;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.user.BodyFilter;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class LoginActivity$onLogin$2<T> implements Consumer<MyInfo> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onLogin$2(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void accept(MyInfo myInfo) {
        this.this$0.getSessionManager$app_productionFittsRelease().setFirstAppStart(true);
        this.this$0.getSessionManager$app_productionFittsRelease().setUserInfo(myInfo);
        int weight = myInfo.getBodyInfo().getWeight() - 10;
        BodyFilter bodyFilter = myInfo.getBodyFilter();
        if (bodyFilter == null) {
            Intrinsics.throwNpe();
        }
        if (weight > bodyFilter.getMin_weight() || myInfo.getBodyInfo().getWeight() + 10 < myInfo.getBodyFilter().getMin_weight()) {
            myInfo.getBodyFilter().setMin_weight(myInfo.getBodyInfo().getWeight() - 10);
        }
        if (myInfo.getBodyInfo().getWeight() + 10 < myInfo.getBodyFilter().getMax_weight() || myInfo.getBodyFilter().getMin_weight() > myInfo.getBodyFilter().getMax_weight()) {
            myInfo.getBodyFilter().setMax_weight(myInfo.getBodyInfo().getWeight() + 10);
        }
        if (myInfo.getBodyInfo().getHeight() - 10 > myInfo.getBodyFilter().getMin_height() || myInfo.getBodyInfo().getHeight() + 10 < myInfo.getBodyFilter().getMin_height()) {
            myInfo.getBodyFilter().setMin_height(myInfo.getBodyInfo().getHeight() - 10);
        }
        if (myInfo.getBodyInfo().getHeight() + 10 < myInfo.getBodyFilter().getMax_height() || myInfo.getBodyFilter().getMin_height() > myInfo.getBodyFilter().getMax_height()) {
            myInfo.getBodyFilter().setMax_height(myInfo.getBodyInfo().getHeight() + 10);
        }
        this.this$0.getSessionManager$app_productionFittsRelease().setHeight(myInfo.getBodyInfo().getHeight());
        this.this$0.getSessionManager$app_productionFittsRelease().setWeight(myInfo.getBodyInfo().getWeight());
        this.this$0.getSessionManager$app_productionFittsRelease().setSimilarityBodyFilter(Integer.valueOf(myInfo.getBodyFilter().getMin_height()), Integer.valueOf(myInfo.getBodyFilter().getMax_height()), Integer.valueOf(myInfo.getBodyFilter().getMin_weight()), Integer.valueOf(myInfo.getBodyFilter().getMax_weight()));
        this.this$0.gotoMainView();
    }
}
