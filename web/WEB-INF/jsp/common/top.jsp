<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/10/31
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%--
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"

<!DOCTYPE html>

<html>--%>

<head>
    <link rel="StyleSheet" href="css/JPetProject.css" type="text/css" media="screen" />
    <title>JPetStore Demo</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>

<body>
    <div id="Header">

        <div id="Logo">
            <div id="LogoContent">
                <a href="main"><img src="images/jpetstore.png" id="mainPic"/></a>
            </div>
        </div>


        <div id="Menu">

            <div id="MenuContent">
                <a href="cart"><img align="middle" name="img_cart" src="images/cart.gif" /></a>
                <img align="middle" src="images/separator.gif" />
                <c:if test="${sessionScope.account==null}">
                    <a href="signOnInterface">Sign In</a>
                </c:if>
                <c:if test="${sessionScope.account!=null}">
                    <a href="signOut">Sign Out</a>
                    <img align="middle" src="images/separator.gif" />
                    <a href="myAccount">My Account</a>
                </c:if>
                <img align="middle" src="images/separator.gif" />
                <a href="help.html">?</a>
            </div>
        </div>

        <div id="Search">
            <div id="SearchContent">
                <form action="search" method="post">


                <input type="text" id="searchText" name="keyword" size="14" value="Manx" style="color: #eaac0085;">
                <input type="submit" value="Search">
                </form>
                <script>
                    var text=document.querySelector('#searchText');
                    text.onfocus=function(){
                        this.style.color='#eaac00';
                        if(this.value =='Manx'){
                            this.value ='';
                        }
                    }
                    text.onblur=function(){
                        if(text.value === ''){
                            this.value ='Manx';
                            this.style.color='#eaac0085';
                        }
                    }
                </script>
                <div id="productAutoComplete">
                    <ul id="productAutoList">
<%--                        <li class="productAutoItem"></li>--%>
<%--                        <li class="productAutoItem"></li>--%>
<%--                        <li class="productAutoItem"></li>--%>
<%--                        <li class="productAutoItem"></li>--%>
<%--                        <li class="productAutoItem"></li>--%>
                    </ul>
                </div>

            </div>
        </div>



        <div id="QuickLinks">
            <a href="category?categoryId=FISH"><img src="images/sm_fish.gif" /></a>
            <img src="images/separator.gif" />
            <a href="category?categoryId=DOGS"><img src="images/sm_dogs.gif" /></a>
            <img src="images/separator.gif" />
            <a href="category?categoryId=CATS"><img src="images/sm_reptiles.gif" /></a>
            <img src="images/separator.gif" />
            <a href="category?categoryId=REPTILES"><img src="images/sm_cats.gif" /></a>
            <img src="images/separator.gif" />
            <a href="category?categoryId=BIRDS"><img src="images/sm_birds.gif" /></a>
        </div>

    </div>

<div id="Content">