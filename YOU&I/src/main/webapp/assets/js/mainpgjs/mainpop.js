function mainpop(){
	
    var sub = document.getElementById("sub");
    sub.onclick = function() {
	  document.getElementById("main").style.display = 'block';
      document.getElementById('pop1').style.display = 'none';
    }
    
    document.querySelector('.btn').addEventListener('click', function () {
      document.getElementById('pop1').style.display = 'block';
    });
    }

mainpop();