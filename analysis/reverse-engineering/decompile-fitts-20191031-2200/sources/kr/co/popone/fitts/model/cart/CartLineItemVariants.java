package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartLineItemVariants {
    private final long id;
    @SerializedName("price")
    private final int price;
    @SerializedName("quantity")
    private final int quantity;
    @SerializedName("special_discount_info")
    @NotNull
    private final SpecialDiscount specialDiscountInfo;
    @SerializedName("variant")
    @NotNull
    private final CartVariants variant;

    @NotNull
    public static /* synthetic */ CartLineItemVariants copy$default(CartLineItemVariants cartLineItemVariants, long j, CartVariants cartVariants, int i, int i2, SpecialDiscount specialDiscount, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = cartLineItemVariants.id;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            cartVariants = cartLineItemVariants.variant;
        }
        CartVariants cartVariants2 = cartVariants;
        if ((i3 & 4) != 0) {
            i = cartLineItemVariants.quantity;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = cartLineItemVariants.price;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            specialDiscount = cartLineItemVariants.specialDiscountInfo;
        }
        return cartLineItemVariants.copy(j2, cartVariants2, i4, i5, specialDiscount);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final CartVariants component2() {
        return this.variant;
    }

    public final int component3() {
        return this.quantity;
    }

    public final int component4() {
        return this.price;
    }

    @NotNull
    public final SpecialDiscount component5() {
        return this.specialDiscountInfo;
    }

    @NotNull
    public final CartLineItemVariants copy(long j, @NotNull CartVariants cartVariants, int i, int i2, @NotNull SpecialDiscount specialDiscount) {
        Intrinsics.checkParameterIsNotNull(cartVariants, "variant");
        Intrinsics.checkParameterIsNotNull(specialDiscount, "specialDiscountInfo");
        CartLineItemVariants cartLineItemVariants = new CartLineItemVariants(j, cartVariants, i, i2, specialDiscount);
        return cartLineItemVariants;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartLineItemVariants) {
                CartLineItemVariants cartLineItemVariants = (CartLineItemVariants) obj;
                if ((this.id == cartLineItemVariants.id) && Intrinsics.areEqual((Object) this.variant, (Object) cartLineItemVariants.variant)) {
                    if (this.quantity == cartLineItemVariants.quantity) {
                        if (!(this.price == cartLineItemVariants.price) || !Intrinsics.areEqual((Object) this.specialDiscountInfo, (Object) cartLineItemVariants.specialDiscountInfo)) {
                            return false;
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
        CartVariants cartVariants = this.variant;
        int i2 = 0;
        int hashCode = (((((i + (cartVariants != null ? cartVariants.hashCode() : 0)) * 31) + this.quantity) * 31) + this.price) * 31;
        SpecialDiscount specialDiscount = this.specialDiscountInfo;
        if (specialDiscount != null) {
            i2 = specialDiscount.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartLineItemVariants(id=");
        sb.append(this.id);
        sb.append(", variant=");
        sb.append(this.variant);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", specialDiscountInfo=");
        sb.append(this.specialDiscountInfo);
        sb.append(")");
        return sb.toString();
    }

    public CartLineItemVariants(long j, @NotNull CartVariants cartVariants, int i, int i2, @NotNull SpecialDiscount specialDiscount) {
        Intrinsics.checkParameterIsNotNull(cartVariants, "variant");
        Intrinsics.checkParameterIsNotNull(specialDiscount, "specialDiscountInfo");
        this.id = j;
        this.variant = cartVariants;
        this.quantity = i;
        this.price = i2;
        this.specialDiscountInfo = specialDiscount;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final CartVariants getVariant() {
        return this.variant;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final int getPrice() {
        return this.price;
    }

    @NotNull
    public final SpecialDiscount getSpecialDiscountInfo() {
        return this.specialDiscountInfo;
    }
}
