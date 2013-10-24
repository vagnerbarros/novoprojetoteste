<%@page import="masterfila.dominio.Perfil"%>
<%@page import="masterfila.entidade.Funcionario"%>
<div class="menu">
	
	<%
	Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
	%>
	
	<div class="limite">
	
		<ul class="lista_menu">
			<li> <a href="home.jsp">Início</a> </li>
			<li> <a href="sobre.jsp">Sobre</a> </li>
			<li> <a href="perfil.jsp">Meu Perfil</a> </li>
			
			<% 
			if(funcionario != null){
				if(funcionario.getPerfil().equals(Perfil.GERENTE)){ %>
						<li> <a href="gestao_de_clientes_minha_empresa.jsp">Gestão de Clientes</a> </li>
				<% } else if(funcionario.getPerfil().equals(Perfil.ADMIN)){%>
						<li> <a href="gestao_empresa.jsp">Gestão de Empresas</a> </li>
				<% } 
			}%>
		</ul>
		
	</div>
	
	<div class="clr"></div>
	
</div>