## Loops

### Abstract

- Expression Language, Expression Tag를 활용하여 JSP 페이지에서 request의 attribute에 접근 가능하다. 
  - List, Array 등의 자료 구조를 활용하여 넘어온 데이터의 경우 바로 사용할 수 없다. 

---

### Implementation

- Scriptlet을 활용하여 for 루프를 구현하고자 할 때

  ```jsp
  <%@ page import = "package.Item" %>
  ...
  <%
  List<Item> list = (List<Item>) request.getAttribute("list");
  for (Item item: list) {
      pageContext.setAttribute("item", item);
  %>
  <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.value}</td>
  </tr>
  <%
  }
  %>
  ```

  - Errors
    - EL은 지역 변수에 접근이 불가능하다. 
    - Jasper 엔진이 이를 해석할 때, 접근 가능한 전역 객체들 중에서 해당 이름의 속성을 갖는 객체에 접근한다. 
      - ${item.id}에 대한 해석을, item.getId()로 해석하는 것이 아닌, pageContext, request, session, application 각각에 "item"의 이름을 갖는 객체를 찾는다. 

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)