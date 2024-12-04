<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- fullCalendar -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<!-- bootStrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- home.js -->
<script defer src="/js/schedule/home.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/schedule/home.css">

<title>FRESH WAVE</title>
</head>
<body>
        <main>
            <div id='calendar'></div>  
        </main>

<!-- Button trigger modal -->
  <!-- Modal -->
<div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addModalLabel">일정 추가하기</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="text" id="calTitle" name="title" placeholder="일정 제목을 입력해주세요!">
                <br>
                <input type="date" id="calStartDate" name="startDate">
                <div class="faildate-msg1">시작일을 선택해주세요.</div>
                <input type="time" id="calStartTime" name="startTime">
                <p>-</p>
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
                <input type="text" name="userAdd">
                <br>
                <textarea name="content" id="calContent" placeholder="내용을 입력해주세요."></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="close-btn" data-bs-dismiss="modal">Close</button>
                <button type="button" class="save-btn">Save changes</button>
            </div>
        </div>
    </div>
</div>

  <!-- Modal -->
  <div class="modal fade" id="detailModal" tabindex="-1" aria-labelledby="detailModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="detailModalLabel">일정 상세조회</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body" id="detail-body">
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <button type="button" class="edit-btn" onclick="changeEvent(this);">수정하기</button>
            <button type="button" class="del-btn" onclick="delEvent(this);">삭제하기</button>
            <button type="button" class="save-btn">Save changes</button>
        </div>
      </div>
    </div>
  </div>

</body>
</html>