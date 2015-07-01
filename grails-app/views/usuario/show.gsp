
<%@ page import="com.whitchsappweb.Usuario" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'usuario.label', default: 'Usuario')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-usuario" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-usuario" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list usuario">
			
				<g:if test="${usuarioInstance?.apelido}">
				<li class="fieldcontain">
					<span id="apelido-label" class="property-label"><g:message code="usuario.apelido.label" default="Apelido" /></span>
					
						<span class="property-value" aria-labelledby="apelido-label"><g:fieldValue bean="${usuarioInstance}" field="apelido"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.profilePicture}">
				<li class="fieldcontain">
					<span id="profilePicture-label" class="property-label"><g:message code="usuario.profilePicture.label" default="Profile Picture" /></span>
					<img src="${createLink( action:'image', id: params.id)}"/>
				</li>
				</g:if>
			
				<g:if test="${usuarioInstance?.contatos}">
				<li class="fieldcontain">
					<span id="contatos-label" class="property-label"><g:message code="usuario.contatos.label" default="Contatos" /></span>
					
						<g:each in="${usuarioInstance.contatos}" var="c">
						<span class="property-value" aria-labelledby="contatos-label"><g:link controller="usuario" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${usuarioInstance?.id}" />
					<g:link class="edit" action="edit" id="${usuarioInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
