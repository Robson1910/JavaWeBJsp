/**
 * Validando o login
 */
 
 function validar(){
	
	let login = formLogar.usuario.value
	let password = formLogar.senha.value
	
	if(login === ""){
		alert("Preencha o campo usuário!")
		formLogar.usuario.focus()
		return false
	} else if(password === ""){
		alert("Preencha o campo senha!")
		formLogar.senha.focus()
		return false
	}else{
		document.forms["formLogar"].submit()
	}	
}