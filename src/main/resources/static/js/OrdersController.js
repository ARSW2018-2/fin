   var Company=(function(){

    var getEmpresa=function(empresa,tiempo,llama){
    
    axios.get('/info/'+JSON.stringify(empresa)+"/"+tiempo).then(function (response) {
            llama.Eraser();
            var fin=response.data;
            console.log(response.data);                
           
            document.getElementById("title").innerHTML += fin.Title;
               document.getElementById("year").innerHTML += fin.Year;
               document.getElementById("released").innerHTML += fin.Released;
               document.getElementById("plot").innerHTML += fin.Plot;
               document.getElementById("runtime").innerHTML += fin.Runtime;
               
   
        })
        .catch(function (error) {
            
            console.log(error);
        });
    };

    return {

        getEmpresa:getEmpresa
    };
    })(); 
   
   
   
   


