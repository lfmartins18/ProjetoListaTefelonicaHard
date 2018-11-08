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
	