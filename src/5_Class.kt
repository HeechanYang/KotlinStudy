fun main(args: Array<String>) {
    // Create Obj
    val basicClass = BasicClass()

    // Test Primary Constructor
    val obj = Person("양희찬")


    val person2_2 = Person2()
    println("\nperson2_2.name was ${person2_2.name}")
    person2_2.name = "양희찬"
    println("person2_2.name is ${person2_2.name} now")

    val person2_1 = Person2("양희찬")
    println("\nperson2_1.name is ${person2_1.name}")
}

// Header와 body 생략 가능
class BasicClass

class Person(name: String) {
    // 기본 생성자의 param은 init블록 외에서 그냥 사용 불가
    fun print() {
        // println("My name is $name")
        // println("My name is ${this.name}")
    }

    init {
        println("My name is $name")
    }
}

class Person2 {
    var name: String = "Default"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    constructor()

    constructor(name: String) {
        this.name = name
    }
}

// Class가 Primary Constructor를 가지고 있다면, 각 Secondary Constructor들은 직간접적으로 위임해 줘야 함
    // 직접적 : 기본 생성자에 위임
    // 간접적 : 직접적 위임을 하는 다른 보조 생성자에 위임
class Person3(val name: String) {

    // 직접적 위임
    constructor(name: String, parent: Person3) : this(name) {
    }

    // 간접적 위임
    constructor() : this("default", Person3()) {
    }
}