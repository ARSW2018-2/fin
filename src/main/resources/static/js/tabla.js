var ConsultControladorTabla =(function(){

    var MostrarInfo=function(){
        var empresa=document.getElementById("x").value;
        var tiempo=document.getElementById("id").value;
        alert(tiempo);
        alert(empresa);
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
                    console.log(property);
                    if(first==0){
                        var encabezado =document.createElement('tr');
                        var m=document.createElement('td');
                        m.appendChild(document.createTextNode("No"));
                        encabezado.appendChild(m);
                        for(nombre in objeto){
                            var propiedad=document.createElement('td');
                            propiedad.appendChild(document.createTextNode(nombre));
                            encabezado.appendChild(propiedad);
                        }
                        primero=1;
                        tabla.appendChild(encabezado);
                    }
                    var tr=document.createElement('tr');
                    var num =document.createElement('td');
                    num.appendChild(document.createTextNode(property));
                    
                    tr.appendChild(num);
                    for(x in objeto){
                        var td =document.createElement('td');
                        var objetosub=objeto[x];
                        
                        for(y in objetosub){
                            console.log(objetosub[y]);
                            td.appendChild(document.createTextNode(objetosub[y]));
                        }
                        
                        tr.appendChild(td);
                    }
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
        Company.getEmpresa(empresa,tiempo,llamado);
    };
    return{
        MostrarInfo:MostrarInfo
    };
})();


