## Architecture

### Abstract

- Web Application Architecture에는, 2개의 모델로 나누어 생각할 수 있다. 
  - Model 1
    - Model - Business, DB Logic을 처리
    - View, Controller - 사용자의 요청을 처리, 응답에 필요한 화면을 구축
  - Model 2
    - Model
      - Logic 처리를 담당
      - Service: 비즈니스 로직 처리
      - Dao: DB 작업 처리
      - Java Beans: Entity 값을 각각 저장할 클래스
    - View
      - 모든 화면 처리를 담당
    - Controller 
      - Servlet에서 Client의 요청을 분석하여, Logic 처리를 위해 Model 단을 호출한다. 
      - Model 단에서 처리된 data를 request, session, application 객체에 저장
      - Redirect / forward 방식을 통해 JSP 페이지로 출력

---

### Include

- <%@ include file="/template/xxx.jsp" %>
  - header.jsp 파일을, 현재 JSP 파일로 가져와서 사용한다. 
  - 잦은 중복이 일어나는 JSP 파일을, 하나의 파일로 생성하여 재사용이 가능하다. 
    - 프로젝트의 context path
    - HTML의 header, footer, 등