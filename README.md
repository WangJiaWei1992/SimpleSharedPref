# SimpleSharedPref
## 如何使用
### 1.在接口ISharedPref中添加键值对信息
```java
@KEY("sample")
@DEFAULT("10")
Call<Integer> sample();
```
表示添加一个key为sample，默认值为10，类型为int的键值信息（不需要你去实现）

### 2.使用它
```java
SimpleSharedPref.getService().sample().put(10);
int r = SimpleSharedPref.getService().sample().get();
```
### 备注
在SharedPrefCall中需要获取context,添加到自己的工程时，只需要将context改一下即可
