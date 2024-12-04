package com.gz.app.schedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gz.app.schedule.service.ScheduleService;
import com.gz.app.schedule.vo.EventVo;
import com.gz.app.schedule.vo.PriorityVo;
import com.gz.app.schedule.vo.ScheduleVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("schedule")
public class ScheduleController {

    private final ScheduleService service;
    private final ObjectMapper objectMapper;

    // 홈화면
    @GetMapping("home")
    public void home(){

    }

    // ajax 통신(이벤트)
    @PostMapping("event")
    @ResponseBody
    public List<EventVo> event(HttpSession session) {

        List<EventVo> evtVoList = service.getEventVoList();

        return evtVoList;
    }

    // 일정 작성하기 화면
    @GetMapping("write")
    public String write(HttpSession session, Model model){
//        if(session.getAttribute("loginMemberVo") == null){
//            return "redirect:/member/login";
//        }
        List<PriorityVo> priorityVoList = service.getPriorityVoList();
        model.addAttribute("priorityVoList", priorityVoList);

        return "schedule/write";
    }

    // 일정 작성하기 프로세스
    @PostMapping("write")
    public String write(ScheduleVo vo, HttpSession session){

        int result = service.write(vo);

        if(result < 0){
            throw new IllegalStateException("작성하기 오류 발생");
        }
        return "redirect:/schedule/home";
    }

    // 상세조회
    @GetMapping("detail")
    @ResponseBody
    public ScheduleVo detail(String sno, HttpSession session, Model model){

        ScheduleVo vo = service.getEventByNo(sno);
        model.addAttribute("vo", vo);

        return vo;
    }

    // 일정 수정 화면
    @GetMapping("edit")
    public String edit(Model model, String sno){

        ScheduleVo vo = service.getEventByNo(sno);

        return "schedule/edit";
    }

    // 일정 수정 프로세스
    @PostMapping("edit")
    public String edit(ScheduleVo vo, HttpSession session){

        int result = service.changeEvent(vo);

        System.out.println("vo = " + vo);

        if(result != 1){
            throw new IllegalStateException();
        }
        return "redirect:/schedule/home";
    }

    // 일정 삭제 (ajax)
    @GetMapping("del")
    public String del(String sno){
        int result = service.del(sno);

        if(result != 1){
            throw new IllegalStateException();
        }

        return "redirect:/schedule/home";
    }


}
