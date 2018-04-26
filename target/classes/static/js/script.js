function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}

function set_cookie(name, value) {
    document.cookie = name +'='+ value +'; Path=/;';
}
function delete_cookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

/*
var vueLog = new Vue({
    el:'#loggedIn',
    data: {
        logged_in_msg: "",
        isLoggedIn : false
    },
    mounted() {
        if ((getCookie("access_token"))) {
            axios.get("/getUsername?access_token=" + getCookie("access_token"))
                .then(function(response) {
                    this.logged_in_msg = "Tere tulemast tagasi, " + response.data;
                    this.isLoggedIn = true;
                    console.log(this.logged_in_msg);
                    console.log(response.data);
                }.bind(this))
                .catch(function(error) {
                    delete_cookie("access_token");
                    console.log(error);
                });
        }
    },
    methods: {
        logOut(){
            axios.get("/logout?access_token="+getCookie("access_token"))
                .then(function(response){
                    this.isLoggedIn = false;
                    this.logged_in_msg  = "";
                    delete_cookie("access_token")
                }.bind(this))
        }
    }

});
*/