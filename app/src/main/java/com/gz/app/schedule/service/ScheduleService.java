package com.gz.app.schedule.service;

import com.gz.app.schedule.mapper.ScheduleMapper;
import com.gz.app.schedule.vo.EventVo;
import com.gz.app.schedule.vo.PriorityVo;
import com.gz.app.schedule.vo.ScheduleVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleMapper mapper;

    public List<ScheduleVo> getEventList() {

        return mapper.getEventList();
    }

    public int write(ScheduleVo vo) {

        return mapper.write(vo);
    }

    public List<EventVo> getEventVoList() {


        List<ScheduleVo> schVoList = mapper.getSchVoList();
        List<EventVo> evtVoList = new ArrayList<>();
        for (int i = 0; i<schVoList.size(); i++){
            ScheduleVo schVo = schVoList.get(i);
            schVo.setStart(schVo.getStartDate() +"T"+ schVo.getStartTime()+":00");
//            schVo.setStart(schVo.getStartDate() +" "+ schVo.getStartTime());
            schVo.setEnd(schVo.getFinishDate() +"T"+ schVo.getFinishTime()+":00");

            EventVo evtVo = new EventVo();
            evtVo.setId(schVo.getNo());
            evtVo.setStart(schVo.getStart());
            evtVo.setEnd(schVo.getEnd());
            evtVo.setTitle(schVo.getTitle());
            evtVo.setPriority(schVo.getPriority());

            evtVoList.add(evtVo);
        }

        return evtVoList;
    }

    public ScheduleVo getEventByNo(String sno) {

        return mapper.getEventByNo(sno);
    }

    public int changeEvent(ScheduleVo vo) {
        return mapper.changeEvent(vo);
    }

    public int del(String sno) {
        return mapper.del(sno);
    }

    public List<PriorityVo> getPriorityVoList() {
        return mapper.getPriorityVoList();
    }
}
