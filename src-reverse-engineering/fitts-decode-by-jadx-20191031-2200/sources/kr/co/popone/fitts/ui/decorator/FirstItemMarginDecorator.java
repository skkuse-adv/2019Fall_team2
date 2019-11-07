package kr.co.popone.fitts.ui.decorator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FirstItemMarginDecorator extends ItemDecoration {
    private final Decorator firstItemDecorator;
    private final Decorator itemDecorator;

    public static final class Builder {
        private Decorator firstItemDecorator;
        private Decorator itemDecorator;

        @NotNull
        public final Builder setFirstItemDecorator(int i, int i2, int i3, int i4) {
            this.firstItemDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder setItemDecorator(int i, int i2, int i3, int i4) {
            this.itemDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final FirstItemMarginDecorator build() {
            Decorator decorator = this.firstItemDecorator;
            if (decorator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstItemDecorator");
            }
            Decorator decorator2 = this.itemDecorator;
            if (decorator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemDecorator");
            }
            return new FirstItemMarginDecorator(decorator, decorator2);
        }
    }

    public static final class Decorator {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        @NotNull
        public static /* synthetic */ Decorator copy$default(Decorator decorator, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = decorator.top;
            }
            if ((i5 & 2) != 0) {
                i2 = decorator.bottom;
            }
            if ((i5 & 4) != 0) {
                i3 = decorator.left;
            }
            if ((i5 & 8) != 0) {
                i4 = decorator.right;
            }
            return decorator.copy(i, i2, i3, i4);
        }

        public final int component1() {
            return this.top;
        }

        public final int component2() {
            return this.bottom;
        }

        public final int component3() {
            return this.left;
        }

        public final int component4() {
            return this.right;
        }

        @NotNull
        public final Decorator copy(int i, int i2, int i3, int i4) {
            return new Decorator(i, i2, i3, i4);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Decorator) {
                    Decorator decorator = (Decorator) obj;
                    if (this.top == decorator.top) {
                        if (this.bottom == decorator.bottom) {
                            if (this.left == decorator.left) {
                                if (this.right == decorator.right) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((this.top * 31) + this.bottom) * 31) + this.left) * 31) + this.right;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Decorator(top=");
            sb.append(this.top);
            sb.append(", bottom=");
            sb.append(this.bottom);
            sb.append(", left=");
            sb.append(this.left);
            sb.append(", right=");
            sb.append(this.right);
            sb.append(")");
            return sb.toString();
        }

        public Decorator(int i, int i2, int i3, int i4) {
            this.top = i;
            this.bottom = i2;
            this.left = i3;
            this.right = i4;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }
    }

    public FirstItemMarginDecorator(@NotNull Decorator decorator, @NotNull Decorator decorator2) {
        Intrinsics.checkParameterIsNotNull(decorator, "firstItemDecorator");
        Intrinsics.checkParameterIsNotNull(decorator2, "itemDecorator");
        this.firstItemDecorator = decorator;
        this.itemDecorator = decorator2;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        if (recyclerView.getChildLayoutPosition(view) != 0) {
            Decorator decorator = this.itemDecorator;
            rect.set(ViewExtensionsKt.dpToPx(view, decorator.getLeft()), ViewExtensionsKt.dpToPx(view, decorator.getTop()), ViewExtensionsKt.dpToPx(view, decorator.getRight()), ViewExtensionsKt.dpToPx(view, decorator.getBottom()));
            return;
        }
        Decorator decorator2 = this.firstItemDecorator;
        rect.set(ViewExtensionsKt.dpToPx(view, decorator2.getLeft()), ViewExtensionsKt.dpToPx(view, decorator2.getTop()), ViewExtensionsKt.dpToPx(view, decorator2.getRight()), ViewExtensionsKt.dpToPx(view, decorator2.getBottom()));
    }
}
