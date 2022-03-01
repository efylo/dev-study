## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit](https://programmers.co.kr/learn/challenges)
    - [Join - 있었는데요 없었습니다](https://programmers.co.kr/learn/courses/30/lessons/59043)

---

### 문제 해석

- ANIMAL_INS의 Datetime < ANIMAL_OUTS의 Datetime
  - 보호소에 들어온 이후, 입양을 가는 절차가 정상적
- 위를 만족하지 않는 동물의 ID 반환
  - Join문 구현
    - 보호소에 들어왔었으며, 입양을 간 동물들의 테이블을 생성
  - Where문 적용
    - 입양을 간 날짜가, 보호소에 들어온 날짜보다 앞선 경우

---

### 구현

- MySQL

  ```mysql
  SELECT ao.animal_id AS animal_id, ao.name AS name
  -- Join문 구현
  FROM animal_outs as ao
  JOIN animal_ins as ai
  	ON ao.animal_id = ai.animal_id
  -- 입양 날짜가, 보호소에 들어온 날짜보다 이른 경우(오류)
  WHERE ao.datetime < ai.datetime
  ORDER BY ai.datetime;
  ```

