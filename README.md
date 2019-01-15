# KotlinStudy

이번에 Kotlin으로 개발할 기회가 생겨 Kotlin에대해 알아보는 시간을 갖게 되었다.

이 스터디의 기반이 되는 레퍼런스는 다음과 같다.
 - `Inflearn`의 [`새차원의 코틀린(Kotlin) 강좌`](https://www.inflearn.com/course/%EC%BD%94%ED%8B%80%EB%A6%B0-%EA%B0%95%EC%A2%8C-%EC%83%88%EC%B0%A8%EC%9B%90/)
 - `Kotlin 공식홈페이지`의 [`Tutorial`](https://kotlinlang.org/docs/reference/)
 
 - Java와 다른 점
    - 디렉터리와 패키지를 일치시키지 않아도 됨.
    - 세미콜론이 필요 없음
    - 모든 것이 객체임
        - Int, Long, Double, etc..
    - Literal
        - 8진수 미지원
        - 2진수 - 0b0000101
        - 16진수 - 0x0F
    - Underscores in numeric literals
        ```kotlin
        val oneMillion = 1_000_000
        val accountNumber = 356_1234_1234_12
        val bytes = 0b00000000_10000000_10000000_10000000
        ```
    - Representation
        - Java 플랫폼에서 숫자형은 JVM primitive type으로 저장됨
        - 그러나 Nullable이나 제네릭의 경우에는 박싱됨
        - 박싱된 경우 identity를 유지하지 않음
    - Explicit Conversion
        - 작은 타입은 큰 타입의 하위 타입이 아님
            - 작은 타입에서 큰 타입으로의 대입이 안됨
    - Object 형태의 Array
        - 특별한 Array들, IntArray, LongArray, ShortArray, etc....
    - Package
        - 소스코드 파일의 경로와 package명이 일치하지 않아도 됨
        - Package를 명시하지 않으면 이름이 없는 기본 패키지에 포함됨.
            - 그냥 바로 가져다 쓰면 됨
        - 자동으로 import 되는 기본 패키지들
            - `kotlin.*`
            - `kotlin.annotation.*`
            - `kotlin.collections.*`
            - `kotlin.io.*`
            - `kotlin.range.*`
            - etc....
    - Import 
        - `as` keyword를 통해 로컬 리네임 가능
    - Method
        - 클래스 밖에 그냥 선언 가능 (C처럼)
    - Class
        - 구성요소  
            - ClassName
            - Head
            - Body
                - Constructor and Initialize block
                - Properties
                - Functions
                - Nested and Inner Classes
                - Object Declaration
            - Header와 Body는 옵션  
        ``` 
        class ClassName [(Header)] [{  
          Body
        }]
        ```
        ```kotlin
        class Human(name:String){
          //Body
        }
        ```
        - Primary Constructor
            - Class 별로 1개만 가질 수 있음
            - Header의 일부
                ```kotlin
                class Person constructor(firstName: String){}
                ```
            - Annotation이나 접근지정자가 없을 경우 `constructor` 생략 가능
                ```kotlin
                class Person (firstName: String){}
                ```
            - 기본 생성자의 코드는 `init` 블록에 들어감
                ```kotlin
                class Person (firstName: String){
                   init{
                      //code
                   }     
                }
                ``` 
            - 프로퍼티 초기화 선언에도 사용 가능
                ```kotlin
                class Person (name: String){
                    val upperCaseName = name.toUpperCase()
                }
                ```
        - Secondary Constructor
            - Class 별로 여러개를 가질 수 있음
            ```kotlin
            class Person2 {
                var name: String = "Default"
            
                constructor()
            
                constructor(name: String){
                    this.name = name
                }
            }
            ```
            - Class가 Primary Constructor를 가지고 있다면, 각 Secondary Constructor들은 직간접적으로 위임해 줘야 함
                - 직접적 : 기본 생성자에 위임
                - 간접적 : 직접적 위임을 하는 다른 보조 생성자에 위임
            ```kotlin
            class Person3(val name: String) {
                // 직접적 위임
                constructor(name: String, parent: Person3) : this(name) {
                }
      
                // 간접적 위임
                constructor() : this("default", Person3()) {
                }
            }
            ```
    - Inheritance
        - `Java`의 최상위 객체는 `Object`인 반면
        - `Kotlin`의 최상위 객체는 `Any`
            - Any가 포함하는 함수
                - equals()
                - hashCode()
                - toString()
        - open을 해야 다른 클래스가 상속을 할 수 있음
            - 모든 클래스는 default로 final로 선언됨
                - 이유는 Effective Java, Item 17: Design and document for inheritance or else prohibit it
            - open은 final과 반대 개념
        ```kotlin
        open class AA
        
        class BB : AA()
        ```
        - Method override
        - Property override ??
    - Abstract Class
        - 구현이 없는 클래스
