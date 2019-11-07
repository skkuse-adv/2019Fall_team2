package kr.co.popone.fitts.model.datamodel.action;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SchemeAction {
    void onSchemeClick(@NotNull ViewHolder viewHolder, @Nullable String str);
}
