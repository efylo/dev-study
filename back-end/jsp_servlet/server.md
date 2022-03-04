## Server

### Web server

- HTTP 요청을 직접적으로 받는 위치
- 요청을 동적으로 처리하기 위해 Server app을 호출
  - HTTP url 및 본문 데이터 참조

---

### WAS(Web Application Server)

- Web server로부터 파싱된 데이터를 받는다. 
- 데이터에 상응하는 비즈니스 로직을 수행한다. 
- 수행 후 결과물을 다시 web server로 전송한다. 

---

### Apache Tomcat

- 설치
  - [Apache Tomcat® - Welcome!](https://tomcat.apache.org/)
  - 실제로 서비스하고자 한다면, Windows Service Installer를 통해 진행
    - PC의 Service에 등록되어, 자동으로 실행
- 환경 설정
  - 시스템 환경 변수 설정
    - 이름: JAVA_HOME
    - 폴더: 로컬 환경의 jdk 폴더
- 실행
  - apache-tomcat-x.x.xx/bin 폴더
    - startup.bat 파일 실행
  - Tomcat 실행 시, 웹 서버도 같이 실행된다. 
- 오류 발생 시
  - JAVA_HOME 환경 변수에 등록된 폴더 확인
  - 관리자 권한으로 실행
  - cmd를 통해 startup.bat 파일 실행
- 동작 확인
  - localhost:8080
    - 웹 브라우저에, 상기 주소 입력
    - 로컬 환경의 8080번 포트를 접근함을 의미
    - 8080번 포트는, HTTP의 예비 포트
  - 동일 공유기에 연결된 다른 기기를 통해 확인
    - localhost의 자리에 로컬 PC의 ip주소 입력