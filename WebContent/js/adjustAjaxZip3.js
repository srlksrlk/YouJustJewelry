//AjaxZip3を使用して住所情報を自動入力する。
//且つ存在しない都道府県、市区町村を入力しないようにする。
//Version            : 1.0
//Author             : Y.Narita
function backSpaceClear(){
	AjaxZip3.zip2addr('zipcode', '', 'prefecture', 'citytown');
	if(event.keyCode == 8){
			formClear();
    	}
}
function formClear(){
	document.entry.prefecture.value="";
	document.entry.citytown.value="";
}
function addressClear(){
	var preLength = document.entry.prefecture.value;
	var cityLength = document.entry.citytown.value;
    	if(preLength == "" || cityLength == ""){
    		alert("都道府県または市区町村が未入力です。");
    		return false;
    	}
}