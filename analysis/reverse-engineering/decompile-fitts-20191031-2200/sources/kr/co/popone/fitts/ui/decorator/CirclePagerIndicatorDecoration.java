package kr.co.popone.fitts.ui.decorator;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.orhanobut.logger.Logger;

public class CirclePagerIndicatorDecoration extends ItemDecoration {
    private static final float DP = Resources.getSystem().getDisplayMetrics().density;
    private int colorActive = -1;
    private int colorInactive = 1895825407;
    private final int mIndicatorHeight;
    private float mIndicatorItemLength;
    private float mIndicatorItemPadding;
    private float mIndicatorStrokeWidth;
    private final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private final Paint mPaint = new Paint();
    private int realItemCount;

    public CirclePagerIndicatorDecoration(int i, int i2, int i3, int i4) {
        float f = (float) i2;
        float f2 = DP;
        this.mIndicatorStrokeWidth = f * f2;
        this.mIndicatorItemLength = f * f2;
        this.mIndicatorItemPadding = ((float) i3) * f2;
        this.mIndicatorHeight = (int) (((float) i4) * f2);
        this.mPaint.setStrokeWidth(this.mIndicatorStrokeWidth);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.realItemCount = i;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        super.onDrawOver(canvas, recyclerView, state);
        float f2 = this.mIndicatorItemLength;
        int i = this.realItemCount;
        float width = (((float) recyclerView.getWidth()) - ((f2 * ((float) i)) + (((float) Math.max(0, i - 1)) * this.mIndicatorItemPadding))) / 2.0f;
        float height = ((float) recyclerView.getHeight()) - (((float) this.mIndicatorHeight) / 2.0f);
        drawInactiveIndicators(canvas, width, height, this.realItemCount);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() % this.realItemCount;
        int findFirstVisibleItemPosition2 = linearLayoutManager.findFirstVisibleItemPosition();
        StringBuilder sb = new StringBuilder();
        sb.append("ActivePosition = ");
        sb.append(findFirstVisibleItemPosition2);
        Logger.d(sb.toString());
        if (findFirstVisibleItemPosition2 != -1) {
            View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition2);
            int left = findViewByPosition.getLeft();
            int width2 = findViewByPosition.getWidth();
            findViewByPosition.getRight();
            if (findFirstVisibleItemPosition == this.realItemCount - 1) {
                f = 0.0f;
            } else {
                f = this.mInterpolator.getInterpolation(((float) (left * -1)) / ((float) width2));
            }
            drawHighlights(canvas, width, height, findFirstVisibleItemPosition, f);
        }
    }

    private void drawInactiveIndicators(Canvas canvas, float f, float f2, int i) {
        this.mPaint.setColor(this.colorInactive);
        float f3 = this.mIndicatorItemLength + this.mIndicatorItemPadding;
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawCircle(f, f2, this.mIndicatorItemLength / 2.0f, this.mPaint);
            f += f3;
        }
    }

    private void drawHighlights(Canvas canvas, float f, float f2, int i, float f3) {
        this.mPaint.setColor(this.colorActive);
        float f4 = this.mIndicatorItemLength;
        float f5 = this.mIndicatorItemPadding;
        float f6 = f4 + f5;
        if (f3 == 0.0f) {
            canvas.drawCircle(f + (f6 * ((float) i)), f2, f4 / 2.0f, this.mPaint);
        } else {
            canvas.drawCircle(f + (f6 * ((float) i)) + (f4 * f3) + (f5 * f3), f2, f4 / 2.0f, this.mPaint);
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.bottom = -((int) (DP * 16.0f));
    }
}
