<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>

<html>
<head>
    <title>Title</title>
    <style>
        ul.pagination {
            display: inline-block;
            padding: 0;
            margin: 0;
        }

        ul.pagination li {
            display: inline;
        }

        ul.pagination li a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        ul.pagination li a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        ul.pagination li a:hover:not(.active) {
            background-color: #ddd;
        }

        div.center {
            text-align: center;
        }
    </style>

</head>
<body>
<br>
<!----------- 分页部分 maxPageItems:每页显示的行数，默认为10------------>
<%-- items:总记录数，pager标签正是根据这个值来计算分页参数的
maxPageItems:每页显示的行数，默认为10
maxIndexPages:最大输出的页码数
export：这个属性是让标签给你暴露什么变量，当然这些变量是有选择的，如在Pager标签里，可以暴露出来的变量有pageOffset及pageNumber，
    即页码偏移量及页码。通过这两个变量名，可以在Jsp或Java里面从Request里获得。 Export属性接受的值还有表达式，如currentPage=pageNumber表示，
    把pageNumber的值暴露出来，并赋给一个叫 CurrentPage的变量，这个变量将被保存到Request中，在Jsp中使用${currentPageNumber}可以得到值。
${pageUrl }: 传过来的url值, 在前一个页面的param中
--%>
<%--<div class="center">--%>

<div class="dataTables_info" id="datatable-editable_info">从${param.limit } 到 ${param.limit + 10} 条记录——总记录数为 ${param.count} 条</div>

<div class="dataTables_paginate paging_full_numbers" >
    <ul class="pagination">
        <pg:pager url="${param.url }" items="${param.count}"
                  maxPageItems="${param.limit }"
                  maxIndexPages="10" export="currentPageNumber=pageNumber">
            <pg:param name="limit" value="${param.limit }"/>
            <pg:first>
                <li><%--<a href="${pageUrl }">首页</a>--%>
                    <%--<a tabindex="0" class="first paginate_button paginate_button_disabled" href="${pageUrl }">第一页</a>--%>
                    <a tabindex="0" class="first paginate_button" href="${pageUrl }">第一页</a>
                </li>
            </pg:first>
            <pg:prev>
                <li><%--<a href="${pageUrl }">«</a>--%>
                    <%--<a tabindex="0" class="previous paginate_button paginate_button_disabled"--%>
                    <a tabindex="0" class="previous paginate_button"
                       href="${pageUrl }">上一页 </a>
                </li>
            </pg:prev>
            <pg:pages>
                <c:choose>
                    <%-- 如果页码等于当前页码,则active --%>
                    <c:when test="${currentPageNumber eq pageNumber}">
                        <li><%--<a class="active" href="${pageUrl }">${pageNumber }</a>--%>
                            <a tabindex="0" class="paginate_active" href="${pageUrl }">${pageNumber }</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><%--<a href="${pageUrl }">${pageNumber }</a>--%>
                            <a tabindex="0"  href="${pageUrl }">${pageNumber }</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </pg:pages>
            <pg:next>
                <li><%--<a href="${pageUrl }">»</a>--%>
                    <%--<a tabindex="0" class="next paginate_button paginate_button_disabled" href="${pageUrl }"> 下一页 </a>--%>
                    <a tabindex="0" class="next paginate_button" href="${pageUrl }"> 下一页 </a>
                </li>
            </pg:next>
            <pg:last>
                <li><%--<a href="${pageUrl }">尾页</a>--%>
                    <%--<a tabindex="0" class="last paginate_button paginate_button_disabled" href="${pageUrl }"> 最后一页 </a>--%>
                    <a tabindex="0" class="last paginate_button" href="${pageUrl }"> 最后一页 </a>
                </li>
            </pg:last>
            <%--


                            <a tabindex="0" class="first paginate_button paginate_button_disabled" id="datatable-editable_first">第一页</a>
                            <a tabindex="0" class="previous paginate_button paginate_button_disabled" id="datatable-editable_previous">上一页 </a>
                            <span><a tabindex="0" class="paginate_active">1</a></span>
                            <a tabindex="0" class="next paginate_button paginate_button_disabled" id="datatable-editable_next"> 下一页 </a>
                            <a tabindex="0" class="last paginate_button paginate_button_disabled" id="datatable-editable_last"> 最后一页 </a>

            --%>


        </pg:pager>
    </ul>
</div>



<h></h>
<br>
</body>
</html>
