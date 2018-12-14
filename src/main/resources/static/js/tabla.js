var ConsultControladorTabla =(function(){

    var MostrarInfo=function(){
        var pelicula=document.getElementById("x").value;
        var ano=document.getElementById("año").value;

        var llamado ={

            exito: function(response){

                var lista="";
                for(x in response){
                    if(x.includes("Compania")){
                        lista =response[x];
                    }
                }
                if(lista==""){
                    lista=response;
                }
                var first=0;
                var tabla= document.getElementById('tabla');
                for(property in lista){
                    var objeto=lista[property];
                    alert(objeto);
                    console.log(property);
                    
                    num.appendChild(document.createTextNode(property));
                    
                    tabla.append(tr);
                }
            },
            OnFailed: function(exception){
                console.log(exception);
                alert("Problema con el servicio.");
            },
            Eraser:function(){
                var ta= document.getElementById('tabla');
                ta.removeChild(ta.childNodes[0]);  
            }
        };
        Company.getEmpresa(pelicula,ano,llamado);
    };
    return{
        MostrarInfo:MostrarInfo
    };
})();


