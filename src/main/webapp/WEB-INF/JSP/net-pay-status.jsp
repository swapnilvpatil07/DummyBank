<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		wait...</span> <br />
		Redirecting back to ${payload.callBckUrl}
		<br />
	<form action="${payload.callBckUrl}" name="payform" method="post">
		<input type="hidden" name="status" value="${status}"> <input
			type="hidden" name="message" value="${message}"> <input
			type="hidden" name="txnAmount" value="${payload.txnAmount}">
		<input type="hidden" name="orderId" value="${payload.orderId}">
		<input type="hidden" name="mobileNo" value="${payload.mobileNo}">
		<input type="hidden" name="email" value="${payload.email}"> <input
			type="hidden" name="mId" value="${payload.mId}"> <input
			type="hidden" name="reqType" value="${payload.reqType}">
		<script type="text/javascript">
			document.payform.submit();
		</script>
	</form>
</body>
</html>