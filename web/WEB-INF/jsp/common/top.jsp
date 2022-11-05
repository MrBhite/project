<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <link rel="StyleSheet" href="css/project.css" type="text/css" media="screen" />
    <title>JPetStore Demo</title>
    <meta charset="UTF-8" >
    <script >
        //src="roll.js"用不了，无法显示，放在head里可以
        onload = function () {
            var arr = document.getElementsByClassName("slide");
            for (var i = 0; i < arr.length; i++) {
                arr[i].style.left = i * 960 + "px";
            }
        }

        function LeftMove() {
            var arr = document.getElementsByClassName("slide");//获取子div
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
            moveId = setInterval(LeftMove, 20);//设置一个定时器,20ms移1px
        }

        timeId = setInterval(divInterval, 3000);//设置定时器。3s后开始滚动

        // 当浏览器窗口切出或页面切换到其他页面一段时间再回来时，轮播效果会加速。
        //虽然窗口切出去了，定时器依然执行，但页面却没有将效果显示，所以切回来后会将之前的效果显示出来而加速轮播图。

        //页面失去焦点定时器停止
        onblur = function () {
            clearInterval(timeId);
            clearInterval(moveId);
        }
        //页面获取焦点时重启定时器
        onfocus = function () {
            clearInterval(timeId);
            clearInterval(moveId);
            moveId = setInterval(LeftMove, 20);
            clearInterval(timeId);//重新打开一个定时前，先关闭之前定时器。
            timeId = setInterval(divInterval, 9000);//重启一个定时器
        }
    </script>
</head>

<body >
<div id="Header">
    <div id="Menu">
        <!--MenuDropdownButton打开下拉菜单-->
        <span id="MenuDropdownButton"><img src="images/menu-菜单.svg" alt="Menu"></span>
        <!--div内下拉菜单内容-->
        <div id="MenuContent">
            <a href="#">Cart</a>
            <a href="#">Sign In</a>
            <a href="#">Sign Out</a>
            <a href="#">My Account</a>
            <a href="help.html">?</a>
        </div>
    </div>
    <div id="Logo">
        <div id="LogoContent">
            <a href="mainForm"><img id="jpet" src="images/jpetstore.png" /></a>
            <!--不用+../,因为是转发的-->
        </div>



    </div>
    <div id="Search">
        <div id="SearchContent">
            <form action="#" method="post">
                <input id="searchtext" type="text" name="keyword" size="60">
                <input id="searchicon" type="image" src="images/未标题-2.png" alt="Submit" size="50" align="bottom" />
            </form>
            </form>
        </div>

    </div>
    <!--
    <br>
    <div id="QuickLinks">
        <a href="#"><img src="images/sm_fish.gif" /></a>

        <a href="#"><img src="images/sm_dogs.gif" /></a>

        <a href="#"><img src="images/sm_reptiles.gif" /></a>

        <a href="#"><img src="images/sm_cats.gif" /></a>

        <a href="#"><img src="images/sm_birds.gif" /></a>

    </div>
-->
</div>


<div id="Content"><stripes:messages />