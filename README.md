# 돈 갚아라 Project
**웹 애플리케이션 url 주소 : <http://bismoney.xyz>**  
  
**USE : JAVA, Spring, Spring Security, Spring JPA, Querydsl, Thymleaf, Gradle, MySQL, AWS**  

### What is 돈 갚아라
- 돈 갚아라 Project는 평소 친구들과의 가벼운 채무관계에 있어 기록과 동시에 계산을 편리하게 하기 위해 만들었고, 추가적으로 게시판을 통해 소통 할 수 있는 서비스다.

### 목차
1. 프로젝트 설명  
  1.1. ERD  
  1.2. 역할 설명  
  1.3. 기능 설명
2. 프로젝트 상세 설명  
  2.1. 역할 관련  
  2.2. 채무자 등록, 금액 입력 및 확인  
  2.3. 게시판 글 작성 (글 작성, 수정, 삭제, 댓글 작성, 삭제, 첨부 파일 등록)  
  2.4. 회원 이름, 비밀번호 변경  
  2.5. 장부, 게시판 검색  
3. 개선 사항

&nbsp;
# 프로젝트 설명

## 1. ERD / API 명세서(Swagger)
### ERD
![image](https://github.com/baikinsoo/isbill/assets/48581772/04f4f813-e130-4f14-bb4f-5dff6681beed)
&nbsp;
### API 명세서
![image](https://github.com/baikinsoo/isbill/assets/48581772/6640ab88-e8f6-441d-a40c-c3d943007e2c)
### Swagger 명세서 URL : http://bismoney.xyz/swagger-ui/index.html  
&nbsp;
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
1. 최초 회원 가입 이후 마이페이지를 통해 이름, 비밀번호 변경이 가능하다.
   
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
   1.1. antMatchers와 mvcMatchers를 통해 단순 URL과 mvc Controller의 경로에 대해 접근 역항르 구분짓는다.
```
http.authorizeRequests()
.mvcMatchers("/**","/css/**", "/js/**").permitAll()
.antMatchers("/", "/members/**", "/money/list/**").permitAll()
.mvcMatchers("/bill/new","/money/new").hasAnyRole("USER","ADMIN")
.mvcMatchers("/upBoard/list").hasRole("ADMIN")
.anyRequest().authenticated();
```
2. HTML에 Spring Security를 적용하여 화면 선택 가능 역할에 대해 구분한다.  
   2.1. sec:authorize의 hasAnyAuthority, isAnonymous(), isAuthenticated() 메서드를 이용하여 상황에 맞게 접근 권한을 구분 할 수 있다.
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
3. ajax를 통해 특정 URL에 대해 요청, 응답을 받는다. (여기서 URL에 대한 요청은 해당 사용자의 로그인 여부 및 등급에 대한 여부를 판단한다.)
   3.1. ajax에 url, type(HTTP 메서드), success(요청 성공시), error(요청 실패시) 필드들을 이용하여, 비동기적으로 페이지 전체를 새로고침하지 않고 서버와 데이터를 교환한다.
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
4. ResponseEntity를 이용하여 ajax로 넘어온 요청에 대한 응답을 전달한다
5. Principal 객체를 통해 로그인이 되었는지 아닌지 로그인이 된 경우 해당 사용자의 역할에 대해 조회하고 경우에 따른 응답을 전달한다.
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
**1. 채무자 등록**  
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
**2. 금액 입력 및 확인**
1. 금액 입력의 경우, Principal을 통해 회원을 인식하고, 해당 회원에 대한 채무자와 장부 DB를 가져온 뒤 사용자가 입력한 금액 데이터를 전달 받아 DB에 저장한다.
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
2. 조회에 필요한 데이터를 가져온 뒤 saveMoney 로직을 통해 금액을 입력하고, DB에 저장된 최종 계산 금액에 입력된 데이터를 + - 하여 사용자가 금액을 입력하게 되면, 내부에서 계산된 금액을 계속해서 반환하게 된다. 
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
## 3. 게시판 글 작성 (글 작성, 수정, 삭제, 댓글 작성, 삭제, 첨부 파일 등록)
**1. 게시글 목록**
1. 게시글 목록의 경우 Spring JPA의 Paging 기능을 이용하여 데이터를 5개씩 보이도록 한다.
   1.1. pageable은 Page 인터페이스의 메서드 파라미터로 주로 사용되며 페이지에 관련된 내용들을 포함한다.
```
Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);

Page<FreeBoard> freeBoardPage = freeBoardService.getFreeBoardPage(freeBoardSearchDto, pageable);

model.addAttribute("freeBoardSearchDto", freeBoardSearchDto);
model.addAttribute("freeBoardList", freeBoardPage);
model.addAttribute("maxPage", 5);
return "freeBoard/freeBoardList";
```
**2. 게시글 작성 (첨부 파일 AWS Bucket 저장)**
1. 게시글 작성에는 첨부파일 등록, 제목, 글 데이터가 넘어오게 된다. (MultipartFile을 통해 바이너리 데이터가 담겨져서 넘어온다.)
   1.1. 첨부파일의 제공자를 Principal을 통해 구분하고, 제공자 및 파일 경로를 저장소에 저장한다.
```
@PostMapping("/new")
    public String saveContent(@Validated FreeBoardFormDto freeBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            return "freeBoard/newContent";
        }

        String url = s3UploadService.saveFile(freeBoardFormDto.getAttachFile());

        Member member = principalService.findMember(principal);

        freeBoardService.saveContent(freeBoardFormDto, member, url);

        return "redirect:/freeBoard";
    }
```
2. freeBoardFormDto를 통해 데이터가 넘어오고, 그 중 첨부파일을 가져오기 위해 MultipartFile 객체를 가져오고, S3UploadService 즉, AWS Bucket에 첨부파일을 저장하기 위한 Service 코드에 해당한다.
```
@PostMapping("/new")
    public String saveContent(@Validated FreeBoardFormDto freeBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            return "freeBoard/newContent";
        }

        String url = s3UploadService.saveFile(freeBoardFormDto.getAttachFile());

        Member member = principalService.findMember(principal);

        freeBoardService.saveContent(freeBoardFormDto, member, url);

        return "redirect:/freeBoard";
    }
```
- 첨부파일 AWS Bucket 저장
3. 첨부 파일을 AWS Bucket에 저장하기 위해선 gradle을 통해 AWS 의존성을 주입하고, Bucket에 대한 정보를 설정해준다.
4. 아래 key 정보와, region, bucket의 이름과 같은 구체적인 정보들은 application.yml 파일에 작성한 뒤 불러온다.
```
cloud:
  aws:
    s3:
      bucket: spring-bucket-bis
    stack.auto: false
    region.static: ap-northeast-2
    credentials:
      accessKey: AKIAWEAMPDQHPEFNKQS2
      secretKey: 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
```
```
@Configuration
public class S3Config {

    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Bean
    public AmazonS3 amazonS3Client() {

        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }
}
```
5. saveFile 메서드가 호출되면, MultipartFile 객체를 전달 받아 AWS Bucket에 연결하여 저장한다. amazonS3 객체의 putObject를 통해 연결된 Bucket에 첨부파일을 저장한다.
   5.1. createStoreFileName() 메서드는 Bucket에 저장되는 파일명이 중복되지 않도록 변경하는 메서드에 해당한다.(코드는 별도로 구현되어 있다.)
```
public String saveFile(MultipartFile multipartFile) throws IOException {

        if (multipartFile.isEmpty()) {
            return null;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        metadata.setContentType(multipartFile.getContentType());

        amazonS3.putObject(bucket, storeFileName, multipartFile.getInputStream(), metadata);
        String string = amazonS3.getUrl(bucket, storeFileName).toString();
        return string;
    }
```
**3. 게시글 수정 삭제**
1. 기존의 입력된 첨부파일, 제목, 글을 그대로 가져 온 뒤, 게시글 작성 로직과 유사하게 수정 로직도 작성한다.
2. 첨부파일의 경우 수정, 삭제의 상황을 구분하여 로직을 작성해준다.
- 첨부파일의 경우 수정이되거나, 삭제가 될 경우 AWS Bucket에서도 해당 객체를 삭제하도록 코드를 작성한다. (만약 수정, 삭제 시 해당 객체가 Bucket에서 사라지지 않게 되면 Bucket에 무수히 많은 객체들이 쌓이기 때문이다.)
```
@PostMapping("/{freeBoardId}/edit")
    public String editFreeBoard(@PathVariable("freeBoardId") Long freeBoardId, @ModelAttribute("freeBoard") FreeBoardFormDto freeBoardFormDto) throws IOException {

        if (freeBoardFormDto.getAttachFile().isEmpty()) {
            FreeBoard one = freeBoardService.findOne(freeBoardId);
            freeBoardService.editContent(one, freeBoardFormDto, null);
        } else {
            String url = s3UploadService.saveFile(freeBoardFormDto.getAttachFile());
            FreeBoard one = freeBoardService.findOne(freeBoardId);
            s3UploadService.deleteFile(one.getAWSUrl());
            freeBoardService.editContent(one, freeBoardFormDto, url);
        }
        return "redirect:/freeBoard/" + freeBoardId;
    }
```
3. 삭제의 경우 해당 엔티티를 찾아서 삭제한다.
```
@DeleteMapping("/{freeBoardId}/delete")
    public ResponseEntity<String> delete(@PathVariable("freeBoardId") Long freeBoardId) {
        freeCommentService.deleteFBComment(freeBoardId);
        try {
            freeBoardService.delete(freeBoardId);
            return ResponseEntity.ok("삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제에 실패했습니다.");
        }
    }
```
**4. 게시글 댓글 입력, 삭제**
1. 게시글 댓글의 경우 해당 게시글에 대한 인덱스, 현재 로그인 중인 회원 정보가 필요하다.
2. 댓글 입력칸의 경우 현재 로그인 및 역할이 부여된 회원에게만 보여준다. Principal을 통해 현재 로그인한 회원 정보를 가져오고, @PathVariable을 통해 현재 게시글에 대한 인덱스 정보를 통해 게시글 엔티티를 가져온다.
3. 게시글 엔티티와 로그인한 회원 정보를 토대로 댓글 작성 한다.
```
@PostMapping("/{freeBoardId}")
    public String comment(@PathVariable("freeBoardId") Long freeBoardId,
                          @Validated @ModelAttribute("freeCommentDto") FreeCommentDto freeCommentDto,
                          Principal principal) {

        FreeBoard one = freeBoardService.findOne(freeBoardId);
        Member member = principalService.findMember(principal);
        freeCommentService.saveComment(one, member, freeCommentDto);

        return "redirect:/freeBoard/" + freeBoardId;
    }
```
4. 삭제의 경우 현재 로그인한 회원의 정보와 댓글 작성자와 일치 할 경우 삭제 버튼이 보이게 되고, 버튼을 누르게 되면 해당 인덱스에 해당하는 댓글이 삭제된다.
```
<td><div th:if="${#authentication.name == Comments.getMember().getEmail()}">
  <button th:onclick="'deleteComment(' + ${Comments.getId()} + ',' + ${freeBoard.getId()} + ')'" class="comment-delete-button" >삭제</button>
</div></td>
```
```
@DeleteMapping("/{commentId}/delete")
    public ResponseEntity<String> delete(@PathVariable("commentId") Long commentId) {
        freeCommentService.deleteOne(commentId);
        return ResponseEntity.ok("삭제되었습니다.");
    }
```

## 4. 회원 이름, 비밀번호 변경
1. 마이페이지를 통해 회원의 이름, 비밀번호 변경이 가능하다. 마이페이지 버튼 또한 회원일 경우에만 필요한 버튼이기 때문에 역할이 검증된 회원에게만 보이도록 설정한다.
2. Principal 객체를 통해 로그인한 회원의 엔티티를 가져온다. 전달 받은 이름, 비밀번호의 정보로 변경한 뒤 DB에 다시 저장한다.
3. 회원 이름과 연관된 DB의 모든 데이터를 변경한다.
```
@PostMapping("/edit")
    public String editMember(@Validated @ModelAttribute("member") MemberEditFormDto memberEditFormDto, Principal principal) {

        Member member = principalService.findMember(principal);

        Member.editMember(member, memberEditFormDto, passwordEncoder);

        memberService.editMember(member);

        registreService.changeName(member.getId(), memberEditFormDto.getName());

        return "redirect:/";
    }
```
## 5. 장부, 게시판 검색
- 검색 조건은 동적 쿼리가 필요하기 때문에 Querydsl을 통해 원하는 원하는 검색 조건 쿼리를 작성한다.

1. 홈페이지 상단에 장부 검색 버튼을 누르게 되면 '[주소]/'의 경로로 입력된 데이터가 전달된다.
```
<div style="margin-right: 20px;">
  <form class="form-inline my-2 my-lg-0" th:action="@{/}" method="get">
    <input name="searchQuery" class="form-control mr-sm-2" type="search" placeholder="장부 검색" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</div>
```
2. / 경로로 데이터가 전달되면, 반환값이 Page<>인 getMainPage 메서드를 호출한다.
```
@GetMapping("/")
    public String main(RegistreSearchDto registreSearchDto, Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
        Page<Registre> mainPage = registreService.getMainPage(registreSearchDto, pageable);
        model.addAttribute("registreSearchDto", registreSearchDto);
        model.addAttribute("registres", mainPage);
        model.addAttribute("maxPage", 5);
        return "main";
    }
```
3. getMainPage는 Repository의 getRegistreList를 호출하게 되고, getRegistreList는 CustomRepository에 해당하고, 해당 커스텀 Repository는 Querydsl을 사용하여 동적 쿼리를 사용한다.
```
@RequiredArgsConstructor
public class RegistreRepositoryCustomImpl implements RegistreRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private BooleanExpression registreName(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null :
                QRegistre.registre.name.like("%" + searchQuery + "%");
    }

    @Override
    public Page<Registre> getRegistreList(RegistreSearchDto registreSearchDto, Pageable pageable) {

        QueryResults<Registre> registreQueryResults = jpaQueryFactory
                .selectFrom(QRegistre.registre)
                .where(registreName(registreSearchDto.getSearchQuery()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Registre> content = registreQueryResults.getResults();
        long total = registreQueryResults.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
```
4. JPAQueryFactory를 통해 Querydsl를 사용하며, BooleanExpression를 통해 쿼리 조건을 작성한다.
5. getRegistreList 메서드를 통해 원하는 동적 쿼리를 실행 시켜 원하는 조건의 데이터를 Page<>로 반환한다.
6. 위 코드의 경우 String 즉, 검색명이 전달되면 해당 이름이 포함되어 있는 장부(registre)를 검색하여 페이징 조건에 맞게 반환한다.
7. 페이징을 통해 각 페이지가 지정되어 있을 때 검색 조건이 유지 될 수 있도록 쿼리 파라미터로 검색어를 지속적으로 전달한다.
```
<input type="hidden" name="searchQuery" th:value="${registreSearchDto.searchQuery}">
```
8. 페이징 된 결과를 페이지별로 출력하고, 각 페이지 번호를 클릭하게 되면, 위의 hidden을 통해 입력된 검색 조건과, 페이지 번호가 / 경로의 GET 요청을 보내게 되고, 해당 요청을 받게 되면 위의 커스텀 Repository를 호출하는 방식을 반복하며 원하는 검색 조건을 유지하며 페이징된 결과를 보여준다.
```
<li class="page-item" th:classappend="${registres.number eq 0}?'disabled':''">
  <a th:href="@{'/' + '?searchQuery=' + ${registreSearchDto.searchQuery} + '&page=' + ${registres.number-1}}" aria-label='Previous' class="page-link">
    <span aria-hidden='true'>Previous</span>
  </a>
</li>
```
-  게시판 검색도 장부 검색과 동일한 방식으로 검색된다.

&nbsp;
# 개선 사항
  
## 1. 기능
1. 예외처리 부분에 있어서 부족한 부분이 많다. 기본적인 데이터 전달은 @Validation 같은 검증을 통해 사전 방지를 했지만, 그 외 사용자가 일으킬 수 있는 예외에 대한 처리가 필요해 보인다. 
## 2. 보안

## 3. 성능
1. 현재 하나의 서버에서 동작하는 프로젝트이기 때문에 추후에 사용자가 많아지게 되면, 서버를 여러대 돌릴 상황까지 고려해야 한다.
2. 추후 프록시 기술이나, redis 같은 동시성에 관련된 기술을 추가 하여 대용량 처리에 대해 대비해야 한다.
## 4. 코드
1. 코드 부분에서 Controller <-> Service <-> Repository 관계에서 데이터를 주고 받을 때 Controller <-> Service 간에 데이터를 주고 받을 때 엔티티가 직접 사용되는 코드가 부분 부분 있다. 엔티티가 직접 사용되는 부분이 없도록 수정해야 할 것 같다.
2. Controller 경로 명을 수정할 필요가 있다.(delete,edit과 같은 동사가 직접 사용되지 않도록 수정해야 한다.)
