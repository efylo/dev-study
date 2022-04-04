## Web Development

### Abstract

- Web에서 서비스를 제공하는 프로그램을 개발
- 거시적으로 Static contents, MVC / Template engine, API 세 종류의 개발 과정이 존재

---

### Static Contents

- 서버 프로그램 내에서 따로 처리를 진행하지 않고, 사용자에게 바로 전송하는 웹 컨텐츠
  - Spring Initializr을 통해 생성한 프로젝트 내 위치
    - project-name/src/main/resources/static 폴더에 기본적으로 저장한다. 
- Process
  - URL Mapping 탐색
    - Http 요청 내 존재하는 URL에 매핑된 서버 프로그램이 존재하는지 탐색
  - Static Contents 탐색
    - Mapping된 서버 프로그램이 존재하지 않는다면, 정적 컨텐츠를 탐색

---

### MVC / Template Engine

- MVC 디자인 패턴
  - JSP / Servlet 기반 스파게티 코드를 이해하기 쉽고, 기능별로 분리하여 관리하기 위한 목적으로 개발된 디자인 패턴
  - View: 사용자에게 전달할 화면을 구성하는 단
  - Controller: 사용자의 각 요청을 처리하는 로직을 구현하는 단
  - Model: Controller와 View 단 사이에 주고받는 데이터
    - View는 Controller가 전송한 Model을 기반으로, 동적 페이지를 구성한다. 
- 분기
  - HTTP 요청 > Controller > (Service > DAO > DB ...) > Controller > View > HTTP 응답
  - HTTP 요청 > Controller > HTTP 응답
  - HTTP 요청 > Mapping 실패 > Static Contents > HTTP 응답

---

### API

- Application Programming Interface
  - Abstract
    - 응용 프로그래밍을 함에 있어서, 부 프로그램 / 프로토콜 등을 정의하여 타 프로그램과의 상호 작용을 하기 위한 인터페이스
    - 개념으로써의 부 프로그램 / 프로토콜 등을 일컫는다. 
      - 실제로 구현한 구현체를 라이브러리라고 일컫는다. 
    - API / 라이브러리는 프로그래머가 사용의 주체가 된다. 
      - 프로그래머가 작성한 코드 내에, 적절하게 사용된다. 
    - 프레임워크는 프로그래머가 사용의 객체가 된다. 
      - 프로그래머는, 프레임워크가 제공하는 규격에 맞추어 코드를 작성한다. 

- API 개발
  - 프로그램 / 프로토콜을 정의