package com.isseiaoki.simplecropview.util;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.MessageTemplateProtocol;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static int sInputImageHeight;
    public static int sInputImageWidth;

    public static int getRotateDegreeFromOrientation(int i) {
        if (i == 3) {
            return 180;
        }
        if (i != 6) {
            return i != 8 ? 0 : 270;
        }
        return 90;
    }

    public static void copyExifInfo(Context context, Uri uri, Uri uri2, int i, int i2) {
        if (!(uri == null || uri2 == null)) {
            try {
                File fileFromUri = getFileFromUri(context, uri);
                File fileFromUri2 = getFileFromUri(context, uri2);
                if (fileFromUri != null) {
                    if (fileFromUri2 != null) {
                        String absolutePath = fileFromUri.getAbsolutePath();
                        String absolutePath2 = fileFromUri2.getAbsolutePath();
                        ExifInterface exifInterface = new ExifInterface(absolutePath);
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_FLASH);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_FOCAL_LENGTH);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE_REF);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_DATESTAMP);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_PROCESSING_METHOD);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_GPS_TIMESTAMP);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_MAKE);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_MODEL);
                        arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_WHITE_BALANCE);
                        int i3 = VERSION.SDK_INT;
                        String str = androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS;
                        String str2 = androidx.exifinterface.media.ExifInterface.TAG_F_NUMBER;
                        if (i3 >= 11) {
                            arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_EXPOSURE_TIME);
                            arrayList.add(str2);
                            arrayList.add(str);
                        }
                        int i4 = VERSION.SDK_INT;
                        String str3 = androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_ORIGINAL;
                        String str4 = androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME_DIGITIZED;
                        if (i4 >= 23) {
                            arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED);
                            arrayList.add(androidx.exifinterface.media.ExifInterface.TAG_SUBSEC_TIME);
                            arrayList.add(str4);
                            arrayList.add(str3);
                        }
                        if (VERSION.SDK_INT >= 24) {
                            arrayList.add(str2);
                            arrayList.add(str);
                            arrayList.add(str4);
                            arrayList.add(str3);
                        }
                        ExifInterface exifInterface2 = new ExifInterface(absolutePath2);
                        for (String str5 : arrayList) {
                            String attribute = exifInterface.getAttribute(str5);
                            if (!TextUtils.isEmpty(attribute)) {
                                exifInterface2.setAttribute(str5, attribute);
                            }
                        }
                        exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
                        exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i2));
                        exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(0));
                        exifInterface2.saveAttributes();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getExifRotation(File file) {
        if (file == null) {
            return 0;
        }
        try {
            return getRotateDegreeFromOrientation(new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0));
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("An error occurred while getting the exif data: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString(), e);
            return 0;
        }
    }

    public static int getExifRotation(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"orientation"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    int i = query.getInt(0);
                    if (query != null) {
                        query.close();
                    }
                    return i;
                }
            }
            if (query != null) {
                query.close();
            }
            return 0;
        } catch (RuntimeException unused) {
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static int getExifOrientation(Context context, Uri uri) {
        if (uri.getAuthority().toLowerCase().endsWith(MessengerShareContentUtility.TEMPLATE_MEDIA_TYPE)) {
            return getExifRotation(context, uri);
        }
        return getExifRotation(getFileFromUri(context, uri));
    }

    public static Matrix getMatrixFromExifOrientation(int i) {
        Matrix matrix = new Matrix();
        switch (i) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(1.0f, -1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(-90.0f);
                matrix.postScale(1.0f, -1.0f);
                break;
            case 8:
                matrix.postRotate(-90.0f);
                break;
        }
        return matrix;
    }

    public static int getExifOrientationFromAngle(int i) {
        int i2 = i % 360;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 90) {
            return 6;
        }
        if (i2 != 180) {
            return i2 != 270 ? 1 : 8;
        }
        return 3;
    }

    @TargetApi(19)
    public static Uri ensureUriPermission(Context context, Intent intent) {
        Uri data = intent.getData();
        if (VERSION.SDK_INT >= 19) {
            context.getContentResolver().takePersistableUriPermission(data, intent.getFlags() & 1);
        }
        return data;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ec A[RETURN] */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File getFileFromUri(android.content.Context r5, android.net.Uri r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 0
            r3 = 19
            if (r0 < r3) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            r3 = 0
            if (r0 == 0) goto L_0x00b6
            boolean r0 = android.provider.DocumentsContract.isDocumentUri(r5, r6)
            if (r0 == 0) goto L_0x00b6
            boolean r0 = isExternalStorageDocument(r6)
            java.lang.String r4 = ":"
            if (r0 == 0) goto L_0x004a
            java.lang.String r5 = android.provider.DocumentsContract.getDocumentId(r6)
            java.lang.String[] r5 = r5.split(r4)
            r6 = r5[r2]
            java.lang.String r0 = "primary"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x00e3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r6.append(r0)
            java.lang.String r0 = "/"
            r6.append(r0)
            r5 = r5[r1]
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            goto L_0x00e4
        L_0x004a:
            boolean r0 = isDownloadsDocument(r6)
            if (r0 == 0) goto L_0x006c
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r6)
            java.lang.String r0 = "content://downloads/public_downloads"
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            long r1 = r6.longValue()
            android.net.Uri r6 = android.content.ContentUris.withAppendedId(r0, r1)
            java.lang.String r5 = getDataColumn(r5, r6, r3, r3)
            goto L_0x00e4
        L_0x006c:
            boolean r0 = isMediaDocument(r6)
            if (r0 == 0) goto L_0x00ab
            java.lang.String r6 = android.provider.DocumentsContract.getDocumentId(r6)
            java.lang.String[] r6 = r6.split(r4)
            r0 = r6[r2]
            java.lang.String r4 = "image"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0087
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x009e
        L_0x0087:
            java.lang.String r4 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0092
            android.net.Uri r0 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            goto L_0x009e
        L_0x0092:
            java.lang.String r4 = "audio"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x009d
            android.net.Uri r0 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            goto L_0x009e
        L_0x009d:
            r0 = r3
        L_0x009e:
            java.lang.String[] r4 = new java.lang.String[r1]
            r6 = r6[r1]
            r4[r2] = r6
            java.lang.String r6 = "_id=?"
            java.lang.String r5 = getDataColumn(r5, r0, r6, r4)
            goto L_0x00e4
        L_0x00ab:
            boolean r0 = isGoogleDriveDocument(r6)
            if (r0 == 0) goto L_0x00e3
            java.io.File r5 = getGoogleDriveFile(r5, r6)
            return r5
        L_0x00b6:
            java.lang.String r0 = r6.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x00d2
            boolean r0 = isGooglePhotosUri(r6)
            if (r0 == 0) goto L_0x00cd
            java.lang.String r5 = r6.getLastPathSegment()
            goto L_0x00e4
        L_0x00cd:
            java.lang.String r5 = getDataColumn(r5, r6, r3, r3)
            goto L_0x00e4
        L_0x00d2:
            java.lang.String r5 = r6.getScheme()
            java.lang.String r0 = "file"
            boolean r5 = r0.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x00e3
            java.lang.String r5 = r6.getPath()
            goto L_0x00e4
        L_0x00e3:
            r5 = r3
        L_0x00e4:
            if (r5 == 0) goto L_0x00ec
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            return r6
        L_0x00ec:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.util.Utils.getFileFromUri(android.content.Context, android.net.Uri):java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r9, android.net.Uri r10, java.lang.String r11, java.lang.String[] r12) {
        /*
            java.lang.String r0 = "_display_name"
            java.lang.String r1 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r1, r0}
            r8 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0047 }
            r7 = 0
            r3 = r10
            r5 = r11
            r6 = r12
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0047 }
            if (r9 == 0) goto L_0x0041
            boolean r11 = r9.moveToFirst()     // Catch:{ all -> 0x003f }
            if (r11 == 0) goto L_0x0041
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x003f }
            java.lang.String r11 = "content://com.google.android.gallery3d"
            boolean r10 = r10.startsWith(r11)     // Catch:{ all -> 0x003f }
            if (r10 == 0) goto L_0x002e
            int r10 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x003f }
            goto L_0x0032
        L_0x002e:
            int r10 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x003f }
        L_0x0032:
            r11 = -1
            if (r10 == r11) goto L_0x0041
            java.lang.String r10 = r9.getString(r10)     // Catch:{ all -> 0x003f }
            if (r9 == 0) goto L_0x003e
            r9.close()
        L_0x003e:
            return r10
        L_0x003f:
            r10 = move-exception
            goto L_0x0049
        L_0x0041:
            if (r9 == 0) goto L_0x0046
            r9.close()
        L_0x0046:
            return r8
        L_0x0047:
            r10 = move-exception
            r9 = r8
        L_0x0049:
            if (r9 == 0) goto L_0x004e
            r9.close()
        L_0x004e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.util.Utils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isGoogleDriveDocument(Uri uri) {
        return "com.google.android.apps.docs.storage".equals(uri.getAuthority());
    }

    private static File getGoogleDriveFile(Context context, Uri uri) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (uri == null) {
            return null;
        }
        String absolutePath = new File(context.getCacheDir(), "tmp").getAbsolutePath();
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            if (openFileDescriptor == null) {
                closeQuietly(null);
                closeQuietly(null);
                return null;
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                fileOutputStream = new FileOutputStream(absolutePath);
            } catch (IOException unused) {
                fileOutputStream = null;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        File file = new File(absolutePath);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        return file;
                    }
                }
            } catch (IOException unused2) {
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                return null;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileOutputStream2 = fileOutputStream;
                th = th3;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream2);
                throw th;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            closeQuietly(fileInputStream);
            closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[SYNTHETIC, Splitter:B:20:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC, Splitter:B:25:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap decodeSampledBitmapFromUri(android.content.Context r3, android.net.Uri r4, int r5) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0030 }
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0033, all -> 0x0030 }
            if (r1 == 0) goto L_0x0021
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException -> 0x001f }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x001f }
            int r3 = calculateInSampleSize(r3, r4, r5)     // Catch:{ FileNotFoundException -> 0x001f }
            r2.inSampleSize = r3     // Catch:{ FileNotFoundException -> 0x001f }
            r3 = 0
            r2.inJustDecodeBounds = r3     // Catch:{ FileNotFoundException -> 0x001f }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r1, r0, r2)     // Catch:{ FileNotFoundException -> 0x001f }
            r0 = r3
            goto L_0x0021
        L_0x001f:
            r3 = move-exception
            goto L_0x0035
        L_0x0021:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x0027 }
            goto L_0x0041
        L_0x0027:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.isseiaoki.simplecropview.util.Logger.e(r3)
            goto L_0x0041
        L_0x0030:
            r3 = move-exception
            r1 = r0
            goto L_0x0043
        L_0x0033:
            r3 = move-exception
            r1 = r0
        L_0x0035:
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0042 }
            com.isseiaoki.simplecropview.util.Logger.e(r3)     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0041:
            return r0
        L_0x0042:
            r3 = move-exception
        L_0x0043:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            com.isseiaoki.simplecropview.util.Logger.e(r4)
        L_0x0051:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.util.Utils.decodeSampledBitmapFromUri(android.content.Context, android.net.Uri, int):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039 A[ADDED_TO_REGION, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int calculateInSampleSize(android.content.Context r3, android.net.Uri r4, int r5) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            r2 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001d }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x0022, all -> 0x001d }
            android.graphics.BitmapFactory.decodeStream(r3, r2, r0)     // Catch:{ FileNotFoundException -> 0x001b, all -> 0x0018 }
            closeQuietly(r3)
            goto L_0x0025
        L_0x0018:
            r4 = move-exception
            r2 = r3
            goto L_0x001e
        L_0x001b:
            r2 = r3
            goto L_0x0022
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            closeQuietly(r2)
            throw r4
        L_0x0022:
            closeQuietly(r2)
        L_0x0025:
            int r3 = r0.outWidth
            sInputImageWidth = r3
            int r3 = r0.outHeight
            sInputImageHeight = r3
        L_0x002d:
            int r3 = r0.outWidth
            int r3 = r3 / r1
            if (r3 > r5) goto L_0x0039
            int r3 = r0.outHeight
            int r3 = r3 / r1
            if (r3 <= r5) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            return r1
        L_0x0039:
            int r1 = r1 * 2
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.isseiaoki.simplecropview.util.Utils.calculateInSampleSize(android.content.Context, android.net.Uri, int):int");
    }

    public static Bitmap getScaledBitmapForHeight(Bitmap bitmap, int i) {
        return getScaledBitmap(bitmap, Math.round(((float) i) * (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()))), i);
    }

    public static Bitmap getScaledBitmapForWidth(Bitmap bitmap, int i) {
        return getScaledBitmap(bitmap, i, Math.round(((float) i) / (((float) bitmap.getWidth()) / ((float) bitmap.getHeight()))));
    }

    public static Bitmap getScaledBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static int getMaxSize() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] > 0) {
            return Math.min(iArr[0], 4096);
        }
        return 2048;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void updateGalleryInfo(Context context, Uri uri) {
        if (MessageTemplateProtocol.CONTENT.equals(uri.getScheme())) {
            ContentValues contentValues = new ContentValues();
            File fileFromUri = getFileFromUri(context, uri);
            if (fileFromUri != null && fileFromUri.exists()) {
                contentValues.put("_size", Long.valueOf(fileFromUri.length()));
            }
            context.getContentResolver().update(uri, contentValues, null, null);
        }
    }
}
