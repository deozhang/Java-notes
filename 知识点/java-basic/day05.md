数组的定义：数组一旦定义，就不可更改
int[] arr=new int[10];
int[] arr1=new int[]{};
int[] arr2={};

写法:int arr[]=new int[10];
初始化：
int[] arr=new int[10];不能在定义的同时初始化，有对应类型的默认值

int[] arr1=new int[]{};
int[] arr2={};
这两种可以在定义的同时初始化

数组的属性：length（长度，元素个数，空间大小）
通过  数组名.length  的方式获取数组的元素个数（长度）
通过   数组名[i]  i表示元素下标的方式，获取数组中的下标为i的元素
数组的遍历：
通过与for搭配，查看数组的元素

数组方法：
复制的方法
1.arrcopy
2.copyof
注意参数的表达的含义

冒泡排序
让数组进行升序排序
双层for循环搭配
for(int i=0;i<arr.length-1;i++){//一共要几轮
 for(int j=0;j<arr.length-1-i;j++){//每轮循环几次
	if(arr[j]>arr[j+1]){//排序规则的处理逻辑
		int temp=arr[j+1];
		arr[j+1]=arr[j];
		arr[i]=temp;
	}
 }	

}


数组排序的方法：
  sort（arr）方法




















































