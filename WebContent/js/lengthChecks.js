//指定した文字数を入力しないようにする
//Version            : 1.0
//Author             : Y.Narita

function passwordLengthCheck() { 
	userId = document.entry.userId.value;
	lastName = document.entry.lastName.value;
	firstName = document.entry.firstName.value;
	zipcode = document.entry.zipcode.value;
	prefecture = document.entry.prefecture.value;
	citytown = document.entry.citytown.value;
	houseNumber = document.entry.houseNumber.value;
	userMail = document.entry.userMail.value;
	userPass = document.entry.userPass.value;
	userPassRekey = document.entry.userPassRekey.value;
	
	
	if (userId.length > 30) {
		document.entry.userId.value="";
		alert("30文字以内にしてください"); 
	}
	if ( lastName.length > 30) {
		document.entry.lastName.value="";
		alert("30文字以内にしてください"); 
	}
	if (firstName.length > 30) {
		document.entry.firstName.value="";
		alert("30文字以内にしてください"); 
	}
	if (zipcode.length > 8) {
		document.entry.zipcode.value="";
		alert("8文字以内にしてください"); 
	}
	if (prefecture.length > 10) {
		document.entry.prefecture.value="";
		alert("10文字以内にしてください"); 
	}
	if (citytown.length > 10) {
		document.entry.citytown.value="";
		alert("10文字以内にしてください"); 
	}
	if (houseNumber.length > 100) {
		document.entry.houseNumber.value="";
		alert("100文字以内にしてください"); 
	}
	if (userMail.length > 60) {
		document.entry.userMail.value="";
		alert("60文字以内にしてください"); 
	}
	if (userPass.length > 30) {
		document.entry.userPass.value="";
		alert("30文字以内にしてください"); 
	}
	if(userPassRekey.length > 30){
		document.entry.userPassRekey.value="";
		alert("30文字以内にしてください"); 
	}
}