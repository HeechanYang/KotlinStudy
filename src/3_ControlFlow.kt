fun main(args: Array<String>) {
    // if문
    println("############ if ############")

    var a = 3
    var b = 5

    val max = if (a > b) a else b
    println("max $a, $b : $max")

    // 위의 if식을 보면 3항 연산이 떠오를 텐데, Kotlin에는 3항 연산이 없음
    // val max2 = a > b ? a : b

    // 단, a나 b의 값을 바꾸어도 max의 결과가 달라지진 않음
    a = 6
    b = 3
    println("max $a, $b : $max")

    // if문이 식으로 쓰일 때 블록으로 쓸 수 있고 마지막에 반환값을 적어주면 됨
    val min = if (a < b) {
        println("$a < $b")
        a
    } else {
        println("$a >= $b")
        b
    }
    println("min $a, $b : $min")

    // when문
    // java에서와 달리 위에서부터 조건을 만족하는 것을 찾으면 끝나고 나서 바로 break가 걸림
    // break를 일일이 써줄 필요 없음
    println("\n############ when ############")

    var x: Any = 3
    val validNumbers = listOf(1..10)
    println("\n[x = $x]")

    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 1")
        3 -> println("x == 3")

    // 여러개도 가능
        4, 5 -> println("x == 4 or 5")

    // 식도 가능
        1 + 5 -> println("a == 6")

    // 다른 타입도 가능
    // 단, x의 자료형이 명시적으로 정해진 경우 불가
        "1" -> println("x == 1")
        else -> {
            println("nothing to match")
            x = -1
        }
    }

    when (x) {

    }

    when (x) {

    }

    // range나 collection에 in이나 !in으로 범위를 검사할 수 있음
    when (x) {
        in 1..10 -> println("1 <= x <= 10")
        in validNumbers -> println("x is valid")
        !in validNumbers -> println("x is invalid")
    }

    // type 검사도 가능
    // 이 때 SmartCast가 적용되어 해당 타입의 기능 사용 가능
    x = "I'm String"
    println("\n[x = $x]")
    when (x) {
        is Int -> print("x is a Int")
        is Double -> print("x is a Double")
        is Long -> print("x is a Long")
        is String -> {
            println("x is a String. And first char is ${x[0]}")
        }
    }

    // when에 인자를 입력하지 않으면 if - else if 체인을 대체함
    val str = "asdfasf"
    when {
        str.length <= 10 -> {
            println("Please input str more than 5. Current size is ${str.length}")
        }
        str.length >= 10 -> println("Good!")
    }

    // for문
    println("\n############ for ############")
    val arr = arrayOf(1, 2, 3, 4)
    println("\nfor (num in arr)")
    for (num in arr) {
        print("$num ")
    }
    println()

    // iterator를 반환하지 않는 객체를 사용하면 error 발생
    // For-loop range must have an 'iterator()' method
    val any = Any()
//    for(element in any){}

    // 배열이나 리스트를 반복할 때 index를 사용하고 싶으면 .indices
    println("\nfor (idx in arr.indices)")
    for (idx in arr.indices) {
        print("[$idx] ${arr[idx]} ")
    }
    println()

    // 배열이나 리스트를 반복할 때 index와 value를 둘 다 사용하고 싶으면 .withIndex()
    println("\nfor ((idx, value) in arr.withIndex())")
    for ((idx, value) in arr.withIndex()) {
        print("[$idx] $value ")
    }
    println()

    // while과 do-while은 java와 거의 같음
    // 다른 점은 do-while에서 body의 지역변수를 조건문이 참조 가능
    println("\n############ while ############")
    println("\nwhile (++cnt < 4)")
    var cnt = 0
    while (cnt++ < 4) {
        print("$cnt ")
    }
    println()

    println("\n############ do-while ############")
    println("\ndo{ } while (++cnt < 4)")
    cnt = 0
    do {
        var cnt2 = 4
        print("$cnt - $cnt2 /")
    } while (cnt2 > ++cnt)
    println()
}

