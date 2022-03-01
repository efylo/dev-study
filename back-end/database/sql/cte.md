## CTE

### Abstract

- MySQL - CTE

  - MySQL에서는 매 쿼리마다, 임시 릴레이션이 생성된다. 
    - 임시 릴레이션이란, 일시적으로 생성된 테이블(릴레이션)을 일컫는다. 
  - 임시 릴레이션에 이름을 붙여 쿼리문에 사용하는 것을, CTE라고 한다. 

- WITH RECURSIVE 문

  - pseudo-code

    ```pseudocode
    WITH RECURSIVE
    cte_name [(col1, col2, ...)]
    AS ( subquery )
    SELECT col1, col2, ... FROM cte_name;
    ```

  - subquery

    ```pseudocode
    AS (
        SELECT col1, col2, ... coln FROM table_name
        UNION [ALL, DISTINCT]
        SELECT col1, col2, ... coln FROM cte_name
        WHERE clause
    )
    ```

    1. 초기화 구문
       - CTE의 초기 행 값을 Insert한다. 
    2. 집합 연산자
       - ALL은 중복값을 포함하며, DISTINCT는 중복값을 포함하지 않는다. 
       - 직전 iteration까지의 집합과, 재귀 구문에서 생성된 새 집합을 합친다. 
    3. 재귀 구문 & 조건문
       - 직전 iteration의 집합을 기반으로, 새 집합을 생성한다. 
       - 새 집합이 NULL일 경우, WITH문을 탈출한다. 

---

### Reference

- [GeeksforGeeks - MySQL | Recursive CTE (Common Table Expressions)](https://www.geeksforgeeks.org/mysql-recursive-cte-common-table-expressions/?ref=gcse)