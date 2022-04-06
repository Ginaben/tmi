$(function () {

    let username = $("#username");
    let password = $("#password");
    let rePassword = $("#rePassword");
    let nickName = $("#nickName");
    let month = $("#month");
    let day = $("#day");


/* 유효성 검사 */

    //비밀번호 확인
    rePassword.blur(function () {
        let pwdCheck = $(".re-password-error");

        if (password.val() !== rePassword.val()) {
            pwdCheck.text("비밀번호가 일치하지 않습니다.");
            pwdCheck.css("color", "red");
            this.focus();

        } else {
            pwdCheck.text("비밀번호가 일치합니다.");
            pwdCheck.css("color", "blue");
        }
    }); //end rePassword.blur


    //마지막 유효성검사사
    $("#jonBtn").on("click", function () {
        if (username.val() !== "" && password.val() !== ""
            && nickName.val() !== "" && month.val() !== "" && day.val() !== "") {
            $("#joinForm").submit();
        }
    }); //end submit


}); //end script
