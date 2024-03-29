# 아키텍쳐 패턴
# 디자인 패턴

# 객체지향 5대 원칙
 - SRP (The Single Responsibility Principle)
 - OCP (The Open Close Principle)
 - LSP (The Liskov Substitution Principle)
 - ISP (The Interface Segregation Principle)
 - DIP (The Dependency Inversion Principle)

# 필요한 조엘 테스트  

 1. 버전 관리시스템 ( git )  
 2. 빌드 자동화 ( Maven )  
 3. 버그 추적시스템을 운영하고 있습니까?   
 4. 일정을 업데이트하고 있습니까?  
 5. 명세서를 작성하고 있습니까?  
 6. 일일 빌드를 하고 있습니까?  

# 성능을 너무 고려하지 않는다.

# 객체지향 생활 규칙
규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.  
규칙 2 : else 예약어 금지  
규칙 3 : 원시값과 문자열의 포장  
규칙 4 : 한 줄에 한 점만을 사용    
규칙 5 : 클래스명, 변수명, 메서드명 축약 금지  
  - 클래스와 클래스 변수에 표현이 중복되지 않도록 해야함.  
  
규칙 6 : 모든 엔티티를 작게 유지  
  - 50줄 이상 되는 클래스와 파일이 10개 이상인 패키지가 없어야한다.  
  
규칙 7 : 2개이상의 인스턴스 변수를 가진 클래스 사용금지 <- VO객체는 사용이 가능한가?  
규칙 8 : 일급 콜렉션 사용  
 - 비지니스에 종속적인 자료구조  
 - Collection의 불변성을 보장  
 - 상태와 행위를 한 곳에서 관리  
 - 이름이 있는 컬렉션  
 
규칙 9 : 게터 /세터/ 속성 사용 금지  


