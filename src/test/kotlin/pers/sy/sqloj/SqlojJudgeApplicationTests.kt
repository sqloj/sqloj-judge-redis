package pers.sy.sqloj

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SqlojJudgeApplicationTests {

//    val lua1 = "local res\n" +
//            "res = redis.call('SET', 'sy', '100')\n" +
//            "res = redis.call('GET', 'sy')\n" +
//            "return res"
//    val lua2 = "local result\n" +
//            "result = redis.call(\"HMSET\", \"syh\", \"school\", \"ZAFU\", \"age\", \"23\", \"description\", \"ACMer\")\n" +
//            "result = redis.call(\"HMGET\", \"syh\", \"school\", \"age\")\n" +
//            "return result"
//    val lua3 = "local res = redis.call(\"INFO\") return res"
//    val lua4 = "local res = redis.call(\"SET\", \"TEST\", \"TTT!!!\") return res"
//    val lua5 = "local res = redis.pcall(\"HEXISTS\", \"syh\", \"age\") return res"
//    val lua6 = "local res = redis.pcall(\"EXISTS\", \"syh\") return res"
//    val lua7 = "local res = redis.pcall(\"KEYS\", \"syh\") return res"
//    val lua8 = "local res = redis.call(\"SET\", \"Number\", \"10.10\")\n" +
//            "res = redis.pcall(\"incrByFloat\", \"Number\", \"-5.5\")\n" +
//            "return res"
//    val lua9 = "local res = redis.pcall(\"HGETALL\", \"syh\") return res"
//    val lua10 = "local res = redis.pcall(\"SADD\", \"ycy\", \"math\")\n" +
//            "res = redis.pcall(\"SADD\", \"ycy\", \"abc\")\n" +
//            "res = redis.pcall(\"SADD\", \"ycy\", \"xyz\")\n" +
//            "res = redis.pcall(\"SISMEMBER\", \"ycy\", \"math\")\n" +
//            "return res\n"
//    val lua11 = "local res = redis.pcall(\"ZADD\", \"myzset\", 1, \"one\")\n" +
//            "res = redis.pcall(\"ZADD\", \"myzset\", 2, \"two\")\n" +
//            "res = redis.pcall(\"ZADD\", \"myzset\", 3, \"three\")\n" +
//            "res = redis.pcall(\"ZPOPMAX\", \"myzset\")\n" +
//            "return res"

    @Test
    fun Test1() {
//        val connect = RedisConnect()
//        val jedis = connect.jedisConnection()
//        val keys = ArrayList<String>()
//        val args = ArrayList<String>()
//        val luaScript = jedis.scriptLoad(lua11)
//        println("luaScript: $luaScript \n" + "keys: ${keys.size}  " + "  args: ${args.size}")
//        val res = jedis.evalsha(luaScript, keys, args)
//
//        println(res!!::class.qualifiedName.toString())
//        var ret:ArrayList<String> = ArrayList()
//        when (res) {
//            is String -> {
//                ret.add(res)
//            }
//            is java.util.ArrayList<*> -> {
//                ret = res as ArrayList<String>
//            }
//
//            is Long -> {
//                ret.add(res.toString())
//            }
//
//            else -> {
//                ret.add(res.toString())
//            }
//        }
//        println(ret)
//        println(ret!!::class.qualifiedName.toString())
    }

}



