const button = document.getElementById('button');
button.addEventListener('click', () => {
    fetch("http://localhost:8080/movies")
        .then(response => response.json())
        .then(data => {
            // Use the JSON data to create and append HTML elements
            const container = document.getElementById('data-list');
            for (let item of data) {
                const element = document.createElement('p');
                element.innerHTML = item.name;
                container.appendChild(element);
            }
        });
});

function getData() {
    $.ajax({
        url: "http://localhost:8080/movies",
        success: function (result) {
            // Process the data and display it on the page
            var dataList = "";
            for (var i = 0; i < result.length; i++) {
                dataList += "<li>" + result + "</li>";
            }
            $("#data-list").html(dataList);
        }
    });
}