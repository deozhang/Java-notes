console.log(Math.ceil(12.3));
		
console.log(Math.ceil(Math.random()*10));
		

var date = new Date();//当前系统时间
console.log(date);
var date2 = new Date("2008/08/08");//指定日期时间		
console.log(date2);

console.log(date.getFullYear());
console.log(date.toLocaleDateString());
console.log(date.toLocaleDateString(date.setDate(31)));

//Array对象
var arr1 = [10,"张三",true,{"name":"zs"}];//常用
console.log(arr1);

var arr2 = new Array();

var arr3 = new Array(5);
console.log(arr3);

var a = [["江苏","安徽","浙江"],["南京","宿州","合肥"],["老王","老宋","老张"]];
console.log(a);
console.log(a[1][1]);

var arr4 = [37,12,78,45,234];
console.log(arr4.sort());//默认规则

//自定义规则排序(从小到大)
function sortSelf(a,b){
	return a-b;
}
arr4.sort(sortSelf);
console.log(arr4);
	

//数组和字符串之间的转换
console.log(arr1.toString());

var arr5 = "q,w,e,r,t".split(",");
console.log(arr5);

//案例
var str1 = "name=zs&age=20&hobby=sing";
var arr6 = str1.split("&");
for(var i=0;i<arr6.length;i++){
	var newArr = arr6[i].split("=");
	arr6[i] = newArr;
}
console.log(arr6);

//js中没有方法的重载,调用时能找到方法名,则执行方法体内容
function f1(){
	console.log("哈哈哈");
}

function f1(a){
	console.log("去死");
}

// f1();

var f2 = function(a,b){
	console.log(a+b);
}
// f2(4,7);

var f3 = new Function("a","b","console.log(a+b);");
f3(5,8);

var f4 = (a,b) => {return a+b};
var f4 = (a,b) => a+b;
console.log(f4(5,6));

/*
在外部函数中使用内部函数的私有变量不可以,
在内部函数中访问外部函数的私有变量可以
*/
var y = 3;
function outer(){
	var x = 1;
	function inner(){
		y = 2;
		console.log(x);
	}
	inner();
	console.log(y);
}
outer();
var str = "console.log('deo')";
eval("console.log('Java')");	//注意:console.log里面的输入字符串要用单引号
eval(str);

var reg1 = /a/g;
var reg2 = new RegExp("a","g");

var str2 = "dalao";
console.log(/^da/.test(str2));
console.log(/^abc{3}/.test("abccc"));
console.log(/a/.test("A"));
console.log(/a/i.test("A"));

var reg = /\d/g;
var str = "sg45dfg68gfjh89";
console.log(str.replace(reg,"*"));
console.log(str.match(reg));
console.log(str.search(reg));

