package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
public final class Registrar implements ComponentRegistrar {

    private static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zza;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zza = firebaseInstanceId;
        }

        public final String getId() {
            return this.zza.getId();
        }

        public final String getToken() {
            return this.zza.getToken();
        }
    }

    @Keep
    public final List<Component<?>> getComponents() {
        Class<FirebaseInstanceId> cls = FirebaseInstanceId.class;
        return Arrays.asList(new Component[]{Component.builder(cls).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).factory(zzah.zza).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(cls)).factory(zzai.zza).build(), LibraryVersionComponent.create("fire-iid", "19.0.1")});
    }
}
