class HitungDiskon(var totalPayment: Int) {
    var discountTotal: Double = 0.0
    var totalPaymentAfterDiscount: Double = 0.0

    fun discount(totalPayment: Int, memberDiscount: Double): Int {
        discountTotal = (totalPayment * memberDiscount) / 100
        totalPaymentAfterDiscount = totalPayment - discountTotal

        return totalPaymentAfterDiscount.toInt()
    }

    fun discount(totalPayment: Int) {
        discountTotal = (totalPayment * 0).toDouble()
        totalPaymentAfterDiscount = totalPayment - discountTotal
    }
}