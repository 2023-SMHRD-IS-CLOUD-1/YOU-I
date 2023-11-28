function rank(){
    $(document).ready(function() {
		
		var sendObj = { data: "hello" };
	  
	 $.ajax({
		 		data : sendObj,
                url: "http://localhost:8081/YOU_I/rank.do",
                
                dataType : "json",
                success: function (res) {
                  for(var i=0; res.length;i++){
				  $(".pt"+i).append($("<div>" + res[i].groupCategory+ "</div>"));
                  $(".pt"+i).append($("<div>" + res[i].groupName + "</div>"));
                  $(".pt"+i).append($("<div>" + res[i].groupLikes + "</div>"));
				  }

                },

                error : function(e){
                    console.log(e);
                }
            })
            })
}
rank();