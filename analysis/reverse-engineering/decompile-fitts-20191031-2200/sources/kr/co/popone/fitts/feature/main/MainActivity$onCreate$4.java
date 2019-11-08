package kr.co.popone.fitts.feature.main;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import kr.co.popone.fitts.model.category.CategoryViewData;
import retrofit2.HttpException;

final class MainActivity$onCreate$4<T1, T2> implements BiConsumer<List<? extends CategoryViewData>, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$4(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(List<CategoryViewData> list, Throwable th) {
        if (list != null) {
            this.this$0.categoryAdapter.setCategories(list);
        } else if (!(th instanceof HttpException)) {
            Logger.d("ErrorOccur::getCategoryList", new Object[0]);
            this.this$0.showMessage("죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0, IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
