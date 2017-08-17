// 로그인 체크



function popUp (check_) {
	var check = check_;
	if(check == "정보수정 [이용할 수 없습니다.]") {
		alert('정보수정 [이용할 수 없습니다.] 로그인해주세요.');
		return;
	} else {
		var a = window.open('/unitt_web/MemberController?member=modifyCheck', 'child',
				'width=480, height=550, left=700, top=200', true);
	}
	var check2 = document.getElementId("dNote").value;
	if(check2 == "회원탈퇴 [이용할 수 없습니다.]") {
		alert('회원탈퇴 [이용할 수 없습니다.] 로그인해주세요.');
		return;
	}
}

//function insertMusic(user_id,board_idx){
//var id = user_id;
//var idx = board_idx.value;
//var name = prompt("저장할 제목을 입력해 주세요.")
//location.href = "../../PlaylistController?command=insertList&id=" +id +"&idx=" +idx +"&name=" +name;
//}