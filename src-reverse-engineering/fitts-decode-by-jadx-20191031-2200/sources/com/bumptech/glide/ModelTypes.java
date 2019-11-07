package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

interface ModelTypes<T> {
    @CheckResult
    @NonNull
    T load(@Nullable Bitmap bitmap);

    @CheckResult
    @NonNull
    T load(@Nullable Drawable drawable);

    @CheckResult
    @NonNull
    T load(@Nullable Uri uri);

    @CheckResult
    @NonNull
    T load(@Nullable File file);

    @CheckResult
    @NonNull
    T load(@RawRes @DrawableRes @Nullable Integer num);

    @CheckResult
    @NonNull
    T load(@Nullable Object obj);

    @CheckResult
    @NonNull
    T load(@Nullable String str);

    @CheckResult
    @Deprecated
    T load(@Nullable URL url);

    @CheckResult
    @NonNull
    T load(@Nullable byte[] bArr);
}
