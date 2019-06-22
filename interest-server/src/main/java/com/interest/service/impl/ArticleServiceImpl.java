package com.interest.service.impl;

import com.interest.dao.ArticleDao;
import com.interest.exception.ArticleException;
import com.interest.model.entity.ArticleEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.entity.UserDetailEntity;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.request.ArticleUpdateRequest;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.response.ArticleResponse;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseStatus;
import com.interest.service.ArticleService;
import com.interest.service.UserDetailService;
import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    @Transactional
    public void createArticle(ArticleCreateRequest articleCreateRequest) {
        int userid = SecurityAuthenUtil.getId();

        UserDetailEntity userDetailEntity = userDetailService.getEntityByUserid(userid);
        if (userDetailEntity.getArticleSign() == 1) {
            throw new ArticleException(ResponseStatus.FAIL_6001.getValue(), ResponseStatus.FAIL_6001.getReasonPhrase());
        }

        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle(articleCreateRequest.getTitle());
        articleEntity.setContent(articleCreateRequest.getContent());
        articleEntity.setCreateTime(DateUtil.currentTimestamp());
        articleEntity.setReplyTime(articleEntity.getCreateTime());
        articleEntity.setUserid(userid);

        String info = htmlText(articleEntity.getContent());
        if (info.length() > 100) {
            info = info.substring(0, 100);
        }
        articleEntity.setInfo(info);

        articleDao.insertArticle(articleEntity);

        userDetailService.updateArticleSign(1, userid);
    }

    @Override
    public PageResult getArticle(String searchContent, PageWrapper pageWrapper) {
        List<ArticleResponse> list = articleDao.getArticleList(searchContent, pageWrapper);
        int size = articleDao.getArticleSize(searchContent);
        return new PageResult<>(list, size);
    }

    @Override
    public ArticleDetailResponse getArticleById(int id) {
        threadPoolTaskExecutor.execute(() -> {
            articleDao.addClickRateById(1, id);
        });

        return articleDao.getArticleById(id);
    }

    @Override
    public void addCommentCountById(Integer articleid) {
        threadPoolTaskExecutor.execute(() -> {
            articleDao.addCommentCountById(1, articleid);
        });
    }

    @Override
    public PageResult getArticlesByUserId(int userId, PageWrapper pageWrapper) {
        List<ArticleResponse> list = articleDao.getArticlesListByUserId(userId, pageWrapper);
        int size = articleDao.getArticlesSizeByUserId(userId);
        return new PageResult<>(list, size);
    }

    @Override
    public PageResult getArticleOnManagement(String searchContent, String dateTimestamp, int del, PageWrapper pageWrapper) {
        String dayStart = null;
        String dayEnd = null;
        if (dateTimestamp != null && !"".equals(dateTimestamp)) {
            dayStart = DateUtil.dayStart(dateTimestamp);
            dayEnd = DateUtil.dayEnd(dateTimestamp);
        }
        List<ArticleResponse> list = articleDao.getArticleListOnManagement(searchContent, dayStart, dayEnd, del, pageWrapper);
        int size = articleDao.getArticleSizeOnManagement(searchContent, dayStart, dayEnd, del);
        return new PageResult<>(list, size);
    }

    @Override
    public void updateArticlesDelByIds(List<String> groupId, int del) {
        articleDao.updateArticlesDelByIds(groupId, del);
    }

    @Override
    public void updateArticlesTopByIds(List<String> groupId, int top) {
        articleDao.updateArticlesTopByIds(groupId, top);
    }

    @Override
    public void updateArticlesDelById(int articleId) {
        int userId = SecurityAuthenUtil.getId();
        articleDao.updateArticlesDelByIdAndUserId(userId,articleId);
    }

    @Override
    public void updateArticle(ArticleUpdateRequest articleCreateRequest) {
        int userId = SecurityAuthenUtil.getId();

        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(articleCreateRequest.getId());
        articleEntity.setTitle(articleCreateRequest.getTitle());
        articleEntity.setContent(articleCreateRequest.getContent());
        articleEntity.setUserid(userId);
        String info = htmlText(articleEntity.getContent());
        if (info.length() > 100) {
            info = info.substring(0, 100);
        }
        articleEntity.setInfo(info);

        articleDao.updateArticle(articleEntity);

    }

    public String htmlText(String htmlStr) {
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        //剔除空格行
        textStr = textStr.replaceAll("[ ]+", " ");
        textStr = textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
        return textStr;// 返回文本字符串
    }
}
