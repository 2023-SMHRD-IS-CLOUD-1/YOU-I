
    const remo = document.getElementById('remo');
    const picText = document.getElementById('pic');

    remo.addEventListener('click', function () {
        $("#uploadedImage").attr("src"," ");
        upimage = [""];
        uploadedImage.style.display = 'none';
        picText.style.display = 'block';
    });
