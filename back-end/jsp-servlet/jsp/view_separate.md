## WEB-INF

### Abstract

- Eclipse에서 Dynamic Web Project를 생성하게 될 경우 마주치는 폴더
  - WebContent 내부에 위치
- 프로토콜, IP주소, 포트 번호가 올바르다 하여도, WAS가 반환해주지 않는 정보들이 저장돼있는 폴더. 
  - WAS 내부의 프로그램 내에서 포워딩하는 것은 가능하다. 

---

### lib

- 기본적으로 아무 파일도 들어있지 않다. 
- Java로 된 Web Application을 구동하고자 할 때 필요한 라이브러리들을 위치시킬 수 있다. 
  - Java Resources - Libraries/Web App Libraries 안에서 인식된 라이브러리들을 확인할 수 있다. 
  - 각 DBMC 제조사별 JDBC 드라이버, JSTL 라이브러리 등을 포함시킬 수 있다. 

---

### Private

- 사용자에게 제공하는 정보이지만, 웹 브라우저의 주소를 통해 직접 접근하는 것을 차단할 수 있다. 
  - protocol://domain:port/project/WEB-INF 주소는 직접 접근이 불가능하다. 