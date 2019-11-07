package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
    private volatile byte[] buf;
    private final ArrayPool byteArrayPool;
    private int count;
    private int marklimit;
    private int markpos;
    private int pos;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    @VisibleForTesting
    RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i) {
        super(inputStream);
        this.markpos = -1;
        this.byteArrayPool = arrayPool;
        this.buf = (byte[]) arrayPool.get(i, byte[].class);
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.buf == null || inputStream == null) {
            throw streamClosed();
        }
        return (this.count - this.pos) + inputStream.available();
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    public synchronized void release() {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
    }

    public void close() throws IOException {
        if (this.buf != null) {
            this.byteArrayPool.put(this.buf);
            this.buf = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.markpos;
        if (i != -1) {
            int i2 = this.pos - i;
            int i3 = this.marklimit;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) this.byteArrayPool.get(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.buf = bArr2;
                    this.byteArrayPool.put(bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.markpos;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.pos -= this.markpos;
                this.markpos = 0;
                this.count = 0;
                int i5 = this.pos;
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                int i6 = this.pos;
                if (read > 0) {
                    i6 += read;
                }
                this.count = i6;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.markpos = -1;
            this.pos = 0;
            this.count = read2;
        }
        return read2;
    }

    public synchronized void mark(int i) {
        this.marklimit = Math.max(this.marklimit, i);
        this.markpos = this.pos;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0018=Splitter:B:11:0x0018, B:27:0x003b=Splitter:B:27:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.buf     // Catch:{ all -> 0x0040 }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r2 = r5.pos     // Catch:{ all -> 0x0040 }
            int r3 = r5.count     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r2 < r3) goto L_0x0018
            int r1 = r5.fillbuf(r1, r0)     // Catch:{ all -> 0x0040 }
            if (r1 != r4) goto L_0x0018
            monitor-exit(r5)
            return r4
        L_0x0018:
            byte[] r1 = r5.buf     // Catch:{ all -> 0x0040 }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.buf     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.io.IOException r0 = streamClosed()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0026:
            int r1 = r5.count     // Catch:{ all -> 0x0040 }
            int r2 = r5.pos     // Catch:{ all -> 0x0040 }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r5.pos     // Catch:{ all -> 0x0040 }
            int r2 = r1 + 1
            r5.pos = r2     // Catch:{ all -> 0x0040 }
            byte r0 = r0[r1]     // Catch:{ all -> 0x0040 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0039:
            monitor-exit(r5)
            return r4
        L_0x003b:
            java.io.IOException r0 = streamClosed()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0050, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x005d, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(@androidx.annotation.NonNull byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.buf     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0099
            if (r8 != 0) goto L_0x000a
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x000a:
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0094
            int r2 = r5.pos     // Catch:{ all -> 0x009e }
            int r3 = r5.count     // Catch:{ all -> 0x009e }
            if (r2 >= r3) goto L_0x003b
            int r2 = r5.count     // Catch:{ all -> 0x009e }
            int r3 = r5.pos     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
            if (r2 < r8) goto L_0x001d
            r2 = r8
            goto L_0x0022
        L_0x001d:
            int r2 = r5.count     // Catch:{ all -> 0x009e }
            int r3 = r5.pos     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
        L_0x0022:
            int r3 = r5.pos     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ all -> 0x009e }
            int r3 = r5.pos     // Catch:{ all -> 0x009e }
            int r3 = r3 + r2
            r5.pos = r3     // Catch:{ all -> 0x009e }
            if (r2 == r8) goto L_0x0039
            int r3 = r1.available()     // Catch:{ all -> 0x009e }
            if (r3 != 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            int r7 = r7 + r2
            int r2 = r8 - r2
            goto L_0x003c
        L_0x0039:
            monitor-exit(r5)
            return r2
        L_0x003b:
            r2 = r8
        L_0x003c:
            int r3 = r5.markpos     // Catch:{ all -> 0x009e }
            r4 = -1
            if (r3 != r4) goto L_0x0051
            int r3 = r0.length     // Catch:{ all -> 0x009e }
            if (r2 < r3) goto L_0x0051
            int r3 = r1.read(r6, r7, r2)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x0084
            if (r2 != r8) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            int r4 = r8 - r2
        L_0x004f:
            monitor-exit(r5)
            return r4
        L_0x0051:
            int r3 = r5.fillbuf(r1, r0)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x005e
            if (r2 != r8) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            int r4 = r8 - r2
        L_0x005c:
            monitor-exit(r5)
            return r4
        L_0x005e:
            byte[] r3 = r5.buf     // Catch:{ all -> 0x009e }
            if (r0 == r3) goto L_0x006c
            byte[] r0 = r5.buf     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            java.io.IOException r6 = streamClosed()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x006c:
            int r3 = r5.count     // Catch:{ all -> 0x009e }
            int r4 = r5.pos     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
            if (r3 < r2) goto L_0x0075
            r3 = r2
            goto L_0x007a
        L_0x0075:
            int r3 = r5.count     // Catch:{ all -> 0x009e }
            int r4 = r5.pos     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
        L_0x007a:
            int r4 = r5.pos     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r4, r6, r7, r3)     // Catch:{ all -> 0x009e }
            int r4 = r5.pos     // Catch:{ all -> 0x009e }
            int r4 = r4 + r3
            r5.pos = r4     // Catch:{ all -> 0x009e }
        L_0x0084:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x0089
            monitor-exit(r5)
            return r8
        L_0x0089:
            int r4 = r1.available()     // Catch:{ all -> 0x009e }
            if (r4 != 0) goto L_0x0092
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x0092:
            int r7 = r7 + r3
            goto L_0x003c
        L_0x0094:
            java.io.IOException r6 = streamClosed()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x0099:
            java.io.IOException r6 = streamClosed()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x009e:
            r6 = move-exception
            monitor-exit(r5)
            goto L_0x00a2
        L_0x00a1:
            throw r6
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.markpos) {
            this.pos = this.markpos;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Mark has been invalidated, pos: ");
            sb.append(this.pos);
            sb.append(" markLimit: ");
            sb.append(this.marklimit);
            throw new InvalidMarkException(sb.toString());
        }
    }

    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.buf;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                throw streamClosed();
            } else if (((long) (this.count - this.pos)) >= j) {
                this.pos = (int) (((long) this.pos) + j);
                return j;
            } else {
                long j2 = ((long) this.count) - ((long) this.pos);
                this.pos = this.count;
                if (this.markpos == -1 || j > ((long) this.marklimit)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (fillbuf(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (((long) (this.count - this.pos)) >= j - j2) {
                        this.pos = (int) ((((long) this.pos) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) this.count)) - ((long) this.pos);
                    this.pos = this.count;
                    return j3;
                }
            }
        } else {
            throw streamClosed();
        }
    }
}
