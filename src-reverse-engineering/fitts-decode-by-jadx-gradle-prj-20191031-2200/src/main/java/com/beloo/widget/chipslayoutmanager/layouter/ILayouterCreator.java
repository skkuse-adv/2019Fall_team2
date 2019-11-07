package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder;

interface ILayouterCreator {
    Builder createBackwardBuilder();

    Builder createForwardBuilder();

    Rect createOffsetRectForBackwardLayouter(@NonNull AnchorViewState anchorViewState);

    Rect createOffsetRectForForwardLayouter(AnchorViewState anchorViewState);
}
