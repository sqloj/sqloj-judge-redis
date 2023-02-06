package pers.sy.sqloj.common

object Configs {
    val password: String = System.getenv("REDIS_PASSWORD") ?: "sy123456"
    val host: String = System.getenv("REDIS_HOST") ?: "127.0.0.1"
    val judgedatabase: String = System.getenv("REDIS_JUDGE_DATABASE") ?: "1"
    val port: String = System.getenv("REDIS_PORT") ?: "6379"
}