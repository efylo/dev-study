## Document

### 정의

- JavaScript는 웹 페이지에서 동적인 기능을 수행하는 역할을 가능케한다. 
- document 객체는, 현재 .js 파일이 포함된 Document Object Model 트리에 접근을 가능케한다. 
  - DOM 트리로의 인터페이스라고 봐도 무방할 것 같다. 

---

### 메서드

- getElementsById(string id)

  - 매개변수와 동일한 id를 갖는 DOM 트리의 객체를 반환

  - 객체의 속성 및 태그 정보에 관련된 값을 참조할 수 있다. 

    ```javascript
    // "hello"라는 id를 갖는 tag 객체를 반환
    var tag = document.getElementsById("hello");
    // tag 객체의 value 속성을 참조
    console.log(tag.value);
    ```

    - input tag에 입력된 값을 tag.value를 통해 참조 가능