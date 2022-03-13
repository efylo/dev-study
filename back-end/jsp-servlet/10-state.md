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
- ServletContext 객체
  - getAttribute(key) / setAttribute(key)
    - 현재 Servlet의 Context에 존재하는 특성 값을 가져올 수 있다. 
    - key - value 값으로 저장되며, DOM 객체를 활용하는 방법과 비슷하다. 
- 특징
  - 현재 Application 내에서 전역적으로 사용 가능하다. 
    - 다수의 사용자에 의해서, 로직이 정상적으로 동작하지 않을 수 있다. 
  - 

---

### Session

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)