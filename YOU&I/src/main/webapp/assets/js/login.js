googlebtn = document.getElementsByClassName("google-btn");
        googlebtn.onclick = () =>{
            function init() {
   gapi.load('auth2', function() {
      gapi.auth2.init();
      options = new gapi.auth2.SigninOptionsBuilder();
      options.setPrompt('select_account');
        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
      options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
        // 인스턴스의 함수 호출 - element에 로그인 기능 추가
        // GgCustomLogin은 li태그안에 있는 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
      gapi.auth2.getAuthInstance().attachClickHandler('GgCustomLogin', options, onSignIn, onSignInFailure);
   })
}

function onSignIn(googleUser) {
   var access_token = googleUser.getAuthResponse().access_token
   $.ajax({
       // url api통해 개인정보가져오기
      url: 'https://people.googleapis.com/v1/people/me'
        // key에 자신의 API 키를 넣습니다.
      , data: {personFields:'birthdays', key:'AIzaSyDsOUtRqBDZbtrjL-I9ohE5k0rsTYc6VuI', 'access_token': access_token}
      , method:'GET'
   })
   .done(function(e){
        //프로필을 가져온다.
      var profile = googleUser.getBasicProfile();
      console.log(profile)
   })
   .fail(function(e){
      console.log(e);
   })
}
function onSignInFailure(t){      
   console.log(t);
}
        }
        document.addEventListener("DOMContentLoaded", function () {
            const signupButton = document.getElementById('signupButton');
            const loginForm = document.getElementById('loginForm');
            const signupForm = document.querySelector('.signup-container');

            signupButton.addEventListener('click', function () {
                // 이미지 페이드 아웃
                const imageContainer = document.getElementById('imageContainer');
                const images = imageContainer.querySelectorAll('img');
                images.forEach(img => img.style.opacity = 0);
                var destinationURL = "진짜회원가입.html";

            // 화면 이동
            window.location.href = destinationURL;
            });

            // 이미지 전환 처리
            const imageContainer = document.getElementById('imageContainer');
            const images = imageContainer.querySelectorAll('img');
            let currentImageIndex = 0;

            setInterval(() => {
                images[currentImageIndex].style.opacity = 0;
                currentImageIndex = (currentImageIndex + 1) % images.length;
                images[currentImageIndex].style.opacity = 1;
            }, 3000);

        });