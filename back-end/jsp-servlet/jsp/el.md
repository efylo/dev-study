## Expression Language

### Abstract

- Servlet에서 동적으로 처리한 데이터(Model)들은, JSP 단에서 사용하게 된다. 
  - 데이터들은, JSP 단에서 자바 문법을 이용하지 않고, EL을 활용하여 값을 가져온다. 

---

### Syntax

- ${var}
  - var이라고 하는 변수의 값을 가져온다. 
- ${list[0]}
  - 선형 자료 구조(Iterator, 배열) 내에서 인덱스에 해당하는 값을 가져온다. 
- ${map.key}
  - 비선형 자료구조(Map, 등) 내에서 key에 해당하는 value를 가져온다. 
- JSP의 저장 객체 참조
  - page: pageContext 객체
  - request: HttpServletRequest 객체
  - session
  - application
  - param: request 내 인자 값
  - header: Http 요청의 헤더 객체

---

### Operators

- 여타 프로그래밍 언어와 마찬가지로, 연산자를 지원한다. 
- 특이사항
  - 비교 연산자 (>, >=, <, <=, ==, !=)는 영문자로 표현 가능하다. 
    - gt, ge, lt, le, eq, ne
  - empty 연산자
    - null 혹은 "" 빈 문자열일 경우 참을 반환하며, 전치 연산자로 변수의 앞에 위치한다. 