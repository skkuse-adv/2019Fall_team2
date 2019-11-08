package kr.co.popone.fitts.feature.event;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters;

final class AppliableEventApplyActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$4(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0, ShopSearchActivity.class);
        intent.putExtra("parameters", new Parameters("쇼핑몰홈 링크 주소가 아닌\n상세페이지 링크 주소가 맞는지 확인해주세요", Integer.valueOf(C0008R$drawable.img_icon_wish), "상품 찜하기", "현재 보고있는 상품의 링크 주소가 자동으로 입력됩니다."));
        this.this$0.startActivityForResult(intent, 100);
    }
}
