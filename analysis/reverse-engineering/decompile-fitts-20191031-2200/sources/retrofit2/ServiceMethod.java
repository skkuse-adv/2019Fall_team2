package retrofit2;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

final class ServiceMethod<R, T> {
    static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
    static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
    static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private final HttpUrl baseUrl;
    private final CallAdapter<R, T> callAdapter;
    private final Factory callFactory;
    private final MediaType contentType;
    private final boolean hasBody;
    private final Headers headers;
    private final String httpMethod;
    private final boolean isFormEncoded;
    private final boolean isMultipart;
    private final ParameterHandler<?>[] parameterHandlers;
    private final String relativeUrl;
    private final Converter<ResponseBody, R> responseConverter;

    static final class Builder<T, R> {
        CallAdapter<T, R> callAdapter;
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotUrl;
        boolean hasBody;
        Headers headers;
        String httpMethod;
        boolean isFormEncoded;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        String relativeUrl;
        Set<String> relativeUrlParamNames;
        Converter<ResponseBody, T> responseConverter;
        Type responseType;
        final Retrofit retrofit;

        Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        public ServiceMethod build() {
            this.callAdapter = createCallAdapter();
            this.responseType = this.callAdapter.responseType();
            Type type = this.responseType;
            if (type == Response.class || type == Response.class) {
                StringBuilder sb = new StringBuilder();
                sb.append("'");
                sb.append(Utils.getRawType(this.responseType).getName());
                sb.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw methodError(sb.toString(), new Object[0]);
            }
            this.responseConverter = createResponseConverter();
            for (Annotation parseMethodAnnotation : this.methodAnnotations) {
                parseMethodAnnotation(parseMethodAnnotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                int i = 0;
                while (i < length) {
                    Type type2 = this.parameterTypes[i];
                    if (!Utils.hasUnresolvableType(type2)) {
                        Annotation[] annotationArr = this.parameterAnnotationsArray[i];
                        if (annotationArr != null) {
                            this.parameterHandlers[i] = parseParameter(i, type2, annotationArr);
                            i++;
                        } else {
                            throw parameterError(i, "No Retrofit annotation found.", new Object[0]);
                        }
                    } else {
                        throw parameterError(i, "Parameter type must not include a type variable or wildcard: %s", type2);
                    }
                }
                if (this.relativeUrl == null && !this.gotUrl) {
                    throw methodError("Missing either @%s URL or @Url parameter.", this.httpMethod);
                } else if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw methodError("Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.isFormEncoded && !this.gotField) {
                    throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.isMultipart || this.gotPart) {
                    return new ServiceMethod(this);
                } else {
                    throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private CallAdapter<T, R> createCallAdapter() {
            Type genericReturnType = this.method.getGenericReturnType();
            if (Utils.hasUnresolvableType(genericReturnType)) {
                throw methodError("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            } else if (genericReturnType != Void.TYPE) {
                try {
                    return this.retrofit.callAdapter(genericReturnType, this.method.getAnnotations());
                } catch (RuntimeException e) {
                    throw methodError(e, "Unable to create call adapter for %s", genericReturnType);
                }
            } else {
                throw methodError("Service methods cannot return void.", new Object[0]);
            }
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath(HttpRequest.METHOD_DELETE, ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath(HttpRequest.METHOD_GET, ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath(HttpRequest.METHOD_HEAD, ((HEAD) annotation).value(), false);
                if (!Void.class.equals(this.responseType)) {
                    throw methodError("HEAD method must use Void as response type.", new Object[0]);
                }
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath(HttpRequest.METHOD_POST, ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath(HttpRequest.METHOD_PUT, ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath(HttpRequest.METHOD_OPTIONS, ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length != 0) {
                    this.headers = parseHeaders(value);
                } else {
                    throw methodError("@Headers annotation is empty.", new Object[0]);
                }
            } else {
                String str = "Only one encoding annotation is allowed.";
                if (annotation instanceof Multipart) {
                    if (!this.isFormEncoded) {
                        this.isMultipart = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                } else if (!(annotation instanceof FormUrlEncoded)) {
                } else {
                    if (!this.isMultipart) {
                        this.isFormEncoded = true;
                        return;
                    }
                    throw methodError(str, new Object[0]);
                }
            }
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z) {
            String str3 = this.httpMethod;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (ServiceMethod.PARAM_URL_REGEX.matcher(substring).find()) {
                            throw methodError("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.relativeUrl = str2;
                    this.relativeUrlParamNames = ServiceMethod.parsePathParameters(str2);
                    return;
                }
                return;
            }
            throw methodError("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private Headers parseHeaders(String[] strArr) {
            okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpRequest.HEADER_CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    MediaType parse = MediaType.parse(trim);
                    if (parse != null) {
                        this.contentType = parse;
                    } else {
                        throw methodError("Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        private ParameterHandler<?> parseParameter(int i, Type type, Annotation[] annotationArr) {
            ParameterHandler<?> parameterHandler = null;
            for (Annotation parseParameterAnnotation : annotationArr) {
                ParameterHandler<?> parseParameterAnnotation2 = parseParameterAnnotation(i, type, annotationArr, parseParameterAnnotation);
                if (parseParameterAnnotation2 != null) {
                    if (parameterHandler == null) {
                        parameterHandler = parseParameterAnnotation2;
                    } else {
                        throw parameterError(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                }
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            throw parameterError(i, "No Retrofit annotation found.", new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
            if ("android.net.Uri".equals(((java.lang.Class) r12).getName()) != false) goto L_0x0044;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private retrofit2.ParameterHandler<?> parseParameterAnnotation(int r11, java.lang.reflect.Type r12, java.lang.annotation.Annotation[] r13, java.lang.annotation.Annotation r14) {
            /*
                r10 = this;
                java.lang.Class<okhttp3.MultipartBody$Part> r0 = okhttp3.MultipartBody.Part.class
                boolean r1 = r14 instanceof retrofit2.http.Url
                java.lang.String r2 = "@Path parameters may not be used with @Url."
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0070
                boolean r13 = r10.gotUrl
                if (r13 != 0) goto L_0x0067
                boolean r13 = r10.gotPath
                if (r13 != 0) goto L_0x0060
                boolean r13 = r10.gotQuery
                if (r13 != 0) goto L_0x0057
                java.lang.String r13 = r10.relativeUrl
                if (r13 != 0) goto L_0x004a
                r10.gotUrl = r3
                java.lang.Class<okhttp3.HttpUrl> r13 = okhttp3.HttpUrl.class
                if (r12 == r13) goto L_0x0044
                java.lang.Class<java.lang.String> r13 = java.lang.String.class
                if (r12 == r13) goto L_0x0044
                java.lang.Class<java.net.URI> r13 = java.net.URI.class
                if (r12 == r13) goto L_0x0044
                boolean r13 = r12 instanceof java.lang.Class
                if (r13 == 0) goto L_0x003b
                java.lang.Class r12 = (java.lang.Class) r12
                java.lang.String r12 = r12.getName()
                java.lang.String r13 = "android.net.Uri"
                boolean r12 = r13.equals(r12)
                if (r12 == 0) goto L_0x003b
                goto L_0x0044
            L_0x003b:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0044:
                retrofit2.ParameterHandler$RelativeUrl r11 = new retrofit2.ParameterHandler$RelativeUrl
                r11.<init>()
                return r11
            L_0x004a:
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = r10.httpMethod
                r12[r4] = r13
                java.lang.String r13 = "@Url cannot be used with @%s URL"
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0057:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "A @Url parameter must not come after a @Query"
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0060:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r2, r12)
                throw r11
            L_0x0067:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "Multiple @Url method annotations found."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0070:
                boolean r1 = r14 instanceof retrofit2.http.Path
                if (r1 == 0) goto L_0x00b8
                boolean r0 = r10.gotQuery
                if (r0 != 0) goto L_0x00af
                boolean r0 = r10.gotUrl
                if (r0 != 0) goto L_0x00a8
                java.lang.String r0 = r10.relativeUrl
                if (r0 == 0) goto L_0x009b
                r10.gotPath = r3
                retrofit2.http.Path r14 = (retrofit2.http.Path) r14
                java.lang.String r0 = r14.value()
                r10.validatePathName(r11, r0)
                retrofit2.Retrofit r11 = r10.retrofit
                retrofit2.Converter r11 = r11.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Path r12 = new retrofit2.ParameterHandler$Path
                boolean r13 = r14.encoded()
                r12.<init>(r0, r11, r13)
                return r12
            L_0x009b:
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = r10.httpMethod
                r12[r4] = r13
                java.lang.String r13 = "@Path can only be used with relative url on @%s"
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x00a8:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r2, r12)
                throw r11
            L_0x00af:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "A @Path parameter must not come after a @Query."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x00b8:
                boolean r1 = r14 instanceof retrofit2.http.Query
                java.lang.String r2 = "<String>)"
                java.lang.String r5 = " must include generic type (e.g., "
                if (r1 == 0) goto L_0x0140
                retrofit2.http.Query r14 = (retrofit2.http.Query) r14
                java.lang.String r0 = r14.value()
                boolean r14 = r14.encoded()
                java.lang.Class r1 = retrofit2.Utils.getRawType(r12)
                r10.gotQuery = r3
                java.lang.Class<java.lang.Iterable> r3 = java.lang.Iterable.class
                boolean r3 = r3.isAssignableFrom(r1)
                if (r3 == 0) goto L_0x0116
                boolean r3 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r3 == 0) goto L_0x00f2
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Query r12 = new retrofit2.ParameterHandler$Query
                r12.<init>(r0, r11, r14)
                retrofit2.ParameterHandler r11 = r12.iterable()
                return r11
            L_0x00f2:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r1.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r1.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x0116:
                boolean r11 = r1.isArray()
                if (r11 == 0) goto L_0x0134
                java.lang.Class r11 = r1.getComponentType()
                java.lang.Class r11 = retrofit2.ServiceMethod.boxIfPrimitive(r11)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Query r12 = new retrofit2.ParameterHandler$Query
                r12.<init>(r0, r11, r14)
                retrofit2.ParameterHandler r11 = r12.array()
                return r11
            L_0x0134:
                retrofit2.Retrofit r11 = r10.retrofit
                retrofit2.Converter r11 = r11.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Query r12 = new retrofit2.ParameterHandler$Query
                r12.<init>(r0, r11, r14)
                return r12
            L_0x0140:
                boolean r1 = r14 instanceof retrofit2.http.QueryName
                if (r1 == 0) goto L_0x01c0
                retrofit2.http.QueryName r14 = (retrofit2.http.QueryName) r14
                boolean r14 = r14.encoded()
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                r10.gotQuery = r3
                java.lang.Class<java.lang.Iterable> r1 = java.lang.Iterable.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0196
                boolean r1 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r1 == 0) goto L_0x0172
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$QueryName r12 = new retrofit2.ParameterHandler$QueryName
                r12.<init>(r11, r14)
                retrofit2.ParameterHandler r11 = r12.iterable()
                return r11
            L_0x0172:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x0196:
                boolean r11 = r0.isArray()
                if (r11 == 0) goto L_0x01b4
                java.lang.Class r11 = r0.getComponentType()
                java.lang.Class r11 = retrofit2.ServiceMethod.boxIfPrimitive(r11)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$QueryName r12 = new retrofit2.ParameterHandler$QueryName
                r12.<init>(r11, r14)
                retrofit2.ParameterHandler r11 = r12.array()
                return r11
            L_0x01b4:
                retrofit2.Retrofit r11 = r10.retrofit
                retrofit2.Converter r11 = r11.stringConverter(r12, r13)
                retrofit2.ParameterHandler$QueryName r12 = new retrofit2.ParameterHandler$QueryName
                r12.<init>(r11, r14)
                return r12
            L_0x01c0:
                boolean r1 = r14 instanceof retrofit2.http.QueryMap
                java.lang.String r6 = "Map must include generic types (e.g., Map<String, String>)"
                if (r1 == 0) goto L_0x0224
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x021b
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r12 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r0 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x0214
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r0 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class<java.lang.String> r1 = java.lang.String.class
                if (r1 != r0) goto L_0x01fc
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r3, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$QueryMap r12 = new retrofit2.ParameterHandler$QueryMap
                retrofit2.http.QueryMap r14 = (retrofit2.http.QueryMap) r14
                boolean r13 = r14.encoded()
                r12.<init>(r11, r13)
                return r12
            L_0x01fc:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@QueryMap keys must be of type String: "
                r12.append(r13)
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x0214:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r6, r12)
                throw r11
            L_0x021b:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@QueryMap parameter type must be Map."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0224:
                boolean r1 = r14 instanceof retrofit2.http.Header
                if (r1 == 0) goto L_0x02a2
                retrofit2.http.Header r14 = (retrofit2.http.Header) r14
                java.lang.String r14 = r14.value()
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.lang.Iterable> r1 = java.lang.Iterable.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0278
                boolean r1 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r1 == 0) goto L_0x0254
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Header r12 = new retrofit2.ParameterHandler$Header
                r12.<init>(r14, r11)
                retrofit2.ParameterHandler r11 = r12.iterable()
                return r11
            L_0x0254:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x0278:
                boolean r11 = r0.isArray()
                if (r11 == 0) goto L_0x0296
                java.lang.Class r11 = r0.getComponentType()
                java.lang.Class r11 = retrofit2.ServiceMethod.boxIfPrimitive(r11)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Header r12 = new retrofit2.ParameterHandler$Header
                r12.<init>(r14, r11)
                retrofit2.ParameterHandler r11 = r12.array()
                return r11
            L_0x0296:
                retrofit2.Retrofit r11 = r10.retrofit
                retrofit2.Converter r11 = r11.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Header r12 = new retrofit2.ParameterHandler$Header
                r12.<init>(r14, r11)
                return r12
            L_0x02a2:
                boolean r1 = r14 instanceof retrofit2.http.HeaderMap
                if (r1 == 0) goto L_0x02fe
                java.lang.Class r14 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                boolean r0 = r0.isAssignableFrom(r14)
                if (r0 == 0) goto L_0x02f5
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                java.lang.reflect.Type r12 = retrofit2.Utils.getSupertype(r12, r14, r0)
                boolean r14 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r14 == 0) goto L_0x02ee
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r14 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                if (r0 != r14) goto L_0x02d6
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r3, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$HeaderMap r12 = new retrofit2.ParameterHandler$HeaderMap
                r12.<init>(r11)
                return r12
            L_0x02d6:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@HeaderMap keys must be of type String: "
                r12.append(r13)
                r12.append(r14)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x02ee:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r6, r12)
                throw r11
            L_0x02f5:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@HeaderMap parameter type must be Map."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x02fe:
                boolean r1 = r14 instanceof retrofit2.http.Field
                if (r1 == 0) goto L_0x038f
                boolean r0 = r10.isFormEncoded
                if (r0 == 0) goto L_0x0386
                retrofit2.http.Field r14 = (retrofit2.http.Field) r14
                java.lang.String r0 = r14.value()
                boolean r14 = r14.encoded()
                r10.gotField = r3
                java.lang.Class r1 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.lang.Iterable> r3 = java.lang.Iterable.class
                boolean r3 = r3.isAssignableFrom(r1)
                if (r3 == 0) goto L_0x035c
                boolean r3 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r3 == 0) goto L_0x0338
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Field r12 = new retrofit2.ParameterHandler$Field
                r12.<init>(r0, r11, r14)
                retrofit2.ParameterHandler r11 = r12.iterable()
                return r11
            L_0x0338:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r1.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r1.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x035c:
                boolean r11 = r1.isArray()
                if (r11 == 0) goto L_0x037a
                java.lang.Class r11 = r1.getComponentType()
                java.lang.Class r11 = retrofit2.ServiceMethod.boxIfPrimitive(r11)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                retrofit2.ParameterHandler$Field r12 = new retrofit2.ParameterHandler$Field
                r12.<init>(r0, r11, r14)
                retrofit2.ParameterHandler r11 = r12.array()
                return r11
            L_0x037a:
                retrofit2.Retrofit r11 = r10.retrofit
                retrofit2.Converter r11 = r11.stringConverter(r12, r13)
                retrofit2.ParameterHandler$Field r12 = new retrofit2.ParameterHandler$Field
                r12.<init>(r0, r11, r14)
                return r12
            L_0x0386:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@Field parameters can only be used with form encoding."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x038f:
                boolean r1 = r14 instanceof retrofit2.http.FieldMap
                if (r1 == 0) goto L_0x0400
                boolean r0 = r10.isFormEncoded
                if (r0 == 0) goto L_0x03f7
                java.lang.Class r0 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x03ee
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r12 = retrofit2.Utils.getSupertype(r12, r0, r1)
                boolean r0 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x03e7
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r0 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class<java.lang.String> r1 = java.lang.String.class
                if (r1 != r0) goto L_0x03cf
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r3, r12)
                retrofit2.Retrofit r12 = r10.retrofit
                retrofit2.Converter r11 = r12.stringConverter(r11, r13)
                r10.gotField = r3
                retrofit2.ParameterHandler$FieldMap r12 = new retrofit2.ParameterHandler$FieldMap
                retrofit2.http.FieldMap r14 = (retrofit2.http.FieldMap) r14
                boolean r13 = r14.encoded()
                r12.<init>(r11, r13)
                return r12
            L_0x03cf:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@FieldMap keys must be of type String: "
                r12.append(r13)
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x03e7:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r6, r12)
                throw r11
            L_0x03ee:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@FieldMap parameter type must be Map."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x03f7:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@FieldMap parameters can only be used with form encoding."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0400:
                boolean r1 = r14 instanceof retrofit2.http.Part
                if (r1 == 0) goto L_0x0573
                boolean r1 = r10.isMultipart
                if (r1 == 0) goto L_0x056a
                retrofit2.http.Part r14 = (retrofit2.http.Part) r14
                r10.gotPart = r3
                java.lang.String r1 = r14.value()
                java.lang.Class r6 = retrofit2.Utils.getRawType(r12)
                boolean r7 = r1.isEmpty()
                if (r7 == 0) goto L_0x0498
                java.lang.Class<java.lang.Iterable> r13 = java.lang.Iterable.class
                boolean r13 = r13.isAssignableFrom(r6)
                java.lang.String r14 = "@Part annotation must supply a name or use MultipartBody.Part parameter type."
                if (r13 == 0) goto L_0x046a
                boolean r13 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r13 == 0) goto L_0x0446
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r12 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class r12 = retrofit2.Utils.getRawType(r12)
                boolean r12 = r0.isAssignableFrom(r12)
                if (r12 == 0) goto L_0x043f
                retrofit2.ParameterHandler$RawPart r11 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r11 = r11.iterable()
                return r11
            L_0x043f:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r14, r12)
                throw r11
            L_0x0446:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r6.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r6.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x046a:
                boolean r12 = r6.isArray()
                if (r12 == 0) goto L_0x0488
                java.lang.Class r12 = r6.getComponentType()
                boolean r12 = r0.isAssignableFrom(r12)
                if (r12 == 0) goto L_0x0481
                retrofit2.ParameterHandler$RawPart r11 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r11 = r11.array()
                return r11
            L_0x0481:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r14, r12)
                throw r11
            L_0x0488:
                boolean r12 = r0.isAssignableFrom(r6)
                if (r12 == 0) goto L_0x0491
                retrofit2.ParameterHandler$RawPart r11 = retrofit2.ParameterHandler.RawPart.INSTANCE
                return r11
            L_0x0491:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r14, r12)
                throw r11
            L_0x0498:
                r7 = 4
                java.lang.String[] r7 = new java.lang.String[r7]
                java.lang.String r8 = "Content-Disposition"
                r7[r4] = r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "form-data; name=\""
                r8.append(r9)
                r8.append(r1)
                java.lang.String r1 = "\""
                r8.append(r1)
                java.lang.String r1 = r8.toString()
                r7[r3] = r1
                r1 = 2
                java.lang.String r3 = "Content-Transfer-Encoding"
                r7[r1] = r3
                r1 = 3
                java.lang.String r14 = r14.encoding()
                r7[r1] = r14
                okhttp3.Headers r14 = okhttp3.Headers.of(r7)
                java.lang.Class<java.lang.Iterable> r1 = java.lang.Iterable.class
                boolean r1 = r1.isAssignableFrom(r6)
                java.lang.String r3 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation."
                if (r1 == 0) goto L_0x0522
                boolean r1 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r1 == 0) goto L_0x04fe
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r12 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class r1 = retrofit2.Utils.getRawType(r12)
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x04f7
                retrofit2.Retrofit r11 = r10.retrofit
                java.lang.annotation.Annotation[] r0 = r10.methodAnnotations
                retrofit2.Converter r11 = r11.requestBodyConverter(r12, r13, r0)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                r12.<init>(r14, r11)
                retrofit2.ParameterHandler r11 = r12.iterable()
                return r11
            L_0x04f7:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r3, r12)
                throw r11
            L_0x04fe:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r6.getSimpleName()
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = r6.getSimpleName()
                r12.append(r13)
                r12.append(r2)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x0522:
                boolean r1 = r6.isArray()
                if (r1 == 0) goto L_0x054f
                java.lang.Class r12 = r6.getComponentType()
                java.lang.Class r12 = retrofit2.ServiceMethod.boxIfPrimitive(r12)
                boolean r0 = r0.isAssignableFrom(r12)
                if (r0 != 0) goto L_0x0548
                retrofit2.Retrofit r11 = r10.retrofit
                java.lang.annotation.Annotation[] r0 = r10.methodAnnotations
                retrofit2.Converter r11 = r11.requestBodyConverter(r12, r13, r0)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                r12.<init>(r14, r11)
                retrofit2.ParameterHandler r11 = r12.array()
                return r11
            L_0x0548:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r3, r12)
                throw r11
            L_0x054f:
                boolean r0 = r0.isAssignableFrom(r6)
                if (r0 != 0) goto L_0x0563
                retrofit2.Retrofit r11 = r10.retrofit
                java.lang.annotation.Annotation[] r0 = r10.methodAnnotations
                retrofit2.Converter r11 = r11.requestBodyConverter(r12, r13, r0)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                r12.<init>(r14, r11)
                return r12
            L_0x0563:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r3, r12)
                throw r11
            L_0x056a:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@Part parameters can only be used with multipart encoding."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0573:
                boolean r1 = r14 instanceof retrofit2.http.PartMap
                if (r1 == 0) goto L_0x05f9
                boolean r1 = r10.isMultipart
                if (r1 == 0) goto L_0x05f0
                r10.gotPart = r3
                java.lang.Class r1 = retrofit2.Utils.getRawType(r12)
                java.lang.Class<java.util.Map> r2 = java.util.Map.class
                boolean r2 = r2.isAssignableFrom(r1)
                if (r2 == 0) goto L_0x05e7
                java.lang.Class<java.util.Map> r2 = java.util.Map.class
                java.lang.reflect.Type r12 = retrofit2.Utils.getSupertype(r12, r1, r2)
                boolean r1 = r12 instanceof java.lang.reflect.ParameterizedType
                if (r1 == 0) goto L_0x05e0
                java.lang.reflect.ParameterizedType r12 = (java.lang.reflect.ParameterizedType) r12
                java.lang.reflect.Type r1 = retrofit2.Utils.getParameterUpperBound(r4, r12)
                java.lang.Class<java.lang.String> r2 = java.lang.String.class
                if (r2 != r1) goto L_0x05c8
                java.lang.reflect.Type r12 = retrofit2.Utils.getParameterUpperBound(r3, r12)
                java.lang.Class r1 = retrofit2.Utils.getRawType(r12)
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x05bf
                retrofit2.Retrofit r11 = r10.retrofit
                java.lang.annotation.Annotation[] r0 = r10.methodAnnotations
                retrofit2.Converter r11 = r11.requestBodyConverter(r12, r13, r0)
                retrofit2.http.PartMap r14 = (retrofit2.http.PartMap) r14
                retrofit2.ParameterHandler$PartMap r12 = new retrofit2.ParameterHandler$PartMap
                java.lang.String r13 = r14.encoding()
                r12.<init>(r11, r13)
                return r12
            L_0x05bf:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x05c8:
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@PartMap keys must be of type String: "
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r12, r13)
                throw r11
            L_0x05e0:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.RuntimeException r11 = r10.parameterError(r11, r6, r12)
                throw r11
            L_0x05e7:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@PartMap parameter type must be Map."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x05f0:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@PartMap parameters can only be used with multipart encoding."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x05f9:
                boolean r14 = r14 instanceof retrofit2.http.Body
                if (r14 == 0) goto L_0x0637
                boolean r14 = r10.isFormEncoded
                if (r14 != 0) goto L_0x062e
                boolean r14 = r10.isMultipart
                if (r14 != 0) goto L_0x062e
                boolean r14 = r10.gotBody
                if (r14 != 0) goto L_0x0625
                retrofit2.Retrofit r14 = r10.retrofit     // Catch:{ RuntimeException -> 0x0619 }
                java.lang.annotation.Annotation[] r0 = r10.methodAnnotations     // Catch:{ RuntimeException -> 0x0619 }
                retrofit2.Converter r11 = r14.requestBodyConverter(r12, r13, r0)     // Catch:{ RuntimeException -> 0x0619 }
                r10.gotBody = r3
                retrofit2.ParameterHandler$Body r12 = new retrofit2.ParameterHandler$Body
                r12.<init>(r11)
                return r12
            L_0x0619:
                r13 = move-exception
                java.lang.Object[] r14 = new java.lang.Object[r3]
                r14[r4] = r12
                java.lang.String r12 = "Unable to create @Body converter for %s"
                java.lang.RuntimeException r11 = r10.parameterError(r13, r11, r12, r14)
                throw r11
            L_0x0625:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "Multiple @Body method annotations found."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x062e:
                java.lang.Object[] r12 = new java.lang.Object[r4]
                java.lang.String r13 = "@Body parameters cannot be used with form or multi-part encoding."
                java.lang.RuntimeException r11 = r10.parameterError(r11, r13, r12)
                throw r11
            L_0x0637:
                r11 = 0
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.Builder.parseParameterAnnotation(int, java.lang.reflect.Type, java.lang.annotation.Annotation[], java.lang.annotation.Annotation):retrofit2.ParameterHandler");
        }

        private void validatePathName(int i, String str) {
            if (!ServiceMethod.PARAM_NAME_REGEX.matcher(str).matches()) {
                throw parameterError(i, "@Path parameter name must match %s. Found: %s", ServiceMethod.PARAM_URL_REGEX.pattern(), str);
            } else if (!this.relativeUrlParamNames.contains(str)) {
                throw parameterError(i, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        private Converter<ResponseBody, T> createResponseConverter() {
            try {
                return this.retrofit.responseBodyConverter(this.responseType, this.method.getAnnotations());
            } catch (RuntimeException e) {
                throw methodError(e, "Unable to create converter for %s", this.responseType);
            }
        }

        private RuntimeException methodError(String str, Object... objArr) {
            return methodError(null, str, objArr);
        }

        private RuntimeException methodError(Throwable th, String str, Object... objArr) {
            String format = String.format(str, objArr);
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("\n    for method ");
            sb.append(this.method.getDeclaringClass().getSimpleName());
            sb.append(".");
            sb.append(this.method.getName());
            return new IllegalArgumentException(sb.toString(), th);
        }

        private RuntimeException parameterError(Throwable th, int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return methodError(th, sb.toString(), objArr);
        }

        private RuntimeException parameterError(int i, String str, Object... objArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" (parameter #");
            sb.append(i + 1);
            sb.append(")");
            return methodError(sb.toString(), objArr);
        }
    }

    ServiceMethod(Builder<R, T> builder) {
        this.callFactory = builder.retrofit.callFactory();
        this.callAdapter = builder.callAdapter;
        this.baseUrl = builder.retrofit.baseUrl();
        this.responseConverter = builder.responseConverter;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
    }

    /* access modifiers changed from: 0000 */
    public Call toCall(Object... objArr) throws IOException {
        RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr != null ? objArr.length : 0;
        if (length == parameterHandlerArr.length) {
            for (int i = 0; i < length; i++) {
                parameterHandlerArr[i].apply(requestBuilder, objArr[i]);
            }
            return this.callFactory.newCall(requestBuilder.build());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(parameterHandlerArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public T adapt(Call<R> call) {
        return this.callAdapter.adapt(call);
    }

    /* access modifiers changed from: 0000 */
    public R toResponse(ResponseBody responseBody) throws IOException {
        return this.responseConverter.convert(responseBody);
    }

    static Set<String> parsePathParameters(String str) {
        Matcher matcher = PARAM_URL_REGEX.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Class<?> boxIfPrimitive(java.lang.Class r1) {
        /*
            java.lang.Class r0 = java.lang.Boolean.TYPE
            if (r0 != r1) goto L_0x0007
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            return r1
        L_0x0007:
            java.lang.Class r0 = java.lang.Byte.TYPE
            if (r0 != r1) goto L_0x000e
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            return r1
        L_0x000e:
            java.lang.Class r0 = java.lang.Character.TYPE
            if (r0 != r1) goto L_0x0015
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            return r1
        L_0x0015:
            java.lang.Class r0 = java.lang.Double.TYPE
            if (r0 != r1) goto L_0x001c
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            return r1
        L_0x001c:
            java.lang.Class r0 = java.lang.Float.TYPE
            if (r0 != r1) goto L_0x0023
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            return r1
        L_0x0023:
            java.lang.Class r0 = java.lang.Integer.TYPE
            if (r0 != r1) goto L_0x002a
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            return r1
        L_0x002a:
            java.lang.Class r0 = java.lang.Long.TYPE
            if (r0 != r1) goto L_0x0031
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            return r1
        L_0x0031:
            java.lang.Class r0 = java.lang.Short.TYPE
            if (r0 != r1) goto L_0x0037
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.boxIfPrimitive(java.lang.Class):java.lang.Class");
    }
}
