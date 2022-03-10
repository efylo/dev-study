## Window

### Abstract

- .js의 최상위 전역객체
- 브라우저와 관련된 여러 객체, 속성 및 함수가 존재
- 기본적으로 제공되는 프로퍼티 / 함수를 포함
  - Number, setInterval(), ...
- a.k.a BOM(Browser Object Model)

---

### 내장 객체

- alert(): 브라우저의 알림 창
- confirm(): 브라우저의 확인/취소 선택 창
- prompt(): 브라우저의 입력 창
  - modal 창을 더 자주 사용
- navigator 객체
  - 브라우저의 정보가 내장된 객체
  - navigator.userAgent
- location 객체
  - 현재 페이지 주소와 관련된 정보
  - location.href
    - value에 할당된 url로 페이지 이동
  - location.reload()
    - 현재 페이지를 새로고침
  - location.back(), location.forward()
- window.open('url', 'name', 'property', 'history')
  - window.close()
  - opener
    - 현재 창을 open()한 부모 window 객체
  - window open / close를 통해 페이지 분기 처리 가능
- setTimeOut() - clearTimeOut()
  - 콜백함수를 x ms 이후에 실행
- setInterval() - clearInterval()
  - 콜백함수를 x ms 마다 실행

---

### Document 객체

- Window의 하위 객체 중 하나