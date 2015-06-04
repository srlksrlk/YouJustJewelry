<!--
-@author Y.Matsukawa 4/15
-@author T.Senna
-@author K.Mizuno
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>You Just Jewelry</title>
<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="stylecss/OrderForm.css" rel="stylesheet">
<link href="stylecss/jquery.bootgrid.min.css" rel="stylesheet" />
<link href="stylecss/bootstrap-select.min.css" rel="stylesheet" />
<link href="stylecss/strip.css" rel="stylesheet" />
<link rel="shortcut icon" href="img/favicon.ico" />
</head>
<body>

	<div class="container" align="center">
		<div class="panel panel-default touka2">
			<div class="panel-heading">購入商品一覧</div>

			<!-- テーブル -->
			<table class="table">
				<thead>
					<tr>
						<th>プラン名</th>
						<th>単価</th>
						<th>購入枚数</th>
						<th>プランごとの小計</th>
						<th>枚数変更</th>
					</tr>
				</thead>
				<!-- 前のページから引っ張ってくる -->
				<tbody>
					<s:iterator value="#session.order_info">
						<tr>
							<td><s:property value="%{ticketName}" /></td>
							<td><s:property value="%{price}" /></td>
							<td><s:property value="%{ticketCount}" /></td>
							<td>¥<s:property value="%{totalAmount}" /></td>
							<td><s:form action="OrderChange">
									<s:hidden name="ticketId" value="%{ticketId}" />
									<s:hidden name="ticketName" value="%{ticketName}" />
									<s:hidden name="price" value="%{price}" />
									<s:hidden name="ticketCount" value="%{ticketCount}" />
									<s:hidden name="totalAmount" value="%{totalAmount}" />
									<input type="submit" class="btn btn-primary" value="枚数変更" />
									<s:select name="ticketNumber" list="#session.numberList"
										class="selectpicker" value="1" />

								</s:form></td>
							<td><s:form action="DeleteTicketCount">
									<s:hidden name="ticketId" value="%{ticketId}" />
									<input type="submit" class="btn btn-primary" value="削除" />
								</s:form></td>
						</tr>

					</s:iterator>

				</tbody>

			</table>
		</div>
	</div>
	<div align="center">
		<p align="right">
			<b>現在の小計は<s:property value="#session.totalCart_amount" />円です。
			</b>
		</p>
		<s:form action="ConfirmedAction">
			<s:token />
			<input class="btn btn-default" type="submit" name="button"
				value="　　購入　　">
		</s:form>
		<br>
		<s:form action="BackCartAction">
			<s:token />
			<input class="btn btn-default" type="submit" name="button"
				value="一覧に戻る">
		</s:form>
	</div>

	<!--scriptタグ-->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
	<script src="js/jquery.bootgrid.min.js"></script>
	<script src="js/bootstrap-select.min.js"></script>
	<script src="js/strip.pkgd.min.js"></script>

	<script type="text/javascript">
		 $('.selectpicker').selectpicker({
		      style: 'btn-default',
		      size: 5,
		      width:60
		  });
		</script>
	<!--scriptタグここまで-->
</body>
</html>
