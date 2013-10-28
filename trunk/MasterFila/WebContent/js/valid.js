function validarPreenchimento(){
	
	if(document.getElementById("txtCNPJ").value==""){
		construirAlert("Prencha o CNPJ!");
	}else if(validarCNPJ(document.getElementById("txtCNPJ").value)==false){
		construirAlert("CNPJ Invalido!");
	}else if(document.getElementById("txtRazao").value==""){
		construirAlert("Prencha a Razao Social!");
	}else if(document.getElementById("txtNomeAparecer").value==""){
		construirAlert("Preencher Nome que vai aparecer no MF");
	}else if(document.getElementById("txtEmail").value==""){
		construirAlert("Preencher Email");
	}else if(document.getElementById("selCategoria").value=="0"){
		construirAlert("Selecione uma categoria");
	}else if(!form_cadastra_empresa.foto.value){
		construirAlert("Selecione uma imagem");
	}else{
			var foto = form_cadastra_empresa.foto.value;
			extensao = (foto.substring(foto.lastIndexOf("."))).toLowerCase(); 
			extensoes_permitidas = new Array(".gif", ".jpg", ".png");
			permitida = false;
				for (var i = 0; i < extensoes_permitidas.length; i++) {
	         		if (extensoes_permitidas[i] == extensao) {
	         			permitida = true;
	         			break;
	         		}
	         	}
				if (permitida!=true) {
					construirAlert("Extensao do arquivo para o Banner Principal n&atilde;o &eacute; permitida.<br/>Utilize apenas .gif .png ou .jpg");
				}else{
					if(document.getElementById("txtEndereco").value==""){
						construirAlert("Preencher Endereco");
					}else if(document.getElementById("sel_estado").value=="0"){
						construirAlert("Selecione um Estado");
					}else if(document.getElementById("sel_cidade").value=="0"){
						construirAlert("Selecione uma cidade");
					}else{
						document.getElementById("form_cadastra_empresa").submit();
					}
				}
	}
}

function construirAlert(msg) {
	document.getElementById('content_alert').style.display = "block";
	document.getElementById('lbl_msg').innerHTML = msg;
}

function validarCNPJ(cnpj) {

	cnpj = cnpj.replace(/[^\d]+/g,'');

	if(cnpj == '') return false;
	
	if (cnpj.length != 14)
		return false;

	// Elimina CNPJs invalidos conhecidos
	if (cnpj == "00000000000000" || 
		cnpj == "11111111111111" || 
		cnpj == "22222222222222" || 
		cnpj == "33333333333333" || 
		cnpj == "44444444444444" || 
		cnpj == "55555555555555" || 
		cnpj == "66666666666666" || 
		cnpj == "77777777777777" || 
		cnpj == "88888888888888" || 
		cnpj == "99999999999999")
		return false;
		
	// Valida DVs
	tamanho = cnpj.length - 2
	numeros = cnpj.substring(0,tamanho);
	digitos = cnpj.substring(tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
	  soma += numeros.charAt(tamanho - i) * pos--;
	  if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(0))
		return false;
		
	tamanho = tamanho + 1;
	numeros = cnpj.substring(0,tamanho);
	soma = 0;
	pos = tamanho - 7;
	for (i = tamanho; i >= 1; i--) {
	  soma += numeros.charAt(tamanho - i) * pos--;
	  if (pos < 2)
			pos = 9;
	}
	resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
	if (resultado != digitos.charAt(1))
		  return false;
		  
	return true;
   
}