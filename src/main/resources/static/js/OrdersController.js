function company() {
    var empresa={};
    var ciudad= {};
    var tiempo={};
    function getEmpresa(){
        var empres=document.getElementById("x").value;
        var tiemp=document.getElementById("id").value;
        alert(tiemp);
        alert(empres);
        
        axios.get('/info/'+tiemp+"/"+empres).then(function (response) {
                console.log(response.data)
                ciudad=response.data;
        
            })
           .catch(function (error) {
                console.log(error);
            });
    }
    return {
        getEmpresa:getEmpresa
    };
    
    
    
}
var compan=company();
console.log(compan);

        
        

        
        var empresa= {};
        var ciudad={};
        var tiempo={};
        function getEmpresa(em) {
            var empres=document.getElementById("x").value;
            tiempo=document.getElementById("id").value;
            alert(empres);
            axios.get('/info/'+tiempo+"/"+empres)
                .then(function (response) {
                    ciudad=response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
            }



