package kr.co.popone.fitts.feature.search;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.R$styleable;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchBar extends FrameLayout {
    private HashMap _$_findViewCache;
    @Nullable
    private Function0<Unit> cancelListener;
    /* access modifiers changed from: private */
    @NotNull
    public State searchBarState;
    /* access modifiers changed from: private */
    public final PublishSubject<String> searchSubject;
    private final BehaviorSubject<State> stateChangeSubject;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> textChangesSubject;

    public enum State {
        BEFORE_INPUT,
        INPUT,
        AFTER_INPUT
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[State.values().length];

        static {
            $EnumSwitchMapping$0[State.BEFORE_INPUT.ordinal()] = 1;
            $EnumSwitchMapping$0[State.INPUT.ordinal()] = 2;
            $EnumSwitchMapping$0[State.AFTER_INPUT.ordinal()] = 3;
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
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final State getSearchBarState() {
        return this.searchBarState;
    }

    @NotNull
    public final Editable getText() {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editSearchKeyword");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "editSearchKeyword.text");
        return text;
    }

    private final void setSearchBarHint(String str) {
        if (isLaidOut()) {
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
            Intrinsics.checkExpressionValueIsNotNull(editText, "editSearchKeyword");
            editText.setHint(str);
        }
    }

    @Nullable
    public final Function0<Unit> getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(@Nullable Function0<Unit> function0) {
        this.cancelListener = function0;
    }

    public SearchBar(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context);
        State state = State.BEFORE_INPUT;
        this.searchBarState = state;
        BehaviorSubject<State> createDefault = BehaviorSubject.createDefault(state);
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(State.BEFORE_INPUT)");
        this.stateChangeSubject = createDefault;
        BehaviorSubject<String> createDefault2 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, "BehaviorSubject.createDefault(\"\")");
        this.textChangesSubject = createDefault2;
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<String>()");
        this.searchSubject = create;
        initialize(context, null);
    }

    public SearchBar(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet);
        State state = State.BEFORE_INPUT;
        this.searchBarState = state;
        BehaviorSubject<State> createDefault = BehaviorSubject.createDefault(state);
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(State.BEFORE_INPUT)");
        this.stateChangeSubject = createDefault;
        BehaviorSubject<String> createDefault2 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, "BehaviorSubject.createDefault(\"\")");
        this.textChangesSubject = createDefault2;
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<String>()");
        this.searchSubject = create;
        initialize(context, attributeSet);
    }

    public SearchBar(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        super(context, attributeSet, i);
        State state = State.BEFORE_INPUT;
        this.searchBarState = state;
        BehaviorSubject<State> createDefault = BehaviorSubject.createDefault(state);
        Intrinsics.checkExpressionValueIsNotNull(createDefault, "BehaviorSubject.createDefault(State.BEFORE_INPUT)");
        this.stateChangeSubject = createDefault;
        BehaviorSubject<String> createDefault2 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, "BehaviorSubject.createDefault(\"\")");
        this.textChangesSubject = createDefault2;
        PublishSubject<String> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<String>()");
        this.searchSubject = create;
        initialize(context, attributeSet);
    }

    private final void initialize(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SearchBar);
            try {
                setSearchBarHint(obtainStyledAttributes.getString(0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        LayoutInflater.from(context).inflate(C0013R$layout.view_search_bar, this, true);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonCancel)).setOnClickListener(new SearchBar$initialize$1(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.buttonClear)).setOnClickListener(new SearchBar$initialize$2(this));
        ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setOnEditorActionListener(new SearchBar$initialize$3(this));
        ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).addTextChangedListener(new SearchBar$initialize$4(this));
        BehaviorSubject<String> behaviorSubject = this.textChangesSubject;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editSearchKeyword");
        behaviorSubject.onNext(editText.getText().toString());
        updateUI();
        this.stateChangeSubject.onNext(this.searchBarState);
    }

    public final void changeSearchBarState(@NotNull State state) {
        Intrinsics.checkParameterIsNotNull(state, "searchBarState");
        if (this.searchBarState != state) {
            this.searchBarState = state;
            updateUI();
            this.stateChangeSubject.onNext(state);
        }
    }

    @NotNull
    public final Observable<State> stateChanges() {
        return this.stateChangeSubject;
    }

    @NotNull
    public final Observable<String> textChanges() {
        return this.textChangesSubject;
    }

    @NotNull
    public final Observable<String> searchActions() {
        return this.searchSubject;
    }

    public final void goSearch(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setText(str);
        changeSearchBarState(State.AFTER_INPUT);
    }

    private final void updateUI() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.searchBarState.ordinal()];
        String str = "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager";
        String str2 = "input_method";
        String str3 = "buttonCancel";
        String str4 = "icon_search";
        String str5 = "buttonClear";
        String str6 = "검색";
        boolean z = true;
        String str7 = "editSearchKeyword";
        int i2 = 0;
        if (i != 1) {
            String str8 = "editSearchKeyword.text";
            if (i == 2) {
                EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
                Intrinsics.checkExpressionValueIsNotNull(editText, str7);
                editText.setHint(str6);
                ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setPadding(ViewExtensionsKt.dpToPx((View) this, 20), 0, 0, 0);
                ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).requestFocus();
                ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
                Intrinsics.checkExpressionValueIsNotNull(imageButton, str5);
                EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
                Intrinsics.checkExpressionValueIsNotNull(editText2, str7);
                Editable text = editText2.getText();
                Intrinsics.checkExpressionValueIsNotNull(text, str8);
                imageButton.setVisibility(text.length() > 0 ? 0 : 4);
                ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.icon_search);
                Intrinsics.checkExpressionValueIsNotNull(imageView, str4);
                imageView.setVisibility(4);
                TextView textView = (TextView) _$_findCachedViewById(C0010R$id.buttonCancel);
                Intrinsics.checkExpressionValueIsNotNull(textView, str3);
                textView.setVisibility(0);
                Object systemService = getContext().getSystemService(str2);
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword), 1);
                    return;
                }
                throw new TypeCastException(str);
            } else if (i == 3) {
                EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
                Intrinsics.checkExpressionValueIsNotNull(editText3, str7);
                editText3.setHint(str6);
                ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setPadding(ViewExtensionsKt.dpToPx((View) this, 20), 0, 0, 0);
                ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).clearFocus();
                Object systemService2 = getContext().getSystemService(str2);
                if (systemService2 != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService2;
                    EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
                    Intrinsics.checkExpressionValueIsNotNull(editText4, str7);
                    inputMethodManager.hideSoftInputFromWindow(editText4.getWindowToken(), 2);
                    ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
                    Intrinsics.checkExpressionValueIsNotNull(imageButton2, str5);
                    EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
                    Intrinsics.checkExpressionValueIsNotNull(editText5, str7);
                    Editable text2 = editText5.getText();
                    Intrinsics.checkExpressionValueIsNotNull(text2, str8);
                    if (text2.length() <= 0) {
                        z = false;
                    }
                    if (!z) {
                        i2 = 4;
                    }
                    imageButton2.setVisibility(i2);
                    ImageView imageView2 = (ImageView) _$_findCachedViewById(C0010R$id.icon_search);
                    Intrinsics.checkExpressionValueIsNotNull(imageView2, str4);
                    imageView2.setVisibility(4);
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.buttonCancel);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
                    textView2.setVisibility(8);
                    return;
                }
                throw new TypeCastException(str);
            }
        } else {
            EditText editText6 = (EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword);
            Intrinsics.checkExpressionValueIsNotNull(editText6, str7);
            editText6.setHint(str6);
            ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setPadding(ViewExtensionsKt.dpToPx((View) this, 20), 0, 0, 0);
            ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).setText("");
            ((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword)).requestFocus();
            ImageButton imageButton3 = (ImageButton) _$_findCachedViewById(C0010R$id.buttonClear);
            Intrinsics.checkExpressionValueIsNotNull(imageButton3, str5);
            imageButton3.setVisibility(4);
            ImageView imageView3 = (ImageView) _$_findCachedViewById(C0010R$id.icon_search);
            Intrinsics.checkExpressionValueIsNotNull(imageView3, str4);
            imageView3.setVisibility(4);
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.buttonCancel);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
            textView3.setVisibility(0);
            Object systemService3 = getContext().getSystemService(str2);
            if (systemService3 != null) {
                ((InputMethodManager) systemService3).showSoftInput((EditText) _$_findCachedViewById(C0010R$id.editSearchKeyword), 1);
                return;
            }
            throw new TypeCastException(str);
        }
    }
}
