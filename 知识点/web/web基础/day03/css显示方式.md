显示方式    display
每个元素都有自己默认的显示方式
a.块元素    p h1~h6 div table ul ol
独占一行,从上往下,可以设置宽高
display:block
b.行内元素    span a
从左往右,不能换行,不可以设置宽高(实际内容撑开大小)
display:inline;
c.行内块元素    img input 
从左往右,不能换行,可以设置宽高
display:inline-block;

应用:如果需要修改元素的默认显示方式,可以通过display样式进行修改

d.隐藏元素
display:none;
opacity:0;    (opacityt:不透明)

定位:定位元素相对于正常位置应该出现的位置
a.流定位(流布局)		符合标准文档流(默认定位)
	块级元素		从上往下
	行内元素		从左往右
b.浮动定位		脱离标准文档流,让出原来位置
	float:left|right;
	浮动会对下面的节点有影响
	
	清除浮动带来的影响
	clear:left|right|both;
	left|right代表元素左边或者右边不允许有浮动元素
	both代表元素两边不允许有浮动元素
	哪个元素受到影响就在哪个元素里面写clear清除影响

c.position定位(结合位置:top|right|bottom|left)
相对定位:relative
相对于自己原来的位置,不脱离标准文档流,不让出原来的位置

绝对定位:absolute
相对于定位过了的祖先元素,如果没有定位过了的祖先元素则按照最初包含
快的位置定位,摆脱标准文档流,让出原来位置

固定位置:fixed
以当前窗口为参考点,脱离标准文档流,让出原来位置

堆叠
z-index:数值;
数值越大,距离用户越近.
