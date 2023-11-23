/**
 * 
 */
 document.addEventListener("DOMContentLoaded", function () {
            const images = document.querySelectorAll('.slide-image');
            let currentImageIndex = 0;

            function showImage(index) {
                images.forEach((img, i) => {
                    img.style.opacity = i === index ? 1 : 0;
                });
            }

            setInterval(() => {
                currentImageIndex = (currentImageIndex + 1) % images.length;
                showImage(currentImageIndex);
            }, 3000);
        });

        function signup() {
            // 여기에 회원가입 처리 로직을 추가하세요.
            alert('회원가입 성공!');
        }
        const dropArea = document.getElementById('drop-area');
  const fileInput = document.getElementById('fileInput');
  const uploadedImage = document.getElementById('uploadedImage');
  function preventDefaults(e) {
    e.preventDefault();
    e.stopPropagation();
  }
  function highlight() {
    dropArea.classList.add('highlight');
  }
  function unhighlight() {
    dropArea.classList.remove('highlight');
  }

  function handleFiles(files) {
    for (const file of files) {
      if (file.type.startsWith('image/')) {
        const reader = new FileReader();

        reader.onload = function (e) {
          uploadedImage.src = e.target.result;
          uploadedImage.style.display = 'block';
        };
        reader.readAsDataURL(file);
      } else {
        alert('이미지 파일만 업로드 가능합니다.');
      }
    }
  }
  ['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false);
    document.body.addEventListener(eventName, preventDefaults, false);
  });

  ['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, highlight, false);
  });

  ['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, unhighlight, false);
  });
  dropArea.addEventListener('drop', function (e) {
    const dt = e.dataTransfer;
    const files = dt.files;
    handleFiles(files);
  });
  dropArea.addEventListener('click', () => {
    fileInput.click();
  });
  fileInput.addEventListener('change', () => {
    const files = fileInput.files;
    handleFiles(files);
  });

  function dragOverHandler(e) {
    preventDefaults(e);
    highlight();
  }

  function dragEnterHandler(e) {
    preventDefaults(e);
    highlight();
  }

  function dragLeaveHandler(e) {
    preventDefaults(e);
    unhighlight();
  }
  //이거는 전화번호 중간에 - 들어가게해줌
  function formatPhoneNumber(input) {
          
          let cleaned = ('' + input).replace(/\D/g, '');

          
          if (cleaned === '' || isNaN(cleaned)) {
              return '';
          }

         
          let formatted = '';
          for (let i = 0; i < cleaned.length; i++) {
              if (i === 3 || i === 7) {
                  formatted += '-';
              }
              formatted += cleaned[i];
          }

          return formatted;
      }

      const phoneInput = document.getElementById('phone');
      phoneInput.addEventListener('input', function () {
          this.value = formatPhoneNumber(this.value);
      });

      let hobbyList = ["축구","야구","농구"];