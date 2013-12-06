<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - Gestão de Clientes</title>

<link href="css/style.css" rel="stylesheet" />
<link href="css/style_paginas.css" rel="stylesheet" />

<style type="text/css" title="currentStyle">
@import "recurosTableFilter/media/css/demo_page.css";

@import "recurosTableFilter/media/css/demo_table.css";

@import "recurosTableFilter/media/css/themes/base/jquery-ui.css";

@import
	"recurosTableFilter/media/css/themes/smoothness/jquery-ui-1.7.2.custom.css"
	;
</style>

<script src="js/Mascara.js"	type="text/javascript"></script>

<script src="recurosTableFilter/media/js/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<script src="recurosTableFilter/media/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script src="js/valid.js" type="text/javascript"></script>
<script src="recurosTableFilter/media/js/jquery-ui.js"
	type="text/javascript"></script>

<script
	src="recurosTableFilter/media/js/jquery.dataTables.columnFilter.js"
	type="text/javascript"></script>

<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').dataTable().columnFilter();

	});
</script>
<script type="text/javascript">
	var _gaq = _gaq || [];
	_gaq.push([ '_setAccount', 'UA-17838786-4' ]);
	_gaq.push([ '_trackPageview' ]);

	(function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www')
				+ '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
</head>

<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite wh700">

		<h4>Gestão de Empresas</h4>
		
		<%@ include file="componente_menu_gestao_empresa.jsp"%>
		
		<h5> Cadastrar Nova Empresa :.</h5>
		
		<div class="blue_line"></div>
		
		<div class="alert" id="content_alert" style="display: none;">
			<p><strong>Atenção!</strong> <span id="lbl_msg"></span> </p>
		</div>
		
		<div class="clr"></div>
		
		<form method="POST" action="controlador" class="form_cadastra_empresa" name="form_cadastra_empresa" id="form_cadastra_empresa">
			<input type="hidden" name="acao" value="cadastrar_empresa">
			<label class="wh150">CNPJ:</label>
			<label class="wh300">Razão Social:</label>
			
			<input name="cnpj" type="text" class="wh150" maxlength="18" onkeypress="mascara(this,cnp)" id="txtCNPJ"/>
			<input name="razao" type="text" class="wh300" maxlength="100" id="txtRazao"/>
			
			<label class="wh300">Nome que aparecerá no Master Fila:</label>
			<input type="text" name="nome" class="wh455" maxlength="100" id="txtNomeAparecer"/>
			
			<label class="wh300">Email:</label>
			<input type="text" name="email" class="wh455" maxlength="100" id="txtEmail"/>

			<label class="wh455">Categoria:</label>
			<select id="selCategoria" name="categoria">
				<option value="0">.: Selecione :.</option>
				<option value="Consultório Médico">Consultório Médico</option>
				<option value="Cartório">Cartório</option>
				<option value="Repartição Pública">Repartição Pública</option>
				<option value="Prefeitura e setores vinculados">Prefeitura e setores vinculados</option>
				<option value="Agência Bancária">Agência Bancária</option>
			</select>
		
			<label class="wh455">Foto da empresa:</label>
			<input type="file" class="wh300" name="foto"/>
				
			<label class="wh455">Endereço (Rua - Nº - Bairro):</label>
			<input type="text" name="endereco" class="wh455" id="txtEndereco"/>
			
			<label class="wh225">Estado:</label>
			<label class="wh225">Cidade:</label>
			
			<select class="wh225" id="sel_estado" name="estado" >
				<option value="0">.: Selecione :.</option>
				<option value="pernambuco">Pernambuco</option>
			</select>
			
			<select class="wh225" id="sel_cidade" name="cidade">
				<option value="0">.: Selecione :.</option>
				<%for (String cidade : Constants.listaCidades){ %>
					<option value="<%=cidade %>"><%=cidade %></option>
				<%} %>
			</select>
			
			<a class="submit" href="javascript:validarPreenchimento();">Cadastrar Empresa</a>
			
		</form>
		
		<div class="clr"></div>
		
	</div>

	<div class="clr"></div>
		
</body>
</html>

<%@ include file="rodape.jsp"%>