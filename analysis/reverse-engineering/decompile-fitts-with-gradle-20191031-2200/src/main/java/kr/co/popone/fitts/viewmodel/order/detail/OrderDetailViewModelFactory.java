package kr.co.popone.fitts.viewmodel.order.detail;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final CreatePostActivityUtil createPostActivityUtil;

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    public OrderDetailViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull CreatePostActivityUtil createPostActivityUtil2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(createPostActivityUtil2, "createPostActivityUtil");
        this.commerceRepository = fittsCommerceRepository;
        this.createPostActivityUtil = createPostActivityUtil2;
    }

    @NotNull
    public final CreatePostActivityUtil getCreatePostActivityUtil() {
        return this.createPostActivityUtil;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new OrderDetailViewModel(this.commerceRepository, this.createPostActivityUtil);
    }
}
