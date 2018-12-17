/*
	let user = new XMLHttpRequest();

	user.open('GET', '/usuario');

	user.onload = function(){
		if(this.status != 200){
			console.log("Erro");
		}
		else{
			console.log(this.responseText);

		    let a = JSON.parse(this.responseText);

		    console.log(a);

		    for(let i=0; i<a.content.length; i++){
		     document.getElementById('Usuario').innerHTML += '<tr><th>' +a.content[i].nome + '</th>'+
		     '<th>' +a.content[i].email + '</th>'+
		     '<th>' +a.content[i].senha + '</th>'+
		     '<th>' +a.content[i].dataNasc + '</th></tr>';

		}
	};
  }
	 user.send();

function setarDados(){

	 let setarUsuario = new XMLHttpRequest();
	 setarUsuario.open('POST', '/usuario');

	 setarUsuario.onload = function(){
		  if(this.status == 200){
			  console.log("Sucesso");
		      console.log(JSON.parse(this.responseText));
		  }
	  };
	  setarUsuario.setRequestHeader('Content-Type', 'application/json');

	     let new_usuario = { 
	    		'nome': document.getElementById('nome').value,
	    		'email': document.getElementById('email').value,
	    		'senha': document.getElementById('senha').value,
	    		'dataNasc': document.getElementById('nascimento').value


	     };

	     setarUsuario.send(JSON.stringify(new_usuario)); 
};*/

function setarDados(){
	let nome = document.getElementById("nome").value;
	let email = document.getElementById("email").value;
	let senha = document.getElementById("senha").value;
	let nasc = document.getElementById("nascimento").value;

	let novo_usuario = {
			nome: nome,
			email: email,
			senha: senha,
			dataNasc: nasc
	};

	fetch("/usuario", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(novo_usuario)
	
	}).then(function(response){
		alert("Dados cadastrados");
		window.location.href = "http://localhost:8080/lista.html";
	}).catch(function(error){
		console.log(error);
	});

}


function criarTabela(){
	fetch("/usuario")
	.then(function(response){
		if(response.status >= 200 && response.status <= 300){

			response.json()
			.then(function(data){

				let tb = document.getElementById("usuario");

				tb.innerHTML = "<tr><th>Nome</th><th>Email</th><th>Senha</th><th>Nascimento</th></tr>"

				for(let i=0; i<data.content.length; i++){

					let p = data.content[i];

					tb.innerHTML += `<tr><th>${p.nome}</th><th>${p.email}</th><th>${p.senha}</th><th>${p.dataNasc}</th></tr>`

				}

			});

		}
	}).catch(function(error){
		console.log(error);
	});
}
function limpar(){
	document.getElementById('nome').value=''; 
	document.getElementById('email').value='';
	document.getElementById('senha').value=''; 
	document.getElementById('nascimento').value='';
	
	alert("Dados apagados!");

}

criarTabela();