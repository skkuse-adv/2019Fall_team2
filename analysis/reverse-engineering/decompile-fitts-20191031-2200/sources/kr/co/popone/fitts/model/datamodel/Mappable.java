package kr.co.popone.fitts.model.datamodel;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface Mappable<K, V> {
    @NotNull
    Map<K, V> toMap();
}
