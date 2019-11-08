package kr.co.popone.fitts.feature.category;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Action;

final class CategorySearchFragment$onPostClick$1$1 implements Action {
    final /* synthetic */ int $it;

    CategorySearchFragment$onPostClick$1$1(int i) {
        this.$it = i;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogSuccess:: Type = Post, MainPath = Category, SubId = ");
        sb.append(this.$it);
        Logger.d(sb.toString(), new Object[0]);
    }
}
