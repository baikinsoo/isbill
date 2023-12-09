# 돈 갚아라 Project
**웹 애플리케이션 url 주소 : <http://bismoney.xyz>**  
  
**사용 기술 : JAVA, Spring, Spring Security, Spring JPA, Querydsl, Gradle, MySQL, AWS**
&nbsp;
### What is 돈 갚아라
돈 갚아라 Project는 평소 친구들과의 가벼운 채무관계에 있어 기록과 동시에 계산을 편리하게 하기 위해 만들었고, 추가적으로 게시판을 통해 소통 할 수 있는 서비스다.

&nbsp;
# 프로젝트 설명

## 1. 역할 설명
  
### 역할 별 기능
서비스의 기능은 **1. 일반 사용자 2. 회원 3. 관리자** 총 3개의 역할로 나누어져 있고 해당 역할마다 사용 가능한 기능들이 전부 다르다.  
  
**1. 일반 사용자**  
1. 일반 사용자의 경우 장부, 게시판 글만 확인이 가능하며, 권한이 필요한 페이지의 경우 로그인 페이지로 이동 시킨다.
   
![Animation](https://github.com/baikinsoo/isbill/assets/48581772/1efd1c8d-85b6-4815-8510-221ae4d981c6)

**2. 회원**  
1. 회원의 경우 2가지 회원이 존재한다. (1) 등업이 필요한 회원 (2) 등업이 완료된 회원  
2. (1) 등업이 필요한 회원의 경우 게시글 작성과 같이 등업이 필요한 행동의 경우 등업 요청을 하도록 유도한다.  
 2.1. 등업 요청 버튼을 누르게 되면 등업 신청이 완료된다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/058fad51-7968-444d-91d1-c92ddf64c37e)

3. (2) 등업이 완료된 회원의 경우 채무자 등록, 금액 입력, 자유, 등업 게시판 글 작성이 가능해진다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/699fe173-69a4-41ca-af09-4a7106c48004)

**3. 관리자**
1. 관리자의 경우 패치 노트 게시글 작성이 가능하며, 등업이 안된 회원이 등업 요청을 보낸 경우 등업을 시킬 수 있다.

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/54e1c9cd-ba3f-4368-bfce-515943239f3b)

## 2. 기능 설명
