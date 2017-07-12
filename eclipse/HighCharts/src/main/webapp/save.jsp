<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存书籍信息</title>
</head>
<body>
    <form action="save" method="post">
        <span>书籍名称:</span><input type="text" name="name"><br>
        <span>书籍作者:</span><input type="text" name="author"><br>
        <span>出版社:</span><input type="text" name="publisher"><br>
        <span>出版时间:</span><input type="text" name="publishDate"><br>
        <span>书籍价格:</span><input type="text" name="price"><br>
        <span>书籍类型:</span>
        <select name="cid">
            <option value="1">文学类</option>
            <option value="2">计算机类</option>
            <option value="3">天文科学类</option>
            <option value="4">历史类</option>
            <option value="5">生物类</option>
            <option value="6">外语类</option>
            <option value="7">艺术设计类</option>
        </select><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>