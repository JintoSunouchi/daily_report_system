<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>出退勤 一覧</h2>
        <table id="timecard_list">
            <tbody>
                <tr>
                    <th class="timecard_name">氏名</th>
                    <th class="timecard_date">日付</th>
                    <th class="timecard_attendance_at">出勤時間</th>
                    <th class="timecard_retirement_at">退勤時間</th>
                    <th class="timecard_action">操作</th>
                </tr>
                <c:forEach var="timecard" items="${timecards}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="timecard_name"><c:out
                                value="${timecard.employee.name}" /></td>
                        <td class="timecard_date"><fmt:formatDate
                                value='${timecard.timecard_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="timecard_attendance_at"><fmt:formatDate
                                value='{timecard.timecard_attendance_at}' pattern='HH:mm:ss' /></td>
                        <td class="timecard_retirement_at"><fmt:formatDate
                                value='{timecard.timecard_retirement_at}' pattern='HH:mm:ss' /></td>
                        <td class="timecard_action"><a
                            href="<c:url value='/timecards/show?id=${timecard.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            (全 ${timecards_count} 件) <br />
            <c:forEach var="i" begin="1" end="${((timecards_count -1) / 15) + 1}"
                step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/timecards/index?page${i}' />"><c:out
                                value="${i}" /></a>&nbsp;
                </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='/timecards/new' />">新規出退勤の登録</a>
        </p>
    </c:param>
</c:import>
