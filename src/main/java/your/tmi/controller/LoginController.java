package your.tmi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import your.tmi.service.MemberService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(String error, Model model, HttpServletRequest request) {

        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("redirectURI", referer);

        if (error != null) {
            model.addAttribute("error", "아이디 비번 체크");
        }

        return "login";
    }


}
