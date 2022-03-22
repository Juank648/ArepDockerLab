let button = document.getElementById('pubMsg');

button.addEventListener('click', function () {
    addMessage()
});

function addMessage(){
    let url = window.location.href + '/messages';
    let msg = document.getElementById("message").value;
    axios.post(url,msg)
        .then(res => {
                getMessages()
            }
        )

}

function getMessages(){
    let url = window.location.href + '/messages';
    $("#table_messages > tbody").empty();
    axios.get(url).then(res=>{
        res.data.map(messagetable=>{
            $("#table_messages > tbody").append(
                "<tr>" +
                "<td>" + messagetable.msgContent + "</td>" +
                "<td>" + messagetable.date + "</td>" +
                "</tr>"
            );
        })
    })
}