<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <link rel="StyleSheet" href="project.css" type="text/css" media="screen" />
    <title>JPetStore Demo</title>
    <meta charset="UTF-8" >
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