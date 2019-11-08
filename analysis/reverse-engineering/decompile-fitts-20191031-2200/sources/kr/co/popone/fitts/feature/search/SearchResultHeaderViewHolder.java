package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class SearchResultHeaderViewHolder extends ViewHolder {
    @NotNull
    private final TextView resultTextView;

    public SearchResultHeaderViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super(view);
        View findViewById = view.findViewById(C0010R$id.resultTextView);
        if (findViewById == null) {
            Intrinsics.throwNpe();
        }
        this.resultTextView = (TextView) findViewById;
    }

    @NotNull
    public final TextView getResultTextView() {
        return this.resultTextView;
    }
}
