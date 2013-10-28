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
Fila fila = Fachada.getInstance().cadastroFila().buscarFila(tipo);

Ficha ficha = fila.ultimaFichaChamada();
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
					
					<span class="data_chamada"><%=ficha.getData() %> - Horário Chamada: <%=ficha.getData().getTime() %></span>
					
					<div class="clr"></div>
				</div>
				
				<div class="quadro_estatistica">
					
					<h2>Estatísticas de Chamada</h2>
					
					Quadro de Estatísticas					
					
					<div class="clr"></div>
				</div>
				
			</div>
			
			<div class="quadro_historico">
				
				<h2>Histórico (5 Últimas)</h2>
				
				<%
				List<Ficha> fichas = GerenciadorArquivo.historico;
					for(int i = 0; i < fichas.size(); i++){
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
