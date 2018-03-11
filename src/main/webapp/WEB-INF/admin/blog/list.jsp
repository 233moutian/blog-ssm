<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        博文管理
    </title>
    <meta charset="utf-8">
    <%@ include file="../se7en_css.jsp" %>

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body>
<div class="modal-shiftfix">
    <!-- Navigation -->
    <%@ include file="../navigation.jsp" %>
    <div class="alert alert-success " hidden="hidden" id="msg" role="alert">
        <p> 提示:</p>
    </div>
    <!-- End Navigation -->
    <div class="container-fluid main-content">
        <!-- DataTables Example -->
        <div class="row">
            <div class="col-lg-12">
                <div class="widget-container fluid-height clearfix">
                    <div class="heading">
                        <i class="icon-table"></i>博文管理<a class="btn btn-sm btn-primary-outline pull-right"
                                                         href="${pageContext.request.contextPath}/admin/blog/saveUI"><i
                            class="icon-plus"></i>添加</a>
                    </div>
                    <div class="widget-content padded clearfix">
                        <table class="table table-bordered table-striped" id="datatable-editable">
                            <thead>
                            <th width="200px">id</th>
                            <th width="200px">标题</th>
                            <th width="200px">内容</th>
                            <th width="200px">点击数</th>
                            <th width="200px">评论数</th>
                            <th width="200px">创建时间</th>
                            <th width="200px">修改时间</th>
                            <th width="150px">操作</th>
                            </thead>
                            <tbody id="tbody">
                            <%--<tr>
                                <td class="cente">admin</td>
                                <td class="center"></td>
                                <td class="center"></td>
                                <td class="center"></td>
                                <td class=""><a target="_blank" href="/blog/admin/admin/show/1"><i
                                        class="icon-search"></i>查看</a>&nbsp;&nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td class="center">llssz</td>
                                <td class="center">lz</td>
                                <td class="center"></td>
                                <td class="center"></td>
                                <td class=""><a target="_blank" href="/blog/admin/admin/show/10"><i
                                        class="icon-search"></i>查看</a>&nbsp;&nbsp;
                                </td>
                            </tr>--%>

                            <c:forEach items="${blogList}" var="blog">
                                <tr>
                                    <td class="center">${blog.blogId}</td>
                                    <td class="center">${blog.title}</td>
                                    <td class="center">${blog.summary}</td>
                                    <td class="center">${blog.clickHit}</td>
                                    <td class="center">${blog.replyHit}</td>
                                    <td class="center"><fmt:formatDate value="${blog.createTime}"
                                                                       pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td class="center"><fmt:formatDate value="${blog.updateTime}"
                                                                       pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td>
                                        <a target="_blank" href="/blog/admin/admin/show/1"> <i
                                                class="icon-search"></i>查看</a>&nbsp;&nbsp;
                                        <a target="_blank" href="/blog/admin/admin/show/1"> <i
                                                class="icon-search"></i>编辑</a>&nbsp;&nbsp;
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>



                            <!-- 封装通用的分页jsp -->
                            <jsp:include page="../page.jsp">
                                <jsp:param value="${pageContext.request.contextPath}/admin/blog/list"
                                           name="url"/>
                                <jsp:param value="${requestScope.count}" name="count"/>
                                <jsp:param value="${requestScope.limit}" name="limit"/>
                            </jsp:include>



                    </div>
                </div>
            </div>
        </div>
        <!-- end DataTables Example -->
    </div>
