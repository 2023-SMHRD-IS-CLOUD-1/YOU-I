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
	document.getElementById('fileS3root').value = "fileS3" + changevar;

	const fileRoot = putFile(upimage[0]);
	$("#UserProfileS3root").val(fileRoot[0]);

	var data = { filename: fileRoot[0], fileOriName: fileRoot[1], fileDate: fileRoot[2], fileS3root: $("#fileS3root").val() }
	$.ajax({
		url: "http://localhost:8081/YOU_I/Upload.do",
		data: data,
		dataType: "json",
		success: function(res) {
		},
		error: function(e) {
		}
	})

	var sendObj = { nick: inputValues[0], phone: inputValues[1], region: inputValues[2], ct1: mypCtValues[0] , userprofile: fileRoot[0]};
	$.ajax({

		url: "UpdateMyPage.do",
		data: sendObj,
		dataType: "json",
		success: function() {
		},
		error: function(e) {
		}
	})
})


