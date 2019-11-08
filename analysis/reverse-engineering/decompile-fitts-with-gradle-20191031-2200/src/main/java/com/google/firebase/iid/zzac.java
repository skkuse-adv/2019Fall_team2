package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

final class zzac {
    private final Messenger zza;
    private final zzd zzb;

    zzac(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.zza = new Messenger(iBinder);
            this.zzb = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.zzb = new zzd(iBinder);
            this.zza = null;
        } else {
            String str = "Invalid interface descriptor: ";
            String valueOf = String.valueOf(interfaceDescriptor);
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzd = this.zzb;
        if (zzd != null) {
            zzd.zza(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
