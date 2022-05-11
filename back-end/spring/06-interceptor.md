## Interceptor

### Abstract

- Controller에 전달되기 이전에 요청을 가로채서, 특정한 기능을 수행할 수 있다. 
  - 특정 URL이 호출되기 이전 / 이후 / 완료된 이후에 동일한 기능을 항상 수행할 경우 고려
    - 사용자 인증, 관리자 계정 인증, 등


---

### Interceptors

- 인터페이스
  - web.servlet.HandlerInterceptor
    - preHandle
      - Controller 요청을 처리하기 전에 수행되는 메서드
      - false를 반환하게 될 경우 해당 요청을 처리하지 않는다. 
    - postHandle
      - Controller 요청을 처리한 이후 수행되는 메서드
    - afterCompletion
      - 클라이언트에 응답을 완료한 이후 수행, 예외 발생 시에도 수행된다. 
- 설정
  - Spring Web과 관련된 설정 파일에 설정을 진행
  - \<interceptors> 태그 내부에, 여러 \<interceptor>들을 정의
  - \<interceptor> 내에, 인터셉터 객체와 이를 수행할 요청 정보를 매핑
    - \<mapping>, \<beans:ref bean="클래스명">
    - 다수의 매핑 태그를 활용할 수 있다. 

