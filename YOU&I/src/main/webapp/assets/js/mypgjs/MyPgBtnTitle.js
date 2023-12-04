function mypgBtn(){
    $(document).ready(function () {
        $.ajax({

        url: "MyGroup.do",


          dataType : "json",
          success: function (res) {
              console.log(res);
              if(res == false){
             document.getElementById("gr").innerHTML = '메인페이지로 이동';
             $(".grbtn").on("click", function(){
                 $(".grbtn").attr("href", "http://localhost:8081/YOU_I/Gomainpg.do");
             })
         }
         
},

        error : function(e){

 
}
})
})
}
mypgBtn();