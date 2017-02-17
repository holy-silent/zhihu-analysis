<h1 style="box-sizing: border-box; margin-right: 0px; margin-bottom: 16px; margin-left: 0px; line-height: 1.25; padding-bottom: 0.3em; border-bottom: 1px solid rgb(238, 238, 238); color: rgb(51, 51, 51); font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; white-space: normal; margin-top: 0px !important;">
    zhihu-analysis
</h1>
<p>
    <span style="font-family: 微软雅黑, &quot;Microsoft YaHei&quot;;">知乎用户分析项目，该项目主要用于学习如何使用爬虫获取互联网资源，作为自己学习爬虫的入门级项目。项目采用spring+mybatis+webmagic框架，由于在工作中很少写代码，所以代码质量可能较差，也希望看到该项目的朋友海涵，有错误的地方也欢迎大家能够指出来。</span>
</p>
<p>
    <br/>
</p>
<p>
    <strong>2017/2/16</strong>
</p>
<p>
    1、完成框架搭建
</p>
<p>
    2、完成用户基础信息的采集内容
</p>
<p>
    <br/>
</p>
<p>
    <strong>目前遗留问题：</strong>
</p>
<p>
    知乎用户主页中，点击“查看详细资料”时触发的ajax请求，暂时没有解决动态获取数据的问题。目前思路是采用&quot;selenium&quot;提供Js运行环境，由其触发按钮点击操作，将页面下载下来后获取详细信息。
</p>
