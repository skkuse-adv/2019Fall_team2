package com.beloo.widget.chipslayoutmanager;

interface IPositionsContract {
    int findFirstCompletelyVisibleItemPosition();

    int findFirstVisibleItemPosition();

    int findLastCompletelyVisibleItemPosition();

    int findLastVisibleItemPosition();
}
