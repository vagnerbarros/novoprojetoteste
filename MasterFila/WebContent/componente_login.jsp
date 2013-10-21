<%@page import="masterfila.entidade.Funcionario"%>
<%@page import="masterfila.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="masterfila.util.Constants"%>

<div class="content_login">
		
		<%
			Funcionario f = (Funcionario) session.getAttribute("usuario");
			if(f == null){
			%>
				
				<form action="controlador" method="POST" class="form_login"> 
					<input type="hidden" value="logar" name="acao"/>
					<label class="wh150">Login:</label>
					<label class="wh150">Senha:</label>
					<input type="text" name="login" class="wh150"/>
					<input type="password" name="senha" class="wh150"/>
					<input type="submit" value="Confirmar" />
					<a href="esqueci_senha.jsp"> Esqueci a Senha</a>
				</form>
			<%
			}
			else{ %>
				<label>Bem Vindo! <%=f.getNome() %></label><br><br>
				<a href="controlador?acao=logout">Deslogar</a>
			<% }
			%>
		<div class="clr"></div>
</div>