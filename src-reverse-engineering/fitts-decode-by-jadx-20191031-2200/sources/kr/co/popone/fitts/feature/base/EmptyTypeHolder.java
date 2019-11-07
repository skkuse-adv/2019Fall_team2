package kr.co.popone.fitts.feature.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EmptyTypeHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_empty_view;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EmptyTypeHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_empty_view, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new EmptyTypeHolder(inflate);
        }
    }

    public <T> void bind(@Nullable T t, @Nullable Integer num) {
    }

    public void clear() {
    }

    public EmptyTypeHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }
}
