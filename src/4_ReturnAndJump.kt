fun main(args: Array<String>) {
    // Label & break & continue
    println("[Label & break & continue]")
    println("just `double for` and `break`")
    for (i in 1..4) {
        print("$i -- ")
        for (j in 1..4) {
            print("$j ")
            if (i + j > 5) {
                break
            }
        }
        println()
    }

    println("\njust 'double for' and 'break' and 'flag'")
    for (i in 1..4) {
        print("$i -- ")
        var doBreak = false

        for (j in 1..4) {
            print("$j ")
            if (i + j > 5) {
                doBreak = true
                break
            }
        }
        if(doBreak){
            break
        }
        println()
    }
    println()

    println("\n'double for' and 'break' with 'label'")
    myLabel@ for (i in 1..4) {
        print("$i -- ")
        for (j in 1..4) {
            print("$j ")
            if (i + j > 5) {
                break@myLabel
            }
        }
        println()
    }
    println()

    // Return by Label
    println("\n[Return by Label]")
    println("'foreach' with 'fun'")
    foo1()
    println("\n'foreach' with 'lambda'")
    foo2()
    println("\n\n'foreach' with 'lambda' and 'label'")
    foo3()
    println("\n\n'foreach' with 'lambda' and 'implicit label'")
    foo4()
    println("\n\n'foreach' with 'lambda' and 'implicit label' and 'return'")
    foo5()
}

// 코틀린에서 중첩될 수 있는 요소들
// - 함수 리터럴 (function literals)
// - 지역 함수 (local function)
// - 객체 표현식 (object expression)
// - 함수 (function)
fun foo1() {
    val ints = listOf(1, 2, 3, 4)

    ints.forEach(fun(value: Int) {
        if (value == 2) {
            print("return ")
            return
        }
        print("$value ")
    })
    println()
}

// 로컬함수와 람다를 중복해서 사용했을 경우
fun foo2() {
    val ints = listOf(1, 2, 3, 4)

    ints.forEach {
        if (it == 2) {
            print("return")
            return
        }
        print("$it ")
    }
    println()
}

// 레이블을 사용한 return
fun foo3() {
    val ints = listOf(1, 2, 3, 4)

    ints.forEach label@{
        if (it == 2) {
            print("return ")
            return@label
        }
        print("$it ")
    }
    println()
}

// 암시적 레이블
// 암시적 레이블은 람다가 사용된 함수의 이름과 동일
fun foo4() {
    val ints = listOf(1, 2, 3, 4)

    ints.forEach {
        if (it == 2) {
            print("return ")
            return@forEach
        }
        print("$it ")
    }
    println()
}

// 암시적 레이블 + 값 리턴
// 암시적 레이블을 사용하는데 값도 리턴해야하는 경우
// return@레이블 value
fun foo5() {
    val ints = listOf(1, 2, 3, 4)

    for (s in ints.map {
        if (it == 2) {
            return@map "return "
        } else {
            "$it "
        }
    }) {
        print(s)
    }
    println()
}