## Annotation

### Abstract

- 코드 자체에 영향을 주지 않는, 메타 데이터의 형식을 자바에서는 Annotation이라고 한다. 
  - 사용처
    - 컴파일러에게 정보를 제공한다. 
    - 컴파일 / 배포 프로세스 과정에 활용된다. 
    - 프로그램이 동작하는 동안 사용된다. 
  - Spring
    - 스프링 프레임워크에서는, 다수의 Annotation을 활용하여, 복잡한 서버 프로그램을 기능적으로 나누어 구현한다. 

---

### in Spring

- Application

  | Syntax                 | Location       | Indicates                     |
  | ---------------------- | -------------- | ----------------------------- |
  | @SpringBootApplication | Prior to class | 메인 메서드가 존재하는 클래스 |

- Controller

  | Syntax                     | Location                                       | Indicates                                      |
  | -------------------------- | ---------------------------------------------- | ---------------------------------------------- |
  | @Controller                | Prior to class                                 | Controller의 기능이 구현된 클래스              |
  | @GetMapping(String path)   | Method of Controller                           | Http 요청 url의 path에 매핑된 클래스           |
  | @ResponseBody              | Method of Controller                           | 메서드가 반환한 객체를 Http 응답의 body에 추가 |
  | @RequestParam(String name) | Prior to Parameter of the method in Controller | Http 요청의 Param을 메서드의 매개변수에 입력   |

---

### in JUnit

- class xxxTest

  | Syntax     | Location        | Indicates                                |
  | ---------- | --------------- | ---------------------------------------- |
  | @Test      | Prior to method | 테스트 용으로 작성된 메서드              |
  | @AfterEach | Prior to method | 매 테스트 메서드 종료 시 실행되는 메서드 |

  

