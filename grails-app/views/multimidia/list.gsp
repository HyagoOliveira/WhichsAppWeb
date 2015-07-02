<%--
  Created by IntelliJ IDEA.
  User: Hyago
  Date: 01/07/2015
  Time: 20:45
--%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Multimidia List</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul><li><g:link class="create" action="create">Upload New Multimidia File</g:link></li></ul>
</div>
<div class="content scaffold-list" role="main">
    <h1>Multimidia List</h1>
    <g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="filename" title="Filename" />
            <g:sortableColumn property="uploadDate" title="Upload Date" />
        </tr>
        </thead>
        <tbody>
        <g:each in="${multimidiaInstanceList}" status="i" var="multimidiaInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="download" id="${multimidiaInstance.id}">${multimidiaInstance.filename}</g:link></td>
                <td><g:formatDate date="${multimidiaInstance.uploadDate}" /></td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${multimidiaInstanceTotal}" />
    </div>
</div>
</body>
</html>