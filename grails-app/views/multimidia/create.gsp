<%@ page import="com.whitchsappweb.Multimidia" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Upload New Multimidia File</title>
</head>
<body>
<div class="nav" role="navigation">
    <ul><li><g:link class="list" action="list">Multimidia List</g:link></li></ul>
</div>
<div class="content scaffold-create" role="main">
    <h1>Upload New Multimidia File</h1>
    <g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
    <g:uploadForm action="upload">
        <fieldset class="form">
            <input type="file" name="file" />
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="upload" class="save" value="Upload" />
        </fieldset>
    </g:uploadForm>
</div>
</body>
</html>