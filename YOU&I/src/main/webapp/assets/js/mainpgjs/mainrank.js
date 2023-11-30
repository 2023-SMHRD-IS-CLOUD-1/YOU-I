function rank(){
    $(document).ready(function() {
		
		//var sendObj = { data: "hello" };
	  
	 $.ajax({
		 		//data : sendObj,
                url: "http://localhost:8081/YOU_I/rank.do",
                dataType : "json",
                success: function (res) {
					var i = 0;
					res.forEach(function(res){
					
				  $(".groupinfo"+i).after("<tr><td class='grouptd'>" + res.hobbyName+ "</td></tr>");
                  $(".groupinfo"+i).after("<tr><td class='grouptd'>" + res.groupName + "</td></tr>");
                  $(".groupinfo"+i).after("<tr><td class='grouptd'>" + res.groupLikes + "</td></tr>");
                  i++;	
					});
                  
                },

                error : function(e){
                    console.log(e);
                }
            })
            })
}
rank();