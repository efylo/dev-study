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

### URL

- GET Method를 활용한 submit

  ```html
  <form action="example.com" method="get">
      <div>
          <label for="id1">ID1</label>
          <input name="id1" id="id1" value="1">
      </div>
      <div>
          <label for="id2">ID2</label>
          <input name="id2" id="id2" value="2">
      </div>
      <div>
          <button>
              submit
          </button>
      </div>
  </form>
  ```

  ```http
  GET /?id1=1&id2=2 HTTP/2.0
  Host: example.com
  ```

  - Host 서버에, "/?id1=1&id2=2"에 대한 HTTP 요청이 전송
  - 브라우저 상에 "example.com/?id1=1&id2=2" 주소가 노출

  ---

- POST Method를 활용한 submit

  ```html
  <form action="example.com" method="post" enctype="multipart/form-data">
      <div>
          <label for="field1">text type</label>
          <input name="field1" id="field1" value="value1">
      </div>
      <div>
          <label for="field2">choose a file</label>
          <input type="file" id="field2" name="field2">
      </div>
      <div>
          <button>
              send
          </button>
      </div>
  </form>
  ```

  - enctype="multipart/form-data"
    - 파일을 전송할 경우, binary 데이터를 상정하기에, enctype 속성을 변경해주어야 한다. 

  ```http
  POST / HTTP/2.0
  Host: example.com
  Content-type: multipart/form-data;boundary="boundary"
  
  --boundary
  Content-Disposition: form-data; name="field1"
  
  value1
  --boundary
  Content-Disposition: form-data; name="field2"; filename="example.txt"
  
  value2
  --boundary--
  ```

  - --boundary
    - 다음 Content의 위치를 알려준다. 
  - --boundary--
    - HTTP의 끝을 알려준다. 
  - Content-Disposition
    - value의 Disposition(특성)
  - CRLF $\times$ 2
    - value의 시작 위치를 알려준다. 

---

### HTTP

- Get 및 Post를 주로 사용한다. 
- Methods
  - GET: Retrieve, 서버의 데이터를 요청한다. 
    - Protocol의 본문(body)을 작성할 수 없다. 
  - POST: Create, 서버에 데이터를 생성한다. 
  - PUT: Update, 서버의 데이터를 변경한다. 
  - DELETE: 서버에 데이터 삭제를 요청한다. 

---

### Reference

- [MDN Web Docs - Guides/Forms/Sending form data](https://developer.mozilla.org/en-US/docs/Learn/Forms/Sending_and_retrieving_form_data)
- [MDN Web Docs - Web/HTTP/Methods/POST](https://developer.mozilla.org/ko/docs/Web/HTTP/Methods/POST)