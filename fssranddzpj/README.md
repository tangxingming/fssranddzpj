# fssranddzpj
非税收入和电子票据

# 目录结构
## 在com.youchu.fssranddzpj包下进行划分：
```
common包：
存放一些常用的工具类，比如Exception，DateUtils等。
```
```
config包：
存放项目公用的配置文件。
```
```
module包：
存放业务模块代码，详情如下：
agreement包：自动报销转账三方协议签署功能
direct包：非税直接缴费信息记账功能
indirect包：非税跨行缴费待查信息核对补录功能
reconciliation包：日终对账功能
reimbursement包：非税缴费自动报销功能
solve包：非税资金划解业务信息记账功能
sys包：系统功能
```
