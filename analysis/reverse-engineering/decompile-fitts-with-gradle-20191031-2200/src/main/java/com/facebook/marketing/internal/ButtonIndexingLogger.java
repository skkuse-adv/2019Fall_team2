package com.facebook.marketing.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.kakao.message.template.MessageTemplateProtocol;
import com.kakao.usermgmt.StringSet;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ButtonIndexingLogger {
    /* access modifiers changed from: private */
    public static final String TAG = "com.facebook.marketing.internal.ButtonIndexingLogger";
    private static volatile Set<String> clickedKeySet = new HashSet();

    static {
        new HashSet();
    }

    private static JSONObject generateButtonDetail(View view, String str, boolean z) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String[] split = str.split("\\.", -1);
            int length = split.length - 1;
            View view2 = view;
            while (view2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("classname", view2.getClass().getCanonicalName());
                jSONObject2.put("index", split[length]);
                jSONObject2.put("id", view2.getId());
                String str3 = "";
                if (SensitiveUserDataUtils.isSensitiveUserData(view2)) {
                    str2 = str3;
                } else {
                    str2 = ViewHierarchy.getTextOfView(view2);
                }
                jSONObject2.put("text", str2);
                jSONObject2.put(StringSet.tag, view2.getTag() == null ? str3 : String.valueOf(view2.getTag()));
                String str4 = MessageTemplateProtocol.DESCRIPTION;
                if (view2.getContentDescription() != null) {
                    str3 = String.valueOf(view2.getContentDescription());
                }
                jSONObject2.put(str4, str3);
                jSONArray.put(jSONObject2);
                view2 = ViewHierarchy.getParentOfView(view2);
                length--;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int length2 = jSONArray.length() - 1; length2 >= 0; length2--) {
                jSONArray2.put(jSONArray.get(length2));
            }
            jSONObject.put("path", jSONArray2);
            jSONObject.put("is_from_click", z);
            if (view instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put(MessengerShareContentUtility.MEDIA_IMAGE, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
            return jSONObject;
        } catch (Exception unused) {
            return new JSONObject();
        }
    }

    private static void sendGraphAPIRequest(Context context, String str, String str2) {
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            String appVersion = AppEventUtility.getAppVersion();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("app_version", appVersion);
                bundle.putString("indexed_button_list", str);
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/button_indexing", new Object[]{str2}), null, null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (Exception unused) {
            }
        }
    }

    public static void logIndexing(String str, View view, String str2, Context context) {
        if (!clickedKeySet.contains(str2)) {
            clickedKeySet.add(str2);
            JSONObject generateButtonDetail = generateButtonDetail(view, str2, true);
            if (generateButtonDetail.length() > 0) {
                sendGraphAPIRequest(context, new JSONArray(Arrays.asList(new String[]{generateButtonDetail.toString()})).toString(), str);
            }
        }
    }

    public static void logAllIndexing(final JSONObject jSONObject, final String str) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    String applicationId = FacebookSdk.getApplicationId();
                    AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                    jSONObject.put("screenname", str);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONObject.put("view", jSONArray);
                    GraphRequest buildAppIndexingRequest = ViewIndexer.buildAppIndexingRequest(jSONObject.toString(), currentAccessToken, applicationId, "button_sampling");
                    if (buildAppIndexingRequest != null) {
                        buildAppIndexingRequest.executeAndWait();
                    }
                } catch (JSONException e) {
                    Utility.logd(ButtonIndexingLogger.TAG, (Exception) e);
                }
            }
        });
    }
}
