fun main(args: Array<String>) {
    val data1: DataClass = DataClass("양희찬", "서울")
    // 기본값으로 저장됨
    val data2: DataClass = DataClass("양희찬2")
    // 다른 property 값은 그대로 두고 원하는 property 값만 변경해서 복사하고 싶을 때 copy() 사용!
    val data3 = data1.copy(address = "안성")
    // Destructuring Declaration
    // ComponentN() 사용!
    val (d3Name, d3Address) = data3

    // toString() 자동으로 생성됨
    // Primary Constructor에서 선언한 property가 아니라 Body에서 선언한 property는
    // toString(), hashCode() 등에 포함되지 않음
    println(data1)
    println(data2.toString())
    println(data3)

    println(NestedClassTest.Nested().foo())
    println(InnerClassTest().Inner().foo())
}

// 기본값 설정 가능
data class DataClass(val name: String, val address: String = "Default") {
    var property1 = "Property"
}
// -> public final class DataClass {..}

// Nested class
class NestedClassTest {
    private var bar: Int = 1

    class Nested {
        // Outer의 property 접근 불가
        // fun foo() = bar
        fun foo() = 2
    }
}

// Inner class
class InnerClassTest {
    private var bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

// Anonymous Inner class
// aEditText.setOnclickListener(object : View.OnClickListener{
//     override fun onClick(v : View?){...}
// })