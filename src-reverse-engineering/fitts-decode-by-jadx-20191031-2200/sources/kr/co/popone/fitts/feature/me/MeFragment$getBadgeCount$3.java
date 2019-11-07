package kr.co.popone.fitts.feature.me;

import android.content.Intent;
import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.intro.IntroActivity;
import retrofit2.HttpException;

final class MeFragment$getBadgeCount$3<T> implements Consumer<Throwable> {
    final /* synthetic */ MeFragment this$0;

    MeFragment$getBadgeCount$3(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error occured ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        if (!(th instanceof HttpException)) {
            this.this$0.showMessage("죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
        } else if (((HttpException) th).code() == 401) {
            Intent intent = new Intent(this.this$0.getContext(), IntroActivity.class);
            intent.addFlags(32768);
            intent.addFlags(268435456);
            this.this$0.startActivity(intent);
        }
    }
}
