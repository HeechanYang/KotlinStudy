fun main(args: Array<String>) {
    println("######################## AA, BB, CC")
    val aa = AA("AA")
    aa.name
    aa.printInfo()
    println()

    val bb = BB()
    bb.printInfo()
    println()

    val cc = CC("CC")
    cc.printInfo()

    println("\n######################## DD")
    val dd1 = DD()
    dd1.printInfo()
    dd1.printInfo2()
    println()

    val dd2 = DD("DD2")
    dd2.printInfo()
    dd2.printInfo2()
    println()

    val dd3 = DD("DD3", 26)
    dd3.printInfo()
    dd3.printInfo2()

    println("\n######################## EE")
    val ee = EE()
    ee.printInfo()
    ee.printInfo2()
    println()
}

// open을 해야 다른 class가 상속을 받을 수 있음
open class AA(var name: String = "Default") {
    open fun printInfo() {
        println("printInfo in AA : My name is $name")
    }

    fun printInfo2() {
        println("printInfo2 in AA : My name is $name")
    }
}

class BB : AA("BB")

class CC(name: String) : AA(name)

// 자식 클래스에 Primary Constructor가 없는 경우, Secondary Constructor에서 위임해줘야함
open class DD : AA {
    var age :Int = -1
    // 직접적 위임
    constructor() : super()

    // 간접적 위임
    constructor(name: String) : this(){
        this.name = name
    }

    constructor(name: String, age: Int) : super(name){
        this.age = age
    }

    // override를 명시해 주어야 함
    // fun printInfo2(){}
    // 'printInfo2' hides member of supertype 'AA' and needs 'override' modifier

    // 상위 클래스에서 open을 해주어야 함
    // override fun printInfo2(){}
    // 'printInfo2' in 'AA' is final and cannot be overridden

    override fun printInfo() {
        println("overridden printInfo in DD : My name is ${this.name}, and ${this.age} years old")
    }
}


interface II {
    fun printInfo(name: String) {
        println("printInfo in II : My name is $name")
    }

    fun printInfo2(name: String) {
        println("printInfo2 in II : My name is $name")
    }

    abstract fun printInfo3(name: String)
}

//
class EE : DD, II {

    var job: String = "jobless"

    constructor() : super()

    constructor(name: String) : super(name)

    constructor(name: String, age: Int) : super(name, age)

    constructor(name: String, age: Int, job: String) : super(name, age) {
        this.job = job
    }

    override fun printInfo() {
        super<DD>.printInfo()
        super<II>.printInfo(this.name)
    }

    // 왜 호출이 안되지??
    override fun printInfo2(name: String) {
        super<DD>.printInfo2()
        super<II>.printInfo2(this.name)
    }

    // 인터페이스에서 상속한 함수를 구현할 의무는 없어진건가??
    // override fun printInfo3(name: String) {}
        // 아니군 abstract함수는 구현하지 않으면 오류 발생
    override fun printInfo3(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

abstract class ABS{
    abstract fun printInfo()
    abstract fun printInfo2()
    abstract fun printInfo3()
}

