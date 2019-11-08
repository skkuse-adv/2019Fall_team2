package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.cache.ValueLoader;

public class InstallerPackageNameProvider {
    private final MemoryValueCache<String> installerPackageNameCache = new MemoryValueCache<>();
    private final ValueLoader<String> installerPackageNameLoader = new ValueLoader<String>(this) {
        public String load(Context context) throws Exception {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    };

    public String getInstallerPackageName(Context context) {
        try {
            String str = (String) this.installerPackageNameCache.get(context, this.installerPackageNameLoader);
            if ("".equals(str)) {
                str = null;
            }
            return str;
        } catch (Exception e) {
            Fabric.getLogger().e(Fabric.TAG, "Failed to determine installer package name", e);
            return null;
        }
    }
}
