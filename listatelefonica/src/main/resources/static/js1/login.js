function logarDados(){
	let email = document.getElementById("email").value;
	let senha = document.getElementById("senha").value;

	let novo_usuario = {
			email: email,
			senha: senha,
	};

	fetch("/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(novo_usuario)
	
	}).then(function(response){

		window.location.href = "http://localhost:8080/index.html";
	}).catch(function(error){
		console.log(error);
	});

}
