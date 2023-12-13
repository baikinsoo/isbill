# 돈 갚아라 Project
**웹 애플리케이션 url 주소 : <http://bismoney.xyz>**  
  
**USE : JAVA, Spring, Spring Security, Spring JPA, Querydsl, Thymleaf, Gradle, MySQL, AWS**  

&nbsp;
### What is 돈 갚아라
돈 갚아라 Project는 평소 친구들과의 가벼운 채무관계에 있어 기록과 동시에 계산을 편리하게 하기 위해 만들었고, 추가적으로 게시판을 통해 소통 할 수 있는 서비스다.

### 목차
1. 프로젝트 설명  
  1.1. ERD  
  1.2. 역할 설명  
  1.3. 기능 설명
2. 프로젝트 상세 설명
   

&nbsp;
# 프로젝트 설명

## 1. ERD
![image](https://github.com/baikinsoo/isbill/assets/48581772/04f4f813-e130-4f14-bb4f-5dff6681beed)

## 2. 역할 설명
  
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

## 3. 기능 설명  

**1. 채무자 등록, 금액 입력 및 확인**
1. 등업이 완료된 회원의 경우 장부가 생성되며, 채무자를 등록, 채무자에 대한 빌린 돈, 갚은 돈을 입력 할 수 있다.
2. 금액을 입력하게 되면 장부에 자동으로 저장되며, 빌린 돈과 갚은 돈을 계산하여 갚아야 할 최종 금액을 보여준다.
     
![Animation](https://github.com/baikinsoo/isbill/assets/48581772/8029d244-c333-4ba3-80a2-9a0b6f348ebf)

**2. 게시판 글 작성 (글 작성, 수정, 삭제, 댓글 작성, 삭제, 첨부 파일 등록)**
1. 등업이 완료된 회원의 경우 첨부 파일 등록이 가능한 게시글 작성이 가능하다. (첨부파일 수정, 삭제 / 게시글 수정, 삭제도 가능하다.)
   
![Animation](https://github.com/baikinsoo/isbill/assets/48581772/3dc19530-3129-4ac2-b4c1-13d079d976b9)  
2. 게시글의 경우 자신의 글이 아니면 수정, 삭제 버튼이 보이지 않는다.  
  
  (1) 자신의 게시글일 경우
  ![image](https://github.com/baikinsoo/isbill/assets/48581772/2b87b9fd-249b-4ba4-8fe4-c7decfb433da)

  (2) 자신의 게시글이 아닐 경우
  ![image](https://github.com/baikinsoo/isbill/assets/48581772/e14e29d9-3ef6-47d0-8082-2cafa9efc24d)

**3. 댓글 작성 (댓글 작성, 삭제)**
1. 게시글에 댓글을 작성, 삭제가 가능하다.
   ![Animation](https://github.com/baikinsoo/isbill/assets/48581772/14fdefe0-a700-4c6c-a2a5-6486b953bde8)
2. 댓글도 마찬가지로 자신이 쓴 댓글만 삭제 버튼이 보이고 삭제가 가능하다.
   ![image](https://github.com/baikinsoo/isbill/assets/48581772/7afff8c4-30b5-46ff-85fa-f638f46d8d46)

**4. 이름, 비밀번호 변경**
1. 최초 회원 가입 이후 마이페이지를 통해 비밀번호 변경이 가능하다.
   
![Animation](https://github.com/baikinsoo/isbill/assets/48581772/f1f61a68-9552-44b7-8630-947e01f64bce)

**5. 장부, 게시판 검색**
1. 원하는 장부 이름을 검색할 수 있다.
   
![Animation](https://github.com/baikinsoo/isbill/assets/48581772/b57e988a-370b-4a6a-ae51-35a191afeb2f)  

2. 원하는 게시글 제목을 검색할 수 있다. (페이징도 검색 기준이 유지되는 상태에서 적용된다.)

![Animation](https://github.com/baikinsoo/isbill/assets/48581772/39effbe0-943a-4c4b-9b0d-47acd309fa39)  

&nbsp;
# 프로젝트 상세 설명

## 1. 역할 관련  
1. Spring Security에 의해 특정 URL에 접근 허용할 역할을 지정한다.
```
http.authorizeRequests()
.mvcMatchers("/**","/css/**", "/js/**").permitAll()
.antMatchers("/", "/members/**", "/money/list/**").permitAll()
.mvcMatchers("/bill/new","/money/new").hasAnyRole("USER","ADMIN")
.mvcMatchers("/upBoard/list").hasRole("ADMIN")
.anyRequest().authenticated();
```
2. HTML에 Spring Security를 적용하여 화면 선택 가능 역할에 대해 구분한다.  
```
<li class="nav-item" sec:authorize="true">
<a class="nav-link" href="/patch">패치 노트</a>
</li>
<li class="nav-item" sec:authorize="hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')">
<a class="nav-link" href="/members/edit">마이페이지</a>
</li>
<li class="nav-item" sec:authorize="hasAnyAuthority('ROLE_ADMIN')">
<a class="nav-link" href="/upBoard/admin">관리자 전용</a>
</li>
<li class="nav-item" sec:authorize="isAnonymous()">
<a class="nav-link" href="/members/login">로그인</a>
</li>
<li class="nav-item" sec:authorize="isAuthenticated()">
<a class="nav-link" href="/members/logout">로그아웃</a>
</li>
```
3. ajax를 통해 특정 URL에 대해 요청, 응답을 받는다.
```
function billNew() {
  var token = $("meta[name='_csrf']").attr("content");
  var header = $("meta[name='_csrf_header']").attr("content");
  var url = "/bill/billNew";
  $.ajax({
    url: url,
    type: "GET",
    beforeSend: function(xhr) {
      /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
      xhr.setRequestHeader(header, token);
    },
    cache: false,
    success: function(result, status) {
      location.href = '/bill/new';
    },
    error: function(jqXHR, status, error) {
      if (jqXHR.status == 401) {
        alert('로그인 후 이용해주세요');
        location.href = '/members/login';
      } else if (jqXHR.status == 418) {
        alert('등업 후 이용해주세요');
      location.href = '/upBoard';
      } else {
        alert(jqXHR.responseText);
      }
    }
  });
}
```
4. ResponseEntity를 이용하여 ajax로 넘어온 요청에 대한 응답을 전달한다.
```
@GetMapping("billNew")
    public ResponseEntity billNew(Principal principal) {
        Member member = null;
        if (principal != null) {
            member = principalService.findMember(principal);
            if (member.getRole() == Role.NONE) {
                return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
            }
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
```

## 2. 채무자 등록, 금액 입력 및 확인
1. @Validated, BindingResult를 통해 데이터에 대해 검증을 거친 뒤, findBill을 통해 기존에 존재하는 채무자인지 2차 검증이 이루어진다. 2가지 검증을 통과하게 되면, 새로운 채무자가 등록된다.
2. 1차 데이터 검증에 실패하게 되면, BindingResult에 오류와 관련된 데이터를 포함하고, DB를 조회하여 이미 존재하는 채무자인지 검증한다.
3. Principal을 통해 현재 로그인한 회원을 인식하여 DB에 해당 회원에 대한 데이터가 저장된다.
```
@PostMapping("/new")
    public String createBill(@Validated BillFormDto billFormDto, BindingResult bindingResult, Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            return "bill/billForm";
        }

        String name = billFormDto.getName();
        Bill bill = billService.findBill(name, principal);

        if (bill != null) {
            bindingResult.rejectValue("name", "error.billFormDto", "이미 존재하는 채무자 이름입니다.");
            return "bill/billForm";
        }

        billService.saveBill(billFormDto, principal);
        return "redirect:/";
    }
```
4. 금액 입력의 경우, Principal을 통해 회원을 인식하고, 해당 회원에 대한 채무자와 장부 DB를 가져온 뒤 사용자가 입력한 금액 데이터를 전달 받아 DB에 저장한다.
```
@PostMapping("/new")
    public String moneyNew(@Valid @ModelAttribute MoneyFormDto moneyFormDto, BindingResult bindingResult, Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            List<Bill> bills = billService.findMemberBills(principal);
            model.addAttribute("bills", bills);
            return "money/moneyForm";
        }
        String name = principal.getName();
        Member member = memberService.findByEmail(name);
        Registre registre = registreService.findMember(member.getId());
        Bill bill = billService.findById(moneyFormDto.getBillId());
        RegistreBill registreBill = null;
        registreBill = registreBillService.findRegistreBill(registre.getId(), bill.getId());

        if (registreBill == null) {
            registreBillService.saveRB(registre, bill);
        }
        moneyService.saveMoney(moneyFormDto, registre, bill);

        return "redirect:/";
    }
```
5. 조회에 필요한 데이터를 가져온 뒤 saveMoney 로직을 통해 금액을 입력하고, DB에 저장된 최종 계산 금액에 입력된 데이터를 + - 하여 사용자가 금액을 입력하게 되면, 내부에서 계산된 금액을 계속해서 반환하게 된다. 
```
public void saveMoney(MoneyFormDto moneyFormDto, Registre registre, Bill bill) {

        Money lastMoney = null;

        RegistreBill registreBill = registreBillRepository.findByRegistre_IdAndBill_Id(registre.getId(), bill.getId());

        List<Money> moneyList = moneyRepository.findByRegistreBill_Id(registreBill.getId());

        if (!moneyList.isEmpty()) {
            lastMoney = moneyList.get(moneyList.size() - 1);
        } else {
            throw new RuntimeException("결과값이 없습니다.");
        }

        Long remainMoney = lastMoney.getRemainMoney();
        Long borrowMoneyAll = lastMoney.getBorrowMoneyAll();
        Long payMoneyAll = lastMoney.getPayMoneyAll();
```
