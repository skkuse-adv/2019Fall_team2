package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache.Limits;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG;
    static final String TAG = "UrlRedirectCache";
    private static FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append("_Redirect");
        REDIRECT_CONTENT_TAG = sb.toString();
    }

    static synchronized FileLruCache getCache() throws IOException {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new Limits());
            }
            fileLruCache = urlRedirectCache;
        }
        return fileLruCache;
    }

    static Uri getRedirectedUri(Uri uri) {
        InputStreamReader inputStreamReader;
        Throwable th;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        try {
            FileLruCache cache = getCache();
            InputStreamReader inputStreamReader2 = null;
            boolean z = false;
            while (true) {
                try {
                    InputStream inputStream = cache.get(uri2, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    z = true;
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader.read(cArr, 0, cArr.length);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader);
                        inputStreamReader2 = inputStreamReader;
                        uri2 = sb.toString();
                    } catch (IOException unused) {
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } catch (IOException unused2) {
                    inputStreamReader = inputStreamReader2;
                    Utility.closeQuietly(inputStreamReader);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = inputStreamReader2;
                    Utility.closeQuietly(inputStreamReader);
                    throw th;
                }
            }
            if (z) {
                Uri parse = Uri.parse(uri2);
                Utility.closeQuietly(inputStreamReader2);
                return parse;
            }
            Utility.closeQuietly(inputStreamReader2);
            return null;
        } catch (IOException unused3) {
            inputStreamReader = null;
            Utility.closeQuietly(inputStreamReader);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            Utility.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    static void cacheUriRedirect(Uri uri, Uri uri2) {
        if (uri != null && uri2 != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
                outputStream.write(uri2.toString().getBytes());
            } catch (IOException unused) {
            } catch (Throwable th) {
                Utility.closeQuietly(outputStream);
                throw th;
            }
            Utility.closeQuietly(outputStream);
        }
    }

    static void clearCache() {
        try {
            getCache().clearCache();
        } catch (IOException e) {
            LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("clearCache failed ");
            sb.append(e.getMessage());
            Logger.log(loggingBehavior, 5, str, sb.toString());
        }
    }
}
