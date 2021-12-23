function  ajax() {
    //1.创建XMLHttpRequest对象
    var xmlHttp;
    //根据不同版本浏览器，创建不同的对象
    if (window.XMLHttpRequest) {
        //非IE
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //IE
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
    }
    //2.打开连接
    xmlHttp.open("post","/admin/json",true);
    //3.指定回调函数
    xmlHttp.onreadystatechange=function(){
        //3.1 判断状态
        if(xmlHttp.readyState==4) {
            //3.2 接受返回的内容
            var jsonStr = xmlHttp.responseText;
            var array = JSON.parse(jsonStr);
            document.getElementById("adminMessage").innerHTML ="<span id='adminName'>"+" "+array.userName+" "+"</span>";
            document.getElementById("adminProFilePhoto").src=array.userProfilePhoto;
        }
    }
    //4.发送
    //  xmlHttp.send(null);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.send(null);
}