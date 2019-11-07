package kr.co.popone.fitts.model.search;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class RealSearchHistoryRepository implements SearchHistoryRepository {
    private final Context context;
    @NotNull
    private List<String> history = CollectionsKt__CollectionsKt.emptyList();
    private final String preferenceName;

    public RealSearchHistoryRepository(@NotNull Context context2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(str, "preferenceName");
        this.context = context2;
        this.preferenceName = str;
    }

    @NotNull
    public List<String> getHistory() {
        return this.history;
    }

    public void setHistory(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.history = list;
    }

    public void loadHistory() {
        List list;
        String string = this.context.getSharedPreferences(this.preferenceName, 0).getString(this.preferenceName, null);
        if (string != null) {
            Object fromJson = new Gson().fromJson(string, (Type) List.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson<List<Strin…istory, List::class.java)");
            list = (List) fromJson;
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        setHistory(list);
    }

    public void saveHistory() {
        Editor edit = this.context.getSharedPreferences(this.preferenceName, 0).edit();
        edit.putString(this.preferenceName, new Gson().toJson((Object) getHistory()));
        edit.apply();
    }
}
