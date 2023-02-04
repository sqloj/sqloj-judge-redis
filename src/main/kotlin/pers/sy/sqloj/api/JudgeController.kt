package pers.sy.sqloj.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import pers.sy.sqloj.common.SystemInfo
import pers.sy.sqloj.entity.PingVO
import pers.sy.sqloj.service.InfoService
import pers.sy.sqloj.service.JudgeService
import pers.sy.sqloj.util.VResponse

@RestController
@RequestMapping("/api/")
@Tag(name = "SQLOJ 用户管理", description = "UserController")
class JudgeController
@Autowired constructor(
    val infoService: InfoService,
    val judgeService: JudgeService
) {

    @GetMapping("/info")
    @Operation(summary = "系统信息")
    @ApiResponse(description = "系统信息")
    fun getInfo(): VResponse<Any?> {
        return VResponse.ok(SystemInfo)
    }

    @GetMapping("/db-info")
    @Operation(summary = "数据库系统信息")
    @ApiResponse(description = "数据库系统信息")
    fun getDbInfo(
        @RequestParam password: String
    ): VResponse<Any?> {
        return if (infoService.verify(password)) {
            VResponse.ok(infoService.getVersion())
        } else {
            VResponse.err(1, "密码错误")
        }
    }

    @PostMapping("/ping")
    @Operation(summary = "数据库系统信息")
    @ApiResponse(description = "数据库系统信息")
    fun ping(
        @RequestParam password: String
    ): VResponse<Any?> {
        return if (infoService.verify(password)) {
            VResponse.ok(PingVO)
        } else {
            VResponse.err(1, "密码错误")
        }
    }

    @PostMapping("/exec")
    @Operation(summary = "数据库系统信息")
    @ApiResponse(description = "数据库系统信息")
    fun exec(
        @RequestParam password: String,
        @RequestBody lua: String
    ): VResponse<Any?> {
        if (!infoService.verify(password)) {
            return VResponse.err(1, "密码错误")
        }
        return try {
            val ret = judgeService.judge(lua)
            VResponse.ok(ret)
        } catch (e: Exception) {
            VResponse.err(2, e.message)
        }
    }
}
