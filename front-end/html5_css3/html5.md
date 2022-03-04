## HTML5

### 정의

- HyperText Markup Language(HTML)은, 웹 페이지의 구조를 잡아주는 언어이다. 
  - Front-end의 3요소 중 하나
- 트리 구조를 차용하며, 트리의 각 노드는 tag로써 구현된다. 
  - 각 Tag들을 적합하게 사용하는 것이 중요하다. 
  - Tag마다 속성(Attributes)이 상이하다. 
    - Global attributes는 모든 Tag들에 공통적으로 존재한다. 

---

### 주석(Comments)

```html
<!-- Comments ... -->
```

- Server에서 Client로 넘어올 때, 주석 정보도 포함
  - 중요 정보에 대한 유출을 주의

---

### Fundamental tags

- html, head, meta, title, body, 등을 포함

- Fundamental = 개인적인 의견

- Code

  ```html
  <!DOCTYPE html>
  <html>
      <head>
          <meta charset="UTF-8">
          <title>A page title</title>
          <meta name="keywords" content="HTML5 tags, front-end">
          <meta name="author" content="efylo">
      </head>
      <body>
          <!-- HTML 페이지의 내용 -->
      </body>
  </html>
  ```

- Meta tag

  - HTML 페이지의 메타 데이터를 구성한다. 
  - Attributes
    - charset: 문자의 인코딩 타입을 지정
    - name & content: 페이지의 description, keywords, author, viewport 등을 지정
  - 적합한 Meta tag를 구성하는 것은, 더 나은 웹 페이지를 구축할 수 있게 해준다. 
    - 적절한 키워드 및 설명은, 검색 엔진에서 더 검색될 수 있도록 도와준다. 

---

### Form tag

- action 속성에 지정된 서버의 url로, input tag에 입력된 데이터를 전송

  - method에 지정된 방식으로 전송한다. 
    - get 메서드
    - post 메서드

- Code

  ```html
  <!-- action: form의 입력 데이터가 전송될 서버의 url을 지정 -->
  <form action="url" method="get">
      <label for="first-text">Type any text:</label>
      <input type="text" id="first-text" name="first-text">
      <input type="submit" value="제출">
  </form>
  ```

---

### Input tag

- 동적 입력 데이터를 위한 tag, 다양한 type이 존재
  - type: "text", "checkbox", "radio", "file", "password"
    - label tag와 병행하여 사용
    - (label tag의 for attribute) = (input tag의 id attribute)
- checkbox / radio
  - name 속성의 값을 동일하게 하여, 여러 입력을 처리할 수 있도록 처리한다. 

- dropdown-list
  - select > option * n
    - select tag 밑에, 가능한 다수의 option을 구성
    - 구성된 option들 중 택 1
  - input & datalist > option
    - (input tag의 list attribute) = (datalist tag의 id attribute)
    - pre-defined된 option tag의 value attribute을 사용자가 활용 가능
    - 꼭 pre-defined된 값을 활용할 필요 X
- file transfer
  - 파일 전송 시에는, form tag의 규격을 맞춰주어야 한다. 
  - form type="post" enctype="multipart/form-data"
    - input type="file"

- button
  - input type="button"
    - 아무런 기능도 제공하지 않는다. 
    - 기능을 추가하고 싶을 경우, js에 이벤트를 바인딩

  - input type="submit"
    - 데이터를 제출한다. 
    - 내용: form tag에 작성된 데이터
    - 서버: action attribute의 url
    - 방식: method attribute의 get/post

  - input type="reset"
    - 데이터를 초기 상태로 되돌린다. 

  - input type="image"
    - \<img> + \<submit>
    - 클릭 시 form tag의 데이터가 제출되므로, 주의

  - button
    - form tag에 연동하여 사용 가능하다. 
    - button에 연결된 form의 속성을 지정할 수 있다. 


---

### Semantic tag

- 정의
  - 유의미한 tag, 목적성이 뚜렷한 contents를 일컫는다. 
    - form, table, img 등의 tag는 contents의 목적성이 뚜렷하다. 
  - 이와 반대로, div, span 등의 tag는 개발자가 정의하기 나름이다. 
  - 브라우저 / 검색 엔진 / 개발자에게 의미를 전달한다. 
    - 메타 데이터로써의 역할을 한다. 

---

### Attributes

- Global attributes
  - 모든 Tag에 공통적으로 존재하는 속성
- class attribute
  - tag에 클래스명을 부여
  - .css 파일을 적용할 클래스 지정 가능
  - 디자인의 요소를 지정하는 것에 자주 사용
- id attribute
  - tag의 유일한 id를 부여
  - 해당 tag를 식별 가능
  - input tag의 속성으로 사용되었을 때
    - JavaScript에서 해당 id의 값을 참조 가능하다. 

---

### 기타

- VS Code(IDE)
  - HTML5 문서 편집을 위한 용이한 Extension들이 존재
  - Extensions(8)
    - Emmet Live: 다수의 Tag들을 한 줄의 코드로 편리하게 구성
    - Live Server: 해당 코드를 localhost의 5500포트에 올림
    - Prettier / indent-rainbow / Bracket Pair Colorizer: HTML 문서의 가독성을 향상
    - Auto Rename Tag / CSS Peek / HTML CSS Support: Intellisense
  - 단축키
    - Alt+Shift+위아래 방향키
      - 현재 코드라인 위아래로 복사
    - Ctrl+Alt+위아래 방향키
      - 다중 커서 지원
- 특수문자
  - \&amp;
    - 서버에서 url에 &기호를 묶어 전송할 때 사용해야 하는 경우 존재
- table vs. div
  - table
    - table tag 내 전체 내용이 load돼야 화면에 나타난다. 
    - tag 내부 내용이 많을 경우, 화면의 많은 부분이 나타나지 않는다. 
    - data의 전부를 보여줘야 하는 경우 사용한다. 
  - 다중 div
    - 각 div는 각 tag가 load된 이후 화면에 나타난다. 
    - 많은 내용을 분할하여 load할 수 있으며, 디자인을 적용하기에 용이하다. 