package com.wychmod.aicloud.controller;

import com.wychmod.aicloud.util.ResponseEntity;
import jakarta.annotation.Resource;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openai")
public class OpenAIController {

    @Resource
    private OpenAiChatModel chatModel;

    @Resource
    private OpenAiImageModel imageModel;

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

    @RequestMapping("/draw")
    public ResponseEntity draw(String question) {
        if (!StringUtils.hasLength(question)) {
            return ResponseEntity.fail("请先输入内容！");
        }
        // 调用OpenAI接口
        ImageResponse result = imageModel.call(new ImagePrompt(question));
        return ResponseEntity.success(result.getResults().getFirst());
    }
}
