## Spring Beans / Configuration

### Abstract

- 정의
  - Spring 프레임워크의 IoC 컨테이너가 관리 하에 있는 객체

- 메타 정보
  - 클래스명
    - package-name을 포함한 full-name
  - 동작 정보
    - IoC 컨테이너 내부 동작과 관련된 정보들이 포함
    - Scope
    - Lifecycle callbacks - init-method, factory-method
  - 다른 Bean 객체와의 관계
    - Dependencies
  - Pool 및 Connection 크기 등
- Spring Bean 가져오기
  - ApplicationContext 객체의 getBean() 메서드 활용
    1. getBean("name")
    2. getBean(AnyClass.class)
    3. getBean("name", AnyClass.class)


---

### Configuration using XML

- **XML 파일 생성** - config.xml
  - ApplicationContext 객체 생성 시, 해당 파일 이름을 사용하여 접근한다. 
  - 정해진 이름을 활용할 필요는 없다. 
- **Tags - beans namespace**
  - \<beans> 태그
    - 포함하고 싶은 Namespace를 지정할 수 있다. 
      - beans, context, jdbc, tx, p, ...
  - \<bean> 태그
    - IoC 컨테이너가 관리하는, Spring Bean 객체를 설정한다. 
    - 속성
      - id: bean 객체의 이름
      - class: bean 객체의 클래스명, package-qualified
      - scope: bean 객체의 생성 범위; (default) singleton
        - GoF의 Singleton 디자인 패턴은 ClassLoader 기준으로 하나의 객체만을 허용한다면, 
        - Spring의 Singleton 디자인 패턴은 Container / Bean 단위로 하나의 객체만을 허용한다. 
      - init-method, destroy-method: 생성 / 소멸 시에 호출되는 메서드
        - Spring과 Java Code를 결합하는 단점이 존재한다. 
  - \<property> 태그
    - Setter Injection을 진행할 메서드의 name, 해당 인자 값 ref / value를 지정한다. 
    - ref는 참조형 데이터 타입, value는 기본형 데이터 타입을 사용한다. 
  - \<constructor-arg> 태그
    - Constructor Injection을 진행할 생성자에 적절한 value를 지정한다. 
      - 다수의 arguments는, index / type / name을 통해 식별한다. 
- **여담**
  - XML / Annotation 방식의 Configuration
    - 각 방식의 장단점이 존재하며, 적절하게 혼용하는 것 또한 가능하다. 
    - Annotation 방식이 먼저 실행되며, 이후 XML 방식이 실행된다. 
      - 중복된 경우, XML Injection의 방식이 사용된다. 
  - Setter / Constructor 방식의 Dependency Injection
    - Required 멤버 변수에는 Constructor 방식을, Optional 멤버 변수에는 Setter 방식을 추천한다고 한다. 

---

### Configuration using Annotation

- **XML - context namespace**
  - Annotation 관련 설정
    - \<context:annotation-config>
      - IoC 컨테이너에 생성된 객체 내부의 Annotation을 해석
    - \<context:component-scan base-package="spring.di">
      - @Component 클래스를 해석하여, IoC 컨테이너 내부에 해당 객체를 생성
      - \<context:annotation-config> 태그의 동작을 포함
- **Dependency Injection**
  - @Autowired
    - 위치
      - Prior to 클래스 내부의 Dependency 객체
      - Prior to 해당 Dependency 객체의 Setter 메서드
      - Prior to 해당 클래스의 Constructor
    - 동작
      - IoC 컨테이너 내부에, Dependency 객체의 타입을 만족하는 객체를 탐색
      - 탐색 성공 시, Dependency Injection이 정상적으로 진행
      - Dependency 객체 앞에 위치한 Autowired의 경우, Default 생성자 호출 이후 DI 진행
        - Default 생성자가 존재하지 않는다면, 예외 발생
    - 탐색 조건
      - IoC 컨테이너 내부에, Dependency의 타입에 해당하는 객체가 하나일 경우
        - 해당 객체가 다수일 경우, 예외 발생
    - 매개변수
      - boolean required
        - 설정해주지 않을 경우, 기본적으로 true로 설정
        - false로 설정해줄 경우, 해당 객체가 존재하지 않을 경우 DI를 진행하지 않음
  - @Qualifier(String name)
    - Dependency 객체에, name을 부여
    - IoC 컨테이너 내부에, 동일한 타입의 여러 객체를 식별
    - Constructor Injection 진행 시, 매개변수 앞에 위치
- **Bean 객체 생성**
  - @Component
    - 정의
      - 클래스 앞에 위치하여, 해당 클래스가 Spring Bean임을 나타낸다. 
      - 매개변수로 해당 Spring Bean의 name을 지정할 수 있다. 

    - 설정
      - XML 내부에 \<context:component-scan base-package="any.package"> 선언
      - ApplicationContext 객체 생성 - CPXAC
        - IoC 컨테이너는, base-package를 스캔하여 @Component가 선언된 클래스를 객체화

  - Semantic Component
    - 정의
      - Spring Bean 객체에 의미를 부여한다. 
      - 단순히 Application의 구성 요소로써의 클래스가 아닌, Application 내부에서 해당 클래스가 갖는 의미를 짐작할 수 있다. 

    - Annotations
      - @Controller
      - @Service
      - @Repository


- **Yet**
  - @Bean
  - @Required
  - @Primary
  - @Value
  - @Resource, @PostConstruct, @PreDestroy
    - Spring 프레임워크가 아닌, javax.annotation 패키지에 속한 Annotation
    - JDK 11부터 해당 javax.annotaiton 라이브러리를 지원하지 않는다. 


---

### Configuration using Java Code

- **Configuration 클래스**
  - Annotations
    - @Configuration
      - 클래스 앞에 위치하여, Configuration을 위한 클래스임을 알려준다. 

    - @ComponentScan(String[] basePackages)
      - 클래스 앞에 위치하여, Component Scan을 진행할 패키지들의 배열을 알려준다. 

    - @Bean
      - 메서드 앞에 위치하여, IoC 컨테이너 내부에 해당 메서드의 반환 결과 값의 객체가 생성된다. 

  - ApplicationContext 객체 생성
    - AnnotationConfigApplicationContext 생성자 활용
    - 매개변수
      - AppConfig.class


---

### Reference

- [Spring Framework Docs(Core Technologies)](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)
- [YouTube - 뉴렉처 [스프링 강의 01 - DI(Dependency Injection)]](https://www.youtube.com/watch?v=XtXHIDnzS9c&list=PLq8wAnVUcTFWxnsrMu5kS_jt_o8gpEiTR)