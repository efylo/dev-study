## 이벤트

### 개요

- 웹 페이지 상에서 다양한 종류의 상호작용이 있을 때마다, 이벤트가 발생

  - 예시: 마우스 클릭, 키보드 입력

- Event Handler / Listener

  - DOM에서 발생하는 이벤트를 감지
  - 연결된 JavaScript의 함수를 호출

- 종류

  | 구분 | 설명                          |
  | ---- | ----------------------------- |
  | 1    | 웹 페이지 로딩 완료 시        |
  | 2    | 페이지 스크롤 시              |
  | 3    | 브라우저 창 크기 조절 시      |
  | 4    | 마우스 클릭 시                |
  | 5    | 키보드로 키 입력 시           |
  | 6    | form을 submit 시              |
  | 7    | input 내용 변경 시            |
  | 8    | 마우스를 통해 Element 이동 시 |

- 마우스 이벤트

  | 구분        | 설명                                           |
  | ----------- | ---------------------------------------------- |
  | onclick     | 마우스로 Element 클릭 시                       |
  | ondbclick   | 마우스로 Element 더블 클릭 시                  |
  | onmouseup   | 마우스로 Element에서 마우스 버튼이 올라갔을 때 |
  | onmousedown | 마우스로 Element에서 마우스 버튼이 내려갔을 때 |
  | onmouseover | 마우스가 Element 밖에서 안으로 들어올 때       |
  | onmouseout  | 마우스가 Element 안에서 밖으로 나갈 때         |
  | onmousemove | 마우스를 움직일 시                             |

- 키보드 이벤트

  | 구분       | 설명                            |
  | ---------- | ------------------------------- |
  | onkeypress | 키보드가 눌러졌을 때(ASCII)     |
  | onkeydown  | 키보드를 누르는 순간(KeyCode)   |
  | onkeyup    | 키보드의 누르고 있던 키를 뗄 때 |

- Frame(UI) 이벤트

  | 구분     | 설명                                             |
  | -------- | ------------------------------------------------ |
  | onload   | document, image, frame 등 전체가 로딩 완료 시    |
  | onabort  | image 등의 내용 로딩 도중 취소되어 중단되었을 시 |
  | onerror  | image 등의 내용 로딩 중 오류 발생 시             |
  | onresize | document, element의 크기 변경 시                 |
  | onscroll | document, element 스크롤 시                      |
  | onselect | 텍스트 선택 시                                   |
  
- Form 이벤트

  | 구분              | 설명                                              |
  | ----------------- | ------------------------------------------------- |
  | onsubmit          | form 제출 시                                      |
  | onreset           | 입력 form reset 시                                |
  | oninput           | input / textarea 값 변경 시                       |
  | onchange          | select box, checkbox, radio button의 상태 변경 시 |
  | onfocus (focusin) | input 요소에 focus가 들어올 때                    |
  | onblur (focusout) | input 요소에서 focus가 나갈 때                    |
  | onselect          | input / textarea의 입력 값 중 일부 선택되었을 시  |

---

### 방법론

- In-line 이벤트 핸들러
  - HTML 태그의 이벤트 속성(onclick, onsubmit, ..)에 JavaScript 코드를 직접 연결
  - CBD(Component Based Development)로 나아가며, Angular / React / Vue.js 등 프론트엔드 프레임워크 등에서 차용
- 이벤트 핸들러 Property
  - JavaScript에서 HTML의 요소를 가져와, 해당 요소의 속성에 이벤트 핸들러를 등록
  - 오직 하나의 이벤트 핸들러만 등록 가능
- addEventListener 메서드
  - addEventListener(arg1, arg2[, arg3])
    - arg1: 이벤트 이름
    - arg2: 이벤트 핸들러
    - arg3: 캡쳐링 여부
    - IE 9 미만 버전에서는 사용 불가능