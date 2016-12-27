# SpringAxis2webservice
该工程是使用Spring 和axis2 发布webservice 的一个简单实例

以下几点需要注意:
1以下提出的工程结构目录是固定的,不能修改
 WEB-INF/services/axis/META-INF/services.xml
 其中除了axis 这个文件夹的名字可以改以外,其他的都不能改
 
2生成客户端的访问路径为http://ip:port/services/SayHello?wsdl

3其他需要注意的地方在代码注释中已经提及

总的来说就是
1在spring中将需要发布的类 注入到spring容器中

2在services.xml 中去应用bean

3关于具体的实现,如果有兴趣可以研究下框架
