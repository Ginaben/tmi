$(function () {

    let username = $("#username");
    let password = $("#password");
    let rePassword = $("#rePassword");
    let nickName = $("#nickName");
    let month = $("#month");
    let day = $("#day");
    let check1 = false;


    // 닉네임 중복 확인
    $("#nickname-check").off().on("click", function () {
        let nickname = $("#nickName");

        if (nickname.val() === "" || nickname.val() === "undefined") {
            alert("닉네임을 입력해주세요.");
        } else {
            $.ajax({
                url: "/nickName",
                method: "post",
                dataType: "json",
                data: {
                    nickName: nickname.val()
                }
            })
                .done(function (data) {
                    let $nickname = $(".nickname-error");
                    if (data.result === 1) {
                        $nickname.text("이미 존재하는 닉네임입니다.");
                        $nickname.css("color", "red");
                        nickname.focus();
                    } else {
                        check1 = true;
                        $nickname.text("사용 가능한 닉네임입니다.");
                        $nickname.css("color", "blue");
                    }
                });
        }
    });


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


    // 회원가입 버튼
    $("#joinBtn").on("click", function () {
        if (check1 === true && (password.val() === rePassword.val())) {
            $("#joinForm").submit();
        }
    });


}); //end script
