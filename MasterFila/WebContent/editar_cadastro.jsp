<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - In�cio</title>

<link href="css/style.css" rel="stylesheet" />
<link href="css/style_paginas.css" rel="stylesheet" />

<script src="js/jquery.maskedinput-1.3.min.js"></script>
<script type="text/javascript" src="js/script_cadastro.js"></script>

</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite wh700">
			
			<div class="div_alerts" id="div_alert_cadastro" style="display: none;">
				
				<a href="javascript:fechar_alert_cadastro()" class="link_close"> <img alt="" src="css/img/icon_close.png" height="10" /> </a>
				
				<img alt="" src="css/img/icon_alert.png" height="10"/>
				<strong> .: Aten��o :. </strong>
				<br/>
				
				<p id="alt_campos_nao_preenchidos">- Campos Obrigat�rios n�o preenchidos</p>
				<p id="alt_cpf_invalido">- CPF Inv�lido</p>
				<p id="alt_senhas">- Senhas n�o Conferem, preencha novamente!</p>
				
			</div>
			
			<h4>Editar Perfil</h4>

			<form action="controlador" class="form_cadastro_cliente" name="form_cadastro_cliente">
				<input type="hidden" value="editar" name="acao">
				<label class="wh300"> <span>* Campos Obrigat�rios</span> </label>
				
				<label class="wh300 rspace17"> Nome: <span>*</span></label>
				<input type="text" id="txtNome" name="nome" value="${usuario.nome}" class="wh300" onKeyPress="return VerificaNomeProprio(event);" />
				
				<label class="wh300 rspace17"> CPF: <span>*</span></label>
				<input type="text" id="txtCpf" name="cpf" value="${usuario.cpf}" class="wh300" />
								
				<label class="wh300 rspace17"> Login: <span>*</span></label>
				<input type="text" id="txtLogin" name="login" value="${usuario.login}" class="wh300"/>
				
				<label class="wh455">Senha: <span>*</span> </label>
				<input type="password" name="senha" id="txtSenha" class="wh300"/>
				
				<label class="wh455">Confirma��o de Senha: <span>*</span> </label>
				<input type="password" id="txtConfirmsenha" class="wh330 rspace17"/>
				
				<div class="clr"></div>
				
				<input type="submit" value="Atualizar" class="submit">
				
			</form>
	
			<div class="clr"></div>
		
	</div>

</body>
</html>

<%@ include file="rodape.jsp" %>