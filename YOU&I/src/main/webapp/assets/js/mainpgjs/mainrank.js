

function rank() {
	var Groupno = new Array;
	var StringNo = null;
	return new Promise(function(resolve, reject) {
		$.ajax({
			//data : sendObj,
			url: "rank.do",
			dataType: "json",
			success: function(res) {
				console.log(res)
				$("#tagA1").on("click", function() {
						console.log("클릭")
						$("#tagA1").attr("href","GojoinGroup.do?groupNo=" + res[0].groupNo);
					})
				$("#tagA2").on("click", function() {
						console.log("클릭")
						$("#tagA2").attr("href","GojoinGroup.do?groupNo=" + res[1].groupNo);
					})
				$("#tagA3").on("click", function() {
						console.log("클릭")
						$("#tagA3").attr("href","GojoinGroup.do?groupNo=" + res[2].groupNo);
					})
				$("#tagA4").on("click", function() {
						console.log("클릭")
						$("#tagA4").attr("href","GojoinGroup.do?groupNo=" + res[3].groupNo);
					})
				
				var i = 0;
				StringNo = "";
				res.forEach(function(res) {
					console.log("확인용" + res.gr)
					var temp = res.groupNo
					StringNo += temp + ",";
					Groupno.push(StringNo);
					console.log(Groupno);
					$(".groupinfo" + i).after("<tr><td class='grouptd'>" + res.groupInfo + "</td></tr>");
					$(".groupinfo" + i).after("<tr><td class='grouptd'>" + res.groupName + "</td></tr>");
					$(".groupinfo" + i).after("<tr><td class='grouptd'>" + flaticonHobby(res.hobbyNo) + res.hobbyName + "</td></tr>");
					
					i++;

				});
				resolve(StringNo);


			},

			error: function(e) {
				console.log(e);
			}
		})


	})


}



rank().then(function(resolvedData) {
	console.log(resolvedData);
	var Groupnodata = { data: resolvedData }
	var bucketUrl = "https://s3.ap-northeast-2.amazonaws.com/you-i/"
	$.ajax({

		url: "GroupImageTake.do",
		data: Groupnodata,
		dataType: "json",
		success: function(res) {
			var i = 1;
			res.forEach(function(res) {
				console.log("https://s3.ap-northeast-2.amazonaws.com/you-i/resize_profile" + res.fileThumb)
				var imagePath = "resize_profile" + res.fileThumb;
				var finalUrl = bucketUrl + encodeURIComponent(imagePath);
				$("#groupimg" + i).append(`<img style="object-fit: fill; width:155px;height:155px" src=${finalUrl}>`);
				i++;
			})
		},
		error: function(e) {
			console.log(e);
		}
	})
})

function flaticonHobby(resolveData) {
	return `<span id="flaticon${resolveData}" ><img src='assets/css/flaticon/${resolveData}.png' class="flaticon">`


}


