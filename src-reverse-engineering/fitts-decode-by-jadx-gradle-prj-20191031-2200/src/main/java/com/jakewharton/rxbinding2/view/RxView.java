package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class RxView {
    @CheckResult
    @NonNull
    public static Observable<Object> attaches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachesObservable(view, true);
    }

    @CheckResult
    @NonNull
    public static Observable<ViewAttachEvent> attachEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachEventObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> detaches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewAttachesObservable(view, false);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> clicks(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewClickObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<DragEvent> drags(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewDragObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @CheckResult
    @NonNull
    public static Observable<DragEvent> drags(@NonNull View view, @NonNull Predicate<? super DragEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewDragObservable(view, predicate);
    }

    @RequiresApi(16)
    @CheckResult
    @NonNull
    public static Observable<Object> draws(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTreeObserverDrawObservable(view);
    }

    @CheckResult
    @NonNull
    public static InitialValueObservable<Boolean> focusChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewFocusChangeObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> globalLayouts(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTreeObserverGlobalLayoutObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<MotionEvent> hovers(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewHoverObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @CheckResult
    @NonNull
    public static Observable<MotionEvent> hovers(@NonNull View view, @NonNull Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewHoverObservable(view, predicate);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> layoutChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLayoutChangeObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<ViewLayoutChangeEvent> layoutChangeEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLayoutChangeEventObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> longClicks(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewLongClickObservable(view, Functions.CALLABLE_ALWAYS_TRUE);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> longClicks(@NonNull View view, @NonNull Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "handled == null");
        return new ViewLongClickObservable(view, callable);
    }

    @CheckResult
    @NonNull
    public static Observable<Object> preDraws(@NonNull View view, @NonNull Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "proceedDrawingPass == null");
        return new ViewTreeObserverPreDrawObservable(view, callable);
    }

    @RequiresApi(23)
    @CheckResult
    @NonNull
    public static Observable<ViewScrollChangeEvent> scrollChangeEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewScrollChangeEventObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<Integer> systemUiVisibilityChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewSystemUiVisibilityChangeObservable(view);
    }

    @CheckResult
    @NonNull
    public static Observable<MotionEvent> touches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewTouchObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @CheckResult
    @NonNull
    public static Observable<MotionEvent> touches(@NonNull View view, @NonNull Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewTouchObservable(view, predicate);
    }

    @CheckResult
    @NonNull
    public static Observable<KeyEvent> keys(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new ViewKeyObservable(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @CheckResult
    @NonNull
    public static Observable<KeyEvent> keys(@NonNull View view, @NonNull Predicate<? super KeyEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new ViewKeyObservable(view, predicate);
    }

    @CheckResult
    @NonNull
    @Deprecated
    public static Consumer<? super Boolean> activated(@NonNull final View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                view.setActivated(bool.booleanValue());
            }
        };
    }

    @CheckResult
    @NonNull
    @Deprecated
    public static Consumer<? super Boolean> clickable(@NonNull final View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                view.setClickable(bool.booleanValue());
            }
        };
    }

    @CheckResult
    @NonNull
    @Deprecated
    public static Consumer<? super Boolean> enabled(@NonNull final View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                view.setEnabled(bool.booleanValue());
            }
        };
    }

    @CheckResult
    @NonNull
    @Deprecated
    public static Consumer<? super Boolean> pressed(@NonNull final View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                view.setPressed(bool.booleanValue());
            }
        };
    }

    @CheckResult
    @NonNull
    @Deprecated
    public static Consumer<? super Boolean> selected(@NonNull final View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new Consumer<Boolean>() {
            public void accept(Boolean bool) {
                view.setSelected(bool.booleanValue());
            }
        };
    }

    @CheckResult
    @NonNull
    public static Consumer<? super Boolean> visibility(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return visibility(view, 8);
    }

    @CheckResult
    @NonNull
    public static Consumer<? super Boolean> visibility(@NonNull final View view, final int i) {
        Preconditions.checkNotNull(view, "view == null");
        if (i == 0) {
            throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.");
        } else if (i == 4 || i == 8) {
            return new Consumer<Boolean>() {
                public void accept(Boolean bool) {
                    view.setVisibility(bool.booleanValue() ? 0 : i);
                }
            };
        } else {
            throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.");
        }
    }
}
