package pers.sy.sqloj.service

import org.springframework.stereotype.Component
import pers.sy.sqloj.common.Configs
import redis.clients.jedis.Jedis

@Component
class RedisConnect() {

    val redisHost: String = Configs.host
    val redisPort: String = Configs.port
    val redisDatabase: String = Configs.judgedatabase
    val redisPassword: String = Configs.password


    fun jedisConnection(): Jedis {
//        println("host : ${redisHost}, port : ${redisPort}, database : ${redisDatabase}, password: ${redisPassword} ")
        val jedis = Jedis(redisHost,redisPort.toInt())
        jedis.auth(redisPassword)
        jedis.select(redisDatabase.toInt())
        return jedis
    }

}