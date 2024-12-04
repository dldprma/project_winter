<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script defer src="/js/schedule/write.js"></script>
<link rel="stylesheet" href="/css/schedule/write.css">
<title>FRESH WAVE</title>
</head>
<body>
        <main>
            <form action="/schedule/write" method="post">
                <input type="text" id="calTitle" name="title" placeholder="일정 제목을 입력해주세요!">
                <br>
                <input type="date" id="calStartDate" name="startDate">
                <div class="faildate-msg1">시작일을 선택해주세요.</div>
                <input type="time" id="calStartTime" name="startTime">
                <span>-</span>
                <input type="date" id="calEndDate" name="finishDate">
                <div class="faildate-msg2">종료일을 선택해주세요.</div>
                <div class="faildate-msg3">종료일이 시작일보다 빠릅니다. 일정을 다시 선택해주세요.</div>
                <input type="time" id="calEndTime" name="finishTime">
                <br>
                <input type="text" name="location" placeholder="주소를 입력해주세요.">
                <br>
                <label>중요도 : </label>
                <select name="priority">
                    <c:forEach items="${priorityVoList}" var="priorityVo">
                        <option value="${priorityVo.no}">${priorityVo.name}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="text" name="userAdd" placeholder="사용자 추가">
                <br>
                <textarea name="content" id="calContent" placeholder="내용을 입력해주세요."></textarea>
                <input type="submit" value="작성하기">
            </form>
        </main>

</body>
</html>