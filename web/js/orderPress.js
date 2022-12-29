var opens = document.querySelectorAll('.tbody');


for(var i = 0; i < opens.length; i++){

}
opens.forEach(this.addEventListener('click', function (e){
    if(e.target.matches('button')){
        var tbody = e.target.parentNode.parentNode.parentNode;
        if(window.getComputedStyle(tbody.children[1].children[0]).display==='none'){
            for(var i = 1; i<tbody.childElementCount; i++){
                tbody.children[i].children[0].style.display='table-cell';
                tbody.children[i].children[1].style.display='table-cell';
            }
        }else{
            for(var i = 1; i<tbody.childElementCount; i++){
                tbody.children[i].children[0].style.display='none';
                tbody.children[i].children[1].style.display='none';
            }
        }
    }
}));