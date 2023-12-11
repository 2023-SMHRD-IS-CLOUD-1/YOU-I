//마이페이지 회원정보 띄우기
function mypgShow(){
$(document).ready(function () {

    $.ajax({
        
        url: "UserMyPage.do",

        dataType: "json",
        success: function (res) {

           $("#ip0").val(res['nick']);
           $("#ip1").val(res['phone']);
           $("#ip2").val(res['region']);
           $("#mypCtOp1").text(res['hobby']);
           $("#mypg").text(res['id'] + "님 환영합니다💗");
           profileImageTake(res['profileImg']);
        },
        error: function (e) {
        }
    })
})
}
//회원 프로필사진 띄우기
function profileImageTake(resolvedData) {
	console.log(resolvedData);
	var bucketUrl = "https://s3.ap-northeast-2.amazonaws.com/you-i/"
				try{
				var imagePath = "resize_profile/" + resolvedData;
				var finalUrl = bucketUrl + encodeURIComponent(imagePath);
				$("#uploadedImage").attr("src", finalUrl);
				$("#uploadedImage").css("display", "block");
			}
				catch(e){}
		}
mypgShow();