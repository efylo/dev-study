## View

### Abstract

- Controller 단은 사용자의 요청에 포함된 Parameter들을 해석하여, 서버 프로그램에 포함된 다양한 로직을 처리하고, View 단에 데이터를 전송한다. 
- View 단으로 전송되는 데이터를, Model이라고 일컫는다. 
  - Spring
    - org.springframework.ui.Model 클래스
  - Servlet / JSP
    - Java Beans, Dto, Vo 클래스

---

### Template Engine

- Model에 포함된 데이터를 해석하여, HTML 페이지를 구성해주는 엔진
  - Thymeleaf 등
- project-name/src/main/resources/templates 폴더
  - Template Engine 위에서 구동될 HTML 페이지를 위치시킨다. 
- project-name/src/main/resources/static 폴더
  - 정적인 HTML 페이지를 위치시킨다. 
  - 폴더 내 index.html 페이지는 자동적으로 서버의 welcome-page로 설정된다. 