package com.bumptech.glide.integration.okhttp3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataFetcher.DataCallback;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.Preconditions;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpStreamFetcher implements DataFetcher<InputStream>, Callback {
    private static final String TAG = "OkHttpFetcher";
    private volatile Call call;
    private DataCallback<? super InputStream> callback;
    private final Factory client;
    private ResponseBody responseBody;
    private InputStream stream;
    private final GlideUrl url;

    public OkHttpStreamFetcher(Factory factory, GlideUrl glideUrl) {
        this.client = factory;
        this.url = glideUrl;
    }

    public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super InputStream> dataCallback) {
        Builder url2 = new Builder().url(this.url.toStringUrl());
        for (Entry entry : this.url.getHeaders().entrySet()) {
            url2.addHeader((String) entry.getKey(), (String) entry.getValue());
        }
        Request build = url2.build();
        this.callback = dataCallback;
        this.call = this.client.newCall(build);
        FirebasePerfOkHttpClient.enqueue(this.call, this);
    }

    public void onFailure(@NonNull Call call2, @NonNull IOException iOException) {
        boolean isLoggable = Log.isLoggable(TAG, 3);
        this.callback.onLoadFailed(iOException);
    }

    public void onResponse(@NonNull Call call2, @NonNull Response response) {
        this.responseBody = response.body();
        if (response.isSuccessful()) {
            this.stream = ContentLengthInputStream.obtain(this.responseBody.byteStream(), ((ResponseBody) Preconditions.checkNotNull(this.responseBody)).contentLength());
            this.callback.onDataReady(this.stream);
            return;
        }
        this.callback.onLoadFailed(new HttpException(response.message(), response.code()));
    }

    public void cleanup() {
        try {
            if (this.stream != null) {
                this.stream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody2 = this.responseBody;
        if (responseBody2 != null) {
            responseBody2.close();
        }
        this.callback = null;
    }

    public void cancel() {
        Call call2 = this.call;
        if (call2 != null) {
            call2.cancel();
        }
    }

    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
