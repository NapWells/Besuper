<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html lang="en">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QK外卖 - 后台管理系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>resources/css/admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>resources/myJs/login.js" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="grey">

    <div id="">
        <div id="login-form" class="">
            <h3 class="col-lg-10">QK外卖</h3>
            <form method="post" id="loginForm">
                <table>
                    <tr class="form-group">
                        <td><label>用户ID</label></td>
                        <td><input class="form-control" name="id"></td>
                        <td rowspan="2">
                            <a href="javascript:void(0)" id="login" >
                                <%--onclick="loginFunction('<%=basePath%>')"--%>
                                <i class="fa fa-chevron-circle-right login-button"></i>
                            </a>
                        </td>
                    </tr>
                    <input type="hidden" name="path" value="<%=basePath%>">
                    <tr class="form-group">
                        <td>密码</td>
                        <td><input class="form-control" type="password" name="password"></td>
                    </tr>
                </table>
                    
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=basePath%>resources/js/jquery.js"></script>
    <script src="<%=basePath%>resources/js/admin.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>resources/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>resources/js/login.js"></script>

</body>

</html>
