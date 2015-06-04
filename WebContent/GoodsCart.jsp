<!--
-@author T.Senna
-@author Y.Matsukawa
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
		<link href="stylecss/GoodsCart.css" rel="stylesheet" />
		<link href="stylecss/jquery.bootgrid.min.css" rel="stylesheet" />
		<link href="stylecss/bootstrap-select.min.css" rel="stylesheet" />
		<link href="stylecss/strip.css" rel="stylesheet" />
		<link rel="shortcut icon" href="img/favicon.ico" />
	</head>

	<body>

		<img src="img/Logo1.png">
		<div class="lobtn">
			<div class="transition emb-floanime">
				<p>
					ようこそ
					<s:property value="#session.user_name" />
					さん
				</p>
			</div>
			<s:form action="LogoutAction">
				<s:token/>
				<button type="submit" class="btn btn-default">
					<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
					Log out
				</button>
			</s:form>
		</div>


		<div class="container">
			<!-- 商品テーブルここから -->
			<div>
			<div class="row">
				<div class="col-md-8">
					<div class="panel panel-default touka">
						<!--パネル-->
						<div class="panel-heading">ガイドツアーリスト</div>
						<table id="grid-basic" class="table">
							<thead>
								<tr>
									<th data-header-css-class="customerColumn" data-column-id="id">id</th>
									<th data-column-id="plans">Plans</th>
									<th data-header-css-class="customerColumn" data-column-id="fee">Fee</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="#session.ticket_info">
									<tr>
										<td><s:property value="%{ticketId}" /></td>
										<td><s:property value="%{ticketName}" /></td>
										<td><s:property value="%{price}" />円</td>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 商品テーブルここまで -->

				<!-- 商品カートここから -->
				<div class="col-md-4">
					<div class="panel panel-default touka">
						<div class="panel-heading">商品カート  ※1つの商品の上限は20枚です</div>
						<div class="panel-body">
							<!-- 商品サンプル -->
							<p>商品サンプル(ID)</p>
							<div class="btn-group" role="group" aria-label="...">
								<a type="button" class="btn btn-default strip"
									href="img/image1.jpg" data-strip-group-options="side: 'left'">1</a>
								<a type="button" class="btn btn-default strip"
									href="img/image2.jpg" data-strip-group-options="side: 'left'">2</a>
								<a type="button" class="btn btn-default strip"
									href="img/image3.jpg" data-strip-group-options="side: 'left'">3</a>
								<a type="button" class="btn btn-default strip"
									href="img/image4.jpg" data-strip-group-options="side: 'left'">4</a>
								<a type="button" class="btn btn-default strip"
									href="img/image5.jpg" data-strip-group-options="side: 'left'">5</a>
								<a type="button" class="btn btn-default strip"
									href="img/image6.jpg" data-strip-group-options="side: 'left'">6</a>
							</div>
							<br>
							<br>
							<s:form action="CartAddAction">
								<s:token/>
								<!-- 商品IDを決定するプルダウンメニュー -->
								<s:select name="ticketId" list="#session.ticket_info"
									listKey="%{ticketId}" listValue="%{ticketName}"
									cssClass="selectpicker" />

								<!-- 商品個数を決定するプルダウンメニュー -->
								<s:select name="ticketNumber" list="#session.numberList"
									cssClass="selectpicker" value="1" />

								<br>
								<s:property value="#session.error_msg"/>
								<br>

								<s:submit cssClass="btn btn-success" value="Buy">
								</s:submit>
							</s:form>
							<br> <br>
						</div>
					</div>
					<div class="panel panel-default touka">
						<div class="panel-heading">カート情報</div>
						<div class="panel-body">

							<s:if test="#session.totalTicket_count > 0">
							<s:form action = "GoOrderFormAction">
							<s:token/>
							<s:property value="#session.totalTicket_count" />
							枚<br>
							<s:property value="#session.totalCart_amount" />
							円<br>
							<input type="submit" value="購入手続きをする" class="btn btn-default">
							</s:form>
							<br> <br>
							<s:form action = "CartDeleteAction">
							<s:token />
							<input type="submit" value="カートを空にする" class="btn btn-default">
							</s:form>
							</s:if><s:else>現在：カートにチケットはありません</s:else>
						</div>
					</div>
				</div>
				<!-- 商品カートここまで -->
			</div>
			<!-- div row -->
		</div></div>
		<!-- div container -->

		<!--scriptタグここから-->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
		<script src="js/jquery.bootgrid.min.js"></script>
		<script src="js/bootstrap-select.min.js"></script>
		<script src="js/strip.pkgd.min.js"></script>

		<!-- テーブル用タグ -->
		<script>
			$(function() {
				$("#grid-basic").bootgrid();
			});
		</script>

		<!-- セレクトタグ用 -->
		<script type="text/javascript">
			$('.selectpicker').selectpicker({
				style : 'btn-default',
				size : 3
			});
		</script>


		<!--scriptタグここまで-->


		<!-- bodyここまで -->
	</body>
</html>