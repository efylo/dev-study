## Service

### Abstract

- Service 함수는 Http 요청 요청에 따른 서비스를 수행하여, Http 응답을 사용자에게 전송
  - super.service(req, resp): HttpServlet 클래스의 service 함수
    - HttpServletRequest req에 존재하는 메서드에 상응하는 doGet, doPost, ...를 호출
    - 서비스의 형태에 따른 비즈니스 로직이 다르기 때문에, doGet / doPost 등의 내부 구현은 정의되어있지 않다. (추상 메서드)

---

### 분기 처리

- GET / POST
  - 겹치는 로직이 존재할 경우, HttpServlet 클래스의 service 함수를 직접 Override
    - GET과 POST 요청을 동시에 처리하면서, 겹치지 않는 로직을 request.getMethod()를 통해 분기 처리가 가능
  - 공통 로직이 많지 않을 경우, doGet() 및 doPost() 함수를 Override
    - service 함수라는 하나의 단을 거치지 않고, 함수를 직접적으로 수행
    - 또한, getMethod() 메서드를 통한 검증 단계를 줄일 수 있다. 
    - 이와 비슷하게, 다른 Http의 메서드 또한 재정의하여 사용 가능