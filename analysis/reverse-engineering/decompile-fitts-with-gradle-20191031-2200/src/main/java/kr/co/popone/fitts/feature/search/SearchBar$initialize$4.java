package kr.co.popone.fitts.feature.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.search.SearchBar.State;
import org.jetbrains.annotations.Nullable;

public final class SearchBar$initialize$4 implements TextWatcher {
    final /* synthetic */ SearchBar this$0;

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    SearchBar$initialize$4(SearchBar searchBar) {
        this.this$0 = searchBar;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.buttonClear);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "buttonClear");
        if (charSequence == null) {
            Intrinsics.throwNpe();
        }
        boolean z = true;
        imageButton.setVisibility(charSequence.length() > 0 ? 0 : 4);
        this.this$0.textChangesSubject.onNext(charSequence.toString());
        if (this.this$0.getSearchBarState() == State.AFTER_INPUT) {
            if (charSequence.length() == 0) {
                this.this$0.changeSearchBarState(State.INPUT);
                return;
            }
        }
        SearchBar searchBar = this.this$0;
        if (charSequence.length() <= 0) {
            z = false;
        }
        searchBar.changeSearchBarState(z ? State.INPUT : State.BEFORE_INPUT);
    }
}
