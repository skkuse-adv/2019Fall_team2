package com.kakao.network.multipart;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

public class MultipartRequestEntity {
    private static final String ASCII_CHARSET_NAME = "US-ASCII";
    private static final byte[] MULTIPART_CHARS = getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    private static final Random RANDOM = new Random();
    private final long contentLength;
    private final String contentType = computeContentType(MULTIPART_FORM_CONTENT_TYPE);
    private final byte[] multipartBoundary = generateMultipartBoundary();
    private final List<Part> parts;

    public static byte[] getAsciiBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(ASCII_CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("data may not be null");
        }
    }

    public static byte[] getBytes(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("data may not be null");
        } else if (str2 == null || str2.isEmpty()) {
            throw new IllegalArgumentException("charset may not be null or empty");
        } else {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException unused) {
                throw new IllegalArgumentException(String.format("Unsupported encoding: %s", new Object[]{str2}));
            }
        }
    }

    private static byte[] generateMultipartBoundary() {
        byte[] bArr = new byte[(RANDOM.nextInt(11) + 30)];
        for (int i = 0; i < bArr.length; i++) {
            byte[] bArr2 = MULTIPART_CHARS;
            bArr[i] = bArr2[RANDOM.nextInt(bArr2.length)];
        }
        return bArr;
    }

    public MultipartRequestEntity(List<Part> list) {
        this.parts = list;
        this.contentLength = Part.getLengthOfParts(list, this.multipartBoundary);
    }

    private String computeContentType(String str) {
        StringBuilder sb = new StringBuilder(str);
        String str2 = ";";
        if (!str.endsWith(str2)) {
            sb.append(str2);
        }
        try {
            sb.append(" boundary=");
            sb.append(new String(this.multipartBoundary, ASCII_CHARSET_NAME));
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        Part.sendParts(outputStream, this.parts, this.multipartBoundary);
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }
}
