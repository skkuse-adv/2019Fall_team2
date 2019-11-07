package io.fabric.sdk.android.services.persistence;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.io.File;

public class FileStoreImpl implements FileStore {
    private final String contentPath;
    private final Context context;
    private final String legacySupport;

    public FileStoreImpl(Kit kit) {
        if (kit.getContext() != null) {
            this.context = kit.getContext();
            this.contentPath = kit.getPath();
            StringBuilder sb = new StringBuilder();
            sb.append("Android/");
            sb.append(this.context.getPackageName());
            this.legacySupport = sb.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    public File getCacheDir() {
        return prepare(this.context.getCacheDir());
    }

    public File getExternalCacheDir() {
        File file;
        if (!isExternalStorageAvailable()) {
            file = null;
        } else if (VERSION.SDK_INT >= 8) {
            file = this.context.getExternalCacheDir();
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            StringBuilder sb = new StringBuilder();
            sb.append(this.legacySupport);
            sb.append("/cache/");
            sb.append(this.contentPath);
            file = new File(externalStorageDirectory, sb.toString());
        }
        return prepare(file);
    }

    public File getFilesDir() {
        return prepare(this.context.getFilesDir());
    }

    @TargetApi(8)
    public File getExternalFilesDir() {
        File file = null;
        if (isExternalStorageAvailable()) {
            if (VERSION.SDK_INT >= 8) {
                file = this.context.getExternalFilesDir(null);
            } else {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                StringBuilder sb = new StringBuilder();
                sb.append(this.legacySupport);
                sb.append("/files/");
                sb.append(this.contentPath);
                file = new File(externalStorageDirectory, sb.toString());
            }
        }
        return prepare(file);
    }

    /* access modifiers changed from: 0000 */
    public File prepare(File file) {
        String str = Fabric.TAG;
        if (file == null) {
            Fabric.getLogger().d(str, "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            Fabric.getLogger().w(str, "Couldn't create file");
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public boolean isExternalStorageAvailable() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        Fabric.getLogger().w(Fabric.TAG, "External Storage is not mounted and/or writable\nHave you declared android.permission.WRITE_EXTERNAL_STORAGE in the manifest?");
        return false;
    }
}
