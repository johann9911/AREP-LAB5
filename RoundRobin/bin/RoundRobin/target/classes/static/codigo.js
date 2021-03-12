var boton = document.getElementById("boton_add");



function ponerMensaje(){
	var URLactual = window.location;

	var mensaje = document.getElementById("mensaje").value;
   	console.log(mensaje); 
   	axios.post(URLactual, mensaje)
   		.then(res => {
	        if(res.status==200) {
       			console.log(res.data);
         		mensaje.innerHTML = res.data.title;
            }
       		console.log(res);
     	})
     	.catch(function(err) {
       		console.log(err);
     	});
}