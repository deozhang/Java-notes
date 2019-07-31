var li_1Ele = document.getElementById("li_1");
// console.log(li_1Ele);

var liEles = document.getElementsByTagName("li");
// console.log(liEles);
// console.log(liEles[1].innerHTML);
// console.log(liEles[0].innerHTML);
// console.log(liEles[0].innerText);//获取纯文本,不带文本

var li_2Eles = document.getElementsByName("li_2");
// console.log(li_2Eles);
// console.log(li_2Eles[0])

var parentEle = li_1Ele.parentNode;
// console.log(parentEle);

var liEles = parentEle.childNodes;
// console.log(liEles);

var liEle = document.querySelector("#li_1");
// console.log(liEle);

var liEles = document.querySelectorAll("li");
// console.log(liEles);

var li_3Eles = document.getElementsByClassName("li_3");
console.log(li_3Eles);