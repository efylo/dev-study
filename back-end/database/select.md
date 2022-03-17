## SELECT문

### Abstract

- SQL의 CRUD 구문 중 테이블에서 Read하여 출력하는 / 혹은 임시 테이블을 만드는 방식으로도 사용이 되는 구문

  ```mysql
  SELECT col1, col2, ...
  FROM table_name
  WHERE col1 = "val1";
  -- 위처럼 뽑아낸 테이블을, Join문 등에서 활용 가능
  ```

- Syntax

  - SELECT col1, col2, ...
    - 뽑아낼 Column의 이름 / 값 / 함수 등을 지정한다. 
  - FROM table_name
    - SELECT 문을 실행할 테이블을 지정한다. 
    - 지정하지 않을 경우, dummy table이 선택된다. 
  - WHERE 조건식
    - SELECT할 row의 조건을 지정한다. 
  - ORDER BY col1, col2 desc
    - col1을 기준으로 오름차순 정렬
    - col1의 값이 같은 경우, col2를 기준으로 내림차순 정렬

---

### Approach

- SELECT문의 실행 순서에 따른 접근
- 접근
  - FROM절
    - 생성하고자 하는 데이터에 필요한 테이블을 먼저 규정한다. 
    - 테이블이 하나일 경우 크게 고려할 부분이 없으나, JOIN문이 들어가기 시작하면 복잡해질 여지가 충분하다. 
  - WHERE절
    - 데이터가 가져야 할 제약사항을, SQL의 조건문으로 규정한다. 
  - GROUP BY절
    - 집계 함수를 정의할 기준을 정의한다. 
  - HAVING절
    - 각 그룹이 가져야 할 제약사항을, SQL의 조건문으로 규정한다. 
    - 각 데이터에 적용되는 제약사항이 WHERE절이라면, HAVING절은 그렇지 않다. 
  - SELECT절
    - 앞선 제약 조건을 만족하는 테이블 내에서 선택
    - GROUP BY 절을 포함한다면, 다중행 데이터는 선택하기 어렵다. 
  - ORDER BY절
    - 주어진 기준에 따라서, 정렬한다. 
    - SELECT절 이후에 실행되기에, 정렬 기준에 ALIAS를 포함 가능하다. 
  - LIMIT절
    - 테이블 행의 인덱스를 설정할 수 있다. 
    - 인자값 1개: 맨 처음부터 len개의 행을 반환
    - 인자값 2개: start 인덱스부터 len개의 행을 반환

