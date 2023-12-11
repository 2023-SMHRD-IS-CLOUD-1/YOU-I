function showMpCt() {
    $(document).ready(function () {
        $.ajax({
            url: "SelectAllHobbyName.do",
            dataType: "json",
            success: function (res) {

                var i = 0;
                res.forEach(function (item) {
                    $(".mypCtOp").after("<option>" + item.hobbyName + "</option>");
                    i++;
                });
            },
            error: function (e) {
            }
        })
    })
}
showMpCt();