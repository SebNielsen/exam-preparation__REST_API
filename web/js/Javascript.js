var id;
$(document).ready(function(){
   $('#svg2').on('click', function(event){
       $('#'+id).css("fill","#c0c0c0");
       id = event.target.id;
       $('#'+id).css("fill","#ff0000");
       
       //var url = "http://restcountries.eu/rest/v1/alpha?codes="+id;
       var url = "http://localhost:8080/Exam-Preparation-REST-AJAX-Javascript/Servlet?id="+id;
       $.ajax({
        url: url,
        method: "GET",
        success: function (data) {
            $('#countryName').text("Country:" + data[0].name);
            $('#population').text("Population: " + data[0].population);
            $('#area').text("Area: " + data[0].area);
            $('#borders').text("Borders: " + data[0].borders);
        },
        });
   }); 
});

