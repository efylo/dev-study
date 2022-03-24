## ETC

### Errors

- JSP가 어떻게 Servlet 코드로 변환되는지 과정을 이해하는 것이, JSP 내의 에러를 줄이고 디버깅을 도와준다. 
  - JSP는, Jasper Engine이라는 인터프리터가, 구문 하나하나를 읽고 해석하여 Servlet 코드로 생성해준다. 
    - Eclipse workspace 내 .metadata에, Jasper가 해석한 Servlet 파일이 생성된다. 

---

### Syntax

- Comments

  - <%-- ... --%>
    - Jasper 엔진이 해석하지 않는 주석 구문
    - 반면, HTML의 주석 구문은 Jasper 엔진이 해석하므로, 주의를 요한다. 

- Directive (지시자)

  - page Directive

    - <%@ page charset="utf-8" import="java.io.*"%>
      - import 속성을 지정함으로써, 프로젝트 내 자바의 패키지를 JSP 내부적으로 사용할 수 있다. 
      
  - include Directive
    - <%@ include ... %>
    - 페이지에 특정 jsp 파일을 포함
  - taglib Directive

    - <%@ taglib prefix="c" uri="http://..." %>

---

### Scope

- WAS에 존재하는 객체의 영역

  - JSP 파일은, 본인이 속한 영역에 존재하는 객체를 참조할 수 있다. 

- 영역

  | 객체        | 설명                                   |
  | ----------- | -------------------------------------- |
  | pageContext | 하나의 JSP 페이지에 대한 영역          |
  | request     | 하나의 Http 요청에 사용되는 영역       |
  | session     | 하나의 클라이언트에 할당된 세션의 영역 |
  | application | 하나의 웹 어플리케이션의 전역적인 영역 |

  - 메서드: 네 영역 모두 동일한 아래의 메서드를 갖는다. 
    - setAttribute(String name, Object value)
    - getAttribute(String name)
    - getAttributeNames()
    - removeAttribute(String name)

---

### Separate Servlet, JSP using Forward

- Servlet 프로그램에서, JSP 파일로 포워딩

  - 사용자의 요청을 처리하는 Controller의 역할을 진행하는 부분을 Servlet에 작성

  - 사용자의 요청에 들어있는 Parameter들을 적절히 파싱하여 JSP 파일로 포워딩

    ```java
    ...
        // request 객체의 속성에, 전달하고 싶은 값을 할당
        request.setAttribute("name", obj);
    
    	// 포워딩을 진행할 dispatcher 객체
        RequestDispatcher dispatcher = 
            request.getRequestDispatcher("/page.jsp");
    
    	// "/page.jsp" 주소로 포워딩
        dispatcher.forward(request, response);
    ...
    ```

- page Directive 설정

  - 한글로 서비스를 진행하기 위해 웹 페이지의 설정 값을 지정

    ```jsp
    <%@ page language="java" contentType="text/html" charset="UTF-8"
        pageEncoding="UTF-8" %>
    ```