### 请实现一个函数，把字符串 s 中的每个空格替换成"%20"

* 示例：
* 输入： s = "We are happy."
* 输出： We%20are%20happy.

#### 方法一:replace函数

```
replace()方法两种形式
replace(char oldChar, char newChar) or replace(CharSequence target, CharSequence replacement)

```

```
public String replaceSpace(String s) {
        String replaceStr = s.replace(" ","%20");
        return replaceStr;
    }
```

#### 方法二:创建一个新的动态数组

先查找数组中空格个数并统计数字

设置新数组长度为 `charArray.length + 2*spacenum`

暴力方法

```
if(ch == ' '){
	replaceArrays[index++] = '%';
        replaceArrays[index++] = '2';
        replaceArrays[index++] = '0';
}else{
        replaceArrays[index++] = ch;
}
```

#### 方法三:arraycopy函数

自定义函数 `insertElement(char[] array, int index, char element) `

具体实现为

```
public static char[] insertElement(char[] array, int index, char element) {
        char[] newArray = new char[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        return newArray;
}
```

arraycopy()方法从两个坐标复制原数组的元素到数组,并规定复制的长度
