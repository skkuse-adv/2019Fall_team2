package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    private static final class GoogleAdInfo implements IInterface {
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(AdvertisingInterface.ADVERTISING_ID_SERVICE_INTERFACE_TOKEN);
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(AdvertisingInterface.ADVERTISING_ID_SERVICE_INTERFACE_TOKEN);
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        public void onServiceDisconnected(ComponentName componentName) {
        }

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return (IBinder) this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null) {
                    return null;
                }
                Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
                if (invokeMethodQuietly instanceof Integer) {
                    if (((Integer) invokeMethodQuietly).intValue() == 0) {
                        Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                        if (methodQuietly2 == null) {
                            return null;
                        }
                        Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly2, context);
                        if (invokeMethodQuietly2 == null) {
                            return null;
                        }
                        Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", (Class<?>[]) new Class[0]);
                        Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                        if (methodQuietly3 != null) {
                            if (methodQuietly4 != null) {
                                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly3, new Object[0]);
                                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly4, new Object[0])).booleanValue();
                                return attributionIdentifiers;
                            }
                        }
                    }
                }
                return null;
            }
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        } catch (Exception e) {
            Utility.logd("android_id", e);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent(AdvertisingInfoServiceStrategy.GOOGLE_PLAY_SERVICES_INTENT);
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b A[Catch:{ Exception -> 0x00c0, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f A[Catch:{ Exception -> 0x00c0, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[Catch:{ Exception -> 0x00c0, all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r12) {
        /*
            java.lang.String r0 = "limit_tracking"
            java.lang.String r1 = "androidid"
            java.lang.String r2 = "aid"
            android.os.Looper r3 = android.os.Looper.myLooper()
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            com.facebook.internal.AttributionIdentifiers r3 = recentlyFetchedIdentifiers
            if (r3 == 0) goto L_0x0023
            long r3 = java.lang.System.currentTimeMillis()
            com.facebook.internal.AttributionIdentifiers r5 = recentlyFetchedIdentifiers
            long r6 = r5.fetchTime
            long r3 = r3 - r6
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0023
            return r5
        L_0x0023:
            com.facebook.internal.AttributionIdentifiers r3 = getAndroidId(r12)
            r4 = 0
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            java.lang.String r6 = "com.facebook.katana.provider.AttributionIdProvider"
            r8 = 0
            android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            if (r5 == 0) goto L_0x0041
            java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
        L_0x003f:
            r6 = r5
            goto L_0x0055
        L_0x0041:
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            java.lang.String r6 = "com.facebook.wakizashi.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            if (r5 == 0) goto L_0x0054
            java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            goto L_0x003f
        L_0x0054:
            r6 = r4
        L_0x0055:
            java.lang.String r5 = getInstallerPackageName(r12)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            if (r5 == 0) goto L_0x005d
            r3.androidInstallerPackage = r5     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
        L_0x005d:
            if (r6 != 0) goto L_0x0063
            cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            return r3
        L_0x0063:
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00c0, all -> 0x00be }
            if (r12 == 0) goto L_0x00ac
            boolean r5 = r12.moveToFirst()     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r5 != 0) goto L_0x0077
            goto L_0x00ac
        L_0x0077:
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            int r0 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.attributionId = r2     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r1 <= 0) goto L_0x00a3
            if (r0 <= 0) goto L_0x00a3
            java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r2 != 0) goto L_0x00a3
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.androidAdvertiserId = r1     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.limitTracking = r0     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
        L_0x00a3:
            if (r12 == 0) goto L_0x00a8
            r12.close()
        L_0x00a8:
            cacheAndReturnIdentifiers(r3)
            return r3
        L_0x00ac:
            cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r12 == 0) goto L_0x00b4
            r12.close()
        L_0x00b4:
            return r3
        L_0x00b5:
            r0 = move-exception
            r4 = r12
            r12 = r0
            goto L_0x00e4
        L_0x00b9:
            r0 = move-exception
            r11 = r0
            r0 = r12
            r12 = r11
            goto L_0x00c2
        L_0x00be:
            r12 = move-exception
            goto L_0x00e4
        L_0x00c0:
            r12 = move-exception
            r0 = r4
        L_0x00c2:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r2.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r3 = "Caught unexpected exception in getAttributionId(): "
            r2.append(r3)     // Catch:{ all -> 0x00e2 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00e2 }
            r2.append(r12)     // Catch:{ all -> 0x00e2 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x00e2 }
            com.facebook.internal.Utility.logd(r1, r12)     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x00e1
            r0.close()
        L_0x00e1:
            return r4
        L_0x00e2:
            r12 = move-exception
            r4 = r0
        L_0x00e4:
            if (r4 == 0) goto L_0x00e9
            r4.close()
        L_0x00e9:
            goto L_0x00eb
        L_0x00ea:
            throw r12
        L_0x00eb:
            goto L_0x00ea
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    public static AttributionIdentifiers getCachedIdentifiers() {
        return recentlyFetchedIdentifiers;
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        if (!FacebookSdk.isInitialized() || !FacebookSdk.getAdvertiserIDCollectionEnabled()) {
            return null;
        }
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    @Nullable
    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
