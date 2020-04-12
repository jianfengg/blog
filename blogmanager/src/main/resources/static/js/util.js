var tosignBase =  'https://test.tosign.cn/tosignserver/';
function searchStr(id){
	var data = $('#'+id).val();
	if(data == undefined || data == null || data == '' ){
		return '';
	} else {
		return '%'+data+'%';
	}
}