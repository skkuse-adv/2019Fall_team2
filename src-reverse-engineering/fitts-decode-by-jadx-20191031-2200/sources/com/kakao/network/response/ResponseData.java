package com.kakao.network.response;

public class ResponseData {
    private final byte[] data;
    private final int httpStatusCode;

    public ResponseData(int i, byte[] bArr) {
        this.httpStatusCode = i;
        this.data = bArr;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getStringData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return null;
        }
        return new String(bArr);
    }
}
