## Build

### Abstract

- 서버 프로그램 구성에 필요한 모든 자원을 묶어, 하나의 통합된 소프트웨어로 구성하는 과정
  - Spring boot project 구성 시 포함된 파일들이 모두 해당된다. 
- Gradle을 활용하여 build할 경우, 하나의 .jar 파일을 반환한다. 
  - "java -jar xxx.jar" 명령어를 통해, .jar 파일을 실행할 수 있다. 

---

### Process

- MS Powershell

  ```powershell
  PS C:\> cd spring-project/project-name
  PS C:\spring-project\project-name> ./gradlew.bat build
  ...
  ```

  - Spring Initializr을 통해 생성한 프로젝트에 존재하는, "gradlew.bat" 배치 파일을 활용하여 빌드할 수 있다. (Windows 11)

- Errors

  - compileJava FAILED
    - 시스템 환경 변수 - "JAVA_HOME" 변수 확인
      - 프로젝트에서 정의된 자바 버전과, JAVA_HOME의 버전이 다르다면 컴파일되지 않는다. 
      - 변수 설정 후, PowerShell 종료 후 다시 실행하여야 제대로 적용된다. 

- Run

  ```powershell
  PS C:\spring-project\project-name> cd build/libs
  PS C:\spring-project\project-name\build\libs> java -jar project-name-0.0.1-SNAPSHOT.jar
  ```

  - 시스템 환경 변수 - "Path" 변수에 존재하는 jdk의 버전 확인

- Check

  ```powersh
    .   ____          _            __ _ _
   /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
  ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
   \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
   =========|_|==============|___/=/_/_/_/
   :: Spring Boot ::                (v2.6.6)
  ```

  - 스프링의 로고 확인
  - http://localhost:8080 체크

