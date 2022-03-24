## Redirection

### Abstract

1. 사용자의 Http Request를 받아, 로직을 수행
2. 로직 수행 이후에 사용자에게 보여주고 싶은 페이지가 존재한다면 Redirection을 사용
   - Http Response 객체에, redirect 요청을 포함하여 전송
   - response.sendRedirect(url);

---

### Forwarding

1. 사용자의 Http Request를 받아, 로직을 수행
2. 로직 수행 이후에 처리된 결과를, 다른 페이지와 공유한다. 
   - 새로운 요청이 아닌, 처리한 데이터를 전송할 때 사용
3. RequestDispatcher 클래스를 활용
   - request.setAttribute("result", result);
   - request.getRequestDispatcher("./xxx.jsp");
   - 요청에 key-value를 담아서, .jsp 파일로 전송

---

### Reference

- [Youtube - 2020 Servlet&JSP 프로그래밍 by. 뉴렉처](https://www.youtube.com/channel/UC5-ixpj8DioZqmrasj6Ihpw)