package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import java.util.List;
import kr.co.popone.fitts.C0010R$id;
import me.gujun.android.taggroup.TagGroup;

final class SearchHomeFragment$onViewCreated$4<T> implements Observer<List<? extends String>> {
    final /* synthetic */ SearchHomeFragment this$0;

    SearchHomeFragment$onViewCreated$4(SearchHomeFragment searchHomeFragment) {
        this.this$0 = searchHomeFragment;
    }

    public final void onChanged(List<String> list) {
        ((TagGroup) this.this$0._$_findCachedViewById(C0010R$id.hotKeywordTag)).setTags(list);
    }
}
