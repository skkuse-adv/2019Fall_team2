package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil.Callback;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;

class PagedStorageDiffHelper {

    private static class OffsettingListUpdateCallback implements ListUpdateCallback {
        private final ListUpdateCallback mCallback;
        private final int mOffset;

        OffsettingListUpdateCallback(int i, ListUpdateCallback listUpdateCallback) {
            this.mOffset = i;
            this.mCallback = listUpdateCallback;
        }

        public void onInserted(int i, int i2) {
            this.mCallback.onInserted(i + this.mOffset, i2);
        }

        public void onRemoved(int i, int i2) {
            this.mCallback.onRemoved(i + this.mOffset, i2);
        }

        public void onMoved(int i, int i2) {
            ListUpdateCallback listUpdateCallback = this.mCallback;
            int i3 = this.mOffset;
            listUpdateCallback.onMoved(i + i3, i2 + i3);
        }

        public void onChanged(int i, int i2, Object obj) {
            this.mCallback.onChanged(i + this.mOffset, i2, obj);
        }
    }

    private PagedStorageDiffHelper() {
    }

    static <T> DiffResult computeDiff(PagedStorage<T> pagedStorage, PagedStorage<T> pagedStorage2, ItemCallback<T> itemCallback) {
        final int computeLeadingNulls = pagedStorage.computeLeadingNulls();
        final int size = (pagedStorage.size() - computeLeadingNulls) - pagedStorage.computeTrailingNulls();
        final int size2 = (pagedStorage2.size() - pagedStorage2.computeLeadingNulls()) - pagedStorage2.computeTrailingNulls();
        final PagedStorage<T> pagedStorage3 = pagedStorage;
        final PagedStorage<T> pagedStorage4 = pagedStorage2;
        final ItemCallback<T> itemCallback2 = itemCallback;
        AnonymousClass1 r0 = new Callback() {
            @Nullable
            public Object getChangePayload(int i, int i2) {
                Object obj = pagedStorage3.get(i + computeLeadingNulls);
                PagedStorage pagedStorage = pagedStorage4;
                Object obj2 = pagedStorage.get(i2 + pagedStorage.getLeadingNullCount());
                if (obj == null || obj2 == null) {
                    return null;
                }
                return itemCallback2.getChangePayload(obj, obj2);
            }

            public int getOldListSize() {
                return size;
            }

            public int getNewListSize() {
                return size2;
            }

            public boolean areItemsTheSame(int i, int i2) {
                Object obj = pagedStorage3.get(i + computeLeadingNulls);
                PagedStorage pagedStorage = pagedStorage4;
                Object obj2 = pagedStorage.get(i2 + pagedStorage.getLeadingNullCount());
                if (obj == obj2) {
                    return true;
                }
                if (obj == null || obj2 == null) {
                    return false;
                }
                return itemCallback2.areItemsTheSame(obj, obj2);
            }

            public boolean areContentsTheSame(int i, int i2) {
                Object obj = pagedStorage3.get(i + computeLeadingNulls);
                PagedStorage pagedStorage = pagedStorage4;
                Object obj2 = pagedStorage.get(i2 + pagedStorage.getLeadingNullCount());
                if (obj == obj2) {
                    return true;
                }
                if (obj == null || obj2 == null) {
                    return false;
                }
                return itemCallback2.areContentsTheSame(obj, obj2);
            }
        };
        return DiffUtil.calculateDiff(r0, true);
    }

    static <T> void dispatchDiff(ListUpdateCallback listUpdateCallback, PagedStorage<T> pagedStorage, PagedStorage<T> pagedStorage2, DiffResult diffResult) {
        int computeTrailingNulls = pagedStorage.computeTrailingNulls();
        int computeTrailingNulls2 = pagedStorage2.computeTrailingNulls();
        int computeLeadingNulls = pagedStorage.computeLeadingNulls();
        int computeLeadingNulls2 = pagedStorage2.computeLeadingNulls();
        if (computeTrailingNulls == 0 && computeTrailingNulls2 == 0 && computeLeadingNulls == 0 && computeLeadingNulls2 == 0) {
            diffResult.dispatchUpdatesTo(listUpdateCallback);
            return;
        }
        if (computeTrailingNulls > computeTrailingNulls2) {
            int i = computeTrailingNulls - computeTrailingNulls2;
            listUpdateCallback.onRemoved(pagedStorage.size() - i, i);
        } else if (computeTrailingNulls < computeTrailingNulls2) {
            listUpdateCallback.onInserted(pagedStorage.size(), computeTrailingNulls2 - computeTrailingNulls);
        }
        if (computeLeadingNulls > computeLeadingNulls2) {
            listUpdateCallback.onRemoved(0, computeLeadingNulls - computeLeadingNulls2);
        } else if (computeLeadingNulls < computeLeadingNulls2) {
            listUpdateCallback.onInserted(0, computeLeadingNulls2 - computeLeadingNulls);
        }
        if (computeLeadingNulls2 != 0) {
            diffResult.dispatchUpdatesTo((ListUpdateCallback) new OffsettingListUpdateCallback(computeLeadingNulls2, listUpdateCallback));
        } else {
            diffResult.dispatchUpdatesTo(listUpdateCallback);
        }
    }

    static int transformAnchorIndex(@NonNull DiffResult diffResult, @NonNull PagedStorage pagedStorage, @NonNull PagedStorage pagedStorage2, int i) {
        int computeLeadingNulls = pagedStorage.computeLeadingNulls();
        int i2 = i - computeLeadingNulls;
        int size = (pagedStorage.size() - computeLeadingNulls) - pagedStorage.computeTrailingNulls();
        if (i2 >= 0 && i2 < size) {
            for (int i3 = 0; i3 < 30; i3++) {
                int i4 = ((i3 / 2) * (i3 % 2 == 1 ? -1 : 1)) + i2;
                if (i4 >= 0 && i4 < pagedStorage.getStorageCount()) {
                    int convertOldPositionToNew = diffResult.convertOldPositionToNew(i4);
                    if (convertOldPositionToNew != -1) {
                        return convertOldPositionToNew + pagedStorage2.getLeadingNullCount();
                    }
                }
            }
        }
        return Math.max(0, Math.min(i, pagedStorage2.size() - 1));
    }
}
