<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ItcastOA</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<frameset rows="100,*,25" framespacing="0" border="0" frameborder="0">
    <frame src="../top.jsp" name="TopMenu"  scrolling="no" noresize />
    <frameset cols="180,*" id="resize">
        <frame noresize name="menu" src="../left.jsp" scrolling="yes" />
        <frame noresize name="right" src="../right.jsp" scrolling="yes" />
    </frameset>
    <frame noresize name="status_bar" scrolling="no" src="../bottom.jsp" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>