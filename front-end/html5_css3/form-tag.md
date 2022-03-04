## HTML Form Tag

### Abstract

- HTML의 Form tag는, HTML 페이지 내에서 사용자의 입력을 받아서 처리하는 기능을 제공해준다. 
- action attribute = 입력 데이터를 전송할 서버의 url
- method attribute = 입력 데이터를 전송할 HTTP의 방식을 지정

---

### Methods(HTTP in HTML5)

- Get
  - 서버에 url로 원하는 정보를 요청한다. 
  - HTTP의 본문(body)에 내용을 첨부할 수 없다. 
    - url에 원하는 데이터를 바인딩하여 요청한다. 
    - "watch?v=1234" 등과 같은 url 주소
    - 길이가 제한된다. (브라우저별로 상이하다. )
- Post
  - 서버의 url + HTTP의 본문의 내용을 포함한 정보를 서버에 요청한다. 
  - HTTP의 본문의 내용은, url에 보여지지 않는다. 
    - 중요한 정보를 암호화할 수 있다. 
    - 노출에 대한 염려 X
    - 길이에 제한이 없다. (용량이 큰 데이터)

---

### HTTP

- HTTP의 메서드 중, HTML에서는 Get과 Post만 가능하다. 
  - Put, Delete 등의 메서드는 지원하지 않는다. 
- GET: Retrieve, 서버의 데이터를 요청한다. 
  - HTTP 프로토콜의 본문(body)을 작성할 수 없다. 
- POST: Create, 서버에 데이터를 생성한다. 
- PUT: Update, 서버의 데이터를 변경한다. 
- DELETE: 서버에 데이터 삭제를 요청한다. 