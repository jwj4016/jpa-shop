package com.example.jpashop.web;

import com.example.jpashop.domain.Address;
import com.example.jpashop.domain.Member;
import com.example.jpashop.service.ItemService;
import com.example.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    final private MemberService memberService;
    final private ItemService itemService;

    @RequestMapping(value = "/members/new", method = RequestMethod.GET)
    public String createForm() {
        return "members/createMemberForm";
    }

    @RequestMapping(value = "/members/new", method = RequestMethod.POST)
    public String create(Member member, String city, String street, String zipcode) {
        Address address = new Address(city, street, zipcode);
        member.setAddress(address);
        memberService.join(member);
        return "redirect:/";
    }

     @RequestMapping(value = "/members", method = RequestMethod.GET)
     public String list(Model model) {
         List<Member> memberList = memberService.findMembers();
         model.addAttribute("memberList", memberList);
         return "members/memberList";
     }

    // /members?page=0&size=20&sort=name,desc&sort=address.city
    /*
    @RequestMapping(value = "/membersPage", method = RequestMethod.GET)
    public String list(@PageableDefault(size = 11, sort = "name", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Member> page = memberService.findMembers(pageable);
        model.addAttribute("memberList", page.getContent());
        return "members/memberList";
    }
    */


    /* 페이징 정보가 둘 이상일 경우.
        public String list(
            @Qualifier("member") Pageable memberPageable
            , @Qualifier("order") Pageable orderPageable
            , ...)

        request : /members?member_page=0&order_page=1


     */
}
