var apiClient = (function () {
  var url = window.location.href + "logs";

  var getMessages = function () {
    $("#mensaj tbody").empty();
    console.log(url);
    axios.get(url).then((res) => {
      console.log(res);
      res.data.map((mensaje) =>
        $("#mensaj tbody").append(
          `<tr><td>${mensaje.description}</td>
			<td>${mensaje.date}</td></tr>`
        )
      );
    });
  };

  var addMessage = function (mensaje) {
    console.log("sdfsds");
    axios.post(url, mensaje).then((res) => {
      getMessages();
    });
  };

  return {
    addMessage: addMessage,
    getMessages: getMessages,
  };
})();
