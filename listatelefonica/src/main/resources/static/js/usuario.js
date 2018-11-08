    alert('OI');
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
	 
	 let setarUsuario = new XMLHttpRequest();
	 setarUsuario.open('POST', '/usuario');
	  
	 setarUsuario.onload = function setarDados(){
		  if(this.status == 200){
			  console.log("Sucesso");
		      console.log(JSON.parse(this.responseText));
		  }
	  };
	  setarUsuario.setRequestHeader('Content-Type', 'application/json');
	     
	     let new_usuario = {"nome": "Jair", "email": "ptnao@gmail.com",
	    		 "senha": "jairsalvador", "1970-05-20"};

	     setarUsuario.send(JSON.stringify(new_usuario)); 