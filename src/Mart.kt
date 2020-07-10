class Mart(){
    private val username = arrayOf("Andra", "Wisnu", "MasAgus")
    private val password = arrayOf("A123", "W123","apaajaboleh")
    private var usernameInput: String = ""
    private var passwordInput: String = ""
    var status: Int = 0
    var inputMember: String = ""


    fun login(){
        println("+Login Kasir+")
        print("Username:")
        usernameInput = readLine().toString()
        print("Password:")
        passwordInput = readLine().toString()
        for (i in username.indices) {
            if ((usernameInput == username[i]) && (passwordInput == password[i])) {
                status = 1
                masuk()
                return
            }
            else status = 0
        }
        if (status == 1) {
            ulang()
        }
        else if (status == 0) {
            println("Gagal Login")
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


    fun checkoutPelanggan() {
        println("---------------------------")
        println("Checkout Pelanggan")
        println("1. Pelanggan Member")
        println("2. Pelanggan Non-Member")
        println("---------------------------")

        val input = readLine()!!
        when (input) {
            "1" -> pelangganMember()
            "2" -> pelangganNonMember()
            else -> {
                println("Input Salah")
                masuk()
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

    fun pelangganMember() {
        println("---------------------------")
        println("Checkout Pelanggan Member")
        println("---------------------------")
        println("Input Nama member: ")
        println("---------------------------")


        val inputMember = readLine()!!
        when (inputMember) {
            "1" -> pelangganMember()
            "2" -> pelangganNonMember()
            else -> {
                println("Input Salah")
                masuk()
            }

        }


    }

    fun  pelangganNonMember() {
        println("---------------------------")
        println("Checkout Pelanggan Non-Member")
        println("---------------------------")
        println("Input Nama member: ")
        println("---------------------------")

        val input = readLine()!!
        when (input) {
            "1" -> pelangganMember()
            "2" -> pelangganNonMember()
            else -> {
                println("Input Salah")
                masuk()
            }

        }


    }


    fun ulang () {
        print("Kembali ke Menu Utama?")
        when(readLine()) {
            "Y" -> masuk()
            "N" -> return
            else -> {
                println("Input Salah")
                ulang()
            }
        }
    }

}