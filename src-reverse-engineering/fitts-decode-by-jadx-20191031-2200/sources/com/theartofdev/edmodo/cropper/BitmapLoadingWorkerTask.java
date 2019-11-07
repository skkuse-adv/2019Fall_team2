package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;

final class BitmapLoadingWorkerTask extends AsyncTask<Void, Void, Result> {
    private final Context mContext;
    private final WeakReference<CropImageView> mCropImageViewReference;
    private final int mHeight;
    private final Uri mUri;
    private final int mWidth;

    public static final class Result {
        public final Bitmap bitmap;
        public final int degreesRotated;
        public final Exception error;
        public final int loadSampleSize;
        public final Uri uri;

        Result(Uri uri2, Bitmap bitmap2, int i, int i2) {
            this.uri = uri2;
            this.bitmap = bitmap2;
            this.loadSampleSize = i;
            this.degreesRotated = i2;
            this.error = null;
        }

        Result(Uri uri2, Exception exc) {
            this.uri = uri2;
            this.bitmap = null;
            this.loadSampleSize = 0;
            this.degreesRotated = 0;
            this.error = exc;
        }
    }

    public BitmapLoadingWorkerTask(CropImageView cropImageView, Uri uri) {
        this.mUri = uri;
        this.mCropImageViewReference = new WeakReference<>(cropImageView);
        this.mContext = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        double d = f > 1.0f ? (double) (1.0f / f) : 1.0d;
        double d2 = (double) displayMetrics.widthPixels;
        Double.isNaN(d2);
        this.mWidth = (int) (d2 * d);
        double d3 = (double) displayMetrics.heightPixels;
        Double.isNaN(d3);
        this.mHeight = (int) (d3 * d);
    }

    public Uri getUri() {
        return this.mUri;
    }

    /* access modifiers changed from: protected */
    public Result doInBackground(Void... voidArr) {
        try {
            if (!isCancelled()) {
                BitmapSampled decodeSampledBitmap = BitmapUtils.decodeSampledBitmap(this.mContext, this.mUri, this.mWidth, this.mHeight);
                if (!isCancelled()) {
                    RotateBitmapResult rotateBitmapByExif = BitmapUtils.rotateBitmapByExif(decodeSampledBitmap.bitmap, this.mContext, this.mUri);
                    return new Result(this.mUri, rotateBitmapByExif.bitmap, decodeSampledBitmap.sampleSize, rotateBitmapByExif.degrees);
                }
            }
            return null;
        } catch (Exception e) {
            return new Result(this.mUri, e);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Result result) {
        if (result != null) {
            boolean z = false;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.mCropImageViewReference.get();
                if (cropImageView != null) {
                    z = true;
                    cropImageView.onSetImageUriAsyncComplete(result);
                }
            }
            if (!z) {
                Bitmap bitmap = result.bitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        }
    }
}
