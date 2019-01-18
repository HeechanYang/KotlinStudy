import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun main(args: Array<String>) {
    val t1 = Thread(MyRunnable())
    // Object Expression !
    val t2 = Thread(object : Runnable {
        override fun run() {
            println("MyThread2 is Run!!")
        }
    })
    // Lambda도 가능
    val t3 = Thread(Runnable { println("MyThread3 is Run!!") })

    t1.run()
    t2.run()
    t3.run()
    // 그냥 궁금한건데 start 와 run의 차이가 뭐지

    // Singleton using Object Declaration
    SingletonObject.doSomething()

    // Companion Object
    // MyClass.Factory.create() 할 필요 없음
    // 함수를 공유한다는 건가?
    // Static처럼 보일 수 있지만 다름 (이건 뭔소린지 모르겠다 나중에 찾아봐야지)
    // - companion object의 멤버는 실제 객체의 멤버임
    // - 슈퍼클래스도 가질 수 있는 클래스의 객체임
    MyClass.create()
    MyClass.Factory.create()
}

// 저 run 메서드 하나 구현하려고 이렇게 class를 따로 만들어야 해?!?!
// 그래서 있는 것이 객체 표현식
// 제약사항
// - 익명 객체가 local이나 private으로 선언될 때만 type으로 사용 가능
// - 익명 객체가 public function이나 public property에서 리턴되는 경우 익명 객체의 슈퍼타입으로 동작됨
//      - 이런 경우 익명 객체에 추가된 멤버에 접근이 불가능
class MyRunnable : Runnable {
    override fun run() {
        println("MyThread1 is Run!!")
    }
}

class C{
    private fun foo() = object{val x:String = "x"}
    fun publicFoo() = object{val x:String = "x"}

    fun bar(){
        // - 익명 객체가 local이나 private으로 선언될 때만 type으로 사용 가능
        var x1 = foo().x
        // - 익명 객체가 public function이나 public property에서 리턴되는 경우 익명 객체의 슈퍼타입으로 동작됨
        //      - 이런 경우 익명 객체에 추가된 멤버에 접근이 불가능
        // var x2 = publicFoo().x
    }
}

// Object Declaration
object SingletonObject{
    fun doSomething(){
        println("SingletonObject.doSomething()")
    }
}

// Object Declaration - 상속 가능
object DefaultListener : MouseAdapter(){
    override fun mouseClicked(e: MouseEvent?) {
        super.mouseClicked(e)
    }

    override fun mouseMoved(e: MouseEvent?) {
        super.mouseMoved(e)
    }
}

// Companion Object
class MyClass{
    // companion object의 이름은 생략 가능
    // ex) companion object {...}
    // 이럴 경우 ClassName.Companion.xxx로 접근 가능
    companion object Factory{
        fun create(): MyClass = MyClass()
    }
}