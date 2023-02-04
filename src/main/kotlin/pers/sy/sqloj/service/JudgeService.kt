package pers.sy.sqloj.service

import org.springframework.stereotype.Service
import pers.sy.sqloj.exception.ScriptException
import redis.clients.jedis.Jedis

@Service
data class JudgeService
    constructor(
                val jedis: Jedis = RedisConnect().jedisConnection()
    ) {
    fun exec(statement: String, keys: ArrayList<String>, args: ArrayList<String> ): ArrayList<String> {
        System.err.println("[LOG] exec: statement = $statement")
        var ret:ArrayList<String> = ArrayList()
        try {
            // connect
            jedis.connect()
            jedis.select(1)
            jedis.flushDB()
            // Run Script
            val luaScript = jedis.scriptLoad(statement)
            var res = jedis.evalsha(luaScript, keys, args)

            when (res) {
                is String -> {
                    ret.add(res)
                }
                is java.util.ArrayList<*> -> {
                    ret = res as ArrayList<String>
                }
                is Long -> {
                    ret.add(res.toString())
                }
                else -> {
                    ret.add(res.toString())
                }
            }
        } finally {
            jedis.flushDB()
            jedis.close()
        }
        return ret
    }

    fun judge(lua: String): ArrayList<String> {
        val luaSplit: List<String> = lua.trim().split("--JUDGE_SERVER_KEY_ARG")
        var keys: ArrayList<String>
        var args: ArrayList<String>
        if (luaSplit.size == 3) {
            keys = ArrayList(luaSplit[1].trim().split(Regex("""\s+""")))
            args = ArrayList(luaSplit[1].trim().split(Regex("""\s+""")))
        } else {
            throw ScriptException()
        }
        println("KEYS : $keys")
        println("ARGS : $args")
        return exec(luaSplit[0], keys, args)
    }
}