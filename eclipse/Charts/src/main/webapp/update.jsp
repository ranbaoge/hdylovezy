<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改书籍信息</title>
</head>
<body>
    <form action="save" method="post">
        <span>书籍ID:</span><input type="text" name="id" value="<%=request.getParameter("id")%>" readonly="readonly">
        <span>书籍名称:</span><input type="text" name="name"><br>
        <span>书籍作者:</span><input type="text" name="author"><br>
        <span>出版社:</span><input type="text" name="publisher"><br>
        <span>出版时间:</span><input type="text" name="publishDate"><br>
        <span>书籍价格:</span><input type="text" name="price"><br>
        <span>书籍类型:</span>
        <select name="cid">
            <option value="1">计算机类</option>
            <option value="2">文学类</option>
            <option value="3">艺术类</option>
            <option value="4">天文科学</option>
            <option value="5">武侠小说</option>
        </select><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>