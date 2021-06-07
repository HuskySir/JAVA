
<a name="paths"></a>
## 资源

<a name="student-controller_resource"></a>
### Student-controller
Student Controller


<a name="addstudentusingpost"></a>
#### 添加学生信息
```
POST /student
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**birthday**  <br>*可选*|生日|string (date-time)|
|**Query**|**birthplace**  <br>*可选*|籍贯|string|
|**Query**|**id**  <br>*可选*|学号|integer (int32)|
|**Query**|**name**  <br>*可选*|姓名|string|
|**Query**|**score**  <br>*可选*|成绩|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/student
```


###### 请求 query
```
json :
{
  "birthday" : "string",
  "birthplace" : "string",
  "id" : 0,
  "name" : "string",
  "score" : 0
}
```


<a name="updatestudentusingput"></a>
#### 修改学生信息
```
PUT /student
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Query**|**birthday**  <br>*可选*|生日|string (date-time)|
|**Query**|**birthplace**  <br>*可选*|籍贯|string|
|**Query**|**id**  <br>*可选*|学号|integer (int32)|
|**Query**|**name**  <br>*可选*|姓名|string|
|**Query**|**score**  <br>*可选*|成绩|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/student
```


###### 请求 query
```
json :
{
  "birthday" : "string",
  "birthplace" : "string",
  "id" : 0,
  "name" : "string",
  "score" : 0
}
```


<a name="findstudentbyidusingget"></a>
#### 查询单个学生信息
```
GET /student/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[Student](#student)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/student/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "birthday" : "string",
  "birthplace" : "string",
  "id" : 0,
  "name" : "string",
  "score" : 0
}
```


<a name="deletestudentbyidusingdelete"></a>
#### 删除学生信息
```
DELETE /student/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|无内容|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/student/0
```


<a name="findallstudentusingget"></a>
#### 查询所有学生信息
```
GET /students
```


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|< [Student](#student) > array|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/students
```


##### HTTP响应示例

###### 响应 200
```
json :
[ {
  "birthday" : "string",
  "birthplace" : "string",
  "id" : 0,
  "name" : "string",
  "score" : 0
} ]
```



