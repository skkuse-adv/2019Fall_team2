package com.google.firebase.platforminfo;

final class AutoValue_LibraryVersion extends LibraryVersion {
    private final String libraryName;
    private final String version;

    AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.libraryName = str;
            if (str2 != null) {
                this.version = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibraryVersion{libraryName=");
        sb.append(this.libraryName);
        sb.append(", version=");
        sb.append(this.version);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        if (!this.libraryName.equals(libraryVersion.getLibraryName()) || !this.version.equals(libraryVersion.getVersion())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }
}
