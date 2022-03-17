## Servlet

### Abstract

- Web에서 들어오는 HTTP 요청에 대한 반응을 전송
  - 이 때, 각 요청에 대해 상이한 로직을 갖는 서버 애플리케이션의 일부를 실행
  - Server Application Let의 준말이라는 속설이 존재

---

### 동작

- WAS(Apache tomcat)
  - Servlet 클래스 Classloading
    - WAS가 작성된 Servlet 클래스를 Load하여 구동
    - Load하여 구동하기 위해, HttpServlet 인터페이스 상속 필요
    - WAS는 HttpServlet 추상 클래스를 호출하여 실행
  - HttpServlet 인터페이스
    - service 메서드 구현 필수
      - protected 접근 제어자
      - 이는, HttpServlet 인터페이스의 자식 클래스에서 사용 가능하다. 

---

### 코드

- Foo.java

  ```java
  import javax.servlet.*;
  import javax.servlet.http.*;
  import java.io.*;
  
  public class Foo extends HttpServlet {
      protected void service(HttpServletRequest request
                         , HttpServletResponse response)
                         throws IOException, ServletException
      {
          System.out.println("hello Servlet");
      }
  }
  ```

  - System.out.println 메서드는, WAS의 콘솔 창에 로그를 남긴다. 

- javac

  - JDK 폴더 내에 존재하는 자바 컴파일러
  - Foo.java 파일을 컴파일하여, Foo.class 파일을 생성
  - javac에 classpath 추가
    - javac - cp "...\servlet-api.jar" Foo.java
    - Foo.java를 "...\servlet-api.jar" 파일을 포함하여 컴파일한다는 의미

- 확인

  - Foo.java 파일 위치에, Foo.class 파일이 생성된 것을 확인

---

### WEB-INF 폴더

- WEB-INF 폴더 구조

  - web.xml
  - classes
    - Foo.class

- WEB-INF 폴더 특징

  - 사용자의 임의 접근 불가능

  - url-pattern => servlet-name

  - servlet-name => servlet-class

    ```xml
    <!-- ... -->
    <servlet>
        <servlet-name>foo</servlet-name>
        <servlet-class>Foo</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>foo</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
    ```

    - "/hello" 패턴에 매칭되는 url이 전송될 경우, foo 이름을 갖는 servlet을 찾는다, foo 이름에 해당되는 Foo 클래스를 실행하여 사용자에게 response를 반환한다. 

---

### I/O

- Stream 계열

  - Byte 단위로 데이터를 처리

  - 영어가 아닌, 다른 언어를 사용해서 문자열을 처리하지 못한다. 

  - 코드

    ```java
    import javax.servlet.*;
    import javax.servlet.http.*;
    import java.io.*;
    
    public class Foo extends HttpServlet {
        protected void service(HttpServletRequest request
                           , HttpServletResponse response)
                           throws IOException, ServletException
        {
            // Foo는 WAS로부터 response 인스턴스를 제공받는다. 
            // response 인스턴스로부터, os 인스턴스를 가져온다. 
            // out 인스턴스를 사용해, os 인스턴스에 내용을 작성한다. 
            // out 인스턴스의 true는, 엔터가 눌렸을 때 데이터를 내보냄(flush)
            OutputStream os = response.getOutputStream();
            PrintStream out = new PrintStream(os, true);
            out.println("Hello Servlet");
        }
    }
    ```

- Reader / Writer 계열

  - String 단위로 데이터를 처리

  - 한국어를 포함, 영어권이 아닌 국가들은 Writer계열이 권장된다. 

  - 코드

    ```java
    import javax.servlet.*;
    import javax.servlet.http.*;
    import java.io.*;
    
    public class Foo extends HttpServlet {
        protected void service(HttpServletRequest request
                           , HttpServletResponse response)
                           throws IOException, ServletException
        {
            PrintWriter out = response.getWriter();
            out.println("안녕 서블릿");
        }
    }
    ```

- out.println()

  - 현재 실행하는 서블릿 프로그램이 문자열 / 바이트 데이터를 출력한다. 
  - 서블릿이 출력한 데이터를, WAS의 response 인스턴스가 입력받는다. 

---

### Problems

- 출력 문제
  - 브라우저에 컨텐츠의 형식을 알려주지 않았기에, 브라우저는 이를 자의적으로 해석
  - Servlet이 보내는 웹 문서를 .txt / .html 등으로 해석하느냐에 따라서 브라우저는 이를 다르게 렌더링
- 인코딩 문제
  - ISO-8859-1

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)