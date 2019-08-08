<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dummy Bank</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link href="/css/custom.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<h2 class="m-crd">
			<img alt="Fidel Bank" src="/img/fid-bnk-1.PNG" width="180px;">
		</h2>
		<div class="card m-crd rounded-0">
			<form action="${processUrl}" method="post">
				<div class="card-header rounded-0 card-header-cust">Payment
					Details</div>
				<div class="card-body rounded-0">
					<table class="tbl-1 w-100">
						<tr>
							<td class="pb-3 td-cust-1">Pay From:</td>
							<td class="pb-3 td-cust"><select class="w-100" name="from-acc">
									<option value="000${data.accountInfo.accountNo}">
										000${data.accountInfo.accountNo} - ${data.custName}</option>
							</select></td>
							<td class=" pb-3 td-cust"><span style="padding-left: 50px;">INR:
									<span style="color: green;">${data.accountInfo.accountBalance}</span>
									as of ${curDate}
							</span></td>
						</tr>
						<tr>
							<td class="pb-3">Pay To</td>
							<td class="pb-3">${mrData.mName}</td>
							<td class="pb-3"></td>
						</tr>
						<tr>
							<td class="pb-3">Amount (INR)</td>
							<td class="pb-3">${payload.txnAmount}</td>
							<td class="pb-3"></td>
						</tr>
						<tr>
							<td class="pb-3">Remark</td>
							<td class="pb-3"><input type="text" name="remark"></td>
							<td class="pb-3"></td>
						</tr>
					</table>
				</div>
				<div class="card-footer rounded-0">
					<div class="row">
						<div class="col-lg-1">
							<input type="submit" value="Cancel" onclick="$('input[name=status').val('cancel');">
						</div>
						<div class="col-lg-2">
							<input type="submit" value="Pay">
						</div>
					</div>
				</div>

				<input type="hidden" name="txnAmount" value="${payload.txnAmount}">
				<input type="hidden" name="orderId" value="${payload.orderId}">
				<input type="hidden" name="mobileNo" value="${payload.mobileNo}">
				<input type="hidden" name="email" value="${payload.email}">
				<input type="hidden" name="callBckUrl" value="${payload.callBckUrl}">
				<input type="hidden" name="mId" value="${payload.mId}">
				<input type="hidden" name="reqType" value="${payload.reqType}">
				<input type="hidden" name="custId" value="${payload.custId}">
				<input type="hidden" name="status" value="">
			</form>
		</div>
	</div>
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>