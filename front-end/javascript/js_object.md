## JavaScript - 객체

### 정의

- 키(Key)와 값(Value)로 구성된 프로퍼티(Property)들의 집합
- 전역 객체를 제외한 JavaScript 객체는, 프로퍼티를 동적으로 추가 및 삭제가 가능하다. 
  - Java에서는 불가능하지만, JavsScript 및 Python에서는 가능
- JavaScript의 함수는 일급 객체 - 값으로 사용할 수 있다. 
- \_\_proto__: 프로토타입

---

### 생성

- 객체 리터럴
  - {}를 활용하여 객체를 생성
- new Object()
  - 생성된 빈 객체에 프로퍼티를 추가하여 객체를 완성
- 생성자 함수
  - 동일한 프로퍼티를 갖는 객체 생성을 위해, 생성자 함수를 이용

---

### 함수

- 함수(function)

  - first-class 객체

    - 변수, 객체, 배열 등에 저장 가능
    - 콜백 함수 / 리턴 값으로 사용 가능
    - 동적 생성 가능

  - 정의 방법

    - 함수 선언문

      ```javascript
      function f(param1, param2) {
          // 함수 내용
      }
      ```

      - 함수 호이스팅: 선언의 위치에 관계 없이, 코드 내 어디서든 호출 가능

    - 함수 표현식

      ```javascript
      var f = function(param1, param2) {
          // 함수 내용
      }
      ```

      - 변수 호이스팅: 선언되기 전에 호출할 경우, undefined 값으로 초기화
      - 콜백 함수는, 표현식으로 자주 만든다. 
    
    - Function 생성자 함수
    
      ```javascript
      var obj = new Function("param1", "param2", ..., "var x = 3.14; ...");
      ```
  
- 매개변수(parameter)

  - 매개변수: 함수 정의 부분에 존재하는 외부로부터 전달받을 변수를 일컫는다. 
  - 전달인자(arguments): 함수 호출 시 전달하는 값
  - 매개변수와 전달인자의 개수가 일치하지 않아도 호출 가능

- 콜백 함수(Callback function)

  - 특정 이벤트가 발생했을 때 시스템에 의해 호출되는 함수
  - 매개변수를 통해 전달하며, 전달받은 함수는 이를 특정 시점에 처리
  - 비동기식 처리 모델에서 주로 사용
    - 처리가 종료됐을 때 콜백함수를 호출
  - setInterval(Callback, interval) / setTimeOut(Callback, timeOut) 등에 이용 가능하다. 
    - Java에서 Thread를 이용해야 하는 것과 다르다. 

---

### 접근

- 속성 값 조회
  - dot(.): obj.key 를 통해 접근
  - []: object["key"] 를 통해 접근
- 값 추가
  - obj.key = value; 
  - 동적으로 속성 - 값이 추가된다. 
- 값 제거
  - delete obj.key;
  - 동적으로 속성이 제거된다. 