
function validarRecuperarEmail() {
	
	email = document.getElementById("txtEmail").value;
	
	if(email==""){
		exibir_div_por_id("div_alert_recuperar_email");
		exibir_div_por_id("alt_email_vazio");
		return false;
	}
	else{
		return true;
	}
}

function fechar_alert_recuperar_email() {
	ocultar_div_por_id("div_alert_recuperar_email");
	ocultar_div_por_id("alt_email_vazio");
}

$(document).ready(function() {
	jQuery(function($){
		$("#txtCpf").mask("999.999.999-99", {placeholder: " "});
	});
});

function fechar_alert_cadastro() {
	document.getElementById("div_alert_cadastro").style.display = "none";
	ocultar_div_por_id("alt_cpf_invalido");
	ocultar_div_por_id("alt_campos_nao_preenchidos");
	ocultar_div_por_id("alt_senhas");
}

function exibir_div_por_id(id){
	document.getElementById(id).style.display = "block";
}

function ocultar_div_por_id(id) {
	document.getElementById(id).style.display = "none";
}

function validarCadastroUsuario() {

	fechar_alert_cadastro();
	pintarBordas();
	
	if(preenchimentoCadastroUsuario()==true){
		
		cpf = document.getElementById("txtCpf").value.replace(".","");
		cpf = cpf.replace(".","");
		cpf = cpf.replace("-","");
		
		senha = document.getElementById("txtSenha").value;
		confirmSenha = document.getElementById("txtConfirmsenha").value;
		
		if(verificarCpf(cpf)!=true){
			exibir_div_por_id("div_alert_cadastro");
			exibir_div_por_id("alt_cpf_invalido");
		}else if(senha!=confirmSenha) {
			exibir_div_por_id("div_alert_cadastro");
			exibir_div_por_id("alt_senhas");
			document.getElementById("txtSenha").value="";
			document.getElementById("txtConfirmsenha").value="";
			document.getElementById("txtSenha").focus();
		}else{
			document.form_cadastro_cliente.submit();
		}
		
	}
	
}

function preenchimentoCadastroUsuario(){
	
	nome = document.getElementById("txtNome").value;
	cpf = document.getElementById("txtCpf").value.replace(".","");
	cpf = cpf.replace(".","");
	cpf = cpf.replace("-","");
	email = document.getElementById("txtEmail").value;
	endereco = document.getElementById("txtEndereco").value;
	login = document.getElementById("txtLogin").value;
	senha = document.getElementById("txtSenha").value;
	confirmSenha = document.getElementById("txtConfirmsenha").value;
	
	if(nome=="" || cpf=="" || email=="" || endereco=="" || login=="" || senha=="" || confirmSenha==""){
		exibir_div_por_id("div_alert_cadastro");
		exibir_div_por_id("alt_campos_nao_preenchidos");
	}else{
		return true;
	}

}

function pintarBordas() {
	
	nome = document.getElementById("txtNome").value;
	cpf = document.getElementById("txtCpf").value.replace(".","");
	cpf = cpf.replace(".","");
	cpf = cpf.replace("-","");
	email = document.getElementById("txtEmail").value;
	endereco = document.getElementById("txtEndereco").value;
	login = document.getElementById("txtLogin").value;
	senha = document.getElementById("txtSenha").value;
	confirmSenha = document.getElementById("txtConfirmsenha").value;
	
	if(confirmSenha==""){
		document.getElementById("txtConfirmsenha").style.border = "solid 1px red";
		document.getElementById("txtConfirmsenha").focus();
	}else{
		document.getElementById("txtConfirmsenha").style.border = "solid 1px #BDBFC1";
	}
	
	if(senha==""){
		document.getElementById("txtSenha").style.border = "solid 1px red";
		document.getElementById("txtSenha").focus();
	}else{
		document.getElementById("txtSenha").style.border = "solid 1px #BDBFC1";
	}
	
	if(login==""){
		document.getElementById("txtLogin").style.border = "solid 1px red";
		document.getElementById("txtLogin").focus();
	}else{
		document.getElementById("txtLogin").style.border = "solid 1px #BDBFC1";
	}
	
	if(email==""){
		document.getElementById("txtEmail").style.border = "solid 1px red";
		document.getElementById("txtEmail").focus();
	}else{
		document.getElementById("txtEmail").style.border = "solid 1px #BDBFC1";
	}
		
	if(endereco==""){
		document.getElementById("txtEndereco").style.border = "solid 1px red";
		document.getElementById("txtEndereco").focus();
	}else{
		document.getElementById("txtEndereco").style.border = "solid 1px #BDBFC1";
	}
	
	if(cpf==""){
		document.getElementById("txtCpf").style.border = "solid 1px red";
		document.getElementById("txtCpf").focus();
	}else{
		document.getElementById("txtCpf").style.border = "solid 1px #BDBFC1";
	}
	
	if(nome==""){
		document.getElementById("txtNome").style.border = "solid 1px red";
		document.getElementById("txtNome").focus();
	}else{
		document.getElementById("txtNome").style.border = "solid 1px #BDBFC1";
	}
	
}

