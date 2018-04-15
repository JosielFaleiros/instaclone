<%@page contentType="text/html" pageEncoding="utf-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Feed">
    <jsp:body>
        <div class="row center feed">
            <h3>public feed</h3>

            <c:forEach var="image" items="${images}">
                <div class="card">
                    <div class="card-image">
                        <img src="${image.getUrl()}" width="400px"> <br/> 
                    </div>
                    <span class="card-content black-text">
                        ${image.getCreate_time()}
                    </span>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</t:wrapper>