## Web MVC

### Abstract

- **MVC Design Pattern**
  - Model
    - 데이터 표현에 관련된 객체, 처리 및 응답에 대한 객체, 등
    - 종류
      - Entity (Dto, Vo, Java Beans)
        - 데이터 표현에 관련된 객체, 하나의 객체는 개체의 상태 정보를 포함
      - Service Object
        - 데이터 처리와 관련된 비즈니스 로직을 포함하는 객체
      - Data Access Object
        - 데이터베이스와 관련된 로직을 포함하는 객체
  - View
    - 사용자에게 화면, 글자, 등으로써 어플리케이션의 상태를 표현
    - 사용자의 입력을 처리하여, 서버로 전달
    - View단의 데이터는 직접 접근 불가능
      - Tomcat의 경우, WEB-INF 내 View 단의 데이터를 보관
      - 이와 상이하게, 정적 컨텐츠의 경우 사용자에게 직접 노출되어있다. 
  - Controller
    - 사용자의 요청으로부터, 어플리케이션의 동작을 정의
      - 요청에 포함된, 행위 / 상태와 관련된 정보를 파싱
      - 파싱된 정보에 기반하여, 동작을 수행
      - 수행 후 View로 진행

---

### Spring Web MVC Data Flow

- 개요
  - Web 상에서 데이터의 흐름은, HTTP 요청 - 서버의 처리 - HTTP 응답으로 구분할 수 있다. 
  - 하나의 Spring Web MVC 어플리케이션 내에서, 데이터의 흐름을 이해하고자 한다. 
- 흐름
  1. HTTP 요청
     - 웹 서버는 사용자의 HTTP 요청을 입력받는다. 
     - Tomcat과 같은 WAS는, 웹 서버의 기능을 포함하므로 구동 시에 HTTP를 통한 접근이 가능하다. 
  2. Filter
     - HTTP 요청은, WAS로 전달되면서 필터를 거치게 된다. (전처리)
     - Spring 웹 어플리케이션은, 필터링이 된 요청을 전달받는다. 
  3. DispatcherServlet
     - 필터링이 된 요청은, Spring 어플리케이션의 웹 부분에 존재하는 DispatcherServler으로 전달된다. 
     - DispatcherServler은 전송받은 요청을 HandlerMapping으로 전달한다. 
  4. HandlerMapping
     - 서버로 전달된 URL 주소와 이를 처리하는 Controller를 매핑한다. 
     - URL 주소를 입력받아, 해당하는 Controller를 출력하는 방식으로 이해할 수 있다. 
     - 정적 컨텐츠의 경우 다른 로직을 따를 것으로 보인다. 
  5. Controller
     - 요청에 포함된 Parameter를 입력받아, 서비스를 처리한다. 
     - 서비스를 처리함에 있어서, Service / Dao / DB 클래스를 사용할 수 있다. 
     - 처리된 값을 출력한다. 
       - 출력하는 데이터 타입에 따라서, 처리 방식이 달라진다. 
  6. ViewResolver
     - View의 이름을 입력받아, 해당하는 URL 주소를 반환한다. 
     - 항상 호출되는 것은 아니다. 

---

### Web Project

- **WEB**
  - 구성 요소
    - Web Components
    - Static Resources
    - Helper Classes & Libraries
  - Web Application Lifecycle
    1. 웹을 구성하는 코드를 작성한다. 
    2. 필요하다면, 웹 어플리케이션 배포에 필요한 설정 파일을 작성한다. 
    3. 컴파일을 진행한다. 
    4. 필요하다면, 패키징을 진행한다. 
    5. 웹 컨테이너에 어플리케이션을 배포한다. 
    6. URL 주소를 통해 접근한다. 
  - WAR; Web application ARchive
    - JAR, JSP, 서블릿, 자바 클래스, XML, 태그 라이브러리, 정적 컨텐츠 등을 묶어놓은 파일로써, 웹 어플리케이션을 구성
    - WEB-INF
      - .war 파일의 특수한 디렉토리
      - web.xml
        - URL 주소와 서블릿을 매핑
        - 서블릿과 관련된 Dependency들에 대한 등록
        - WAS가 읽어들이는 파일

---

### Maven Project Structure - WEB

- Maven Project 구성
  - src
    - main
      - java
        - 어플리케이션과 관련된 소스 파일
      - resources
        - META-INF
        - 자바 어플리케이션에 사용되는 리소스
      - webapp
        - *resources*
          - 웹 어플리케이션의 정적 컨텐츠 (html, css, js, images, ...)
        - WEB-INF
          - classes
            - 런타임에 사용되는 자바 클래스, 패키지, 리소스
          - *spring*
            - Spring Container와 관련된 설정 파일
            - 웹 / 어플리케이션의 두 파일을 포함
          - views
            - 동적 컨텐츠
          - web.xml
            - 웹 어플리케이션에 관련된 설정 파일
  - target
    - mvn build / package 단계의 산출물을 저장
    - mvn clean을 통해 산출물 삭제
  - pom.xml
    - Project Object Model; 현재 프로젝트와 관련된 설정 파일을 포함

