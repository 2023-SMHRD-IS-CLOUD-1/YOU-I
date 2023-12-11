function unregister() {
	$("#popupsub").on("click", function() {

		var sendObj = { id: $("#inPop1").val(), pw: $("#inPop2").val() };
		$.ajax({

			url: "unregister.do",
			data: sendObj,
			dataType: "json",
			success: function() {

				alert("회원탈퇴에 성공하셨습니다. 이용해주셔서 감사합니다.");
				window.location.href = "http://localhost:8081/YOU_I/Gomainpg.do";
			},
			error: function(e) {
				alert("아이디와 비밀번호가 일치하지않습니다.");
			}
		})
	})
}
unregister();