<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div id="mydiv">
		<div class="header" style="width: inherit; display: inline;">
			<div style="float: left; width: auto;"><img src="/img/verified-by-visa.png" height="40px" width="105"></div>
			<div style="float: right; width: auto;"><img src="/img/fid-bnk-1.png" height="40px" width="105"></div>
			<br> 
			<br>
			<b style="color: red;"> Enter your OTP</b><br>
			<div style="text-align: left;">
				<span style="font-size: 15px;">Please enter your OTP in the
					space provided below, to confirm your identity for this purchase.
					This information will not be shared with the merchant.</span>
			</div>

			<span
				style="font-size: 10px; align-items: center; color: #33adff; margin-bottom: 5px;">Incase
				the mobile no. reflected below is not correct, kindly click on
				refresh button </span>
			<form action="">
				<table class="tbl-pay">
					<tr>
						<td class="txt-right">Mobile No</td>
						<td class="txt-left">X6XXXX4XX4</td>
					</tr>
					<tr>
						<td class="txt-right">Merchant Name</td>
						<td class="txt-left">PAYTM</td>
					</tr>
					<tr>
						<td class="txt-right">Date</td>
						<td class="txt-left">Jul 15, 2019</td>
					</tr>
					<tr>
						<td class="txt-right">Total Charge</td>
						<td class="txt-left">Rs 82990.00</td>
					</tr>
					<tr>
						<td class="txt-right">Card Number</td>
						<td class="txt-left">XXXX XXXX XXXX 0226</td>
					</tr>
					<tr>
						<td class="txt-right">Personal Message</td>
						<td class="txt-left" style="color: red;">3D Secure Authentication*</td>
					</tr>
					<tr>
						<td class="txt-right">Name</td>
						<td class="txt-left">SWAPNIL VASUDEV PATIL</td>
					</tr>
					<tr>
						<td class="txt-right">OTP</td>
						<td class="txt-left"><input type="text"
							style="height: 20px; width: 60px;" max="6" /></td>
					</tr>
					<tr>
						<td class="txt-right"></td>
						<td class="txt-left">
						<a href="#" style="font-size: 12px;">Resend OTP</a>
						</td>
					</tr>
					<tr>
						<td class="txt-right"></td>
						<td class="txt-left"><input type="submit" value="Submit" /><span
							style="margin-right: 50px;"></span><input type="reset"
							value="Reset" /></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- <div >
		Text
		</div> -->
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