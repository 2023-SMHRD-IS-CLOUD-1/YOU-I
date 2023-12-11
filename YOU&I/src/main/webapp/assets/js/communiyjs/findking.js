/**
 * 
 */
var TempGroup = window.location
const searchParams = new URL(TempGroup).searchParams;
const GroupNo = searchParams.get('groupNo')
$("#modifyprofile").attr("href", "Gomypg.do");
$("#clubmember").attr("href", "Goclubmember.do?groupNo=" + GroupNo);
$("#community").attr("href", "Gocommunity.do?groupNo=" + GroupNo);
$("#clubfee").attr("href", "Goclubfee.do?groupNo=" + GroupNo);
$("#groupSchedules").attr("href", "GogroupSchedules.do?groupNo=" + GroupNo);
$("#groupKing").attr("href", "GogroupKing.do?groupNo=" + GroupNo);

$.ajax({
    url: 'findKing.do?groupNo='+GroupNo,
    dataType: 'json',
    success: function (findKingData) {
        if(findKingData.levelNo==21){
			$("#sideService").append(`<li><a id='groupKing' href='GogroupKing.do?groupNo=${GroupNo}'>가입승인</a></li>`)
		}
    },
    
});