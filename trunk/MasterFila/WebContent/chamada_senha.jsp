<%@ include file="topo.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MasterFila - In�cio</title>
<link href="css/style.css" rel="stylesheet" />

<script type="text/javascript">  
	
    var variaveis =location.search.split("?");
    var id_fila = variaveis[1].split("=");
    
    $(document).ready(function(){  
        
        setInterval(carregar, 2000);  // Executa a fun��o carregar a cada meio segundo.   

        function carregar(){
           $.ajax({              
                  type: 'post', // O tipo de requisi��o
                  data: 'function=carregar', // Vari�veis que ser�o passadas pro script Server Inside.
                  url: 'arquivos_filas/'+id_fila[1]+'.jsp',
                  success: function(retorno){ //Caso o script obtenha sucesso ele carreda no #pannel as informa��es.
                    $('#content').html(retorno); 				
                  }
             });         
        } 
        
    });  

    </script>  

</head>
<body>
	
	<%@ include file="componente_localizar_empresa.jsp"%>
	
	<%@ include file="menu.jsp"%>
	
	<div class="clr"></div>
	
	<div class="limite">
		
		<div class="content_chamada_senhas" id="content">
			
			<img alt="" src="gif_load.gif" class="img_load"/>

		</div>
		
		<div class="clr"></div>
			
	</div>
	
	<div class="clr"></div>
	
	<br/>
		
</body>
</html>

<%@ include file="rodape.jsp"%>
