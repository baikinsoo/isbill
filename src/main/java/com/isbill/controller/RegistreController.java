package com.isbill.controller;

import com.isbill.domain.Member;
import com.isbill.dto.RegistreBillDto;
import com.isbill.dto.RegistreFormDto;
import com.isbill.repository.MemberRepository;
import com.isbill.service.RegistreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RegistreController {
}
