<%@page import="java.util.List"%>
<%@page import="masterfila.util.Constants"%>
<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - In�cio</title>
<script type="text/javascript" src="js/paginate.js"></script>
<link href="css/style.css" rel="stylesheet" />
<link href="css/style_paginas.css" rel="stylesheet" />
</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite">
		
		<div class="div_left_sobre">
		
		<h4 style="margin-bottom: 10px;">Master Fila</h4>
		
		<p class="txt_sobre">
			
			<img alt="" src="css/img/banner_inicio.png" width="230" class="img_sobre2">
			
			<img alt="" src="css/img/logo_master.png" height="105"
				class="img_sobre" /> <strong> Potencial Inovador </strong> <br />
			<br /> Atualmente a maioria dos sistemas de gerenciamento de filas
			de atendimento � realizado por um sistema simples, onde a pessoa
			retira uma senha e fica no local aguardando ser chamado, dessa
			forma a pessoa fica "presa" ao local e n�o pode sair, pois acaba
			ficando com medo de sua vez chegar e ela n�o est� presente. <br />
			<br /> Com o Master Fila a pessoa que retirar a senha poder�
			acompanhar atrav�s do celular ou qualquer outro dispositivo m�vel
			com acesso a internet, o andamento da fila e dessa forma saber� se
			a sua vez de ser atendida est� chegando, sem precisar ficar
			aguardando no local.
						
			<br/>
			<br/>
			
			<strong> Alguns Recursos Especiais </strong>
			<br/>
			<br>
			. Alertas a cada chamada
			<br>
			. Previs�es de tempo para as pr�ximas Chamadas
			<br>
			
			<a href="#" class="link_levar">Levar o Master Fila para minha empresa</a>
			
		</p>
		
		<br/>
		<br/>
		<br/>
				
		<div class="clr"></div>
				
		</div>
				
		<div class="clr"></div>
				
	</div>

</body>
</html>

<%@ include file="rodape.jsp"%>