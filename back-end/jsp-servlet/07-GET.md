## GET & POST

### Abstract

- HTTP Get은, 사용자가 서버에 정보를 요청하는 HTTP 중 하나의 메서드이다. 
  - 특징
    - 본문(body)를 포함하지 않는다. 
    - Query string을 통해 요청에 추가적인 정보를 전달 가능
    - 특정 사이즈를 넘어가는 정보는 전송 불가능
    - 정보 노출의 염려가 존재

---

### Query String

- 개요

  - url 주소에, "?", "=", "&"와 같은 특수 문자들을 추가하여, 사용자의 요청에 정보를 담는 방식

- HTTP Get

  - "http://" + 서버의 도메인 + 원하는 서비스 + Query string
    - 도메인 주소를 통해, 회사 / 단체 / 등의 웹 서버에 접근
    - 서비스 이름을 통해, 웹 서버에서 원하는 서비스에 접근
    - Query string을 통해, 내 요청에 추가적인 정보를 입력

- Example

  - "?key1=value1&key2=value2..."

- Server단 처리

  - HttpServletRequest

    - 현재 Servlet으로 들어온 HTTP Request

  - .getParameter("key")의 값

    | 구분                    | request.getParameter("key") |
    | ----------------------- | --------------------------- |
    | ".../service?key=value" | "value"                     |
    | ".../service?key="      | ""                          |
    | ".../service?"          | null                        |
    | ".../service"           | null                        |

---

### 사용자 입력에 대한 GET, POST 요청

- HTML5의 Form 태그를 통해, 웹 브라우저로 들어오는 사용자의 입력을 서버로의 HTTP 요청에 사용할 수 있다. 

- GET

  - 간단하며 노출되어도 상관 없는 정보를 url에 바인딩하여 서버에 전송

    - url 주소의 크기에 제한이 존재하기에, 너무 큰 데이터를 전송하지 못한다. 
    - option 정도의 값을 전달해주며, 세부적인 내용을 전송하기에 적합하지 않다. 

  - 예시

    ```html
    <form action="service">
        <div>
            <label>type any number</label>
        </div>
        <div>
            <input type="text" name="key" />
            <input type="submit" value="submit" />
        </div>
    </form>
    ```

    - "service?key=input" url 주소가 서버로 전송된다. 
    - input 태그의 name 속성이, url 주소에 key로써 바인딩된다. 
    - name 속성의 value 값이, url 주소에 value로써 바인딩된다. 

- POST

  - 많은 양의 정보 혹은 노출이 꺼려지는 정보를, HTTP의 본문에 담아 서버에 전송

  - 예시

    ```html
    <form action="service" method="post">
        <div>
            <label>title:</label>
            <input type="text" name="title" />
        </div>
        <div>
            <label>content:</label>
            <textarea name="content"></textarea>
        </div>
        <div>
            <input type="submit" value="submit" />
        </div>
    </form>
    ```

    - "title=...&content=..."의 정보가 HTTP 본문에 담겨 전송된다. 

  - UTF-8 등과 같은 Multi-byte 문자 전송 문제

    - Servlet 단 해결
      - request.setCharacterEncoding("UTF-8");
      - 요청받은 HttpServletRequest를, "UTF-8"로 Decode
    - Tomcat 단 해결
      - <Connector port="8080" ... URIEncoding="UTF-8" />
      - 서버 전체의 인코딩 타입을 바꾸기 때문에, 다른 서비스에 영향을 줄 수 있다. 

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)