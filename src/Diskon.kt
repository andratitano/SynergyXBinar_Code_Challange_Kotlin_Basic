abstract class Diskon() {
    companion object Discound {
        const val memberDiscount: Double = 9.5
        const val nonMemberDiscount: Double = 4.1
    }

    abstract  fun login()
    protected abstract fun checkoutPelanggan()
    protected abstract fun memberInputItem()
    protected abstract fun nonMemberInputItem()
}