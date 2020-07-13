import java.lang.NumberFormatException

class Mart: Diskon(){
    private val username = arrayOf("Andra", "Wisnu", "MasAgus")
    private val password = arrayOf("A123", "W123","apaajaboleh")
    private var usernameInput: String = ""
    private var passwordInput: String = ""

    var isLogin: Boolean = false
    var loginUsername: String = ""
    var loginPassword: String = ""
    private val member = ArrayList<String>()

    var item = ArrayList<String>()
    var itemOne = ArrayList<Int>()
    var itemTotal = ArrayList<Int>()

    var inputMember: String = ""
    var inputItem: String = ""
    var inputItemOne: Int = 0
    var inputItemTotal: Int = 0
    var itemTotalCounter: Int = 0
    var totalPayment: Int = 0
    var memberReqDiscount: Int = 50000
    var nonMemberReqDiscount: Int = 70000
    var discountTotal: Double = 0.0
    var totalPaymentAfterDiscount: Double = 0.0
    var customerMoney: Int = 0
    var tambahLagi: String = ""
    val charY: Char = 'Y'
    val charN: Char = 'N'


    override fun login() {
        addMember()
        isLogin = false
        println("-------------------------------")
        println(" Selamat Datang di Synrgy Mart ")
        println("-------------------------------")
        println("+ Login Kasir +")
        print("Username : ")
        loginUsername = readLine().toString()
        print("Password : ")
        loginPassword = readLine().toString()
        println("-------------------------------")
        for (i in 0..2) {
            if ((loginUsername == username[i]) && (loginPassword == password[i])) {
                println("Login Berhasil")
                isLogin = true
                masuk()
            }
        }
        if (isLogin == false) {
            println("ALERT : Login Gagal!")
            login()
        }
    }


    fun masuk() {
        println("---------------------------")
        println("Selamat Datang, ${this.usernameInput}")
        println("1. Checkout Pelanggan")
        println("0. Logout")

        val input = readLine()!!
        when (input) {
            "1" -> checkoutPelanggan()
            "0" -> welcome()
            else -> {
                println("Input Salah")
                masuk()
            }

        }


    }


    fun addMember() {
        member.add("Wisnu")
        member.add("Hanif")
        member.add("Nanda")
        member.add("Andra")
    }

    override fun checkoutPelanggan() {
        println("---------------------------")
        println("Checkout Pelanggan")
        println("1. Pelanggan Member")
        println("2. Pelanggan Non-Member")
        println("---------------------------")

        val input = readLine()!!
        when (input) {
            "1" -> member()
            "2" -> nonMemberInputItem()
            else -> {
                println("Input Salah")
                checkoutPelanggan()

            }

        }


    }

    /*   when(readline()){
       "1" -> checkoutPelanggan()
       "0" -> welcome()
       else -> {
           println("Input Salah")
           masuk()
       }
   } */

    fun member() {
        println("---------------------------")
        println("Checkout Pelanggan Member")
        println("---------------------------")
        println("Input Nama Member: ")
        println("---------------------------")
        inputMember = readLine().toString()
        for (i in member) {
            if (inputMember == i) {
                println("Member Terdaftar")
                memberInputItem()

            }

        }
        println("Nama Tidak Terdaftar. Silakan Masukkan Kembali.")
        member()



    }

    override fun memberInputItem() {
        println("-------------------------------")
        println(" Checkout Pelanggan Member $inputMember")
        println("-------------------------------")
        print("Input Nama Barang         : ")
        inputItem = readLine().toString()
        print("Input Harga Satuan Barang : ")
        try {
            inputItemOne = Integer.valueOf(readLine())
        } catch (e: NumberFormatException) {
            println("Input Harga Satuan Harus Berupa INTEGER")
            memberInputItem()
        }
        print("Input Jumlah Barang       : ")
        try {
            inputItemTotal = Integer.valueOf(readLine())
        } catch (e: NumberFormatException) {
            println("Input Jumlah Barang Harus Berupa INTEGER")
            memberInputItem()
        }
        println("-------------------------------")
        item.add(inputItem)
        itemOne.add(inputItemOne)
        itemTotal.add(inputItemTotal)
        itemTotalCounter++
        memberInputItemChoice()
    }

    fun memberInputItemChoice() {
        print("Input Barang Lagi? (Y/N) : ")
        tambahLagi = readLine().toString()
        when (tambahLagi) {
            charY.toString() -> {
                memberInputItem()
            }
            charN.toString() -> {
                memberItemList()
            }
            else -> {
                println("ALERT : Input Salah!")
                memberInputItemChoice()
            }
        }
    }

