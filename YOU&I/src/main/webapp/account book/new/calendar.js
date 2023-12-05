var name_, name_2, money, money2, date, date2, outcome, income

function input() {
    date = document.getElementById('input_date').value;
    name_ = document.getElementById('input_name').value;
    money = document.getElementById('input_money').value;

    document.getElementById("date").innerHTML = date;
    document.getElementById("name_").innerHTML = name_;
    document.getElementById("money").innerHTML = money + "원";

    if (money !== undefined && money2 !== undefined) {
        outcome = money - money2;
    } else if (money !== undefined) {
        outcome = -money;
    } else {
        outcome = money2;
    }
    console.log(date, name_, money, outcome); 
    document.getElementById("outcome").innerHTML = outcome + "원";

    document.getElementById('input_date').value = null;
    document.getElementById('input_name').value = null;
    document.getElementById('input_money').value = null;
}

function input2() {
    let today = new Date();
    let year = today.getFullYear();
    let month = today.getMonth() + 1;
    let date = today.getDate();
    date2 = year + "-" + month + "-" + "0"+ date;
    name_2 = document.getElementById('input_name2').value;
    money2 = document.getElementById('input_money2').value;

    document.getElementById("date2").innerHTML = date2;
    document.getElementById("name2").innerHTML = name_2;
    document.getElementById("money2").innerHTML = money2 + "원";
    
    if (money !== undefined && money2 !== undefined) {
        income = money2 - money
    } else if (money !== undefined) {
        income = money;
    } else {
        income = money2
    }
    console.log(date, name_, money2, income + "원");

    document.getElementById("income").innerHTML = income + "원";

    document.getElementById('input_name2').value = null;
    document.getElementById('input_money2').value = null;
}

function input3() {
    $.getJSON('http://127.0.0.1:8081/new/result.json', function(response_json) {
        let year = response_json['images'][0]['receipt']['result']['paymentInfo']['date']['formatted']['year'];
        let month = response_json['images'][0]['receipt']['result']['paymentInfo']['date']['formatted']['month'];
        let day = response_json['images'][0]['receipt']['result']['paymentInfo']['date']['formatted']['day'];

        let name_3 = response_json['images'][0]['receipt']['result']['storeInfo']['name']['text'];
        let date3 = year + "-" + month + "-" + day;
        let money3 = response_json['images'][0]['receipt']['result']['totalPrice']['price']['formatted']['value'];

        if (money !== undefined && money2 !== undefined) {
            outcome2 = -money3 + income;
        }

        document.getElementById("date3").innerHTML = date3;
        document.getElementById("name3").innerHTML = name_3;
        document.getElementById("money3").innerHTML = money3 + "원";
        document.getElementById("outcome2").innerHTML = outcome2 + "원";
    });
}
