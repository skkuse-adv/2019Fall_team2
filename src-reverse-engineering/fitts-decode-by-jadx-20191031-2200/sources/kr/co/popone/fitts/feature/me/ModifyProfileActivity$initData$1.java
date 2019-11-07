package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.orhanobut.logger.Logger;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.utils.Snackbar;
import retrofit2.HttpException;

final class ModifyProfileActivity$initData$1<T1, T2> implements BiConsumer<MyInfo, Throwable> {
    final /* synthetic */ ModifyProfileActivity this$0;

    ModifyProfileActivity$initData$1(ModifyProfileActivity modifyProfileActivity) {
        this.this$0 = modifyProfileActivity;
    }

    public final void accept(MyInfo myInfo, Throwable th) {
        this.this$0.userInfoRequest = null;
        if (myInfo != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.profile_id);
            Intrinsics.checkExpressionValueIsNotNull(textView, "profile_id");
            textView.setText(myInfo.getFittsID());
            BaseRequestOptions error = ((RequestOptions) new RequestOptions().placeholder((int) C0008R$drawable.image_default_profile_large)).error((int) C0008R$drawable.image_default_profile_large);
            Intrinsics.checkExpressionValueIsNotNull(error, "RequestOptions().placeho…ge_default_profile_large)");
            Glide.with((FragmentActivity) this.this$0).load(myInfo.getProfileImageUrl()).apply((BaseRequestOptions<?>) (RequestOptions) error).into((ImageView) (CircleImageView) this.this$0._$_findCachedViewById(C0010R$id.profile_image));
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.profile_email);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "profile_email");
            textView2.setText(myInfo.getEmail());
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.modify_profile_button);
            linearLayout.setOnClickListener(new ModifyProfileActivity$initData$1$$special$$inlined$run$lambda$1(linearLayout, this));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            Snackbar.Companion.showMessage(this.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
