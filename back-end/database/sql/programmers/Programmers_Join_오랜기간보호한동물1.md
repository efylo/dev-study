## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit](https://programmers.co.kr/learn/challenges)
    - [Join - 오랜 기간 보호한 동물(1)](https://programmers.co.kr/learn/courses/30/lessons/59044)

---

### 문제 해석

- Outer Join문을 통한 차집합 구현
  - ANIMAL_INS에 존재하지만, ANIMAL_OUTS에 존재하지 않는 동물의 ID를 SELECT
- 가장 오래 보호소에 있는 동물의 ID
  - ANIMAL_INS의 DATETIME 속성 순 정렬
- 3마리 SELECT
  - LIMIT문 구현

---

### 구현

- MySQL

  ```mysql
  SELECT ai.name as name, ai.datetime as 'datetime'
  FROM animal_ins as ai
  LEFT OUTER JOIN animal_outs as ao
  	ON ai.animal_id = ao.animal_id
  WHERE ao.animal_id IS NULL
  ORDER BY ai.datetime
  LIMIT 3;
  ```