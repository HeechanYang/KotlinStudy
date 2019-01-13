// 함수 START
fun sum(a: Int, b: Int): Int {
    return a + b
}

// 함수의 return 값이 식(Expression)이라면 return 생략 가능
// 이 경우 return type이 추론됨
fun sum2(a: Int, b: Int) = a + b

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun mul(a: Int, b: Int): Int {
    return a * b
}

fun div(a: Int, b: Int): Int {
    return a / b
}

fun mod(a: Int, b: Int): Int {
    return a % b
}
// 함수 END

//조건문 START
fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun max2(a: Int, b: Int) = if (a > b) a else b

fun min(a: Int, b: Int): Int {
    if (a < b) {
        return a
    } else {
        return b
    }
}
//조건문 END

// Nullable, ?
fun parseInt(str: String): Int? {
    var result = 0
    for(c in str){

    }
    return 1
}
// Nullable END

// 자동 타입 변환
fun printTypeOf(target : Any) {
    if(target is Int){
        println(target.toString() + " is a Int")
    } else if(target is Double){
        println(target.toString() + " is a Double")
    } else if(target is String){
        println(target.toString() + " is a String")
    } else if(target is Boolean){
        println(target.toString() + " is a Boolean")
    } else {
        println(target.toString() + " is a something else")
    }
}
// 자동 타입 변환 END

// When 표현
fun printTypeOf2(target : Any){
    when(target){
        1 -> {
            println(target.toString() + " is One")
        }
        "Hello" -> {
            println(target.toString() + " World!")
        }
        is Long -> {
            println(target.toString() + " is a Long")
        }
        is Int -> {
            println(target.toString() + " is a Int")
        }
        else -> {
            println("ELSE!!")
        }
    }
}
// When 표현 END

// Range Start
fun rangeTest(){
    val x = 3

    if(x in 1..10){
        println("fits in range")
    }

    for(a in 1..5){
        print("$a ")
    }
    println()
}
// Range End


/**
 * Java의 void는 Kotlin의 Unit에 대응됨
 */
fun printSum(a: Int, b: Int): Unit {
    println(sum(a, b))
}

// Unit 생략 가능
fun printSum2(a: Int, b: Int) {
    println(sum(a, b))
}

fun main(args: Array<String>) {
    // var : 기존의 지역변수와 같음
    // 타입을 명시해주지 않으면 타입 추론
    var a = 1
    var b: Int = 3
    a = 2

    // val : 읽기 전용 변수.
    // final로 설정하는 것과 같음
    val c = 1
    val d: Int = 5
    val e: Int
    e = 4

    // 문자열 보간법(String Interpolation)
    println("$a + $b : " + sum(a, b))
    println("$a + $b : " + sum2(a, b))
    print("$c + $d : ")
    printSum(c, d)
    print("$c + $e : ")
    printSum2(c, e)
    // 문자열 보간법 END

    // When 표현 Test
    printTypeOf2(1)
    val long : Long = 0
    printTypeOf2(long)
    val int : Int = 0
    printTypeOf2(int)
    val boolean : Boolean = false
    printTypeOf2(boolean)
    // When 표현 Test End

    // Range Test
    rangeTest()
    // Range Test END

    // Collections
    val fruitList = listOf("apple","banana", "kiwi")
    for(fruit in fruitList){
        print("$fruit ")
    }
    println()

    val petTypeSet = setOf("dog","cat", "hamster")
    for(petType in petTypeSet){
        print("$petType ")
    }
    println()
    // Collections END
}