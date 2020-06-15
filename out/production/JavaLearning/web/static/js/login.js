$(function () {

    //浏览器窗口发生变化时触发resize事件
    $(window).resize(function () {
        // console.log(this);
        if($(this).width() < 1220){
            $('#div_title').css('visibility','hidden');
        }
        else{
            $('#div_title').css('visibility','visible');
        }
    });

    //验证码对比信息
    var check = ['1shnu','sh1nu','shnu1'];

    //点击更换验证码图片
    var i = 1;
    $('#checkimg').click(function () {
        var j = i%3 + 1; // 2,3,1
        $(this).prop('src','static/img/'+j+'.jpeg');
        i++;
    })

    //给表单绑定提交事件
    $('form').submit(function () {
        //用户名和密码都输入时，fulfil的值才为true
        var fulfil = $('#username').val() && $('#password').val();
        //校验是否有未填项或失败项
        if(!fulfil){
            $('#span_tip').html('用户名或密码为空！');
            return false;
        }
        //校验验证码
        else if (i%3 == 1){
            if ($('#check').val() !== check[0]) {
                $('#span_tip').html('验证码不正确！');
                return false;
            }
        }
        else if (i%3 == 2){
            if ($('#check').val() !== check[1]) {
                $('#span_tip').html('验证码不正确！');
                return false;
            }
        }
        else if (i%3 == 3){
            if ($('#check').val() !== check[2]) {
                $('#span_tip').html('验证码不正确！');
                return false;
            }
        }
        return true;
    })
})
