package kr.co.popone.fitts.feature.alarm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.alarm.AlarmAdapter.Delegate;
import kr.co.popone.fitts.feature.base.Scrollable;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm.Type;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.utils.Snackbar;
import kr.co.popone.fitts.utils.Snackbar.Companion;
import kr.co.popone.fitts.viewmodel.alarm.AlarmViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AlarmFragment extends Fragment implements Delegate, Scrollable {
    private HashMap _$_findViewCache;
    private final AlarmAdapter alarmAdapter = new AlarmAdapter(this);
    @NotNull
    public AlarmViewModel vm;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.RUNNING.ordinal()] = 3;
            $EnumSwitchMapping$0[Status.SUCCESS.ordinal()] = 4;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 5;
        }
    }

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
    public final AlarmViewModel getVm() {
        AlarmViewModel alarmViewModel = this.vm;
        if (alarmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        return alarmViewModel;
    }

    public final void setVm(@NotNull AlarmViewModel alarmViewModel) {
        Intrinsics.checkParameterIsNotNull(alarmViewModel, "<set-?>");
        this.vm = alarmViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_alarm, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.alarmRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "alarmRecyclerView");
        recyclerView.setAdapter(this.alarmAdapter);
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.alarmRefreshLayout)).setOnRefreshListener(new AlarmFragment$onViewCreated$1(this));
        AlarmViewModel alarmViewModel = this.vm;
        String str = "vm";
        if (alarmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        alarmViewModel.updateAlarmList().observe(this, new AlarmFragment$sam$androidx_lifecycle_Observer$0(new AlarmFragment$onViewCreated$2(this.alarmAdapter)));
        AlarmViewModel alarmViewModel2 = this.vm;
        if (alarmViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        alarmViewModel2.showUpdateDialog().observe(this, new AlarmFragment$onViewCreated$3(this));
        AlarmViewModel alarmViewModel3 = this.vm;
        if (alarmViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        alarmViewModel3.updateNetworkState().observe(this, new AlarmFragment$sam$androidx_lifecycle_Observer$0(new AlarmFragment$onViewCreated$4(this)));
    }

    public void onAlarmClick(@NotNull String str, @Nullable Type type) {
        Intrinsics.checkParameterIsNotNull(str, "scheme");
        AlarmViewModel alarmViewModel = this.vm;
        if (alarmViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        alarmViewModel.alarmContentClick(requireActivity, str, type);
    }

    public void onProfileClick(@NotNull User user) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        if (Intrinsics.areEqual((Object) user.getStatus(), (Object) "deactivated")) {
            Companion companion = Snackbar.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            companion.showMessage(requireActivity, "탈퇴한 사용자입니다");
            return;
        }
        ShowRoomActivity.Companion.start(getContext(), Long.valueOf(user.getId()), "notification");
    }

    /* access modifiers changed from: private */
    public final void handleNetworkState(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "alarmRefreshLayout";
        if (i == 1) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.alarmRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 2) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.alarmRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i == 3 || i == 4) {
            this.alarmAdapter.updateNetworkState(networkState);
        } else if (i == 5) {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.alarmRefreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            FragmentExtensionKt.handleError(this, networkState.getMsg());
        }
    }

    /* access modifiers changed from: private */
    public final void showUpdateDialog() {
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        int color = ContextCompat.getColor(context2, C0006R$color.gray8);
        DialogExtensions.showConfirmDialog$default(dialogExtensions, context, "최신버전으로 업데이트 해주세요", "현재 버전에서는 볼 수 없는 페이지에요 ㅠ_ㅠ", new AlarmFragment$showUpdateDialog$1(this), null, "업데이트", "다음번에", color, 16, null);
    }

    public void scrollTop() {
        if (isAdded()) {
            ((RecyclerView) _$_findCachedViewById(C0010R$id.alarmRecyclerView)).scrollToPosition(0);
        }
    }
}
