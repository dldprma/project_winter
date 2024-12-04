<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script defer src="/js/schedule/edit.js"></script>
<link rel="stylesheet" href="/css/schedule/edit.css">
<title>FRESH WAVE</title>
</head>
<body>
        <main>
            <form action="/schedule/edit" method="post">
                <input type="hidden" name="no" value="${vo.no}">
                <input type="text" name="title" value="${vo.title}">
                <input type="date" name="startDate" value="${vo.startDate}">
                <input type="time" name="startTime" value="${vo.startTime}">
                <input type="date" name="finishDate" value="${vo.finishDate}">
                <input type="time" name="finishTime" value="${vo.finishTime}">
                <br>
                <textarea name="content" value="${vo.content}"></textarea>
                <input type="submit" value="수정하기">
            </form>
        </main>

</body>
</html>