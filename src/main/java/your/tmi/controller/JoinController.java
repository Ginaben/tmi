package your.tmi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import your.tmi.dto.MemberDto;
import your.tmi.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String join(@ModelAttribute("joinData") MemberDto memberDto){
        return "join";
    }

    @PostMapping("/join")
    public String join(@Validated @ModelAttribute("joinData") MemberDto memberDto, BindingResult bindingResult) {
        Long id = memberService.save(memberDto.getUsername(), memberDto.getPassword(), memberDto.getRePassword(), memberDto.getNickName(),
                memberDto.getMonth(), memberDto.getDay());
        return "redirect:/";
    }


}
