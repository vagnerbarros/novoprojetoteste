<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="masterfila.entidade.Usuario"%>
<%@page import="masterfila.util.Constants"%>
<%@page import="com.sun.corba.se.impl.orbutil.closure.Constant"%>
<html>
<head>
<link rel="SHORTCUT ICON" href="icon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style_topo.css" rel="stylesheet" />
<link rel="stylesheet" href="themes/base/jquery.ui.all.css">
<link href="css/style_cadastro.css" rel="stylesheet" />

<script src="ui/jquery-1.7.2.js"></script>
<script src="external/jquery.bgiframe-2.1.2.js"></script>
<script src="ui/jquery.ui.core.js"></script>
<script src="ui/jquery.ui.widget.js"></script>
<script src="ui/jquery.ui.position.js"></script>
<script src="ui/jquery.ui.dialog.js"></script>
	
<script type="text/javascript">

			$(function(){

				// Dialog
				$('#dialog').dialog({
					modal: true,
					autoOpen: false,
					height:300,
					width:400
				});

				// Dialog Link
				$('#dialog_link').click(function(){
					$('#dialog').dialog('open');
					return false;
				});

				//hover states on the static widgets
				$('ul#icons li').hover(
					function() { $(this).addClass('ui-state-hover'); },
					function() { $(this).removeClass('ui-state-hover'); }
				);

			});
		</script>

</head>
<body>
	
	<!-- ui-dialog -->
	<div id="dialog" title="Alterar Cidade">
    	
    	<div class="left_escolha_cidade">
    	
		<form class="form_cidade" method="POST" action="controlador">
		
			<input type="hidden" value="acessarSistema" name="acao">
			
			<label>Selecione o Estado:</label>
			
			<select name="estados">
				<%
				String [] estados = Constants.listaEstados;
				for(String estado : estados){
				%>
			    <option value="<%=estado %>"><%=estado %></option>
			    <%} %>
			</select>
			
			<label>Selecione a Cidade:</label>
			
			<select name="cidades">
				<%
				String [] cidades = Constants.listaCidades;
				for(String cidade : cidades){
				%>
			    <option value="<%=cidade %>"><%=cidade %></option>
			    <%} %>
			</select>
			
			<input type="submit" value="Alterar Cidade"/>
			
		</form>
		
		</div>
		
		<div class="right_escolha_cidade">
				<img alt="" src="css/img/logo_form.png" width="70"/>
		</div>
		
	</div>
	
	<header>
	
		<div class="limite">
			
			<div class="left_topo">
				<a href="index.jsp">
					<img alt="" src="css/img/logo.png" height="95"/>
				</a>
			</div>
			
			<div class="right_topo">
				
				<%@ include file="componente_login.jsp"%>
							
			</div>
			
		</div>
	
	</header>
	
	<div class="clr"></div>
		
</body>
</html>