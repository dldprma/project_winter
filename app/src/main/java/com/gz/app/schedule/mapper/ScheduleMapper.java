package com.gz.app.schedule.mapper;

import com.gz.app.schedule.vo.EventVo;
import com.gz.app.schedule.vo.PriorityVo;
import com.gz.app.schedule.vo.ScheduleVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    @Select("""
            SELECT
                NO AS ID
                , TITLE
                , START_DATE    AS "START"
                , FINISH_DATE   AS END
                , START_TIME
                , FINISH_TIME
                , DEL_YN
            FROM SCHEDULE
            WHERE DEL_YN = 'N'
            """)
    List<ScheduleVo> getEventList();

    @Insert("""
            INSERT INTO SCHEDULE
            (
                NO
                , WRITER_NO
                , TITLE
                , CONTENT
                , LOCATION
                , START_DATE
                , FINISH_DATE
                , START_TIME
                , FINISH_TIME
                , PRIORITY
            )
            VALUES
            (
                SEQ_SCHEDULE.NEXTVAL
                , 1
                , #{title}
                , #{content}
                , #{location}
                , #{startDate}
                , #{finishDate}
                , #{startTime}
                , #{finishTime}
                , #{priority}
            )
            """)
    int write(ScheduleVo vo);

    @Select("""
            SELECT
                S.NO
                , WRITER_NO
                , PRIORITY
                , P.NAME
                , TITLE
                , CONTENT
                , LOCATION
                , START_DATE
                , FINISH_DATE
                , START_TIME
                , FINISH_TIME
                , ALLDAY
                , ALM_TIME
                , SHARE_YN
                , DEL_YN
            FROM SCHEDULE S
            JOIN PRIORITY P ON (S.PRIORITY = P.NO)
            WHERE WRITER_NO = 1
                AND SHARE_YN = 'N'
                AND DEL_YN = 'N'
                        """)
    List<ScheduleVo> getSchVoList();

    @Select("""
            SELECT
                NO
                , WRITER_NO
                , PRIORITY
                , TITLE
                , CONTENT
                , LOCATION
                , START_DATE
                , FINISH_DATE
                , START_TIME
                , FINISH_TIME
                , SHARE_YN
                , DEL_YN
            FROM SCHEDULE
            WHERE WRITER_NO = 1
                AND NO = #{sno}
                AND SHARE_YN = 'N'
                AND DEL_YN = 'N'
            """)
    ScheduleVo getEventByNo(String sno);

    int changeEvent(ScheduleVo vo);

    @Update("""
            UPDATE SCHEDULE
                SET
                    DEL_YN = 'Y'
            WHERE NO = #{sno}
                AND WRITER_NO = 1
            """)
    int del(String sno);

    @Select("""
            SELECT
                NO
                , NAME
            FROM PRIORITY
            """)
    List<PriorityVo> getPriorityVoList();
}
