<!-- 
-@author T.Senna 4/11
-@author K.Mizuno 4/16
-@author T.Okamoto 4/20 
 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "ja">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>You just jewelry</title>
    <link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="stylecss/LoginError.css" rel="stylesheet">
	<link rel="shortcut icon" href="img/favicon.ico" />
  </head>

  <body>
    <div class="form-group" align="center">
    	<s:form action = "BackLoginAction">
      	<button type="submit" class="ghost-button action">
      	<span class="front">Login Error</span><span class="back">Back to Login</span></button>
      	</s:form>
    </div>

    <!--scriptタグ-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!--scriptタグ-->
  </body>
</html>
