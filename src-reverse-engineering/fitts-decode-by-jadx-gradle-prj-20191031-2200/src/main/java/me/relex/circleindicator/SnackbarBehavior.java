package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.Snackbar.SnackbarLayout;
import java.util.List;

public class SnackbarBehavior extends Behavior<CircleIndicator> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        return view instanceof SnackbarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        circleIndicator.setTranslationY(getTranslationYForSnackbar(coordinatorLayout, circleIndicator));
        return true;
    }

    private float getTranslationYForSnackbar(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator) {
        List dependencies = coordinatorLayout.getDependencies(circleIndicator);
        int size = dependencies.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = (View) dependencies.get(i);
            if ((view instanceof SnackbarLayout) && coordinatorLayout.doViewsOverlap(circleIndicator, view)) {
                f = Math.min(f, ViewCompat.getTranslationY(view) - ((float) view.getHeight()));
            }
        }
        return f;
    }
}
