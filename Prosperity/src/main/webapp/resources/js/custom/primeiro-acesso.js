function validarSenha() {
	senha = document.FormSenha.senha.value;
	confirmarSenha = document.FormSenha.confirmarSenha.value;
	if (senha != confirmarSenha) {
		var div = document.getElementById("textDiv").className = "alert alert-danger text-center";

		textDiv.textContent = "Senhas diferentes";

		var text = "[" + div.textContent + "]";
		return false;
	}
	return true;
}
