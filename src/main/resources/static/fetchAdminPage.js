function getData() {
    $.ajax({
        url: "http://localhost:8080/movies",
        success: function (result) {
            var dataList = "";
            dataList = "<li>" + result + "</li>";
            $("#data-list").html(dataList);
        }
    });
}

window.onload = function () {



    const button1 = document.getElementById('data');
    button1.addEventListener('click', () => {
        fetch("http://localhost:8080/movies")
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById('data-list');
                for (let item of data) {
                    const element = document.createElement('p');
                    element.innerHTML = `ID: ${item._id.toString()}<br>
                        Category: ${item.category}<br>
                        Actors: ${item.actors.join(', ')}<br>
                        Rating: ${item.rating}<br>
                        Director: ${item.director}<br>
                        Release Year: ${item.releaseYear}<br>
                        Title: ${item.title}`;
                    container.appendChild(element);
                }
            });
    });

    const button2 = document.getElementById('clientsDisplay');
    button2.addEventListener('click', () => {
        fetch("http://localhost:8080/admin/clients")
            .then(response => response.json())
            .then(data => {
                const container = document.getElementById('data-list-clients');
                for (let item of data) {
                    const element = document.createElement('p');
                    element.innerHTML = `
                        ID: ${item._id.toString()}<br>
                        Name: ${item.name}<br>
                        Nazwisko: ${item.surname}<br>
                        Phone: ${item.phone_number}<br>                     
                        Address: ${item.address}<br>
                        Data rejestracji: ${item.date_of_registration}<br>`;
                    container.appendChild(element);
                }
            });
    });



}