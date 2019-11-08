package com.beloo.widget.chipslayoutmanager.util.log;

import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;

public class LoggerFactory {
    @NonNull
    public IFillLogger getFillLogger(SparseArray<View> sparseArray) {
        return new FillLogger(sparseArray);
    }
}
