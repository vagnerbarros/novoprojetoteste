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
	
	<div class="limite wh700">

		<h4>Gestão de Clientes</h4>
		
		<%@ include file="componente_menu_gestao_clientes.jsp"%>
		
		<h5> Pessoas Cadastradas no Master Fila :.</h5>
		
		<div class="blue_line"></div>
		
		<strong class="alert_vincular"> ATENÇÃO - Ao Vincular uma pessoa, ela poderá solicitar ficha pela internet ou aplicativo móvel para atendimento em sua empresa. </strong>
		
		<div id="dt_example">

			<div id="demo">

				<table cellpadding="0" cellspacing="0" border="0" class="display"
					id="example">
					<thead>
						<tr>
							<th>CPF</th>
							<th>Nome</th>
							<th>Email</th>
							<th>Login</th>
							<th>Vincular</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>CPF</th>
							<th>Nome</th>
							<th>Email</th>
							<th>Login</th>
						</tr>
					</tfoot>
					<tbody>
						
						<!-- O FOR DEVE COMEÇAR AQUI -->
						
						<tr>
							<td class="read_only" align="center">101.004.934-83</td>
							<td>Plínio Manoel Oliveira Silva</td>
							<td align="center">ti.plinio@gmail.com</td>
							<td align="center">pliniomos</td>
							<td align="center"> <a href="#"> <img alt="" src="css/img/icons/icon_on.png" height="16"/> </a> </td>
						</tr>

						<tr>
							<td class="read_only" align="center">280.680.254-72</td>
							<td>José Manoel da Silva Sobrinho</td>
							<td align="center">leonartplacas@gmail.com</td>
							<td align="center">leonart</td>
							<td align="center"> <a href="#"> <img alt="" src="css/img/icons/icon_on.png" height="16"/> </a> </td>
						</tr>
						
						<!-- O FOR DEVE TERMINAR AQUI -->
						
					</tbody>
				</table>

				<div class="spacer"></div>
			</div>
		</div>
	</div>

</body>
</html>

<%@ include file="rodape.jsp"%>