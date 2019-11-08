package com.crashlytics.android.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class ClsFileOutputStream extends FileOutputStream {
    public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
    public static final String SESSION_FILE_EXTENSION = ".cls";
    public static final FilenameFilter TEMP_FILENAME_FILTER = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION);
        }
    };
    private boolean closed;
    private File complete;
    private File inProgress;
    private final String root;

    public ClsFileOutputStream(String str, String str2) throws FileNotFoundException {
        this(new File(str), str2);
    }

    public ClsFileOutputStream(File file, String str) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = IN_PROGRESS_SESSION_FILE_EXTENSION;
        sb.append(str2);
        super(new File(file, sb.toString()));
        this.closed = false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file);
        sb2.append(File.separator);
        sb2.append(str);
        this.root = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.root);
        sb3.append(str2);
        this.inProgress = new File(sb3.toString());
    }

    public synchronized void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
            StringBuilder sb = new StringBuilder();
            sb.append(this.root);
            sb.append(SESSION_FILE_EXTENSION);
            File file = new File(sb.toString());
            if (this.inProgress.renameTo(file)) {
                this.inProgress = null;
                this.complete = file;
                return;
            }
            String str = "";
            if (file.exists()) {
                str = " (target already exists)";
            } else if (!this.inProgress.exists()) {
                str = " (source does not exist)";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not rename temp file: ");
            sb2.append(this.inProgress);
            sb2.append(" -> ");
            sb2.append(file);
            sb2.append(str);
            throw new IOException(sb2.toString());
        }
    }

    public void closeInProgressStream() throws IOException {
        if (!this.closed) {
            this.closed = true;
            super.flush();
            super.close();
        }
    }

    public File getCompleteFile() {
        return this.complete;
    }

    public File getInProgressFile() {
        return this.inProgress;
    }
}
