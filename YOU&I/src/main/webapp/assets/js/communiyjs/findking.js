$.ajax({
    url: 'findKing.do?groupNo='+GroupNo,
    dataType: 'json',
    success: function (findKingData) {
        console.log(findKingData);
        console.log(findKingData.levelNo)
        if(findKingData.levelNo==21){
			$("#sideService").append("<li><a href='GogroupKing.do'>가입승인</a></li>")
		}
    },
     error: function (xhr, status, error) {
        console.error('Error occurred in findKing.do:', error);
        console.log(xhr)
    }
});