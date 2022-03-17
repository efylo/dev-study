## Dynamic Page

### Needs

- 정적인 페이지는, 사용자가 항상 동일한 결과 값을 받기 때문에 단조로울 수 있다. 
  - 사용자의 입력에 따라 변화하는 결과 값을 Servlet을 통해 생성해줄 수 있다. 
  - Servlet을 통해 생성하는 것보다 JSP를 활용해 만들어주는 것이 바람직하다. 

---

### Process

- 서블릿(2)

  - Dynamic Page 생성 서블릿

    1. Http 요청에서 쿠키를 받아온다. (쿠키는, 동적인 데이터를 포함)
    2. 쿠키 데이터에 따른, HTML 파일을 생성한다. 
    3. 생성된 HTML 파일을 사용자에게 전송한다. (Http response)

    - 주어진 쿠키를 입력으로 받아, 동적으로 HTML 파일을 생성하고, 사용자에게 반환한다. 

  - Dynamic data 처리 서블릿

    1. 사용자의 동적인 요청을 받는다. (동적인 데이터를 포함한 요청)
    2. 동적인 요청을 처리하는 로직을 수행한다. 
    3. 로직 수행 이후 Dynamic Page 생성 서블릿으로 redirect를 진행한다. 

    - 동적인 데이터와 쿠키를 입력받아, 새로이 쿠키를 생성하여 Redirection 진행

---

### 기타

- Cookie 삭제
  - cookie.setMaxAge(0);
    - 서버에 존재하는 자원이 아닌, 웹 브라우저 혹은 로컬 디스크에 저장되어있기 때문에 Http 응답에 삭제 요청을 실어서 전송
    - 쿠키의 maxAge 속성이 0으로 설정되기 때문에, 브라우저 단에서 자동적으로 삭제가 이루어질 것으로 보인다. 
  - Cookie를 보내지 않는다면?
    - 웹 브라우저에 잔재하는 쿠키가 그대로 남아있게 되어, 사용자의 다음 번 요청에도 동일한 쿠키가 실리게 된다. 
  - Cookie에 default 값을 실어 보낸다면?
    - defualt 값을 처리하는 로직 / 쿠키가 전송되지 않았을 때 처리하는 로직을 따로 두어야 한다. 

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)