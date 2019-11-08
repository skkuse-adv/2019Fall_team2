package kotlinx.coroutines;

import com.kakao.message.template.MessageTemplateProtocol;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class InactiveNodeList implements Incomplete {
    @NotNull
    private final NodeList list;

    public boolean isActive() {
        return false;
    }

    public InactiveNodeList(@NotNull NodeList nodeList) {
        Intrinsics.checkParameterIsNotNull(nodeList, MessageTemplateProtocol.TYPE_LIST);
        this.list = nodeList;
    }

    @NotNull
    public NodeList getList() {
        return this.list;
    }

    @NotNull
    public String toString() {
        return getList().getString("New");
    }
}
