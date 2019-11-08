package kr.co.popone.fitts.model.search;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface SearchHistoryRepository {
    @NotNull
    List<String> getHistory();

    void loadHistory();

    void saveHistory();

    void setHistory(@NotNull List<String> list);
}
