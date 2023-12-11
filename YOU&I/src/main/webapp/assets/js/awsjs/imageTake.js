// **DO THIS**:
//   Replace BUCKET_NAME with the bucket name.
//
var albumBucketName = 'you-i';

// **DO THIS**:
//   Replace this block of code with the sample code located at:
//   Cognito -- Manage Identity Pools -- [identity_pool_name] -- Sample Code -- JavaScript
//
// Initialize the Amazon Cognito credentials provider
AWS.config.region = 'ap-northeast-2'; // Region
AWS.config.credentials = new AWS.CognitoIdentityCredentials({
	IdentityPoolId: '',
});

// Create a new service object
var s3 = new AWS.S3({
	apiVersion: '2006-03-01',
	params: { Bucket: albumBucketName }
});

// A utility function to create HTML.
function getHtml(template) {
	console.log(template.join('\n') + "조인 확인용");
	return template.join('\n');
}

function listAlbums() {
	s3.listObjects({ Delimiter: '/' }, function(err, data) {
		if (err) {
			return alert('There was an error listing your albums: ' + err.message);
		} else {
			var albums = data.CommonPrefixes.map(function(commonPrefix) {
				var prefix = commonPrefix.Prefix;
				var albumName = decodeURIComponent(prefix.replace('/', ''));
				return getHtml([
					'<li>',
					'<button style="margin:5px;" onclick="viewAlbum(\'' + albumName + '\')">',
					albumName,
					'</button>',
					'</li>'
				]);
			});
			var message = albums.length ?
				getHtml([
					'<p>Click on an album name to view it.</p>',
				]) :
				'<p>You do not have any albums. Please Create album.';
			var htmlTemplate = [
				'<h2>Albums</h2>',
				message,
				'<ul>',
				getHtml(albums),
				'</ul>',
			]
			document.getElementById('viewer').innerHTML = getHtml(htmlTemplate);

		}
	});
}

function viewAlbum(albumName) {
	var albumPhotosKey = 'resize_profile/' + encodeURIComponent(albumName) + '/';
	s3.listObjects({ Prefix: albumPhotosKey }, function(err, data) {
		if (err) {
			return alert('There was an error viewing your album: ' + err.message);
		}
		// 'this' references the AWS.Request instance that represents the response
		var href = this.request.httpRequest.endpoint.href;
		console.log(href + "확인용");
		var bucketUrl = href + albumBucketName + '/';
		console.log(bucketUrl + "버킷 url확인용");
		//console.log(photoKey.replace(albumPhotosKey, ''));
		var photos = data.Contents.map(function(photo) {
			var photoKey = photo.Key;
			console.log(photoKey + "포토키 확인용");
			var photoUrl = bucketUrl + encodeURIComponent(photoKey);
			console.log(photoUrl + " 사진 Url 확인용");

			return getHtml([
				'<div>',
				'<br/>',
				'<img style="width:128px;height:128px;" src="' + photoUrl + '"/>',
				'</div>',

			]);
		});
		var message = photos.length ?
			'<p>The following photos are present.</p>' :
			'<p>There are no photos in this album.</p>';
		var htmlTemplate = [
			'<div>',
			getHtml(photos),
			'</div>',

		]
		document.getElementById('viewer').innerHTML = getHtml(htmlTemplate);
		//document.getElementsByTagName('img')[0].setAttribute('style', 'display:none;');

	});
}
