package kr.co.popone.fitts.feature.feeds.title;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FittieInfoTitleView extends FrameLayout {
    private HashMap _$_findViewCache;
    private final CircleImageView ivFittieCover = ((CircleImageView) this.view.findViewById(C0010R$id.iv_feed_fittie_profile));
    private final TextView tvContentsFirst = ((TextView) this.view.findViewById(C0010R$id.tv_feed_title_first));
    private final TextView tvContentsSecond = ((TextView) this.view.findViewById(C0010R$id.tv_feed_title_second));
    private final TextView tvFittieId = ((TextView) this.view.findViewById(C0010R$id.tv_feed_fittie_id));
    private final View view;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public FittieInfoTitleView(@NotNull Context context, @Nullable SessionManager sessionManager, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        View inflate = LayoutInflater.from(context).inflate(C0013R$layout.view_fittie_type_title, this);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…_fittie_type_title, this)");
        this.view = inflate;
        updateView(sessionManager, str, str2);
    }

    private final void updateView(SessionManager sessionManager, String str, String str2) {
        if (str == null || str2 == null) {
            ViewExtensionsKt.gone(this);
            return;
        }
        if (sessionManager != null) {
            MyInfo userInfo = sessionManager.getUserInfo();
            if (userInfo != null) {
                TextView textView = this.tvFittieId;
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvFittieId");
                textView.setText(userInfo.getFittsID());
                CircleImageView circleImageView = this.ivFittieCover;
                Intrinsics.checkExpressionValueIsNotNull(circleImageView, "ivFittieCover");
                ImageViewExtensionKt.loadImageAsProfile(circleImageView, userInfo.getProfileImageUrl());
            }
        }
        TextView textView2 = this.tvContentsFirst;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvContentsFirst");
        textView2.setText(str);
        TextView textView3 = this.tvContentsSecond;
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvContentsSecond");
        textView3.setText(str2);
    }
}
