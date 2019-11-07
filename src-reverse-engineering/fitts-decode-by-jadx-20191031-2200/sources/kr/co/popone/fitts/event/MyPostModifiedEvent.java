package kr.co.popone.fitts.event;

public final class MyPostModifiedEvent {
    private final long postID;

    public MyPostModifiedEvent(long j) {
        this.postID = j;
    }

    public final long getPostID() {
        return this.postID;
    }
}
