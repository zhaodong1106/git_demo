<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script src="http://bootboxjs.com/bootbox.js"></script>
<script>
	$(function() {
		$("#testJson").click(function() {
			var url = this.href;
			var args = {};
			$.post(url, args, function(data) {
				for ( var i = 0; i < data.length; i++) {
					var userId = data[i].userId;
					var lastName = data[i].userName;
					alert(userId + ":" + lastName);

				}
			});
			return false;
		});
		$("#submit").click(function() {
			var url = "jsonReturnUser";
			var args = {
				userId : function() {
					return $("#userId").val();
				}
			};
			$.post(url, args, function(data) {
				for ( var i = 0; i < data.length; i++) {
					alert(data[i].userId + ":" + data[i].userName);
				}

			});

		});
		$("#testValidate").bootstrapValidator({
			
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
                userName: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '用户名不能为空'
                        },
                        stringLength: {/*长度提示*/
                            min: 2,
                            max: 30,
                            message: '用户名长度必须在6到30之间'
                        },
                        regexp: {
                         regexp: /^[a-zA-Z0-9_\.]+$/,
                         message: '用户名由数字字母下划线和.组成'
                     },
                         threshold :  6 ,
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}  
                         url: 'checkNameValidate',//验证地址
                         message: '用户已存在',//提示消息
                         //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                         type: 'POST'//请求方式
                    }
                    }
                },
                userPassword: {
                    message:'密码无效',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 30,
                            message: '用户名长度必须在6到30之间'
                        }
                    }
                },
                userEmail: {
                    validators: {
                        notEmpty: {
                            message: 'The email address is required and can\'t be empty'
                        },
                        emailAddress: {
                            message: 'The input is not a valid email address'
                        }
                    }
                }
            }

		});
		$("#submit1").click(function() {
			bootbox.dialog({
				message : "确定登录吗？傻逼",
				title : "登录窗口",
				buttons : {
					Cancel : {
						label : "取消",
						className : "btn-default",
						callback : function() {
							alert("Cancel");
						}
					},
					OK : {
						label : "确定",
						className : "btn-primary",
						callback : function() {
							$("#testValidate").submit();
						}
					}
				}
			});
		});
	});
</script>
</head>

<body>
	This is my JSP page.
	<br>
	<br>
	<a href="listAll?id=3">listAll</a>
	<a href="showUserAll?pageSize=3">showUserAll</a>
	<a href="studentInsert">studentInsert</a>
	<br>
	<a href="showClassAll">showClassAll</a>
	<br>
	<a href="testJson" id="testJson">test Json</a>
	<br>
	<input type="text" id="userId" />
	<br>
	<input type="button" value="submit" id="submit" />
	<form action="testUpload" enctype="multipart/form-data" method="post">
		file:<input name="file" type="file" /> desc:<input name="desc"
			type="text" /> <input type="submit" value="上传" />
	</form>
	<form id="testValidate" action="testValidate" method="post" role="form" class="form-horizontal">
		<div class="form-group">
		<label for="userName" class="col-sm-1 control-label">用户名</label>
		<div class="col-sm-3">
		<input id="userName" name="userName" type="text" class="form-control"  placeholder="请输入用户名" />
		</div>
		</div>
		<div class="form-group">
		<label for="userPassword" class="col-sm-1 control-label">密码</label>
		<div class="col-sm-3">
		<input id="userPassword" name="userPassword" type="password" class="form-control"  placeholder="请输入密码" />
		</div>
		</div>
		<div class="form-group">
		<label for="userEmail" class="col-sm-1 control-label">邮箱</label>
		<div class="col-sm-3">
		<input id="userEmail" name="userEmail" type="text" class="form-control"  placeholder="请输入邮箱" />
		</div>
		</div>
		<div class="form-group">
		
		<div class="col-sm-offset-1 col-sm-1">
		<button id="submit1"  type="submit" class="btn btn-info"    onclick="return false;">登录</button>
		</div>
		</div>

	</form>
	<a href="testDownload">testDownload</a>
</body>
</html>
