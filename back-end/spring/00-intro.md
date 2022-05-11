## Spring Framework

### Introduction

- Java EE
  - 기업형, 분산형 어플리케이션 개발을 위한 자바 버전
- Spring Framework
  - 기업형, 분산형 어플리케이션 개발을 위한 오픈 소스 프레임워크
    - 다수의 개발자에게 동일한 반복적인 작업을 자동화
  - Dependency Injection, Transaction Management, User Auth, 등을 지원

---

###Loose Coupling

- **개요**
  
  - 시스템 내부에 존재하는 구성 요소들이 서로 느슨하게 결합되어 있는 것
    - 느슨하게 결합된 경우 각 구성 요소들을 변경하기 쉬워진다. 
- **구현**

  - 자바의 인터페이스
    - 구성 요소 간의 결합력을 낮춰준다. 
      - 해당 인터페이스를 구현한 여러 클래스를 수용할 수 있다. 
    - 사용의 주체가 되는 클래스의 소스 코드 변경을 줄여준다. 
      - 구현체를 생성하는 부분의 변경이 필요하다. 
  - 인스턴스 생성 
    - new 예약어
      - Java 내에서 객체 생성에 가장 자주 사용되는 예약어
    - Class.forName(String name).newInstance()
      - 프로젝트 폴더를 기준으로, 전체 경로를 올바르게 입력해야 동작한다. 
      - 외부 설정 파일에서 클래스 명을 읽어와서, 해당하는 인스턴스를 생성할 수 있다. 
      - 소스코드를 변경하지 않고, 설정 파일을 변경하여 객체 간 결합을 바꿀 수 있다. 

---

### Maven

- 개요

  - 소프트웨어 빌드 도구
    - 프로젝트 생성, 라이브러리 설정, 코딩, 컴파일, 테스트, 패키징, 배포, 리포팅
  - 프로젝트 진행에 도움을 줄 수 있는 도구
    - IDE에 독립적이다. 

- 프로젝트 생성

  ```powershell
  C:\anydir> mvn archetype:generate -DgroupId=com.anydomain -DartifactId=anyprj -DarchetypeArtifactId=maven-archetype-quickstart
  ```

  - 프로젝트를 생성하고자하는 폴더에 가서, mvn 명령을 통해 프로젝트 생성이 가능
  - "repo.maven.apache.org" 서버에서 다양한 폴더를 다운로드하기 때문에, 네트워크 연결이 필요
  - 정상적으로 생성될 경우, "src/main", "src/test", "pom.xml" 및 하위 폴더 구조를 확인 가능

- Build Lifecycle

  - 프로젝트의 전반적인 빌드 과정, Lifecycle
  - Lifecycle의 각 단계, Phase
    - Phase는 기본적으로, "pom.xml" 파일의 \<packaging> 태그에 따라 결정된다. 
    - \<packaging> 태그의 값이 jar인지, war인지, 등에 따라 변경된다. 
    - \<phase> compile, test, package, install, deploy 등의 페이즈가 존재한다. 
  - 각 Phase에 사용되는, Plug-in
    - Phase별로 맞추어 꽂을 수 있는, Plug-in이 존재한다. 
    - 해당 Plug-in은 변경 가능하며, 모든 Phase가 사용하는 것은 아니다. 
    - "pom.xml" 파일을 수정하여, 해당 프로젝트에 적합한 Plug-in을 설정할 수 있다. 
  - 각 Plug-in의 목적, Goal
    - Plug-in은, 여러 목적을 가질 수 있다. 

- Dependency 설정
  - 해당 Maven 프로젝트와, 의존 관계에 있는 외부 라이브러리를 가져온다. 
    - 의존 관계가 있음은, 외부 라이브러리가 존재하여야 해당 프로젝트를 오류 없이 실행 가능하다는 것을 의미한다. 
    - 외부 라이브러리들을, "pom.xml" 파일의 \<dependency> 태그를 활용하여 Maven이 자동으로 가져오도록 설정해줄 수 있다. 
  - 프로세스
    - "pom.xml" 파일의 \<dependency> 태그에 존재하는 라이브러리를 정의
    - Maven은 이를 인식하여, 원격 저장소에서 로컬 저장소로 가져온다. 
      - "${user.home}/.m2/repository/" 폴더에 위치하게 된다. 
      - 가져오는 과정에서 에러가 발생했다면, 위 폴더를 참조하여 디버깅 진행
  - mvn install
    - Maven 프로젝트를, 로컬 저장소에 설치한다. 
    - 설치된 Maven 프로젝트는, 라이브러리로써 다른 프로젝트에 사용 가능하다. 
  - mvn deploy
    - Maven 프로젝트를, 원격 저장소에 저장한다. 
    - 이를 통해, 내가 생성한 라이브러리를 다른 사용자들 또한 사용할 수 있다. 
  
- \<dependency>

  - \<groupId>
  - \<artifactId>
  - \<scope>
    - runtime
      - 컴파일 시 해당 dependency를 사용하지 않는다
      - 컴파일 단계에서 필요하다면 에러가 발생
      - Eclipse - Maven Dependencies: 해당 라이브러리는 별도의 색으로 표현


---

### Reference

- [Spring docs](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html)
- [YouTube - 뉴렉처 [스프링 강의 01 - DI(Dependency Injection)]](https://www.youtube.com/watch?v=XtXHIDnzS9c&list=PLq8wAnVUcTFWxnsrMu5kS_jt_o8gpEiTR)
- [YouTube - 뉴렉처 [메이븐(Maven) 강의/강좌 on 이클립스]](https://www.youtube.com/watch?v=VAp0n9DmeEA&list=PLq8wAnVUcTFWRRi_JWLArMND_PnZM6Yja)
