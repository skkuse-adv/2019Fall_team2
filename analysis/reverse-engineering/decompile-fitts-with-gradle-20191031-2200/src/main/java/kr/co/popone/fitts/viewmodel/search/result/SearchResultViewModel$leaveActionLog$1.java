package kr.co.popone.fitts.viewmodel.search.result;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Action;

final class SearchResultViewModel$leaveActionLog$1 implements Action {
    final /* synthetic */ String $type;

    SearchResultViewModel$leaveActionLog$1(String str) {
        this.$type = str;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogSuccess:: Type = ");
        sb.append(this.$type);
        sb.append(", MainPath = Search");
        Logger.d(sb.toString(), new Object[0]);
    }
}
