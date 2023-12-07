function mypgShow(){
$(document).ready(function () {

    $.ajax({
        
        url: "UserMyPage.do",

        dataType: "json",
        success: function (res) {

           console.log(res);
           $("#ip0").val(res['nick']);
           $("#ip1").val(res['phone']);
           $("#ip2").val(res['region']);
           $("#mypCtOp1").text(res['hobby']);
           $("#mypg").text(res['id'] + "님 환영합니다💗");
           profileImageTake(res['profileImg']);
              
       

        },

        error: function (e) {
            console.log(e);
        }
    })
})
}
function profileImageTake(resolvedData) {
	console.log(resolvedData);
	var bucketUrl = "https://s3.ap-northeast-2.amazonaws.com/you-i/"

			console.log("요청옴" + resolvedData)
				try{
				console.log(resolvedData)
				console.log("https://s3.ap-northeast-2.amazonaws.com/you-i/resize_profile" + resolvedData)
				var imagePath = "resize_profile/" + resolvedData;
				console.log(imagePath);
				var finalUrl = bucketUrl + encodeURIComponent(imagePath);
				$("#uploadedImage").attr("src", finalUrl);
				$("#uploadedImage").css("display", "block");
			}
				catch(e){}
		}
mypgShow();