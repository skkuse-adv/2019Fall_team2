package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;

public final class Common {
    public static final Api<Object> API = new Api<>("Common.API", zaph, CLIENT_KEY);
    public static final ClientKey<zai> CLIENT_KEY = new ClientKey<>();
    private static final AbstractClientBuilder<zai, Object> zaph = new zab();
    public static final zac zapi = new zad();
}
