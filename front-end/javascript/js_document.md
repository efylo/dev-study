## Document

### 정의

- JavaScript는 웹 페이지에서 동적인 기능을 수행하는 역할을 가능케한다. 
- document 객체는, 현재 .js 파일이 포함된 Document Object Model 트리에 접근을 가능케한다. 
  - DOM 트리로의 인터페이스라고 봐도 무방할 것 같다. 

---

### DOM

- Document Object Model은, HTML 및 XML 문서의 구조를 정의하는 API
- 문서 요소들의 집합을, 트리 형태의 계층 구조로 표현
  - document
    - HTML 계층 구조의 최상위 노드
    - document.xxx을 통해 하위 태그를 가져올 수 있다. 

---

### 메서드

- 객체 생성

  - createElement(tagName)

    - tagName에 해당하는 태그를 생성

  - createTextNode(text)
  
    - text node를 생성
  
  - appendChild(node)
  
    - 객체에 node를 child로 추가
  
  - removeChild(node)
  
    - 객체의 node를 제거한다. 
  
  - **객체의 속성 설정**
  
    > - setAttribute(name, value)
    >   - 해당 객체의 name 속성에 value 값을 지정
    >   - 사용 예시
    >     - .setAttribute("style", "...; ...") 지양
    >     - .setAttribute("class", "class01") 지향
    > - getAttribute(name)
    >   - 해당 객체에 name 값을 가져온다. 
    > - 문제점
    >   - 웹 표준 / 브라우저가 지원하는 태그의 속성만 사용 가능
    > - 객체의 속성
    >   - innerHTML: HTML로 지정
    >   - innerText: Text로 지정
  
  ---
  
- 객체 가져오기

  - getElementById(string id)

    - 매개변수와 동일한 id를 갖는 DOM 트리의 객체를 반환

    - 객체의 속성 및 태그 정보에 관련된 값을 참조할 수 있다. 

      ```javascript
      // "hello"라는 id를 갖는 tag 객체를 반환
      var tag = document.getElementsById("hello");
      // tag 객체의 value 속성을 참조
      console.log(tag.value);
      ```

      - input tag에 입력된 값을 tag.value를 통해 참조 가능

  - getElementsByTagName(string tagName) 

    - tagName과 동일한 태그를 갖는 DOM 트리의 객체들을 배열로 반환
    - 배열의 각 요소를 통해, 접근 가능하다. 

  - getElementsByName(string name)

  - getElementsByClassName(string className)

  - querySelector(string selector)

  - querySelectorAll(string selector)

    - selector를 인자로 받기에, 클래스라면 ".className", 아이디라면 "#id", 등으로 접근해야 한다. 

    - name을 기준으로 query하는 방법

      ```javascript
      // input 태그 중 name 속성이 test인 요소 반환
      document.querySelector("input[name='test']");
      // input 태그 중 name 속성명이 test로 시작하는 요소 반환
      document.querySelector("input[name^='test']");
      // input 태그 중 name 속성명이 test로 끝나는 요소 반환
      document.querySelector("input[name$='test']");
      // input 태그 중 name 속성명이 test를 포함하는 요소 반환
      document.querySelector("input[name~='test']");
      ```