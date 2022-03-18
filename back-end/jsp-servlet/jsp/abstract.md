## JSP

### Abstract

- JSP 파일은, HTML 문서를 java 프로그램 내에서 동적으로 처리하는 어려움을 해결해주는 의의를 갖는다. 
  - Jasper 엔진이, JSP 파일을 파싱하여 서버의 배포용 디렉토리에 서블릿 파일을 생성
    - 배포용 디렉토리는, .metadata/.plugins/org.eclipse.wst.server.core/ 내부에 존재
  - Jasper 엔진은, 기본적으로 JSP 파일의 모든 데이터를 서블릿의 Http 응답에 작성

---

### Syntax

- <% ... %>
  - 서블릿의 서비스 함수 내에 자바 코드로써 인식되어 파싱된다. 
    - 서비스 함수 안에 위치할 수 있는 자바 코드를 작성해야 한다. 
- <%! ... %>
  - 멤버 변수 위치에 자바 코드로써 인식되어 파싱된다. 
    - 서비스 함수 내에 존재할 수 없는 자바 코드, 혹은 클래스 내에 전역적으로 사용하고자 하는 변수, 한수, 및 메서드를 정의하기 위해 사용된다. 
- <%@ page ... %>
  - HTML 페이지의 초기 설정을 진행해준다. 
  - 서비스 함수 내에서 첫 번째로 실행된다. 
    - Character encoding set 및 Content type을 주로 설정
    - Http response에 데이터가 입력될 경우, 이후에 위 설정들을 바꿔주는 것은 현재까지 response에 입력된 데이터가 올바른 값을 갖게 됨을 보장할 수 없기 때문이다. 
- 기타
  - 정의된 문법을 제외한 구문들은 출력 구문으로써 HTTP 응답에 작성된다. 
  - 출력 구문 중간에 코드 블럭을 삽입하여, 동적으로 데이터를 작성할 수 있다. 

---

### Local Variables

- 여기서 정의한 지역 변수란, Jasper 엔진이 jsp 파일을 파싱할 때 _jspService 함수에 기본적으로 생성해주는 지역 변수를 일컫는다. 

  > - 내장 객체
  >   - final javax.sevlet.jsp.PageContext **pageContext**;
  >   - javax.servlet.http.HttpSession **session** = null;
  >   - final javax.servlet.ServletContext **application**;
  >   - final javax.servlet.ServletConfig **config**;
  >   - javax.servlet.jsp.JspWriter **out** = null;
  >   - final java.lang.Object **page** = this;
  >   - HttpServletRequest **request**
  >   - HttpServletResponse **response**

- 위 내장 객체들은, jsp 파일의 코드 블럭 내에 변수로써 지정될 수 없다. 

---

### Spaghetti Code

- 자바 프로그램의 블럭 {} 내에, 출력 값으로 존재하고자 하는 데이터를 입력하고자 할 때, jsp 파일의 복잡도가 훨씬 높아진다. 
  - <% ... { %>
  - HTML tags...
  - <% } %>
    - jsp의 코드 블럭을 통해 java의 코드 블럭을 표현하고자할 때, 코드가 굉장히 복잡해지는 문제점을 갖는다. 
- 이 외에도, jsp의 코드 블럭 내에 java의 코드들이 스파게티처럼 흩뿌려져 있어서 유지보수하기 힘들어지는 상황이 자주 발생한다. 

---

### MVC

- model 1
  - 하나의 jsp 파일 내에 Model, Controller, View가 모두 존재하는 방식
  - Model
    - 출력을 위한 자바의 변수, <%= var %>
  - View
    - HTML 문서, 중간에 model들이 존재한다. 
  - Controller
    - java 코드 블럭, 특정 로직을 수행해 model의 값을 결정한다. 
- model 2
  - Controller, View가 물리적으로 분리

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)