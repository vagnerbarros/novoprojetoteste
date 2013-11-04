<%@page import="masterfila.util.Data"%>
<%@page import="java.util.List"%>
<%@page import="masterfila.util.GerenciadorArquivo"%>
<%@page import="masterfila.entidade.Ficha"%>
<%@page import="masterfila.entidade.TipoFicha"%>
<%@page import="masterfila.fachada.Fachada"%>
<%@page import="masterfila.entidade.Fila"%>
<%@page import="masterfila.entidade.Estabelecimento"%>

<%

Estabelecimento e = (Estabelecimento) session.getAttribute("estabelecimento");
TipoFicha tipo = Fachada.getInstance().cadastroTipoFicha().listar().get(0);
List<Ficha> fichas = Fachada.getInstance().cadastroFicha().listarAtendidas();

Ficha ficha = fichas.get(0);
%>
			<div class="quadro_chamadas_estatistica">
				
				<div class="quadro_chamada_atual">
					
					<h2>Última Chamada de Senha</h2>
					
					<span class="desc_empresa">
					<strong>Empresa:</strong><%=e.getNome() %>	
					<br/>
					<strong>Endereço:</strong> <%=e.getEndereco() %> - <%=e.getCidade() %> - <%=e.getEstado() %>
					</span>
					
					<span class="content_senha">
					SENHA<br/>
					<%=ficha.getNumero() %>
					</span>
					
					<span class="content_guiche">
					GUICHÊ<br/>
					<%=ficha.getGuiche().getNumero() %>
					</span>
					
					<span class="data_chamada"><%=Data.converterData(ficha.getData())  %> - Horário Chamada: <%=Data.converterHora(ficha.getData()) %></span>
					
					<div class="clr"></div>
				</div>
			</div>
			
			<div class="quadro_historico">
				
				<h2>Histórico (5 Últimas)</h2>
				
				<%
					for(int i = 0; i < fichas.size() && i < 5; i++){
						Ficha f = fichas.get(i);
				%>
				
				<span class="content_senha">
				SENHA<br/>
				<%=f.getNumero() %>
				</span>
					
				<span class="content_guiche">
				GUICHÊ<br/>
				<%=f.getGuiche().getNumero() %>
				</span>
				
				<%
					}
				%>
				
			</div>
			
			<div class="clr"></div>
