package your.tmi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import your.tmi.paging.RequestPageSortDto;
import your.tmi.service.MemberService;
import your.tmi.service.TmiService;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DetailController {

    private final MemberService memberService;
    private final TmiService tmiService;

    //디테일
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model,
                         RequestPageSortDto requestPageDto){
        model.addAttribute("member",memberService.getInfo(id));

        //tmi 페이징
        Pageable pageable = requestPageDto.getPageableSort();
        model.addAttribute("tmi",tmiService.getTmi(pageable, id));

        return "detail";
    }

    //마이페이지
    @GetMapping("/myPage/{id}")
    public String myPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("member",memberService.getInfo(id));

        return "myPage";
    }

    //tmi저장
    @PostMapping("/addTmi/{id}")
    public String addTmi(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        String text = request.getParameter("text");
        tmiService.addTmi(text,id);

        return "detail :: #list-table";
    }

    //tmi 삭제
    @DeleteMapping("/deleteTmi/{tno}")
    public String remove(@PathVariable("tno") Long tno, Model model,
                         HttpServletRequest request, RequestPageSortDto requestPageDto) {
        tmiService.removeTmi(tno);

        Long id = Long.valueOf(request.getParameter("id"));

        Pageable pageable = requestPageDto.getPageableSort();
        model.addAttribute("tmi",tmiService.getTmi(pageable, id));

        return "detail :: #list-table";
    }


}
