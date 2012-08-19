<html>
	<head>
		<meta name="layout" content="main">
		<title>Recovery Password</title>
	</head>
	<body>
		<g:form action="save">
			Email: <g:textField name="email" required="" value="${companyInstance?.email}"/>
			<br/>
			<input type="submit" value="Recuperar Password">
		</g:form>
	</body>
</html>
