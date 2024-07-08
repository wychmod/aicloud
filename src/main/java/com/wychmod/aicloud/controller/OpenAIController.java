package com.wychmod.aicloud.controller;

import com.wychmod.aicloud.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai")
public class OpenAIController {

    @Resource
    private OpenAiChatModel chatModel;

    /**
     * 模拟调用OpenAI聊天接口
     * @param question 用户提问问题
     * @return 回复
     */
    @RequestMapping("/chat")
    public ResponseEntity chat(String question) {
        if (!StringUtils.hasLength(question)) {
            return ResponseEntity.fail("请先输入内容！");
        }
        // 调用OpenAI接口
        String result = chatModel.call(question);
        return ResponseEntity.success(result);
    }
}
