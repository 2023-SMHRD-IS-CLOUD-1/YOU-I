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
           
              
       

        },

        error: function (e) {
            console.log(e);
        }
    })
})
}
mypgShow();