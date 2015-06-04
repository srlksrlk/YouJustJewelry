<!--
-@author Y.Narita 4/11
-@author K.Mori 4/11
-@author T.Senna 4/11
-@version 1.0
-
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> -->
<!DOCTYPE html>

	<html lang="ja">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>NewSignin</title>
		<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="stylecss/NewCustomer.css" rel="stylesheet">
		<link href="stylecss/jquery.bootgrid.min.css" rel="stylesheet" />
		<link href="stylecss/bootstrap-select.min.css" rel="stylesheet" />
		<link rel="shortcut icon" href="img/favicon.ico" />
		<link href="stylecss/data-tip.css" rel="stylesheet" />

		<!-- scriptタグここから  -->
		<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>
		<script src="js/jquery.dateselector.js"></script>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
		<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
		<script src="js/adjustAjaxZip3.js"></script>
		<script src="js/lengthChecks.js"></script>
		<script type="text/javascript">
		$(function() {
		$.datepicker.setDefaults( $.datepicker.regional[ "ja" ] );
		$( "#datepicker" ).datepicker({
	        changeYear: true,
			showMonthAfterYear: true,
		    dateFormat:'yy/mm/dd',
		    monthNames:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
		    maxDate: '+0d',
			});
		$("#datepicker").datepicker("setDate", "1985/01/01");
		});
		
		</script>
		<!-- scriptタグここまで  -->

	</head>

    <body>
  <!-- タイトル -->
  			<div align="center">
  				<h2>新規登録</h2><br><br>
  			</div>
		<s:form action = "NewCustomerAction" method="post" name="entry">
		<s:token/>


		  <!-- ID重複時のエラー表示 -->
		<div class="noticeFont">
			<s:property value="notice"/><br>
		</div>

  <!--ユーザーID入力-->
  <!-- <form role="form"> -->
  				<div class="container">
  					<div class="row">
  						<div class="col-xs-3 col-xs-push-1">
  							<div class="form-group">
  					  			<label for="id">ユーザーID</label>
  					  			<font size="3" color="#ff0000"><b>*</b></font>
								<div data-tip="半角英数字4~30文字以内">
									<input name="userId" value="<s:property value="userId" />" class="form-control"
									placeholder="hogehoge" required pattern="\w{4,30}" onkeyup="passwordLengthCheck();"
									title="半角英数字 4～30文字以内でお願いします。"/>
								</div>
  							</div>
  						</div>
  					</div>
  				</div>

  <!--姓名入力-->

  				<div class="container">
  					<div class="row">
  						<div class="col-xs-3 col-xs-push-1">
  							<div class="form-group">
  					  		<label for="lastname">姓</label>
  					  		  	<font size="3" color="#ff0000"><b>*</b></font>
								<div data-tip="全角半角30文字以内">
									<input name="lastName" value="<s:property value="lastName" />" class="form-control input-sm"
									placeholder="姓" required pattern="\S{1,30}" onkeyup="passwordLengthCheck();"
									title="スペース無し、30文字以内でお願いします。"/>
  								</div>
  							</div>
  						</div>
  						<div class="col-xs-3 col-xs-push-1">
  					  	<div class="form-group">
  								<label for="firstname">名</label>
  					  		  	<font size="3" color="#ff0000"><b>*</b></font>
								<div data-tip="全角半角30文字以内">
	  								<input name="firstName" value="<s:property value="firstName" />" class="form-control input-sm"
	  								placeholder="名" required pattern="\S{1,30}" onkeyup="passwordLengthCheck();"
	  								title="30文字以内でお願いします。"/>
  								</div>
  							</div>
  						</div>
  					</div>
  				</div>



  <!--sex-->
  					<div class="form-group">
	  						<div class="container">
	  							<div class="row">
	  								<div class="col-xs-3 col-xs-push-1">
	  									<p class="control-label"><b>性別</b></p>
	  									<div class="radio-inline">
	  										<input type="radio" value="0" name="gender" id="man" required>
	  										<label for="man">男性</label>
	  									</div>
	  								</div>
	  							</div>
	  						</div>
	  						<div class="container">
	  							<div class="row">
	  								<div class="col-xs-3 col-xs-push-1">
	  									<div class="radio-inline">
	  										<input type="radio" value="1" name="gender" id="woman" required>
	  										<label for="woman">女性</label>
	  									</div>
	  								</div>
	  							</div>
	  						</div>
  					</div>



  <!--生年月日-->
  					<div class="container">
  						<div class="row">
  							<div class="col-xs-3 col-xs-push-1">
  								<label for="date">生年月日</label>
  								<font size="3" color="#ff0000"><b>*</b></font>
  								<div id="content">
  									<div data-tip="クリックして選択">
	 									<p><input type="text" id="datepicker"  name="birthday" readonly="readonly"
	 									value="<s:property value="birthday" />" class="form-control" required ></p>
									</div>
  								</div>
  							</div>
  						</div>
  					</div>

