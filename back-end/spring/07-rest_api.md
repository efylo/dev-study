## REST API

### Abstract

- Representational Stateless Transfer
  - Roy Fielding의 박사 학위 논문에서 처음으로 소개
  - 웹 서비스 설계 간 사용할 수 있는 설계 스타일, 여러 제약 조건을 만족해야 한다. 
    - REST API의 제약 조건을 만족하는 서비스를, RESTful 서비스라고 칭한다. 
- 장점
  - 적은 대역폭 / 가볍고 유연한 구조
- 단점
  - 추상적인 제약 조건
- 특징
  - HTTP만을 사용한 통신을 진행
  - 모든 플랫폼에 대해 동일한 인터페이스
    - 접근하는 플랫폼이 상이하더라도, 동일한 인터페이스를 제공한다. 
  - 자원(Resource), 행위(Verb), 표현(Representation)을 통한 서비스
    - URI는 서버의 자원을 나타낸다. 
    - HTTP 메서드는 클라이언트가 해당 자원에 대해 하고 싶은 행위를 나타낸다. 

---

### REST in Spring

- 자원(Resource; URI)
  - 정의
    - HTTP 프로토콜의 URI에 서버의 자원을 명시한다. 
  - 규칙
    - 구분자(/)를 통해 자원의 계층 관계를 표현한다. 
    - 소문자, 하이픈(-)을 사용한다. 
    - 확장자를 사용하지 않는다. 
  - 특징
    - URI의 Path에, 사용자가 요청하고자 하는 정보가 포함된다. 
    - Path에서, 사용자가 요청하는 변수를 파싱해야 한다. 
  - Spring
    - @RequestMapping("/{name}")
      - URI의 위치에 존재하는 값을, 변수로써 취급한다. 
    - @PathVariabe("name")
      - 해당하는 변수를 파싱하여, 변수에 주입한다. 
- 행위(Verb; Method)
  - 정의
    - 자원에 적용하고 싶은 행위를 명시한다. 
  - HTTP 메서드
    - GET
      - 서버의 자원을 가져오는 용도로 활용한다. 
      - Body 부분에 데이터를 담을 수 없다. 
    - POST
      - 서버에 자원을 생성하는 용도로 활용한다. 
      - Body 부분에 생성하고자 하는 자원을 포함한다. 
    - PUT / PATCH
      - 서버의 자원을 수정하는 용도로 활용한다. 
      - Body 부분에 수정하고자 하는 자원을 포함한다. 
    - DELETE: 자원을 삭제한다. 
      - 서버의 자원을 삭제하는 용도로 활용한다. 
      - Body 부분에 데이터를 담을 수 없다. 
- 표현(Representation)
  - 정의
    - 자원에 대한 표현
    - 바이트의 나열과, 이를 해석하기 위해 필요한 메타 정보들을 포함한다. 
  - 포맷
    - JSON, XML, YAML 등의 데이터 포맷들을 사용하여 자원을 표현한다. 

---

### Reference

- [What is the difference between resource and ... - Stack Overflow](https://stackoverflow.com/questions/33706191/what-is-the-difference-between-resource-and-resource-representation-in-rest)
