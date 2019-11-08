package kr.co.popone.fitts.feature.identification.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.VoidToUnit;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IdentificationAdditionalInfoFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final CompositeDisposable viewDisposable = new CompositeDisposable();
    @NotNull
    public IdentificationAdditionalInfoViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IdentificationAdditionalInfoFragment newInstance() {
            return new IdentificationAdditionalInfoFragment();
        }
    }

    @NotNull
    public static final IdentificationAdditionalInfoFragment newInstance() {
        return Companion.newInstance();
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
    public final IdentificationAdditionalInfoViewModel getViewModel() {
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel = this.viewModel;
        if (identificationAdditionalInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return identificationAdditionalInfoViewModel;
    }

    public final void setViewModel(@NotNull IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel) {
        Intrinsics.checkParameterIsNotNull(identificationAdditionalInfoViewModel, "<set-?>");
        this.viewModel = identificationAdditionalInfoViewModel;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.activity_identification_additional_info, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        String str = "editSsnSecond";
        if (activity != null) {
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSsnSecond);
            Intrinsics.checkExpressionValueIsNotNull(editText, str);
            KeyboardExtensionKt.showKeyboard(activity, editText);
        }
        CompositeDisposable compositeDisposable = this.viewDisposable;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C0010R$id.backButton);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "backButton");
        Observable map = RxView.clicks(frameLayout).map(VoidToUnit.INSTANCE);
        String str2 = "RxView.clicks(this).map(VoidToUnit)";
        Intrinsics.checkExpressionValueIsNotNull(map, str2);
        Disposable subscribe = map.subscribe((Consumer<? super T>) IdentificationAdditionalInfoFragment$onViewCreated$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "backButton.clicks()\n    …WINDOW)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.viewDisposable;
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.confirmButton);
        Intrinsics.checkExpressionValueIsNotNull(textView, "confirmButton");
        Observable map2 = RxView.clicks(textView).map(VoidToUnit.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(map2, str2);
        Disposable subscribe2 = map2.subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$2<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "confirmButton.clicks()\n …Input()\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.viewDisposable;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editSsnSecond);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        InitialValueObservable afterTextChangeEvents = RxTextView.afterTextChangeEvents(editText2);
        Intrinsics.checkExpressionValueIsNotNull(afterTextChangeEvents, "RxTextView.afterTextChangeEvents(this)");
        Disposable subscribe3 = afterTextChangeEvents.doOnError(IdentificationAdditionalInfoFragment$onViewCreated$3.INSTANCE).subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$4<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "editSsnSecond.afterTextC…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.viewDisposable;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editSsnSecond);
        Intrinsics.checkExpressionValueIsNotNull(editText3, str);
        InitialValueObservable textChanges = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        Disposable subscribe4 = textChanges.subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$5<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe4, "editSsnSecond.textChange…ring())\n                }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.viewDisposable;
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel = this.viewModel;
        String str3 = "viewModel";
        if (identificationAdditionalInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        Disposable subscribe5 = identificationAdditionalInfoViewModel.getUserIdentificationSubject().doOnError(IdentificationAdditionalInfoFragment$onViewCreated$6.INSTANCE).subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$7<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe5, "viewModel.userIdentifica…ontact)\n                }");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.viewDisposable;
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel2 = this.viewModel;
        if (identificationAdditionalInfoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        Disposable subscribe6 = identificationAdditionalInfoViewModel2.getSecondSsnNotInvalid().subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$8<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe6, "viewModel.secondSsnNotIn…lor)) }\n                }");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        CompositeDisposable compositeDisposable7 = this.viewDisposable;
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel3 = this.viewModel;
        if (identificationAdditionalInfoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        Disposable subscribe7 = identificationAdditionalInfoViewModel3.getIdentificationResult().subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$9<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe7, "viewModel.identification…(state)\n                }");
        DisposableKt.plusAssign(compositeDisposable7, subscribe7);
        CompositeDisposable compositeDisposable8 = this.viewDisposable;
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel4 = this.viewModel;
        if (identificationAdditionalInfoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        Disposable subscribe8 = identificationAdditionalInfoViewModel4.getErrorOccurSubject().subscribe((Consumer<? super T>) new IdentificationAdditionalInfoFragment$onViewCreated$10<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe8, "viewModel.errorOccurSubj…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable8, subscribe8);
        IdentificationAdditionalInfoViewModel identificationAdditionalInfoViewModel5 = this.viewModel;
        if (identificationAdditionalInfoViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str3);
        }
        identificationAdditionalInfoViewModel5.initModel();
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public void onDestroy() {
        super.onDestroy();
        this.viewDisposable.clear();
    }
}
