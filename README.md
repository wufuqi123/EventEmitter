```
    一个事件发射接收器。
```

#### 基础功能
1. 添加依赖

    请在 build.gradle 下添加依赖。

    ``` 
        implementation 'cn.wufuqi:EventEmitter:1.0.4'
    ```


2. 设置jdk8或更高版本

    因为本sdk使用了jdk8才能使用的 Lambda 表达式，所以要在 build.gradle 下面配置jdk8或以上版本。

    ``` 
    android {
        ....

        compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
        }
        
    }
    ```

3. 事件发送

    ``` 
        val event by lazy { EventEmitter() }

        ...

         event.emit("事件名",...事件发送的参数（任意类型）)

    ``` 

4. 事件监听

    1. on 监听
        发送几次监听几次，如果执行了3次 emit("log事件") 则 on("log事件") 则会执行3次

        ```
            event.on("log事件"){
                it[0] //发送的第0个参数
                it[1] //发送的第1个参数
                it[2] //发送的第2个参数

                ...
            }
        ```

    2. once 监听
        只监听一次事件，则会自动取消监听。如果执行了3次 emit("log事件") 则 once("log事件") 则只会执行一次，执行的一次为 emit 的第一次。

        ```
            event.once("log事件"){
                it[0] //发送的第0个参数
                it[1] //发送的第1个参数
                it[2] //发送的第2个参数

                ...
            }
        ```

5. 取消监听

    1. off 一个参数的

        off(eventName: String) 取消 eventName 事件中的 所有事件

        取消一个事件,当前事件下的全部事件

        ```
            event.off("log事件")
        ```


    2. off 两个参数的

        off(eventName: String, listener: (param: MutableList<Any>) -> Unit) 取消 eventName 事件中的 listener 回调参数。

        取消一个事件,当前事件下的一个对应事件

        ```
            event.off("log事件",已经注册过的回调方法)
        ```

    3. offAll

        取消全部事件

        取消 event 对象下的所有事件

        ```
            event.offAll()
        ```

6. 获取全部注册事件名

    获取  on once 方法去注册的事件名，并未被销毁掉的事件名

    ```
        event.eventNames()
    ```

7. 获取全部发送的事件名

    获取  emit 方法发送的事件名，并未被销毁掉的事件名

    ```
        event.emitNames()
    ```

8. 通过事件名，获取注册的事件数量

    ```
        event.listenerCount("事件名")
    ```

9. 获取注册的全部事件数量

     ```
        event.listenerCountAll()
    ```