package com.google.android.gms.internal.firebase_remote_config;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public final class zzr implements zzv {
    public final String getName() {
        return HttpRequest.ENCODING_GZIP;
    }

    public final void zza(zzcm zzcm, OutputStream outputStream) throws IOException {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new zzq(this, outputStream));
        zzcm.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
