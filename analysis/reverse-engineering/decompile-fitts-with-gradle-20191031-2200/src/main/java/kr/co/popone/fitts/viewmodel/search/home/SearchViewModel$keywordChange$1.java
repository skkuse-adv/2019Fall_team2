package kr.co.popone.fitts.viewmodel.search.home;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState;
import org.jetbrains.annotations.NotNull;

final class SearchViewModel$keywordChange$1 extends FunctionReference implements Function1<CharSequence, SearchState> {
    SearchViewModel$keywordChange$1(SearchViewModel searchViewModel) {
        super(1, searchViewModel);
    }

    public final String getName() {
        return "charSeqToState";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(SearchViewModel.class);
    }

    public final String getSignature() {
        return "charSeqToState(Ljava/lang/CharSequence;)Lkr/co/popone/fitts/viewmodel/search/home/SearchViewModel$SearchState;";
    }

    @NotNull
    public final SearchState invoke(@NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(charSequence, "p1");
        return ((SearchViewModel) this.receiver).charSeqToState(charSequence);
    }
}
