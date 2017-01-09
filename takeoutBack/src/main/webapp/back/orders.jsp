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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="<%=basePath%>back/index.jsp">QK外卖 - 后台管理系统</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${sessionScope.manager["name"]} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="<%=basePath%>back/personal-info.jsp"><i class="fa fa-fw fa-user"></i>个人信息</a>
                        </li>
                        <li class="<%=basePath%>back/divider"></li>
                        <li>
                            <a href="<%=basePath%>logout.action"><i class="fa fa-fw fa-power-off"></i>退出登陆</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="<%=basePath%>back/personal-info.jsp"><i class="fa fa-fw fa-table"></i>个人信息</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>back/password.jsp"><i class="fa fa-fw fa-table"></i>修改密码</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>staffList.action"><i class="fa fa-fw fa-table"></i>员工管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>merchantList.action"><i class="fa fa-fw fa-table"></i>商家管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>riderList.action"><i class="fa fa-fw fa-table"></i>骑士管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>userList.action"><i class="fa fa-fw fa-table"></i>消费者管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>getOrderList.action" class="active"><i class="fa fa-fw fa-table"></i>订单管理</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            订单管理
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                        <form action="" class="form-group input-group" id="search-from-list">
                            <input type="text" class="form-control" name="id" placeholder="搜索相关订单">
                            <span class="input-group-btn"><button class="btn btn-default" type="button" onclick="submitForm()"><i class="fa fa-search"></i></button></span>
                        </form>
                    </div>
                    <div class="col-lg-12"></div>
                    <div class="col-lg-12">

                            <table class="table table-bordered table-striped" id="order_list_table">
                                <thead>
                                    <tr>
                                        <th class="orderId">订单号</th>
                                        <th class="sName">商家</th>
                                        <th class="sAddr">商家地址</th>
                                        <th class="sPhone">商家联系电话</th>
                                        <th class="uName">收货人</th>
                                        <th class="uAddr">收货地址</th>
                                        <th class="uPhone">消费者电话</th>
                                        <th class="rName">骑士</th>
                                        <th class="rPhone">骑士联系电话</th>
                                        <th class="status">状态</th>
                                        <th class="action"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderManagerList}" var="order" varStatus="status">
                                    <tr>
                                        <td class="orderId">${order.id}</td>
                                        <td class="sName">${order.merchantName}</td>
                                        <td class="sAddr">${order.merchantAddress}</td>
                                        <td class="sPhone">${order.merchantPhone}</td>
                                        <td class="uName">${order.receipterName}</td>
                                        <td class="uAddr">${order.receipterAddress}</td>
                                        <td class="uPhone">${order.receipterPhone}</td>
                                        <td class="rName">${order.riderName}</td>
                                        <td class="rPhone">${order.riderPhone}</td>
                                        <td class="status">${order.statusName}</td>
                                        <td class="action">
                                            <button type="submit" class="btn btn-default warning"><a href="<%=basePath%>cancelOrder.action?id=${order.id}" style="color: white">中止</a></button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=basePath%>resources/js/jquery.js"></script>
    <script src="<%=basePath%>resources/js/admin.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>resources/js/bootstrap.min.js"></script>

    <script src="<%=basePath%>resources/js/orders.js"></script>
</body>

</html>
