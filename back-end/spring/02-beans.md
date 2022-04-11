## Spring Beans

### Abstract

- Spring 프레임워크의 IoC 컨테이너에 제공되는 정보
  - 프레임워크를 사용하는 개발자에게 정보 제공의 책임이 있다. 

- Meta-data
  - 클래스명
    - 클래스명은, 패키지 정보를 포함한 full-name
  - 동작과 관련된 정보
    - IoC 컨테이너 내부 동작과 관련된 정보들이 포함
    - Scope, Lifecycle callbacks, ...
  - 다른 Bean들과의 참조 관계
    - Dependencies
  - Pool 및 Connection 크기 등

---

### Configuration Methods

- **XML**

  - config.xml 파일 생성

    - Configuration을 위한 파일임을 알려줄 수 있는 파일 명을 사용 권장

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
      	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
      
      	<!-- B b = new B(); -->
      	<bean id="B" class="com.anypackage.B" />
      	<!-- A a = new A(); -->
      	<bean id="A" class="com.anypackage.A">
      		<!-- a.setB(b); -->
      		<property name="b" ref="b" />
      	</bean>
      
      </beans>
      ```

      - Dependency Injection 뿐만이 아닌, 더 다양한 설정이 가능

  - spring-context 라이브러리

    - .xml 파일을 읽어서 현재 프로젝트에 활용하기 위한 인터페이스 및 클래스 제공

      ```java
      ApplicationContext context = new ClassPathXmlApplicationContext("com/anypackage/config.xml")
      ```

      - ClassPath = 프로젝트의 src 폴더
      - 이외에 FileSystemXml..., XmlWeb... 또한 사용할 수 있다. 

  - 라이브러리 생성 / 가져오기

    - Maven - pom.xml - \<dependencies> - \<dependency> 태그 활용

  - 여담

    - XML / Annotation 방식의 Configuration
      - 각 방식의 장단점이 존재하기 때문에, 개발자의 선택이라고 한다. 
        - 혼용하는 것 또한 가능하다. 
      - Annotation 방식이 먼저 실행되며, 이후 XML 방식이 실행된다. 
        - 중복된 경우, XML Injection의 방식이 사용된다. 

- **Annotation**

- **Java**

---

### Reference

- [Spring Framework Docs(Core Technologies) - Beans Definition](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-definition)
- [Spring Framework Docs(Core Technologies) - Beans Annotation Config](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-annotation-config)
- [YouTube - 뉴렉처 [스프링 강의 01 - DI(Dependency Injection)]](https://www.youtube.com/watch?v=XtXHIDnzS9c&list=PLq8wAnVUcTFWxnsrMu5kS_jt_o8gpEiTR)