fun main(args: Array<String>) {
    // Underscores in numeric literals
    val oneMillion = 1_000_000
    val accountNumber = 356_1234_1234_12
    val bytes = 0b10000000_10000000_10000000_10000000

    println("oneMillion : $oneMillion")
    println("accountNumber : $accountNumber")
    println("bytes : $bytes")

    // Java 플랫폼에서 숫자형은 JVM primitive type으로 저장됨
    // 그러나 Nullable이나 제네릭의 경우에는 박싱됨
    // 박싱된 경우 identity를 유지하지 않음

    // Primitive type
    var a: Int = 10000
    // Primitive type
    var b: Int = 10000
    // Nullable -> Boxing
    var c: Int? = 10000

    println("a == b : ${a == b}")
    println("a === b : ${a === b}")
    println("a == c : ${a == c}")
    println("a === c : ${a === c}")

    // Explicit Conversion
    var numA: Int = 1
//    val numB: Long = a
    val numB: Long = a.toLong()
    var strA: String = "123"
    numA = strA.toInt()

    // Array 배열은 class로 표현됨
    var arr1: Array<Int> = arrayOf(1, 2, 3, 4)
    for (num in arr1) {
        print("$num ")
    }
    println()

    for (i in 0..(arr1.size - 1)) {
        print("${arr1[i]} ")
    }
    println()

}