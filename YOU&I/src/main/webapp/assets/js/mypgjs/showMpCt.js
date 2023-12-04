function showMpCt() {
    $(document).ready(function () {
        var $this = $(this);



        $.ajax({
            url: "http://localhost:8081/YOU_I/SelectAllHobbyName.do",

            dataType: "json",
            success: function (res) {

                var i = 0;

                res.forEach(function (item) {
                    $(".mypCtOp").after("<option>" + item.hobbyName + "</option>");
                    i++;
                });

            },

            error: function (e) {
                console.log(e);
            }
        })
    })

}
showMpCt();