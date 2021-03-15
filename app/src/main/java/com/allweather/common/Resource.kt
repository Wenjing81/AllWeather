package com.allweather.network

//枚举类型Status， 有三种
enum class Status {
    SUCCESS, ERROR, LOADING
}
//生成一个单例类 Resource,用companion object 的原因是可以免去声明一个对象的麻烦。
data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}