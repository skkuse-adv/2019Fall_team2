package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AdvertisingInfoServiceStrategy implements AdvertisingInfoStrategy {
    public static final String GOOGLE_PLAY_SERVICES_INTENT = "com.google.android.gms.ads.identifier.service.START";
    public static final String GOOGLE_PLAY_SERVICES_INTENT_PACKAGE_NAME = "com.google.android.gms";
    private final Context context;

    private static final class AdvertisingConnection implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> queue;
        private boolean retrieved;

        private AdvertisingConnection() {
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue<>(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.queue.clear();
        }

        public IBinder getBinder() {
            if (this.retrieved) {
                Fabric.getLogger().e(Fabric.TAG, "getBinder already called");
            }
            this.retrieved = true;
            try {
                return (IBinder) this.queue.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private static final class AdvertisingInterface implements IInterface {
        public static final String ADVERTISING_ID_SERVICE_INTERFACE_TOKEN = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        private final IBinder binder;

        public AdvertisingInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        /* JADX INFO: finally extract failed */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0022, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
            io.fabric.sdk.android.Fabric.getLogger().d(io.fabric.sdk.android.Fabric.TAG, "Could not get parcel from Google Play Service to capture AdvertisingId");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0024 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String getId() throws android.os.RemoteException {
            /*
                r5 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                java.lang.String r2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r2)     // Catch:{ Exception -> 0x0024 }
                android.os.IBinder r2 = r5.binder     // Catch:{ Exception -> 0x0024 }
                r3 = 1
                r4 = 0
                r2.transact(r3, r0, r1, r4)     // Catch:{ Exception -> 0x0024 }
                r1.readException()     // Catch:{ Exception -> 0x0024 }
                java.lang.String r2 = r1.readString()     // Catch:{ Exception -> 0x0024 }
                r1.recycle()
                r0.recycle()
                goto L_0x0036
            L_0x0022:
                r2 = move-exception
                goto L_0x0037
            L_0x0024:
                io.fabric.sdk.android.Logger r2 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ all -> 0x0022 }
                java.lang.String r3 = "Fabric"
                java.lang.String r4 = "Could not get parcel from Google Play Service to capture AdvertisingId"
                r2.d(r3, r4)     // Catch:{ all -> 0x0022 }
                r1.recycle()
                r0.recycle()
                r2 = 0
            L_0x0036:
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy.AdvertisingInterface.getId():java.lang.String");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
            r1.recycle();
            r0.recycle();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            io.fabric.sdk.android.Fabric.getLogger().d(io.fabric.sdk.android.Fabric.TAG, "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0025 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isLimitAdTrackingEnabled() throws android.os.RemoteException {
            /*
                r6 = this;
                android.os.Parcel r0 = android.os.Parcel.obtain()
                android.os.Parcel r1 = android.os.Parcel.obtain()
                r2 = 0
                java.lang.String r3 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService"
                r0.writeInterfaceToken(r3)     // Catch:{ Exception -> 0x0025 }
                r3 = 1
                r0.writeInt(r3)     // Catch:{ Exception -> 0x0025 }
                android.os.IBinder r4 = r6.binder     // Catch:{ Exception -> 0x0025 }
                r5 = 2
                r4.transact(r5, r0, r1, r2)     // Catch:{ Exception -> 0x0025 }
                r1.readException()     // Catch:{ Exception -> 0x0025 }
                int r4 = r1.readInt()     // Catch:{ Exception -> 0x0025 }
                if (r4 == 0) goto L_0x0030
                r2 = 1
                goto L_0x0030
            L_0x0023:
                r2 = move-exception
                goto L_0x0037
            L_0x0025:
                io.fabric.sdk.android.Logger r3 = io.fabric.sdk.android.Fabric.getLogger()     // Catch:{ all -> 0x0023 }
                java.lang.String r4 = "Fabric"
                java.lang.String r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking"
                r3.d(r4, r5)     // Catch:{ all -> 0x0023 }
            L_0x0030:
                r1.recycle()
                r0.recycle()
                return r2
            L_0x0037:
                r1.recycle()
                r0.recycle()
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoServiceStrategy.AdvertisingInterface.isLimitAdTrackingEnabled():boolean");
        }
    }

    public AdvertisingInfoServiceStrategy(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public AdvertisingInfo getAdvertisingInfo() {
        String str = "Could not bind to Google Play Service to capture AdvertisingId";
        Looper myLooper = Looper.myLooper();
        Looper mainLooper = Looper.getMainLooper();
        String str2 = Fabric.TAG;
        if (myLooper == mainLooper) {
            Fabric.getLogger().d(str2, "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent(GOOGLE_PLAY_SERVICES_INTENT);
            intent.setPackage("com.google.android.gms");
            try {
                if (this.context.bindService(intent, advertisingConnection, 1)) {
                    try {
                        AdvertisingInterface advertisingInterface = new AdvertisingInterface(advertisingConnection.getBinder());
                        AdvertisingInfo advertisingInfo = new AdvertisingInfo(advertisingInterface.getId(), advertisingInterface.isLimitAdTrackingEnabled());
                        this.context.unbindService(advertisingConnection);
                        return advertisingInfo;
                    } catch (Exception e) {
                        Fabric.getLogger().w(str2, "Exception in binding to Google Play Service to capture AdvertisingId", e);
                        this.context.unbindService(advertisingConnection);
                    }
                } else {
                    Fabric.getLogger().d(str2, str);
                    return null;
                }
            } catch (Throwable th) {
                Fabric.getLogger().d(str2, str, th);
            }
        } catch (NameNotFoundException unused) {
            Fabric.getLogger().d(str2, "Unable to find Google Play Services package name");
            return null;
        } catch (Exception e2) {
            Fabric.getLogger().d(str2, "Unable to determine if Google Play Services is available", e2);
            return null;
        }
    }
}
