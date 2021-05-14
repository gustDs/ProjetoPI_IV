/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    var wURI = "ProdutosServlet"
    var wMLabels = []
    var wMData = []
    var wMBgColors = []
    var wMBoderColors = []

    $.ajax({
        type: "post",
        url: wURI,
    }).then((res, textStatus, jqXHR) => {
        var wStatus = jqXHR.status;
        if (wStatus == 200) {
            var wData = JSON.parse(res)
            wData.forEach(element => {
                wMLabels.push(element["nmProduto"]);
                wMData.push(element["qtProduto"]);
                wMBgColors.push('#' + Math.floor(Math.random() * 16777100).toString(16));
                wMBoderColors.push('black')
            });
            var ctx = document.getElementById('myChart').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                responsive: true,
                data: {

                    labels: wMLabels,
                    datasets: [{
                            label: 'ESTOQUE DE PRODUTOS',
                            labels: wMData,
                            data: wMData,
                            backgroundColor: wMBgColors,
                            borderColor: wMBoderColors,
                            borderWidth: 1
                        }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        }
    }).catch((err) => {
        alert("err")
        console.log("err")
        console.log(err)
    });
});

