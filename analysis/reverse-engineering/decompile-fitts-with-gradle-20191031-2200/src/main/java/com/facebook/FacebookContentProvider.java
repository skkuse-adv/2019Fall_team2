package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String TAG = FacebookContentProvider.class.getName();

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static String getAttachmentUrl(String str, UUID uuid, String str2) {
        return String.format("%s%s/%s/%s", new Object[]{"content://com.facebook.app.FacebookContentProvider", str, uuid.toString(), str2});
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Pair parseCallIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        if (parseCallIdAndAttachmentName != null) {
            try {
                File openAttachment = NativeAppCallAttachmentStore.openAttachment((UUID) parseCallIdAndAttachmentName.first, (String) parseCallIdAndAttachmentName.second);
                if (openAttachment != null) {
                    return ParcelFileDescriptor.open(openAttachment, 268435456);
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got unexpected exception:");
                sb.append(e);
                sb.toString();
                throw e;
            }
        } else {
            throw new FileNotFoundException();
        }
    }

    /* access modifiers changed from: 0000 */
    public Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        String str = "..";
        try {
            String[] split = uri.getPath().substring(1).split("/");
            String str2 = split[0];
            String str3 = split[1];
            if (!str.contentEquals(str2) && !str.contentEquals(str3)) {
                return new Pair<>(UUID.fromString(str2), str3);
            }
            throw new Exception();
        } catch (Exception unused) {
            return null;
        }
    }
}
