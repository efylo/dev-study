## Apache Tomcat

### Description

- 설치
  - [Apache Tomcat® - Welcome!](https://tomcat.apache.org/)
  - 실제로 서비스하고자 한다면, Windows Service Installer를 통해 진행
    - PC의 Service에 등록되어, 자동으로 실행
- Command prompt
  - 실행 명령어
    - %CATALINA_HOME%\bin\startup.bat
    - %CATALINA_HOME%\bin\catalina.bat start
  - 종료 명령어
    - %CATALINA_HOME%\bin\shutdown.bat
    - %CATALINA_HOME%\bin\catalina.bat stop
- 실행 확인
  - "localhost:8080"
    - 웹 브라우저에, 상기 주소 입력
    - tomcat 페이지 로딩 확인
  - 동일 공유기에 연결된 다른 기기를 통해 확인
    - localhost의 자리에 로컬 PC의 ip주소 입력
    - "192.168.x.xxx:8080" 등

---

### System 환경 변수 설정

- Tomcat application을 구동하기 위해서, 몇몇 시스템 환경 변수 설정이 필요하다. 
- "apache-tomcat-[version]" 폴더 내 "RUNNING.txt" 파일에 환경 변수 설정 방법 및 이유가 명세되어 있다. 
  - JDK SE 8.0 이상 설치
    - Tomcat은 Java를 이용해 개발된 애플리케이션이기 때문에, JRE 혹은 JDK에 대한 설치를 필요로 한다. 
  - CATALINA_HOME
    - Required(필수)
    - 시스템 환경 변수에 "apache-tomcat-[version]" 폴더를 등록
    - 자동으로 등록해주기도 하지만, 그렇지 않을 수 있기에 명시적으로 등록하는 것을 추천
  - JAVA_HOME / JRE_HOME
    - Require(필수), 둘 중 하나만 등록되어 있어도 가능
    - 시스템 환경 변수에 JDK / JRE 폴더를 등록
    - 둘 다 설치되어 있다면, JRE_HOME이 사용
  - CATALINA_BASE
    - Optional(선택)
    - Multiple Tomcat Instances를 위한 시스템 환경 변수
  - Optional
    - CATALINA_OPTS
    - CATALINA_PID (only in *nix)
      - pid 강제를 통해서, 프로세스 강제 종료를 가능케 함
    - JAVA_OPTS
  - 기타
    - 'setenv.bat' / 'setenv.sh' 파일을 통한 환경 변수 설정

---

### Tomcat

- RUNNING.txt
  - Apache 재단의 Tomcat의 정상적인 구동을 위한 Docs
  - 목적: 컴퓨터에서 tomcat 실행
- BUILDING.txt
  - Apache ant를 활용, 작성한 프로그램을 하나의 통합된 SW로 빌드하여 배포하는 과정에 대한 명세
  - DBCP(Database Connection Pool)의 Non-backward compatibility에 대한 주의사항 명세

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)
- apache-tomcat-9.0.56\RUNNING.txt
- apache-tomcat-9.0.56\BUILDING.txt