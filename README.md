# swift-sample
集成了thrify,nifty,zookeeper，实现了一个最小核心的RPC调用模型
主要参考了[slimina](https://github.com/slimina/thrift-zookeeper-rpc)的大作，不过他是基于原生的thriftserver来访问的，另外通过apache pool实现了
客户端的访问连接池。我使用nifty分别对客户端，服务器进行了替换。
> * interface-rpc 接口定义，常用的业务定义。声明一下，源代码是基于thrift的源文件生成。细心的同学会说，thrift的文件是如何生成的呢？
看下这个图
![开发流程](http://upload-images.jianshu.io/upload_images/1455720-39451e0a5d3bca82.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

目前只是一个初级版本，还得继续完善。接下来首先会在自动生成thrift的idl文件上进行优化。
