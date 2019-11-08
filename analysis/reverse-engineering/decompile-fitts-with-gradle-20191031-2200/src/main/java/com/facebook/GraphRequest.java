package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ShareInternalUtility;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.kakao.message.template.MessageTemplateProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GraphRequest {
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    public static final String FIELDS_PARAM = "fields";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    /* access modifiers changed from: private */
    public static final String MIME_BOUNDARY;
    public static final String TAG = "GraphRequest";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private static Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private JSONObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private boolean skipClientToken;
    private Object tag;
    private String version;

    private static class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            this.request = graphRequest;
            this.value = obj;
        }

        public GraphRequest getRequest() {
            return this.request;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    public interface GraphJSONArrayCallback {
        void onCompleted(JSONArray jSONArray, GraphResponse graphResponse);
    }

    public interface GraphJSONObjectCallback {
        void onCompleted(JSONObject jSONObject, GraphResponse graphResponse);
    }

    private interface KeyValueSerializer {
        void writeString(String str, String str2) throws IOException;
    }

    public interface OnProgressCallback extends Callback {
        void onProgress(long j, long j2);
    }

    public static class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Creator<ParcelableResourceWithMimeType> CREATOR = new Creator<ParcelableResourceWithMimeType>() {
            public ParcelableResourceWithMimeType createFromParcel(Parcel parcel) {
                return new ParcelableResourceWithMimeType(parcel);
            }

            public ParcelableResourceWithMimeType[] newArray(int i) {
                return new ParcelableResourceWithMimeType[i];
            }
        };
        private final String mimeType;
        private final RESOURCE resource;

        public int describeContents() {
            return 1;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public RESOURCE getResource() {
            return this.resource;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource2, String str) {
            this.mimeType = str;
            this.resource = resource2;
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    private static class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private boolean useUrlEncode = false;

        public Serializer(OutputStream outputStream2, Logger logger2, boolean z) {
            this.outputStream = outputStream2;
            this.logger = logger2;
            this.useUrlEncode = z;
        }

        public void writeObject(String str, Object obj, GraphRequest graphRequest) throws IOException {
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof RequestOutputStream) {
                ((RequestOutputStream) outputStream2).setCurrentRequest(graphRequest);
            }
            if (GraphRequest.isSupportedParameterType(obj)) {
                writeString(str, GraphRequest.parameterToString(obj));
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, null);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, mimeType);
                } else {
                    throw getInvalidTypeError();
                }
            } else {
                throw getInvalidTypeError();
            }
        }

        private RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public void writeRequestsAsJson(String str, JSONArray jSONArray, Collection<GraphRequest> collection) throws IOException, JSONException {
            OutputStream outputStream2 = this.outputStream;
            if (!(outputStream2 instanceof RequestOutputStream)) {
                writeString(str, jSONArray.toString());
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream2;
            writeContentDisposition(str, null, null);
            write("[", new Object[0]);
            int i = 0;
            for (GraphRequest graphRequest : collection) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                requestOutputStream.setCurrentRequest(graphRequest);
                if (i > 0) {
                    write(",%s", jSONObject.toString());
                } else {
                    write("%s", jSONObject.toString());
                }
                i++;
            }
            write("]", new Object[0]);
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), jSONArray.toString());
            }
        }

        public void writeString(String str, String str2) throws IOException {
            writeContentDisposition(str, null, null);
            writeLine("%s", str2);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), str2);
            }
        }

        public void writeBitmap(String str, Bitmap bitmap) throws IOException {
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), "<Image>");
            }
        }

        public void writeBytes(String str, byte[] bArr) throws IOException {
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(bArr.length)}));
            }
        }

        public void writeContentUri(String str, Uri uri, String str2) throws IOException {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws IOException {
            int i;
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream2).addProgress(parcelFileDescriptor.getStatSize());
                i = 0;
            } else {
                i = Utility.copyAndCloseInputStream(new AutoCloseInputStream(parcelFileDescriptor), this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("    ");
                sb.append(str);
                logger2.appendKeyValue(sb.toString(), String.format(Locale.ROOT, "<Data: %d>", new Object[]{Integer.valueOf(i)}));
            }
        }

        public void writeRecordBoundary() throws IOException {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            this.outputStream.write("&".getBytes());
        }

        public void writeContentDisposition(String str, String str2, String str3) throws IOException {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                String str4 = "";
                writeLine(str4, new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", HttpRequest.HEADER_CONTENT_TYPE, str3);
                }
                writeLine(str4, new Object[0]);
                return;
            }
            this.outputStream.write(String.format("%s=", new Object[]{str}).getBytes());
        }

        public void write(String str, Object... objArr) throws IOException {
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    this.outputStream.write("--".getBytes());
                    this.outputStream.write(GraphRequest.MIME_BOUNDARY.getBytes());
                    this.outputStream.write("\r\n".getBytes());
                    this.firstWrite = false;
                }
                this.outputStream.write(String.format(str, objArr).getBytes());
                return;
            }
            this.outputStream.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
        }

        public void writeLine(String str, Object... objArr) throws IOException {
            write(str, objArr);
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }
    }

    private static String getDefaultPhotoPathIfNull(String str) {
        return str == null ? ShareInternalUtility.MY_PHOTOS : str;
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            sb.append(charArray[secureRandom.nextInt(charArray.length)]);
        }
        MIME_BOUNDARY = sb.toString();
    }

    public GraphRequest() {
        this(null, null, null, null, null);
    }

    public GraphRequest(AccessToken accessToken2, String str) {
        this(accessToken2, str, null, null, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2) {
        this(accessToken2, str, bundle, httpMethod2, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2) {
        this(accessToken2, str, bundle, httpMethod2, callback2, null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken2;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback2);
        setHttpMethod(httpMethod2);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    GraphRequest(AccessToken accessToken2, URL url) {
        this.batchEntryOmitResultOnSuccess = true;
        this.skipClientToken = false;
        this.accessToken = accessToken2;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }

    public static GraphRequest newDeleteObjectRequest(AccessToken accessToken2, String str, Callback callback2) {
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, HttpMethod.DELETE, callback2);
        return graphRequest;
    }

    public static GraphRequest newMeRequest(AccessToken accessToken2, final GraphJSONObjectCallback graphJSONObjectCallback) {
        AccessToken accessToken3 = accessToken2;
        GraphRequest graphRequest = new GraphRequest(accessToken3, "me", null, null, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                GraphJSONObjectCallback graphJSONObjectCallback = graphJSONObjectCallback;
                if (graphJSONObjectCallback != null) {
                    graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
                }
            }
        });
        return graphRequest;
    }

    public static GraphRequest newPostRequest(AccessToken accessToken2, String str, JSONObject jSONObject, Callback callback2) {
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, HttpMethod.POST, callback2);
        graphRequest.setGraphObject(jSONObject);
        return graphRequest;
    }

    public static GraphRequest newMyFriendsRequest(AccessToken accessToken2, final GraphJSONArrayCallback graphJSONArrayCallback) {
        AccessToken accessToken3 = accessToken2;
        GraphRequest graphRequest = new GraphRequest(accessToken3, "me/friends", null, null, new Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (graphJSONArrayCallback != null) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                }
            }
        });
        return graphRequest;
    }

    public static GraphRequest newGraphPathRequest(AccessToken accessToken2, String str, Callback callback2) {
        GraphRequest graphRequest = new GraphRequest(accessToken2, str, null, null, callback2);
        return graphRequest;
    }

    public static GraphRequest newPlacesSearchRequest(AccessToken accessToken2, Location location, int i, int i2, String str, final GraphJSONArrayCallback graphJSONArrayCallback) {
        if (location != null || !Utility.isNullOrEmpty(str)) {
            Bundle bundle = new Bundle(5);
            bundle.putString("type", "place");
            bundle.putInt("limit", i2);
            if (location != null) {
                bundle.putString("center", String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}));
                bundle.putInt("distance", i);
            }
            if (!Utility.isNullOrEmpty(str)) {
                bundle.putString("q", str);
            }
            String str2 = "search";
            AccessToken accessToken3 = accessToken2;
            GraphRequest graphRequest = new GraphRequest(accessToken3, str2, bundle, HttpMethod.GET, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    if (graphJSONArrayCallback != null) {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        graphJSONArrayCallback.onCompleted(jSONObject != null ? jSONObject.optJSONArray("data") : null, graphResponse);
                    }
                }
            });
            return graphRequest;
        }
        throw new FacebookException("Either location or searchText must be specified.");
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback2) {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", bitmap);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, File file, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("picture", open);
        if (str2 != null && !str2.isEmpty()) {
            bundle2.putString("caption", str2);
        }
        GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
        return graphRequest;
    }

    public static GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Uri uri, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException {
        String defaultPhotoPathIfNull = getDefaultPhotoPathIfNull(str);
        if (Utility.isFileUri(uri)) {
            return newUploadPhotoRequest(accessToken2, defaultPhotoPathIfNull, new File(uri.getPath()), str2, bundle, callback2);
        }
        if (Utility.isContentUri(uri)) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", uri);
            if (str2 != null && !str2.isEmpty()) {
                bundle2.putString("caption", str2);
            }
            GraphRequest graphRequest = new GraphRequest(accessToken2, defaultPhotoPathIfNull, bundle2, HttpMethod.POST, callback2);
            return graphRequest;
        }
        throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, String str, Callback callback2) {
        String str2;
        if (str == null && accessToken2 != null) {
            str = accessToken2.getApplicationId();
        }
        if (str == null) {
            str = Utility.getMetadataApplicationId(context);
        }
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/custom_audience_third_party_id");
            String sb2 = sb.toString();
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
            Bundle bundle = new Bundle();
            if (accessToken2 == null) {
                if (attributionIdentifiers != null) {
                    if (attributionIdentifiers.getAttributionId() != null) {
                        str2 = attributionIdentifiers.getAttributionId();
                    } else {
                        str2 = attributionIdentifiers.getAndroidAdvertiserId();
                    }
                    if (attributionIdentifiers.getAttributionId() != null) {
                        bundle.putString("udid", str2);
                    }
                } else {
                    throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                }
            }
            if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                bundle.putString("limit_event_usage", "1");
            }
            GraphRequest graphRequest = new GraphRequest(accessToken2, sb2, bundle, HttpMethod.GET, callback2);
            return graphRequest;
        }
        throw new FacebookException("Facebook App ID cannot be determined");
    }

    public static GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, Callback callback2) {
        return newCustomAudienceThirdPartyIdRequest(accessToken2, context, null, callback2);
    }

    public final JSONObject getGraphObject() {
        return this.graphObject;
    }

    public final void setGraphObject(JSONObject jSONObject) {
        this.graphObject = jSONObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final void setHttpMethod(HttpMethod httpMethod2) {
        if (this.overriddenURL == null || httpMethod2 == HttpMethod.GET) {
            if (httpMethod2 == null) {
                httpMethod2 = HttpMethod.GET;
            }
            this.httpMethod = httpMethod2;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final void setSkipClientToken(boolean z) {
        this.skipClientToken = z;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final void setParameters(Bundle bundle) {
        this.parameters = bundle;
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(AccessToken accessToken2) {
        this.accessToken = accessToken2;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z) {
        this.batchEntryOmitResultOnSuccess = z;
    }

    public static final String getDefaultBatchApplicationId() {
        return defaultBatchApplicationId;
    }

    public static final void setDefaultBatchApplicationId(String str) {
        defaultBatchApplicationId = str;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(final Callback callback2) {
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new Callback(this) {
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("__debug__") : null;
                    JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("messages") : null;
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            String optString = optJSONObject2 != null ? optJSONObject2.optString(SettingsJsonConstants.PROMPT_MESSAGE_KEY) : null;
                            String optString2 = optJSONObject2 != null ? optJSONObject2.optString("type") : null;
                            String optString3 = optJSONObject2 != null ? optJSONObject2.optString(MessageTemplateProtocol.LINK) : null;
                            if (!(optString == null || optString2 == null)) {
                                LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                                if (optString2.equals("warning")) {
                                    loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                                }
                                if (!Utility.isNullOrEmpty(optString3)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(optString);
                                    sb.append(" Link: ");
                                    sb.append(optString3);
                                    optString = sb.toString();
                                }
                                Logger.log(loggingBehavior, GraphRequest.TAG, optString);
                            }
                        }
                    }
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onCompleted(graphResponse);
                    }
                }
            };
        } else {
            this.callback = callback2;
        }
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final GraphResponse executeAndWait() {
        return executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeBatchAsync(this);
    }

    public static HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return toHttpConnection((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    public static HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new GraphRequestBatch(collection));
    }

    public static HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        URL url;
        validateFieldsParamForGetRequests(graphRequestBatch);
        try {
            if (graphRequestBatch.size() == 1) {
                url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
            } else {
                url = new URL(ServerProtocol.getGraphUrlBase());
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = createConnection(url);
                serializeToUrlConnection(graphRequestBatch, httpURLConnection);
                return httpURLConnection;
            } catch (IOException | JSONException e) {
                Utility.disconnectQuietly(httpURLConnection);
                throw new FacebookException("could not construct request body", e);
            }
        } catch (MalformedURLException e2) {
            throw new FacebookException("could not construct URL for request", (Throwable) e2);
        }
    }

    public static GraphResponse executeAndWait(GraphRequest graphRequest) {
        List executeBatchAndWait = executeBatchAndWait(graphRequest);
        if (executeBatchAndWait != null && executeBatchAndWait.size() == 1) {
            return (GraphResponse) executeBatchAndWait.get(0);
        }
        throw new FacebookException("invalid state: expected a single response");
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAndWait((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    public static List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return executeBatchAndWait(new GraphRequestBatch(collection));
    }

    public static List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = toHttpConnection(graphRequestBatch);
            return executeConnectionAndWait(httpURLConnection, graphRequestBatch);
        } catch (Exception e) {
            List<GraphResponse> constructErrorResponses = GraphResponse.constructErrorResponses(graphRequestBatch.getRequests(), httpURLConnection, new FacebookException((Throwable) e));
            runCallbacks(graphRequestBatch, constructErrorResponses);
            return constructErrorResponses;
        } finally {
            Utility.disconnectQuietly(httpURLConnection);
        }
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        Validate.notNull(graphRequestArr, "requests");
        return executeBatchAsync((Collection<GraphRequest>) Arrays.asList(graphRequestArr));
    }

    public static GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return executeBatchAsync(new GraphRequestBatch(collection));
    }

    public static GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
    }

    public static List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        List<GraphResponse> fromHttpConnection = GraphResponse.fromHttpConnection(httpURLConnection, graphRequestBatch);
        Utility.disconnectQuietly(httpURLConnection);
        int size = graphRequestBatch.size();
        if (size == fromHttpConnection.size()) {
            runCallbacks(graphRequestBatch, fromHttpConnection);
            AccessTokenManager.getInstance().extendAccessTokenIfNeeded();
            return fromHttpConnection;
        }
        throw new FacebookException(String.format(Locale.US, "Received %d responses while expecting %d", new Object[]{Integer.valueOf(fromHttpConnection.size()), Integer.valueOf(size)}));
    }

    public static GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return executeConnectionAsync(null, httpURLConnection, graphRequestBatch);
    }

    public static GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        Validate.notNull(httpURLConnection, "connection");
        GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
        graphRequestBatch.setCallbackHandler(handler);
        graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
        return graphRequestAsyncTask;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{Request: ");
        sb.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", graphPath: ");
        sb.append(this.graphPath);
        sb.append(", graphObject: ");
        sb.append(this.graphObject);
        sb.append(", httpMethod: ");
        sb.append(this.httpMethod);
        sb.append(", parameters: ");
        sb.append(this.parameters);
        sb.append("}");
        return sb.toString();
    }

    static void runCallbacks(final GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        int size = graphRequestBatch.size();
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            Callback callback2 = graphRequestBatch.get(i).callback;
            if (callback2 != null) {
                arrayList.add(new Pair(callback2, list.get(i)));
            }
        }
        if (arrayList.size() > 0) {
            AnonymousClass5 r7 = new Runnable() {
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        ((Callback) pair.first).onCompleted((GraphResponse) pair.second);
                    }
                    for (com.facebook.GraphRequestBatch.Callback onBatchCompleted : graphRequestBatch.getCallbacks()) {
                        onBatchCompleted.onBatchCompleted(graphRequestBatch);
                    }
                }
            };
            Handler callbackHandler = graphRequestBatch.getCallbackHandler();
            if (callbackHandler == null) {
                r7.run();
            } else {
                callbackHandler.post(r7);
            }
        }
    }

    private static HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());
        httpURLConnection.setChunkedStreamingMode(0);
        return httpURLConnection;
    }

    private void addCommonParameters() {
        String str = "access_token";
        if (this.accessToken != null) {
            if (!this.parameters.containsKey(str)) {
                String token = this.accessToken.getToken();
                Logger.registerAccessToken(token);
                this.parameters.putString(str, token);
            }
        } else if (!this.skipClientToken && !this.parameters.containsKey(str)) {
            String applicationId = FacebookSdk.getApplicationId();
            String clientToken = FacebookSdk.getClientToken();
            if (Utility.isNullOrEmpty(applicationId) || Utility.isNullOrEmpty(clientToken)) {
                Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(applicationId);
                sb.append("|");
                sb.append(clientToken);
                this.parameters.putString(str, sb.toString());
            }
        }
        this.parameters.putString("sdk", "android");
        this.parameters.putString("format", "json");
        String str2 = "debug";
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            this.parameters.putString(str2, "info");
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.parameters.putString(str2, "warning");
        }
    }

    private String appendParametersToBaseUrl(String str, Boolean bool) {
        if (!bool.booleanValue() && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (String str2 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str2);
            if (obj == null) {
                obj = "";
            }
            if (isSupportedParameterType(obj)) {
                buildUpon.appendQueryParameter(str2, parameterToString(obj).toString());
            } else if (this.httpMethod == HttpMethod.GET) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unsupported parameter type for GET request: %s", new Object[]{obj.getClass().getSimpleName()}));
            }
        }
        return buildUpon.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL == null) {
            String format = String.format("%s/%s", new Object[]{ServerProtocol.getGraphUrlBase(), getGraphPathWithVersion()});
            addCommonParameters();
            Uri parse = Uri.parse(appendParametersToBaseUrl(format, Boolean.valueOf(true)));
            return String.format("%s?%s", new Object[]{parse.getPath(), parse.getQuery()});
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    /* access modifiers changed from: 0000 */
    public final String getUrlForSingleRequest() {
        String str;
        String str2 = this.overriddenURL;
        if (str2 != null) {
            return str2.toString();
        }
        if (getHttpMethod() == HttpMethod.POST) {
            String str3 = this.graphPath;
            if (str3 != null && str3.endsWith("/videos")) {
                str = ServerProtocol.getGraphVideoUrlBase();
                String format = String.format("%s/%s", new Object[]{str, getGraphPathWithVersion()});
                addCommonParameters();
                return appendParametersToBaseUrl(format, Boolean.valueOf(false));
            }
        }
        str = ServerProtocol.getGraphUrlBase();
        String format2 = String.format("%s/%s", new Object[]{str, getGraphPathWithVersion()});
        addCommonParameters();
        return appendParametersToBaseUrl(format2, Boolean.valueOf(false));
    }

    private String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        return String.format("%s/%s", new Object[]{this.version, this.graphPath});
    }

    private void serializeToBatch(JSONArray jSONArray, Map<String, Attachment> map) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        String str = this.batchEntryName;
        if (str != null) {
            jSONObject.put("name", str);
            jSONObject.put("omit_response_on_success", this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            jSONObject.put("depends_on", str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        jSONObject.put("relative_url", relativeUrlForBatchedRequest);
        jSONObject.put("method", this.httpMethod);
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            Logger.registerAccessToken(accessToken2.getToken());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str3);
            if (isSupportedAttachmentType(obj)) {
                String format = String.format(Locale.ROOT, "%s%d", new Object[]{"file", Integer.valueOf(map.size())});
                arrayList.add(format);
                map.put(format, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            jSONObject.put("attached_files", TextUtils.join(",", arrayList));
        }
        if (this.graphObject != null) {
            final ArrayList arrayList2 = new ArrayList();
            processGraphObject(this.graphObject, relativeUrlForBatchedRequest, new KeyValueSerializer(this) {
                public void writeString(String str, String str2) throws IOException {
                    arrayList2.add(String.format(Locale.US, "%s=%s", new Object[]{str, URLEncoder.encode(str2, "UTF-8")}));
                }
            });
            jSONObject.put("body", TextUtils.join("&", arrayList2));
        }
        jSONArray.put(jSONObject);
    }

    private static boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
        for (com.facebook.GraphRequestBatch.Callback callback2 : graphRequestBatch.getCallbacks()) {
            if (callback2 instanceof com.facebook.GraphRequestBatch.OnProgressCallback) {
                return true;
            }
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            if (((GraphRequest) it.next()).getCallback() instanceof OnProgressCallback) {
                return true;
            }
        }
        return false;
    }

    private static void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z) {
        String str = HttpRequest.HEADER_CONTENT_TYPE;
        if (z) {
            httpURLConnection.setRequestProperty(str, HttpRequest.CONTENT_TYPE_FORM);
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
            return;
        }
        httpURLConnection.setRequestProperty(str, getMimeContentType());
    }

    private static boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            Iterator it2 = graphRequest.parameters.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (isSupportedAttachmentType(graphRequest.parameters.get((String) it2.next()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static final boolean shouldWarnOnMissingFieldsParam(GraphRequest graphRequest) {
        String version2 = graphRequest.getVersion();
        boolean z = true;
        if (Utility.isNullOrEmpty(version2)) {
            return true;
        }
        if (version2.startsWith("v")) {
            version2 = version2.substring(1);
        }
        String[] split = version2.split("\\.");
        if ((split.length < 2 || Integer.parseInt(split[0]) <= 2) && (Integer.parseInt(split[0]) < 2 || Integer.parseInt(split[1]) < 4)) {
            z = false;
        }
        return z;
    }

    static final void validateFieldsParamForGetRequests(GraphRequestBatch graphRequestBatch) {
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            GraphRequest graphRequest = (GraphRequest) it.next();
            if (HttpMethod.GET.equals(graphRequest.getHttpMethod()) && shouldWarnOnMissingFieldsParam(graphRequest)) {
                Bundle parameters2 = graphRequest.getParameters();
                String str = FIELDS_PARAM;
                if (!parameters2.containsKey(str) || Utility.isNullOrEmpty(parameters2.getString(str))) {
                    Logger.log(LoggingBehavior.DEVELOPER_ERRORS, 5, "Request", "starting with Graph API v2.4, GET requests for /%s should contain an explicit \"fields\" parameter.", graphRequest.getGraphPath());
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r14v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r14v5, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r8v5, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r14v8 */
    /* JADX WARNING: type inference failed for: r14v9, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARNING: type inference failed for: r14v10 */
    /* JADX WARNING: type inference failed for: r14v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ca  */
    /* JADX WARNING: Unknown variable types count: 6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final void serializeToUrlConnection(com.facebook.GraphRequestBatch r13, java.net.HttpURLConnection r14) throws java.io.IOException, org.json.JSONException {
        /*
            com.facebook.internal.Logger r6 = new com.facebook.internal.Logger
            com.facebook.LoggingBehavior r0 = com.facebook.LoggingBehavior.REQUESTS
            java.lang.String r1 = "Request"
            r6.<init>(r0, r1)
            int r2 = r13.size()
            boolean r5 = isGzipCompressible(r13)
            r0 = 0
            r1 = 1
            if (r2 != r1) goto L_0x001c
            com.facebook.GraphRequest r3 = r13.get(r0)
            com.facebook.HttpMethod r3 = r3.httpMethod
            goto L_0x001e
        L_0x001c:
            com.facebook.HttpMethod r3 = com.facebook.HttpMethod.POST
        L_0x001e:
            java.lang.String r4 = r3.name()
            r14.setRequestMethod(r4)
            setConnectionContentType(r14, r5)
            java.net.URL r4 = r14.getURL()
            java.lang.String r7 = "Request:\n"
            r6.append(r7)
            java.lang.String r7 = r13.getId()
            java.lang.String r8 = "Id"
            r6.appendKeyValue(r8, r7)
            java.lang.String r7 = "URL"
            r6.appendKeyValue(r7, r4)
            java.lang.String r7 = r14.getRequestMethod()
            java.lang.String r8 = "Method"
            r6.appendKeyValue(r8, r7)
            java.lang.String r7 = "User-Agent"
            java.lang.String r8 = r14.getRequestProperty(r7)
            r6.appendKeyValue(r7, r8)
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = r14.getRequestProperty(r7)
            r6.appendKeyValue(r7, r8)
            int r7 = r13.getTimeout()
            r14.setConnectTimeout(r7)
            int r7 = r13.getTimeout()
            r14.setReadTimeout(r7)
            com.facebook.HttpMethod r7 = com.facebook.HttpMethod.POST
            if (r3 != r7) goto L_0x006d
            r0 = 1
        L_0x006d:
            if (r0 != 0) goto L_0x0073
            r6.log()
            return
        L_0x0073:
            r14.setDoOutput(r1)
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00c6 }
            java.io.OutputStream r14 = r14.getOutputStream()     // Catch:{ all -> 0x00c6 }
            r1.<init>(r14)     // Catch:{ all -> 0x00c6 }
            if (r5 == 0) goto L_0x008b
            java.util.zip.GZIPOutputStream r14 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0088 }
            r14.<init>(r1)     // Catch:{ all -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r13 = move-exception
            r14 = r1
            goto L_0x00c8
        L_0x008b:
            r14 = r1
        L_0x008c:
            boolean r0 = hasOnProgressCallbacks(r13)     // Catch:{ all -> 0x00c4 }
            if (r0 == 0) goto L_0x00b6
            com.facebook.ProgressNoopOutputStream r0 = new com.facebook.ProgressNoopOutputStream     // Catch:{ all -> 0x00c4 }
            android.os.Handler r1 = r13.getCallbackHandler()     // Catch:{ all -> 0x00c4 }
            r0.<init>(r1)     // Catch:{ all -> 0x00c4 }
            r8 = 0
            r7 = r13
            r9 = r2
            r10 = r4
            r11 = r0
            r12 = r5
            processRequest(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00c4 }
            int r1 = r0.getMaxProgress()     // Catch:{ all -> 0x00c4 }
            java.util.Map r10 = r0.getProgressMap()     // Catch:{ all -> 0x00c4 }
            com.facebook.ProgressOutputStream r0 = new com.facebook.ProgressOutputStream     // Catch:{ all -> 0x00c4 }
            long r11 = (long) r1     // Catch:{ all -> 0x00c4 }
            r7 = r0
            r8 = r14
            r9 = r13
            r7.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x00c4 }
            r14 = r0
        L_0x00b6:
            r0 = r13
            r1 = r6
            r3 = r4
            r4 = r14
            processRequest(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00c4 }
            r14.close()
            r6.log()
            return
        L_0x00c4:
            r13 = move-exception
            goto L_0x00c8
        L_0x00c6:
            r13 = move-exception
            r14 = r0
        L_0x00c8:
            if (r14 == 0) goto L_0x00cd
            r14.close()
        L_0x00cd:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.serializeToUrlConnection(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
    }

    private static void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i, URL url, OutputStream outputStream, boolean z) throws IOException, JSONException {
        Serializer serializer = new Serializer(outputStream, logger, z);
        String str = "  Attachments:\n";
        if (i == 1) {
            GraphRequest graphRequest = graphRequestBatch.get(0);
            HashMap hashMap = new HashMap();
            for (String str2 : graphRequest.parameters.keySet()) {
                Object obj = graphRequest.parameters.get(str2);
                if (isSupportedAttachmentType(obj)) {
                    hashMap.put(str2, new Attachment(graphRequest, obj));
                }
            }
            if (logger != null) {
                logger.append("  Parameters:\n");
            }
            serializeParameters(graphRequest.parameters, serializer, graphRequest);
            if (logger != null) {
                logger.append(str);
            }
            serializeAttachments(hashMap, serializer);
            JSONObject jSONObject = graphRequest.graphObject;
            if (jSONObject != null) {
                processGraphObject(jSONObject, url.getPath(), serializer);
                return;
            }
            return;
        }
        String batchAppId = getBatchAppId(graphRequestBatch);
        if (!Utility.isNullOrEmpty(batchAppId)) {
            serializer.writeString("batch_app_id", batchAppId);
            HashMap hashMap2 = new HashMap();
            serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
            if (logger != null) {
                logger.append(str);
            }
            serializeAttachments(hashMap2, serializer);
            return;
        }
        throw new FacebookException("App ID was not specified at the request or Settings.");
    }

    private static boolean isMeRequest(String str) {
        Matcher matcher = versionPattern.matcher(str);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str.startsWith("me/") || str.startsWith("/me/")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void processGraphObject(org.json.JSONObject r6, java.lang.String r7, com.facebook.GraphRequest.KeyValueSerializer r8) throws java.io.IOException {
        /*
            boolean r0 = isMeRequest(r7)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = ":"
            int r0 = r7.indexOf(r0)
            java.lang.String r3 = "?"
            int r7 = r7.indexOf(r3)
            r3 = 3
            if (r0 <= r3) goto L_0x001e
            r3 = -1
            if (r7 == r3) goto L_0x001c
            if (r0 >= r7) goto L_0x001e
        L_0x001c:
            r7 = 1
            goto L_0x001f
        L_0x001e:
            r7 = 0
        L_0x001f:
            java.util.Iterator r0 = r6.keys()
        L_0x0023:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0044
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r6.opt(r3)
            if (r7 == 0) goto L_0x003f
            java.lang.String r5 = "image"
            boolean r5 = r3.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x003f
            r5 = 1
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            processGraphObjectProperty(r3, r4, r8, r5)
            goto L_0x0023
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.processGraphObject(org.json.JSONObject, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
    }

    private static void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z) throws IOException {
        Class cls = obj.getClass();
        if (JSONObject.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = (JSONObject) obj;
            if (z) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    processGraphObjectProperty(String.format("%s[%s]", new Object[]{str, str2}), jSONObject.opt(str2), keyValueSerializer, z);
                }
                return;
            }
            String str3 = "id";
            if (jSONObject.has(str3)) {
                processGraphObjectProperty(str, jSONObject.optString(str3), keyValueSerializer, z);
                return;
            }
            String str4 = "url";
            if (jSONObject.has(str4)) {
                processGraphObjectProperty(str, jSONObject.optString(str4), keyValueSerializer, z);
            } else if (jSONObject.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                processGraphObjectProperty(str, jSONObject.toString(), keyValueSerializer, z);
            }
        } else if (JSONArray.class.isAssignableFrom(cls)) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                processGraphObjectProperty(String.format(Locale.ROOT, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), jSONArray.opt(i), keyValueSerializer, z);
            }
        } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, obj.toString());
        } else if (Date.class.isAssignableFrom(cls)) {
            keyValueSerializer.writeString(str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format((Date) obj));
        }
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) throws IOException {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isSupportedParameterType(obj)) {
                serializer.writeObject(str, obj, graphRequest);
            }
        }
    }

    private static void serializeAttachments(Map<String, Attachment> map, Serializer serializer) throws IOException {
        for (String str : map.keySet()) {
            Attachment attachment = (Attachment) map.get(str);
            if (isSupportedAttachmentType(attachment.getValue())) {
                serializer.writeObject(str, attachment.getValue(), attachment.getRequest());
            }
        }
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) throws JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        for (GraphRequest serializeToBatch : collection) {
            serializeToBatch.serializeToBatch(jSONArray, map);
        }
        serializer.writeRequestsAsJson("batch", jSONArray, collection);
    }

    private static String getMimeContentType() {
        return String.format("multipart/form-data; boundary=%s", new Object[]{MIME_BOUNDARY});
    }

    private static String getUserAgent() {
        if (userAgent == null) {
            userAgent = String.format("%s.%s", new Object[]{"FBAndroidSDK", "4.41.0"});
            String customUserAgent = InternalSettings.getCustomUserAgent();
            if (!Utility.isNullOrEmpty(customUserAgent)) {
                userAgent = String.format(Locale.ROOT, "%s/%s", new Object[]{userAgent, customUserAgent});
            }
        }
        return userAgent;
    }

    private static String getBatchAppId(GraphRequestBatch graphRequestBatch) {
        if (!Utility.isNullOrEmpty(graphRequestBatch.getBatchApplicationId())) {
            return graphRequestBatch.getBatchApplicationId();
        }
        Iterator it = graphRequestBatch.iterator();
        while (it.hasNext()) {
            AccessToken accessToken2 = ((GraphRequest) it.next()).accessToken;
            if (accessToken2 != null) {
                String applicationId = accessToken2.getApplicationId();
                if (applicationId != null) {
                    return applicationId;
                }
            }
        }
        if (!Utility.isNullOrEmpty(defaultBatchApplicationId)) {
            return defaultBatchApplicationId;
        }
        return FacebookSdk.getApplicationId();
    }

    private static boolean isSupportedAttachmentType(Object obj) {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType);
    }

    /* access modifiers changed from: private */
    public static boolean isSupportedParameterType(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    /* access modifiers changed from: private */
    public static String parameterToString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number)) {
            return obj.toString();
        }
        if (obj instanceof Date) {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(obj);
        }
        throw new IllegalArgumentException("Unsupported parameter type.");
    }
}
