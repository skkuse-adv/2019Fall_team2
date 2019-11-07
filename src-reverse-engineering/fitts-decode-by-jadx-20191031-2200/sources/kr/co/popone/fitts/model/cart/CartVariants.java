package kr.co.popone.fitts.model.cart;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartVariants {
    @SerializedName("additional_price")
    private final int additionalPrice;
    @SerializedName("discount_percentage")
    private final double discountPercentage;
    private final long id;
    @SerializedName("options")
    @NotNull
    private final List<VariantInfoOption> option;
    @SerializedName("origin_price")
    private final int originPrice;
    @SerializedName("price")
    private final int price;
    @SerializedName("product")
    @NotNull
    private final Product product;
    @SerializedName("sales_price")
    private final int salesPrice;
    @SerializedName("state")
    @NotNull
    private final String state;

    @NotNull
    public static /* synthetic */ CartVariants copy$default(CartVariants cartVariants, long j, String str, int i, int i2, int i3, double d, List list, Product product2, int i4, int i5, Object obj) {
        CartVariants cartVariants2 = cartVariants;
        int i6 = i5;
        return cartVariants.copy((i6 & 1) != 0 ? cartVariants2.id : j, (i6 & 2) != 0 ? cartVariants2.state : str, (i6 & 4) != 0 ? cartVariants2.additionalPrice : i, (i6 & 8) != 0 ? cartVariants2.originPrice : i2, (i6 & 16) != 0 ? cartVariants2.salesPrice : i3, (i6 & 32) != 0 ? cartVariants2.discountPercentage : d, (i6 & 64) != 0 ? cartVariants2.option : list, (i6 & 128) != 0 ? cartVariants2.product : product2, (i6 & 256) != 0 ? cartVariants2.price : i4);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.state;
    }

    public final int component3() {
        return this.additionalPrice;
    }

    public final int component4() {
        return this.originPrice;
    }

    public final int component5() {
        return this.salesPrice;
    }

    public final double component6() {
        return this.discountPercentage;
    }

    @NotNull
    public final List<VariantInfoOption> component7() {
        return this.option;
    }

    @NotNull
    public final Product component8() {
        return this.product;
    }

    public final int component9() {
        return this.price;
    }

    @NotNull
    public final CartVariants copy(long j, @NotNull String str, int i, int i2, int i3, double d, @NotNull List<VariantInfoOption> list, @NotNull Product product2, int i4) {
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str2, ServerProtocol.DIALOG_PARAM_STATE);
        List<VariantInfoOption> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "option");
        Product product3 = product2;
        Intrinsics.checkParameterIsNotNull(product3, "product");
        CartVariants cartVariants = new CartVariants(j, str2, i, i2, i3, d, list2, product3, i4);
        return cartVariants;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartVariants) {
                CartVariants cartVariants = (CartVariants) obj;
                if ((this.id == cartVariants.id) && Intrinsics.areEqual((Object) this.state, (Object) cartVariants.state)) {
                    if (this.additionalPrice == cartVariants.additionalPrice) {
                        if (this.originPrice == cartVariants.originPrice) {
                            if ((this.salesPrice == cartVariants.salesPrice) && Double.compare(this.discountPercentage, cartVariants.discountPercentage) == 0 && Intrinsics.areEqual((Object) this.option, (Object) cartVariants.option) && Intrinsics.areEqual((Object) this.product, (Object) cartVariants.product)) {
                                if (this.price == cartVariants.price) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.state;
        int i2 = 0;
        int hashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.additionalPrice) * 31) + this.originPrice) * 31) + this.salesPrice) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.discountPercentage);
        int i3 = (hashCode + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
        List<VariantInfoOption> list = this.option;
        int hashCode2 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        Product product2 = this.product;
        if (product2 != null) {
            i2 = product2.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.price;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartVariants(id=");
        sb.append(this.id);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", additionalPrice=");
        sb.append(this.additionalPrice);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", discountPercentage=");
        sb.append(this.discountPercentage);
        sb.append(", option=");
        sb.append(this.option);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(")");
        return sb.toString();
    }

    public CartVariants(long j, @NotNull String str, int i, int i2, int i3, double d, @NotNull List<VariantInfoOption> list, @NotNull Product product2, int i4) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(list, "option");
        Intrinsics.checkParameterIsNotNull(product2, "product");
        this.id = j;
        this.state = str;
        this.additionalPrice = i;
        this.originPrice = i2;
        this.salesPrice = i3;
        this.discountPercentage = d;
        this.option = list;
        this.product = product2;
        this.price = i4;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    public final int getAdditionalPrice() {
        return this.additionalPrice;
    }

    public final int getOriginPrice() {
        return this.originPrice;
    }

    public final int getSalesPrice() {
        return this.salesPrice;
    }

    public final double getDiscountPercentage() {
        return this.discountPercentage;
    }

    @NotNull
    public final List<VariantInfoOption> getOption() {
        return this.option;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    public final int getPrice() {
        return this.price;
    }
}
