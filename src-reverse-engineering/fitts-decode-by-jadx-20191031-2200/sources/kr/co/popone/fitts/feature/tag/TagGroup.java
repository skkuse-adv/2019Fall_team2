package kr.co.popone.fitts.feature.tag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.content.ContextCompat;
import com.kakao.network.ServerProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kr.co.popone.fitts.R$styleable;

public class TagGroup extends ViewGroup {
    /* access modifiers changed from: private */
    public int backgroundColor;
    /* access modifiers changed from: private */
    public int borderColor;
    /* access modifiers changed from: private */
    public float borderStrokeWidth;
    /* access modifiers changed from: private */
    public int checkedBackgroundColor;
    /* access modifiers changed from: private */
    public int checkedBorderColor;
    /* access modifiers changed from: private */
    public int checkedMarkerColor;
    /* access modifiers changed from: private */
    public int checkedTextColor;
    /* access modifiers changed from: private */
    public int dashBorderColor;
    /* access modifiers changed from: private */
    public int horizontalPadding;
    private int horizontalSpacing;
    /* access modifiers changed from: private */
    public CharSequence inputHint;
    /* access modifiers changed from: private */
    public int inputHintColor;
    /* access modifiers changed from: private */
    public int inputTextColor;
    /* access modifiers changed from: private */
    public boolean isAppendMode;
    private InternalTagClickListener mInternalTagClickListener;
    /* access modifiers changed from: private */
    public OnTagChangeListener mOnTagChangeListener;
    /* access modifiers changed from: private */
    public OnTagClickListener mOnTagClickListener;
    /* access modifiers changed from: private */
    public int pressedBackgroundColor;
    /* access modifiers changed from: private */
    public int textColor;
    /* access modifiers changed from: private */
    public float textSize;
    /* access modifiers changed from: private */
    public int verticalPadding;
    private int verticalSpacing;

    private class InternalTagClickListener implements OnClickListener {
        private InternalTagClickListener() {
        }

        public void onClick(View view) {
            TagView tagView = (TagView) view;
            if (TagGroup.this.isAppendMode) {
                if (tagView.mState == 2) {
                    TagView checkedTag = TagGroup.this.getCheckedTag();
                    if (checkedTag != null) {
                        checkedTag.setChecked(false);
                    }
                } else if (tagView.isChecked) {
                    TagGroup.this.deleteTag(tagView);
                } else {
                    TagView checkedTag2 = TagGroup.this.getCheckedTag();
                    if (checkedTag2 != null) {
                        checkedTag2.setChecked(false);
                    }
                    tagView.setChecked(true);
                }
            } else if (TagGroup.this.mOnTagClickListener != null) {
                TagGroup.this.mOnTagClickListener.onTagClick(tagView.getText().toString(), tagView);
            }
        }
    }

    private static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public interface OnTagChangeListener {
        void onAppend(TagGroup tagGroup, String str);

        void onDelete(TagGroup tagGroup, String str);
    }

    public interface OnTagClickListener {
        void onTagClick(String str, TagView tagView);
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int checkedPosition;
        String input;
        int tagCount;
        String[] tags;

