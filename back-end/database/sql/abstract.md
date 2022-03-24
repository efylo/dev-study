## RDBMS

### Abstract

- 관계형(Relational) 데이터베이스 시스템
  - 테이블 단위로 데이터를 관리
  - 중복 데이터의 최소화를 지향
    - 정규화: 중복 데이터가 존재할 경우, 이를 독립적인 테이블로 분리
  - 분산되어 존재하는 데이터를, 테이블 간 관계를 통해 검색
- SQL(Structured Query Language)
  - DB의 데이터를 처리할 수 있도록 지원하는 언어

---

### Data Types

- 문자형 데이터 타입

  | 구분                  | 정의                                                |
  | --------------------- | --------------------------------------------------- |
  | CHAR[(M)]             | 고정 길이 문자열을 저장, M은 1 ~ 2^8^-1             |
  | VARCHER[(M)]          | 가변 길이 문자열을 저장, M = 1 ~ 2^16^-1            |
  | TINYTEXT[(M)]         | 최대 2^8^-1 BYTE                                    |
  | TEXT[(M)]             | 최대 2^16^-1 BYTE                                   |
  | MEDIUMTEXT[(M)]       | 최대 2^24^-1 BYTE                                   |
  | LONGTEXT[(M)]         | 최대 2^32^-1 BYTE                                   |
  | ENUM('V1', 'V2', ...) | 열거형, 정해진 값 중 하나만 저장, 최대 2^16^-1 요소 |
  | SET('V1', 'V2', ...)  | 집합형, 정해진 값 중 여럿을 저장, 최대 64개 요소    |

- 숫자형 데이터 타입

  | 구분   | 정의  |
  | ------ | ----- |
  | INT    | 4BYTE |
  | DOUBLE | 8BYTE |

- 날짜형 데이터 타입

  | 구분          | 바이트 | 정의                     |
  | ------------- | ------ | ------------------------ |
  | DATE          | 3      | yyyy-MM-dd               |
  | TIME          | 3      | HH:MM:SS                 |
  | DATETIME      | 8      | yyyy-MM-dd HH:MM:SS      |
  | TIMESTAMP[(M) | 4      | TIMEZONE의 영향을 받는다 |

- 이진 데이터 타입

  | 구분           | 정의                                |
  | -------------- | ----------------------------------- |
  | BINARY[(M)]    | CHAR과 유사, 문자열로 저장          |
  | VARBINARY[(M)] | VARCHAR과 유사, 문자열로 저장       |
  | BLOB[(M)]      | 이진 데이터 타입, 최대 2^16^-1 BYTE |

  - 사진을 저장하기 위한 용도로 자주 사용

---

### Table

- Create

  ```mysql
  CREATE DATABASE DB_NAME;
  
  CREATE TABLE TABLE_NAME (
      COL1 TYPE [ATTRIBUTES], 
      COL2 TYPE [ATTRIBUTES], 
      ...
  );
  ```

  - Attributes

    | 구분           | 정의                                                         |
    | -------------- | ------------------------------------------------------------ |
    | NOT NULL       | NULL값을 가질 수 없음                                        |
    | DEFAULT value  | NULL 값이 들어올 경우, value 값이 할당                       |
    | UNSIGNED       |                                                              |
    | CHARACTER SET  | 문자의 인코딩 타입을 지정                                    |
    | AUTO INCREMENT | 값이 들어올 때마다 자동적으로 증가                           |
    | UNIQUE         | 중복된 값을 저장할 수 없음                                   |
    | PRIMARY KEY    | ROW를 구분하기 위한 유일한 값, 중복된 값 X / NULL 허용 X     |
    | FOREIGN KEY    | 특정 테이블의 PK 값만 저장 가능, NULL값 허용, REFERENCES를 이용하여 참조 칼럼 지정 |
    | CHECK          | 값의 범위 / 종류를 지정, MySQL 8.0.16부터 사용               |

- Insert

  ```mysql
  INSERT INTO TABLE_NAME(COL1, COL2, ...)
  VLAUES(val1, val2, ...), 
  	(val11, val22, ...);
  ```

  - NULL을 허용하는 Column은 제외하고 insert할 수 있다. 
  - Insert는 테이블의 행(row)를 추가한다. 

- Update

  ```mysql
  UPDATE TABLE_NAME
  SET COL1 = 'VAL1_MODIFIED', COL2 = 'VAL2_MODIFIED'
  WHERE PK = 'PRIMARY_KEY';
  ```

  - Update는 테이블의 행(row)의 값을 업데이트한다. 
  - 열의 값을 변환할 시에는, Alter를 활용해야 한다. 

- Delete

  ```mysql
  DELETE FROM TABLE_NAME
  WHERE PK = 'PRIMARY_KEY';
  ```
  
  - Delete은 Table의 row를 제거한다. 
  
- Drop

  ```mysql
  DROP DATABASE IF EXISTS DB_NAME1;
  
  DROP TABLE IF EXISTS TABLE_NAME;
  ```
  
  - Drop은 Table / Database와 같은 저장소의 단위를 제거한다. 

