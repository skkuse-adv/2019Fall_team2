package com.kakao.network;

import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ApiResponseStatusError;
import com.kakao.network.response.CustomErrorConverter;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseData;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.tasks.ITaskQueue;
import com.kakao.network.tasks.KakaoResultTask;
import com.kakao.util.helper.log.Logger;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;

class DefaultNetworkService implements NetworkService {
    private ITaskQueue taskQueue;

    DefaultNetworkService(ITaskQueue iTaskQueue) {
        this.taskQueue = iTaskQueue;
    }

    public <T> Future<T> request(final IRequest iRequest, final ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<T>(responseCallback) {
            public T call() throws Exception {
                return DefaultNetworkService.this.request(iRequest, responseStringConverter);
            }
        });
    }

    public <T, E extends Exception> Future<T> request(IRequest iRequest, ResponseStringConverter<T> responseStringConverter, CustomErrorConverter<E> customErrorConverter, ResponseCallback<T> responseCallback) {
        ITaskQueue iTaskQueue = this.taskQueue;
        final IRequest iRequest2 = iRequest;
        final ResponseStringConverter<T> responseStringConverter2 = responseStringConverter;
        final CustomErrorConverter<E> customErrorConverter2 = customErrorConverter;
        AnonymousClass2 r1 = new KakaoResultTask<T>(responseCallback) {
            public T call() throws Exception {
                return DefaultNetworkService.this.request(iRequest2, responseStringConverter2, customErrorConverter2);
            }
        };
        return iTaskQueue.addTask(r1);
    }

    public <T> T request(IRequest iRequest, ResponseStringConverter<T> responseStringConverter) throws IOException, ResponseBodyException, ApiResponseStatusError {
        ResponseData request = new NetworkTask().request(iRequest);
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(request.getStringData());
        Logger.d(sb.toString());
        if (request.getHttpStatusCode() == 200) {
            return responseStringConverter.convert(request.getStringData());
        }
        ResponseBody responseBody = new ResponseBody(request.getStringData());
        throw new ApiResponseStatusError(responseBody.getInt("code"), responseBody.optString("msg", str), request.getHttpStatusCode(), responseBody);
    }

    public <T, E extends Exception> T request(IRequest iRequest, ResponseStringConverter<T> responseStringConverter, CustomErrorConverter<E> customErrorConverter) throws IOException, Exception, ResponseBodyException {
        ResponseData request = new NetworkTask().request(iRequest);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(request.getStringData());
        Logger.d(sb.toString());
        if (request.getHttpStatusCode() == 200) {
            return responseStringConverter.convert(request.getStringData());
        }
        throw ((Exception) customErrorConverter.convert(request.getHttpStatusCode(), request.getStringData()));
    }

    public <T> Future<List<T>> requestList(final IRequest iRequest, final ResponseStringConverter<T> responseStringConverter, ResponseCallback<List<T>> responseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<List<T>>(responseCallback) {
            public List<T> call() throws Exception {
                return DefaultNetworkService.this.requestList(iRequest, responseStringConverter);
            }
        });
    }

    public <T> List<T> requestList(IRequest iRequest, ResponseStringConverter<T> responseStringConverter) throws IOException {
        ResponseData request = new NetworkTask().request(iRequest);
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(request.getStringData());
        Logger.d(sb.toString());
        if (request.getHttpStatusCode() == 200 || request.getHttpStatusCode() == 200) {
            return responseStringConverter.convertList(request.getStringData());
        }
        ResponseBody responseBody = new ResponseBody(request.getStringData());
        throw new ApiResponseStatusError(responseBody.getInt("code"), responseBody.optString("msg", str), request.getHttpStatusCode(), responseBody);
    }
}
