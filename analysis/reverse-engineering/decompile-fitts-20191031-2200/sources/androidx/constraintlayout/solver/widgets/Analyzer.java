package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analyzer {
    private Analyzer() {
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            singleGroup(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.mChildren;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        boolean z = constraintWidgetContainer.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.mBelongingGroup = null;
            constraintWidget.mGroupsToSolver = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.mBelongingGroup == null && !determineGroups(constraintWidget2, list, z3)) {
                singleGroup(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i = Math.max(i, getMaxDimension(constraintWidgetGroup, 0));
            i2 = Math.max(i2, getMaxDimension(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i2;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static boolean determineGroups(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return traverse(constraintWidget, constraintWidgetGroup, list, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0181, code lost:
        if (r3.mOwner == r4) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0128, code lost:
        if (r3.mOwner == r4) goto L_0x012a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget r8, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r9, java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r10, boolean r11) {
        /*
            r0 = 1
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r8.mOptimizerMeasured = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r8.getParent()
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r3 = r8.mBelongingGroup
            if (r3 != 0) goto L_0x01f0
            r8.mOptimizerMeasurable = r0
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r9.mConstrainedGroup
            r3.add(r8)
            r8.mBelongingGroup = r9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0044
            invalidate(r2, r8, r9)
            if (r11 == 0) goto L_0x0044
            return r1
        L_0x0044:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0077
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0077
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 == 0) goto L_0x005c
            invalidate(r2, r8, r9)
            return r1
        L_0x005c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.getParent()
            if (r3 != r4) goto L_0x0074
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.getParent()
            if (r3 == r4) goto L_0x0077
        L_0x0074:
            invalidate(r2, r8, r9)
        L_0x0077:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x00aa
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x00aa
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r11 == 0) goto L_0x008f
            invalidate(r2, r8, r9)
            return r1
        L_0x008f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.getParent()
            if (r3 != r4) goto L_0x00a7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.getParent()
            if (r3 == r4) goto L_0x00aa
        L_0x00a7:
            invalidate(r2, r8, r9)
        L_0x00aa:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r8.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00b4
            r3 = 1
            goto L_0x00b5
        L_0x00b4:
            r3 = 0
        L_0x00b5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r8.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x00bf
            r4 = 1
            goto L_0x00c0
        L_0x00bf:
            r4 = 0
        L_0x00c0:
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x00ce
            float r3 = r8.mDimensionRatio
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x00ce
            resolveDimensionRatio(r8)
            goto L_0x00e4
        L_0x00ce:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r8.getHorizontalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x00de
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r8.getVerticalDimensionBehaviour()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00e4
        L_0x00de:
            invalidate(r2, r8, r9)
            if (r11 == 0) goto L_0x00e4
            return r1
        L_0x00e4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x00f0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x012a
        L_0x00f0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0102
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x0102
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x012a
        L_0x0102:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0114
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x0114
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x012a
        L_0x0114:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x013d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x013d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x013d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 != r4) goto L_0x013d
        L_0x012a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x013d
            boolean r3 = r8 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r3 != 0) goto L_0x013d
            boolean r3 = r8 instanceof androidx.constraintlayout.solver.widgets.Helper
            if (r3 != 0) goto L_0x013d
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r9.mStartHorizontalWidgets
            r3.add(r8)
        L_0x013d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x0149
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0183
        L_0x0149:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x015b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x015b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0183
        L_0x015b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x016d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x016d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0183
        L_0x016d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.mParent
            if (r3 != r4) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 != r4) goto L_0x019c
        L_0x0183:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x019c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r8.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 != 0) goto L_0x019c
            boolean r3 = r8 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r3 != 0) goto L_0x019c
            boolean r3 = r8 instanceof androidx.constraintlayout.solver.widgets.Helper
            if (r3 != 0) goto L_0x019c
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r3 = r9.mStartVerticalWidgets
            r3.add(r8)
        L_0x019c:
            boolean r3 = r8 instanceof androidx.constraintlayout.solver.widgets.Helper
            if (r3 == 0) goto L_0x01bc
            invalidate(r2, r8, r9)
            if (r11 == 0) goto L_0x01a6
            return r1
        L_0x01a6:
            r3 = r8
            androidx.constraintlayout.solver.widgets.Helper r3 = (androidx.constraintlayout.solver.widgets.Helper) r3
            r4 = 0
        L_0x01aa:
            int r5 = r3.mWidgetsCount
            if (r4 >= r5) goto L_0x01bc
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r3.mWidgets
            r5 = r5[r4]
            boolean r5 = traverse(r5, r9, r10, r11)
            if (r5 != 0) goto L_0x01b9
            return r1
        L_0x01b9:
            int r4 = r4 + 1
            goto L_0x01aa
        L_0x01bc:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r8.mListAnchors
            int r3 = r3.length
            r4 = 0
        L_0x01c0:
            if (r4 >= r3) goto L_0x01ef
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r5.mTarget
            if (r6 == 0) goto L_0x01ec
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r8.getParent()
            if (r6 == r7) goto L_0x01ec
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = r5.mType
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            if (r6 != r7) goto L_0x01de
            invalidate(r2, r8, r9)
            if (r11 == 0) goto L_0x01e1
            return r1
        L_0x01de:
            setConnection(r5)
        L_0x01e1:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.mOwner
            boolean r5 = traverse(r5, r9, r10, r11)
            if (r5 != 0) goto L_0x01ec
            return r1
        L_0x01ec:
            int r4 = r4 + 1
            goto L_0x01c0
        L_0x01ef:
            return r0
        L_0x01f0:
            if (r3 == r9) goto L_0x022f
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r11 = r9.mConstrainedGroup
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r2 = r3.mConstrainedGroup
            r11.addAll(r2)
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r11 = r9.mStartHorizontalWidgets
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r2 = r8.mBelongingGroup
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r2 = r2.mStartHorizontalWidgets
            r11.addAll(r2)
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r11 = r9.mStartVerticalWidgets
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r2 = r8.mBelongingGroup
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r2 = r2.mStartVerticalWidgets
            r11.addAll(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r11 = r8.mBelongingGroup
            boolean r11 = r11.mSkipSolver
            if (r11 != 0) goto L_0x0213
            r9.mSkipSolver = r1
        L_0x0213:
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r11 = r8.mBelongingGroup
            r10.remove(r11)
            androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r8 = r8.mBelongingGroup
            java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidget> r8 = r8.mConstrainedGroup
            java.util.Iterator r8 = r8.iterator()
        L_0x0220:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x022f
            java.lang.Object r10 = r8.next()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r10
            r10.mBelongingGroup = r9
            goto L_0x0220
        L_0x022f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Analyzer.traverse(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup, java.util.List, boolean):boolean");
    }

    private static void invalidate(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.mOptimizerMeasurable = false;
    }

    private static int getMaxDimension(ConstraintWidgetGroup constraintWidgetGroup, int i) {
        int i2 = i * 2;
        List startWidgets = constraintWidgetGroup.getStartWidgets(i);
        int size = startWidgets.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) startWidgets.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
            int i5 = i2 + 1;
            i3 = Math.max(i3, getMaxDimensionTraversal(constraintWidget, i, constraintAnchorArr[i5].mTarget == null || !(constraintAnchorArr[i2].mTarget == null || constraintAnchorArr[i5].mTarget == null), 0));
        }
        constraintWidgetGroup.mGroupDimensions[i] = i3;
        return i3;
    }

    private static int getMaxDimensionTraversal(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        ConstraintWidget constraintWidget2 = constraintWidget;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!constraintWidget2.mOptimizerMeasurable) {
            return 0;
        }
        boolean z3 = constraintWidget2.mBaseline.mTarget != null && i12 == 1;
        if (z2) {
            i6 = constraintWidget.getBaselineDistance();
            i5 = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = constraintWidget.getBaselineDistance();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
        if (constraintAnchorArr[i3].mTarget == null || constraintAnchorArr[i4].mTarget != null) {
            i7 = i3;
            i3 = i4;
            i8 = 1;
        } else {
            i7 = i4;
            i8 = -1;
        }
        int margin = (constraintWidget2.mListAnchors[i3].getMargin() * i8) + getParentBiasOffset(constraintWidget, i);
        int i14 = (z3 ? i2 - i6 : i2) + margin;
        int width2 = (i12 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i8;
        Iterator it = constraintWidget2.mListAnchors[i3].getResolutionNode().dependents.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, getMaxDimensionTraversal(((ResolutionAnchor) it.next()).myAnchor.mOwner, i12, z2, i14));
        }
        Iterator it2 = constraintWidget2.mListAnchors[i7].getResolutionNode().dependents.iterator();
        int i15 = 0;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            i15 = Math.max(i15, getMaxDimensionTraversal(((ResolutionAnchor) it2.next()).myAnchor.mOwner, i12, z2, width2 + i14));
            it2 = it3;
        }
        if (z3) {
            i13 -= i6;
            width = i15 + i5;
        } else {
            width = i15 + ((i12 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i8);
        }
        int i16 = 1;
        if (i12 == 1) {
            Iterator it4 = constraintWidget2.mBaseline.getResolutionNode().dependents.iterator();
            int i17 = 0;
            while (it4.hasNext()) {
                Iterator it5 = it4;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it4.next();
                if (i8 == i16) {
                    i17 = Math.max(i17, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i12, z2, i6 + i14));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i17 = Math.max(i17, getMaxDimensionTraversal(resolutionAnchor.myAnchor.mOwner, i12, z2, (i5 * i8) + i14));
                }
                it4 = it5;
                i7 = i11;
                i16 = 1;
            }
            i9 = i7;
            int i18 = i17;
            i10 = (constraintWidget2.mBaseline.getResolutionNode().dependents.size() <= 0 || z3) ? i18 : i8 == 1 ? i18 + i6 : i18 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = margin + Math.max(i13, Math.max(width, i10));
        int i19 = i14 + width2;
        if (i8 != -1) {
            int i20 = i14;
            i14 = i19;
            i19 = i20;
        }
        if (z2) {
            Optimizer.setOptimizedWidget(constraintWidget2, i12, i19);
            constraintWidget2.setFrame(i19, i14, i12);
        } else {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
            constraintWidget2.setRelativePositioning(i19, i12);
        }
        if (constraintWidget.getDimensionBehaviour(i) == DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.mDimensionRatio != 0.0f) {
            constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.mListAnchors;
        if (!(constraintAnchorArr2[i3].mTarget == null || constraintAnchorArr2[i9].mTarget == null)) {
            ConstraintWidget parent = constraintWidget.getParent();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
            if (constraintAnchorArr3[i3].mTarget.mOwner == parent && constraintAnchorArr3[i9].mTarget.mOwner == parent) {
                constraintWidget2.mBelongingGroup.addWidgetsToSet(constraintWidget2, i12);
            }
        }
        return max;
    }

    private static void setConnection(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget != constraintAnchor) {
            constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
        }
    }

    private static void singleGroup(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.mChildren));
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : ((ConstraintWidgetGroup) list.get(i3)).getWidgetsToSet(i)) {
                if (constraintWidget.mOptimizerMeasurable) {
                    updateSizeDependentWidgets(constraintWidget, i, i2);
                }
            }
        }
    }

    private static void updateSizeDependentWidgets(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.mTarget == null || constraintAnchor2.mTarget == null) ? false : true) {
            Optimizer.setOptimizedWidget(constraintWidget, i, getParentBiasOffset(constraintWidget, i) + constraintAnchor.getMargin());
        } else if (constraintWidget.mDimensionRatio == 0.0f || constraintWidget.getDimensionBehaviour(i) != DimensionBehaviour.MATCH_CONSTRAINT) {
            int relativePositioning = i2 - constraintWidget.getRelativePositioning(i);
            int length = relativePositioning - constraintWidget.getLength(i);
            constraintWidget.setFrame(length, relativePositioning, i);
            Optimizer.setOptimizedWidget(constraintWidget, i, length);
        } else {
            int resolveDimensionRatio = resolveDimensionRatio(constraintWidget);
            int i4 = (int) constraintWidget.mListAnchors[i3].getResolutionNode().resolvedOffset;
            int i5 = i4 + resolveDimensionRatio;
            constraintAnchor2.getResolutionNode().resolvedTarget = constraintAnchor.getResolutionNode();
            constraintAnchor2.getResolutionNode().resolvedOffset = (float) resolveDimensionRatio;
            constraintAnchor2.getResolutionNode().state = 1;
            constraintWidget.setFrame(i4, i5, i);
        }
    }

    private static int getParentBiasOffset(ConstraintWidget constraintWidget, int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.mListAnchors;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 != null) {
            ConstraintWidget constraintWidget2 = constraintAnchor3.mOwner;
            ConstraintWidget constraintWidget3 = constraintWidget.mParent;
            if (constraintWidget2 == constraintWidget3) {
                ConstraintAnchor constraintAnchor4 = constraintAnchor2.mTarget;
                if (constraintAnchor4 != null && constraintAnchor4.mOwner == constraintWidget3) {
                    return (int) (((float) (((constraintWidget3.getLength(i) - constraintAnchor.getMargin()) - constraintAnchor2.getMargin()) - constraintWidget.getLength(i))) * (i == 0 ? constraintWidget.mHorizontalBiasPercent : constraintWidget.mVerticalBiasPercent));
                }
            }
        }
        return 0;
    }

    private static int resolveDimensionRatio(ConstraintWidget constraintWidget) {
        float f;
        float f2;
        if (constraintWidget.getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mDimensionRatioSide == 0) {
                f2 = ((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio;
            } else {
                f2 = ((float) constraintWidget.getHeight()) / constraintWidget.mDimensionRatio;
            }
            int i = (int) f2;
            constraintWidget.setWidth(i);
            return i;
        } else if (constraintWidget.getVerticalDimensionBehaviour() != DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (constraintWidget.mDimensionRatioSide == 1) {
                f = ((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio;
            } else {
                f = ((float) constraintWidget.getWidth()) / constraintWidget.mDimensionRatio;
            }
            int i2 = (int) f;
            constraintWidget.setHeight(i2);
            return i2;
        }
    }
}
