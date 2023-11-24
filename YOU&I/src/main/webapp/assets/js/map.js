/**
 * 
 */


// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    for (var i = 0; i < places.length; i++) {
        if (places[i]) {
            console.log(places[i]);  // 각 places 요소의 내용을 콘솔에 출력
        }
    }
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {
        if (places[i]) {
        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i,places[i]), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, places) {
             // mouseover 이벤트 대신 click 이벤트에 대한 리스너를 추가
    kakao.maps.event.addListener(marker, 'click', function() {
        displayInfowindow(marker, places.place_name);
    });

    // mouseout 이벤트 대신 click 이벤트에 대한 리스너를 추가
    itemEl.onclick = function() {
        displayInfowindow(marker, title);
        
    };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }}

    // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {
    var el = document.createElement('li');
    var itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
        '<div class="info" data-index="' + index + '">' +
        '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
            '   <span class="jibun gray">' + places.address_name + '</span>';
    } else {
        itemStr += '    <span>' + places.address_name + '</span>';
    }

    itemStr += '  <span class="tel">' + places.phone + '</span>' +
        '</div>';

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, places) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png',
        imageSize = new kakao.maps.Size(36, 37),
        imgOptions =  {
            spriteSize: new kakao.maps.Size(36, 691),
            spriteOrigin: new kakao.maps.Point(0, (idx * 46) + 10),
            offset: new kakao.maps.Point(13, 37)
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
        marker = new kakao.maps.Marker({
            position: position,
            image: markerImage
        });

    // places 데이터를 마커 객체의 places 속성으로 설정합니다.
    marker.places = places;

    // 마커를 지도에 추가합니다.
    marker.setMap(map);

    // 마커 클릭 시 이벤트를 등록합니다.
    kakao.maps.event.addListener(marker, 'click', function() {
        displayInfowindow(marker);
    });

    // markers 배열에 마커를 저장합니다.
    markers.push(marker);

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다

function displayInfowindow(marker) {
    var places = marker.places
    if (places.place_name.includes('CGV')) {
     
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fcfile175.uf.daum.net%2Fimage%2F2441C6425530ACDC2C9F9F'; // Replace with the actual URL for CGV
    }else if(places.place_name.includes('메가박스')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FF0ED3C6D20164215AD0B3B06E1721113'
    }else if(places.place_name.includes('롯데시네마')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Fcfile171.uf.daum.net%2Fimage%2F99A59E335ACDAECD0E6756'
    }else if( places.place_name.includes('장안성')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F165A023AA59B49449C81E747A1BA714A'
    }else if( places.place_name.includes('벗초밥')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Ft1.daumcdn.net%2Flocal%2Freview_placeapp%2FbtqeLi0VU17_gVLF8KKZda7IMZ7KGbNsh1_img.jpg'
    }else if( places.place_name.includes('베비에르')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F24B6BB62100C45D0915A31B81C64A07C'
    }else if( places.place_name.includes('좋은날')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2FDEECF4611B514E5FB97B12C52844CB22'
    }else if( places.place_name.includes('황하호연')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocalfiy%2F96162A1CAF9042C4909B9D52E7ADC7CD'
    }else if( places.place_name.includes('오리한마당')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Ffiy_reboot%2Fplace%2F44894B51A94F4C5B81FA7BA4B93C899C'
    }else if( places.place_name.includes('다미정')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F0A1215068DF146C682AE8F42AD9DCD90'
    }else if( places.place_name.includes('능이백숙')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.kakaocdn.net%2Ffiy_reboot%2Fplace%2F1ECB36B409864621B3E310079E1641C0'
    }else if( places.place_name.includes('예향촌')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F255E8E3C53CE151518'
    }else if( places.place_name.includes('고코로')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F8DEB725870E74D86A18EFFA45A997E96'
    }else if( places.place_name.includes('부엌간')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=https%3A%2F%2Fpostfiles.pstatic.net%2FMjAyMzEwMThfNjUg%2FMDAxNjk3NTkwNjEwODEw.emh4HGTacl8WEW3C7vqKAaug-qC8hzDWqxiH6V7dG2wg.6GyTDQB2LNAwYeleaVWlS_YlEBfr0cA0Qdr4mgeWkKMg.JPEG.kims_5055%2FIMG_7184.jpg%3Ftype%3Dw966'
    }else if( places.place_name.includes('스타벅스')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fcfile%2F2323B13D5679CEED19'
    }else if( places.place_name.includes('영빈관')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flocal%2FkakaomapPhoto%2Freview%2Fc566c22a36d58fdce1db8e63f25e8bb8a85200fe%3Foriginal'
    }else if( places.place_name.includes('샤브샤브')){
        thumbnailUrl = 'https://img1.kakaocdn.net/cthumb/local/R0x420/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fplace%2F9E2EB87DD8F1433F88E84E63CD6BD3DF'
    }else {
        thumbnailUrl = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/thumnail.png"
    }
    
    var content = '<div class="wrap">' +
        '    <div class="info">' +
        '        <div class="title">' +
        '            ' + places.place_name +
        '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
        '        </div>' +
        '        <div class="body">' +
        '            <div class="img">' +
        '                <img src='+ thumbnailUrl +' width="73" height="70">' +
        '            </div>' +
        '            <div class="desc">' +
        '                <div class="ellipsis">' + places.address_name + '</div>' +
        '                <div class="jibun ellipsis">' + places.road_address_name + '</div>' +
        '                <div>' + places.phone + '</div>' + 
            '                <div><a href='+places.place_url +' target="_blank" class="link">홈페이지</a></div>' +
        '            </div>' +
        '        </div>' +
        '    </div>' +
        '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}
function closeOverlay() {
    infowindow.close();
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
