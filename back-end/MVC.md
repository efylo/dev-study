## MVC

### Web Service Data Flow

1. Client: HTTP Request
   - 클라이언트는, 서버에게 HTTP 요청을 보낸다. 
     - HTTP 요청에는, 도메인 주소 / 포트 번호 / path / parameter 등이 포함된다. 
2. Server: HTTP Receive
   - TCP/IP 계층을 거쳐, 서버는 클라이언트의 요청을 송신한다. 
     - 유효한 protocol, domain address, port number를 가정한다. 
3. WAS: Mapping
   - WAS는, 클라이언트의 요청에 포함된 path에 해당하는 서버 프로그램을 실행한다. 
     - static한 경우, path에 해당하는 서버의 자원을 반환한다. 
4. Logic: f~path~(parameter...)
   - 서버 프로그램은, 클라이언트의 요청에 포함된 parameter를 기반으로 로직을 수행한다. 
     - 로직 수행의 결과를 출력하여, 사용자에게 응답한다. 
   - 프로세스
     1. HTTP request parsing
        - 요청에 포함된 parameter들을 파싱한다. 
        - 파싱한 parameter의 값은, 사용자의 상태 정보를 포함할 수 있다. 
     2. Processing logics
        - parameter의 값에 대하여, 특정 로직을 수행한다. 
          - 비즈니스 로직, DB 로직을 포함할 수 있다. 
     3. Formatting outputs
        - Logic을 거쳐 나온 값을, 포맷에 맞춰 출력한다. 
        - 출력한 값을 사용자에게 전달한다. 

---

### Separation

- WAS의 프로세스를 기능별로 분리한다. 
  - Contoller
    - HTTP request의 parameter에 따른 로직을 수행한다. 
      - 로직 수행의 결과를, 인스턴스로 생성하여, View 단에 전달한다. 
  - Model
    - 로직 수행의 결과로 가능한 값들의 집합
      - 이는 개념적으로 묶여 하나의 클래스를 정의할 수 있다. 
    - ex) Java Beans, Dto, Vo
  - View
    - HTTP response를 구성한다. 
      - Controller로부터 Model에 해당하는 인스턴스를 전달받는다. 

---

### Expansion

- 서비스가 확장됨에 따라, Controller에서 수행하는 기능이 복잡해진다. 
- Controller
  - 정의
    - HTTP request의 parameter를 입력받는다. 
    - parameter
      - arguments: 해당 동작에 필요한 인자 값
      - action: 서버의 동작(Optional)
  - 동작
    - arguments parsing
      - Request로부터 입력받은 parameter들로부터, 의미를 해석한다. 
      - 해석한 의미에 따라서, 필요한 로직을 수행 / 함수를 호출 / 등의 동작을 수행한다. 
    - HTTP response
      - forward
        - request에 결부된 attribute가 존재하는 경우
        - forward하지 않을 경우, 해당 attribute 사용 불가
      - redirect
        - request에 결부된 attribute가 존재하지 않는 경우
- Service
  - 정의
    - 해당 서비스의 로직(동작)을 수행한다. 
  - 동작
    - 비즈니스 로직을 수행한다. 
      - 입력 값에 대한 유효성 검사 등을 진행
    - DB에 접근해야 한다면, Dao 함수를 호출
      - Dao가 필요로 하는 입력 값을 전달
        - Dto를 활용할 수 있다. 
    - Dao 함수의 결과 값을, Controller 단에 전달
- Dao
  - 정의
    - SQL문을 수행한다. 
  - 동작
    - DB에 연결한다. 
      - Connection conn = DriverManager.getConnection();
    - SQL문 내에 변수를 완성한다. 
      - PreparedStatement pstmt = conn.preparedStatement(sql);
      - .setString(), ...
    - SQL문을 실행한다. 
      - .executeQuery(), .executeUpdate(), ...
    - 실행 결과 값을 전달한다. 

---

### MVC Design Pattern

- 위 과정을 거쳐, MVC 디자인 패턴에 대한 이해를 조금이나마 덧붙일 수 있었다. 
- Model
  - 웹 서비스 프로세스 전반에 걸쳐 사용되는, 데이터와 관련된 클래스들의 집합
  - Java Beans, Dto, Vo
    - 데이터의 표현과 관련된 클래스
  - Dao
    - 데이터베이스와의 통신을 맡아서 진행한다. 
- Controller
  - HTTP request를 수용하고, 그에 따른 분기 처리를 진행한다. 
  - 분기 처리의 결과를, 적절히 처리하여, forward / redirect / request.getWriter().append(state) 등의 동작을 수행한다. 
  - Service, Dao에서 던져진 예외를 처리한다. 
    - Service / Dao에서 직접 처리가 가능하거나, 하는 것이 시의적절한 경우 제외
    - 예외 발생 시, error 페이지를 보여주는 것이 적절하다면, redirect


- View
  - Controller에서 forward한 HTTP request를 적절히 처리한다. 
  - JSP
    - Forward된 데이터를, 자바의 객체로써 전달받을 수 있다. 
    - JSTL(Jsp Standard Tag Library)을 활용해, Tag를 통한 제어를 구현한다. 
      - <%@ taglib prefix="c" uri="..." %>
    - Directive 중 import file 구문을 활용해, 중복된 코드를 재사용한다. (header, footer, ...)

---

### Authorized Service

- 인증이 필요한 서비스의 경우, 어떻게 구현하는 것이 좋을까?
  - 전제 조건
    - 사용자 인증 구현 방식
      - request.getSession().setAttribute("userInfo", userInfo);
  - 구현
    - Front controller에서 사용자 정보를 추출하여, 필요한 서비스 함수의 인자 값으로 전달한다. 
      - 인증이 필요하지 않은 서비스에도 자원이 사용될 여지가 존재한다. 
    - Controller에서 getUserInfo() 메서드를 구현하여, 필요한 서비스 함수 내에 사용한다. 
      - null 처리를 내부적으로 진행한다. 

---

### Forward, Redirect

- 권장 사항
  - forward
    - 현재 상태에서, 다음 상태로 넘어가는 과정에서 Data를 갖고 넘어가는 경우
    - request 객체에 데이터를 저장할 경우, forward를 해야만 데이터 참조 가능
      - request.setAttribute("data", data);
    - session, application 객체의 경우 forward와 상관 없이 데이터 참조 가능
  - redirect
    - 데이터베이스 내 수정이 일어난 경우(insert, delete, update)
      - 사용자의 이전 request의 데이터를 초기화
      - 초기화하지 않을 경우, 새로고침 시마다 쿼리가 지속적으로 발생 가능
