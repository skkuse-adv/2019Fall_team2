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

public final class RecyclerDecorator extends ItemDecoration {
    private final Decorator doubleLeftDecorator;
    private final Decorator doubleRightDecorator;
    private final Decorator singleDecorator;
    private final Decorator tripleCenterDecorator;
    private final Decorator tripleLeftDecorator;
    private final Decorator tripleRightDecorator;
    private final DecoratorType type;

    public static final class Builder {
        private DecoratorType decoratorType;
        private Decorator doubleLeftDecorator;
        private Decorator doubleRightDecorator;
        private Decorator singleDecorator;
        private Decorator tripleCenterDecorator;
        private Decorator tripleLeftDecorator;
        private Decorator tripleRightDecorator;

        @NotNull
        public final Builder decoratorType(@NotNull DecoratorType decoratorType2) {
            Intrinsics.checkParameterIsNotNull(decoratorType2, "type");
            this.decoratorType = decoratorType2;
            return this;
        }

        @NotNull
        public final Builder singleDecorator(int i, int i2, int i3, int i4) {
            this.singleDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder doubleLeftDecorator(int i, int i2, int i3, int i4) {
            this.doubleLeftDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder doubleRightDecorator(int i, int i2, int i3, int i4) {
            this.doubleRightDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder tripleLeftDecorator(int i, int i2, int i3, int i4) {
            this.tripleLeftDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder tripleCenterDecorator(int i, int i2, int i3, int i4) {
            this.tripleCenterDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final Builder tripleRightDecorator(int i, int i2, int i3, int i4) {
            this.tripleRightDecorator = new Decorator(i, i2, i3, i4);
            return this;
        }

        @NotNull
        public final RecyclerDecorator build() {
            RecyclerDecorator recyclerDecorator = new RecyclerDecorator(this.decoratorType, this.singleDecorator, this.doubleLeftDecorator, this.doubleRightDecorator, this.tripleLeftDecorator, this.tripleCenterDecorator, this.tripleRightDecorator);
            return recyclerDecorator;
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

    public enum DecoratorType {
        SINGLE,
        DOUBLE,
        TRIPLE
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[DecoratorType.values().length];

        static {
            $EnumSwitchMapping$0[DecoratorType.SINGLE.ordinal()] = 1;
            $EnumSwitchMapping$0[DecoratorType.DOUBLE.ordinal()] = 2;
            $EnumSwitchMapping$0[DecoratorType.TRIPLE.ordinal()] = 3;
        }
    }

    public RecyclerDecorator() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public /* synthetic */ RecyclerDecorator(DecoratorType decoratorType, Decorator decorator, Decorator decorator2, Decorator decorator3, Decorator decorator4, Decorator decorator5, Decorator decorator6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        DecoratorType decoratorType2 = (i & 1) != 0 ? null : decoratorType;
        this(decoratorType2, (i & 2) != 0 ? null : decorator, (i & 4) != 0 ? null : decorator2, (i & 8) != 0 ? null : decorator3, (i & 16) != 0 ? null : decorator4, (i & 32) != 0 ? null : decorator5, (i & 64) != 0 ? null : decorator6);
    }

    public RecyclerDecorator(@Nullable DecoratorType decoratorType, @Nullable Decorator decorator, @Nullable Decorator decorator2, @Nullable Decorator decorator3, @Nullable Decorator decorator4, @Nullable Decorator decorator5, @Nullable Decorator decorator6) {
        this.type = decoratorType;
        this.singleDecorator = decorator;
        this.doubleLeftDecorator = decorator2;
        this.doubleRightDecorator = decorator3;
        this.tripleLeftDecorator = decorator4;
        this.tripleCenterDecorator = decorator5;
        this.tripleRightDecorator = decorator6;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
        Intrinsics.checkParameterIsNotNull(rect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        DecoratorType decoratorType = this.type;
        if (decoratorType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[decoratorType.ordinal()];
            if (i == 1) {
                Decorator decorator = this.singleDecorator;
                if (decorator != null) {
                    rect.set(ViewExtensionsKt.dpToPx(view, decorator.getLeft()), ViewExtensionsKt.dpToPx(view, decorator.getTop()), ViewExtensionsKt.dpToPx(view, decorator.getRight()), ViewExtensionsKt.dpToPx(view, decorator.getBottom()));
                    return;
                }
                throw new IllegalAccessException("Should init SingleDecorator");
            } else if (i != 2) {
                if (i == 3) {
                    int i2 = childLayoutPosition % 3;
                    if (i2 == 0) {
                        Decorator decorator2 = this.tripleLeftDecorator;
                        if (decorator2 != null) {
                            rect.set(ViewExtensionsKt.dpToPx(view, decorator2.getLeft()), ViewExtensionsKt.dpToPx(view, decorator2.getTop()), ViewExtensionsKt.dpToPx(view, decorator2.getRight()), ViewExtensionsKt.dpToPx(view, decorator2.getBottom()));
                            return;
                        }
                        throw new IllegalAccessException("Should init TripleLeftDecorator");
                    } else if (i2 == 1) {
                        Decorator decorator3 = this.tripleCenterDecorator;
                        if (decorator3 != null) {
                            rect.set(ViewExtensionsKt.dpToPx(view, decorator3.getLeft()), ViewExtensionsKt.dpToPx(view, decorator3.getTop()), ViewExtensionsKt.dpToPx(view, decorator3.getRight()), ViewExtensionsKt.dpToPx(view, decorator3.getBottom()));
                            return;
                        }
                        throw new IllegalAccessException("Should init TripleCenterDecorator");
                    } else {
                        Decorator decorator4 = this.tripleRightDecorator;
                        if (decorator4 != null) {
                            rect.set(ViewExtensionsKt.dpToPx(view, decorator4.getLeft()), ViewExtensionsKt.dpToPx(view, decorator4.getTop()), ViewExtensionsKt.dpToPx(view, decorator4.getRight()), ViewExtensionsKt.dpToPx(view, decorator4.getBottom()));
                            return;
                        }
                        throw new IllegalAccessException("Should init TripleRightDecorator");
                    }
                }
            } else if (childLayoutPosition % 2 == 0) {
                Decorator decorator5 = this.doubleLeftDecorator;
                if (decorator5 != null) {
                    rect.set(ViewExtensionsKt.dpToPx(view, decorator5.getLeft()), ViewExtensionsKt.dpToPx(view, decorator5.getTop()), ViewExtensionsKt.dpToPx(view, decorator5.getRight()), ViewExtensionsKt.dpToPx(view, decorator5.getBottom()));
                    return;
                }
                throw new IllegalAccessException("Should init DoubleLeftDecorator");
            } else {
                Decorator decorator6 = this.doubleRightDecorator;
                if (decorator6 != null) {
                    rect.set(ViewExtensionsKt.dpToPx(view, decorator6.getLeft()), ViewExtensionsKt.dpToPx(view, decorator6.getTop()), ViewExtensionsKt.dpToPx(view, decorator6.getRight()), ViewExtensionsKt.dpToPx(view, decorator6.getBottom()));
                    return;
                }
                throw new IllegalAccessException("Should init DoubleRightDecorator");
            }
        }
        throw new IllegalAccessException("Can't recognize decorator type");
    }
}
