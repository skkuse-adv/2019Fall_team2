package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;

public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<GraphResponse>> {
    private static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    public GraphRequestAsyncTask(GraphRequest... graphRequestArr) {
        this((HttpURLConnection) null, new GraphRequestBatch(graphRequestArr));
    }

    public GraphRequestAsyncTask(Collection<GraphRequest> collection) {
        this((HttpURLConnection) null, new GraphRequestBatch(collection));
    }

    public GraphRequestAsyncTask(GraphRequestBatch graphRequestBatch) {
        this((HttpURLConnection) null, graphRequestBatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... graphRequestArr) {
        this(httpURLConnection, new GraphRequestBatch(graphRequestArr));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        this(httpURLConnection, new GraphRequestBatch(collection));
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        this.requests = graphRequestBatch;
        this.connection = httpURLConnection;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{RequestAsyncTask: ");
        sb.append(" connection: ");
        sb.append(this.connection);
        sb.append(", requests: ");
        sb.append(this.requests);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        if (FacebookSdk.isDebugEnabled()) {
            Utility.logd(TAG, String.format("execute async task: %s", new Object[]{this}));
        }
        if (this.requests.getCallbackHandler() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.requests.setCallbackHandler(handler);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<GraphResponse> list) {
        super.onPostExecute(list);
        Exception exc = this.exception;
        if (exc != null) {
            Utility.logd(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[]{exc.getMessage()}));
        }
    }

    /* access modifiers changed from: protected */
    public List<GraphResponse> doInBackground(Void... voidArr) {
        try {
            if (this.connection == null) {
                return this.requests.executeAndWait();
            }
            return GraphRequest.executeConnectionAndWait(this.connection, this.requests);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
    }
}
