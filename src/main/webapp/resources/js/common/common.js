// 点击切换图片就是再次发送同一个请求，加上一个两位的数字，就会重新更换前端的验证码图片
function changeVerifyCode(img) {
    img.src = "/o2o/Kaptcha?" + Math.floor(Math.random() * 100);
}

//找出地址栏中是否有指定名字的参数，例如shopId
function getQueryString(parameter) {
    let reg = new RegExp("(^|&)" + parameter + "=([^&]*)(&|$)", "i");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    return null;
}