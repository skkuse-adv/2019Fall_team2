package photopicker.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class FileUtils {
    private static final String APP_NAME = APP_NAME;
    private static final String CROP_PATH;
    public static final FileUtils INSTANCE = new FileUtils();
    private static final String POSTFIX = POSTFIX;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        sb.append(APP_NAME);
        sb.append("/CropImage/");
        CROP_PATH = sb.toString();
    }

    private FileUtils() {
    }

    @NotNull
    public final File createCropFile(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return createMediaFile(context, CROP_PATH);
    }

    private final File createMediaFile(Context context, String str) {
        File externalStorageDirectory = Intrinsics.areEqual((Object) Environment.getExternalStorageState(), (Object) "mounted") ? Environment.getExternalStorageDirectory() : context.getCacheDir();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkExpressionValueIsNotNull(externalStorageDirectory, "rootDir");
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append(str);
        File file = new File(sb.toString());
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.CHINA).format(new Date());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(APP_NAME);
        sb2.append("_");
        sb2.append(format);
        sb2.append("");
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sb3);
        sb4.append(POSTFIX);
        return new File(file, sb4.toString());
    }
}