    fun memberItemList() {
        println("-------------------------------")
        println(" Checkout Pelanggan Member $inputMember")
        println("-------------------------------")
        for (i in 0..itemTotalCounter - 1) {
            println("${item[i]} X ${itemTotal[i]} : Rp. ${itemOne[i] * itemTotal[i]}")
            totalPayment += (itemOne[i] * itemTotal[i])
        }
        println("-------------------------------")
        println(" Total Belanja : Rp. ${totalPayment}")
        println("-------------------------------")
        val hitungDiskon = HitungDiskon(totalPayment)
        if (totalPayment > memberReqDiscount) {
            print("Selamat! Karena total belanjaan ${inputMember} \nlebih besar dari Rp. ${memberReqDiscount}, \nmaka mendapatkan potongan sebesar ")
            memberDiscount.percent()
            println("\n${inputMember} Cukup Bayar Rp. ${hitungDiskon.discount(totalPayment, memberDiscount)}")
            this.totalPaymentAfterDiscount = hitungDiskon.discount(totalPayment, memberDiscount).toDouble()
            println("-------------------------------")
        } else {
            HitungDiskon(totalPayment).discount(totalPayment)
        }
        memberPayment()
    }

    fun Any.percent() = print("$this %")



    fun memberPayment() {
        println("-------------------------------")
        println(" Checkout Pelanggan Member $inputMember")
        println("-------------------------------")
        println("Total Belanja       : Rp. ${totalPaymentAfterDiscount.toInt()}")
        println(" ")
        print("Input Uang Customer : Rp. ")
        customerMoney = Integer.valueOf(readLine())
        if (customerMoney < totalPaymentAfterDiscount.toInt()) {
            println("ALERT : Uang Anda Tidak Cukup")
            memberPayment()
        } else {
            println("-------------------------------")
            println("Kembalian : Rp. ${(customerMoney - totalPaymentAfterDiscount).toInt()}")
            println("-------------------------------")
            println("- Terima Kasih -")
        }
    }




    override fun nonMemberInputItem() {
        println("-------------------------------")
        println(" Checkout Pelanggan Non Member")
        println("-------------------------------")
        print("Input Nama Barang         : ")
        inputItem = readLine().toString()
        print("Input Harga Satuan Barang : ")
        try {
            inputItemOne = Integer.valueOf(readLine())
        } catch (e: NumberFormatException) {
            println("ALERT : Input Harga Satuan HARUS INTEGER")
            nonMemberInputItem()
        }
        print("Input Jumlah Barang       : ")
        try {
            inputItemTotal = Integer.valueOf(readLine())
        } catch (e: NumberFormatException) {
            println("ALERT : Input Jumlah Barang HARUS INTEGER")
            nonMemberInputItem()
        }
        println("-------------------------------")
        item.add(inputItem)
        itemOne.add(inputItemOne)
        itemTotal.add(inputItemTotal)
        itemTotalCounter++
        nonMemberAddItemChoice()
    }

    fun nonMemberAddItemChoice() {
        print("Input Barang Lagi? (Y/N) : ")
        tambahLagi = readLine().toString()
        when (tambahLagi) {
            charY.toString() -> {
                nonMemberInputItem()
            }
            charN.toString() -> {
                nonMemberItemList()
            }
            else -> {
                println("ALERT : Input Salah!")
                nonMemberAddItemChoice()
            }
        }
    }

    fun nonMemberItemList() {
        println("-------------------------------")
        println(" Checkout Pelanggan Non Member")
        println("-------------------------------")
        for (i in 0..itemTotalCounter-1) {
            println("${item[i]} X ${itemTotal[i]} : Rp. ${itemOne[i]*itemTotal[i]}")
            totalPayment += (itemOne[i] * itemTotal[i])
        }
        println("-------------------------------")
        println(" Total Belanja : Rp. ${totalPayment}")
        println("-------------------------------")
        if (totalPayment > nonMemberReqDiscount) {
            println("Selamat! Karena total belanjaan ${inputMember} \nlebih besar dari Rp. ${nonMemberReqDiscount}, \nmaka mendapatkan potongan sebesar")
            memberDiscount.percent()
            println("\nAnda Cukup Bayar Rp. ${HitungDiskon(totalPayment).discount(totalPayment, nonMemberDiscount)}")
            println("-------------------------------")
        } else {
            HitungDiskon(totalPayment).discount(totalPayment)
        }
        nonMemberPayment()
    }

    fun nonMemberPayment() {
        println("-------------------------------")
        println(" Checkout Pelanggan Non Member")
        println("-------------------------------")
        println("Total Belanja       : Rp. ${totalPaymentAfterDiscount.toInt()}")
        println(" ")
        print("Input Uang Customer : Rp. ")
        customerMoney = Integer.valueOf(readLine())
        if (customerMoney < totalPaymentAfterDiscount.toInt()) {
            println("ALERT : Uang Anda Tidak Cukup")
            nonMemberPayment()
        } else {
            println("-------------------------------")
            println("Kembalian : Rp. ${(customerMoney - totalPaymentAfterDiscount).toInt()}")
            println("-------------------------------")
            println("- Terima Kasih -")
        }
    }


}