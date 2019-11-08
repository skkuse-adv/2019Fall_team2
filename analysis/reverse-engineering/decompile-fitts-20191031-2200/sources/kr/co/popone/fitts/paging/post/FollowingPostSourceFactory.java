package kr.co.popone.fitts.paging.post;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.repository.PostRepository;
import org.jetbrains.annotations.NotNull;

public final class FollowingPostSourceFactory extends Factory<Long, Post> {
    @NotNull
    private final MutableLiveData<FollowingPostDataSource> followingPostLiveData = new MutableLiveData<>();
    private final PostRepository postRepository;

    public FollowingPostSourceFactory(@NotNull PostRepository postRepository2) {
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        this.postRepository = postRepository2;
    }

    @NotNull
    public final MutableLiveData<FollowingPostDataSource> getFollowingPostLiveData() {
        return this.followingPostLiveData;
    }

    @NotNull
    public DataSource<Long, Post> create() {
        FollowingPostDataSource followingPostDataSource = new FollowingPostDataSource(this.postRepository);
        this.followingPostLiveData.postValue(followingPostDataSource);
        return followingPostDataSource;
    }
}
