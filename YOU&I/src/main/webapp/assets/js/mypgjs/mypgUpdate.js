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
	changevar = document.getElementById("ip0").value
	console.log(changevar + "ip0 값");
	document.getElementById('fileS3root').value = "fileS3" + changevar;

	const fileRoot = putFile(upimage[0]);
	console.log(fileRoot[0], fileRoot[1], fileRoot[2])
	$("#UserProfileS3root").val(fileRoot[0]);

	var data = { filename: fileRoot[0], fileOriName: fileRoot[1], fileDate: fileRoot[2], fileS3root: $("#fileS3root").val() }
	$.ajax({

		url: "http://localhost:8081/YOU_I/Upload.do",
		data: data,
		dataType: "json",
		success: function(res) {
			console.log("DB연결성공")
		},
		error: function(e) {
			console.log("DB연결실패");
		}
	})

	// ct2:mypCtValues[1],ct3: mypCtValues[2]  

	var sendObj = { nick: inputValues[0], phone: inputValues[1], region: inputValues[2], ct1: mypCtValues[0] , userprofile: fileRoot[0]};
	$.ajax({

		url: "UpdateMyPage.do",

		data: sendObj,

		dataType: "json",
		success: function() {
			console.log("성공");
		},

		error: function(e) {
			console.log(e);


		}
	})

})


