package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

class DefaultCachedSettingsIo implements CachedSettingsIo {
    private final Kit kit;

    public DefaultCachedSettingsIo(Kit kit2) {
        this.kit = kit2;
    }

    public JSONObject readCachedSettings() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        String str = "Error while closing settings cache file.";
        Logger logger = Fabric.getLogger();
        String str2 = Fabric.TAG;
        logger.d(str2, "Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(new FileStoreImpl(this.kit).getFilesDir(), Settings.SETTINGS_CACHE_FILENAME);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
                    fileInputStream2 = fileInputStream;
                } catch (Exception e) {
                    e = e;
                    try {
                        Fabric.getLogger().e(str2, "Failed to fetch cached settings", e);
                        CommonUtils.closeOrLog(fileInputStream, str);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = fileInputStream;
                        CommonUtils.closeOrLog(fileInputStream2, str);
                        throw th;
                    }
                }
            } else {
                Fabric.getLogger().d(str2, "No cached settings found.");
                jSONObject = null;
            }
            CommonUtils.closeOrLog(fileInputStream2, str);
            return jSONObject;
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            Fabric.getLogger().e(str2, "Failed to fetch cached settings", e);
            CommonUtils.closeOrLog(fileInputStream, str);
            return null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeOrLog(fileInputStream2, str);
            throw th;
        }
    }

    public void writeCachedSettings(long j, JSONObject jSONObject) {
        String str = "Failed to close settings writer.";
        Logger logger = Fabric.getLogger();
        String str2 = Fabric.TAG;
        logger.d(str2, "Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                jSONObject.put(SettingsJsonConstants.EXPIRES_AT_KEY, j);
                FileWriter fileWriter2 = new FileWriter(new File(new FileStoreImpl(this.kit).getFilesDir(), Settings.SETTINGS_CACHE_FILENAME));
                try {
                    fileWriter2.write(jSONObject.toString());
                    fileWriter2.flush();
                    CommonUtils.closeOrLog(fileWriter2, str);
                } catch (Exception e) {
                    e = e;
                    fileWriter = fileWriter2;
                    try {
                        Fabric.getLogger().e(str2, "Failed to cache settings", e);
                        CommonUtils.closeOrLog(fileWriter, str);
                    } catch (Throwable th) {
                        th = th;
                        CommonUtils.closeOrLog(fileWriter, str);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter = fileWriter2;
                    CommonUtils.closeOrLog(fileWriter, str);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                Fabric.getLogger().e(str2, "Failed to cache settings", e);
                CommonUtils.closeOrLog(fileWriter, str);
            }
        }
    }
}
