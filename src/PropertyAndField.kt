fun main(args: Array<String>) {
    val obj = Address()
    println(obj.name)
    // ->
    // System.out.println(obj.getName());
    obj.name = "Pan-gyo"
    println(obj.name)

    val initTest = LateinitTest()
    // UninitializedPropertyAccessException: lateinit property data has not been initialized
    // println(initTest.data)
    initTest.setUp()
    println(initTest.data)
}

class Address {
    var name: String = "Kotlin"
    // ->
    // @NotNull
    //   private String name = "Kotlin";
        // getter, setter에서 field라는 키워드가 쓰임
        get() {
            return field + "!!!"
        }
        set(value) {
            field = value + "@@@"
        }

    val city: String = "Seoul"
    // ->
    // @NotNull
    // private final String city = "Seoul";
}

/*
lateinit
- 클래스의 바디에서 선언된 프로퍼티만 가능
- 기본 생성자에서 선언된 프로퍼티는 불가능
- var 프로퍼티만 가능
- custom accessor가 없어야 함
- non-null이어야 함
- primitive type은 안 됨
*/
class LateinitTest(/*lateinit var data2 : String*/) {
    lateinit var data: String /*Int*/ /*?*/ // Primitive type이거나 nullable이면 안 됨
    // get() { return field}

    fun setUp() {
        data = "This is lateinit data"
    }
}