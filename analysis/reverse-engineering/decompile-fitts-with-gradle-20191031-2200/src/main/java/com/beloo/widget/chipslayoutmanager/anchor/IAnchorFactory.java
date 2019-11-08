package com.beloo.widget.chipslayoutmanager.anchor;

public interface IAnchorFactory {
    AnchorViewState createNotFound();

    AnchorViewState getAnchor();

    void resetRowCoordinates(AnchorViewState anchorViewState);
}
