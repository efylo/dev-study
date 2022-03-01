## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit](https://programmers.co.kr/learn/challenges)
    - [Join - 없어진 기록 찾기](https://programmers.co.kr/learn/courses/30/lessons/59042)

---

### 문제 해석

- Outer Join문 적용
  - Outer에 대한 이유
    - ANIMAL_OUTS - ANIMAL_INS: 차집합
    - 차집합을, Outer Join을 통해 구현
  - Join의 기준
    - ANIMAL_INS의 기본키(Primary key)
    - ANIMAL_OUTS의 외래키(Foreign key)
    - 둘이 동일하다면, 동일한 개체임이 보장된다. 

---

### 구현

- MySQL

  ```mysql
  SELECT ao.animal_id AS animal_id, ao.name AS name
  -- Left Outer Join (animal_outs <= ins)
  FROM animal_outs AS ao
  LEFT OUTER JOIN animal_ins AS ai
  ON ao.animal_id = ai.animal_id
  -- 기본키 NULL 검출
  WHERE ai.animal_id IS NULL
  ORDER BY ao.animal_id;
  ```

  - 차집합 구현
    1. Outer Join
    2. 외래키(Foreign key) Null 검출