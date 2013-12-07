
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="customer.search.title"/></h1>

<table class="search">
    <tr>
        <th><fmt:message key="customer.form.firstName"/></th>
        <th><fmt:message key="customer.form.lastName"/></th>
    </tr>
    <c:forEach var="customer" items="${customers}" varStatus="status">
        <tr>
            <c:set var="customerFormId" value="customer${status.index}"/>

            <c:url var="editUrl" value="/customer/form.html">
                <c:param name="id" value="${customer.id}" />
            </c:url>
            <c:url var="deleteUrl" value="/customer/delete.html"/>
            <form id="${customerFormId}" action="${deleteUrl}" method="POST">
                <input id="id" name="id" type="hidden" value="${customer.id}"/>
            </form>

            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>
                <a href='<c:out value="${editUrl}"/>'><fmt:message key="button.edit"/></a>
                <a href="javascript:document.forms['${customerFormId}'].submit();"><fmt:message key="button.delete"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
