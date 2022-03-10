## Callback Function

### Abstract

- JS에서는 호출하는 함수의 인자로써, 함수를 사용할 수 있다. 
  - 이 때, 인자로써 사용된 함수를 Callback 함수라고 일컫는다. 
  - 호출된 함수는 로직 내에서 Callback 함수를 원하는 시점에 처리한다. 

---

### Cautions

- Callback 함수에서의 return은, Callback 함수를 반환한다. 
  - Callback 함수를 함수 호출 시 인자 단에서 정의할 때, 가시적이지 않다. 

---

### Examples

- Ajax

  ```javascript
  // Http 요청을 담을 수 있는, XHR 객체 생성
  var xhr = new XMLHttpRequest();
  var url = "www.foo.com/service"
  var method = "GET"
  
  // xhr 인스턴스가 http 요청으로써 기본적으로 필요한 정보 설정
  xhr.open(method, url);
  // http 요청의 헤더에 key-value 값 설정
  xhr.setRequestHeader("Content-Type", "text/plain");
  // xhr 인스턴스의 readystate 값이 변할 경우 실행할 콜백 함수
  xhr.onreadystatechange = function() {
      console.log(xhr.readyState);
  }
  
  // xhr 인스턴스에 지정된 method 방식으로, url 주소를 갖는 서버에 요청 전송
  xhr.send(null);
  ```
  
  