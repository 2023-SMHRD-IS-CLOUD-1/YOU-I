
# YOU-I
![image](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/assets/149571615/b5568cb9-954d-4bb7-a8fc-a7a4c5a0528b)

## 1. 서비스 소개 / 서비스 설명
- 지역별, 취미별로 그룹을 만들어 모임을 가질수 있는 기능제공
- 그룹별 커뮤니티 사이트 제공
- 사용자의 취미에 평가가 좋은 그룹순으로 볼수 있음.
## 2. 사용한 언어
![js](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white)
![html](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![css](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![boot](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![jquery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)
![flask](https://img.shields.io/badge/Flask-000000?style=for-the-badge&logo=flask&logoColor=white)
![AWS](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)
![python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![S3](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=Oracle&logoColor=white)
![eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)
## 3. ERD
  ![image](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/assets/149571615/67627a8b-1866-401c-856b-8e1dc11a57a4)
## 4. 시스템 아키텍처
  ![image](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/assets/149571615/e05baff8-0474-4fdc-a38a-d33f3ce7d68f)
## 5. 핵심 기능
우리의 서비스의 핵심기능은 AWS, OCR 및 API를 이용한 그룹 커뮤니티 기능입니다.
사용자는 본인이 원하는 취미를 등록하여 가입하고싶은 그룹에 가입해 그룹원들과
게시글, 사진 공유 및 그룹일정관리 , 회비관리등 을 이용 할 수 있는 사이트입니다.

<details>
<summary><b>핵심 기능 설명 펼치기</b></summary>
<div markdown="1">

### 5.1. 전체 흐름도
![image](https://github.com/chanhyuckkim/copy/assets/149571615/0eb8ff0b-0cdf-46ee-8761-cc1886f75038)


### 5.2. 메인페이지 핵심기능

- **본인 취미에 맞는 그룹 노출** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/assets/js/mainpgjs/mainrank.js#L3)
- ![image](https://github.com/chanhyuckkim/copy/assets/149571615/59ca12fd-10c1-4fa4-aa7c-fb3757f01928)

  - 본인이 선택한 취미에 맞는 그룹이 사용자들의 좋아요 갯수가 많은 그룹부터 차례대로 노출됩니다.
  - 취미에 맞는 프로필사진을 AWS에서 불러옵니다.
### 5.3.  커뮤니티 사이트 핵심기능

- **글/사진 등록** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/WEB-INF/community.html#L472)
  ![image](https://github.com/chanhyuckkim/copy/assets/149571615/2f4963a6-c3c2-4436-a1c3-3c0c035a3fc4)


  - 그룹별로 커뮤니티사이트에서 게시글과 사진을 등록할 수 있습니다.
    
- **그룹 일정** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/assets/js/calendar.js#L5C1-L5C1)
![image](https://github.com/chanhyuckkim/copy/assets/149571615/406e065b-f434-474d-b3bf-bbb6e9fb4776)

  - 그룹별로 일정을 등록할수 있습니다.
  - 풀캘린더 API를 이용하여 일정관리를 할 수 있습니다.
- **장소 검색** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/assets/js/map.js#L6)
![image](https://github.com/chanhyuckkim/copy/assets/149571615/19ff317e-7750-4b5c-8f06-4766adfbb504)

- 키워드로 장소를 검색하여 가게 정보를 쉽게 찾아볼 수 있습니다.
- **회비 관리** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/assets/js/feecalendar/feecalendar.js#L3)
![image](https://github.com/chanhyuckkim/copy/assets/149571615/edcd95d1-e644-426b-9772-a9cbe88d83fd)

- 사용한 회비를 입력하여 관리할 수 있습니다.
- OCR기반으로 영수증의 텍스트를 읽어 회비관리를 할 수 있습니다.
  ![image](https://github.com/chanhyuckkim/copy/assets/149571615/f7aeb4f7-d41c-4ece-91fd-720ede2fccba)
- **그룹회원조회** :pushpin: [코드 확인](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/blob/85cf700df6aed74bfe6b06e964702aaf8430bd45/YOU%26I/src/main/webapp/WEB-INF/clubmember.html#L163C1-L163C1)
![image](https://github.com/chanhyuckkim/copy/assets/149571615/df02c5b4-6516-4715-90d8-bfd9c2d38ab8)

- 본인이 속한 그룹의 회원들의 정보를 열람할 수 있습니다.
- 회원가입할때 저장한 사진파일을 AWS를 통해 불러옵니다.
</div>
</details>

</br>


## 6. 개발 기간 및 작업관리

### 개발 기간
* 전체 개발 기간 : 2023-11-22 ~ 2023-12-07

### 작업관리
* GitHub를 사용하여 프로젝트 협업을 진행하였습니다.
* 매일 프로젝트를 진행하기 전 작업 순서와 방향성에 대해 회의를 하고 새롭게 배운 내용을 공유하는 시간을 가졌습니다.


## 7. 팀원소개
![image](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/assets/149571615/6fa8e414-7abb-4f01-9bb9-1490ce0549a7)


## 8. 트러블 슈팅
* [AJAX 동시 사용 이슈](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/wiki/%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%852_AJAX_%EB%8F%99%EC%8B%9C_%EC%82%AC%EC%9A%A9%EC%9D%B4%EC%8A%88#ajax-%EB%8F%99%EC%8B%9C-%EC%82%AC%EC%9A%A9%EC%9D%B4%EC%8A%88)
* [AWS S3 사진 파일 관리](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/wiki/%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%853_AWS_S3_%EC%82%AC%EC%A7%84%EA%B4%80%EB%A6%AC_%EB%AC%B8%EC%A0%9C)
* [AWS Lambda](https://github.com/2023-SMHRD-IS-CLOUD-1/YOU-I/wiki/%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%854_%EC%9B%90%EB%B3%B8%ED%8C%8C%EC%9D%BC,_%EB%A6%AC%EC%82%AC%EC%9D%B4%EC%A7%95_%ED%8C%8C%EC%9D%BC_%EB%8F%99%EC%8B%9C_%EC%97%85%EB%A1%9C%EB%93%9C%EB%AC%B8%EC%A0%9C)

## 9. API
### 풀캘린더  https://fullcalendar.io/
### 카카오맵  https://apis.map.kakao.com/
### 네이버클로바 https://clova.ai/
### Vchat CLoud https://www.vchatcloud.com/



