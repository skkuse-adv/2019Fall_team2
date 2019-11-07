package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory;
import com.bumptech.glide.load.model.ResourceLoader.StreamFactory;
import com.bumptech.glide.load.model.ResourceLoader.UriFactory;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader.Factory;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {
    private static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final String TAG = "Glide";
    private static volatile Glide glide;
    private static volatile boolean isInitializing;
    private final ArrayPool arrayPool;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final ConnectivityMonitorFactory connectivityMonitorFactory;
    private final Engine engine;
    private final GlideContext glideContext;
    private final List<RequestManager> managers = new ArrayList();
    private final MemoryCache memoryCache;
    private MemoryCategory memoryCategory = MemoryCategory.NORMAL;
    private final Registry registry;
    private final RequestManagerRetriever requestManagerRetriever;

    public void onConfigurationChanged(Configuration configuration) {
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            File file = new File(cacheDir, str);
            if (file.mkdirs() || (file.exists() && file.isDirectory())) {
                return file;
            }
            return null;
        }
        boolean isLoggable = Log.isLoggable(TAG, 6);
        return null;
    }

    @NonNull
    public static Glide get(@NonNull Context context) {
        if (glide == null) {
            synchronized (Glide.class) {
                if (glide == null) {
                    checkAndInitializeGlide(context);
                }
            }
        }
        return glide;
    }

    private static void checkAndInitializeGlide(@NonNull Context context) {
        if (!isInitializing) {
            isInitializing = true;
            initializeGlide(context);
            isInitializing = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @VisibleForTesting
    @Deprecated
    public static synchronized void init(Glide glide2) {
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            glide = glide2;
        }
    }

    @VisibleForTesting
    public static synchronized void init(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        synchronized (Glide.class) {
            if (glide != null) {
                tearDown();
            }
            initializeGlide(context, glideBuilder);
        }
    }

    @VisibleForTesting
    public static synchronized void tearDown() {
        synchronized (Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                glide.engine.shutdown();
            }
            glide = null;
        }
    }

    private static void initializeGlide(@NonNull Context context) {
        initializeGlide(context, new GlideBuilder());
    }

    private static void initializeGlide(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        Context applicationContext = context.getApplicationContext();
        GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules();
        List<GlideModule> emptyList = Collections.emptyList();
        if (annotationGeneratedGlideModules == null || annotationGeneratedGlideModules.isManifestParsingEnabled()) {
            emptyList = new ManifestParser(applicationContext).parse();
        }
        String str = TAG;
        if (annotationGeneratedGlideModules != null && !annotationGeneratedGlideModules.getExcludedModuleClasses().isEmpty()) {
            Set excludedModuleClasses = annotationGeneratedGlideModules.getExcludedModuleClasses();
            Iterator it = emptyList.iterator();
            while (it.hasNext()) {
                GlideModule glideModule = (GlideModule) it.next();
                if (excludedModuleClasses.contains(glideModule.getClass())) {
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AppGlideModule excludes manifest GlideModule: ");
                        sb.append(glideModule);
                        sb.toString();
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable(str, 3)) {
            for (GlideModule glideModule2 : emptyList) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(glideModule2.getClass());
                sb2.toString();
            }
        }
        glideBuilder.setRequestManagerFactory(annotationGeneratedGlideModules != null ? annotationGeneratedGlideModules.getRequestManagerFactory() : null);
        for (GlideModule applyOptions : emptyList) {
            applyOptions.applyOptions(applicationContext, glideBuilder);
        }
        if (annotationGeneratedGlideModules != null) {
            annotationGeneratedGlideModules.applyOptions(applicationContext, glideBuilder);
        }
        Glide build = glideBuilder.build(applicationContext);
        for (GlideModule registerComponents : emptyList) {
            registerComponents.registerComponents(applicationContext, build, build.registry);
        }
        if (annotationGeneratedGlideModules != null) {
            annotationGeneratedGlideModules.registerComponents(applicationContext, build, build.registry);
        }
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    @Nullable
    private static GeneratedAppGlideModule getAnnotationGeneratedGlideModules() {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            boolean isLoggable = Log.isLoggable(TAG, 5);
        } catch (InstantiationException e) {
            throwIncorrectGlideModule(e);
        } catch (IllegalAccessException e2) {
            throwIncorrectGlideModule(e2);
        } catch (NoSuchMethodException e3) {
            throwIncorrectGlideModule(e3);
        } catch (InvocationTargetException e4) {
            throwIncorrectGlideModule(e4);
        }
        return null;
    }

    private static void throwIncorrectGlideModule(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    Glide(@NonNull Context context, @NonNull Engine engine2, @NonNull MemoryCache memoryCache2, @NonNull BitmapPool bitmapPool2, @NonNull ArrayPool arrayPool2, @NonNull RequestManagerRetriever requestManagerRetriever2, @NonNull ConnectivityMonitorFactory connectivityMonitorFactory2, int i, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull List<RequestListener<Object>> list, boolean z) {
        Context context2 = context;
        MemoryCache memoryCache3 = memoryCache2;
        BitmapPool bitmapPool3 = bitmapPool2;
        ArrayPool arrayPool3 = arrayPool2;
        Class<GifDecoder> cls = GifDecoder.class;
        Class<byte[]> cls2 = byte[].class;
        this.engine = engine2;
        this.bitmapPool = bitmapPool3;
        this.arrayPool = arrayPool3;
        this.memoryCache = memoryCache3;
        this.requestManagerRetriever = requestManagerRetriever2;
        this.connectivityMonitorFactory = connectivityMonitorFactory2;
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache3, bitmapPool3, (DecodeFormat) requestOptions.getOptions().get(Downsampler.DECODE_FORMAT));
        Resources resources = context.getResources();
        this.registry = new Registry();
        this.registry.register((ImageHeaderParser) new DefaultImageHeaderParser());
        if (VERSION.SDK_INT >= 27) {
            this.registry.register((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        }
        List imageHeaderParsers = this.registry.getImageHeaderParsers();
        Downsampler downsampler = new Downsampler(imageHeaderParsers, resources.getDisplayMetrics(), bitmapPool3, arrayPool3);
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, imageHeaderParsers, bitmapPool3, arrayPool3);
        ResourceDecoder parcel = VideoDecoder.parcel(bitmapPool2);
        ByteBufferBitmapDecoder byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool3);
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        StreamFactory streamFactory = new StreamFactory(resources);
        UriFactory uriFactory = new UriFactory(resources);
        FileDescriptorFactory fileDescriptorFactory = new FileDescriptorFactory(resources);
        Class<byte[]> cls3 = cls2;
        AssetFileDescriptorFactory assetFileDescriptorFactory = new AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool3);
        AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        UriFactory uriFactory2 = uriFactory;
        FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        String str = Registry.BUCKET_BITMAP;
        StreamFactory streamFactory2 = streamFactory;
        BitmapDrawableDecoder bitmapDrawableDecoder = new BitmapDrawableDecoder(resources, (ResourceDecoder<DataType, Bitmap>) byteBufferBitmapDecoder);
        String str2 = Registry.BUCKET_BITMAP_DRAWABLE;
        StreamGifDecoder streamGifDecoder = new StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool3);
        String str3 = Registry.BUCKET_GIF;
        StreamFactory streamFactory3 = streamFactory2;
        FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        UriFactory uriFactory3 = uriFactory2;
        AssetFileDescriptorFactory assetFileDescriptorFactory3 = assetFileDescriptorFactory2;
        Context context3 = context;
        ContentResolver contentResolver2 = contentResolver;
        Class<byte[]> cls4 = cls3;
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        this.registry.append(ByteBuffer.class, (Encoder<Data>) new ByteBufferEncoder<Data>()).append(InputStream.class, (Encoder<Data>) new StreamEncoder<Data>(arrayPool3)).append(str, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).append(str, InputStream.class, Bitmap.class, streamBitmapDecoder).append(str, ParcelFileDescriptor.class, Bitmap.class, parcel).append(str, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bitmapPool2)).append(Bitmap.class, Bitmap.class, (ModelLoaderFactory<Model, Data>) Factory.getInstance()).append(str, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).append(Bitmap.class, (ResourceEncoder<TResource>) bitmapEncoder).append(str2, ByteBuffer.class, BitmapDrawable.class, bitmapDrawableDecoder).append(str2, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, (ResourceDecoder<DataType, Bitmap>) streamBitmapDecoder)).append(str2, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, parcel)).append(BitmapDrawable.class, (ResourceEncoder<TResource>) new BitmapDrawableEncoder<TResource>(bitmapPool3, bitmapEncoder)).append(str3, InputStream.class, GifDrawable.class, streamGifDecoder).append(str3, ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).append(GifDrawable.class, (ResourceEncoder<TResource>) new GifDrawableEncoder<TResource>()).append(cls, cls, (ModelLoaderFactory<Model, Data>) Factory.getInstance()).append(str, cls, Bitmap.class, new GifFrameResourceDecoder(bitmapPool3)).append(Uri.class, Drawable.class, (ResourceDecoder<Data, TResource>) resourceDrawableDecoder).append(Uri.class, Bitmap.class, (ResourceDecoder<Data, TResource>) new ResourceBitmapDecoder<Data,TResource>(resourceDrawableDecoder, bitmapPool3)).register((DataRewinder.Factory<?>) new ByteBufferRewinder.Factory<Object>()).append(File.class, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new ByteBufferFileLoader.Factory<Model,Data>()).append(File.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new FileLoader.StreamFactory<Model,Data>()).append(File.class, File.class, (ResourceDecoder<Data, TResource>) new FileDecoder<Data,TResource>()).append(File.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new FileLoader.FileDescriptorFactory<Model,Data>()).append(File.class, File.class, (ModelLoaderFactory<Model, Data>) Factory.getInstance()).register((DataRewinder.Factory<?>) new InputStreamRewinder.Factory<Object>(arrayPool3)).append(Integer.TYPE, InputStream.class, (ModelLoaderFactory<Model, Data>) streamFactory3).append(Integer.TYPE, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) fileDescriptorFactory3).append(Integer.class, InputStream.class, (ModelLoaderFactory<Model, Data>) streamFactory3).append(Integer.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) fileDescriptorFactory3).append(Integer.class, Uri.class, (ModelLoaderFactory<Model, Data>) uriFactory3).append(Integer.TYPE, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) assetFileDescriptorFactory3).append(Integer.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) assetFileDescriptorFactory3).append(Integer.TYPE, Uri.class, (ModelLoaderFactory<Model, Data>) uriFactory3).append(String.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new DataUrlLoader.StreamFactory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new DataUrlLoader.StreamFactory<Model,Data>()).append(String.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new StringLoader.StreamFactory<Model,Data>()).append(String.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new StringLoader.FileDescriptorFactory<Model,Data>()).append(String.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new StringLoader.AssetFileDescriptorFactory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new HttpUriLoader.Factory<Model,Data>()).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new AssetUriLoader.StreamFactory<Model,Data>(context.getAssets())).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new AssetUriLoader.FileDescriptorFactory<Model,Data>(context.getAssets())).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreImageThumbLoader.Factory<Model,Data>(context3)).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new MediaStoreVideoThumbLoader.Factory<Model,Data>(context3)).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UriLoader.StreamFactory<Model,Data>(contentResolver2)).append(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new UriLoader.FileDescriptorFactory<Model,Data>(contentResolver2)).append(Uri.class, AssetFileDescriptor.class, (ModelLoaderFactory<Model, Data>) new UriLoader.AssetFileDescriptorFactory<Model,Data>(contentResolver2)).append(Uri.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UrlUriLoader.StreamFactory<Model,Data>()).append(URL.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new UrlLoader.StreamFactory<Model,Data>()).append(Uri.class, File.class, (ModelLoaderFactory<Model, Data>) new MediaStoreFileLoader.Factory<Model,Data>(context3)).append(GlideUrl.class, InputStream.class, (ModelLoaderFactory<Model, Data>) new HttpGlideUrlLoader.Factory<Model,Data>()).append(cls4, ByteBuffer.class, (ModelLoaderFactory<Model, Data>) new ByteBufferFactory<Model,Data>()).append(cls4, InputStream.class, (ModelLoaderFactory<Model, Data>) new ByteArrayLoader.StreamFactory<Model,Data>()).append(Uri.class, Uri.class, (ModelLoaderFactory<Model, Data>) Factory.getInstance()).append(Drawable.class, Drawable.class, (ModelLoaderFactory<Model, Data>) Factory.getInstance()).append(Drawable.class, Drawable.class, (ResourceDecoder<Data, TResource>) new UnitDrawableDecoder<Data,TResource>()).register(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).register(Bitmap.class, cls4, bitmapBytesTranscoder2).register(Drawable.class, cls4, new DrawableBytesTranscoder(bitmapPool3, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).register(GifDrawable.class, cls4, gifDrawableBytesTranscoder2);
        GlideContext glideContext2 = new GlideContext(context, arrayPool2, this.registry, new ImageViewTargetFactory(), requestOptions, map, list, engine2, z, i);
        this.glideContext = glideContext2;
    }

    @NonNull
    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    @NonNull
    public ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @NonNull
    public Context getContext() {
        return this.glideContext.getBaseContext();
    }

    /* access modifiers changed from: 0000 */
    public ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    /* access modifiers changed from: 0000 */
    @NonNull
    public GlideContext getGlideContext() {
        return this.glideContext;
    }

    public void preFillBitmapPool(@NonNull Builder... builderArr) {
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
        this.arrayPool.trimMemory(i);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    @NonNull
    public RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @NonNull
    public MemoryCategory setMemoryCategory(@NonNull MemoryCategory memoryCategory2) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory2.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory2.getMultiplier());
        MemoryCategory memoryCategory3 = this.memoryCategory;
        this.memoryCategory = memoryCategory2;
        return memoryCategory3;
    }

    @NonNull
    private static RequestManagerRetriever getRetriever(@Nullable Context context) {
        Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @NonNull
    public static RequestManager with(@NonNull Context context) {
        return getRetriever(context).get(context);
    }

    @NonNull
    public static RequestManager with(@NonNull Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @NonNull
    public static RequestManager with(@NonNull FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    @NonNull
    public static RequestManager with(@NonNull Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    @Deprecated
    public static RequestManager with(@NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @NonNull
    public static RequestManager with(@NonNull View view) {
        return getRetriever(view.getContext()).get(view);
    }

    @NonNull
    public Registry getRegistry() {
        return this.registry;
    }

    /* access modifiers changed from: 0000 */
    public boolean removeFromManagers(@NonNull Target<?> target) {
        synchronized (this.managers) {
            for (RequestManager untrack : this.managers) {
                if (untrack.untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void registerRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (!this.managers.contains(requestManager)) {
                this.managers.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void unregisterRequestManager(RequestManager requestManager) {
        synchronized (this.managers) {
            if (this.managers.contains(requestManager)) {
                this.managers.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public void onLowMemory() {
        clearMemory();
    }
}
