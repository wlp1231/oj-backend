package com.wlp.oj.judge;

import com.wlp.oj.judge.strategy.DefaultJudgeStrategy;
import com.wlp.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.wlp.oj.judge.strategy.JudgeContext;
import com.wlp.oj.judge.strategy.JudgeStrategy;
import com.wlp.oj.judge.codesandbox.model.JudgeInfo;
import com.wlp.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
