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