        SavedState(Parcel parcel) {
            super(parcel);
            this.tagCount = parcel.readInt();
            this.tags = new String[this.tagCount];
            parcel.readStringArray(this.tags);
            this.checkedPosition = parcel.readInt();
            this.input = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            this.tagCount = this.tags.length;
            parcel.writeInt(this.tagCount);
            parcel.writeStringArray(this.tags);
            parcel.writeInt(this.checkedPosition);
            parcel.writeString(this.input);
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    public class TagView extends TextView {
        public static final int STATE_INPUT = 2;
        public static final int STATE_NORMAL = 1;
        /* access modifiers changed from: private */
        public boolean isChecked;
        private boolean isPressed;
        private Paint mBackgroundPaint;
        public Paint mBorderPaint = new Paint(1);
        private Path mBorderPath;
        private RectF mCheckedMarkerBound;
        private Paint mCheckedMarkerPaint;
        private RectF mHorizontalBlankFillRectF;
        private RectF mLeftCornerRectF;
        private Rect mOutRect;
        private RectF mRightCornerRectF;
        /* access modifiers changed from: private */
        public int mState;
        private RectF mVerticalBlankFillRectF;
        private int tagBackgroundColor;
        private int tagBorderColor;
        private int tagPressedBackgroundColor;

        private class ZanyInputConnection extends InputConnectionWrapper {
            ZanyInputConnection(TagView tagView, InputConnection inputConnection, boolean z) {
                super(inputConnection, z);
            }

            public boolean deleteSurroundingText(int i, int i2) {
                boolean z = true;
                if (i != 1 || i2 != 0) {
                    return super.deleteSurroundingText(i, i2);
                }
                if (!sendKeyEvent(new KeyEvent(0, 67)) || !sendKeyEvent(new KeyEvent(1, 67))) {
                    z = false;
                }
                return z;
            }
        }

        /* access modifiers changed from: protected */
        public boolean getDefaultEditable() {
            return true;
        }

        public TagView(Context context, int i, CharSequence charSequence) {
            super(context);
            boolean z = false;
            this.isChecked = false;
            this.isPressed = false;
            this.mBackgroundPaint = new Paint(1);
            this.mCheckedMarkerPaint = new Paint(1);
            this.mLeftCornerRectF = new RectF();
            this.mRightCornerRectF = new RectF();
            this.mHorizontalBlankFillRectF = new RectF();
            this.mVerticalBlankFillRectF = new RectF();
            this.mCheckedMarkerBound = new RectF();
            this.mOutRect = new Rect();
            this.mBorderPath = new Path();
            this.tagBackgroundColor = TagGroup.this.backgroundColor;
            this.tagBorderColor = TagGroup.this.borderColor;
            this.tagPressedBackgroundColor = TagGroup.this.pressedBackgroundColor;
            new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f);
            this.mBorderPaint.setStyle(Style.STROKE);
            this.mBorderPaint.setStrokeWidth(TagGroup.this.borderStrokeWidth);
            this.mBackgroundPaint.setStyle(Style.FILL);
            this.mCheckedMarkerPaint.setStyle(Style.FILL);
            this.mCheckedMarkerPaint.setStrokeWidth(4.0f);
            this.mCheckedMarkerPaint.setColor(TagGroup.this.checkedMarkerColor);
            setPadding(TagGroup.this.horizontalPadding, TagGroup.this.verticalPadding, TagGroup.this.horizontalPadding, TagGroup.this.verticalPadding);
            setLayoutParams(new LayoutParams(-2, -2));
            setGravity(17);
            setText(charSequence);
            setTextSize(0, TagGroup.this.textSize);
            this.mState = i;
            setClickable(TagGroup.this.isAppendMode);
            setFocusable(i == 2);
            if (i == 2) {
                z = true;
            }
            setFocusableInTouchMode(z);
            MovementMethod movementMethod = null;
            setHint(i == 2 ? TagGroup.this.inputHint : null);
            if (i == 2) {
                movementMethod = ArrowKeyMovementMethod.getInstance();
            }
            setMovementMethod(movementMethod);
            setOnLongClickListener(new OnLongClickListener(this, TagGroup.this, i) {
                final /* synthetic */ int val$state;

                {
                    this.val$state = r3;
                }

                public boolean onLongClick(View view) {
                    return this.val$state != 2;
                }
            });
            if (i == 2) {
                setOnEditorActionListener(new OnEditorActionListener(TagGroup.this) {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i != 0 || keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
                            return false;
                        }
                        TagView tagView = TagView.this;
                        tagView.setText(tagView.getText().toString().trim());
                        if (TagView.this.isInputAvailable()) {
                            TagView.this.endInput();
                            if (TagGroup.this.mOnTagChangeListener != null) {
                                OnTagChangeListener access$1400 = TagGroup.this.mOnTagChangeListener;
                                TagView tagView2 = TagView.this;
                                access$1400.onAppend(TagGroup.this, tagView2.getText().toString());
                            }
                            TagGroup.this.appendInputTag();
                        }
                        return true;
                    }
                });
                setOnKeyListener(new OnKeyListener(TagGroup.this) {
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(TagView.this.getText().toString())) {
                            TagView lastNormalTagView = TagGroup.this.getLastNormalTagView();
                            if (lastNormalTagView != null) {
                                if (lastNormalTagView.isChecked) {
                                    TagGroup.this.removeView(lastNormalTagView);
                                    if (TagGroup.this.mOnTagChangeListener != null) {
                                        TagGroup.this.mOnTagChangeListener.onDelete(TagGroup.this, lastNormalTagView.getText().toString());
                                    }
                                } else {
                                    TagView checkedTag = TagGroup.this.getCheckedTag();
                                    if (checkedTag != null) {
                                        checkedTag.setChecked(false);
                                    }
                                    lastNormalTagView.setChecked(true);
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                });
                addTextChangedListener(new TextWatcher(TagGroup.this) {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        TagView checkedTag = TagGroup.this.getCheckedTag();
                        if (checkedTag != null) {
                            checkedTag.setChecked(false);
                        }
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String charSequence2 = charSequence.toString();
                        String str = ServerProtocol.AUTHORIZATION_HEADER_DELIMITER;
                        if (charSequence2.contains(str)) {
                            if (charSequence.toString().endsWith(str)) {
                                TagGroup.this.getInputTag().setText(charSequence.toString().substring(0, charSequence.toString().length() - 1));
                                TagView tagView = TagView.this;
                                tagView.setText(tagView.getText().toString().trim());
                                if (TagView.this.isInputAvailable()) {
                                    TagView.this.endInput();
                                    if (TagGroup.this.mOnTagChangeListener != null) {
                                        OnTagChangeListener access$1400 = TagGroup.this.mOnTagChangeListener;
                                        TagView tagView2 = TagView.this;
                                        access$1400.onAppend(TagGroup.this, tagView2.getText().toString());
                                    }
                                    TagGroup.this.appendInputTagWithFocus();
                                }
                            } else {
                                TagGroup.this.getInputTag().setText(Pattern.compile("\\s").matcher(charSequence.toString()).replaceAll(""));
                            }
                        }
                        if (charSequence.length() > 24) {
                            TagGroup.this.getInputTag().setText(charSequence.toString().substring(0, charSequence.toString().length() - 1));
                        }
                    }

                    public void afterTextChanged(Editable editable) {
                        Selection.setSelection(editable, editable.length());
                    }
                });
            }
            invalidatePaint();
        }

