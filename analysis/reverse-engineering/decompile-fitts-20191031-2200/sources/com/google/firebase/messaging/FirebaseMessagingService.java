package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.google.firebase.iid.zzan;
import java.util.ArrayDeque;
import java.util.Queue;

public class FirebaseMessagingService extends zze {
    private static final Queue<String> zza = new ArrayDeque(10);

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(String str) {
    }

    @WorkerThread
    public void onNewToken(String str) {
    }

    @WorkerThread
    public void onSendError(String str, Exception exc) {
    }

    /* access modifiers changed from: protected */
    public final Intent zza(Intent intent) {
        return zzan.zza().zzb();
    }

    public final boolean zzb(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException unused) {
            }
        }
        if (MessagingAnalytics.shouldUploadMetrics(intent)) {
            MessagingAnalytics.logNotificationOpen(intent);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00eb, code lost:
        if (r1.equals(r4) != false) goto L_0x00f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(android.content.Intent r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.getAction()
            java.lang.String r1 = "com.google.android.c2dm.intent.RECEIVE"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0015
            goto L_0x0053
        L_0x0015:
            java.lang.String r1 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0027
            boolean r0 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r11)
            if (r0 == 0) goto L_0x0052
            com.google.firebase.messaging.MessagingAnalytics.logNotificationDismiss(r11)
            return
        L_0x0027:
            java.lang.String r1 = "com.google.firebase.messaging.NEW_TOKEN"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "token"
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.onNewToken(r11)
            return
        L_0x0039:
            java.lang.String r0 = "Unknown intent action: "
            java.lang.String r11 = r11.getAction()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r1 = r11.length()
            if (r1 == 0) goto L_0x004d
            r0.concat(r11)
            goto L_0x0052
        L_0x004d:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0)
        L_0x0052:
            return
        L_0x0053:
            java.lang.String r0 = "google.message_id"
            java.lang.String r1 = r11.getStringExtra(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 2
            if (r2 == 0) goto L_0x0066
            r2 = 0
            com.google.android.gms.tasks.Task r2 = com.google.android.gms.tasks.Tasks.forResult(r2)
            goto L_0x0076
        L_0x0066:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putString(r0, r1)
            com.google.firebase.iid.zzu r4 = com.google.firebase.iid.zzu.zza(r10)
            com.google.android.gms.tasks.Task r2 = r4.zza(r3, r2)
        L_0x0076:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r5 = 1
            r6 = 3
            r7 = 0
            if (r4 == 0) goto L_0x0081
        L_0x007f:
            r1 = 0
            goto L_0x00bd
        L_0x0081:
            java.util.Queue<java.lang.String> r4 = zza
            boolean r4 = r4.contains(r1)
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = "FirebaseMessaging"
            boolean r4 = android.util.Log.isLoggable(r4, r6)
            if (r4 == 0) goto L_0x00a6
            java.lang.String r4 = "Received duplicate message: "
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r8 = r1.length()
            if (r8 == 0) goto L_0x00a1
            r4.concat(r1)
            goto L_0x00a6
        L_0x00a1:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4)
        L_0x00a6:
            r1 = 1
            goto L_0x00bd
        L_0x00a8:
            java.util.Queue<java.lang.String> r4 = zza
            int r4 = r4.size()
            r8 = 10
            if (r4 < r8) goto L_0x00b7
            java.util.Queue<java.lang.String> r4 = zza
            r4.remove()
        L_0x00b7:
            java.util.Queue<java.lang.String> r4 = zza
            r4.add(r1)
            goto L_0x007f
        L_0x00bd:
            if (r1 != 0) goto L_0x018c
            java.lang.String r1 = "message_type"
            java.lang.String r1 = r11.getStringExtra(r1)
            java.lang.String r4 = "gcm"
            if (r1 != 0) goto L_0x00ca
            r1 = r4
        L_0x00ca:
            r8 = -1
            int r9 = r1.hashCode()
            switch(r9) {
                case -2062414158: goto L_0x00ee;
                case 102161: goto L_0x00e7;
                case 814694033: goto L_0x00dd;
                case 814800675: goto L_0x00d3;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            goto L_0x00f8
        L_0x00d3:
            java.lang.String r4 = "send_event"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00f8
            r7 = 2
            goto L_0x00f9
        L_0x00dd:
            java.lang.String r4 = "send_error"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00f8
            r7 = 3
            goto L_0x00f9
        L_0x00e7:
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00ee:
            java.lang.String r4 = "deleted_messages"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00f8
            r7 = 1
            goto L_0x00f9
        L_0x00f8:
            r7 = -1
        L_0x00f9:
            if (r7 == 0) goto L_0x0140
            if (r7 == r5) goto L_0x013c
            if (r7 == r3) goto L_0x0134
            if (r7 == r6) goto L_0x0119
            java.lang.String r11 = "Received message with unknown type: "
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0112
            r11.concat(r0)
            goto L_0x018c
        L_0x0112:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r11)
            goto L_0x018c
        L_0x0119:
            java.lang.String r0 = r11.getStringExtra(r0)
            if (r0 != 0) goto L_0x0125
            java.lang.String r0 = "message_id"
            java.lang.String r0 = r11.getStringExtra(r0)
        L_0x0125:
            com.google.firebase.messaging.SendException r1 = new com.google.firebase.messaging.SendException
            java.lang.String r3 = "error"
            java.lang.String r11 = r11.getStringExtra(r3)
            r1.<init>(r11)
            r10.onSendError(r0, r1)
            goto L_0x018c
        L_0x0134:
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.onMessageSent(r11)
            goto L_0x018c
        L_0x013c:
            r10.onDeletedMessages()
            goto L_0x018c
        L_0x0140:
            boolean r0 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r11)
            if (r0 == 0) goto L_0x0149
            com.google.firebase.messaging.MessagingAnalytics.logNotificationReceived(r11)
        L_0x0149:
            android.os.Bundle r0 = r11.getExtras()
            if (r0 != 0) goto L_0x0154
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
        L_0x0154:
            java.lang.String r1 = "androidx.contentpager.content.wakelockid"
            r0.remove(r1)
            boolean r1 = com.google.firebase.messaging.zza.zzb(r0)
            if (r1 == 0) goto L_0x0184
            java.util.concurrent.ExecutorService r1 = java.util.concurrent.Executors.newSingleThreadExecutor()
            com.google.firebase.messaging.zzb r3 = new com.google.firebase.messaging.zzb
            r3.<init>(r10, r0, r1)
            boolean r3 = r3.zza()     // Catch:{ all -> 0x017f }
            if (r3 == 0) goto L_0x0172
            r1.shutdown()
            goto L_0x018c
        L_0x0172:
            r1.shutdown()
            boolean r1 = com.google.firebase.messaging.MessagingAnalytics.shouldUploadMetrics(r11)
            if (r1 == 0) goto L_0x0184
            com.google.firebase.messaging.MessagingAnalytics.logNotificationForeground(r11)
            goto L_0x0184
        L_0x017f:
            r11 = move-exception
            r1.shutdown()
            throw r11
        L_0x0184:
            com.google.firebase.messaging.RemoteMessage r11 = new com.google.firebase.messaging.RemoteMessage
            r11.<init>(r0)
            r10.onMessageReceived(r11)
        L_0x018c:
            r0 = 1
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x0198, InterruptedException -> 0x0196, TimeoutException -> 0x0194 }
            com.google.android.gms.tasks.Tasks.await(r2, r0, r11)     // Catch:{ ExecutionException -> 0x0198, InterruptedException -> 0x0196, TimeoutException -> 0x0194 }
            return
        L_0x0194:
            r11 = move-exception
            goto L_0x0199
        L_0x0196:
            r11 = move-exception
            goto L_0x0199
        L_0x0198:
            r11 = move-exception
        L_0x0199:
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r0 = java.lang.String.valueOf(r11)
            int r0 = r0.length()
            int r0 = r0 + 20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Message ack failed: "
            r1.append(r0)
            r1.append(r11)
            r1.toString()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.zzc(android.content.Intent):void");
    }
}
