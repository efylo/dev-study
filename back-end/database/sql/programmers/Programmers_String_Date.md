## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit - String, Date](https://programmers.co.kr/learn/courses/30/parts/17047)

---

### String 및 Date 데이터 타입

- String 데이터 타입
  - IN (...) 구문 활용
    - String도 마찬가지로, (...)의 집합에 속하는 값인지 아닌지 검출 가능하다. 
  - LIKE 구문 활용
    - '%': 임의의 0 ~ N개 문자열에 대응된다. 
    - '_': 임의의 1개 문자에 대응된다. 
- DATETIME 데이터 타입
  - 마이너스(-) 연산자를 지원한다. 
  - 형식(Format) 맞추기
    - DATE_FORMAT(datetime, format) 함수를 통해 구현 가능
    - %Y, %y, %M, %m, %D, %d 등 여러 형식을 지원

