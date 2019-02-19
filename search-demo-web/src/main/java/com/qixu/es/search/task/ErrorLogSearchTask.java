package com.qixu.es.search.task;

import com.qixu.es.search.api.dto.PageDTO;
import com.qixu.es.search.api.request.SearchLogCondition;
import com.qixu.es.search.api.request.SearchLogSet;
import com.qixu.es.search.api.request.SortModel;
import com.qixu.es.search.api.response.SearchLogModel;
import com.qixu.es.search.impl.LogSearchHelper;
import com.qixu.es.search.impl.LogSearchService;
import com.qixu.es.search.mq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TimeZone;

/**
 * @author castle
 * @date 2018/11/5
 **/
@Component
public class ErrorLogSearchTask {

    private int currentPageNo = 1;
    private int totalPageNo = 1;
    /**之后放在redis保存*/
    private long startDate = System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
    private long endDate;
    private static final String LOG_LEVEL = "ERROR";
    @Autowired
    private LogSearchService logSearchService;
    @Autowired
    private MessageService messageService;

    @Scheduled(fixedRate = 300000)
    private void searchErrorLogProcess() {
        endDate = System.currentTimeMillis();
        searchErrorLog(currentPageNo, totalPageNo);
        this.startDate = endDate;
    }

    private void searchErrorLog(int currentPageNo, int totalPageNo) {
        if (currentPageNo == 1 || currentPageNo <= totalPageNo) {
            SearchLogSet searchLogSet = genSearchLogSet(currentPageNo);
            String indexName = LogSearchHelper.indexName(searchLogSet.getEnv());
            PageDTO<SearchLogModel> pageDTO = logSearchService.search(searchLogSet, indexName);
            long totalSize = pageDTO.getTotalSize();
            int pageSize = pageDTO.getPageSize();
            totalPageNo = ((int) totalSize + pageSize - 1) / pageSize;
            currentPageNo = pageDTO.getPageNo() + 1;
            List<SearchLogModel> searchLogModels = pageDTO.getList();
            messageService.pushMessage(searchLogModels);
            searchErrorLog(currentPageNo, totalPageNo);
        }
    }

    private SearchLogSet genSearchLogSet(int currentPageNo) {
        //1.拼查询参数
        SearchLogCondition searchLogCondition = new SearchLogCondition();
        searchLogCondition.setLogLevel(LOG_LEVEL);
        searchLogCondition.setStartDate(String.valueOf(startDate));
        searchLogCondition.setEndDate(String.valueOf(endDate));
        SortModel sortModel = new SortModel();
        sortModel.setPageNo(currentPageNo);
        sortModel.setPageSize(100);
        return new SearchLogSet(searchLogCondition, sortModel, "prod");
    }
}
