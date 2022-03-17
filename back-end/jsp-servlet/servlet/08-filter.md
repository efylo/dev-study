## Filter

### Abstract

- Tomcat의 구조
  - Web server
    - HTTP Request / Response를 처리한다. 
  - WAS
    - HTTP Request에 상응하는 서블릿을 실행
    - 서블릿의 결과값을 HTTP Response에 담아 전송
  - Servlet container
    - 서비스하고자 하는 Application
- Filter
  - WAS와 Servlet container 사이에 존재
  - WAS에서 특정 서블릿을 실행하기 전에, 혹은 실행하고 난 뒤에 동작
  - 여러 서블릿들에 공통된 로직을 적용할 수 있다. 

---

### 환경 설정 / 생성

- 환경 설정

  - "web.xml" 파일을 수정하여, Filter를 적용

    ```xml
    <filter>
        <filter-name>xxxFilter</filter-name>
        <filter-class>com.example.web.filter.xxxFilter</filter-class>
    </filter>
    
    <filter-mapping>
        <filter-name>xxxFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```

    - "/*": 모든 url에 대하여, "xxxFilter"를 적용, 특정 url에만 적용하고 싶다면 변경
    - Filter 로직을 작성하고, 이를 적용하는 부분이 분리되어 있다

  - Annotation을 통해, Filter를 적용

    ```java
    @WebFilter("\*")
    public class xxxFilter implements javax.servlet.Filter {
        @Override
        public void doFilter(ServletRequest request
                            , ServletResponse response
                            , FilterChain chain)
        throws IOException, ServletException {
            // Servlet 호출 전 실행하는 로직
            // ...
            chain.doFilter(request, response);
            // Servlet 호출 후 실행되는 로직
            // ...
        }
    }
    ```

    - Filter 로직을 작성하며, 이를 적용하고 싶은 서블릿의 url 패턴 명시 가능
    - FilterChain chain
      - 비동기 처리를 지원한다. 
      - chain.doFilter() 함수 호출 이전의 코드는, 서블릿이 호출되기 전에 실행
      - 호출 이후의 코드는, 서블릿이 호출되어 response를 반환할 시 실행

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)