package dagger.android;

import android.content.BroadcastReceiver;

public interface HasBroadcastReceiverInjector {
    AndroidInjector<BroadcastReceiver> broadcastReceiverInjector();
}
