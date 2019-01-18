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