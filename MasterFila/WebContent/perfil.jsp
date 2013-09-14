<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - Início</title>

<link href="css/style.css" rel="stylesheet" />
<link href="css/style_paginas.css" rel="stylesheet" />

<script type="text/javascript" src="js/script_cadastro.js"></script>

</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite wh700 perfil">
			
			<h4>Meu Perfil</h4>
			
			<strong>Nome:</strong>
			<span>${usuario.nome}</span>
			
			<br/>
			
			<strong>CPF:</strong>
			<span>${usuario.cpf}</span>
			
			<br/>
			
			<strong>Email:</strong>
			<span>${usuario.bairro}</span>
			
			<br/>
			
			<div class="blue_line"></div>
			
			<a href="editar_cadastro.jsp">Editar Perfil</a>
			
			<br/>
			<br/>
			
			<div class="clr"></div>
		
	</div>

</body>
</html>

<%@ include file="rodape.jsp" %>