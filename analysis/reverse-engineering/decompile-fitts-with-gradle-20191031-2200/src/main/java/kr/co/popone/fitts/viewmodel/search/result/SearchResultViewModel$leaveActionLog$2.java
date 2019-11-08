package kr.co.popone.fitts.viewmodel.search.result;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class SearchResultViewModel$leaveActionLog$2<T> implements Consumer<Throwable> {
    final /* synthetic */ String $type;

    SearchResultViewModel$leaveActionLog$2(String str) {
        this.$type = str;
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFailed:: Type = ");
        sb.append(this.$type);
        sb.append(", MainPath = Search");
        Logger.d(sb.toString(), new Object[0]);
    }
}
