<%--
  Created by IntelliJ IDEA.
  User: MrBhite
  Date: 2022/10/31
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/top.jsp"%>

<div id="Welcome">
    <div id="WelcomeContent">
        <%--显示登录用户的FirstName--%>
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <!--页面相同，请求时带参数categoryId,可以通过getparameter获取到数据，实现点击不同按钮展示不同分类-->
            <a href="category?categoryId=FISH"><img src="images/fish_icon.gif" /></a> <br/>
            Saltwater, Freshwater <br />
            <a href="category?categoryId=DOGS"><img src="images/dogs_icon.gif" /></a> <br/>
            Various Breeds <br />
            <a href="category?categoryId=CATS"><img src="images/cats_icon.gif" /></a> <br/>
            Various Breeds, Exotic Varieties <br />
            <a href="category?categoryId=REPTILES"><img src="images/reptiles_icon.gif" /></a><br/>
            Lizards, Turtles, Snakes <br />
            <a href="category?categoryId=BIRDS"><img src="images/birds_icon.gif" /></a> <br/>
            Exotic Varieties
        </div>
    </div>

    <div id="MainImage">
        <div id="MainImageContent">
            <map name="estoremap" id="mainimages">
                <area alt="Birds" coords="72,2,280,250"
                      href="category?categoryId=BIRDS" shape="RECT" data-categoryId="BIRDS"/>
                <area alt="Fish" coords="2,180,72,250"
                      href="category?categoryId=FISH" shape="RECT" />
                <area alt="Dogs" coords="60,250,130,320"
                      href="category?categoryId=DOGS" shape="RECT" />
                <area alt="Reptiles" coords="140,270,210,340"
                      href="category?categoryId=REPTILES" shape="RECT" />
                <area alt="Cats" coords="225,240,295,310"
                      href="category?categoryId=CATS" shape="RECT" />
                <area alt="Birds" coords="280,180,350,250"
                      href="category?categoryId=BIRDS" shape="RECT" />
            </map>
            <img height="355" src="images/splash.gif" align="middle"
                 usemap="#estoremap" width="350" /></div>
    </div>
    <div class="inform" id="inform" style="display: none"></div>
    <div id="Separator">&nbsp;</div>
</div>

<script src="js/productDetail.js"></script>
<%@include file="../common/bottom.jsp"%>