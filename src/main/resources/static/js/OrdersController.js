    var empresa={};
    var ciudad= {};
    var tiempo={};

function company() {

    function getEmpresa(){
        var empres=document.getElementById("x").value;
        var tiemp=document.getElementById("id").value;
        alert(tiemp);
        alert(empres);
   
        axios.get('/info/'+tiemp+"/"+empres).then(function (response) {
                console.log(response.data)
                alert(response.data);
                ciudad=response.data;
                alert(ciudad);
            })
           .catch(function (error) {
                console.log(error);
            });
    
    }
    function getVal(){
        alert(ciudad);
        return ciudad;
    }
    



    return {
        getEmpresa:getEmpresa,
        getVal:getVal
    };
    
    
    
}
var compan=company();
console.log(compan);


