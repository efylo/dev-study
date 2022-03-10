## jQuery

### Abstract

- 2006년, John Resig이 발표한 경량 JavaScript library
- 구조(HTML), 행위(JS), 표현(CSS)에 대한 분리를 통해 복잡한 UI 코드 관리
  - HTML 문서의 탐색, 조작, 이벤트 핸들링, 애니메이션, Ajax 등

---

### 특징

- 브라우저 호환성을 지원(크로스 플랫폼)
- Native DOM API보다 직관적이고 편리한 API 제공
  - document.getElementById("id").addEventListener("click", function() {}); ...
  - $("id").on("click", function() {}); ...
- Event 처리, Ajax, Animation 및 Effect 효과의 쉬운 사용

---

### 기본 문법

- $(selector).function();

  - selector를 통해 선택된 DOM 객체를, wrapper set에 포장하여 반환
  - function()을 통해 wrapper set의 메서드를 호출한다. 

- 속성 선택자(Attribute selector)

  | 구분                            | 설명                                            |
  | ------------------------------- | ----------------------------------------------- |
  | $("selector[field~='word']")    | field 속성의 값에 word를 포함(앞뒤로 공백 필수) |
  | $("selector[field^='start']")   | field 속성의 값이 start로 시작                  |
  | $("selector[field\$='end']")    | field 속성의 값이 end로 끝                      |
  | $("selector[field*='include']") | field 속성의 값이 include를 포함                |

---

### 메서드

- addClass(): 해당 인스턴스의 class 속성에 인자 값을 추가
- append(): 해당 인스턴스의 자식 객체에 인자 값을 끝에 추가
- appendTo(): 해당 인스턴스를, 인자 값의 끝에 자식 객체로 추가
- attr(): 해당 인스턴스의 속성 값을 받아온다(get) / 설정한다(set)
- bind(): 해당 인스턴스에 이벤트 핸들러를 묶는다. 
- css(): 해당 인스턴스의 "style" 값을 받아온다(get) / 설정한다(set)
- each(): 해당 인스턴스에 대해 반복하며, 반복 시마다 인자 값으로 들어온 콜백 함수를 실행
- empty(): 해당 DOM 객체의 모든 자식 객체를 제거한다. 
- filter(): 해당 인스턴스에서, filter에 해당되는 요소들을 제외한다. 
- html(): 해당 객체의 내부 HTML 파일을 인자 값으로 설정한다. 
- remove(): 선택된 인스턴스들을 제거한다. 

---

### Reference

- [jQuery API Documentation](https://api.jquery.com/)
