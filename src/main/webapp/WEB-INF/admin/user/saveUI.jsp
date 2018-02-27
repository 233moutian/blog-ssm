<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
    <meta charset="utf-8">
    <title>
        报名编辑
    </title>
    <%@ include file="../se7en_css.jsp" %>

    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body>
<div class="modal-shiftfix">
    <!-- Navigation -->
    <%@ include file="../navigation.jsp" %>
      <div class="container-fluid main-content"><div class="page-title">
      </div>
          <div class="row">
              <div class="col-lg-12">
                  <ul class="breadcrumb">
                      <li>
                          <a href="${pageContext.request.contextPath}/admin/index"></a><i class="icon-home"></i>
                      </li>
                      <li>
                          <a href="${pageContext.request.contextPath}/admin/user/list">报名管理</a>
                      </li>
                      <li class="active">
                          报名保存
                      </li>
                  </ul>
              </div>
              <div class="col-md-12">
                  <div class="widget-container">
                      <div class="heading">
                          <i class="icon-shield"></i>报名保存
                      </div>
                      <div class="widget-content padded">
                          <form action="${pageContext.request.contextPath}/admin/user/${ user.u_id == null ? 'add' : 'update' }" id="user-form" method="post">
                              <fieldset>
                                  <div class="row">
                                      <div class="col-md-6 col-md-offset-3">
                                          <div class="hidden">
                                              <input name="u_id" type="hidden" value="${user.u_id}"/>
                                          </div>
                                          <div class="form-group">
                                              <label for="name">姓名</label>
                                              <input class="form-control" id="name" name="name" type="text" value="${user.name}">
                                          </div>
                                          <div class="form-group">
                                              <label for="name">专业</label>
                                              <input class="form-control" id="className" name="className" type="text" value="${user.className}">
                                          </div>
                                          <div class="form-group">
                                              <label for="phoneNumber">手机号码</label>
                                              <input class="form-control" id="phoneNumber" name="phoneNumber" type="text" value="${user.phoneNumber}">
                                          </div>
                                          <div class="form-group">
                                              <label for="email">邮箱</label>
                                              <input class="form-control" id="email" name="email" type="email" value="${user.email}">
                                          </div>
                                          <div class="form-group">
                                              <label class="control-label col-md-2">报名部门</label>
                                              <div class="col-md-7">
                                                  <select class="form-control" id="department" name="department" >
                                                      <c:if test="${user.department eq 'Java部'}">
                                                          <option value="Java部">Java部</option>
                                                          <option value=".Net部">.Net部</option>
                                                          <option value="美工部">美工部</option>
                                                          <option value="行政部">行政部</option>
                                                          <option value="php小组">php小组</option>
                                                      </c:if>
                                                      <c:if test="${user.department eq '.Net部'}">
                                                          <option value=".Net部">.Net部</option>
                                                          <option value="Java部">Java部</option>
                                                          <option value="美工部">美工部</option>
                                                          <option value="行政部">行政部</option>
                                                          <option value="php小组">php小组</option>
                                                      </c:if>
                                                      <c:if test="${user.department eq '美工部'}">
                                                          <option value="美工部">美工部</option>
                                                          <option value="Java部">Java部</option>
                                                          <option value=".Net部">.Net部</option>
                                                          <option value="行政部">行政部</option>
                                                          <option value="php小组">php小组</option>
                                                      </c:if>
                                                      <c:if test="${user.department eq '行政部'}">
                                                          <option value="行政部">行政部</option>
                                                          <option value="Java部">Java部</option>
                                                          <option value=".Net部">.Net部</option>
                                                          <option value="美工部">美工部</option>
                                                          <option value="php小组">php小组</option>
                                                      </c:if>
                                                      <c:if test="${user.department eq 'php小组'}">
                                                          <option value="php小组">php小组</option>
                                                          <option value="行政部">行政部</option>
                                                          <option value="Java部">Java部</option>
                                                          <option value=".Net部">.Net部</option>
                                                          <option value="美工部">美工部</option>
                                                      </c:if>
                                                  </select>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  <br>
                                  <div class="col-md-offset-5 col-md-2">
                                      <input class="btn btn-primary " type="submit" value="保存">
                                  </div>

                              </fieldset>
                          </form>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
<%@ include file="../se7en_js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#user_page").addClass("current");
            $("#user-form").validate({
                rules: {
                    name: "required",
                    phoneNumber: {
                        minlength: 11,
                        maxlength: 11,
                        number: true
                    },
                    email: {
                        email: true
                    },
                    className: "required",
                },
                messages: {
                    name: "请填写您的姓名",
                    phoneNumber: '请输入正确的手机号码',
                    email: "请填写正确的邮箱地址",
                    className: "required",
                }
            });
        });
    </script>

  </body>
</html>