package retrofit2.converter.scalars;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class ScalarsConverterFactory extends Factory {
    public static ScalarsConverterFactory create() {
        return new ScalarsConverterFactory();
    }

    private ScalarsConverterFactory() {
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return ScalarRequestBodyConverter.INSTANCE;
        }
        return null;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == String.class) {
            return StringResponseBodyConverter.INSTANCE;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return BooleanResponseBodyConverter.INSTANCE;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return ByteResponseBodyConverter.INSTANCE;
        }
        if (type == Character.class || type == Character.TYPE) {
            return CharacterResponseBodyConverter.INSTANCE;
        }
        if (type == Double.class || type == Double.TYPE) {
            return DoubleResponseBodyConverter.INSTANCE;
        }
        if (type == Float.class || type == Float.TYPE) {
            return FloatResponseBodyConverter.INSTANCE;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return IntegerResponseBodyConverter.INSTANCE;
        }
        if (type == Long.class || type == Long.TYPE) {
            return LongResponseBodyConverter.INSTANCE;
        }
        if (type == Short.class || type == Short.TYPE) {
            return ShortResponseBodyConverter.INSTANCE;
        }
        return null;
    }
}
