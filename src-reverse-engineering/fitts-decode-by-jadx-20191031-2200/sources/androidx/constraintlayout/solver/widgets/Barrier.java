package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import java.util.ArrayList;

public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private ArrayList<ResolutionAnchor> mNodes = new ArrayList<>(4);

    public boolean allowedInBarrier() {
        return true;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mAllowsGoneWidget = z;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.mNodes.clear();
    }

    public void analyze(int i) {
        ResolutionAnchor resolutionAnchor;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && ((ConstraintWidgetContainer) constraintWidget).optimizeFor(2)) {
            int i2 = this.mBarrierType;
            if (i2 == 0) {
                resolutionAnchor = this.mLeft.getResolutionNode();
            } else if (i2 == 1) {
                resolutionAnchor = this.mRight.getResolutionNode();
            } else if (i2 == 2) {
                resolutionAnchor = this.mTop.getResolutionNode();
            } else if (i2 == 3) {
                resolutionAnchor = this.mBottom.getResolutionNode();
            } else {
                return;
            }
            resolutionAnchor.setType(5);
            int i3 = this.mBarrierType;
            if (i3 == 0 || i3 == 1) {
                this.mTop.getResolutionNode().resolve(null, 0.0f);
                this.mBottom.getResolutionNode().resolve(null, 0.0f);
            } else {
                this.mLeft.getResolutionNode().resolve(null, 0.0f);
                this.mRight.getResolutionNode().resolve(null, 0.0f);
            }
            this.mNodes.clear();
            for (int i4 = 0; i4 < this.mWidgetsCount; i4++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i4];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    int i5 = this.mBarrierType;
                    ResolutionNode resolutionNode = i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? null : constraintWidget2.mBottom.getResolutionNode() : constraintWidget2.mTop.getResolutionNode() : constraintWidget2.mRight.getResolutionNode() : constraintWidget2.mLeft.getResolutionNode();
                    if (resolutionNode != null) {
                        this.mNodes.add(resolutionNode);
                        resolutionNode.addDependent(resolutionAnchor);
                    }
                }
            }
        }
    }

    public void resolve() {
        ResolutionAnchor resolutionAnchor;
        float f;
        ResolutionAnchor resolutionAnchor2;
        int i = this.mBarrierType;
        float f2 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                resolutionAnchor = this.mRight.getResolutionNode();
            } else if (i == 2) {
                resolutionAnchor = this.mTop.getResolutionNode();
            } else if (i == 3) {
                resolutionAnchor = this.mBottom.getResolutionNode();
            } else {
                return;
            }
            f2 = 0.0f;
        } else {
            resolutionAnchor = this.mLeft.getResolutionNode();
        }
        int size = this.mNodes.size();
        ResolutionAnchor resolutionAnchor3 = null;
        int i2 = 0;
        while (i2 < size) {
            ResolutionAnchor resolutionAnchor4 = (ResolutionAnchor) this.mNodes.get(i2);
            if (resolutionAnchor4.state == 1) {
                int i3 = this.mBarrierType;
                if (i3 == 0 || i3 == 2) {
                    f = resolutionAnchor4.resolvedOffset;
                    if (f < f2) {
                        resolutionAnchor2 = resolutionAnchor4.resolvedTarget;
                    } else {
                        i2++;
                    }
                } else {
                    f = resolutionAnchor4.resolvedOffset;
                    if (f > f2) {
                        resolutionAnchor2 = resolutionAnchor4.resolvedTarget;
                    } else {
                        i2++;
                    }
                }
                resolutionAnchor3 = resolutionAnchor2;
                f2 = f;
                i2++;
            } else {
                return;
            }
        }
        if (LinearSystem.getMetrics() != null) {
            Metrics metrics = LinearSystem.getMetrics();
            metrics.barrierConnectionResolved++;
        }
        resolutionAnchor.resolvedTarget = resolutionAnchor3;
        resolutionAnchor.resolvedOffset = f2;
        resolutionAnchor.didResolve();
        int i4 = this.mBarrierType;
        if (i4 == 0) {
            this.mRight.getResolutionNode().resolve(resolutionAnchor3, f2);
        } else if (i4 == 1) {
            this.mLeft.getResolutionNode().resolve(resolutionAnchor3, f2);
        } else if (i4 == 2) {
            this.mBottom.getResolutionNode().resolve(resolutionAnchor3, f2);
        } else if (i4 == 3) {
            this.mTop.getResolutionNode().resolve(resolutionAnchor3, f2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r11) {
        /*
            r10 = this;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r10.mLeft
            r2 = 0
            r0[r2] = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r10.mTop
            r3 = 2
            r0[r3] = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r10.mRight
            r4 = 1
            r0[r4] = r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r10.mBottom
            r5 = 3
            r0[r5] = r1
            r0 = 0
        L_0x0017:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            int r6 = r1.length
            if (r0 >= r6) goto L_0x0029
            r6 = r1[r0]
            r1 = r1[r0]
            androidx.constraintlayout.solver.SolverVariable r1 = r11.createObjectVariable(r1)
            r6.mSolverVariable = r1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x0029:
            int r0 = r10.mBarrierType
            if (r0 < 0) goto L_0x013a
            r6 = 4
            if (r0 >= r6) goto L_0x013a
            r0 = r1[r0]
            r1 = 0
        L_0x0033:
            int r6 = r10.mWidgetsCount
            if (r1 >= r6) goto L_0x0068
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r6 = r10.mWidgets
            r6 = r6[r1]
            boolean r7 = r10.mAllowsGoneWidget
            if (r7 != 0) goto L_0x0046
            boolean r7 = r6.allowedInBarrier()
            if (r7 != 0) goto L_0x0046
            goto L_0x0065
        L_0x0046:
            int r7 = r10.mBarrierType
            if (r7 == 0) goto L_0x004c
            if (r7 != r4) goto L_0x0056
        L_0x004c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r6.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r8) goto L_0x0056
        L_0x0054:
            r1 = 1
            goto L_0x0069
        L_0x0056:
            int r7 = r10.mBarrierType
            if (r7 == r3) goto L_0x005c
            if (r7 != r5) goto L_0x0065
        L_0x005c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0065
            goto L_0x0054
        L_0x0065:
            int r1 = r1 + 1
            goto L_0x0033
        L_0x0068:
            r1 = 0
        L_0x0069:
            int r6 = r10.mBarrierType
            if (r6 == 0) goto L_0x007d
            if (r6 != r4) goto L_0x0070
            goto L_0x007d
        L_0x0070:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r10.getParent()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r7) goto L_0x008a
            goto L_0x0089
        L_0x007d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r10.getParent()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r6.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r6 != r7) goto L_0x008a
        L_0x0089:
            r1 = 0
        L_0x008a:
            r6 = 0
        L_0x008b:
            int r7 = r10.mWidgetsCount
            if (r6 >= r7) goto L_0x00c3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = r10.mWidgets
            r7 = r7[r6]
            boolean r8 = r10.mAllowsGoneWidget
            if (r8 != 0) goto L_0x009e
            boolean r8 = r7.allowedInBarrier()
            if (r8 != 0) goto L_0x009e
            goto L_0x00c0
        L_0x009e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r7.mListAnchors
            int r9 = r10.mBarrierType
            r8 = r8[r9]
            androidx.constraintlayout.solver.SolverVariable r8 = r11.createObjectVariable(r8)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r7.mListAnchors
            int r9 = r10.mBarrierType
            r7 = r7[r9]
            r7.mSolverVariable = r8
            if (r9 == 0) goto L_0x00bb
            if (r9 != r3) goto L_0x00b5
            goto L_0x00bb
        L_0x00b5:
            androidx.constraintlayout.solver.SolverVariable r7 = r0.mSolverVariable
            r11.addGreaterBarrier(r7, r8, r1)
            goto L_0x00c0
        L_0x00bb:
            androidx.constraintlayout.solver.SolverVariable r7 = r0.mSolverVariable
            r11.addLowerBarrier(r7, r8, r1)
        L_0x00c0:
            int r6 = r6 + 1
            goto L_0x008b
        L_0x00c3:
            int r0 = r10.mBarrierType
            r6 = 5
            r7 = 6
            if (r0 != 0) goto L_0x00e4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mRight
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r10.mLeft
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r11.addEquality(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mLeft
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r10.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mRight
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r11.addEquality(r0, r1, r2, r6)
            goto L_0x013a
        L_0x00e4:
            if (r0 != r4) goto L_0x0101
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mLeft
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r10.mRight
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r11.addEquality(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mLeft
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r10.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mLeft
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r11.addEquality(r0, r1, r2, r6)
            goto L_0x013a
        L_0x0101:
            if (r0 != r3) goto L_0x011e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r10.mTop
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r11.addEquality(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mTop
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r10.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r11.addEquality(r0, r1, r2, r6)
            goto L_0x013a
        L_0x011e:
            if (r0 != r5) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mTop
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r10.mBottom
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r11.addEquality(r0, r3, r2, r7)
            if (r1 != 0) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r10.mTop
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r10.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTop
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            r11.addEquality(r0, r1, r2, r6)
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Barrier.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }
}
