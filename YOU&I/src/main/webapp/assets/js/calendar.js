/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {

	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		initialView: 'dayGridMonth',
		selectable: true,
		events: function(info, successCallback, failureCallback) {
			$.ajax({
				url: 'selectAllScheduleService.do?groupNo=' + GroupNo,
				dataType: 'json',
				success: function(data) {
					var events = [];
					for (var i = 0; i < data.length; i++) {
						var event = {
							"title": data[i].SCHE_TITLE,
							"start": convertToFullCalendarFormat(data[i].SCHE_ST_DATE),
							"end": convertToFullCalendarFormat(data[i].SCHE_END_DATE),
							extendedProps: {
								memo: data[i].SCHE_CONTENT
							}
						}
						events.push(event);
					}
					successCallback(events);
				},

			})
		},

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

							$.ajax({
								url: 'addSchedule.do?groupNo=' + GroupNo,
								dataType: 'json',
								data: {
									calendar_content: content,
									calendar_start_date: start_date,
									calendar_end_date: end_date,
									calendar_memo: memo
								},
								success: function() {
									var obj = {
										"title": content,
										"start": start_date,
										"end": end_date,
										extendedProps: {
											memo: memo
										},
									}; calendar.addEvent(obj);
								},
							})

							$("#calendarModal").modal("hide");
							$('#calendarModal').on('hidden.bs.modal', function() {
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
					var eventNameToDelete = prompt("삭제할 일정의 이름을 입력하세요.");
					if (eventNameToDelete) {
						var selectedEvents = calendar.getEvents();

						var eventToDelete = selectedEvents.find(function(event) {
							return event.title === eventNameToDelete;
						});

						if (eventToDelete) {
							
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
					$.ajax({
						url: 'addSchedule.do?groupNo=' + GroupNo,
						dataType: 'json',
						data: {
							calendar_content: content,
							calendar_start_date: start_date,
							calendar_end_date: end_date,
							calendar_memo: memo
						},
						success: function() {
							var obj = {
								"title": content,
								"start": start_date,
								"end": end_date,
								extendedProps: {
									memo: memo
								},
							}; calendar.addEvent(obj);
						},
					})
					$("#calendarModal").modal("hide");
					$('#calendarModal').on('hidden.bs.modal', function() {
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
					$.ajax({
						url: 'addSchedule.do?groupNo=' + GroupNo,
						dataType: 'json',
						data: {
							calendar_content: content,
							calendar_start_date: start_date,
							calendar_end_date: end_date,
							calendar_memo: memo
						},
						success: function() {
							var obj = {
								"title": content,
								"start": start_date,
								"end": end_date,
								extendedProps: {
									memo: memo
								},
							}; calendar.addEvent(obj);
						}, 
					})
					$("#calendarModal").modal("hide");
					$('#calendarModal').on('hidden.bs.modal', function() {
						$('#calendar_content').val('');
						$('#calendar_start_date').val('');
						$('#calendar_end_date').val('');
						$('#calendar_memo').val('');
					});
				}
			})
		}

	});
	// 모달 열기 함수
	function openMemoModal(event) {
		$('#memoModal').modal('show');
		$("#memoModal .modal-body").text(event.extendedProps.memo);
	}
	
	// DB에서 받아온 날짜형식 fullcalendar 형식으로 바꿔주는 함수
	function convertToFullCalendarFormat(koreanDate) {
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

		var fullCalendarDate = year + '-' + month + '-' + day;
		return fullCalendarDate;
	}


	calendar.render();
});


