function mypgUp(){
    $("#mybtn").on("click", () => {
			
        var inputValues = [];
      
           $(".ip").each(function() {
           var value = $(this).val();
           inputValues.push(value);
           });
        var mypCtValues = [];
      
           $(".mypCt").each(function() {
           var value = $(this).val();
           mypCtValues.push(value);
           
           });

           // ct2:mypCtValues[1],ct3: mypCtValues[2]  
                                          
            var sendObj = { nick: inputValues[0], phone: inputValues[1], region:inputValues[2], ct1:mypCtValues[0]};
   $.ajax({
       
       url: "UpdateMyPage.do",

       data: sendObj,

       dataType : "json",
       success: function () {
           console.log("성공");
       },

       error : function(e){
           console.log(e);


       }
   })

})

}
mypgUp();