fun main(){
    welcome()
}

fun welcome(){
    println("------------------------------")
    println("Selamat Datang di SYNRGY Mart")
    println("1. Login Kasir")
    println("0. Keluar")


    val input = readLine()!!
    when(input) {
        "1" -> Mart().login()
        "0" -> return
        else -> {
            println("Ulangi input")
            welcome()
        }
    }
}




/*
    when(readline()) {
    "1" -> Mart().login()
    "0" -> return
    else -> {
        println("Ulangi input")
        welcome()
    }
    } */
