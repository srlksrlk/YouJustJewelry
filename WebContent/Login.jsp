<!--
-@author T.Okamoto 04/16
-@author T.Senna 04/16
-@author K.Mizuno 04/16
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<! DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>You just jewelry</title>
		<link href="stylecss/Login.css" rel="stylesheet">
		<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="stylecss/darktooltip.css" rel="stylesheet">
		<link href="stylecss/data-tip.css" rel="stylesheet">
		<link rel="shortcut icon" href="img/favicon.ico" />
		<script src="js/jquery-1.11.2.js"></script>
		<script src="js/jquery.darktooltip.min.js"></script>
		<script>
			$(document).ready( function(){
				$('#def').darkTooltip();
				$('#def-html').darkTooltip({
			   		opacity:1,
			   		gravity:'west'
			  });
			});
		</script>
	</head>
	<body>

	    <!-- bodyここから -->
			<img class="anime" src="img/Title.png">

		<!-- 右上のボタン -->
		<div class="twitter-button">
			<s:form action="TransitionAction" cssClass="form-horizontal">
			<div id="example" data-tooptip="Hello!"><s:submit  class="ghost-button" value="    New Sign in     " /> </div>
 			
			</s:form>
			<s:form action="GoTwitterAction">
				<s:submit class="ghost-button" value=" Login on Twitter " />
			</s:form>
	</div>

		<!-- 下のログインフォーム -->
		<div class="input">
			<div class="row">
				<div class="col-sm-12">
					<div align="center">
						<s:form action="LoginAction">
						<s:token/>
							<!-- forms start-->
							<div class="form-group loginForm">
								<div data-tip="IDかアドレスを入れてね！">
									<input name="email_id" value="<s:property value="email_id" />"
									class="form-control"placeholder="Email or ID" 
									required pattern="\w{4,30}" maxlength="30"
									title="半角英数字 4文字以上30文字以内です。"/>/>

								</div>
								<div data-tip="パスワードを入れてね！">
									<input name="pass" value="<s:property value="pass" />" class="form-control"
									placeholder="Password"  type="Password"
									pattern="^(?=.*[0-9])(?=.*[a-z])[0-9a-z\-]{6,30}$" maxlength="30"
									title="6文字以上30文字以内。半角英数混在必須です。"/>
								</div>
							</div>
							<!-- forms end-->


							<!-- Loginボタンここから -->
							<div class="form-group">
								<s:submit class="ghost-button" value="  Login  "
									align="center" />
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
		<!-- bottomと接続 -->
		<!-- 下のログインフォームここまで -->

</body>
</html>