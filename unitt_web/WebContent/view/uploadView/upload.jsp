<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>동영상 업로드</TITLE>
</HEAD>
<script language="javascript">
	var count = 1;
	var addCount;

	//동영상 추가
	function addInputBox() {
		for (var i = 1; i <= count; i++) {
			if (!document.getElementsByName("test" + i)[0]) {
				addCount = i;
				break;
			}
			else
				addCount = count;
		}
		var addStr = "<tr><td width=40><input type=checkbox name=checkList value="+addCount+
						" size=40></td><td width=160><input type=text name=title value='' size=40></td><td width=160><input type=file name=test"+addCount+
						" size=40></td></tr></br><hr><tr><td colspan=3 border=1><center><b> ↓ 동영상 강좌 내용 ↓ </b></center></td></tr></br><tr><td><textarea rows=5 cols=100 name=content value=''></textarea></td></tr>";

		var table = document.getElementById("dynamic_table");
		var newRow = table.insertRow();
		var newCell = newRow.insertCell();
		newCell.innerHTML = addStr;

		count++;
	}

	//동영상 삭제
	function subtractInputBox() {
		var table = document.getElementById("dynamic_table");
		//var max = document.gForm.checkList.length;

		//alert(max);

		var rows = dynamic_table.rows.length;
		var chk = 0;
		if (rows > 1) {
			for (var i = 0; i < document.gForm.checkList.length; i++) {
				if (document.gForm.checkList[i].checked == true) {
					table.deleteRow(i);
					i--;
					count--;
					chk++;
				}
			}
			if (chk <= 0) {
				alert("삭제할 동영상을 체크해 주세요.");
			}
		} else {
			alert("더이상 삭제할 수 없습니다.");
		}
	}

	function submitbutton() {
		var gform = document.gForm;
		gform.count.value = eval(count);
		//alert(count);
		gForm.submit();
		return;
	}
</script>




<BODY -nLoad="addInputBox()">
	
	<input type="button" value="동영상 업로드폼 추가" onclick="javascript:addInputBox();">
	:
	<input type="button" value="체크된 동영상 삭제"
		onclick="javascript:subtractInputBox();">
	<br>
	<br>

	<form name="gForm" action="/unitt_web/VideoController?video=upload&pageNum=${page}" enctype="multipart/form-data"
		method="post">

		<input type="hidden" name="count">

		<table cellpadding=0 cellspacing=0 id="" border="1">
			<tr>
				<td width="20"><center>v</center></td>
				<td width="310">강좌 제목</td>
				<td width="70"><center>파일선택</center></td>
				<td width="317">업로드 동영상</td>
			</tr>
			<tr>

				<table cellpadding=0 cellspacing=0 id="dynamic_table" border="1">
				</table>
			</tr></br>
			<tr>
				<td colspan="2"><input type="button" value="동영상 올리기" onclick="javascript:submitbutton();"></td>
			</tr>
		</table>
	</form>
	
</BODY>
</HTML>
