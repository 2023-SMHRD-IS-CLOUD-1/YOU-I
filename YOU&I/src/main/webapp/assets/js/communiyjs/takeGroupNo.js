var TempGroup = window.location
const searchParams = new URL(TempGroup).searchParams;
const GroupNo = searchParams.get('groupNo')
console.log(GroupNo);
$("#modifyprofile").attr("href", "Gomodifyprofile.do?groupNo=" + GroupNo);
$("#clubmember").attr("href", "Goclubmember.do?groupNo=" + GroupNo);
$("#community").attr("href", "Gocommunity.do?groupNo=" + GroupNo);
$("#clubfee").attr("href", "Goclubfee.do?groupNo=" + GroupNo);