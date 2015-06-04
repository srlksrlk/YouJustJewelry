<!--
-@author T.Okamoto
-@author T.Sennna 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>You Just Jewelry</title>

	<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="stylecss/End.css" rel="stylesheet">
	<link rel="shortcut icon" href="img/favicon.ico" />
	</head>
	<body>
		<div class="form-group" align="center">
			<font size="4">
	    		<ul class="typing">
	        	<li>Thank you for your shopping! & please come again :)</li>
	        	</ul><br><br>
	    	</font>


	      	<br><br><br><br><br><br><br>
	      	<div class="form-group" align="center">
		    	<s:form action="LogoutAction">
		    	<s:token/>
		      	<button type="submit" class="ghost-button action">
		      	<span class="front">LogOut</span><span class="back">Back to Login</span></button>
		      	</s:form>
		    </div>

		<!--scriptタグ-->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	    <script src="js/bootstrap.min.js"></script>
	    <script src="js/jquery.js"></script>
		<script src="js/inewsticker.js"></script>
	    <script>
			$(document).ready(function() {
				$('.typing').inewsticker({
					speed           : 100,
					effect          : 'typing',
					dir             : 'ltr',
					font_size       : 30,
					color           : '#000000',
					font_family     : 'arial',
					delay_after : 1000,
				});
			});
		</script>
	   	<!--scriptタグ-->
	</body>
</html>