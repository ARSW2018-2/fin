   var Company=(function(){

    var getEmpresa=function(empresa,tiempo,llama){
    
    axios.get('/info/'+tiempo+"/"+empresa).then(function (response) {
            llama.Eraser();
            console.log(response.data);                
            llama.exito(response.data);
          
        })
        .catch(function (error) {
            
            console.log(error);
        });
    };

    return {

        getEmpresa:getEmpresa
    };
    })(); 
   
   
   
   


