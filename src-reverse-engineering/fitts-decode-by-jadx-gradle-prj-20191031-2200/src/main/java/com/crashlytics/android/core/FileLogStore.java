package com.crashlytics.android.core;

interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    ByteString getLogAsByteString();

    byte[] getLogAsBytes();

    void writeToLog(long j, String str);
}
