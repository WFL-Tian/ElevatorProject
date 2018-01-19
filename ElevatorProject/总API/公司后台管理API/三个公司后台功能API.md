### 开发商
#### 1.上传审查文件,申请安装电梯
```
POST /xgdt/develop/add
```

参数
```
companyId = 1245
loupanId = "12334"
fileNameList = ""
```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [

    //添加成功自动刷新页面
    ]
```

#### 2.查看已提交申请的进度
```
POST /xgdt/develop/showShengpi
```

参数
```
companyId = 1245

```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
       "shenpiId": "11", //审批请求id
       "companyId": 1245, // 开发商id
       "loupanId": "246", // 楼盘id
       "createTime": "2018-10-01", // 申请日期
       "shenpiTime": "2018-10-29", // 审批时间
       "shenpiStatus": 3, // 审批状态
       "shenpiResult": "不行"// 审批结果说明
       //查询成功自动刷新页面
    ]
```

#### 3.管理楼盘(分配物业公司,查)
```
POST /xgdt/develop/showLoupan
```

参数
```
companyId = 1245

```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
            "loupanId": "", // 楼盘id
            "loupanAddr": "", // 楼盘地址
            "createTime": "", // 创建日期
            "updateTime": "", //   更新日期
    ]
```



```
POST /xgdt/develop/allot
```

参数
```
companyId = 1245
wuyeId = 123453
elevatorId = 28282
```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
       //分配成功自动刷新页面
    ]
```


### 物业公司
#### 1.管理楼盘(分配维保公司,查)
```
POST /xgdt/wuye/showLoupan
```

参数
```
wuyeId = 1245

```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
            "loupanId": "", // 楼盘id
            "loupanAddr": "", // 楼盘地址
            "createTime": "", // 创建日期
            "updateTime": "", //   更新日期
    ]
```

```
POST /xgdt/wuye/allot
```

参数
```
wuyeId = 1245
weibaoId = 123453
elevatorId = 28282
```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
       //分配成功自动刷新页面
    ]
```

### 维保公司
#### 1.查看维保的电梯
```
POST /xgdt/weibao/showElevator
```

参数
```
weibaoId = 1245

pageIndex: 1, //页码
pageSize: 10, //本页数据量
elevatorType: 1, //电梯类型
elevatorStatus: 1, //如果传递了就专门查询此条件的数据

```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [{
            "elevatorList": [{
            "elevatorId": "123123123"  //电梯Id
            "elevatorType": "电梯类型", //电梯类型
            "elevatorStatus": "正常使用", //后台给数据
            "factorNumber": "gegr123123", //出厂编号
            "installCompany": "xxx公司", //安装单位
            "phone": "123123123", //开发商电话
            "floorLevels": 16, //此电梯层数
            "adminName": "xxx", //安装的安全管理员姓名
            "madeCompany": "xxx公司", //制造公司

            "productionDate": "1231231123", //传递用时间戳，生产日期格式转变为2019-01-01

            "registrationCode": "字符串", //设备注册代码
            "equipmentModel": "字符串", //设备型号
            "loupanAddr": "xx小区", //所在楼盘的名称
            "detailAddr": "详细地址：某个单元楼", //详细地址，商场的东侧之类的

            "createTime": "2017-01-01" //创建时间
            }]
    }]
```

### 提交注册信息,注册账号
```
POST /xgdt/company/register
```

参数
```
companyName = ""  // 单位名称 
companyPhone = ""  //单位固定电话
companyEmail = ""  //企业邮箱
companyShStatus = 0  //审核状态
companyType = 0  //单位类型
enterprisefax = ""  //企业传真
companyAddress = ""  //单位地址
legalrepresentative = ""  //法定代表人
legalrepresentativePhone = ""  //法定代表人
organizationCode = ""  //组织机构代码
```

返回
```
    "code": 0,
    "msg": "成功",
    "data": [
    //添加成功自动刷新页面
    ]
```