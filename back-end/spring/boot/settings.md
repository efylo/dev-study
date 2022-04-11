## Spring Framework

### Settings

- intelliJ IDEA
  - IDE for java application development
- JDK 11
  - Software development toolkit for Java

---

### JDK Settings

- JDK 버전 확인
  - [Spring Initializr](https://start.spring.io/)
    - Project Metadata의 Java 버전과 동일한 버전의 JDK 확인
- JDK 설치
  - Google 검색 후 설치
- 환경 변수 등록
  - 시스템 속성 - 환경 변수
    - Path 변수 선택
      - 다운로드 받은 jdk 파일의 bin 폴더 추가

---

### Spring Initializr

- Project
  - Maven / Gradle
    - 프로젝트 빌드 도구
- Language
  - Java / Kotlin / Groovy
    - 개발 시 사용할 언어
- Spring Boot
  - Versions for Spring Boot Application
    - SNAPSHOT: 아직 개발 중인 버전
    - M1, M2, M3, ...
    - Others: Stable release
- Project Metadata
  - Group
    - 회사명, 단체명, ...
  - Artifact
    - 프로젝트명
  - Package name
    - (default) group.artifact
  - Packaging
  - Java
    - 프로젝트에서 사용할 Java 버전
- Dependencies
  - Spring Web
    - Web 개발 시 필요한 Tomcat, Spring MVC, ...
  - Thymeleaf
    - Server-side Java template engine for HTML

---

### Gradle

- Automatic Downloads
  - Gradle이라고 하는 빌드 도구는, 자동적으로 Dependencies에 선언된 라이브러리들을 다운로드한다. 
  - intelliJ IDEA - External Libraries / Gradle - Dependencies
    - 현재 프로젝트와 의존 관계에 존재하는 라이브러리를 확인할 수 있다. 

---

### Dependencies

- 해당 프로젝트와 의존 관계에 놓여있는 외부 라이브러리를 가져온다. 
  - Eclipse의 Java Libraries에 외부 라이브러리를 추가하는 과정
- 자주 사용되는 라이브러리
  - Spring Boot Libraries
    - spring-boot-starter-web
      - spring-boot-starter-tomcat
      - spring-webmvc
  - spring-boot-starter-thymeleaf
  - spring-boot-starter
    - spring-boot
      - spring-core
    - spring-boot-starter-logging
      - logback, slf4j
  - Test Libraries
    - spring-boot-starter-test
      - junit
      - mockito
      - assertj
      - spring-test