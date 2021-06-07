package com.example.demo;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

@RunWith(SpringRunner.class) //测试类要使用注入的类
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //用于单元测试
public class SwaggerTo {

    /**
     * 生成AsciiDocs格式文档
     * @throws Exception
     */
    @Test
    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)               //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))  //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/asciidoc/generated"));                 //生成文件的存放路径，生成多个文件
    }

    /**
     * 生成Markdown格式文档
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocs() throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)               //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))  //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/markdown/generated"));                //生成文件的存放路径，生成多个文件
    }

    /**
     * 生成Confluence格式文档
     * @throws Exception
     */
    @Test
    public void generateConfluenceDocs() throws Exception {
        //    输出Markdown格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                         //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)                        //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))  //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFolder(Paths.get("src/docs/confluence/generated"));                //生成文件的存放路径，生成多个文件
    }

    /**
     * 生成AsciiDocs格式文档,并汇总成一个文件
     * @throws Exception
     */
    @Test
    public void generateAsciiDocsToFile() throws Exception {
        //    输出Ascii到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)               //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))  //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/asciidoc/generated/all"));               //生成文件的存放路径，汇总为一个文件
    }

    /**
     * 生成Markdown格式文档,并汇总成一个文件
     * @throws Exception
     */
    @Test
    public void generateMarkdownDocsToFile() throws Exception {
        //    输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)               //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))    //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/markdown/generated/all"));                 //生成文件的存放路径，汇总为一个文件
    }

    /**
     * 生成Confluence格式文档,并汇总成一个文件
     * @throws Exception
     */
    @Test
    public void generateConfluenceDocsToFile() throws Exception {
        //    输出Markdown到单文件
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)    //输出格式：ASCIIDOC，MARKDOWN，CONFLUENCE_MARKUP
                .withOutputLanguage(Language.ZH)                         //语言类型：中文（ZH） 默认英文（EN）
                .withPathsGroupedBy(GroupBy.TAGS)                        //Api排序规则
                .withGeneratedExamples()
                .withoutInlineSchema()
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=user"))    //url，注意端口号与分组
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/confluence/generated/all"));                 //生成文件的存放路径，汇总为一个文件
    }
}
