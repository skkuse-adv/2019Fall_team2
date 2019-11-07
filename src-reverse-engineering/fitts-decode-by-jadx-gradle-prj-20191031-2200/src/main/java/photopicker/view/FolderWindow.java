package photopicker.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.facebook.internal.ServerProtocol;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0017R$style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.adapter.ImageFolderAdapter;
import photopicker.adapter.ImageFolderAdapter.OnItemClickListener;
import photopicker.model.LocalMediaFolder;
import photopicker.utils.ScreenUtils;

public final class FolderWindow extends PopupWindow {
    public static final Companion Companion = new Companion(null);
    private ImageFolderAdapter adapter;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public boolean isDismiss;
    /* access modifiers changed from: private */
    public RecyclerView recyclerView;
    private View tourchOutside;
    @SuppressLint({"InflateParams"})
    private final View window;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void setPopupWindowTouchModal(@Nullable PopupWindow popupWindow, boolean z) {
            if (popupWindow != null) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
                    Intrinsics.checkExpressionValueIsNotNull(declaredMethod, "PopupWindow::class.java.…:class.javaPrimitiveType)");
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(popupWindow, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final class ItemDivider extends ItemDecoration {
        private final Drawable mDrawable;

        public ItemDivider(FolderWindow folderWindow) {
            Drawable drawable = folderWindow.context.getResources().getDrawable(C0008R$drawable.item_divider);
            Intrinsics.checkExpressionValueIsNotNull(drawable, "context.resources.getDra…(R.drawable.item_divider)");
            this.mDrawable = drawable;
        }

        public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(canvas, "c");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            ScreenUtils screenUtils = ScreenUtils.INSTANCE;
            Context context = recyclerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "parent.context");
            int dip2px = screenUtils.dip2px(context, 16.0f);
            int width = recyclerView.getWidth() - dip2px;
            int childCount = recyclerView.getChildCount() - 1;
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams != null) {
                    int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) layoutParams).bottomMargin;
                    this.mDrawable.setBounds(dip2px, bottom, width, this.mDrawable.getIntrinsicHeight() + bottom);
                    this.mDrawable.draw(canvas);
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                }
            }
        }

        public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull State state) {
            Intrinsics.checkParameterIsNotNull(rect, "outRect");
            Intrinsics.checkParameterIsNotNull(view, "view");
            Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
            Intrinsics.checkParameterIsNotNull(state, ServerProtocol.DIALOG_PARAM_STATE);
            rect.set(0, 0, 0, this.mDrawable.getIntrinsicWidth());
        }
    }

    private final void registerListener() {
    }

    public FolderWindow(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
        View inflate = LayoutInflater.from(this.context).inflate(C0013R$layout.fragment_image_folder, null);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…gment_image_folder, null)");
        this.window = inflate;
        setContentView(this.window);
        setWidth(ScreenUtils.INSTANCE.getScreenWidth(this.context));
        setHeight(ScreenUtils.INSTANCE.getScreenHeight(this.context));
        setAnimationStyle(C0017R$style.WindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.argb(153, 0, 0, 0)));
        initView();
        registerListener();
        Companion.setPopupWindowTouchModal(this, false);
    }

    private final void initView() {
        this.adapter = new ImageFolderAdapter(this.context);
        this.recyclerView = (RecyclerView) this.window.findViewById(C0010R$id.folder_list);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.addItemDecoration(new ItemDivider(this));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.context));
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView4.setAdapter(this.adapter);
        this.tourchOutside = this.window.findViewById(2131363278);
        View view = this.tourchOutside;
        if (view == null) {
            Intrinsics.throwNpe();
        }
        view.setOnClickListener(new FolderWindow$initView$1(this));
    }

    public final void bindFolder(@NotNull List<LocalMediaFolder> list) {
        Intrinsics.checkParameterIsNotNull(list, "folders");
        ImageFolderAdapter imageFolderAdapter = this.adapter;
        if (imageFolderAdapter == null) {
            Intrinsics.throwNpe();
        }
        imageFolderAdapter.setFolders(list);
    }

    public final void setOnItemClickListener(@NotNull OnItemClickListener onItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener, "onItemClickListener");
        ImageFolderAdapter imageFolderAdapter = this.adapter;
        if (imageFolderAdapter == null) {
            Intrinsics.throwNpe();
        }
        imageFolderAdapter.setOnItemClickListener(onItemClickListener);
    }

    public void dismiss() {
        if (!this.isDismiss) {
            this.isDismiss = true;
            Animation loadAnimation = AnimationUtils.loadAnimation(this.context, C0001R$anim.fade_out);
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwNpe();
            }
            recyclerView2.startAnimation(loadAnimation);
            dismiss();
            loadAnimation.setAnimationListener(new FolderWindow$dismiss$1(this));
        }
    }
}
