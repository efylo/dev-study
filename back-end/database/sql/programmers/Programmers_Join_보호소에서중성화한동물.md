## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit](https://programmers.co.kr/learn/challenges)
    - [Join - 보호소에서 중성화한 동물](https://programmers.co.kr/learn/courses/30/lessons/59045)

---

### 문제 해석

- Join문 활용

  - ANIMAL_INS와 ANIMAL_OUTS의 교집합

  - ANIMAL_INS의 속성과 ANIMAL_OUTS의 속성이 다른 경우

---

### 구현

- MySQL

  ```mysql
  -- ID, TYPE, NAME
  SELECT ai.animal_id, ai.animal_type, ai.name
  -- JOIN문 구현, ANIMAL_ID 기준
  FROM animal_ins as ai
  JOIN animal_outs as ao
      ON ai.animal_id = ao.animal_id
  -- ANIMAL_INS의 상태와 ANIMAL_OUTS의 상태가 다른 경우
  WHERE ai.sex_upon_intake != ao.sex_upon_outcome
  ORDER BY ai.animal_id;
  ```