onload = function () {
    var arr = document.getElementsByClassName("slide");
    for (var i = 0; i < arr.length; i++) {
        arr[i].style.left = i * 960 + "px";
    }
}

function LeftMove() {
    var arr = document.getElementsByClassName("slide");//��ȡ������div
    for (var i = 0; i < arr.length; i++) {
        var left = parseFloat(arr[i].style.left);
        left -= 1;     //��ͼƬ����1��px
        var width = 960;//ͼƬ�Ŀ��
        if (left <= -width) {
            left = (arr.length - 1) * width;//��ͼƬ��ȫ�߳���ʾ��ƴ�ӵ�ĩβ����Ϊƴ�������ܳ��Ⱦ���(arr.length) * width ������һ������ʾ�����Ծͼ�һ
            clearInterval(moveId); //Ȼ��ֹͣѭ��
        }
        arr[i].style.left = left + "px";
    }

}

function divInterval() {
    moveId = setInterval(LeftMove, 10);//����һ����ʱ��,10ms��1px
}

timeId = setInterval(divInterval, 2000);//���ö�ʱ����2s��ʼ����

// ������������г���ҳ���л�������ҳ��һ��ʱ���ٻ���ʱ���ֲ�Ч������١�
//��Ȼ�����г�ȥ�ˣ���ʱ����Ȼִ�У���ҳ��ȴû�н�Ч����ʾ�������л�����Ὣ֮ǰ��Ч����ʾ�����������ֲ�ͼ��

//ҳ��ʧȥ���㶨ʱ��ֹͣ
onblur = function () {
    clearInterval(timeId);
    clearInterval(moveId);
}
//ҳ���ȡ����ʱ������ʱ��
onfocus = function () {
    moveId = setInterval(LeftMove, 10);
    clearInterval(timeId);//���´�һ����ʱǰ���ȹر�֮ǰ��ʱ����
    timeId = setInterval(divInterval, 9600);//����һ����ʱ��
}