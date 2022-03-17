## Response - Encoding Type

### Abstract

- Encoding이란, 문자 혹은 기호 등을 컴퓨터가 이해할 수 있는 바이트 단위의 데이터로 변환하는 것을 의미한다. 
- Tomcat의 기본 Character Encoding은 "ISO-8859-1"로 설정되어 있다. 
  - ISO-8859-1
    - 데이터를 1바이트 단위로 처리한다. 
    - 라틴 계열의 문자들을 통상적으로 포함한다. 
    - 한국어는 ISO-8859-1에 포함되지 않는다. 

---

### 한국어 데이터 전송

- HTTP Response의 Character Encoding을 변경

  ```java
  @Override
  protected void service(HttpServletRequest req
                         , HttpServletResponse resp) 
                         throws ServletException, IOException {
      resp.setCharacterEncoding("UTF-8"); 
  }
  ```

  - 문제점
    - 서버에서 UTF-8로 데이터를 전송하지만, 브라우저는 이를 알 수 없다. 
    - 브라우저가 UTF-8로 데이터를 해석하지 않는다면, 사용자는 데이터를 제대로 확인할 수 없다. 

- HTTP Header의 content-type을 변경

  ```java
  @Override
  protected void service(HttpServletRequest req
                         , HttpServletResponse resp) 
                         throws ServletException, IOException {
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html; charset=UTF-8");
  }
  ```

  - content-type: HTTP 본문의 컨텐츠의 형식을 일러준다. 
    - "text/html": HTML 형식의 데이터
    - "charset=UTF-8": UTF-8로 인코딩됨

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)