---

### XML Configuration

- **pom.xml**
  - 프로젝트와 관련된 설정 파일
  - namespace - Maven, POM
    - xmlns = "http://maven.apache.org/POM/4.0.0"
  - 하위 태그
    - groupId / artifactId / name
      - 프로젝트의 식별자
    - packaging
      - package 과정의 결과로 반환될 통합 파일의 확장자
      - jar, war 등
    - version
      - 프로젝트의 버전 정보
    - properties
      - xml 파일 내에서 사용할 속성, 주로 라이브러리들의 버전 정보를 관리
      - \<property-name>val\</property-name>
        - ${property-name} == val
    - dependencies
      - dependency
        - 프로젝트에서 사용할 외부 라이브러리
        - groupId / artifactId / version - dependency에 대한 식별자
        - scope - 해당 라이브러리를 사용할 범위를 지정
        - exclusions - 포함하지 않을 하위 라이브러리를 지정
    - build
      - plugins
        - 빌드 과정에서 사용되는 플러그인
- **web.xml**
  - Spring Web MVC 어플리케이션
    - WAS에서 현재 어플리케이션을 구동하기 위해, 읽어들이는 설정 파일
  - namespace - Java EE
    - xmlns = "http://java.sun.com/xml/ns/javaee"
  - 하위 태그
    - context-param
      - Root Spring Container의 xml 파일을 설정
    - listener
      - 특정 이벤트가 발생 했을 때 동작하는 WAS의 구성 요소
      - Spring - ContextLoaderListener
    - filter / filter-mapping
      - 특정 url로 넘어오는 요청/응답에 적용할 필터를 설정
    - servlet / servlet-mapping
      - 현재 웹 어플리케이션에 결부할 서블릿을 설정
    - welcome-file-list
    - error-page
      - exception-type / error-code
      - location
      - 해당 예외 / 에러 코드와 일치할 경우, location으로 보낸다. 
- **root-context.xml**
  - Spring Container에 관한 설정 - 어플리케이션 부분
  - namespace
    - xmlns = "http://www.springframework.org/schema/beans"
  - Spring Bean 객체
    - context:component-scan
      - 웹과 관련 없는 Component에 대한 스캔을 진행 (모델, AOP, 유틸리티 클래스 등)
    - DataSource
      1. SimpleDriverDataSource
         - DB 커넥션 풀을 활용하지 않으며, 요청이 들어왔을 때 DB와 연결을 맺는다. 
      2. DB 커넥션 풀 - WAS
         - WAS의 메모리에, DB 커넥션 풀을 생성하여 활용할 수 있다. 
         - WAS에 커넥션 풀과 관련된 설정을 진행한 이후, JNDI API를 통해 현재 어플리케이션에서 참조한다. 
           - "webapp/META-INF/context.xml"에서 커넥션 풀을 생성
           - "root-context.xml"에서 해당 커넥션 풀을 참조하여, 팩토리 클래스를 생성
             - JndiObjectFactoryBean 클래스 활용
      3. DB 커넥션 풀 - 자체 커넥션 풀
         - WAS에 의존하지 않고, 자체적으로 커넥션 풀 관리 기능이 존재하는 클래스를 활용
           - [Apache Commons 프로젝트 - DBCP2](https://commons.apache.org/proper/commons-dbcp/)
           - [HikariCP](https://github.com/brettwooldridge/HikariCP)
             - Tomcat, DBCP2 등의 커넥션 풀보다 성능이 좋다고 한다. 
  - Aspect 설정
    - aop:aspectj-autoproxy
      - aspect (advice + pointcut) 생성
      - proxy - pointcut을 실행함에 있어서, advice를 적용하여 순차적으로 실행
- **servlet-context.xml**
  - Spring Container에 관한 설정 - 웹 MVC 부분
  - namespace
    - xmlns = "http://www.springframework.org/schema/mvc"
  - Spring Bean 객체
    - ViewResolver
      - String, ModelAndView, 등의 객체가 주어졌을 때, 이를 실제 View 단의 데이터와 매핑
    - context:component-scan
      - Controller
  - HandlerMapping
    - annotation-driven
      - RequestMapping이 설정된 클래스 / 메서드 매핑
    - resources
      - 정적 컨텐츠 매핑
  - MultipartResolver
    - content-type이 멀티파트인 요청을 해석한다. 
  - Interceptors
    - Interceptor 객체와 url 주소를 매핑

---

### Reference

- [Web Application Lifecycle - The Java EE 6 Tutorial](https://docs.oracle.com/javaee/6/tutorial/doc/bnadu.html)
- [WAR (file format) - Wikipedia](https://en.wikipedia.org/wiki/WAR_(file_format))
- [jhgan - jsp 공통 에러 페이지 처리 (Servlet Exception Handling)](https://jhgan.tistory.com/13)
- [The LifeCycle Listener Component - Apache Tomcat](https://tomcat.apache.org/tomcat-9.0-doc/config/listeners.html)
- [Maven Project Structure Example](https://examples.javacodegeeks.com/enterprise-java/maven/maven-project-structure-example/)