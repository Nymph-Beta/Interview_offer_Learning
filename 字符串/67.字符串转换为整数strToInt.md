#### 剑指offer67.把字符串转换为整数

```
将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。

Iuput:
+2147483647
1a33

Output:
2147483647
0
```


#### 题解一: 字符转数字,通过ASCII码与0的ASCII码相减

分为符号位和数字

```
判断符号位
int sign = 1;
if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){
	sign = (str.charAt(i) == '+' ) ? 1 : -1;
        i++;
}
```

```
转换过程
while(i < str.length() && Character.isDigit(str.charAt(i))){
	int digit = str.charAt(i) - '0';
        result = result * 10 + digit;
}
```

```
判断越界:
if(result > Integer.MAX_VALUE && sign == 1)
	return Integer.MAX_VALUE;
else if (result > (long) Integer.MAX_VALUE + 1 && sign == -1) {
	return Integer.MIN_VALUE;
```
