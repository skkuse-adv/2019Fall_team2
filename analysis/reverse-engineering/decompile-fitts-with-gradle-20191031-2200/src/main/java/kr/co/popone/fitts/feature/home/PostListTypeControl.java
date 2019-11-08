package kr.co.popone.fitts.feature.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostListTypeControl extends FrameLayout {
    private HashMap _$_findViewCache;
    @NotNull
    private Type type;
    @Nullable
    private Function1<? super Type, Unit> typeChangeListener;

    public enum Type {
        ListView,
        ThumbnailView
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.ListView.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.ThumbnailView.ordinal()] = 2;
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
    public final Type getType() {
        return this.type;
    }

    public final void setType(@NotNull Type type2) {
        Intrinsics.checkParameterIsNotNull(type2, "value");
        if (this.type != type2) {
            this.type = type2;
            updateUI(type2);
            Function1<? super Type, Unit> function1 = this.typeChangeListener;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(this.type);
            }
        }
    }

    @Nullable
    public final Function1<Type, Unit> getTypeChangeListener() {
        return this.typeChangeListener;
    }

    public final void setTypeChangeListener(@Nullable Function1<? super Type, Unit> function1) {
        this.typeChangeListener = function1;
    }

    public PostListTypeControl(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, null);
    }

    public PostListTypeControl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this(context, attributeSet, 0);
    }

    public PostListTypeControl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.type = Type.ListView;
        LayoutInflater.from(context).inflate(C0013R$layout.control_post_list_type, this, true);
        ((Button) _$_findCachedViewById(C0010R$id.listTypeButton)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostListTypeControl this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setType(Type.ListView);
            }
        });
        ((Button) _$_findCachedViewById(C0010R$id.thumbnailTypeButton)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PostListTypeControl this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                this.this$0.setType(Type.ThumbnailView);
            }
        });
    }

    private final void updateUI(Type type2) {
        int i;
        ImageView imageView = (ImageView) _$_findCachedViewById(C0010R$id.controlImageView);
        int i2 = WhenMappings.$EnumSwitchMapping$0[type2.ordinal()];
        if (i2 == 1) {
            i = C0008R$drawable.ic_list_view;
        } else if (i2 == 2) {
            i = C0008R$drawable.ic_thumb_view;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        imageView.setImageResource(i);
    }
}
