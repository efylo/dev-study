## Spring Beans / Configuration

### Abstract

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

---

### Configuration using XML

- **XML 파일 생성** - config.xml
  - ApplicationContext 객체 생성 시, 해당 파일 이름을 사용하여 접근한다. 
  - 정해진 이름을 활용할 필요는 없다. 
- **Tags**
  - \<beans> 태그
    - 포함하고 싶은 Namespace를 지정할 수 있다. 
      - beans, context, jdbc, tx, p, ...

  - \<bean> 태그
    - id: bean 객체의 이름
    - class: bean 객체의 클래스명, package-qualified
    - scope: bean 객체의 생성 범위; (default) singleton
      - GoF의 Singleton 디자인 패턴은 ClassLoader 기준으로 하나의 객체만을 허용한다면, 
      - Spring의 Singleton 디자인 패턴은 Container / Bean 단위로 하나의 객체만을 허용한다. 
    - init-method, destroy-method: 생성 / 소멸 시에 호출되는 메서드
      - Spring과 Java Code를 결합하는 단점이 존재한다. 
  - \<property> 태그
    - Setter Injection을 진행할 메서드의 name, 해당 인자 값 ref / value를 지정한다. 
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

- **Annotation**



---

### Configuration using Java Code

- **Java Code**

---

### Reference

- [Spring Framework Docs(Core Technologies) - Beans Definition](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition)
- [Spring Framework Docs(Core Technologies) - Beans Annotation Config](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-annotation-config)
- [YouTube - 뉴렉처 [스프링 강의 01 - DI(Dependency Injection)]](https://www.youtube.com/watch?v=XtXHIDnzS9c&list=PLq8wAnVUcTFWxnsrMu5kS_jt_o8gpEiTR)