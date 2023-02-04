package pers.sy.sqloj.common

object Configs {
    val password: String = System.getenv("REDIS_PASSWORD") ?: "sy123456"
}