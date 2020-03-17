function post() {
    let questionId = $("#question_id").val();
    let content = $("#comment_content").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        data: JSON.stringify({
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if (response.code == 200){
                $("#comment_section").hide();
            }else{
                if (response.code == 2003){
                    var isAccepted = confirm(response.message);
                    if (isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=Iv1.be207b81d5e1e4e4&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }else{
                    alert(response.message);
                }
            }
        },
        dataType: "json",
        contentType:"application/json"
    });
}