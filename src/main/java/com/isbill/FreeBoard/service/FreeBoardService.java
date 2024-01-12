package com.isbill.FreeBoard.service;

import com.amazonaws.services.s3.AmazonS3;
import com.isbill.FreeBoard.infrastructure.FreeBoard;
import com.isbill.Member.infrastructure.Member;
import com.isbill.FreeBoard.domain.FreeBoardFormDto;
import com.isbill.FreeBoard.domain.FreeBoardSearchDto;
import com.isbill.FreeBoard.infrastructure.FreeBoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class FreeBoardService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;
    private final FreeBoardRepository freeBoardRepository;

    public void saveContent(FreeBoardFormDto freeBoardFormDto, Member member, String Url) {

        MultipartFile attachFile = freeBoardFormDto.getAttachFile();
        String originalFilename = attachFile.getOriginalFilename();

        FreeBoard freeBoard = new FreeBoard();
        freeBoard.setTitle(freeBoardFormDto.getTitle());
        freeBoard.setContent(freeBoardFormDto.getContent());
        freeBoard.setMember(member);
        freeBoard.setAWSUrl(Url);
        freeBoard.setImgName(originalFilename);

        freeBoardRepository.save(freeBoard);
    }

    public List<FreeBoard> findAll() {
        return freeBoardRepository.findAll();
    }

    public FreeBoard findOne(Long id) {
        return freeBoardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void delete(Long id) {
        freeBoardRepository.deleteById(id);
    }

    public void editContent(FreeBoard freeBoard, FreeBoardFormDto freeBoardFormDto, String url) {

        if (url != null) {
            MultipartFile attachFile = freeBoardFormDto.getAttachFile();
            String originalFilename = attachFile.getOriginalFilename();
            freeBoard.setImgName(originalFilename);
            freeBoard.setAWSUrl(url);
        }
        freeBoard.setTitle(freeBoardFormDto.getTitle());
        freeBoard.setContent(freeBoardFormDto.getContent());

        freeBoardRepository.save(freeBoard);
    }

//    페이징만을 위한 코드
    public Page<FreeBoard> pagingFindAll(Pageable pageable) {
        return freeBoardRepository.findAll(pageable);
    }

    //    페이징 및 검색을 위한 코드
    public Page<FreeBoard> getFreeBoardPage(FreeBoardSearchDto freeBoardSearchDto, Pageable pageable) {
        return freeBoardRepository.getFreeBoardList(freeBoardSearchDto, pageable);
    }

    @Transactional
    public FreeBoard deleteUrl(FreeBoard freeBoard) {

        freeBoard.setImgName("이미지 파일을 선택해주세요");
        freeBoard.setAWSUrl(null);
        return freeBoardRepository.save(freeBoard);
    }
}
