package com.kakao.network.multipart;

import java.io.IOException;
import java.io.OutputStream;

public class StringPart extends Part {
    private static final String DEFAULT_STRING_PART_CHARSET = "UTF-8";
    private static final String DEFAULT_STRING_PART_CONTENT_TYPE = "text/plain";
    private static final String DEFAULT_STRING_PART_TRANSFER_ENCODING = "8bit";
    private byte[] content;
    private final String value;

    public StringPart(String str, String str2) {
        this(str, str2, DEFAULT_STRING_PART_CONTENT_TYPE, "UTF-8", DEFAULT_STRING_PART_TRANSFER_ENCODING);
    }

    public StringPart(String str, String str2, String str3, String str4, String str5) {
        if (str3 == null || str3.isEmpty()) {
            str3 = DEFAULT_STRING_PART_CONTENT_TYPE;
        }
        if (str4 == null || str4.isEmpty()) {
            str4 = "UTF-8";
        }
        if (str5 == null || str5.isEmpty()) {
            str5 = DEFAULT_STRING_PART_TRANSFER_ENCODING;
        }
        super(str, str3, str4, str5);
        this.value = str2;
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        outputStream.write(getContent());
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() {
        return (long) getContent().length;
    }

    private byte[] getContent() {
        if (this.content == null) {
            this.content = MultipartRequestEntity.getBytes(this.value, this.charsetString);
        }
        return this.content;
    }
}
