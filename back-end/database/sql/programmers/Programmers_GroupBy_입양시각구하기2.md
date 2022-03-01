## SQL 연습 문제

### 참조

- [Programmers](https://programmers.co.kr/)
  - [SQL 고득점 Kit](https://programmers.co.kr/learn/challenges)
    - [Group By - 입양 시각 구하기(2)](https://programmers.co.kr/learn/courses/30/lessons/59413)

---

### 문제 해석

- Group By 절 활용
- CTE(Comman Table Expressions) 생성
- Outer Join문 활용
  - 주어진 테이블과, 생성한 CTE에 Outer Join을 적용
  - Inner Join을 실행할 경우, NULL값을 포함하지 못하기에 불가능
- Count 함수 적용
  - NULL값은 헤아리지 않는다. 
  - 중복된 값을 다르게 헤아려야 한다. 
    - 서로 다른 행이기 때문에

---

### 구현

- MySQL

  ```mysql
  -- CTE 생성
  WITH RECURSIVE CTE AS (
      SELECT 0 AS h
      UNION ALL
      SELECT h+1 FROM CTE
      	WHERE h+1 < 24
  )
  -- Join (CTE <= Animal_Outs), NULL값 제외
  SELECT T.h as HOUR, COUNT(HOUR(AO.DateTime)) AS 'COUNT'
  FROM Animal_Outs AS AO
  RIGHT OUTER JOIN CTE AS T
  ON HOUR(AO.DateTime) = T.h
  GROUP BY HOUR
  ORDER BY HOUR;
  ```

  - GROUP BY, ORDER BY 구문에는 별칭(Alias)을 사용 가능하다. 
    - 해당 구문은, SELECT 절로 테이블을 생성한 이후 적용하는 것이 아닌가 싶다. 
  - COUNT 구문에 동일한 값이 할당되더라도, 고유 값을 기준으로 DISTINCT를 판별한다. 
    - COUNT(AO.Name)을 사용할 경우, 제대로 된 결과를 반환받지 못한다. 
    - AO.Name이 중복된 값을 허용하기 때문이다. 
    - 더 엄밀하게 적용하자면, COUNT(AO.Animal_ID)를 사용할 수 있을 것이다. 

