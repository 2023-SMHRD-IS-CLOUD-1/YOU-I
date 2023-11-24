function input() {
    var name = document.getElementById('input_name').value;
    var money = document.getElementById('input_money').value;

    let today = new Date();   
    let year = today.getFullYear();
    let month = today.getMonth() + 1;
    let date = today.getDate();

    console.log(year + "-" + month + "-" + date,name,money);
    document.getElementById("date2").innerHTML = (year + "-" + month + "-" + date);
    document.getElementById("name3").innerHTML = (name);
    document.getElementById("money3").innerHTML = (money + " 원");

    document.getElementById('input_name').value = null;
    document.getElementById('input_money').value = null;
}   

function input2() {
    const date = document.querySelector("#input_date").value;
    var name2 = document.getElementById('input_name2').value;
    var money2 = document.getElementById('input_money2').value;
    console.log(date, name2, money2); 

    document.getElementById("date3").innerHTML = (date);
    document.getElementById("name4").innerHTML = (name2);
    document.getElementById("money4").innerHTML = (money2 + " 원");

    document.getElementById('input_date').value = null;
    document.getElementById('input_name2').value = null;
    document.getElementById('input_money2').value = null
}
