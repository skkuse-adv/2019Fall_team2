package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FileSystemException extends IOException {
    @NotNull
    private final File file;
    @Nullable
    private final File other;
    @Nullable
    private final String reason;

    @NotNull
    public final File getFile() {
        return this.file;
    }

    @Nullable
    public final File getOther() {
        return this.other;
    }

    public /* synthetic */ FileSystemException(File file2, File file3, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            file3 = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        this(file2, file3, str);
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    public FileSystemException(@NotNull File file2, @Nullable File file3, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(file2, "file");
        super(ExceptionsKt.constructMessage(file2, file3, str));
        this.file = file2;
        this.other = file3;
        this.reason = str;
    }
}
