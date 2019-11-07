package kr.co.popone.fitts.model.validation;

import com.uber.rave.Rave;
import com.uber.rave.RaveException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class RaveConverterFactory extends Factory {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RaveConverterFactory create() {
            return new RaveConverterFactory();
        }
    }

    private static final class RaveResponseConverter implements Converter<ResponseBody, Object> {
        @NotNull
        private final Converter<ResponseBody, ?> delegateConverter;

        public RaveResponseConverter(@NotNull Converter<ResponseBody, ?> converter) {
            Intrinsics.checkParameterIsNotNull(converter, "delegateConverter");
            this.delegateConverter = converter;
        }

        @NotNull
        public final Converter<ResponseBody, ?> getDelegateConverter() {
            return this.delegateConverter;
        }

        @NotNull
        public Object convert(@NotNull ResponseBody responseBody) {
            Intrinsics.checkParameterIsNotNull(responseBody, "value");
            Object convert = this.delegateConverter.convert(responseBody);
            try {
                if (convert instanceof List) {
                    for (Object next : (List) convert) {
                        if (next != null) {
                            Rave.getInstance().validateIgnoreUnsupported(next);
                        }
                    }
                } else {
                    Rave.getInstance().validateIgnoreUnsupported(convert);
                }
                Intrinsics.checkExpressionValueIsNotNull(convert, "convert");
                return convert;
            } catch (RaveException e) {
                throw new IOException(e);
            }
        }
    }

    @NotNull
    public static final RaveConverterFactory create() {
        return Companion.create();
    }

    @NotNull
    public Converter<ResponseBody, ?> responseBodyConverter(@NotNull Type type, @NotNull Annotation[] annotationArr, @NotNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(annotationArr, "annotations");
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Converter nextResponseBodyConverter = retrofit.nextResponseBodyConverter(this, type, annotationArr);
        Intrinsics.checkExpressionValueIsNotNull(nextResponseBodyConverter, "delegateConverter");
        return new RaveResponseConverter(nextResponseBodyConverter);
    }
}
