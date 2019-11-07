package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.util.Map;

class NativeSessionReport implements Report {
    private final File reportDirectory;

    public Map<String, String> getCustomHeaders() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public NativeSessionReport(File file) {
        this.reportDirectory = file;
    }

    public void remove() {
        File[] files = getFiles();
        int length = files.length;
        int i = 0;
        while (true) {
            String str = CrashlyticsCore.TAG;
            if (i < length) {
                File file = files[i];
                Logger logger = Fabric.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("Removing native report file at ");
                sb.append(file.getPath());
                logger.d(str, sb.toString());
                file.delete();
                i++;
            } else {
                Logger logger2 = Fabric.getLogger();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Removing native report directory at ");
                sb2.append(this.reportDirectory);
                logger2.d(str, sb2.toString());
                this.reportDirectory.delete();
                return;
            }
        }
    }

    public String getIdentifier() {
        return this.reportDirectory.getName();
    }

    public File[] getFiles() {
        return this.reportDirectory.listFiles();
    }

    public Type getType() {
        return Type.NATIVE;
    }
}
