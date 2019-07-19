<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dummy Bank</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

	<span style="align-self: center; font-size: 20px; align-items: center;">Please
		wait...</span>

	<form action="/api/v1/charge" name="payform" method="post">
		<input type="hidden" name="mId" value="1234"> <input
			type="hidden" name="ordId" value="65656565"> <input
			type="hidden" name="cardId" value="565656"> <input
			type="hidden" name="cvvNo" value="152"> <input type="hidden"
			name="mobNo" value="8698484304"> <input type="hidden"
			name="hash" value="6s4d6f4sd64f6sd4f6sd4f6sd4f6sd4f6sd4f6sd4f">
		<script type="text/javascript">
			document.payform.submit();
		</script>
	</form>
</body>
</html>