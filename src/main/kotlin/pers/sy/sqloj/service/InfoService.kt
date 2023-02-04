package pers.sy.sqloj.service

import org.springframework.stereotype.Service
import pers.sy.sqloj.common.Configs
import pers.sy.sqloj.entity.VersionDO

@Service
class InfoService
        constructor(
                val dbInfoMapper: RedisConnect
        ) {
    fun getVersion(): VersionDO {
        return VersionDO(
            Regex(pattern = """redis_version:.*""")
                .find(dbInfoMapper.jedisConnection().info())?.value
        )
    }

            fun verify(password: String): Boolean {
                return password == Configs.password
            }
        }