        public TagView(Context context, int i, CharSequence charSequence, int i2) {
            super(context);
            boolean z = false;
            this.isChecked = false;
            this.isPressed = false;
            this.mBackgroundPaint = new Paint(1);
            this.mCheckedMarkerPaint = new Paint(1);
            this.mLeftCornerRectF = new RectF();
            this.mRightCornerRectF = new RectF();
            this.mHorizontalBlankFillRectF = new RectF();
            this.mVerticalBlankFillRectF = new RectF();
            this.mCheckedMarkerBound = new RectF();
            this.mOutRect = new Rect();
            this.mBorderPath = new Path();
            this.tagBackgroundColor = TagGroup.this.backgroundColor;
            this.tagBorderColor = TagGroup.this.borderColor;
            this.tagPressedBackgroundColor = TagGroup.this.pressedBackgroundColor;
            new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f);
            this.mBorderPaint.setStyle(Style.STROKE);
            this.mBorderPaint.setStrokeWidth(TagGroup.this.borderStrokeWidth);
            this.mBackgroundPaint.setStyle(Style.FILL);
            this.mCheckedMarkerPaint.setStyle(Style.FILL);
            this.mCheckedMarkerPaint.setStrokeWidth(4.0f);
            this.mCheckedMarkerPaint.setColor(TagGroup.this.checkedMarkerColor);
            int color = ContextCompat.getColor(context, i2);
            this.tagBackgroundColor = color;
            this.tagBorderColor = color;
            this.tagPressedBackgroundColor = color;
            setPadding(TagGroup.this.horizontalPadding, TagGroup.this.verticalPadding, TagGroup.this.horizontalPadding, TagGroup.this.verticalPadding);
            setLayoutParams(new LayoutParams(-2, -2));
            setGravity(17);
            setText(charSequence);
            setTextSize(0, TagGroup.this.textSize);
            this.mState = i;
            setClickable(TagGroup.this.isAppendMode);
            setFocusable(i == 2);
            if (i == 2) {
                z = true;
            }
            setFocusableInTouchMode(z);
            MovementMethod movementMethod = null;
            setHint(i == 2 ? TagGroup.this.inputHint : null);
            if (i == 2) {
                movementMethod = ArrowKeyMovementMethod.getInstance();
            }
            setMovementMethod(movementMethod);
            setOnLongClickListener(new OnLongClickListener(this, TagGroup.this, i) {
                final /* synthetic */ int val$state;

                {
                    this.val$state = r3;
                }

                public boolean onLongClick(View view) {
                    return this.val$state != 2;
                }
            });
            setOnClickListener(new OnClickListener(TagGroup.this, charSequence) {
                final /* synthetic */ CharSequence val$text;

                {
                    this.val$text = r3;
                }

                public void onClick(View view) {
                    TagView tagView = (TagView) view;
                    if (TagGroup.this.mOnTagClickListener != null) {
                        TagGroup.this.mOnTagClickListener.onTagClick(this.val$text.toString(), tagView);
                    }
                }
            });
            if (i == 2) {
                setOnEditorActionListener(new OnEditorActionListener(TagGroup.this) {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i != 0 || keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
                            return false;
                        }
                        TagView tagView = TagView.this;
                        tagView.setText(tagView.getText().toString().trim());
                        if (TagView.this.isInputAvailable()) {
                            TagView.this.endInput();
                            if (TagGroup.this.mOnTagChangeListener != null) {
                                OnTagChangeListener access$1400 = TagGroup.this.mOnTagChangeListener;
                                TagView tagView2 = TagView.this;
                                access$1400.onAppend(TagGroup.this, tagView2.getText().toString());
                            }
                            TagGroup.this.appendInputTag();
                        }
                        return true;
                    }
                });
                setOnKeyListener(new OnKeyListener(TagGroup.this) {
                    public boolean onKey(View view, int i, KeyEvent keyEvent) {
                        if (i == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(TagView.this.getText().toString())) {
                            TagView lastNormalTagView = TagGroup.this.getLastNormalTagView();
                            if (lastNormalTagView != null) {
                                if (lastNormalTagView.isChecked) {
                                    TagGroup.this.removeView(lastNormalTagView);
                                    if (TagGroup.this.mOnTagChangeListener != null) {
                                        TagGroup.this.mOnTagChangeListener.onDelete(TagGroup.this, lastNormalTagView.getText().toString());
                                    }
                                } else {
                                    TagView checkedTag = TagGroup.this.getCheckedTag();
                                    if (checkedTag != null) {
                                        checkedTag.setChecked(false);
                                    }
                                    lastNormalTagView.setChecked(true);
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                });
                addTextChangedListener(new TextWatcher(TagGroup.this) {
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        TagView checkedTag = TagGroup.this.getCheckedTag();
                        if (checkedTag != null) {
                            checkedTag.setChecked(false);
                        }
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String charSequence2 = charSequence.toString();
                        String str = ServerProtocol.AUTHORIZATION_HEADER_DELIMITER;
                        if (charSequence2.contains(str)) {
                            if (charSequence.toString().endsWith(str)) {
                                TagGroup.this.getInputTag().setText(charSequence.toString().substring(0, charSequence.toString().length() - 1));
                                TagView tagView = TagView.this;
                                tagView.setText(tagView.getText().toString().trim());
                                if (TagView.this.isInputAvailable()) {
                                    TagView.this.endInput();
                                    if (TagGroup.this.mOnTagChangeListener != null) {
                                        OnTagChangeListener access$1400 = TagGroup.this.mOnTagChangeListener;
                                        TagView tagView2 = TagView.this;
                                        access$1400.onAppend(TagGroup.this, tagView2.getText().toString());
                                    }
                                    TagGroup.this.appendInputTagWithFocus();
                                }
                            } else {
                                TagGroup.this.getInputTag().setText(Pattern.compile("\\s").matcher(charSequence.toString()).replaceAll(""));
                            }
                        }
                        if (charSequence.length() > 24) {
                            TagGroup.this.getInputTag().setText(charSequence.toString().substring(0, charSequence.toString().length() - 1));
                        }
                    }

                    public void afterTextChanged(Editable editable) {
                        Selection.setSelection(editable, editable.length());
                    }
                });
            }
            invalidatePaint();
        }

        public void setChecked(boolean z) {
            int i;
            this.isChecked = z;
            int access$1000 = TagGroup.this.horizontalPadding;
            int access$1100 = TagGroup.this.verticalPadding;
            if (this.isChecked) {
                i = (int) (((float) TagGroup.this.horizontalPadding) + (((float) getHeight()) / 2.5f) + 3.0f);
            } else {
                i = TagGroup.this.horizontalPadding;
            }
            setPadding(access$1000, access$1100, i, TagGroup.this.verticalPadding);
            invalidatePaint();
        }

        public void endInput() {
            setFocusable(false);
            setFocusableInTouchMode(false);
            setHint(null);
            setMovementMethod(null);
            this.mState = 1;
            invalidatePaint();
            requestLayout();
        }

        public boolean isInputAvailable() {
            return getText() != null && getText().length() > 0;
        }

        private void invalidatePaint() {
            if (!TagGroup.this.isAppendMode) {
                this.mBorderPaint.setColor(this.tagBorderColor);
                this.mBackgroundPaint.setColor(this.tagBackgroundColor);
                setTextColor(TagGroup.this.textColor);
            } else if (this.mState == 2) {
                this.mBorderPaint.setColor(TagGroup.this.dashBorderColor);
                this.mBorderPaint.setPathEffect(null);
                this.mBackgroundPaint.setColor(this.tagBackgroundColor);
                setHintTextColor(TagGroup.this.inputHintColor);
                setTextColor(TagGroup.this.inputTextColor);
            } else {
                this.mBorderPaint.setPathEffect(null);
                this.mBorderPaint.setColor(TagGroup.this.checkedBorderColor);
                this.mBackgroundPaint.setColor(TagGroup.this.checkedBackgroundColor);
                setTextColor(TagGroup.this.checkedTextColor);
            }
            if (this.isPressed) {
                this.mBackgroundPaint.setColor(this.tagPressedBackgroundColor);
            }
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.mLeftCornerRectF, -180.0f, 90.0f, true, this.mBackgroundPaint);
            Canvas canvas3 = canvas;
            canvas3.drawArc(this.mLeftCornerRectF, -270.0f, 90.0f, true, this.mBackgroundPaint);
            canvas2.drawArc(this.mRightCornerRectF, -90.0f, 90.0f, true, this.mBackgroundPaint);
            canvas3.drawArc(this.mRightCornerRectF, 0.0f, 90.0f, true, this.mBackgroundPaint);
            canvas.drawRect(this.mHorizontalBlankFillRectF, this.mBackgroundPaint);
            canvas.drawRect(this.mVerticalBlankFillRectF, this.mBackgroundPaint);
            if (this.isChecked) {
                canvas.save();
                canvas.rotate(45.0f, this.mCheckedMarkerBound.centerX(), this.mCheckedMarkerBound.centerY());
                RectF rectF = this.mCheckedMarkerBound;
                float f = rectF.left;
                float centerY = rectF.centerY();
                RectF rectF2 = this.mCheckedMarkerBound;
                Canvas canvas4 = canvas;
                canvas4.drawLine(f, centerY, rectF2.right, rectF2.centerY(), this.mCheckedMarkerPaint);
                float centerX = this.mCheckedMarkerBound.centerX();
                RectF rectF3 = this.mCheckedMarkerBound;
                canvas4.drawLine(centerX, rectF3.top, rectF3.centerX(), this.mCheckedMarkerBound.bottom, this.mCheckedMarkerPaint);
                canvas.restore();
            }
            canvas.drawPath(this.mBorderPath, this.mBorderPaint);
            super.onDraw(canvas);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            int access$800 = (int) TagGroup.this.borderStrokeWidth;
            int access$8002 = (int) TagGroup.this.borderStrokeWidth;
            int access$8003 = (int) (((float) (i + access$800)) - (TagGroup.this.borderStrokeWidth * 2.0f));
            int access$8004 = (int) (((float) (access$8002 + i2)) - (TagGroup.this.borderStrokeWidth * 2.0f));
            int i5 = access$8004 - access$8002;
            float f = (float) access$800;
            float f2 = (float) access$8002;
            float f3 = (float) (access$8002 + i5);
            this.mLeftCornerRectF.set(f, f2, (float) (access$800 + i5), f3);
            float f4 = (float) access$8003;
            this.mRightCornerRectF.set((float) (access$8003 - i5), f2, f4, f3);
            this.mBorderPath.reset();
            this.mBorderPath.addArc(this.mLeftCornerRectF, -180.0f, 90.0f);
            this.mBorderPath.addArc(this.mLeftCornerRectF, -270.0f, 90.0f);
            this.mBorderPath.addArc(this.mRightCornerRectF, -90.0f, 90.0f);
            this.mBorderPath.addArc(this.mRightCornerRectF, 0.0f, 90.0f);
            float f5 = (float) i5;
            int i6 = (int) (f5 / 2.0f);
            float f6 = (float) (access$800 + i6);
            this.mBorderPath.moveTo(f6, f2);
            float f7 = (float) (access$8003 - i6);
            this.mBorderPath.lineTo(f7, f2);
            float f8 = (float) access$8004;
            this.mBorderPath.moveTo(f6, f8);
            this.mBorderPath.lineTo(f7, f8);
            float f9 = (float) (access$8002 + i6);
            this.mBorderPath.moveTo(f, f9);
            float f10 = (float) (access$8004 - i6);
            this.mBorderPath.lineTo(f, f10);
            this.mBorderPath.moveTo(f4, f9);
            this.mBorderPath.lineTo(f4, f10);
            this.mHorizontalBlankFillRectF.set(f, f9, f4, f10);
            this.mVerticalBlankFillRectF.set(f6, f2, f7, f8);
            int i7 = (int) (((float) i2) / 2.5f);
            int i8 = i5 / 2;
            int i9 = i7 / 2;
            this.mCheckedMarkerBound.set((float) (((access$8003 - i7) - TagGroup.this.horizontalPadding) + 3), (float) ((access$8002 + i8) - i9), (float) ((access$8003 - TagGroup.this.horizontalPadding) + 3), (float) ((access$8004 - i8) + i9));
            if (this.isChecked) {
                setPadding(TagGroup.this.horizontalPadding, TagGroup.this.verticalPadding, (int) (((float) TagGroup.this.horizontalPadding) + (f5 / 2.5f) + 3.0f), TagGroup.this.verticalPadding);
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.mState == 2) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                getDrawingRect(this.mOutRect);
                this.isPressed = true;
                invalidatePaint();
                invalidate();
            } else if (action == 1) {
                this.isPressed = false;
                invalidatePaint();
                invalidate();
            } else if (action == 2 && !this.mOutRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.isPressed = false;
                invalidatePaint();
                invalidate();
            }
            return super.onTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            if (this.mState != 2) {
                return;
            }
            if (z) {
                this.mBackgroundPaint.setColor(0);
                setHintTextColor(ContextCompat.getColor(getContext(), 17170445));
                return;
            }
            this.mBackgroundPaint.setColor(0);
            setHintTextColor(TagGroup.this.inputHintColor);
            TagGroup.this.submitTag();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new ZanyInputConnection(this, super.onCreateInputConnection(editorInfo), true);
        }
    }

    public TagGroup(Context context) {
        this(context, null);
    }

    public TagGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130969201);
    }

    /* JADX INFO: finally extract failed */
    public TagGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalTagClickListener = new InternalTagClickListener();
        float dp2px = dp2px(0.5f);
        float sp2px = sp2px(13.0f);
        float dp2px2 = dp2px(8.0f);
        float dp2px3 = dp2px(4.0f);
        float dp2px4 = dp2px(12.0f);
        float dp2px5 = dp2px(3.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TagGroup, i, 2131820795);
        try {
            this.isAppendMode = obtainStyledAttributes.getBoolean(13, false);
            this.inputHint = obtainStyledAttributes.getText(10);
            this.borderColor = obtainStyledAttributes.getColor(1, Color.rgb(73, 193, 32));
            this.textColor = obtainStyledAttributes.getColor(15, Color.rgb(73, 193, 32));
            this.backgroundColor = obtainStyledAttributes.getColor(0, -1);
            this.dashBorderColor = obtainStyledAttributes.getColor(7, Color.rgb(170, 170, 170));
            this.inputHintColor = obtainStyledAttributes.getColor(11, Color.argb(128, 0, 0, 0));
            this.inputTextColor = obtainStyledAttributes.getColor(12, Color.argb(222, 0, 0, 0));
            this.checkedBorderColor = obtainStyledAttributes.getColor(4, Color.rgb(73, 193, 32));
            this.checkedTextColor = obtainStyledAttributes.getColor(6, -1);
            this.checkedMarkerColor = obtainStyledAttributes.getColor(5, -1);
            this.checkedBackgroundColor = obtainStyledAttributes.getColor(3, Color.rgb(73, 193, 32));
            this.pressedBackgroundColor = obtainStyledAttributes.getColor(14, Color.rgb(237, 237, 237));
            this.borderStrokeWidth = obtainStyledAttributes.getDimension(2, dp2px);
            this.textSize = obtainStyledAttributes.getDimension(16, sp2px);
            this.horizontalSpacing = (int) obtainStyledAttributes.getDimension(9, dp2px2);
            this.verticalSpacing = (int) obtainStyledAttributes.getDimension(18, dp2px3);
            this.horizontalPadding = (int) obtainStyledAttributes.getDimension(8, dp2px4);
            this.verticalPadding = (int) obtainStyledAttributes.getDimension(17, dp2px5);
            obtainStyledAttributes.recycle();
            if (this.isAppendMode) {
                appendInputTag();
                setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        TagGroup.this.submitTag();
                    }
                });
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void submitTag() {
        TagView inputTag = getInputTag();
        if (inputTag != null) {
            inputTag.setText(inputTag.getText().toString().trim());
            if (inputTag.isInputAvailable()) {
                inputTag.endInput();
                OnTagChangeListener onTagChangeListener = this.mOnTagChangeListener;
                if (onTagChangeListener != null) {
                    onTagChangeListener.onAppend(this, inputTag.getText().toString());
                }
                appendInputTag();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                int i8 = i6 + measuredWidth;
                if (i8 > size) {
                    i3 += i4 + this.verticalSpacing;
                    i5++;
                    i8 = measuredWidth;
                } else {
                    measuredHeight = Math.max(i4, measuredHeight);
                }
                i6 = i8 + this.horizontalSpacing;
                i4 = measuredHeight;
            }
        }
        int paddingTop = getPaddingTop() + getPaddingBottom() + i3 + i4;
        int paddingLeft = i5 == 0 ? getPaddingLeft() + getPaddingRight() + i6 : size;
        if (mode == 1073741824) {
            paddingLeft = size;
        }
        if (mode2 == 1073741824) {
            paddingTop = size2;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i5 = paddingTop;
        int i6 = 0;
        int i7 = paddingLeft;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                if (i7 + measuredWidth > paddingRight) {
                    i5 += i6 + this.verticalSpacing;
                    i7 = paddingLeft;
                    i6 = measuredHeight;
                } else {
                    i6 = Math.max(i6, measuredHeight);
                }
                childAt.layout(i7, i5, i7 + measuredWidth, measuredHeight + i5);
                i7 += measuredWidth + this.horizontalSpacing;
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.tags = getTags();
        savedState.checkedPosition = getCheckedTagIndex();
        if (getInputTag() != null) {
            savedState.input = getInputTag().getText().toString();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setTags(savedState.tags);
        TagView tagAt = getTagAt(savedState.checkedPosition);
        if (tagAt != null) {
            tagAt.setChecked(true);
        }
        if (getInputTag() != null) {
            getInputTag().setText(savedState.input);
        }
    }

    /* access modifiers changed from: protected */
    public TagView getInputTag() {
        if (this.isAppendMode) {
            TagView tagAt = getTagAt(getChildCount() - 1);
            if (tagAt == null || tagAt.mState != 2) {
                return null;
            }
            return tagAt;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public TagView getLastNormalTagView() {
        return getTagAt(this.isAppendMode ? getChildCount() - 2 : getChildCount() - 1);
    }

    public String[] getTags() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            TagView tagAt = getTagAt(i);
            if (tagAt.mState == 1) {
                arrayList.add(tagAt.getText().toString());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void setTags(String... strArr) {
        removeAllViews();
        for (String appendTag : strArr) {
            appendTag(appendTag);
        }
        if (this.isAppendMode) {
            appendInputTag();
        }
    }

    public ArrayList<TagView> getTagsview() {
        int childCount = getChildCount();
        ArrayList<TagView> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            arrayList.add(getTagAt(i));
        }
        return arrayList;
    }

    public void setTags(List<String> list) {
        setTags((String[]) list.toArray(new String[list.size()]));
    }

    public TagView getTagAt(int i) {
        return (TagView) getChildAt(i);
    }

    /* access modifiers changed from: protected */
    public TagView getCheckedTag() {
        int checkedTagIndex = getCheckedTagIndex();
        if (checkedTagIndex != -1) {
            return getTagAt(checkedTagIndex);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int getCheckedTagIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getTagAt(i).isChecked) {
                return i;
            }
        }
        return -1;
    }

    public void setOnTagChangeListener(OnTagChangeListener onTagChangeListener) {
        this.mOnTagChangeListener = onTagChangeListener;
    }

    /* access modifiers changed from: protected */
    public void appendInputTag() {
        appendInputTag(null);
    }

    /* access modifiers changed from: protected */
    public void appendInputTag(String str) {
        if (getInputTag() == null) {
            TagView tagView = new TagView(getContext(), 2, str);
            tagView.setOnClickListener(this.mInternalTagClickListener);
            addView(tagView);
        }
    }

    /* access modifiers changed from: protected */
    public void appendInputTagWithFocus() {
        TagView inputTag = getInputTag();
        if (inputTag != null) {
            inputTag.requestFocus();
            return;
        }
        TagView tagView = new TagView(getContext(), 2, null);
        tagView.setOnClickListener(this.mInternalTagClickListener);
        addView(tagView);
        tagView.requestFocus();
    }

    /* access modifiers changed from: protected */
    public void appendTag(CharSequence charSequence) {
        TagView tagView = new TagView(getContext(), 1, charSequence);
        tagView.setOnClickListener(this.mInternalTagClickListener);
        addView(tagView);
    }

    public float dp2px(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public float sp2px(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.mOnTagClickListener = onTagClickListener;
    }

    /* access modifiers changed from: protected */
    public void deleteTag(TagView tagView) {
        removeView(tagView);
        OnTagChangeListener onTagChangeListener = this.mOnTagChangeListener;
        if (onTagChangeListener != null) {
            onTagChangeListener.onDelete(this, tagView.getText().toString());
        }
    }
}
