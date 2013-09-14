<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - Início</title>

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
				<strong> .: Atenção :. </strong>
				<br/>
				
				<p id="alt_campos_nao_preenchidos">- Campos Obrigatórios não preenchidos</p>
				<p id="alt_cpf_invalido">- CPF Inválido</p>
				<p id="alt_senhas">- Senhas não Conferem, preencha novamente!</p>
				
			</div>
			
			<h4>Editar Perfil</h4>

			<form action="controlador" class="form_cadastro_cliente" name="form_cadastro_cliente">
				<input type="hidden" value="editar" name="acao">
				<label class="wh300"> <span>* Campos Obrigatórios</span> </label>
				
				<label class="wh300 rspace17"> Nome: <span>*</span></label>
				<label class="wh150"> CPF: <span>*</span></label>
				
				<input type="text" id="txtNome" name="nome" value="${usuario.nome}" class="wh300" onKeyPress="return VerificaNomeProprio(event);" />
				<input type="text" id="txtCpf" name="cpf" value="${usuario.cpf}" class="wh150"/>
				
				<label class="wh300 rspace17"> Endereço: <span>*</span> <strong style="font-size: 12px; font-weight: normal;"> (Rua - Nº - Complemento - Cidade - UF) </strong> </label>
				<input type="text" id="txtEndereco" name="endereco" value="${usuario.rua}" class="wh475"/>
								
				<label class="wh227 rspace17"> Email: <span>*</span></label>
				<label class="wh227 rspace17"> Login: <span>*</span></label>
				
				<input type="text" id="txtEmail" name="email" value="${usuario.bairro}" class="wh225"/>
				<input type="text" id="txtLogin" name="login" value="${usuario.login}" class="wh225"/>
				
				<label class="wh227 rspace17">Senha: <span>*</span> </label>
				<label class="wh227 rspace17">Confirmação de Senha: <span>*</span> </label>
				
				<input type="password" name="senha" id="txtSenha" class="wh225"/>
				<input type="password" id="txtConfirmsenha" class="wh225"/>
				
				<a href="javascript:validarCadastroUsuario()" class="submit">Atualizar</a>
				
			</form>
	
			<div class="clr"></div>
		
	</div>

</body>
</html>

<%@ include file="rodape.jsp" %>