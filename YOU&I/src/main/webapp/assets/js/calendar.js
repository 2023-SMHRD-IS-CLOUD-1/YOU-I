/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {

	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		timeZone: 'UTC',
		initialView: 'dayGridMonth',
		selectable: true, // 드래그 가능하도록 설정
		events: [                           // 일정 데이터 추가 , DB의 event를 가져오려면 JSON 형식으로 변환해 events에 넣어주기 
			$.ajax({
				url: 'selectAllScheduleService.do',
				type: 'GET',
				contentType: 'application/json;charset=utf-8',
				dataType: 'json',
				success: function(data) {
					console.log(data)
					// 각 데이터 항목을 FullCalendar 이벤트로 변환
					for (var i = 0; i < data.length; i++) {
						var obj = {
							"title": data[i].SCHE_TITLE,
							"start": convertToFullCalendarFormat(data[i].SCHE_ST_DATE),
							"end": convertToFullCalendarFormat(data[i].SCHE_END_DATE),  // 이벤트의 종료일자가 필요한 경우 수정
							extendedProps: {
								memo: data[i].SCHE_CONTENT
							}
						};
					calendar.addEvent(obj);
					}

				}
			})
		],
		headerToolbar: {
			center: 'addEventButton deleteEventButton'
		},
		customButtons: {
			addEventButton: {
				text: "일정 추가",
				click: function() {
					$("#addCalendar").off("click");
					var currentDate = calendar.getDate();
					// 모달에 현재 날짜 표시
					$("#calendar_start_date").val(currentDate.toISOString().slice(0, 10));
					$("#calendarModal").modal("show");

					$("#addCalendar").on("click", function() {
						var content = $("#calendar_content").val();
						var start_date = $("#calendar_start_date").val();
						var end_date = $("#calendar_end_date").val();
						var memo = $("#calendar_memo").val();

						if (content == null || content == "") {
							alert("내용을 입력하세요.");
						} else if (start_date == "" || end_date == "") {
							alert("날짜를 입력하세요.");
						} else if (new Date(end_date) - new Date(start_date) < 0) {
							alert("종료일이 시작일보다 먼저입니다.");
						} else {
							var obj = {
								"title": content,
								"start": start_date,
								"end": end_date,
								extendedProps: {
									memo: memo
								}
							};
							calendar.addEvent(obj);
							console.log(obj);
							$("#calendarModal").modal("hide");
							$('#calendarModal').on('hidden.bs.modal', function() {
								// 입력 필드 초기화
								$('#calendar_content').val('');
								$('#calendar_start_date').val('');
								$('#calendar_end_date').val('');
								$('#calendar_memo').val('');
							});
						}
					});
				}
			},
			deleteEventButton: {
				text: "일정 삭제",
				click: function() {
					// 이름을 입력 받음
					var eventNameToDelete = prompt("삭제할 일정의 이름을 입력하세요.");

					if (eventNameToDelete) {
						// 선택된 이벤트들 가져오기
						var selectedEvents = calendar.getEvents();

						// 입력 받은 이름과 동일한 이벤트 찾기
						var eventToDelete = selectedEvents.find(function(event) {
							return event.title === eventNameToDelete;
						});

						if (eventToDelete) {
							// 찾은 이벤트를 삭제
							if (confirm("삭제하시겠습니까?")) {
								eventToDelete.remove();
							}

						} else {
							alert("입력한 이름과 일치하는 일정을 찾을 수 없습니다.");
						}
					} else {
						alert("일정을 선택하세요.");
					}
				}
			}
		},
		editable: true,
		displayEventTime: false,
		eventClick: function(info) {
			var clickEvent = info.event
			console.log(clickEvent.title);
			console.log(clickEvent.extendedProps.memo);
			// 일정 완료 여부 토글
			clickEvent.setExtendedProp('completed', !clickEvent.extendedProps.completed);
			calendar.refetchEvents();
			openMemoModal(info.event)
		},
		dateClick: function(info) {
			$("#addCalendar").off("click");
			info.dayEl.style.backgroundColor = '#87CEEB';
			$("#sprintSettingModalClose").on("click", function() {
				info.dayEl.style.backgroundColor = '#fff';

			})
			$("#calendarModal").modal("show")
			$("#calendar_start_date").val(info.dateStr);
			$("#calendar_end_date").val(info.dateStr);
			$("#addCalendar").on("click", function() {
				info.dayEl.style.backgroundColor = '#fff';
				var content = $("#calendar_content").val();
				var start_date = $("#calendar_start_date").val();
				var end_date = $("#calendar_end_date").val();
				var memo = $("#calendar_memo").val();
				if (content == null || content == "") {
					alert("내용을 입력하세요.");
				} else if (start_date == "" || end_date == "") {
					alert("날짜를 입력하세요.");
				} else if (new Date(end_date) - new Date(start_date) < 0) {
					alert("종료일이 시작일보다 먼저입니다.");
				} else {
					var obj = {
						"title": content,
						"start": start_date,
						"end": end_date,
						extendedProps: {
							memo: memo
						}
					}
					calendar.addEvent(obj);
					console.log(obj);
					$("#calendarModal").modal("hide");
					$('#calendarModal').on('hidden.bs.modal', function() {
						// 입력 필드 초기화
						$('#calendar_content').val('');
						$('#calendar_start_date').val('');
						$('#calendar_end_date').val('');
						$('#calendar_memo').val('');
					});
				}
			})
		},
		select: function(info) {
			$("#addCalendar").off("click");

			$("#calendarModal").modal("show");
			$("#calendar_start_date").val(info.startStr);
			$("#calendar_end_date").val(info.endStr);
			$("#addCalendar").on("click", function() {
				var content = $("#calendar_content").val();
				var start_date = $("#calendar_start_date").val();
				var end_date = $("#calendar_end_date").val();
				var memo = $("#calendar_memo").val();
				if (content == null || content == "") {
					alert("내용을 입력하세요.");
				} else if (start_date == "" || end_date == "") {
					alert("날짜를 입력하세요.");
				} else if (new Date(end_date) - new Date(start_date) < 0) {
					alert("종료일이 시작일보다 먼저입니다.");
				} else {
					var obj = {
						"title": content,
						"start": start_date,
						"end": end_date,
						extendedProps: {
							memo: memo
						},
						completed: false
					}
					calendar.addEvent(obj);
					console.log(obj);
					$("#calendarModal").modal("hide");
					$('#calendarModal').on('hidden.bs.modal', function() {
						// 입력 필드 초기화
						$('#calendar_content').val('');
						$('#calendar_start_date').val('');
						$('#calendar_end_date').val('');
						$('#calendar_memo').val('');
					});
				}
			})
		}

	});
	function convertToFullCalendarFormat(koreanDate) {
		// 한국어 월을 영어로 변환
		var monthMapping = {
			'1월': '01',
			'2월': '02',
			'3월': '03',
			'4월': '04',
			'5월': '05',
			'6월': '06',
			'7월': '07',
			'8월': '08',
			'9월': '09',
			'10월': '10',
			'11월': '11',
			'12월': '12'
		};


		var parts = koreanDate.split(' ');
		var month = monthMapping[parts[0]];
		var day = parts[1].replace(',', '');
		var year = parts[2];

		// FullCalendar 형식으로 변환
		var fullCalendarDate = year + '-' + month + '-' + day;
		return fullCalendarDate;
	}
	function openMemoModal(event) {
		// 메모 모달 열기
		$('#memoModal').modal('show');
		console.log();
		// 메모 모달 내용 설정
		$("#memoModal .modal-body").text(event.extendedProps.memo);
	}



	calendar.render();
});


