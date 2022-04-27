package your.tmi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import your.tmi.dto.search.SearchCondition;
import your.tmi.dto.search.SearchType;
import your.tmi.paging.RequestPageSortDto;
import your.tmi.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SearchController {

    private final MemberService memberService;

    //검색
    @PostMapping({"","/"})
    public String searchList(@RequestParam(value = "searchType", required = false) SearchType searchType,
                             @RequestParam(value = "keyword", required = false) String keyword,
                             RequestPageSortDto requestPageDto, Model model) {

        searchDayList(requestPageDto, model, searchType, keyword);
        return "redirect:/pages/list";
    }

    //검색 후 리스트
    @GetMapping("/list")
    public String list(RequestPageSortDto requestPageDto, Model model,
                       SearchType searchType, String keyword) {

        searchDayList(requestPageDto, model, searchType, keyword);
        return "pages/list";

    }

    //검색 페이징
    private void searchDayList(RequestPageSortDto requestPageDto, Model model, SearchType searchType, String keyword) {

        Pageable pageable = requestPageDto.getPageableSort(Sort.by("month").descending());

        model.addAttribute("searchType", searchType);
        model.addAttribute("keyword", keyword);

        if (searchType != null) {
            model.addAttribute("search", memberService.searchDay(pageable, new SearchCondition(keyword, searchType)));
        }
    }

}
