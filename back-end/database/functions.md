## SQL Functions

### Abstract

- SQL 혹은 RDBMS에서 데이터 / 집계 등의 이유로 제공되는 함수. 
- 데이터에 적용 가능한 함수는, 데이터 타입별로 상이할 수 있다. 
  - 숫자형 / 문자형 / 날짜형에 각각 적용 가능한 함수들이 존재한다. 
- 집계 함수는, GROUP BY절에서 정의한 기준에 의해 생성된 GROUP 내 데이터의 합 / 평균 / 개수 / 최대 / 최소를 구하는 기능을 제공한다. 
  - COUNT: NULL값을 제외하고 개수를 헤아린다. 

---

### 함수

- 숫자형

  | 구분        | 정의                                            |
  | ----------- | ----------------------------------------------- |
  | ABS(x)      | x의 절댓값을 반환                               |
  | CEILING(x)  | x보다 크거나 같은 정수 중 가장 작은 정수를 반환 |
  | FLOOR(x)    | x보다 작거나 같은 정수 중 가장 큰 정수를 반환   |
  | ROUND(x, d) | x를 소수점 d자리까지 반올림하여 반환            |

  - 이외에 TRUNCATE, POW, MOD, GREATEST, LEAST 등이 존재

- 문자형

  | 구분                       | 정의                                      |
  | -------------------------- | ----------------------------------------- |
  | CONCAT(s1, s2, ...)        | 문자열을 결합하여 반환                    |
  | CONCAT_WS(ws, s1, s2, ...) | 문자열 사이에 ws를 추가하며 결합하여 반환 |
  | SUBSTR(s, start, len)      | start부터 len길이만큼의 문자열을 반환     |
  | TRIM()                     | 양 끝의 공백을 제거하여 반환              |
  | REPLACE(s, str1, str2)     | 문자열 내 str1을 str2로 변경              |
  | INSTR(s, str1)             | 문자열 내 str1의 시작 인덱스를 반환       |

  - 이외에 LOWER, UPPER, LEFT, RIGHT, REVERSE 등이 존재

- 날짜형

  | 구분          | 정의                         |
  | ------------- | ---------------------------- |
  | NOW()         | 현재 날짜 / 시간을 반환      |
  | CURDATE()     | 현재 날짜을 반환             |
  | CURTIME()     | 현재 시간을 반환             |
  | DATE_ADD()    | 날짜에서 기준 값만큼 더한다. |
  | DATE_SUB()    | 날짜에서 기준 값만큼 뺀다.   |
  | DATE_FORMAT() | 날짜를 형식에 맞추어, 반환   |

  - YEAR, MONTH, MONTHNAME, DAYNAME, DAYOFMONTH, DAYOFWEEK 등이 존재

---

### 논리 함수

- CASE ~ WHEN ~ THEN ~ ELSE ~ END

  ```mysql
  CASE WHEN cond1 THEN val1
  	WHEN cond2 THEN val2
  	ELSE val3
      END as `조건절`
  ```

- IFNULL(arg, val)

  - arg가 null인 경우, val을 반환

---

### 기타 구문

- desc table_name
  - table_name에 대한 설명을 반환한다. 
    - Field, Type, Null, Key, Default, Extra
- explain
  - 쿼리문에 대한 설명을 반환한다. 