<!-- 郵便番号 -->
  						<div class="container">
  							<div class="row">
  								<div class="col-xs-3 col-xs-push-1">
  									<div class="form-group">
  										<label for="address-number">郵便番号</label>
  										<font size="3" color="#ff0000"><b>*</b></font>
  										<div data-tip="半角数字7桁(ハイフン可)">
	  										<input name="zipcode" value="<s:property value="zipcode" />" class="form-control"
	  										placeholder="100-0011" maxlength="8"
	  										onclick="formClear();" required onKeyUp="backSpaceClear();"
	  										 pattern="\d{3}-?\d{4}" title="半角数字7桁でお願いします。例：000-0000、0000000"/>
  										</div>
  									</div>
  								</div>
  							</div>
  						</div>

<!--住所-->
  						<div class="container">
  							<div class="row">
  								<div class="col-xs-5 col-xs-push-1">
  									<div class="form-group">
  										<label for="address">都道府県</label>
  										<font size="3" color="#ff0000"><b>*</b></font>
										<div data-tip="自動入力されます。"> 
	  										<input name="prefecture" value="<s:property value="prefecture" />" class="form-control" required
	  										pattern=".{1,10}" onkeyup="passwordLengthCheck();" title="自動入力されます。" readonly/>
  										</div>
  									</div>
  								</div>
  							</div>
  						</div>

  						<div class="container">
  							<div class="row">
  								<div class="col-xs-5 col-xs-push-1">
  									<div class="form-group">
  										<label for="address">市区町村</label>
  										<font size="3" color="#ff0000"><b>*</b></font>
										<div data-tip="自動入力されます。">
	  										<input name="citytown" value="<s:property value="citytown" />" class="form-control" required
	  										pattern=".{1,10}" onkeyup="passwordLengthCheck();" title="自動入力されます。" readonly/>
  										</div>
  									</div>
  								</div>
  							</div>
  						</div>

  						<div class="container">
  							<div class="row">
  								<div class="col-xs-5 col-xs-push-1">
  									<div class="form-group">
  										<label for="address">番地</label>
  										<font size="3" color="#ff0000"><b>*</b></font>
										<div data-tip="全角半角100文字以内">
	  										<input name="houseNumber" value="<s:property value="houseNumber" />" class="form-control" required
	  										pattern=".{1,100}" onkeyup="passwordLengthCheck();" title="100文字以内でお願いします。"/>
  										</div>
  									</div>
  								</div>
  							</div>
  						</div>


 				<!--メールアドレス-->
  							<div class="container">
  								<div class="row">
  									<div class="col-xs-5 col-xs-push-1">
  										<div class="form-group">
  										  	<label for="mail-address">メールアドレス</label>
  										  	<font size="3" color="#ff0000"><b>*</b></font>
  											<div data-tip="使用可能なアドレスを入力">
	  											<input name="userMail" value="<s:property value="userMail" />" class="form-control"
	  											placeholder="example@gmail.com" onkeyup="passwordLengthCheck();" required type="email"/>
  											</div>
  										</div>
  									</div>
  								</div>
  							</div>


  				<!--パスワード-->
  								<div class="container">
  									<div class="row">
  										<div class="col-xs-5 col-xs-push-1">
  											<div class="form-group">
  												<label for="password">パスワード</label>
  												<font size="3" color="#ff0000"><b>*</b></font>
  												<div data-tip="6～30文字,半角英数字必須">
	  												<input name="userPass" value="<s:property value="userPass" />" class="form-control"
	  												type="password" placeholder="パスワード" required onkeyup="passwordLengthCheck();"
	  												pattern="^(?=.*[0-9])(?=.*[a-z])[0-9a-z\-]{6,30}$"
	  												title="6文字以上30文字です。半角数字、半角英小文字、ハイフンを使用してください。数字、英小文字の混在の必要があります"/>
  												</div>
  											</div>
  										</div>
  									</div>
  								</div>

  				<!--パスワード再入力-->
  									<div class="container">
  										<div class="row">
  											<div class="col-xs-5 col-xs-push-1">
  												<div class="form-group">
  													<label for="password-oncemore">パスワード（再入力）</label>
  												<font size="3" color="#ff0000"><b>*</b></font>
	  												<div data-tip="6～30文字,半角英数字必須">
		  												<input name="userPassRekey" value="<s:property value="userPassRekey" />" class="form-control"
		  												type="password" placeholder="パスワード" required
		  												pattern="^(?=.*[0-9])(?=.*[a-z])[0-9a-z\-]{6,30}$" onkeyup="passwordLengthCheck();"
		  												title="6文字以上30文字です。半角数字、半角英小文字、ハイフンを使用してください。数字、英小文字の混在の必要があります"/>
	  												</div>
  												</div>
  											</div>
  										</div>
  									</div>
  				<!--登録ボタン-->
  								<div class="container">
  									<div class="row">
  										<div class="col-xs-5 col-xs-push-1">
	  										<input type="submit" class="btn btn-primary btn-lg" value="ご登録" onclick="return addressClear();"/>
  										</div>
  									</div>
  								</div>
  								<br>
		</s:form>
  	</body>
  </html>
