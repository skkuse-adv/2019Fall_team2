package photopicker.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ImagePreviewFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    @NotNull
    public static final String PATH = PATH;
    private HashMap _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getPATH() {
            return ImagePreviewFragment.PATH;
        }

        @NotNull
        public final ImagePreviewFragment getInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, ImagePreviewFragment.PATH);
            ImagePreviewFragment imagePreviewFragment = new ImagePreviewFragment();
            Bundle bundle = new Bundle();
            bundle.putString(getPATH(), str);
            imagePreviewFragment.setArguments(bundle);
            return imagePreviewFragment;
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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(C0013R$layout.fragment_image_preview, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(C0010R$id.preview_image);
        if (viewGroup == null) {
            Intrinsics.throwNpe();
        }
        RequestManager with = Glide.with(viewGroup.getContext());
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(PATH);
        if (string == null) {
            Intrinsics.throwNpe();
        }
        with.load(new File(string)).into(imageView);
        return inflate;
    }
}
