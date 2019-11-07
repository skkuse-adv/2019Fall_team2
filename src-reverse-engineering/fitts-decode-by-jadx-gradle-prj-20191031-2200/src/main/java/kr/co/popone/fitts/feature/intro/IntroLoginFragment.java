package kr.co.popone.fitts.feature.intro;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.utils.UIExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntroLoginFragment extends Fragment {
    private HashMap _$_findViewCache;
    @NotNull
    public EventTracker eventTracker;
    private IntroActivity introActivity;

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
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(C0013R$layout.fragment_intro_login, viewGroup, false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.introActivity = (IntroActivity) activity;
            IntroActivity introActivity2 = this.introActivity;
            if (introActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("introActivity");
            }
            this.eventTracker = introActivity2.getEventTracker$app_productionFittsRelease();
            float f = (float) 24;
            Context requireContext = requireContext();
            Intrinsics.checkExpressionValueIsNotNull(requireContext, "requireContext()");
            Resources resources = requireContext.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "requireContext().resources");
            int roundToInt = MathKt__MathJVMKt.roundToInt(f * resources.getDisplayMetrics().density);
            Resources resources2 = getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources2, "resources");
            inflate.setPadding(roundToInt, 0, roundToInt, UIExtensionsKt.navigationBarHeight(resources2) + roundToInt);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "inflatedView");
            inflate.setTag(Integer.valueOf(4));
            return inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.intro.IntroActivity");
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((Button) _$_findCachedViewById(C0010R$id.facebookAuthenticationButton)).setOnClickListener(new IntroLoginFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.kakaoAuthenticationButton)).setOnClickListener(new IntroLoginFragment$onViewCreated$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.emailAuthenticationButton)).setOnClickListener(new IntroLoginFragment$onViewCreated$3(this));
        ((TextView) _$_findCachedViewById(C0010R$id.showLoginButton)).setOnClickListener(new IntroLoginFragment$onViewCreated$4(this));
    }
}
