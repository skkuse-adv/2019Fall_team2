package com.kakao.network.multipart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilePart extends Part {
    private static final String DEFAULT_FILE_PART_CHARSET = "ISO-8859-1";
    private static final String DEFAULT_FILE_PART_CONTENT_TYPE = "application/octet-stream";
    private static final String DEFAULT_FILE_PART_TRANSFER_ENCODING = "binary";
    private static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = MultipartRequestEntity.getAsciiBytes(FILE_NAME);
    private final File content;

    public FilePart(String str, File file) {
        this(str, file, DEFAULT_FILE_PART_CONTENT_TYPE, DEFAULT_FILE_PART_CHARSET, DEFAULT_FILE_PART_TRANSFER_ENCODING);
    }

    public FilePart(String str, File file, String str2, String str3, String str4) {
        if (str2 == null || str2.isEmpty()) {
            str2 = DEFAULT_FILE_PART_CONTENT_TYPE;
        }
        if (str3 == null || str3.isEmpty()) {
            str3 = DEFAULT_FILE_PART_CHARSET;
        }
        if (str4 == null || str4.isEmpty()) {
            str4 = DEFAULT_FILE_PART_TRANSFER_ENCODING;
        }
        super(str, str2, str3, str4);
        this.content = file;
    }

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        super.sendDispositionHeader(outputStream);
        String name = this.content.getName();
        if (name != null) {
            outputStream.write(FILE_NAME_BYTES);
            outputStream.write(Part.QUOTE_BYTES);
            outputStream.write(MultipartRequestEntity.getAsciiBytes(name));
            outputStream.write(Part.QUOTE_BYTES);
        }
    }

    /* access modifiers changed from: protected */
    public long dispositionHeaderLength() {
        String name = this.content.getName();
        long dispositionHeaderLength = super.dispositionHeaderLength();
        return name != null ? dispositionHeaderLength + ((long) FILE_NAME_BYTES.length) + ((long) Part.QUOTE_BYTES.length) + ((long) MultipartRequestEntity.getAsciiBytes(name).length) + ((long) Part.QUOTE_BYTES.length) : dispositionHeaderLength;
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        if (lengthOfData() != 0) {
            byte[] bArr = new byte[4096];
            File file = this.content;
            InputStream fileInputStream = file != null ? new FileInputStream(file) : new ByteArrayInputStream(new byte[0]);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read >= 0) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                } finally {
                    fileInputStream.close();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() {
        File file = this.content;
        if (file != null) {
            return file.length();
        }
        return 0;
    }
}