</div>
<%@ include file="../se7en_js.jsp" %>
<script type="text/javascript">
    /* $(document).ready(function() {
 //        $("#admin_page").addClass("current");
         var oTable= $("#datatable-editable").dataTable({
             "bProcessing": true, // 是否显示取数据时的那个等待提示
             "bServerSide": true,//这个用来指明是通过服务端来取数据
             "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
             "iDisplayLength": 10,//每页显示10条数据
             "sAjaxSource": "${pageContext.request.contextPath}/admin/blog/dataTable",//这个是请求的地址
            "fnServerData": retrieveData ,
            "oLanguage" : { // 汉化
                "sProcessing" : "正在加载数据...",
                "sLengthMenu" : "显示_MENU_条 ",
                "sZeroRecords" : "没有您要搜索的内容",
                "sInfo" : "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                "sInfoEmpty" : "记录数为0",
                "sInfoFiltered" : "(全部记录数 _MAX_  条)",
                "sInfoPostFix" : "",
                "sSearch" : "搜索",
                "sUrl" : "",
                "oPaginate" : {
                    "sFirst" : "第一页",
                    "sPrevious" : " 上一页 ",
                    "sNext" : " 下一页 ",
                    "sLast" : " 最后一页 "
                    }
            },
            "aoColumns":
                    [
                        { "mData": "title", 'sClass':'center'},
                        { "mData": "content", 'sClass':'center'},
                        { "mData": "clickHit", 'sClass':'center'},
                        { "mData": "replyHit", 'sClass':'center'},
                        { "mData": "createTime", 'sClass':'center'},
                        { "mData": "updateTime", 'sClass':'center'},
                        {
                            "mDataProp": "blogId",
                            "bSearchable": false,
                            "bSortable": false,
                            "fnRender": function(obj) {
                                var id=obj.aData.blogId;
                                var render=  '<a target="_blank"  href="${pageContext.request.contextPath}/admin/blog/show/'+id+'"><i class="icon-search"></i>查看</a>';
                                render += '&nbsp;&nbsp;';
                                return render;
                             }
                        }

                    ]
        });

// 3个参数的名字可以随便命名,但必须是3个参数,少一个都不行
        function retrieveData( sSource111, aoData111, fnCallback111) {
                var arrayObj=new Array(
                    { "mData": "title", 'sClass':'center'},
                    { "mData": "content", 'sClass':'center'},
                    { "mData": "clickHit", 'sClass':'center'},
                    { "mData": "replyHit", 'sClass':'center'},
                    { "mData": "createTime", 'sClass':'center'},
                    { "mData": "updateTime", 'sClass':'center'}
                );
                var searchtext="";
                var sort="";
                var order="";
                var pageOffset=0;
                var size=10;
                var sEcho=0;
                for(var i=0;i<aoData111.length;i++){
                    var value=aoData111[i].value;
                    if(aoData111[i].name=="iSortCol_0"){
                        sort=arrayObj[value].mData;
                    }
                    if(aoData111[i].name=="sSortDir_0"){
                        order=value;
                    }
                    if(aoData111[i].name=="sSearch"){
                        searchtext=value;
                    }
                    if(aoData111[i].name=="iDisplayStart"){
                        pageOffset=value
                    }
                    if(aoData111[i].name=="iDisplayLength"){
                        size=value
                    }
                    if(aoData111[i].name=="sEcho"){
                        sEcho=value;
                    }

                }
            var page=Math.floor(pageOffset/size)+1;
            $.ajax({
                url : sSource111,//这个就是请求地址对应sAjaxSource
                data :{"sort":sort,"order":order,"offset":pageOffset,"pageSize":size,"searchText":searchtext,"pageNo":page,"sEcho":sEcho},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                type : 'post',
                dataType : 'json',
                async : false,
                success : function(result) {
                    console.info(result)
                    fnCallback111(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                },
                error : function(msg) {
                }
            });
        }
        var nEditing = null;

        $('#datatable-editable').on('click', 'a.delete-row', function (e) {
            var id=$(this).attr("name");
            var nRow = $(this).parents('tr')[0];
            $.post("${pageContext.request.contextPath}/admin/blog/delete/"+id, function(result){
                if(result.success){
                    oTable.fnDeleteRow( nRow );
                    $("#msg >p").text("提示:"+result.msg);
                    $("#msg").removeAttrs("hidden");
                }else{
                    $("#msg >p").text("提示:"+result.msg);
                    $("#msg").removeAttrs("hidden");
                }
                setTimeout(function(){    //设时延迟0.5s执行
                    $("#msg").attr("hidden","hidden");
                },5000)
            },"json");
        } );

    });*/



    <c:if test="${msg!=null}">
    <
    script
    type = "application/javascript" >
        $().ready(function () {
            var result =${msg};
            if (result) {
                $("#msg >p").text("提示:" + result.msg);
                $("#msg").removeAttrs("hidden");
            }
            setTimeout(function () {    //设时延迟0.5s执行
                $("#msg").attr("hidden", "hidden");
            }, 5000)
        })
</script>
</c:if>
</body>
</html>

<%--

<div class="dataTables_info" id="datatable-editable_info">从1 到 2 条记录——总记录数为 2 条</div>

<div class="dataTables_paginate paging_full_numbers" id="datatable-editable_paginate">
    <a tabindex="0" class="first paginate_button paginate_button_disabled" id="datatable-editable_first">第一页</a>
    <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="datatable-editable_previous">上一页 </a>
    <span><a tabindex="0" class="paginate_active">1</a></span>
    <a tabindex="0" class="next paginate_button paginate_button_disabled" id="datatable-editable_next"> 下一页 </a>
    <a tabindex="0" class="last paginate_button paginate_button_disabled" id="datatable-editable_last"> 最后一页 </a>
</div>

--%>
