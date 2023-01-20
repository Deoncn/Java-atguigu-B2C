package com.deoncn.search.listener;

import com.deoncn.clients.ProductClient;
import com.deoncn.doc.ProductDoc;
import com.deoncn.pojo.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName:SpringBootListener
 * Package: IntelliJ IDEA
 * Description: 监控boot 程序启动，完成es 数据的同步工作
 *
 * @Author: Deoncn
 * @Create: 2023/1/4 - 13:41
 * @Version: v1.0
 */


@Slf4j
@Component
public class SpringBootListener implements ApplicationRunner {


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ProductClient productClient;

    private String indexStr ="";

    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 需要在此方法，完成es数据同步！
     * 1.判断下 es 中product 索引是否粗存在
     * 2.不存在，java 代码创建一个
     * 3.存在，删除原来的数据
     * 4.查询 商品全部数据
     * 5. 进行es 库的更新工作[插入]
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {


        //1.判断 es 中是否存在product 索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("product");
        boolean exists = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);

        //2. 判断处理
        if (exists) {
            //存在 删除原有数据
            DeleteByQueryRequest queryRequest = new DeleteByQueryRequest("product");
            queryRequest.setQuery(QueryBuilders.matchAllQuery()); //全部删除
            restHighLevelClient.deleteByQuery(queryRequest, RequestOptions.DEFAULT);
        } else {
            // 不存在 创建新的索引表即可 product
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("product");
            createIndexRequest.source(indexStr, XContentType.JSON);
            restHighLevelClient.indices().create(createIndexRequest,RequestOptions.DEFAULT);

        }

        //3. 查询全部商品数据
        List<Product> productList = productClient.allList();

        //4. 批量数据插入
        BulkRequest request = new BulkRequest();

        for (Product product : productList){
            // 数据类型转换
            ProductDoc productDoc = new ProductDoc(product);
            // 用于插入数据的作用
            IndexRequest indexRequest= new IndexRequest("product").id(product.getProductId().toString());
            //  productDoc -> 转成JSON 放入
            String json = objectMapper.writeValueAsString(productDoc);
            indexRequest.source(json,XContentType.JSON);

            request.add(indexRequest);
        };


        // 批量执行bulk request
        restHighLevelClient.bulk(request,RequestOptions.DEFAULT);



    }
}
