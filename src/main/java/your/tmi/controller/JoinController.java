package your.tmi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import your.tmi.dto.MemberDto;
import your.tmi.entity.Member;
import your.tmi.service.MemberService;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(@ModelAttribute("joinData") MemberDto memberDto){
        return "join";
    }

    //회원가입하기
    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("joinData") MemberDto memberDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        Member joinMember = memberDto.toMember(memberDto);
        memberService.save(joinMember);

        redirectAttributes.addAttribute("nickName", joinMember.getNickName());
        return "redirect:/login";
    }

    //닉네임 중복확인
    @PostMapping("/nickName")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> nicknameDuplicateCheck(String nickName) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        Integer count = memberService.countByNickName(nickName);

        if (count == 1) {
            resultMap.put("result", count);
        }

        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }



}
