function disa() {
    var mybtn = document.getElementById("mybtn");
    let ip = document.getElementsByClassName("ip");
    var remo = document.getElementById("remo");
    let mypCt = document.getElementsByClassName("mypCt");
    
    mybtn.onclick = function () {
        mybtn.disabled = true;
        remo.disabled = true;

        for (var i = 0; i < mypCt.length; i++) {
            mypCt[i].disabled = true;
        }
        for (var i = 0; i < ip.length; i++) {
            ip[i].disabled = true;
        }



    }
}
disa();