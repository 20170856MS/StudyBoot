console.log("memberAdd");

$("#all").click(function(c){
    let ch = $(this).prop("checked");
    
    $(".check").prop("checked", ch);

});

$(".check").click(function(){
    
    let flag = true;
    
    $(".check").each(function(idx, item){
        let ch = $(this).prop("checked");
        if(!ch){
            flag=false;
        }
            console.log(ch);

    });

    $("#all").prop("checked", flag);


})

$("#joinButton").click(function(){
    if(results.includes(false)){
        alert("필수 입력이 비었습니다.");
    }else{
        alert("전송");
        //$("#joinForm").submit();
    }
    
    // let c = true;
    // $.each(results, function(idx, item){
    //     if(item){
    //         alert("필수 입력이 비었습니다.");
    //         c = false;
    //         return c;
    //     }
    // })

    // //event 강제실행
    // $("#joinForm").submit();
});


///id 체크
$("#inputId").blur(function(){
    let id = $("#inputId").val();
    let result = nullCheck($("#inputId").val(), "#inputIdResult", "ID");
    results[0] = result;
    console.log(result);

    //단 id가 null이 아닐때
    $.get("./idCheck?id="+id, function(data){
        console.log("Data : ",data);
        if(data=='0'){
            $("#inputIdResult").html("사용 가능한 ID");
        }else{
            $("#inputIdResult").html("이미 사용중인 ID");
            
        }
    })
});

/// pw 체크
$("#inputPw").blur(function(){
    let result = nullCheck($("#inputPw").val(), "#inputPwResult", "PW");
    results[1] = result;
});

$("#inputPw").change(function(){
    $("#inputPwCheck").val("");
    results[2] = result;
    $("#inputPwCheckResult").html("");
});

// pwCheck 체크
$("#inputPwCheck").blur(function(){
    let result = equals($("#inputPw").val(),$("#inputPwCheck").val());
    console.log("result : ", result);
    if(result){
        $("#inputPwCheckResult").html("정상");
    }else{
        $("#inputPwCheckResult").html("PW가 다릅니다");
    }

});

$("#inputPw").on({
    blur: function(){
        let result = equals($("#inputPw").val(),$("#inputPwCheck").val());
        results[1] = result;
    };
    change: function(){
        $("#inputPwCheck").val("");
        results[2] = result;
        $("#inputPwCheckResult").html("");
    };
});


/// name 체크
$("#inputName").blur(function(){
    let result = nullCheck($("#inputName").val(), "#inputNameResult", "Name");
    results[3] = result;
});

/// email 체크
$("#inputEmail").blur(function(){
    let result = nullCheck($("#inputEmail").val(), "#inputEmailResult", "Email");
    results[4] = result;
});

// id, pw, pwEquals, name, email
let results = [false,false,false,false,false];
