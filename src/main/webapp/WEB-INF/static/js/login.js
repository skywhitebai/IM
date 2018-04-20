function login() {
    var userName=$('#userName').val();
    var password=$('#password').val();
    if(userName==''){
        alertWarning("用户名不能为空");
        return;
    }
    if(password==''){
        alertWarning("密码不能为空");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/account/doLogin",
        data:{userName:userName,password:password},
        datatype: "text",
        success: function (data) {
            if(data.code=="200"){
                window.location.href="/";
            }
            else{
                alertErro(data.message);
            }
        }
    });
}