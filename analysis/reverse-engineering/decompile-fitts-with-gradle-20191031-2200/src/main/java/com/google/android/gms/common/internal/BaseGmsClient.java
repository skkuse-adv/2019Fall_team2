package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.kakao.network.ServerProtocol;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzbt = new Feature[0];
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private int zzbu;
    private long zzbv;
    private long zzbw;
    private int zzbx;
    private long zzby;
    private zzh zzbz;
    private final Looper zzca;
    private final GmsClientSupervisor zzcb;
    private final GoogleApiAvailabilityLight zzcc;
    /* access modifiers changed from: private */
    public final Object zzcd;
    /* access modifiers changed from: private */
    public IGmsServiceBroker zzce;
    protected ConnectionProgressReportCallbacks zzcf;
    private T zzcg;
    /* access modifiers changed from: private */
    public final ArrayList<zzc<?>> zzch;
    private zze zzci;
    private int zzcj;
    /* access modifiers changed from: private */
    public final BaseConnectionCallbacks zzck;
    /* access modifiers changed from: private */
    public final BaseOnConnectionFailedListener zzcl;
    private final int zzcm;
    private final String zzcn;
    /* access modifiers changed from: private */
    public ConnectionResult zzco;
    /* access modifiers changed from: private */
    public boolean zzcp;
    private volatile zzb zzcq;
    protected AtomicInteger zzcr;

    public interface BaseConnectionCallbacks {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        public void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
                return;
            }
            if (BaseGmsClient.this.zzcl != null) {
                BaseGmsClient.this.zzcl.onConnectionFailed(connectionResult);
            }
        }
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    private abstract class zza extends zzc<Boolean> {
        private final int statusCode;
        private final Bundle zzcs;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.statusCode = i;
            this.zzcs = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzm();

        /* access modifiers changed from: protected */
        public final void zzn() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void zza(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                BaseGmsClient.this.zza(1, null);
                return;
            }
            int i = this.statusCode;
            if (i != 0) {
                if (i != 10) {
                    BaseGmsClient.this.zza(1, null);
                    Bundle bundle = this.zzcs;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                    }
                    zza(new ConnectionResult(this.statusCode, pendingIntent));
                } else {
                    BaseGmsClient.this.zza(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", new Object[]{getClass().getSimpleName(), BaseGmsClient.this.getStartServiceAction(), BaseGmsClient.this.getServiceDescriptor()}));
                }
            } else if (!zzm()) {
                BaseGmsClient.this.zza(1, null);
                zza(new ConnectionResult(8, null));
            }
        }
    }

    final class zzb extends com.google.android.gms.internal.common.zze {
        public zzb(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.zzcr.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !BaseGmsClient.this.enableLocalFallback()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
                return;
            }
            int i2 = message.what;
            PendingIntent pendingIntent = null;
            if (i2 == 4) {
                BaseGmsClient.this.zzco = new ConnectionResult(message.arg2);
                if (!BaseGmsClient.this.zzl() || BaseGmsClient.this.zzcp) {
                    if (BaseGmsClient.this.zzco != null) {
                        connectionResult2 = BaseGmsClient.this.zzco;
                    } else {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.zzcf.onReportServiceBinding(connectionResult2);
                    BaseGmsClient.this.onConnectionFailed(connectionResult2);
                    return;
                }
                BaseGmsClient.this.zza(3, null);
            } else if (i2 == 5) {
                if (BaseGmsClient.this.zzco != null) {
                    connectionResult = BaseGmsClient.this.zzco;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                BaseGmsClient.this.zzcf.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
            } else if (i2 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                BaseGmsClient.this.zzcf.onReportServiceBinding(connectionResult3);
                BaseGmsClient.this.onConnectionFailed(connectionResult3);
            } else if (i2 == 6) {
                BaseGmsClient.this.zza(5, null);
                if (BaseGmsClient.this.zzck != null) {
                    BaseGmsClient.this.zzck.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.onConnectionSuspended(message.arg2);
                BaseGmsClient.this.zza(5, 1, null);
            } else if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                zza(message);
            } else if (zzb(message)) {
                ((zzc) message.obj).zzo();
            } else {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i3);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }

        private static void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzn();
            zzc.unregister();
        }

        private static boolean zzb(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }
    }

    protected abstract class zzc<TListener> {
        private TListener zzcu;
        private boolean zzcv = false;

        public zzc(TListener tlistener) {
            this.zzcu = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void zzn();

        public final void zzo() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zzcu;
                if (this.zzcv) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    sb.toString();
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (RuntimeException e) {
                    zzn();
                    throw e;
                }
            } else {
                zzn();
            }
            synchronized (this) {
                this.zzcv = true;
            }
            unregister();
        }

        public final void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.zzch) {
                BaseGmsClient.this.zzch.remove(this);
            }
        }

        public final void removeListener() {
            synchronized (this) {
                this.zzcu = null;
            }
        }
    }

    public static final class zzd extends com.google.android.gms.common.internal.IGmsCallbacks.zza {
        private BaseGmsClient zzcw;
        private final int zzcx;

        public zzd(@NonNull BaseGmsClient baseGmsClient, int i) {
            this.zzcw = baseGmsClient;
            this.zzcx = i;
        }

        @BinderThread
        public final void zza(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @BinderThread
        public final void onPostInitComplete(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            Preconditions.checkNotNull(this.zzcw, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzcw.onPostInitHandler(i, iBinder, bundle, this.zzcx);
            this.zzcw = null;
        }

        @BinderThread
        public final void zza(int i, @NonNull IBinder iBinder, @NonNull zzb zzb) {
            Preconditions.checkNotNull(this.zzcw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzb);
            this.zzcw.zza(zzb);
            onPostInitComplete(i, iBinder, zzb.zzda);
        }
    }

    public final class zze implements ServiceConnection {
        private final int zzcx;

        public zze(int i) {
            this.zzcx = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.this.zzb(16);
                return;
            }
            synchronized (BaseGmsClient.this.zzcd) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    iGmsServiceBroker = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                        iGmsServiceBroker = new IGmsServiceBroker$Stub$zza(iBinder);
                    } else {
                        iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                    }
                }
                baseGmsClient.zzce = iGmsServiceBroker;
            }
            BaseGmsClient.this.zza(0, (Bundle) null, this.zzcx);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzcd) {
                BaseGmsClient.this.zzce = null;
            }
            Handler handler = BaseGmsClient.this.mHandler;
            handler.sendMessage(handler.obtainMessage(6, this.zzcx, 1));
        }
    }

    protected final class zzf extends zza {
        private final IBinder zzcy;

        @BinderThread
        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzcy = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzcl != null) {
                BaseGmsClient.this.zzcl.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean zzm() {
            boolean z = false;
            try {
                String interfaceDescriptor = this.zzcy.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    sb.toString();
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.zzcy);
                if (createServiceInterface != null && (BaseGmsClient.this.zza(2, 4, createServiceInterface) || BaseGmsClient.this.zza(3, 4, createServiceInterface))) {
                    BaseGmsClient.this.zzco = null;
                    Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                    if (BaseGmsClient.this.zzck != null) {
                        BaseGmsClient.this.zzck.onConnected(connectionHint);
                    }
                    z = true;
                }
                return z;
            } catch (RemoteException unused) {
            }
        }
    }

    protected final class zzg extends zza {
        @BinderThread
        public zzg(int i, @Nullable Bundle bundle) {
            super(i, null);
        }

        /* access modifiers changed from: protected */
        public final void zza(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.enableLocalFallback() || !BaseGmsClient.this.zzl()) {
                BaseGmsClient.this.zzcf.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            BaseGmsClient.this.zzb(16);
        }

        /* access modifiers changed from: protected */
        public final boolean zzm() {
            BaseGmsClient.this.zzcf.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T createServiceInterface(IBinder iBinder);

    /* access modifiers changed from: protected */
    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getLocalStartServiceAction() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String getServiceDescriptor();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: 0000 */
    public void onSetConnectState(int i, T t) {
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.mLock = new Object();
        this.zzcd = new Object();
        this.zzch = new ArrayList<>();
        this.zzcj = 1;
        this.zzco = null;
        this.zzcp = false;
        this.zzcq = null;
        this.zzcr = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzca = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzcb = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzcc = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzcm = i;
        this.zzck = baseConnectionCallbacks;
        this.zzcl = baseOnConnectionFailedListener;
        this.zzcn = str;
    }

    @Nullable
    private final String zzj() {
        String str = this.zzcn;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzcq = zzb2;
    }

    @Nullable
    public final Feature[] getAvailableFeatures() {
        zzb zzb2 = this.zzcq;
        if (zzb2 == null) {
            return null;
        }
        return zzb2.zzdb;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectedLocked(@NonNull T t) {
        this.zzbw = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.zzbu = i;
        this.zzbv = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzbx = connectionResult.getErrorCode();
        this.zzby = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzh zzh;
        Preconditions.checkArgument((i == 4) == (t != null));
        synchronized (this.mLock) {
            this.zzcj = i;
            this.zzcg = t;
            onSetConnectState(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (!(this.zzci == null || this.zzbz == null)) {
                        String zzt = this.zzbz.zzt();
                        String packageName = this.zzbz.getPackageName();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzt).length() + 70 + String.valueOf(packageName).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(zzt);
                        sb.append(" on ");
                        sb.append(packageName);
                        sb.toString();
                        this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
                        this.zzcr.incrementAndGet();
                    }
                    this.zzci = new zze(this.zzcr.get());
                    if (this.zzcj != 3 || getLocalStartServiceAction() == null) {
                        zzh = new zzh(getStartServicePackage(), getStartServiceAction(), false, 129);
                    } else {
                        zzh = new zzh(getContext().getPackageName(), getLocalStartServiceAction(), true, 129);
                    }
                    this.zzbz = zzh;
                    if (!this.zzcb.zza(new zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq()), this.zzci, zzj())) {
                        String zzt2 = this.zzbz.zzt();
                        String packageName2 = this.zzbz.getPackageName();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzt2).length() + 34 + String.valueOf(packageName2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(zzt2);
                        sb2.append(" on ");
                        sb2.append(packageName2);
                        sb2.toString();
                        zza(16, (Bundle) null, this.zzcr.get());
                    }
                } else if (i == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzci != null) {
                this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
                this.zzci = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzcj != i) {
                return false;
            }
            zza(i2, t);
            return true;
        }
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzcc.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (T) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzcf = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (T) null);
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcj == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzcj != 2) {
                if (this.zzcj != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcj == 3;
        }
        return z;
    }

    public void disconnect() {
        this.zzcr.incrementAndGet();
        synchronized (this.zzch) {
            int size = this.zzch.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzch.get(i)).removeListener();
            }
            this.zzch.clear();
        }
        synchronized (this.zzcd) {
            this.zzce = null;
        }
        zza(1, (T) null);
    }

    public void triggerConnectionSuspended(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.zzcr.get(), i));
    }

    /* access modifiers changed from: private */
    public final void zzb(int i) {
        int i2;
        if (zzk()) {
            i2 = 5;
            this.zzcp = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i2, this.zzcr.get(), 16));
    }

    /* access modifiers changed from: protected */
    public void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        this.zzcf = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.zzcr.get(), i, pendingIntent));
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzca;
    }

    public Feature[] getApiFeatures() {
        return zzbt;
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzcj != 5) {
                checkConnected();
                Preconditions.checkState(this.zzcg != null, "Client is connected but service is null");
                t = this.zzcg;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @WorkerThread
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzcm);
        getServiceRequest.zzy = this.mContext.getPackageName();
        getServiceRequest.zzdk = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzdj = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.zzdl = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.zzdi = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzdl = getAccount();
        }
        getServiceRequest.zzdm = zzbt;
        getServiceRequest.zzdn = getApiFeatures();
        try {
            synchronized (this.zzcd) {
                if (this.zzce != null) {
                    this.zzce.getService(new zzd(this, this.zzcr.get()), getServiceRequest);
                }
            }
        } catch (DeadObjectException unused) {
            triggerConnectionSuspended(1);
        } catch (SecurityException e) {
            throw e;
        } catch (RemoteException | RuntimeException unused2) {
            onPostInitHandler(8, null, null, this.zzcr.get());
        }
    }

    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.mLock) {
            i = this.zzcj;
            t = this.zzcg;
        }
        synchronized (this.zzcd) {
            iGmsServiceBroker = this.zzce;
        }
        printWriter.append(str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzbw > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzbw;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzbv > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.zzbu;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 != 2) {
                printWriter.append(String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzbv;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzby > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzbx));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzby;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(ServerProtocol.AUTHORIZATION_HEADER_DELIMITER);
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @Nullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzcd) {
            if (this.zzce == null) {
                return null;
            }
            IBinder asBinder = this.zzce.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzl() {
        if (this.zzcp || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public String getEndpointPackageName() {
        if (isConnected()) {
            zzh zzh = this.zzbz;
            if (zzh != null) {
                return zzh.getPackageName();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
