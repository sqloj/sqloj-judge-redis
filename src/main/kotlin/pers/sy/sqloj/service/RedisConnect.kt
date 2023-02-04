package pers.sy.sqloj.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import redis.clients.jedis.Jedis


@Configuration
@Component
class RedisConnect() {

    @Value("\${spring.redis.host}")
    var redisHost: String = "124.221.134.229"

    @Value("\${spring.redis.port}")
    var redisPort: String = "6379"

    @Value("\${spring.redis.database}")
    var redisDatabase: String = "0"

    @Value("\${spring.redis.password}")
    var redisPassword: String = "sy123456"

    fun jedisConnection(): Jedis {
        val jedis = Jedis(redisHost,redisPort.toInt())
        jedis.auth(redisPassword)
        jedis.select(redisDatabase.toInt())
        return jedis
    }

}