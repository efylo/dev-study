## State

### Abstract

- Web에서 상태 유지의 어려움
  - 사용자가 서버 측으로 전송한 데이터는, 서버 단에서 저장되지 않는다. 
  - 사용자의 요청이 처리된 이후, 서블릿 객체는 종료되기 때문에, 그 때 사용된 변수들은 모두 사라지게 된다. 
- 상태 유지를 위한 5가지 방법
  - Application
  - Sesscion
  - Cookie
  - Hidden input
  - Query string

---

### Application

- Servlet들이 서로 간에 저장소로 사용할 수 있는 공용 공간
  - 이전에 저장해놓은 상태 값에 대해 참조 가능
  - HttpServletRequest 객체의 ServletContext 객체를 요청하여 사용
    - ServletContext application = request.getServletContext();
- ServletContext 객체
  - getAttribute(String name)
    - Application 객체의 name  속성에 해당하는 값을 가져온다. 
  - setAttribute(String name, Object value)
    - Application 객체의 name 속성에 해당하는 value 값을 지정한다. 
- 특징
  - 현재 Application 내에서 전역적으로 사용 가능하다. 
    - 모든 사용자에게 동일한 공간으로써 동작한다. 
  - 생명 주기: WAS가 종료될 경우

---

### Session

- Servlet들이 서로 간에 저장소로 사용할 수 있는 공용 공간

  - Application 객체는 WAS에서 전역적으로 접근 가능
  - Session 객체는 Http 요청을 보낸 사용자의 Session에만 접근 가능
    - HttpSession session = request.getSession();

- 사용자 식별

  - HTTP Request의 "SID" 속성을 참조하여 식별
  - 첫 요청
    - SID 값이 존재하지 않는다. 
    - WAS는 사용자에게 SID 값을 부여해주며, SID 값에 상응되는 Session 객체의 공간을 할당한다. 
  - 이후의 요청
    - HTTP Request의 "Cookie" 속성에 SID 값이 추가되어 전송된다. 
    - 웹 브라우저 단에서 자동으로 관리되며, SID 값만으로는 보안상의 문제가 발생할 수 있기 때문에 추가적인 검증 로직을 부여하는 경우도 빈번하다. 

- Methods

  > - void setAttribute(String name, Object value)
  > - Object getAttribute(String name)
  > - void invalidate()
  > - void setMaxInactiveInterval(int interval)
  >   - 사용자가 요청을 보내지 않기 시작한 시점부터, 만료 시점을 지정한다. 
  >   - 만료 시점이 지날 경우, 해당 사용자의 세션 공간을 할당 해제한다.  
  > - boolean isNew()
  > - Long getCreationTime()
  > - long getLastAccessedTime()
  
- 특징

  - 세션의 범위에서 사용되는 저장 공간, SID를 통해 각 세션을 구분한다. 
  - 생명 주기: 세션이 시작되고 종료될 때까지


---

### Cookie

- Cookie 객체는 사용자의 웹 브라우저 단에 저장되는 상태 정보이다. 
  - addCookie()를 통해 웹 브라우저에 저장 요청을 보낸다. 
    - response.addCookie();
  - getCookies()를 통해 사용자의 요청에 존재하는 Cookie[]을 받아온다. 
    - cookie.getName()을 통해, 원하는 쿠키의 name에 해당하는 value를 get
- Option 설정
  - cookie.setPath(String uri)
    - Cookie 객체의 path 속성을 설정
    - 특정 도메인의 서버에 데이터 요청 시, path가 일치하는 Cookie들만 Http Request에 심는다. 
    - 서버는, path가 일치하는 Cookie들만 받아서 보게 된다. 
  - cookie.setMaxAge(int expiry)
    - Cookie 객체의 maxAge 속성을 설정
    - maxAge가 존재하는 Cookie 객체는, PC의 로컬 스토리지에 저장되어 사용된다. 
    - maxAge가 없는 Cookie 객체는, 웹 브라우저의 프로세스 종료 시 날아간다. 
- 특징
  - Client의 Web Browser가 지정한 path 공간
  - 생명 주기: Browser에 전달한 시간으로부터, 만료시간까지
    - 서버의 생성 / 종료와 상관 없이 존재할 수 있다. 

  - 잘 활용할 경우, 서버 자원을 아낄 수 있다. 
    - 특정 url에서만 사용되는 상태 정보 / 사용자 정보 등


---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)