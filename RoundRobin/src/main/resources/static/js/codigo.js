var apiClient = (function () {
  var url = window.location.href + "logs";

  var getMessages = function () {
    $("#mensaj tbody").empty();
    axios.get(url).then((res) => {
      res.data.map((mensaje) =>
        $("#mensaj tbody").append(
          `<tr><td>${mensaje.description}</td>
			<td>${mensaje.date}</td></tr>`
        )
      );
    }).catch(error => {
        console.log(error);
      });
  };

  var addMessage = function (mensaje) {
    console.log("sdfsds");
    axios.post(url, mensaje).then((res) => {
      getMessages();
    }).catch(error => {
        console.log(error);
      });
  };

  return {
    addMessage: addMessage,
    getMessages: getMessages,
  };
})();