# Java 코딩 규칙

 - [구글 javaGuide](https://google.github.io/styleguide/javaguide.html)

# Java Test

 - 인스턴스 비교 ( hashCode 비교 => Equals 비교 ) 
 - 시간측정
 
<pre>
      long start = System.currentTimeMillis();  
      long end = System.currentTimeMillis();  
      long result = ( end - start ) / 1000.0;  
      System.out.println( "알고리즘 실행 시간 : " + result );  
</pre>
 
 
# JVM

 - TestJava.java, TestJava.class
 - java -cp "/lib/*" TestJava
 - java -jar testjava.jar TestClass args[0].properties
 - javac -d . TestJava.java
 - java -cp . 패키지.클래스명
  
  
 # Java Clean Code
  
- 클래스 이름( 명사, 명사구 )

- 문제 영역 = 전문 영역

- 해법 영역 = 프로그래밍 

- 메서드 이름( 동사, 동사구 )

- 클래스명, 메서드명, 변수명은 검색하기 쉬운 이름을 사용 ( ctrl + f )

- 블록과 들여쓰기
  - 1단 혹은 2단을 넘지마라!

- 명령과 조회를 분리하라
  - 뭔가를 수행하거나 반환하거나 둘 중 하나만 해라!
  - 오류처리도 한 가지 작업이다!  
  - 추상화 수준을 하나로!  
  - 되도록이면 Switch문을 사용하지마라!    
  
- 함수의 인수를 줄여라!
  - 인수가 많으면 테스트하기 힘들다!
  - 단항 함수  
    - 함수에 질문을 던지는 경우
    - 변환해 결과를 반환하는 경우
    - (변환 함수의 인수가 반환 값이면 혼란을 준다) 반환값이 없을경우.
    - (플래그 함수는 쓰지 않는다.)
  - 인수 객체는 이름을 붙였으므로 써도된다. Vo
  
- 주석
  - 법적인 주석
  - 공식이나 정보를 제공하는 주석

- null을 전달, 반환하지 마라
  - null을 전달, 반환하는 함수는 null체크 때문에 코드를 더럽게 만든다.
  
- [Logback](https://github.com/sowen2819/JAVA/blob/master/LogBack.md)
- 변수명 정하기
  - 해법영역 ( 프로그래밍 )
  - 문제영역 ( 서비스 분야 )
  
- 적절한 행길이 유지
- 가로 형식 맞추기

# EFFECTIVE JAVA

 - 객체의 생성과 파괴
   1. Public 생성자 대신 정적 팩터리 메서드를 고려하라 (from, of, valueOf, instance, create, getType, newType, type)
   2. 생성자에 매개변수가 많다면 빌더를 고려하라
   4. 인스턴스화를 막으려거든 private 생성자를 사용하라
   5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라
   6. 불필요한 객체 생성을 피하라
   7. 다 쓴 객체 참조를 해제하라
   8. finalizer와 cleaner 사용을 피하라
   9. try-finally보다는 try-with-resources를 사용하라
   
 - 모든 객체의 공통 메서드    
   10. equals는 일반 규약을 지켜 재정의하라  
   11. equals를 재정의 하려거든 hashCode도 재정의하라  
   12. toString을 항상 재정의하라  
   13. clone 재정의는 주의해서 진행하라  
   14. Comparable을 구현할지 고려하라  

- 클래스와 인터페이스  
   15. 클래스와 멤버의 접근 권한을 최소화하라  
   16. public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라  
   17. 변경 가능성을 최소화하라  
   18. 상속보다는 컴포지션을 사용하라  
   19. 상속을 고려해 설계하고 문서화하라. 그리지 않았다면 상속을 금지하라.  
   20. 추상 클래스보다는 인터페이스를 우선하라.  
   21. 인터페이스는 구현하는 쪽을 생각해 설계하라.  
   22. 인터페이스는 타입을 정의하는 용도로만 사용하라.  
   23. 태그 달린 클래스보다는 클래스 계층구조를 활용하라.  
   24. 멤버 클래스는 되도록 static으로 만들라  
   25. 톱레벨 클래스는 한 파일에 하나만 담으라.  

- 제네릭  
   26. 로타입(raw Type)은 상용하지 말라.  
   27. 비검사 경고를 제거하라  
   28. 이왕이면 제네릭 타입으로 만들라  
   30. 이왕이면 제네릭 메서드로 만들라  
   31. 한정적 와일드카드를 사용해 API 유연성을 높이라  
   32. 제네릭과 가변인수를 함께 쓸 때는 신중하라  
   33. 타입 안전 이종 컨테이너를 고려하라.  
   
- 열거 타입과 애너테이션  
   34. int 상수 대신 열거 타입을 사용하라.    
   35. ordinal 메서드 대신 인스턴스 필드를 사용하라  
   36. 비트 필드 대신 EnumSet을 사용하라.  
   37. ordinal 인덱싱 대신 EnumMap을 사용하라.   
   38. 확장할 수 있는 열거 타입이 필요하면 인터페이스를 사용하라.  
   39. 명명 패턴보다 애너테이션을 사용하라.  
   40. @Override 애너테이션을 일관되게 사용하라  
   41. 정의하려는 것이 타입이라면 마커 인터페이스를 사용하라.  
   
- 람다와 스트림   
   42. 익명 클래스보다는 람다를 사용하라.  
   43. 람다보다는 메서드 참조를 사용하라.  
   44. 표준 함수형 인터페이스를 사용하라.  
   45. 스트림은 주의해서 사용하라.  
   46. 스트림에서는 부작용 없는 함수를 사용하라.  
   47. 반환 타입으로는 스트림보다 컬렉션이 낫다.  
   48. 스트림 병렬화는 주의해서 적용하라.  

- 메서드  
   49. 매개변수가 유효한지 검사하라  
   50. 적시에 방어적 복사본을 만들라  
   51. 메서드 시그니처를 신중히 설계하라  
   52. 다중정의는 신중히 사용하라  
   53. 가변인수는 신중히 사용하라  
   54. null이 아닌, 빈컬렉션이나 배열을 반환하라  
   55. 옵셔널 반환은 신중히 하라  
   56. 공개된 API 요소에는 항상 문서화 주석을 작성하라  
   
- 일반적인 프로그래밍 원칙  
   57. 지역변수의 범위를 최소화하라  
   58. 전통적인 for문보다는 for-each문을 사용하라  
   59. 라이브러리를 익히고 사용하라  
   60. 정확한 답이 필요하다면 float와 double은 피하라  
   61. 박싱된 기본 타입보다는 기본타입을 사용하라  
   62. 다른 타입이 적절하다면 문자열 사용을 피하라  
   63. 문자열 연결은 느리기 주의하라  
   64. 객체는 인터페이스를 사용해 참조하라  
   65. 리플렉션보다는 인터페이스를 사용하라  
   66. 네이티브 메서드는 신중히 사용하라  
   67. 최적화는 신중히 하라  
   68. 일반적으로 통용되는 명명 규칙을 따르라.  
   
- 예외  
   69. 예외는 진짜 예외 상황에만 사용하라  
   70. 복구할 수 있는 상황에는 검사 예외를, 프로그래밍 오류에는 런타임 예외를 사용하라  
   71. 필요 없는 검사 예외 사용은 피하라  
   72. 표준 예외를 사용하라  
   73. 추상화 수준에 맞는 예외를 던져라  
   74. 메서드가 던지는 모든 예외를 문서화하라  
   75. 예외의 상세 메세지에 실패 관련 정보를 담으라  
   76. 가능한 한 실패 원자적으로 만들라  
   77. 예외를 무시하지 말라.  
   
# JDK
 - jdk6  
 - jdk7  
 - jdk8  
 
 # URL 주의 사항
  - 한글 파라미터로 값을 날릴때는 UTF-8로 인코딩을 한다.  
  - URLEncoder.encode("한글", "UTF-8");  

# Java 메모리 Leak
  - 시스템 자원을 사용하는 객체
  - 익명 클래스 혹은 내부 클래스의 객체
