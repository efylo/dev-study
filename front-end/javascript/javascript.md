## JavaScript

### 정의

- 인터프리터 기반의 Script 언어
  - 컴파일러에 의해 기계어로 번역되지 않는다. 
  - .js 파일 호출 시, 인터프리터가 한 줄씩 읽으며 실행된다. 
- 웹 브라우저에서 동작하는 유일한 General-purpose 프로그래밍 언어
  - 웹 브라우저의 엔진은, 인터프리터와 컴파일러 결합
    - 인터프리터의 실행 속도 향상
  - 크롬의 V8 엔진은, ES6 표준을 잘 구현한 브라우저

---

### 선언

- 외부, 내부, 인라인 선언 가능
- HTML 파일의 script tag에서 .js 파일을 선언하여 사용
  - .js 파일은 body tag의 최하단부에 위치
    - HTML은 절차적으로 읽힌다. 
    - 렌더링되지 않은 요소에 접근할 수 없기에, 보통 최하단부에 위치시킨다. 

---

### 문법

- 주석: //, /* ... */
- 변수 선언: var
  - 변수명: camelCase / underscore(_), dollarSign($) 허용
- 함수 선언: function f() {}
- 객체 생성: new
- window
  - 웹 페이지 자신을 참조하는 객체, 자바에서 this와 동일한 역할
  - window.onload
    - 브라우저 창이 load된 다음에 실행
- document
  - DOM 트리로의 진입점 역할을 수행
  - document.getElementById("id");
    - DOM 트리로의 "id" 객체를 반환
- 내장 클래스
  - Date(): 날짜 클래스 생성자
- foreach
  - for (var v of array) / for (var v in object)

---

### 자료형

- .js 프로그램에서 다루는 데이터 값의 종류

  | 구분      | 설명                                      |
  | --------- | ----------------------------------------- |
  | number    | 숫자형; 정수 또는 실수형                  |
  | string    | 문자열; single / double quotes 모두 허용  |
  | boolean   | boolean형; 참(true) / 거짓(false) 논리 값 |
  | undefined | 초기화하지 않은 변수 - 시스템 레벨        |
  | null      | 값이 존재하지 않는 경우 - 프로그램 레벨   |

- String

  - Unicode - 16비트

  - char 데이터 타입을 제공하지 않는다. 

  - Single, double quotes, **backtick**(`) 모두 허용

    - backtick(`): ES6 템플릿 리터럴

      ```javascript
      var name = "홍길동";
      var age = 10;
      var s = `name is ${name}, age is ${age}`;
      ```

- boolean

  - {비어있는 문자열, null, undefined, 숫자 0} = false
  - 빈 객체 {}는 false가 아니다. 

- Dynamic typing

  - 자료형에 대해, 느슨한 규칙이 적용

- Variable Hoisting(변수 호이스팅)

  - 변수가 선언되기 이전에 사용할 경우, 이후에 선언된 변수를 참조하여 undefined 값으로 선언해준다. 

- let

  - 변수 / 현재 스코프 / 재선언 불가능

- const

  - 상수 / 현재 스코프 / 재선언 및 재할당 불가능

---

### 특징

- Underflow / Overflow / 0 division에 대해 예외를 발생시키지 않는다. 

  - Infinity: 무한
  - NaN: Not a Number, 숫자가 아님을 일러준다. 

- delete

  - 객체의 속성을 제거

- typeof

  - 피연산자의 타입을 반환

- in

  - 프로퍼티 존재 여부 확인

- 연산자

  - ==: 값이 일치하는지 확인(타입 미포함)
  - ===: 값이 일치하는지 확인(타입 포함)
  - /: 나눗셈 연산은, 실수형을 반환

- 호이스팅(Hoisting)

  - 선언되지 않은 변수 및 함수를 사용할 경우, 이후에 선언된 변수 및 함수를 선언해준다. 

    ```javascript
    console.log(x); // undefined 출력
    var x = 10;
    ```

    - 이후에 선언되지 않은 변수 및 함수일 경우, 에러 발생

---

### 연산자 규칙

- Code

  ```javascript
  var s = "1234.56";
  var x = 10;
  console.log(s - x); // 1224.56
  console.log(s + x); // 1234.5610
  var sInt = parseInt(s);
  var sFloat = parseFloat(s);
  
  console.log(x / 0); // Infinity
  ```

  - 문자열과 숫자의 뺄셈
    - 문자열을 숫자형으로 변환
  - 문자열과 숫자의 덧셈
    - 숫자형을 문자열로 변환
  - 정수형과 실수형의 구분 X

---

### 방법론

- 이벤트 핸들러 등록
  - In-line
    - JavaScript에서 지향
    - jQuery에서 지양
    - Angular / React / Vue.js에서 사용(Component Based Development; CBD)


---

### 참조

- [MDN Web Docs](https://developer.mozilla.org/ko/)