<%@page import="masterfila.entidade.Estabelecimento"%>
<%@page import="masterfila.fachada.Fachada"%>
<%@page import="masterfila.dominio.Categoria"%>
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
</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="limite">
		<div class="content_cidade_selecionada">
			<h6>Você está em:</h6>
			<h4>${cidade} - ${estado}</h4>
			<a href="index.jsp" id="dialog_link">Alterar Cidade</a>
		</div>
	</div>
	
	<div class="clr"></div>
	
	<div class="limite">

		<div class="limite_lista_categorias">

			<h4>Localizar empresa por categoria</h4>

			<ul class="lista_categorias primeira_lista">
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.CONSULTORIO %>"> <img alt=""
						src="css/img/icons/icon_consultorios.png" height="25" />
						<%=Categoria.CONSULTORIO %>
				</a></li>
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.CARTORIO %>"> <img alt="" src="css/img/icons/icon_cartorios.png"
						height="25" /> <%=Categoria.CARTORIO %>
				</a></li>
			</ul>

			<ul class="lista_categorias">
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.REPARTICAO %>"> <img alt=""
						src="css/img/icons/icon_reparticoes.png" height="25"/>
						<%=Categoria.REPARTICAO %>
				</a></li>
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.PREFEITURA %>"> <img alt=""
						src="css/img/icons/icon_prefeituras.png" height="25" /> 
						<%=Categoria.PREFEITURA %>
				</a></li>
			</ul>

			<ul class="lista_categorias">
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.AGENCIA %>"> <img alt="" src="css/img/icons/icon_bancos.png"
						height="25" /> <%=Categoria.AGENCIA %>
				</a></li>
				<li><a href="controlador?acao=categoria&categoria=<%=Categoria.OUTRO %>"> <img alt="" src="css/img/icons/icon_outros.png"
						height="25" /> <%=Categoria.OUTRO %>
				</a></li>
			</ul>
	
			<div class="clr"></div>

		</div>

	</div>
	
	<div class="limite">

		<div class="listagem_empresas">

			<h6>Categoria Selecionada:</h6>
			<h4>${categoria_escolhida}</h4>
			
			<br/>
			
			<div id="content_paginate" class="container">
				<div class="page_navigation"></div>
				<ul class="content lista_empresas_paginate">

					<%
					String categoria = (String) session.getAttribute("categoria_escolhida");
					String cidade = (String) session.getAttribute("cidade");
					List<Estabelecimento> lista;
					
					if(categoria == null && cidade == null){
						lista = Fachada.getInstance().cadastroEmpresa().listar();
					}
					else{
						if(categoria != null && cidade == null){
							lista = Fachada.getInstance().cadastroEmpresa().listarCategoria(categoria); 
						}
						else if(categoria == null && cidade != null){
							lista = Fachada.getInstance().cadastroEmpresa().listarCidade(cidade);
						}
						else{
							lista = Fachada.getInstance().cadastroEmpresa().listarCidadeCategoria(cidade, categoria);
						}
					}
					for(Estabelecimento estabelecimento : lista){
					%>
					
					<li>
						<img alt="" src="img_empresas/img_empresa_default.png"/>
						<p>
							<strong><%=estabelecimento.getNome() %>:</strong>
							<strong class="esp_top">Endereço:</strong>
							<br/>
							<%=estabelecimento.getEndereco() %> 
						</p>
						<a class="bg_image_azul_padão" href="chamada_senha.jsp?id_fila=Normal">Visualizar</a>
					</li>
					
					<%
						}
					%>

				</ul>
				
				<div class="clr"></div>
				
			</div>

		</div>
	
	<br/>
		
	</div>

</body>
</html>

<%@ include file="rodape.jsp" %>