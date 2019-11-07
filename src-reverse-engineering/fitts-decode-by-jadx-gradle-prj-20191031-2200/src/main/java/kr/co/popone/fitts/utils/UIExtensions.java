package kr.co.popone.fitts.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.orhanobut.logger.Logger;
import org.jetbrains.annotations.NotNull;

public final class UIExtensions {
    public static final UIExtensions INSTANCE = new UIExtensions();
    private static int _maxTexturesSize = -1;

    private UIExtensions() {
    }

    public final int getMaxTexturesSize() {
        if (_maxTexturesSize < 0) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            int[] iArr = new int[2];
            EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            EGL14.eglChooseConfig(eglGetDisplay, new int[]{12351, 12430, 12329, 0, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
            int i = iArr2[0];
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344}, 0);
            EGLContext eglCreateContext = EGL14.eglCreateContext(eglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            EGL14.eglMakeCurrent(eglGetDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext);
            int[] iArr3 = new int[1];
            GLES20.glGetIntegerv(3379, iArr3, 0);
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(eglGetDisplay, eglCreatePbufferSurface);
            EGL14.eglDestroyContext(eglGetDisplay, eglCreateContext);
            EGL14.eglTerminate(eglGetDisplay);
            _maxTexturesSize = ArraysKt___ArraysKt.first(iArr3);
        }
        return _maxTexturesSize;
    }

    @NotNull
    public final String likeCountText(boolean z, boolean z2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("isMine(");
        sb.append(z);
        sb.append(") liked(");
        sb.append(z2);
        sb.append(") likeCount(");
        sb.append(i);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        if ((!z || i == 0) && (z || !z2)) {
            return "좋아요";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("좋아요 ");
        sb2.append(i);
        sb2.append(44060);
        return sb2.toString();
    }
}
