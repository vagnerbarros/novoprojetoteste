<%@page import="masterfila.fachada.Fachada"%>
<%@page import="masterfila.entidade.Estabelecimento"%>
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

<script src="recurosTableFilter/media/js/jquery-1.4.4.min.js"
	type="text/javascript"></script>
<script src="recurosTableFilter/media/js/jquery.dataTables.min.js"
	type="text/javascript"></script>

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
	
	<%
	List<Estabelecimento> empresas = Fachada.getInstance().cadastroEmpresa().listarTodas();
	%>
	
	<div class="limite wh700">

		<h4>Gestão de Empresas</h4>
		
		<%@ include file="componente_menu_gestao_empresa.jsp"%>
		
		<h5> Listagem de Empresas :.</h5>
		
		<div class="blue_line"></div>
		
		<div id="dt_example">

			<div id="demo">

				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="example">
					<thead>
						<tr>
							<th>CNPJ</th>
							<th>Razão Social</th>
							<th>Email</th>
							<th>Login</th>
							<th>Status</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>CNPJ</th>
							<th>Razão Social</th>
							<th>Email</th>
							<th>Login</th>
						</tr>
					</tfoot>
					<tbody>
						
						<%for(Estabelecimento emp : empresas){ %>
							<tr>
								<td class="read_only" align="center"><%=emp.getCnpj() %></td>
								<td><%=emp.getRazao() %></td>
								<td align="center"><%=emp.getEmail() %></td>
								<td align="center"><%=emp.getNome() %></td>
								<%if(emp.getStatus().equals(Constants.ATIVO)){ %>
									<td align="center"> <a href="controlador?acao=inativar_empresa&id=<%=emp.getId() %>"> <img alt="" src="css/img/icons/icon_inativar.png" height="16"/> </a> </td>
								<%}else if(emp.getStatus().equals(Constants.INATIVO)){%>
									<td align="center"> <a href="controlador?acao=ativar_empresa&id=<%=emp.getId() %>"> <img alt="" src="css/img/icons/icon_on.png" height="16"/> </a> </td>
								<%} %>
							</tr>
						<%} %>
						
					</tbody>
				</table>

				<div class="spacer"></div>
			</div>
		</div>
	</div>

</body>
</html>

<%@ include file="rodape.jsp"%>