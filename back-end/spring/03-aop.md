## Aspect-Oriented Programming

### Abstract

- 정의
  - 객체의 로직 내에 존재하는 관점을 분리하여, 각각을 따로 관리한다. 
    - 성능 분석에 대한 관점
    - 로그 처리에 대한 관점
    - 트랜잭션 처리에 대한 관점
- 구분
  - 핵심 관심 사항(Core concerns)
  - 공통 관심 사항(Cross-cutting concerns)
    - a.k.a 횡단 관심사
- 프록시(Proxy)
  - 대리인; 대신하여 처리해주는 개체
  - AOP 내 동작
    - 핵심 관심 사항 및 공통 관심 사항의 메서드를, 논리적인 순서에 맞추어 실행
    - 핵심 관심 사항의 소스 코드 내부에 공통 관심 사항 소스 코드를 삽입하는 방식이 아닌, 각 메서드를 독립적으로 수행한다. 
      - 메서드 처리 결과에 따라, 다르게 처리하는 것 또한 가능하다. 

---

### Spring AOP

- **Terminology**
  - Target
    - 핵심 관심 사항을 포함하는 객체
  - Advice
    - Target 객체에서 실행하고 싶은 공통 관심 사항의 기능을 정의한 객체
  - JoinPoint
    - Advice를 적용할 수 있는 지점
      - 적용이 가능하다 하여, Advice가 적용이 된 상태는 아니다. 
  - Pointcut
    - Target 객체 내에, Advice를 적용할 지점
      - 표현식을 통하여, 넓은 범위의 Pointcut을 나타낼 수 있다. 
  - Aspect (Advisor)
    - Advice + Pointcut
      - 실제 Spring의 Advisor 객체는, Advice와 Pointcut 객체를 포함한다. 
      - 공통 관심 사항의 기능을 구현한 Advice와, 해당 Advice를 적용할 지점을 포함하는 개념
  - Weaving
    - Pointcut과 Advice를 직조하는 것
    - Weaving 과정은, Target 객체의 로직에 영향을 주지 않는다. 
      - 논리적으로 독립적이며, 로직을 알지 못하더라도 가능하도록 설계되었다. 
- **Pointcut Expressions**
  - AspectJ
    - PARC(Palo Alto Research Center)에서 개발한 Java용 AOP 확장 기능
    - 고급 기법으로써, 다양한 JoinPoint를 지원한다. 
  - Pointcut Expressions
    - JoinPoint 중에서, Pointcut으로써 지정될 지점들을 표현식으로써 나타낸다. 
    - 사용 가능한 표현식
      - 정규 표현식(Regular Expression)
      - AspectJ 표현식

- **구현**
  - 설정
    - AOP를 적용하고자 하는 Context에, \<aop:aspectj-autoproxy> 태그 작성
  - 공통 구현부
    - @Component
      - Spring Container에 처리를 위임한다. 
    - @Aspect
      - Spring Container에 AOP를 위한 객체임을 알려준다. 
    - @Pointcut
      - (선택) 어플리케이션 내에서 특정한 JoinPoint를 지정
    - @Before, @AfterReturning, @AfterThrowing, @Around, @After
      - Pointcut 내에서 Advice를 실행할 분기를 지정
      - AfterReturning, AfterThrowing - 메서드의 수행 결과 참조 가능
      - Around - ProceedingJoinPoint 인자 값을 지정
    - Advice 메서드
      - JoinPoint 객체를 인자 값으로 지정 가능
        - args, signature, 등에 대한 정보를 참조
  - Aspect - 로그
    - slf4j.Logger
      - slf4j.LoggerFactory.getLogger(LoggingAspect.class)
        - 현재 클래스의 메타 정보를 포함한 Logger를 생성
      - 로그의 레벨에 따른 출력을 지정
        - INFO, DEBUG, WARN, ERROR, TRACE

---

### Proxy in Java

- java.lang.reflect.Proxy
  - 개요
    - Java에서 프록시의 기능을 제공해주는 클래스
  - 객체 생성
    - Proxy.newInstance(ClassLoader, Class[], InvocationHandler)
      - ClassLoader - 프록시가 처리하는 로직이 구현된 Target 클래스의 클래스로더
      - Class[] - Target 클래스가 구현한 인터페이스의 배열
      - InvocationHandler - 프록시 객체 호출 시 실제로 호출되는 invoke(Object proxy, Method method, Object[] args) 메서드를 포함하는 인터페이스

---

### Reference

- [YouTube - 뉴렉처 [스프링 강의 02 - AOP]](https://www.youtube.com/watch?v=y2JkXjOocZ4&list=PLq8wAnVUcTFVUMCKI4CL_EHWW5ykPnL0z)