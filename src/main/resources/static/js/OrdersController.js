   var Company=(function(){
   var getEmpresa=function(empresa,tiempo,llama){
        if(tiempo!==""){
            
            axios.get('/info/'+JSON.stringify(empresa)+"/"+tiempo).then(function (response) {



          
                    var fin=response.data;
                    var x = document.createElement("IMG");
                    console.log(response.data);                

                    document.getElementById("title").innerHTML = fin.Title;
                    document.getElementById("year").innerHTML = fin.Year;
                    document.getElementById("released").innerHTML = fin.Released;
                    document.getElementById("plot").innerHTML = fin.Plot;
                    document.getElementById("runtime").innerHTML = fin.Runtime;
                    x.setAttribute("src", fin.Poster);
                    x.setAttribute("width", "400");
                    x.setAttribute("height", "400");
                    x.setAttribute("alt", "FIN");   
                    document.body.appendChild(x);
                })
                .catch(function (error) {

                    console.log(error);
                });
            
        }else{
           axios.get('/info/'+JSON.stringify(empresa)).then(function (response) {
   
   
   

                var fin=response.data;
                var x = document.createElement("IMG");
                console.log(response.data);                

                document.getElementById("title").innerHTML = fin.Title;
                document.getElementById("year").innerHTML = fin.Year;
                document.getElementById("released").innerHTML = fin.Released;
                document.getElementById("plot").innerHTML = fin.Plot;
                document.getElementById("runtime").innerHTML = fin.Runtime;
                x.setAttribute("src", fin.Poster);
                x.setAttribute("width", "400");
                x.setAttribute("height", "400");
                x.setAttribute("alt", "FIN");   
                document.body.appendChild(x);
            })
            .catch(function (error) {

                console.log(error);
            });

}
        };

    return {

        getEmpresa:getEmpresa
    };
    })(); 
   
   
   
   


