package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        if (constraintWidgetContainer.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.mLeft.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.mRight.mMargin;
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.mRight;
            constraintAnchor2.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor2);
            linearSystem.addEquality(constraintWidget.mLeft.mSolverVariable, i);
            linearSystem.addEquality(constraintWidget.mRight.mSolverVariable, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i, width);
        }
        if (constraintWidgetContainer.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.mTop.mMargin;
            int height = constraintWidgetContainer.getHeight() - constraintWidget.mBottom.mMargin;
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            constraintAnchor3.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.mBottom;
            constraintAnchor4.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor4);
            linearSystem.addEquality(constraintWidget.mTop.mSolverVariable, i2);
            linearSystem.addEquality(constraintWidget.mBottom.mSolverVariable, height);
            if (constraintWidget.mBaselineDistance > 0 || constraintWidget.getVisibility() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.mBaseline;
                constraintAnchor5.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor5);
                linearSystem.addEquality(constraintWidget.mBaseline.mSolverVariable, constraintWidget.mBaselineDistance + i2);
            }
            constraintWidget.mVerticalResolution = 2;
            constraintWidget.setVerticalDimension(i2, height);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget r5, int r6) {
        /*
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r5.mListDimensionBehaviors
            r1 = r0[r6]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            float r1 = r5.mDimensionRatio
            r2 = 0
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x001d
            if (r6 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            r5 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x001c
        L_0x001c:
            return r3
        L_0x001d:
            if (r6 != 0) goto L_0x002d
            int r6 = r5.mMatchConstraintDefaultWidth
            if (r6 == 0) goto L_0x0024
            return r3
        L_0x0024:
            int r6 = r5.mMatchConstraintMinWidth
            if (r6 != 0) goto L_0x002c
            int r5 = r5.mMatchConstraintMaxWidth
            if (r5 == 0) goto L_0x003b
        L_0x002c:
            return r3
        L_0x002d:
            int r6 = r5.mMatchConstraintDefaultHeight
            if (r6 == 0) goto L_0x0032
            return r3
        L_0x0032:
            int r6 = r5.mMatchConstraintMinHeight
            if (r6 != 0) goto L_0x003c
            int r5 = r5.mMatchConstraintMaxHeight
            if (r5 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            return r4
        L_0x003c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.optimizableMatchConstraint(androidx.constraintlayout.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void analyze(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2 = constraintWidget;
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget2.mLeft.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget2.mTop.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget2.mRight.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget2.mBottom.getResolutionNode();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 0);
        if (!(resolutionNode.type == 4 || resolutionNode3.type == 4)) {
            if (constraintWidget2.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget != null && constraintWidget2.mRight.mTarget == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, (float) (-constraintWidget.getWidth()));
                        resolutionNode3.setOpposite(resolutionNode, (float) constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget != null) {
                    if (constraintWidget2.mLeft.mTarget != null || constraintWidget2.mRight.mTarget == null) {
                        if (!(constraintWidget2.mLeft.mTarget == null || constraintWidget2.mRight.mTarget == null)) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, (float) (-width));
                                resolutionNode3.setOpposite(resolutionNode, (float) width);
                                constraintWidget2.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget2, 1);
        if (resolutionNode2.type != 4 && resolutionNode4.type != 4) {
            if (constraintWidget2.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED || (z3 && constraintWidget.getVisibility() == 8)) {
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    ConstraintAnchor constraintAnchor = constraintWidget2.mBaseline;
                    if (constraintAnchor.mTarget != null) {
                        constraintAnchor.getResolutionNode().setType(1);
                        resolutionNode2.dependsOn(1, constraintWidget2.mBaseline.getResolutionNode(), -constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget == null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(1);
                    resolutionNode4.setType(1);
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                } else if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                    resolutionNode2.setType(2);
                    resolutionNode4.setType(2);
                    if (z) {
                        resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                    } else {
                        resolutionNode2.setOpposite(resolutionNode4, (float) (-constraintWidget.getHeight()));
                        resolutionNode4.setOpposite(resolutionNode2, (float) constraintWidget.getHeight());
                    }
                    if (constraintWidget2.mBaselineDistance > 0) {
                        constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                    }
                }
            } else if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                    }
                } else if (constraintWidget2.mTop.mTarget == null || constraintWidget2.mBottom.mTarget != null) {
                    if (constraintWidget2.mTop.mTarget != null || constraintWidget2.mBottom.mTarget == null) {
                        if (constraintWidget2.mTop.mTarget != null && constraintWidget2.mBottom.mTarget != null) {
                            if (z) {
                                constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                            }
                            if (constraintWidget2.mDimensionRatio == 0.0f) {
                                resolutionNode2.setType(3);
                                resolutionNode4.setType(3);
                                resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                                resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                                return;
                            }
                            resolutionNode2.setType(2);
                            resolutionNode4.setType(2);
                            resolutionNode2.setOpposite(resolutionNode4, (float) (-height));
                            resolutionNode4.setOpposite(resolutionNode2, (float) height);
                            constraintWidget2.setHeight(height);
                            if (constraintWidget2.mBaselineDistance > 0) {
                                constraintWidget2.mBaseline.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget2.mBaselineDistance);
                            }
                        }
                    } else if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                    }
                } else if (z) {
                    resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                } else {
                    resolutionNode4.dependsOn(resolutionNode2, height);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.mHorizontalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0048, code lost:
        if (r7.mVerticalChainStyle == 2) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean applyChainOptimized(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r24, androidx.constraintlayout.solver.LinearSystem r25, int r26, int r27, androidx.constraintlayout.solver.widgets.ChainHead r28) {
        /*
            r0 = r25
            r1 = r26
            r2 = r28
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r2.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r2.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r2.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r2.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.mHead
            float r8 = r2.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r2.mFirstMatchConstraintWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mLastMatchConstraintWidget
            r9 = r24
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r9.mListDimensionBehaviors
            r2 = r2[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r2 = 2
            r10 = 1
            if (r1 != 0) goto L_0x0038
            int r11 = r7.mHorizontalChainStyle
            if (r11 != 0) goto L_0x0028
            r11 = 1
            goto L_0x0029
        L_0x0028:
            r11 = 0
        L_0x0029:
            int r12 = r7.mHorizontalChainStyle
            if (r12 != r10) goto L_0x002f
            r12 = 1
            goto L_0x0030
        L_0x002f:
            r12 = 0
        L_0x0030:
            int r7 = r7.mHorizontalChainStyle
            if (r7 != r2) goto L_0x0036
        L_0x0034:
            r2 = 1
            goto L_0x004b
        L_0x0036:
            r2 = 0
            goto L_0x004b
        L_0x0038:
            int r11 = r7.mVerticalChainStyle
            if (r11 != 0) goto L_0x003e
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            int r12 = r7.mVerticalChainStyle
            if (r12 != r10) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            int r7 = r7.mVerticalChainStyle
            if (r7 != r2) goto L_0x0036
            goto L_0x0034
        L_0x004b:
            r14 = r3
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0053:
            r7 = 8
            if (r13 != 0) goto L_0x010c
            int r9 = r14.getVisibility()
            if (r9 == r7) goto L_0x00a1
            int r15 = r15 + 1
            if (r1 != 0) goto L_0x0066
            int r9 = r14.getWidth()
            goto L_0x006a
        L_0x0066:
            int r9 = r14.getHeight()
        L_0x006a:
            float r9 = (float) r9
            float r16 = r16 + r9
            if (r14 == r5) goto L_0x007a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            r9 = r9[r27]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x007a:
            if (r14 == r6) goto L_0x0089
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            int r19 = r27 + 1
            r9 = r9[r19]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r16 = r16 + r9
        L_0x0089:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            r9 = r9[r27]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r17 = r17 + r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            int r19 = r27 + 1
            r9 = r9[r19]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r17 = r17 + r9
        L_0x00a1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r14.mListAnchors
            r9 = r9[r27]
            int r9 = r14.getVisibility()
            if (r9 == r7) goto L_0x00df
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r14.mListDimensionBehaviors
            r7 = r7[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r9) goto L_0x00df
            int r10 = r10 + 1
            if (r1 != 0) goto L_0x00c7
            int r7 = r14.mMatchConstraintDefaultWidth
            if (r7 == 0) goto L_0x00bd
            r7 = 0
            return r7
        L_0x00bd:
            r7 = 0
            int r9 = r14.mMatchConstraintMinWidth
            if (r9 != 0) goto L_0x00c6
            int r9 = r14.mMatchConstraintMaxWidth
            if (r9 == 0) goto L_0x00d6
        L_0x00c6:
            return r7
        L_0x00c7:
            r7 = 0
            int r9 = r14.mMatchConstraintDefaultHeight
            if (r9 == 0) goto L_0x00cd
            return r7
        L_0x00cd:
            int r9 = r14.mMatchConstraintMinHeight
            if (r9 != 0) goto L_0x00de
            int r9 = r14.mMatchConstraintMaxHeight
            if (r9 == 0) goto L_0x00d6
            goto L_0x00de
        L_0x00d6:
            float r9 = r14.mDimensionRatio
            r18 = 0
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 == 0) goto L_0x00df
        L_0x00de:
            return r7
        L_0x00df:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            int r9 = r27 + 1
            r7 = r7[r9]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0101
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r7.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r7.mListAnchors
            r20 = r7
            r7 = r9[r27]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0101
            r7 = r9[r27]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r7.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r7.mOwner
            if (r7 == r14) goto L_0x00fe
            goto L_0x0101
        L_0x00fe:
            r19 = r20
            goto L_0x0103
        L_0x0101:
            r19 = 0
        L_0x0103:
            if (r19 == 0) goto L_0x0109
            r14 = r19
            goto L_0x0053
        L_0x0109:
            r13 = 1
            goto L_0x0053
        L_0x010c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r9 = r3.mListAnchors
            r9 = r9[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r13 = r4.mListAnchors
            int r19 = r27 + 1
            r13 = r13[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r13 = r13.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r9.target
            if (r7 == 0) goto L_0x0382
            r21 = r3
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.target
            if (r3 != 0) goto L_0x012a
            goto L_0x0382
        L_0x012a:
            int r7 = r7.state
            r0 = 1
            if (r7 != r0) goto L_0x0380
            int r3 = r3.state
            if (r3 == r0) goto L_0x0135
            goto L_0x0380
        L_0x0135:
            if (r10 <= 0) goto L_0x013b
            if (r10 == r15) goto L_0x013b
            r0 = 0
            return r0
        L_0x013b:
            if (r2 != 0) goto L_0x0144
            if (r11 != 0) goto L_0x0144
            if (r12 == 0) goto L_0x0142
            goto L_0x0144
        L_0x0142:
            r7 = 0
            goto L_0x015d
        L_0x0144:
            if (r5 == 0) goto L_0x0150
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            r0 = r0[r27]
            int r0 = r0.getMargin()
            float r7 = (float) r0
            goto L_0x0151
        L_0x0150:
            r7 = 0
        L_0x0151:
            if (r6 == 0) goto L_0x015d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r6.mListAnchors
            r0 = r0[r19]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            float r7 = r7 + r0
        L_0x015d:
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r0 = r9.target
            float r0 = r0.resolvedOffset
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r3 = r13.target
            float r3 = r3.resolvedOffset
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x016b
            float r3 = r3 - r0
            goto L_0x016d
        L_0x016b:
            float r3 = r0 - r3
        L_0x016d:
            float r3 = r3 - r16
            r22 = 1
            if (r10 <= 0) goto L_0x0223
            if (r10 != r15) goto L_0x0223
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r14.getParent()
            if (r2 == 0) goto L_0x0189
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r14.getParent()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r1]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r5) goto L_0x0189
            r2 = 0
            return r2
        L_0x0189:
            float r3 = r3 + r16
            float r3 = r3 - r17
            r2 = r0
            r0 = r21
        L_0x0190:
            if (r0 == 0) goto L_0x0221
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r5 == 0) goto L_0x01a8
            long r6 = r5.nonresolvedWidgets
            long r6 = r6 - r22
            r5.nonresolvedWidgets = r6
            long r6 = r5.resolvedWidgets
            long r6 = r6 + r22
            r5.resolvedWidgets = r6
            long r6 = r5.chainConnectionResolved
            long r6 = r6 + r22
            r5.chainConnectionResolved = r6
        L_0x01a8:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r0.mNextChainWidget
            r5 = r5[r1]
            if (r5 != 0) goto L_0x01b4
            if (r0 != r4) goto L_0x01b1
            goto L_0x01b4
        L_0x01b1:
            r13 = r25
            goto L_0x021e
        L_0x01b4:
            float r6 = (float) r10
            float r6 = r3 / r6
            r7 = 0
            int r11 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x01cd
            float[] r6 = r0.mWeight
            r7 = r6[r1]
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x01c8
            r7 = 0
            goto L_0x01ce
        L_0x01c8:
            r6 = r6[r1]
            float r6 = r6 * r3
            float r6 = r6 / r8
        L_0x01cd:
            r7 = r6
        L_0x01ce:
            int r6 = r0.getVisibility()
            r11 = 8
            if (r6 != r11) goto L_0x01d7
            r7 = 0
        L_0x01d7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r27]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r2 = r2 + r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r11 = r9.resolvedTarget
            r6.resolve(r11, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r11 = r9.resolvedTarget
            float r2 = r2 + r7
            r6.resolve(r11, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r13 = r25
            r6.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r6.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r0 = r0[r19]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            float r2 = r2 + r0
        L_0x021e:
            r0 = r5
            goto L_0x0190
        L_0x0221:
            r0 = 1
            return r0
        L_0x0223:
            r13 = r25
            r6 = 0
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x022d
            r2 = 1
            r11 = 0
            r12 = 0
        L_0x022d:
            if (r2 == 0) goto L_0x02ac
            float r3 = r3 - r7
            r2 = r21
            float r5 = r2.getBiasPercent(r1)
            float r3 = r3 * r5
            float r0 = r0 + r3
        L_0x0239:
            if (r2 == 0) goto L_0x02b3
            androidx.constraintlayout.solver.Metrics r3 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r3 == 0) goto L_0x0251
            long r5 = r3.nonresolvedWidgets
            long r5 = r5 - r22
            r3.nonresolvedWidgets = r5
            long r5 = r3.resolvedWidgets
            long r5 = r5 + r22
            r3.resolvedWidgets = r5
            long r5 = r3.chainConnectionResolved
            long r5 = r5 + r22
            r3.chainConnectionResolved = r5
        L_0x0251:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r3 = r2.mNextChainWidget
            r3 = r3[r1]
            if (r3 != 0) goto L_0x0259
            if (r2 != r4) goto L_0x02aa
        L_0x0259:
            if (r1 != 0) goto L_0x0260
            int r5 = r2.getWidth()
            goto L_0x0264
        L_0x0260:
            int r5 = r2.getHeight()
        L_0x0264:
            float r5 = (float) r5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r27]
            int r6 = r6.getMargin()
            float r6 = (float) r6
            float r0 = r0 + r6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            r6.resolve(r7, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r2.mListAnchors
            r6 = r6[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            float r0 = r0 + r5
            r6.resolve(r7, r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r5 = r5[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r5 = r5.getResolutionNode()
            r5.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r19]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r0 = r0 + r2
        L_0x02aa:
            r2 = r3
            goto L_0x0239
        L_0x02ac:
            r2 = r21
            if (r11 != 0) goto L_0x02b6
            if (r12 == 0) goto L_0x02b3
            goto L_0x02b6
        L_0x02b3:
            r0 = 1
            goto L_0x037f
        L_0x02b6:
            if (r11 == 0) goto L_0x02ba
        L_0x02b8:
            float r3 = r3 - r7
            goto L_0x02bd
        L_0x02ba:
            if (r12 == 0) goto L_0x02bd
            goto L_0x02b8
        L_0x02bd:
            int r6 = r15 + 1
            float r6 = (float) r6
            float r6 = r3 / r6
            if (r12 == 0) goto L_0x02cf
            r7 = 1
            if (r15 <= r7) goto L_0x02cb
            int r6 = r15 + -1
            float r6 = (float) r6
            goto L_0x02cd
        L_0x02cb:
            r6 = 1073741824(0x40000000, float:2.0)
        L_0x02cd:
            float r6 = r3 / r6
        L_0x02cf:
            int r3 = r2.getVisibility()
            r7 = 8
            if (r3 == r7) goto L_0x02da
            float r3 = r0 + r6
            goto L_0x02db
        L_0x02da:
            r3 = r0
        L_0x02db:
            if (r12 == 0) goto L_0x02ea
            r7 = 1
            if (r15 <= r7) goto L_0x02ea
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r27]
            int r3 = r3.getMargin()
            float r3 = (float) r3
            float r3 = r3 + r0
        L_0x02ea:
            if (r11 == 0) goto L_0x02f8
            if (r5 == 0) goto L_0x02f8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            r0 = r0[r27]
            int r0 = r0.getMargin()
            float r0 = (float) r0
            float r3 = r3 + r0
        L_0x02f8:
            if (r2 == 0) goto L_0x02b3
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            if (r0 == 0) goto L_0x0310
            long r7 = r0.nonresolvedWidgets
            long r7 = r7 - r22
            r0.nonresolvedWidgets = r7
            long r7 = r0.resolvedWidgets
            long r7 = r7 + r22
            r0.resolvedWidgets = r7
            long r7 = r0.chainConnectionResolved
            long r7 = r7 + r22
            r0.chainConnectionResolved = r7
        L_0x0310:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r2.mNextChainWidget
            r0 = r0[r1]
            if (r0 != 0) goto L_0x031c
            if (r2 != r4) goto L_0x0319
            goto L_0x031c
        L_0x0319:
            r7 = 8
            goto L_0x037c
        L_0x031c:
            if (r1 != 0) goto L_0x0323
            int r7 = r2.getWidth()
            goto L_0x0327
        L_0x0323:
            int r7 = r2.getHeight()
        L_0x0327:
            float r7 = (float) r7
            if (r2 == r5) goto L_0x0334
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r27]
            int r8 = r8.getMargin()
            float r8 = (float) r8
            float r3 = r3 + r8
        L_0x0334:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r9.resolvedTarget
            r8.resolve(r10, r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r10 = r9.resolvedTarget
            float r11 = r3 + r7
            r8.resolve(r10, r11)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r27]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r2.mListAnchors
            r8 = r8[r19]
            androidx.constraintlayout.solver.widgets.ResolutionAnchor r8 = r8.getResolutionNode()
            r8.addResolvedValue(r13)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.mListAnchors
            r2 = r2[r19]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r7 = r7 + r2
            float r3 = r3 + r7
            if (r0 == 0) goto L_0x0319
            int r2 = r0.getVisibility()
            r7 = 8
            if (r2 == r7) goto L_0x037c
            float r3 = r3 + r6
        L_0x037c:
            r2 = r0
            goto L_0x02f8
        L_0x037f:
            return r0
        L_0x0380:
            r0 = 0
            return r0
        L_0x0382:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.applyChainOptimized(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):boolean");
    }

    static void setOptimizedWidget(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedTarget = constraintWidget.getParent().mLeft.getResolutionNode();
        constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset = (float) i2;
        constraintWidget.mListAnchors[i3].getResolutionNode().state = 1;
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedTarget = constraintWidget.mListAnchors[i3].getResolutionNode();
        constraintWidget.mListAnchors[i4].getResolutionNode().resolvedOffset = (float) constraintWidget.getLength(i);
        constraintWidget.mListAnchors[i4].getResolutionNode().state = 1;
    }
}
