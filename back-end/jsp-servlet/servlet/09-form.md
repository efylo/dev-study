## Form

### Abstract

- HTML의 Form tag를 통해 웹 브라우저 내 사용자의 입력을, HTTP 형식으로 서버에 전송

  - Form tag의 자식들 중 input tag의 name과 value 값을 묶어서 전송

    ```html
    <form action="url" method="get">
        <input type="text" name="field1" />
        <input type="text" name="field2" />
        <input type="submit" value="submit" />
    </form>
    ```

    - HTTP의 GET 방식으로, "url?field1=value1&field2=value2"를 서버에 전송
    - submit 버튼이 클릭될 경우 요청이 처리된다. 

  - input tag

    - name 속성의 값과 value 속성의 값이 바인딩되어 HTTP에 담긴다. 
    - value 속성의 값은 비어있어도 HTTP에 담기지만, name 속성의 값이 비어있을 경우 HTTP에 담기지 않는다. 

---

### 분기 처리

- 동일한 Form tag 내에서, 2개 이상의 로직을 처리하고 싶을 때

  - 2개 이상의 type="submit" input 태그를 활용

    ```html
    <form action="url" method="post">
        <input type="text" name="field1" />
        <input type="text" name="field2" />
        <input type="submit" name="operator" value="operator1" />
        <input type="submit" name="operator" value="operator2" />
    </form>
    ```

    - name은 동일해도 무방하다. 
      - 다수의 submit 버튼은 동시에 동작하지 않는다. 
    - "operator" 키에 대하여, 값이 "operator1"인 경우 처리하는 로직, ... 등으로 처리

---

### 배열 처리

- Form tag 내에서 동일한 name을 갖는 input tag를 여러 개 사용할 경우, 배열로써 처리된다. 
  - Servlet단에서 이를 .getParameterValues("key") 메서드를 통해 구현 가능하다. 
    - 반환 값은 String의 배열이다. 

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)