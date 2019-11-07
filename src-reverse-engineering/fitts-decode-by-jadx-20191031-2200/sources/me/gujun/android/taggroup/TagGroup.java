package me.gujun.android.taggroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
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
import java.util.ArrayList;
import java.util.List;

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
    private final int default_border_color;
    private final float default_border_stroke_width;
    private final int default_checked_background_color;
    private final int default_checked_border_color;
    private final int default_dash_border_color;
    private final float default_horizontal_padding;
    private final float default_horizontal_spacing;
    private final int default_input_hint_color;
    private final int default_input_text_color;
    private final int default_pressed_background_color;
    private final int default_text_color;
    private final float default_text_size;
    private final float default_vertical_padding;
    private final float default_vertical_spacing;
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

    class InternalTagClickListener implements OnClickListener {
        InternalTagClickListener() {
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
                TagGroup.this.mOnTagClickListener.onTagClick(tagView.getText().toString());
            }
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public interface OnTagChangeListener {
        void onAppend(TagGroup tagGroup, String str);

        void onDelete(TagGroup tagGroup, String str);
    }

    public interface OnTagClickListener {
        void onTagClick(String str);
    }

    static class SavedState extends BaseSavedState {
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

        public SavedState(Parcel parcel) {
            super(parcel);
            this.tagCount = parcel.readInt();
            this.tags = new String[this.tagCount];
            parcel.readStringArray(this.tags);
            this.checkedPosition = parcel.readInt();
            this.input = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
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

    class TagView extends TextView {
        public static final int STATE_INPUT = 2;
        public static final int STATE_NORMAL = 1;
        /* access modifiers changed from: private */
        public boolean isChecked = false;
        private boolean isPressed = false;
        private Paint mBackgroundPaint = new Paint(1);
        private Paint mBorderPaint = new Paint(1);
        private Path mBorderPath = new Path();
        private RectF mCheckedMarkerBound = new RectF();
        private Paint mCheckedMarkerPaint = new Paint(1);
        private RectF mHorizontalBlankFillRectF = new RectF();
        private RectF mLeftCornerRectF = new RectF();
        private Rect mOutRect = new Rect();
        private PathEffect mPathEffect = new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f);
        private RectF mRightCornerRectF = new RectF();
        /* access modifiers changed from: private */
        public int mState;
        private RectF mVerticalBlankFillRectF = new RectF();

        private class ZanyInputConnection extends InputConnectionWrapper {
            public ZanyInputConnection(TagView tagView, InputConnection inputConnection, boolean z) {
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
                requestFocus();
                setOnEditorActionListener(new OnEditorActionListener(TagGroup.this) {
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i != 0 || keyEvent == null || keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 0) {
                            return false;
                        }
                        if (TagView.this.isInputAvailable()) {
                            TagView.this.endInput();
                            if (TagGroup.this.mOnTagChangeListener != null) {
                                OnTagChangeListener access$1000 = TagGroup.this.mOnTagChangeListener;
                                TagView tagView = TagView.this;
                                access$1000.onAppend(TagGroup.this, tagView.getText().toString());
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
                    public void afterTextChanged(Editable editable) {
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        TagView checkedTag = TagGroup.this.getCheckedTag();
                        if (checkedTag != null) {
                            checkedTag.setChecked(false);
                        }
                    }
                });
            }
            invalidatePaint();
        }

        public void setChecked(boolean z) {
            int i;
            this.isChecked = z;
            int access$600 = TagGroup.this.horizontalPadding;
            int access$700 = TagGroup.this.verticalPadding;
            if (this.isChecked) {
                i = (int) (((float) TagGroup.this.horizontalPadding) + (((float) getHeight()) / 2.5f) + 3.0f);
            } else {
                i = TagGroup.this.horizontalPadding;
            }
            setPadding(access$600, access$700, i, TagGroup.this.verticalPadding);
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
                this.mBorderPaint.setColor(TagGroup.this.borderColor);
                this.mBackgroundPaint.setColor(TagGroup.this.backgroundColor);
                setTextColor(TagGroup.this.textColor);
            } else if (this.mState == 2) {
                this.mBorderPaint.setColor(TagGroup.this.dashBorderColor);
                this.mBorderPaint.setPathEffect(this.mPathEffect);
                this.mBackgroundPaint.setColor(TagGroup.this.backgroundColor);
                setHintTextColor(TagGroup.this.inputHintColor);
                setTextColor(TagGroup.this.inputTextColor);
            } else {
                this.mBorderPaint.setPathEffect(null);
                if (this.isChecked) {
                    this.mBorderPaint.setColor(TagGroup.this.checkedBorderColor);
                    this.mBackgroundPaint.setColor(TagGroup.this.checkedBackgroundColor);
                    setTextColor(TagGroup.this.checkedTextColor);
                } else {
                    this.mBorderPaint.setColor(TagGroup.this.borderColor);
                    this.mBackgroundPaint.setColor(TagGroup.this.backgroundColor);
                    setTextColor(TagGroup.this.textColor);
                }
            }
            if (this.isPressed) {
                this.mBackgroundPaint.setColor(TagGroup.this.pressedBackgroundColor);
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
            int access$400 = (int) TagGroup.this.borderStrokeWidth;
            int access$4002 = (int) TagGroup.this.borderStrokeWidth;
            int access$4003 = (int) (((float) (i + access$400)) - (TagGroup.this.borderStrokeWidth * 2.0f));
            int access$4004 = (int) (((float) (access$4002 + i2)) - (TagGroup.this.borderStrokeWidth * 2.0f));
            int i5 = access$4004 - access$4002;
            float f = (float) access$400;
            float f2 = (float) access$4002;
            float f3 = (float) (access$4002 + i5);
            this.mLeftCornerRectF.set(f, f2, (float) (access$400 + i5), f3);
            float f4 = (float) access$4003;
            this.mRightCornerRectF.set((float) (access$4003 - i5), f2, f4, f3);
            this.mBorderPath.reset();
            this.mBorderPath.addArc(this.mLeftCornerRectF, -180.0f, 90.0f);
            this.mBorderPath.addArc(this.mLeftCornerRectF, -270.0f, 90.0f);
            this.mBorderPath.addArc(this.mRightCornerRectF, -90.0f, 90.0f);
            this.mBorderPath.addArc(this.mRightCornerRectF, 0.0f, 90.0f);
            float f5 = (float) i5;
            int i6 = (int) (f5 / 2.0f);
            float f6 = (float) (access$400 + i6);
            this.mBorderPath.moveTo(f6, f2);
            float f7 = (float) (access$4003 - i6);
            this.mBorderPath.lineTo(f7, f2);
            float f8 = (float) access$4004;
            this.mBorderPath.moveTo(f6, f8);
            this.mBorderPath.lineTo(f7, f8);
            float f9 = (float) (access$4002 + i6);
            this.mBorderPath.moveTo(f, f9);
            float f10 = (float) (access$4004 - i6);
            this.mBorderPath.lineTo(f, f10);
            this.mBorderPath.moveTo(f4, f9);
            this.mBorderPath.lineTo(f4, f10);
            this.mHorizontalBlankFillRectF.set(f, f9, f4, f10);
            this.mVerticalBlankFillRectF.set(f6, f2, f7, f8);
            int i7 = (int) (((float) i2) / 2.5f);
            int i8 = i5 / 2;
            int i9 = i7 / 2;
            this.mCheckedMarkerBound.set((float) (((access$4003 - i7) - TagGroup.this.horizontalPadding) + 3), (float) ((access$4002 + i8) - i9), (float) ((access$4003 - TagGroup.this.horizontalPadding) + 3), (float) ((access$4004 - i8) + i9));
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

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new ZanyInputConnection(this, super.onCreateInputConnection(editorInfo), true);
        }
    }

    public TagGroup(Context context) {
        this(context, null);
    }

    public TagGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tagGroupStyle);
    }

    /* JADX INFO: finally extract failed */
    public TagGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.default_border_color = Color.rgb(73, 193, 32);
        this.default_text_color = Color.rgb(73, 193, 32);
        this.default_dash_border_color = Color.rgb(170, 170, 170);
        this.default_input_hint_color = Color.argb(128, 0, 0, 0);
        this.default_input_text_color = Color.argb(222, 0, 0, 0);
        this.default_checked_border_color = Color.rgb(73, 193, 32);
        this.default_checked_background_color = Color.rgb(73, 193, 32);
        this.default_pressed_background_color = Color.rgb(237, 237, 237);
        this.mInternalTagClickListener = new InternalTagClickListener();
        this.default_border_stroke_width = dp2px(0.5f);
        this.default_text_size = sp2px(13.0f);
        this.default_horizontal_spacing = dp2px(8.0f);
        this.default_vertical_spacing = dp2px(4.0f);
        this.default_horizontal_padding = dp2px(12.0f);
        this.default_vertical_padding = dp2px(3.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TagGroup, i, R$style.TagGroup);
        try {
            this.isAppendMode = obtainStyledAttributes.getBoolean(R$styleable.TagGroup_atg_isAppendMode, false);
            this.inputHint = obtainStyledAttributes.getText(R$styleable.TagGroup_atg_inputHint);
            this.borderColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_borderColor, this.default_border_color);
            this.textColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_textColor, this.default_text_color);
            this.backgroundColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_backgroundColor, -1);
            this.dashBorderColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_dashBorderColor, this.default_dash_border_color);
            this.inputHintColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_inputHintColor, this.default_input_hint_color);
            this.inputTextColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_inputTextColor, this.default_input_text_color);
            this.checkedBorderColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_checkedBorderColor, this.default_checked_border_color);
            this.checkedTextColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_checkedTextColor, -1);
            this.checkedMarkerColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_checkedMarkerColor, -1);
            this.checkedBackgroundColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_checkedBackgroundColor, this.default_checked_background_color);
            this.pressedBackgroundColor = obtainStyledAttributes.getColor(R$styleable.TagGroup_atg_pressedBackgroundColor, this.default_pressed_background_color);
            this.borderStrokeWidth = obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_borderStrokeWidth, this.default_border_stroke_width);
            this.textSize = obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_textSize, this.default_text_size);
            this.horizontalSpacing = (int) obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_horizontalSpacing, this.default_horizontal_spacing);
            this.verticalSpacing = (int) obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_verticalSpacing, this.default_vertical_spacing);
            this.horizontalPadding = (int) obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_horizontalPadding, this.default_horizontal_padding);
            this.verticalPadding = (int) obtainStyledAttributes.getDimension(R$styleable.TagGroup_atg_verticalPadding, this.default_vertical_padding);
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
        if (inputTag != null && inputTag.isInputAvailable()) {
            inputTag.endInput();
            OnTagChangeListener onTagChangeListener = this.mOnTagChangeListener;
            if (onTagChangeListener != null) {
                onTagChangeListener.onAppend(this, inputTag.getText().toString());
            }
            appendInputTag();
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
        getPaddingBottom();
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

    public String getInputTagText() {
        TagView inputTag = getInputTag();
        if (inputTag != null) {
            return inputTag.getText().toString();
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

    public void setTags(List<String> list) {
        setTags((String[]) list.toArray(new String[list.size()]));
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

    /* access modifiers changed from: protected */
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
            return;
        }
        throw new IllegalStateException("Already has a INPUT tag in group.");
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
