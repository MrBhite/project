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
        <!--
            <a href="#"><img src="images/fish_icon.gif" /></a> <br/>
            Saltwater, Freshwater <br />
            <a href="#"><img src="images/dogs_icon.gif" /></a> <br/>
            Various Breeds <br />
            <a href="#"><img src="images/cats_icon.gif" /></a> <br/>
            Various Breeds, Exotic Varieties <br />
            <a href="#"><img src="images/reptiles_icon.gif" /></a><br/>
            Lizards, Turtles, Snakes <br />
            <a href="#"><img src="images/birds_icon.gif" /></a> <br/>
            Exotic Varieties
        -->
        <div id="SidebarContent">
            <ul>
                <li>
                    <div id="Welcome">
                        <div id="WelcomeContent">登录用户的FirstName&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    </div>
                </li>
                <li><a class="active" href="#">Fishs</a>
                    <p>Saltwater, Freshwater</p>
                </li>
                <li><a href="#">Dogs</a>
                    <p>Various Breeds</p>
                </li>
                <li><a href="#">Cats</a>
                    <p>Various Breeds, Exotic Varieties</p>
                </li>
                <li><a href="#">Reptiles</a>
                    <p>Lizards, Turtles, Snakes</p>
                </li>
                <li><a href="#">Birds</a>
                    <p> Exotic Varieties</p>
                </li>

                <li><br></li>

            </ul>
        </div>
    </div>


    <div class="rollimages" style="οnmοuseοver=" stop()" οnmοuseοut="start()">
    <div class="slide">
        <img src="images\maltese-1123016_960_720.jpg" s>
    </div>
    <div class="slide">
        <img src="images\discus-fish-1943755_960_720.jpg" s>
    </div>
    <div class="slide">
        <img src="images\gecko-2299365_960_720.jpg" s>
    </div>
    <div class="slide">
        <img src="images\kingfisher-2046453_960_720.jpg" s>
    </div>
    <div class="slide">
        <img src="images\kitten-4611189_960_720.jpg" s>
    </div>
</div>




<!--<div id="MainImage">
<div id="MainImageContent">
<map name="estoremap">
<area alt="Birds" coords="72,2,280,250"
href="" shape="RECT" />
<area alt="Fish" coords="2,180,72,250"
href="" shape="RECT" />
<area alt="Dogs" coords="60,250,130,320"
href="" shape="RECT" />
<area alt="Reptiles" coords="140,270,210,340"
href="" shape="RECT" />
<area alt="Cats" coords="225,240,295,310"
href="" shape="RECT" />
<area alt="Birds" coords="280,180,350,250"
href="" shape="RECT" />
</map>
<img height="355" src="images/splash.gif" align="middle"
usemap="#estoremap" width="350" /></div>
</div>-->



<div id="petlink">
    <ul>
        <p>COME ON AND PICK YOUR LOVELY PETS</p><br>
        <li>
            <a href="#"><img src="images/bird01.jpg"></a>
        </li>
        <li>
            <a href="#"><img src="images/cat01.jpg"></a>
        </li>
        <li>
            <a href="#"><img src="images/dog01.jpg"></a>
        </li>
        <li>
            <a href="#"><img src="images/lizard01.jpg"></a>
        </li>
        <li>
            <a href="#"><img src="images/fish01.jpg"></a>
        </li>
    </ul>
</div>

<div id="Separator">&nbsp;</div>
</div>


<%@include file="../common/bottom.jsp"%>