package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultFittieViewHolder;
import kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultPostViewHolder;
import kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultProductViewHolder;
import kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultStoreViewHolder;
import kr.co.popone.fitts.model.post.PostFeedViewData;
import kr.co.popone.fitts.model.search.HasMoreInfo;
import kr.co.popone.fitts.model.search.IntergratedSearchInterface;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntergratedSearchResultAdapter extends Adapter<ViewHolder> {
    public static final Companion Companion = new Companion(null);
    private static final int FITTIE_TYPE = 2;
    private static final int POST_TYPE = 0;
    private static final int PRODUCT_TYPE = 1;
    private static final int STORE_TYPE = 3;
    private static final int UNDEFINED = 4;
    @NotNull
    private final Delegate delegate;
    private HasMoreInfo hasMoreInfo;
    private List<? extends List<? extends IntergratedSearchInterface>> items = new ArrayList();

    public interface Delegate extends kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultProductViewHolder.Delegate, kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultPostViewHolder.Delegate, kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultStoreViewHolder.Delegate, kr.co.popone.fitts.feature.search.holder.IntergratedSearchResultFittieViewHolder.Delegate, kr.co.popone.fitts.feature.search.holder.StoreSearchResultViewHolder.Delegate {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntergratedSearchResultAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void updateIntergratedSearchResult(@Nullable IntergratedSearchViewData intergratedSearchViewData) {
        List<? extends List<? extends IntergratedSearchInterface>> list = this.items;
        String str = "null cannot be cast to non-null type java.util.ArrayList<kotlin.collections.List<kr.co.popone.fitts.model.search.IntergratedSearchInterface>>";
        if (list != null) {
            ((ArrayList) list).clear();
            if (intergratedSearchViewData != null) {
                if (!intergratedSearchViewData.getPosts().isEmpty()) {
                    List<? extends List<? extends IntergratedSearchInterface>> list2 = this.items;
                    if (list2 != null) {
                        ((ArrayList) list2).add(intergratedSearchViewData.getPosts());
                    } else {
                        throw new TypeCastException(str);
                    }
                }
                if (!intergratedSearchViewData.getProducts().isEmpty()) {
                    List<? extends List<? extends IntergratedSearchInterface>> list3 = this.items;
                    if (list3 != null) {
                        ((ArrayList) list3).add(intergratedSearchViewData.getProducts());
                    } else {
                        throw new TypeCastException(str);
                    }
                }
                if (!intergratedSearchViewData.getUsers().isEmpty()) {
                    List<? extends List<? extends IntergratedSearchInterface>> list4 = this.items;
                    if (list4 != null) {
                        ((ArrayList) list4).add(intergratedSearchViewData.getUsers());
                    } else {
                        throw new TypeCastException(str);
                    }
                }
                if (!intergratedSearchViewData.getStore().isEmpty()) {
                    List<? extends List<? extends IntergratedSearchInterface>> list5 = this.items;
                    if (list5 != null) {
                        ((ArrayList) list5).add(intergratedSearchViewData.getStore());
                    } else {
                        throw new TypeCastException(str);
                    }
                }
                this.hasMoreInfo = intergratedSearchViewData.getHasMore();
                notifyDataSetChanged();
                return;
            }
            return;
        }
        throw new TypeCastException(str);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == POST_TYPE) {
            return IntergratedSearchResultPostViewHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == PRODUCT_TYPE) {
            return IntergratedSearchResultProductViewHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == FITTIE_TYPE) {
            return IntergratedSearchResultFittieViewHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == STORE_TYPE) {
            return IntergratedSearchResultStoreViewHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        Boolean bool = null;
        if (viewHolder instanceof IntergratedSearchResultPostViewHolder) {
            IntergratedSearchResultPostViewHolder intergratedSearchResultPostViewHolder = (IntergratedSearchResultPostViewHolder) viewHolder;
            Object obj = this.items.get(i);
            if (obj != null) {
                List list = (List) obj;
                HasMoreInfo hasMoreInfo2 = this.hasMoreInfo;
                if (hasMoreInfo2 != null) {
                    bool = Boolean.valueOf(hasMoreInfo2.getHasMorePost());
                }
                intergratedSearchResultPostViewHolder.bindTo(list, bool);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kr.co.popone.fitts.model.post.PostFeedViewData>");
        } else if (viewHolder instanceof IntergratedSearchResultProductViewHolder) {
            IntergratedSearchResultProductViewHolder intergratedSearchResultProductViewHolder = (IntergratedSearchResultProductViewHolder) viewHolder;
            Object obj2 = this.items.get(i);
            if (obj2 != null) {
                List list2 = (List) obj2;
                HasMoreInfo hasMoreInfo3 = this.hasMoreInfo;
                if (hasMoreInfo3 != null) {
                    bool = Boolean.valueOf(hasMoreInfo3.getHasMoreProduct());
                }
                intergratedSearchResultProductViewHolder.bindTo(list2, bool);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kr.co.popone.fitts.model.store.ProductFeedViewData>");
        } else if (viewHolder instanceof IntergratedSearchResultFittieViewHolder) {
            IntergratedSearchResultFittieViewHolder intergratedSearchResultFittieViewHolder = (IntergratedSearchResultFittieViewHolder) viewHolder;
            Object obj3 = this.items.get(i);
            if (obj3 != null) {
                List list3 = (List) obj3;
                HasMoreInfo hasMoreInfo4 = this.hasMoreInfo;
                if (hasMoreInfo4 != null) {
                    bool = Boolean.valueOf(hasMoreInfo4.getHasMoreUser());
                }
                intergratedSearchResultFittieViewHolder.bindTo(list3, bool);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kr.co.popone.fitts.model.view.FittieFollowViewData>");
        } else if (viewHolder instanceof IntergratedSearchResultStoreViewHolder) {
            IntergratedSearchResultStoreViewHolder intergratedSearchResultStoreViewHolder = (IntergratedSearchResultStoreViewHolder) viewHolder;
            Object obj4 = this.items.get(i);
            if (obj4 != null) {
                intergratedSearchResultStoreViewHolder.bindTo((List) obj4);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kr.co.popone.fitts.model.store.StoreInfo>");
        }
    }

    public int getItemViewType(int i) {
        IntergratedSearchInterface intergratedSearchInterface = (IntergratedSearchInterface) ((List) this.items.get(i)).get(0);
        if (intergratedSearchInterface instanceof PostFeedViewData) {
            return POST_TYPE;
        }
        if (intergratedSearchInterface instanceof ProductFeedViewData) {
            return PRODUCT_TYPE;
        }
        if (intergratedSearchInterface instanceof FittieFollowViewData) {
            return FITTIE_TYPE;
        }
        if (intergratedSearchInterface instanceof StoreInfo) {
            return STORE_TYPE;
        }
        return UNDEFINED;
    }

    public final void updateFittieFollowing(long j, boolean z) {
        int i = 0;
        for (Object next : this.items) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            List<IntergratedSearchInterface> list = (List) next;
            if (list.get(0) instanceof FittieFollowViewData) {
                for (IntergratedSearchInterface intergratedSearchInterface : list) {
                    if (intergratedSearchInterface != null) {
                        FittieFollowViewData fittieFollowViewData = (FittieFollowViewData) intergratedSearchInterface;
                        if (fittieFollowViewData.getId() == j) {
                            fittieFollowViewData.setFollowing(z);
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.view.FittieFollowViewData");
                    }
                }
                notifyItemChanged(i);
            }
            i = i2;
        }
    }
}
