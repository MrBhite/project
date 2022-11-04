onload = function () {
    var arr = document.getElementsByClassName("slide");
    for (var i = 0; i < arr.length; i++) {
        arr[i].style.left = i * 960 + "px";
    }
}

function LeftMove() {
    var arr = document.getElementsByClassName("slide");//获取三个子div
    for (var i = 0; i < arr.length; i++) {
        var left = parseFloat(arr[i].style.left);
        left -= 1;     //让图片左移1个px
        var width = 960;//图片的宽度
        if (left <= -width) {
            left = (arr.length - 1) * width;//当图片完全走出显示框，拼接到末尾，因为拼接起来总长度就是(arr.length) * width 但还有一张在显示，所以就减一
            clearInterval(moveId); //然后停止循环
        }
        arr[i].style.left = left + "px";
    }

}

function divInterval() {
    moveId = setInterval(LeftMove, 10);//设置一个定时器,10ms移1px
}

timeId = setInterval(divInterval, 2000);//设置定时器。2s后开始滚动

// 当浏览器窗口切出或页面切换到其他页面一段时间再回来时，轮播效果会加速。
//虽然窗口切出去了，定时器依然执行，但页面却没有将效果显示，所以切回来后会将之前的效果显示出来而加速轮播图。

//页面失去焦点定时器停止
onblur = function () {
    clearInterval(timeId);
    clearInterval(moveId);
}
//页面获取焦点时重启定时器
onfocus = function () {
    moveId = setInterval(LeftMove, 10);
    clearInterval(timeId);//重新打开一个定时前，先关闭之前定时器。
    timeId = setInterval(divInterval, 9600);//重启一个定时器
}