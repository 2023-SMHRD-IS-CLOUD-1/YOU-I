function picUp() {
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

				reader.onload = function(e) {
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
	dropArea.addEventListener('drop', function(e) {
		const dt = e.dataTransfer;
		const files = dt.files;
		handleFiles(files);
		upimage = files;
	});
	dropArea.addEventListener('click', () => {
		fileInput.click();
	});
	fileInput.addEventListener('change', () => {
		const files = fileInput.files;
		upimage = files;
		handleFiles(files);
		console.log(files);
		console.log("파일 바뀜");
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

}
picUp();