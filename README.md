---

### **당신의 채무는? (개인 프로젝트)**

- 빈번한 채무 발생으로 인해 기억, 계산 및 정보 전달이 번거로웠던 상황에서, 이러한 어려움을 해결하고자 우리는 간편하게 채무를 기록하고 계산해주며, 한눈에 채무 관계를 확인할 수 있는 채무 관리 서비스를 개발하였습니다.


**웹 애플리케이션 url 주소 : [http://bismoney.xyz](http://bismoney.xyz/)**

**시연 영상 : https://youtu.be/ohXquAYAHeQ**

# 프로젝트

### ERD / API 명세서

**ERD**

![image](https://github.com/baikinsoo/isbill/assets/48581772/04f4f813-e130-4f14-bb4f-5dff6681beed)

**Swagger : http://bismoney.xyz/swagger-ui/index.html**

---

### 역할 별 기능

**Enum**을 통해 1. 일반 사용자 2. 회원 3. 관리자 총 3개의 역할이 존재하고 **Spring Security**, **Filter**를 통해 각 역할 별 서비스 이용 제한이 존재합니다.

서비스 클릭시 **Ajax**를 통해 응답 결과에 따라 해당 사용자에게 필요한 페이지로 **Redirect** 시킵니다.

**Spring Security**의 **UserPrincipal**과  **hasAuthority**를 이용하여 역할별 보이는 화면을 구분하였습니다.

회원가입시 DB에 저장된 Password가 노출되지 않도록 **PasswordEncoder**를 사용하여 암호화를 했습니다.

- 일반 사용자

기본 서비스만 제공되며, 로그인 필요시 로그인 페이지로 Redirect 시킵니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/1efd1c8d-85b6-4815-8510-221ae4d981c6)

- 회원

회원의 경우에도 Enum을 통해 등급을 구분하였습니다.
권한 필요시 등업 페이지로 Redirect 시킵니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/058fad51-7968-444d-91d1-c92ddf64c37e)

- 관리자

각 사용자에게 권한을 부여할 수 있습니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/54e1c9cd-ba3f-4368-bfce-515943239f3b)

### 서비스 별 기능

- 채무자 등록, 금액 입력 및 확인

**1:N (장부_채무자) N:1** 관계를 통해 채무자 이름이 중복 되어도 각 회원의 채무자를 구분지어 입력 할 수 있습니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/8029d244-c333-4ba3-80a2-9a0b6f348ebf)

- 게시판 글 작성 (작성, 수정, 삭제, 댓글 작성, 삭제, 첨부 파일 등록)

**AWS S3 Bucket**을 이용하여 첨부파일 저장소로 활용하였습니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/3dc19530-3129-4ac2-b4c1-13d079d976b9)  

**UserPrincipal**을 통해 사용자 권한을 확인하고, **hasAuthority**를 통해 수정, 삭제 버튼이 보이도록 구분하였습니다.

(본인 게시글)

 ![image](https://github.com/baikinsoo/isbill/assets/48581772/2b87b9fd-249b-4ba4-8fe4-c7decfb433da)

(타인 게시글)

![image](https://github.com/baikinsoo/isbill/assets/48581772/e14e29d9-3ef6-47d0-8082-2cafa9efc24d)

- 댓글 작성 (작성, 삭제)

마찬가지로 **UserPrincipal**을 통해 사용자 권한을 확인하고, **hasAuthority**를 통해 수정, 삭제 버튼이 보이도록 구분하였습니다.
    
   ![Animation](https://github.com/baikinsoo/isbill/assets/48581772/14fdefe0-a700-4c6c-a2a5-6486b953bde8)
    
    
   ![image](https://github.com/baikinsoo/isbill/assets/48581772/7afff8c4-30b5-46ff-85fa-f638f46d8d46)
    

- 이름, 비밀번호 변경

로그인과 마찬가지로 비밀번호를 변경하게 되면, **PasswordEncoder**로 암호화된 새로운 비밀번호가 DB에 저장됩니다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/f1f61a68-9552-44b7-8630-947e01f64bce)

- 장부, 게시판 검색

**Spring JPA**를 통해 페이징을 구현하였습니다.

**Querydsl**을 이용하여 동적쿼리를 작성했으며, Java 언어를 기반으로 하기 때문에 Compile 시점에서 타입 안정성이 보장되기 때문에 Runtime 에러를 방지할 수 있습니다.

**Hidden input**을 통해 검색 시 검색 조건이 유지된 채 페이징이 되도록 하였습니다. 

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/b57e988a-370b-4a6a-ae51-35a191afeb2f) 


![Animation](https://github.com/baikinsoo/isbill/assets/48581772/39effbe0-943a-4c4b-9b0d-47acd309fa39)  

### 배포
- AWS EC2를 통해 배포하였습니다.
- Gabia를 통해 Domain을 구매하여 Router53을 통해 Domain을 연동하였습니다.
---

**사용 기술** : JAVA, Spring, Spring Security, Spring JPA, Querydsl, Thymleaf, Gradle, MySQL, AWS

**GitHub** : https://github.com/baikinsoo/isbill