function verificarCpf(cpf) {
	if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111"
			|| cpf == "22222222222" || cpf == "33333333333"
			|| cpf == "44444444444" || cpf == "55555555555"
			|| cpf == "66666666666" || cpf == "77777777777"
			|| cpf == "88888888888" || cpf == "99999999999")
		return false;
	add = 0;
	for (var i = 0; i < 9; i++)
		add += parseInt(cpf.charAt(i)) * (10 - i);
	rev = 11 - (add % 11);
	if (rev == 10 || rev == 11)
		rev = 0;
	if (rev != parseInt(cpf.charAt(9)))
		return false;
	add = 0;
	for (i = 0; i < 10; i++)
		add += parseInt(cpf.charAt(i)) * (11 - i);
	rev = 11 - (add % 11);
	if (rev == 10 || rev == 11)
		rev = 0;
	if (rev != parseInt(cpf.charAt(10)))
		return false;
	return true;
}

function VerificaNomeProprio(caracter) {
	
	var tecla = "";
	
	if(window.event) { // Internet Explorer
		tecla = event.keyCode;
	}
	else { // Firefox
		tecla = caracter.which;
	}

	//alert(tecla);

	if((tecla != 0) && (tecla != 8) && (tecla != 113) && (tecla != 97) && 
			(tecla != 98) && (tecla != 122) && (tecla != 119) && (tecla != 115) &&
			(tecla != 120) && (tecla != 101) && (tecla != 100) && (tecla != 99) && 
			(tecla != 114) && (tecla != 102) && (tecla != 118) && (tecla != 116) && 
			(tecla != 103) && (tecla != 121) && (tecla != 104) && (tecla != 110) && 
			(tecla != 117) && (tecla != 106) && (tecla != 109) && (tecla != 105) && 
			(tecla != 107) && (tecla != 111) && (tecla != 108) && (tecla != 112) && (tecla != 231) && 
			(tecla != 81) && (tecla != 65) && (tecla != 90) && (tecla != 87) && 
			(tecla != 83) && (tecla != 88) && (tecla != 69) && (tecla != 68) && 
			(tecla != 67) && (tecla != 82) && (tecla != 10) && (tecla != 86) && 
			(tecla != 84) && (tecla != 70) && (tecla != 71) && (tecla != 66) && 
			(tecla != 89) && (tecla != 72) && (tecla != 78) && (tecla != 85) && 
			(tecla != 74) && (tecla != 77) && (tecla != 73) && (tecla != 75) && 
			(tecla != 79) && (tecla != 76) && (tecla != 80) && (tecla != 199) &&
			(tecla != 32) && (tecla != 45) && (tecla != 126) &&
			(tecla != 225) && (tecla != 226) && (tecla != 233) && (tecla != 234) && 
			(tecla != 237) && (tecla != 238) && (tecla != 243) && (tecla != 244) && 
			(tecla != 250) && (tecla != 251) && (tecla != 193) && (tecla != 201) && 
			(tecla != 205) && (tecla != 211) && (tecla != 218) && (tecla != 227) && 
			(tecla != 245) && (tecla != 194) && (tecla != 195) && (tecla != 213) &&
			(tecla != 202) && (tecla != 209) && (tecla != 241) && (tecla != 206) && (
					tecla != 212) && (tecla != 219)) { 

		return false;

	}
	else 
	{ 
		return true; 
	}

}