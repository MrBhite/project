//商品展示js
var xhr;
var name;

var inform = document.getElementById('inform');
var images = document.getElementById('mainimages');

images.addEventListener('mouseover', function(e){
    showInform(e.target.alt);
})

images.addEventListener('mouseleave',function (){
    inform.style.display='none';
})

function createXMLHttpRequest()
{
    xhr = new XMLHttpRequest();
}

function showInform(categoryId)
{
    name  = categoryId;
    var url = "categoryShowJs?categoryId="+categoryId;
    sendRequest(url);
}

function sendRequest(url)
{
    createXMLHttpRequest();
    xhr.onreadystatechange = processInform;
    xhr.open("GET",url,true);
    xhr.send(null);

}
function processInform()
{
    if (xhr.readyState ==4)
        if(xhr.status ==200)
        {
            var rep = xhr.responseText;
            inform.innerText = rep;
            inform.className = name;
            inform.style.display = 'block';
        }
}

function hiddenInform(event)
{
    var informDiv = document.getElementById('inform');
    var x = event.clientX;
    var y = event.clientY;
    var divx1 = informDiv.offsetLeft;
    var divy1 = informDiv.offsetTop;
    var divx2 = informDiv.offsetLeft+informDiv.offsetWidth;
    var divy2 = informDiv.offsetTop+informDiv.offsetHeight;
    if(x < divx1 || x > divx2 || y < divy1 || y> divy2)
    {
        document.getElementById('inform').style.display = 'none';
    }
}

