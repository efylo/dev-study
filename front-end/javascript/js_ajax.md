## AJAX

### Abstract

- **Asynchronous Javascript And XML**
  - JavaScript와 XML을 활용해 구현하는 하나의 방식을 의미한다. 
  - 화면(window) 내에 객체를 생성 / 수정하여 사용자에게 변화된 화면을 제공한다. 
    - 새로운 화면이 생성되지 않는다. 
  - 동적으로 DOM을 구성해야 하는 복잡성이 존재한다. 

---

### Process

1. XMLHttpRequest 객체 생성
   - 웹 브라우저에서 생성하여, 서버로 전송할 데이터를 담을 XMLHttpRequest 객체를 생성한다. 
   - Http를 활용한 요청에 필요한 정보 / 함수들이 객체에 담겨있다. 
2. open(method, url, ...)을 통한 초기화
   - XHR 객체가, http 요청에 적합한 정보를 가지도록 초기화해주는 메서드. 
   - 필수 인자(necessary args)
     - method: 요청을 전송할 방식을 지정, ["GET", "POST", "PUT", "DELETE", etc]
     - url: 요청을 전송할 서버의 주소
   - 선택적 인자(optional args)
     - async: default true; 참일 경우, 비동기 처리 방식을 지원.
       - 해당 요청이 success / error일 경우에 main thread에 존재하는 event listener에게 notify. 
       - MIME 타입이 multipart일 경우, 비동기 처리 방식만을 지원한다. 
     - user, password: default null; 사용자 인증이 필요한 경우 사용한다. 
3. setRequestHeader('key', 'value')
   - Http 요청의 헤더 부분에, 'key' 값을 'value'로 설정
   - 'Content-Type' 등을 설정해줄 수 있다. 
4. onreadystatechange
   - Http 요청의 readystate이 변할 경우 실행할 콜백 함수를 지정 가능
     - Http 요청의 완료: xhr.readystate == xhr.DONE
     - 서버의 상태 정상: xhr.status == 200
       - 서버로부터 전송받은 데이터가 정상적일 경우 웹 페이지의 데이터를 일부 수정하는 동적인 기능을 추가 가능
5. send(body)
   - Http 요청을 서버로 전송한다. 
   - 선택적 인자(optional args)
     - body: XHR 객체의 본문(body)에 담을 정보를 지정한다. 

---

### XHR

- readyState

  - 생성한 xhr 인스턴스의 상태를 0~4의 숫자로 표현

    - 상태

      | Value | State            | 설명                                                         |
      | ----- | ---------------- | ------------------------------------------------------------ |
      | 0     | UNSENT           | open()이 호출되기 전의 상태                                  |
      | 1     | OPENED           | open()이 호출된 이후의 상태                                  |
      | 2     | HEADERS_RECEIVED | send()가 호출됐으며, response의 헤더 및 상태 정보를 받은 상태 |
      | 3     | LOADING          | response의 body를 다운로드 중인 상태                         |
      | 4     | DONE             | 해당 xhr 인스턴스의 요청 완료                                |

- status

  - 서버의 Http 응답에 포함된 상태 정보에 대한 코드
    - 대표적으로 "200 OK", "404 Not Found" 등이 존재한다. 

---

### Reference

- [XMLHttpRequest - Web API | MDN](https://developer.mozilla.org/ko/docs/Web/API/XMLHttpRequest)