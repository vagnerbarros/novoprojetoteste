<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - Início</title>
<script type="text/javascript" src="js/paginate.js"></script>

<link href="css/style.css" rel="stylesheet" />
<link href="css/style_paginas.css" rel="stylesheet" />

<script type="text/javascript">
	$(document).ready(function() {
		$('#content_paginate').pajinate({
			num_page_links_to_display : 3,
			items_per_page : 4
		});
	});
</script>

<script src="js/jquery.maskedinput-1.3.min.js"></script>
<script src="js/script_cadastro.js"></script>

</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite wh700">
			
			<div class="div_alerts" id="div_alert_recuperar_email" style="display: none;">
				
				<a href="javascript:fechar_alert_recuperar_email()" class="link_close"> <img alt="" src="css/img/icon_close.png" height="10" /> </a>
				
				<img alt="" src="css/img/icon_alert.png" height="10"/>
				<strong> .: Atenção :. </strong>
				<br/>
				
				<p id="alt_email_vazio">- Preencha o email</p>
				
			</div>
			
			<h4>Recuperação de Senha</h4>

			<form action="controlador" class="form_esqueci_senha" name="form_esqueci_senha">
				<input type="hidden" name="acao" value="recuperar_email">
				<label class="wh300 rspace17"> Digite seu Email abaixo: <span>*</span></label>
				
				<input type="text" id="txtEmail" class="wh300" onKeyPress="return VerificaNomeProprio(event);" />
				
				<input type="submit" value="Concluir" onclick="return javascript:validarRecuperarEmail()" class="submit"/>
				
			</form>
			
			<br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/>
			<br/><br/><br/><br/><br/>
			
			<div class="clr"></div>
		
	</div>

</body>
</html>

<%@ include file="rodape.jsp" %>