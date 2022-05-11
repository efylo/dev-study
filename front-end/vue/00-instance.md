## Vue.js

### Abstract

- Progressive JavaScript Framework
  - 싱글 페이지 어플리케이션(SPA), 반응형 웹 API 등을 지원

---

### 설치

- **CDN 방식; Content Delivery Network**

  ```html
  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <!-- CDN을 통해 Vue.js 라이브러리를 가져온다. -->
      <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
  </head>
  <body>
      
  </body>
  </html>
  ```

  - HTML 페이지의 head에, script 선언을 통하여 Vue.js 라이브러리를 가져와 사용한다. 
  - 버전에 따라 url이 바뀔 수 있으므로, 공식 문서를 참조하는 것을 추천한다. 

- **npm**

- **cli**

---

### Vue 인스턴스

- **개요**

  - Vue.js 프레임워크의 기반이 되는 인스턴스
  - DOM 트리와 JavaScript의 객체 간 데이터를 주고받을 수 있는 방법을 제공한다. 
    - MVVM 패턴의 ViewModel을 참조한 내용이라고 한다. 

- **선언**

  ```javascript
  new Vue({
      // DOM 요소의 id를 선언할 수 있다. 
      el: "#app",
      // Vue 인스턴스가 관리해야 하는 데이터를 선언할 수 있다. 
      data() {
          return {};
      },
      // Vue 인스턴스의 동작을 자바스크립트의 함수로써 선언할 수 있다. 
      methods: {
          f1() {
              // ...
          }, 
          f2 : function() {
              // ...
          }, 
      }, 
      // Life cycle hooks - created, mounted, updated, destroyed, ...
  });
  ```

---

### Vue 인스턴스의 속성

- **el**
  - DOM 요소의 id를 선언할 수 있다. 예) el: "#app"
  - Vue 인스턴스와, DOM 요소를 결부한다. 
- **data**
  - Vue 인스턴스가 관리해야 하는 변수를 선언한다. 
  - 동적인 데이터, 상태 관리를 위해 필요한 데이터 등을 고려해볼 수 있다. 
- **methods**
  - Vue 인스턴스의 동작을 선언한다. 
- **computed**
  - 동일한 인자에 대한 연산의 중복 호출을 줄인다. 
- **라이프 사이클 훅** (Life-cycle hooks)
  - create(생성), mount(연결), update(갱신), destroy(소멸)
    - 해당 라이프 사이클 전후에 메서드를 결부할 수 있다. 
    - 결부된 메서드는 약속된 분기에 실행된다.
- **components**
  - Vue 인스턴스의 구성 요소
    - 재사용이 용이한 템플릿, 이와 연동된 데이터 등을 하나의 집합으로 관리
    - [컴포넌트의 이름 - HTML 태그의 이름]이 하나의 쌍을 이룬다. 
      - 예) 'VueComponent' - \<vue-component>

- **router**
  - Vue 인스턴스와 결부된 DOM 요소의 자식 요소에, 특정 컴포넌트를 렌더링한다. 
    - \<router-view> 태그에 해당하는 컴포넌트가 렌더링된다. 
  - [경로 - 컴포넌트]가 하나의 쌍을 이룬다. 
    - 예) \<router-link to="/path">\</router-link> - \<router-view>
  - 원하는 컴포넌트를 화면에 띄우고자 한다면, 해당하는 경로로의 접근을 해야 한다. 

---

### Reference

- [시작하기 - Vue.js](https://kr.vuejs.org/v2/guide/index.html)