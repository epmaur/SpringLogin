function register() {
  $('.error').css('display', 'none');
  const username = $('#username').val();
  const password = $('#password').val();
  const password2 = $('#password2').val();
  if (password.length < 8) {
    console.log('Pw too short');
    $('#wrong-pw-error').css('display', 'block');
  } else if (password !== password2) {
    console.log('Invalid pw');
    $('#diff-pw-error').css('display', 'block');
  } else {
    console.log('Success!');
    var http = new XMLHttpRequest();
    var url = "/register";
    var params = '{ "username": ' + username + ', "password":' + password + ', "passwordConfirmation": ' + password2 +' }';
    http.open("POST", url, true);
    http.setRequestHeader("Content-type", "application/json");
    http.onreadystatechange = function() {
        if(http.readyState == 4 && http.status == 200) {
            if (http.responseText == "Error this username already exists") {
                $('#user-exists-error').css('display', 'block');
            } else if (http.responseText == "User created") {
                $('#user-created').css('display', 'block');
            }
        }
    }
    http.send(params);

  }
}
