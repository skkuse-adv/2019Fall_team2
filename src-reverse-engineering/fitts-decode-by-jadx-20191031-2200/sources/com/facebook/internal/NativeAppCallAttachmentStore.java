package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.MessageTemplateProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class NativeAppCallAttachmentStore {
    private static File attachmentsDirectory;

    public static final class Attachment {
        /* access modifiers changed from: private */
        public final String attachmentName;
        private final String attachmentUrl;
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public final UUID callId;
        /* access modifiers changed from: private */
        public boolean isContentUri;
        /* access modifiers changed from: private */
        public Uri originalUri;
        /* access modifiers changed from: private */
        public boolean shouldCreateFile;

        private Attachment(UUID uuid, Bitmap bitmap2, Uri uri) {
            String str;
            this.callId = uuid;
            this.bitmap = bitmap2;
            this.originalUri = uri;
            boolean z = true;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (MessageTemplateProtocol.CONTENT.equalsIgnoreCase(scheme)) {
                    this.isContentUri = true;
                    if (uri.getAuthority() == null || uri.getAuthority().startsWith(MessengerShareContentUtility.TEMPLATE_MEDIA_TYPE)) {
                        z = false;
                    }
                    this.shouldCreateFile = z;
                } else {
                    if ("file".equalsIgnoreCase(uri.getScheme())) {
                        this.shouldCreateFile = true;
                    } else if (!Utility.isWebUri(uri)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported scheme for media Uri : ");
                        sb.append(scheme);
                        throw new FacebookException(sb.toString());
                    }
                }
            } else if (bitmap2 != null) {
                this.shouldCreateFile = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            this.attachmentName = !this.shouldCreateFile ? null : UUID.randomUUID().toString();
            if (!this.shouldCreateFile) {
                str = this.originalUri.toString();
            } else {
                str = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), uuid, this.attachmentName);
            }
            this.attachmentUrl = str;
        }

        public String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public Uri getOriginalUri() {
            return this.originalUri;
        }
    }

    private NativeAppCallAttachmentStore() {
    }

    public static Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        Validate.notNull(uuid, "callId");
        Validate.notNull(bitmap, "attachmentBitmap");
        return new Attachment(uuid, bitmap, null);
    }

    public static Attachment createAttachment(UUID uuid, Uri uri) {
        Validate.notNull(uuid, "callId");
        Validate.notNull(uri, "attachmentUri");
        return new Attachment(uuid, null, uri);
    }

    private static void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private static void processAttachmentFile(Uri uri, boolean z, File file) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (!z) {
            try {
                inputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                Utility.closeQuietly(fileOutputStream);
                throw th;
            }
        } else {
            inputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
        }
        Utility.copyAndCloseInputStream(inputStream, fileOutputStream);
        Utility.closeQuietly(fileOutputStream);
    }

    public static void addAttachments(Collection<Attachment> collection) {
        if (collection != null && collection.size() != 0) {
            if (attachmentsDirectory == null) {
                cleanupAllAttachments();
            }
            ensureAttachmentsDirectoryExists();
            ArrayList<File> arrayList = new ArrayList<>();
            try {
                for (Attachment attachment : collection) {
                    if (attachment.shouldCreateFile) {
                        File attachmentFile = getAttachmentFile(attachment.callId, attachment.attachmentName, true);
                        arrayList.add(attachmentFile);
                        if (attachment.bitmap != null) {
                            processAttachmentBitmap(attachment.bitmap, attachmentFile);
                        } else if (attachment.originalUri != null) {
                            processAttachmentFile(attachment.originalUri, attachment.isContentUri, attachmentFile);
                        }
                    }
                }
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Got unexpected exception:");
                sb.append(e);
                sb.toString();
                for (File delete : arrayList) {
                    try {
                        delete.delete();
                    } catch (Exception unused) {
                    }
                }
                throw new FacebookException((Throwable) e);
            }
        }
    }

    public static void cleanupAttachmentsForCall(UUID uuid) {
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            Utility.deleteDirectory(attachmentsDirectoryForCall);
        }
    }

    public static File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    static synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (attachmentsDirectory == null) {
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            file = attachmentsDirectory;
        }
        return file;
    }

    static File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        attachmentsDirectory2.mkdirs();
        return attachmentsDirectory2;
    }

    static File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        File file = attachmentsDirectory;
        if (file == null) {
            return null;
        }
        File file2 = new File(file, uuid.toString());
        if (z && !file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    static File getAttachmentFile(UUID uuid, String str, boolean z) throws IOException {
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static void cleanupAllAttachments() {
        Utility.deleteDirectory(getAttachmentsDirectory());
    }
}
