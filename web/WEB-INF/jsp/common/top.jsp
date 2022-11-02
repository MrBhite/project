<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/10/31
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
--%>
<!DOCTYPE html>

<html>

<head>
    <link rel="StyleSheet" href="css/project.css" type="text/css" media="screen" />
    <title>JPetStore Demo</title>
</head>

<body>
    <div id="Header">

        <div id="Logo">
            <div id="LogoContent">
                <a href="mainForm"><img src="images/logo-topbar.gif" /></a>
            </div>
        </div>
        <div id="Search">
            <div id="SearchContent">
                <form action="#" method="post">
                    <input type="text" name="keyword" size="50">
                    <input type="submit" value="Search">
                </form>
            </div>
        </div>

        <div id="Menu" >
            <div id="MenuContent">
                <!--<a href="#"><img align="middle" name="img_cart" src="images/cart.gif" /></a><br>-->
                <a href="#">Cart</a><br>
                <a href="#">Sign In</a><br>
                <!--<img align="middle" src="images/separator.gif" />-->
                <a href="#">Sign Out</a><br>
                <!--<img align="middle" src="images/separator.gif" />-->
                <a href="#">My Account</a><br>
                <!--<img align="middle" src="images/separator.gif" />-->
                <a href="help.html">?</a></div>
        </div>
        <br>



        <div id="QuickLinks">
            <a href="#"><img src="images/sm_fish.gif" /></a>
            <img src="images/fish1.gif" />
            <a href="#"><img src="images/sm_dogs.gif" /></a>
            <img src="images/dog1.gif" />
            <a href="#"><img src="images/sm_reptiles.gif" /></a>
            <img src="images/lizard1.gif" />
            <a href="#"><img src="images/sm_cats.gif" /></a>
            <img src="images/cat1.gif" />
            <a href="#"><img src="images/sm_birds.gif" /></a>
        </div>

    </div>

<div id="Content"><stripes:messages />