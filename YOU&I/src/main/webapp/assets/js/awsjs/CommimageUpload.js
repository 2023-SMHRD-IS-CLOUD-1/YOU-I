	
	//게시글 사진 업로드 기능
	var date = new Date();
	console.log(date);
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();

	console.log(year + "_" + month + "_" + day);
	//S3 정보 입력
	const putFile = file => {
		let fileS3Root = document.getElementById("fileS3root").value;
		console.log(fileS3Root);
		const albumBucketName = 'you-i'; // S3의 버킷 이름
		const region = 'ap-northeast-2'; // 서울
		const accessKeyId = ''; // IAM에서 생성한 사용자의 accessKeyId
		const secretAccessKey = ''; // IAM에서 생성한 사용자의 secretAccessKey

		AWS.config.update({
			region,
			accessKeyId,
			secretAccessKey
		});

		let randomRoot = guid();

		// 업로드 파일 정보 입력
		const upload = new AWS.S3.ManagedUpload({
			params: {
				Bucket: albumBucketName,
				Key: 'images/Group' + fileS3Root+ '/' + randomRoot + '_' + year + '_' + month + '_' + day + '_' + file.name,
				Body: file,
				ACL: "public-read"
			}
		});

		const promise = upload.promise();

		promise.then(
			function(data) {
				console.log("Successfully uploaded photo.");
			},
			function(err) {
				return console.log("There was an error uploading your photo: ", err.message);
			}
		);
		return ['images/Group' + fileS3Root+ '/' + randomRoot + '_' + year + '_' + month + '_' + day + '_' + file.name, file.name, year + '_' + month + '_' + day]
	};
	
	// uuid 입력함수
	function guid() {
		function s4() {
			return ((1 + Math.random()) * 0x10000 | 0).toString(16).substring(1);
		}
		return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
	}

